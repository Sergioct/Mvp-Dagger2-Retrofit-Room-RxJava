package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.pojo.Post;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Sergio on 20-May-17.
 */

public interface ApiControllerRetrofit {

    @GET("/posts")
    Single<List<Post>> getPosts();

    @GET("/posts")
    Observable<Post> getPostsObservable();

    //@Headers("Content-Type: application/json")
    //@POST("/posts")
    //String postData(@Body Map<String, Object> body);

}