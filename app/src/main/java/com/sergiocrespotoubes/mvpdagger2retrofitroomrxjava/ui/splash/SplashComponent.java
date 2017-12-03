package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.splash;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.modules.ActivityModule;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.scopes.ActivityScoped;

import dagger.Subcomponent;
import rx.schedulers.Schedulers;

@ActivityScoped
@Subcomponent(modules = {SplashModule.class, ActivityModule.class})
public interface SplashComponent {

    void inject(final SplashActivity activity);

    @Subcomponent.Builder
    interface Builder {
        Builder splashModule(SplashModule module);
        Builder activityModule(ActivityModule module);
        SplashComponent build();
    }

    SplashContract.Presenter getSplashPresenter();
    SplashContract.Model getSplashModel();
    //Schedulers getSchedulers();
    //SplashActivity getSplashActivity();

}