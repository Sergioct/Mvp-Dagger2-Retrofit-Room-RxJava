package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.splash;

import android.app.Activity;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.scopes.ActivityScoped;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Sergio Crespo Toubes on 24/11/2017.
 * SergioCrespoToubes@gmail.com
 * www.SergioCrespoToubes.com
 */
@Module
public class SplashModule {

    @Provides
    @ActivityScoped
    SplashContract.Presenter provideMainPresenter(SplashContract.Model model){
        return new SplashPresenter(model);
    }

    @Provides
    @ActivityScoped
    SplashContract.Model provideMainModel(){
        return new SplashModel();
    }

}
