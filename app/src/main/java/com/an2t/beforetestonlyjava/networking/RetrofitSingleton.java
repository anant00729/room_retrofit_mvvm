package com.an2t.beforetestonlyjava.networking;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Scheduler;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {


    private static Retrofit mSingleton;


    private static final String TAG = RetrofitSingleton.class.getSimpleName();
    private RetrofitSingleton() {
    }

    public static Retrofit getInstance(){

        if (mSingleton == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> {
                Log.e(TAG, message);
            });
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .readTimeout(20000, TimeUnit.MILLISECONDS)
                    .addInterceptor(interceptor)
                    .build();

            mSingleton = new Retrofit.Builder()
                    .baseUrl("https://api.ticketak.com/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build();
            return mSingleton;
        }else {
            return mSingleton;
        }
    }
}
