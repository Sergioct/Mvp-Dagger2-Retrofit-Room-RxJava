package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.splash;

import android.app.Activity;
import android.content.Intent;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.register.RegisterActivity;


/**
 * Created by Sergio Crespo Toubes on 24/11/2017.
 * SergioCrespoToubes@gmail.com
 * www.SergioCrespoToubes.com
 */
public class SplashModel implements SplashContract.Model {

    Activity activity;

    /*public SplashModel(Activity activity) {
        this.activity = activity;
    }*/

    @Override
    public void loadRegister() {
        Intent intent = new Intent(activity, RegisterActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

}
