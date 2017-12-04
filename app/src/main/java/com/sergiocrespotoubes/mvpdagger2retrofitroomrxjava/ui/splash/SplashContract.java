package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.splash;

import android.app.Activity;


import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.root.BaseContract;

import io.reactivex.Observable;

/**
 * Created by Sergio Crespo Toubes on 24/11/2017.
 * SergioCrespoToubes@gmail.com
 * www.SergioCrespoToubes.com
 */
public interface SplashContract {

    interface View extends BaseContract.View {

        void loadRegister();
    }

    interface Presenter extends BaseContract.Presenter {

        void onSplashInit(Activity activity);

        void onTimeFinished();

    }

    interface Model extends BaseContract.Model {

    }

}