package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.modules;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.qualifier.ActivityContext;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.scopes.ActivityScoped;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Module providing Activity context per Activity.
 */
@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(@NonNull final Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityScoped
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityScoped
    //@Named("activity_context")
    Context provideActivityContext() {
        return mActivity;
    }
}