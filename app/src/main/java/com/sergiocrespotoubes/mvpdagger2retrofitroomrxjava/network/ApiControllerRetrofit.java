package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.pojo.Twitch;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Sergio on 20-May-17.
 */

public interface ApiControllerRetrofit {

    @GET("/games/top")
    Call<Twitch> getTopGames();

    @GET("/games/top")
    Observable<Twitch> getTopGamesObservable();

    //@Headers("Content-Type: application/json")
    //@POST("/posts")
    //String postData(@Body Map<String, Object> body);

}