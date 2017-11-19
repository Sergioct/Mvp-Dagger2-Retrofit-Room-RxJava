package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.MyApplication;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.R;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.ApiControllerRetrofit;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.pojo.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import sergiocrespotoubes.com.sergioctsdk.ui.about.AppsAdapter;
import sergiocrespotoubes.com.sergioctsdk.ui.recyclerview.SergioctRecyclerViewActivity;

public class MainActivity extends SergioctRecyclerViewActivity implements MainContract.View {

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

    // Vars
    List <Post> lPost = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MainComponent mainComponent = MyApplication.appComponent.activityComponent().build();
        mainComponent.inject(this);

        presenter.setView(this);

        MainAdapter mainAdapter = new MainAdapter(this, lPost);
        setAdapter(mainAdapter);

        apiControllerRetrofit.getPostsObservable()
                .subscribeOn(Schedulers.io()) // Thread operator use
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Post>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Post post) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


    }

}
