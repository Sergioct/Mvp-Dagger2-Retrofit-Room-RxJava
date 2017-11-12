package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.modules;

import android.content.Context;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.MyApplication;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.qualifier.ApplicationContext;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.scopes.ApplicationScoped;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private MyApplication myApplication;

    public AppModule(MyApplication pregnancyApplication) {
        this.myApplication = pregnancyApplication;
    }

    @Provides
    @ApplicationScoped
    public MyApplication provideMyApplication() {
    return myApplication;
  }

    @Provides
    @ApplicationScoped
    @ApplicationContext
    public Context provideApplicationContext() {
    return myApplication;
  }

}