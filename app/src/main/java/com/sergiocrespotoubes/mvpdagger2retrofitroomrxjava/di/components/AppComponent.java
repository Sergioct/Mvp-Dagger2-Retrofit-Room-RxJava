package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.components;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.MyRoomDatabase;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.entity.UserDao;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.repository.UserRepository;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.modules.AppModule;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.modules.DbModule;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.modules.NetworkModule;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.modules.PicassoModule;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.scopes.ApplicationScoped;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.ApiControllerRetrofit;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.register.RegisterComponent;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * This is a Dagger component. Refer to {@link com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.MyApplication} for the list of Dagger components
 * used in this application.
 * <p>
 * Even though Dagger allows annotating a {@link Component} as a singleton, the code
 * itself must ensure only one instance of the class is created. This is done in {@link
 * com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.MyApplication}.
 * // is the module from Dagger.Android that helps with the generation
 * // and location of subcomponents.
 */
@ApplicationScoped
@Component(modules = {
        AppModule.class,
        DbModule.class,
        PicassoModule.class,
        NetworkModule.class})
public interface AppComponent {

    //void inject(PregnancyApplication pregnancyApplication);

    // Modules
    Picasso getPicasso();

    MyRoomDatabase getMyRoomDatabase();

    ApiControllerRetrofit getApiControllerRetrofit();

    // Components
    //MainComponent.Builder activityComponent();
    RegisterComponent.Builder registerComponent();
    //SplashComponent.Builder splashComponent();

    // Daos
    UserDao getUserDao();
    UserRepository getUserRepository();

}