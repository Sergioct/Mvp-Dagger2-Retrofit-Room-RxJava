package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.modules;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.scopes.FragmentScoped;

import dagger.Module;
import dagger.Provides;

@Module
@FragmentScoped
public class FragmentModule {

    private final Fragment mFragment;

    public FragmentModule(@NonNull final Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @FragmentScoped
    Fragment provideFragment() {
        return mFragment;
    }

}