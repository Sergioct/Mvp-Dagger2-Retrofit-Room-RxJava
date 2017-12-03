package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.splash;

import android.app.Activity;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.root.BaseContract;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Sergio Crespo Toubes on 24/11/2017.
 * SergioCrespoToubes@gmail.com
 * www.SergioCrespoToubes.com
 */
public class SplashPresenter implements SplashContract.Presenter {

    private final String TAG = "SplashPresenter";

    private SplashContract.View view;
    private SplashContract.Model model;

    // Const
    private final long SPLASH_SCREEN_DELAY = 3000;

    //

    public SplashPresenter(SplashContract.Model model) {
        this.model = model;
    }

    public void onSplashInit(final Activity activity) {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                onTimeFinished();
            }
        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

    public void onTimeFinished() {
        model.loadRegister();
    }

    @Override
    public void setView(BaseContract.View view) {
        this.view = (SplashContract.View) view;
    }

    @Override
    public void dropView() {

    }

}
