package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.register;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.scopes.ActivityScoped;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Sergio Crespo Toubes on 01/11/2017.
 * SergioCrespoToubes@gmail.com
 * www.SergioCrespoToubes.com
 */
@Module
public class RegisterModule {

    @Provides
    @ActivityScoped
    RegisterContract.Presenter provideMainPresenter(RegisterContract.Model model){
        return new RegisterPresenter(model);
    }

    @Provides
    @ActivityScoped
    RegisterContract.Model provideMainModel(){
        return new RegisterModel();
    }

}
