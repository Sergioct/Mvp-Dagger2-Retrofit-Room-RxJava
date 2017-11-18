package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.main;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.MyApplication;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.R;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.ApiControllerRetrofit;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.pojo.Top;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.pojo.Twitch;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import sergiocrespotoubes.com.sergioctsdk.testing.SergioctDebug;
import sergiocrespotoubes.com.sergioctsdk.ui.about.utils.MyApp;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    // Injects

    @Inject
    MainContract.Presenter presenter;

    @Inject
    Retrofit retrofit;

    @Inject
    Picasso picasso;

    @Inject
    ApiControllerRetrofit apiControllerRetrofit;

    // Views

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MainComponent mainComponent = MyApplication.appComponent.activityComponent().build();
        mainComponent.inject(this);

        presenter.setView(this);

        Call<Twitch> call = apiControllerRetrofit.getTopGames();
        call.enqueue(new Callback<Twitch>() {
            @Override
            public void onResponse(Call<Twitch> call, Response<Twitch> response) {
                List<Top> gameList = response.body().getTop();
                for (int i = 0; i < gameList.size(); i++) {
                    Log.i("TEST", gameList.get(i).getGame().getName());
                }
            }

            @Override
            public void onFailure(Call<Twitch> call, Throwable t) {

            }
        });

        apiControllerRetrofit.getTopGamesObservable().subscribe()
                .


    }

}
