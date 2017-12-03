package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.splash;

import android.os.Bundle;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.MyApplication;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.R;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.root.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Sergio Crespo Toubes on 24/11/2017.
 * SergioCrespoToubes@gmail.com
 * www.SergioCrespoToubes.com
 */
public class SplashActivity extends BaseActivity implements SplashContract.View {

    final String TAG = "MapsActivity";

    // Injects

    @Inject
    SplashContract.Presenter presenter;

    // Views

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        SplashComponent splashComponent = MyApplication.appComponent.splashComponent().build();
        splashComponent.inject(this);

        //presenter.setView(this, this);
        presenter.onSplashInit(this);
    }

}