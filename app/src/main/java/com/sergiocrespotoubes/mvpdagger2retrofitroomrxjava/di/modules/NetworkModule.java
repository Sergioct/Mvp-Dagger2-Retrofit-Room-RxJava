package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.modules;

import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.qualifier.ApplicationContext;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.scopes.ApplicationScoped;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.ApiControllerRetrofit;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sergio Crespo Toubes on 03/11/2017.
 * SergioCrespoToubes@gmail.com
 * www.SergioCrespoToubes.com
 */
@Module(includes = AppModule.class)
public class NetworkModule {

    String url;

    public NetworkModule(String url) {
        this.url = url;
    }

    @Provides
    @ApplicationScoped
    public Cache provideHttpCache(File cacheFile) {
        int cacheSize = 10 * 1024 * 1024; // 10MB Cache
        Cache cache = new Cache(cacheFile, cacheSize);
        return cache;
    }

    @Provides
    @ApplicationScoped
    public File provideCacheFile(@ApplicationContext Context context){
        return new File(context.getCacheDir(), "okhttp_cache");
    }

    @Provides
    @ApplicationScoped
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        //gsonBuilder.registerTypeAdapter(DateTime.class, new DateTimeConverter());
        return gsonBuilder.create();
    }

    @Provides
    @ApplicationScoped
    OkHttpClient provideOkhttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        return client.build();
    }

    @Provides
    @ApplicationScoped
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @ApplicationScoped
    ApiControllerRetrofit provideApicontrollerRetrofit(Retrofit retrofit){
        return retrofit.create(ApiControllerRetrofit.class);
    }

}