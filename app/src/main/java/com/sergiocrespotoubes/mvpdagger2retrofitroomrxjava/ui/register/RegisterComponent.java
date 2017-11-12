package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.register;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.modules.ActivityModule;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.scopes.ActivityScoped;

import dagger.Subcomponent;

@ActivityScoped
@Subcomponent(modules = {RegisterModule.class, ActivityModule.class})
public interface RegisterComponent {

    void inject(final RegisterActivity activity);

    @Subcomponent.Builder
    interface Builder {
        Builder registerModule(RegisterModule module);
        Builder activityModule(ActivityModule module);
        RegisterComponent build();
    }

    RegisterContract.Presenter getRegisterPresenter();
    RegisterContract.Model getRegisterModel();

}