package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.modules;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.MyRoomDatabase;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.entity.UserDao;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.repository.UserDataSource;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.repository.UserRepository;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.scopes.ApplicationScoped;

import dagger.Module;
import dagger.Provides;


@Module
public class DbModule {

    private MyRoomDatabase myRoomDatabase;

    public DbModule(Application mApplication) {
        myRoomDatabase = Room.databaseBuilder(mApplication, MyRoomDatabase.class, "pregnancydb").build();
    }

    @Provides
    @ApplicationScoped
    MyRoomDatabase provideMyRoomDatabase() {
        return myRoomDatabase;
    }

    @Provides
    @ApplicationScoped
    UserDao provideUserDao(MyRoomDatabase myRoomDatabase) {
        return myRoomDatabase.userDao();
    }

    @Provides
    @ApplicationScoped
    UserRepository provideNameRepository(UserDao nameDao) {
        return new UserDataSource(nameDao);
    }

}