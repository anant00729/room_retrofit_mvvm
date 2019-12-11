package com.an2t.beforetestonlyjava.networking;

import com.an2t.beforetestonlyjava.view_pager.models.ShowReq;
import com.an2t.beforetestonlyjava.view_pager.models.ShowRes;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServiceAPI {

    @POST("GetAllShow")
    Observable<ShowRes> getAllMovies(@Body ShowReq mReq);
}
