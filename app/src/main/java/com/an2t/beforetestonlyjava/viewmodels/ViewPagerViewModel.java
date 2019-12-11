package com.an2t.beforetestonlyjava.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.an2t.beforetestonlyjava.User;
import com.an2t.beforetestonlyjava.db.AppDatabase;
import com.an2t.beforetestonlyjava.networking.RetrofitSingleton;
import com.an2t.beforetestonlyjava.networking.ServiceAPI;
import com.an2t.beforetestonlyjava.view_pager.models.CatShow;
import com.an2t.beforetestonlyjava.view_pager.models.Show;
import com.an2t.beforetestonlyjava.view_pager.models.ShowReq;
import com.an2t.beforetestonlyjava.view_pager.models.ShowRes;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class ViewPagerViewModel extends ViewModel {


    private static final String TAG = ViewPagerViewModel.class.getSimpleName();

    private MutableLiveData<List<Show>> mShow = new MutableLiveData<>();


    public LiveData<List<Show>> getmShow() {
        return mShow;
    }

    public void init() {


        Retrofit mR = RetrofitSingleton.getInstance();

        ServiceAPI mS = mR.create(ServiceAPI.class);

        ShowReq mReq = new ShowReq();

        mReq.setBannerType("Home");
        mReq.setLanguageID(1);
        mReq.setCountryID("230");
        mReq.setLatitude(-1);
        mReq.setLongitude(-1);

        mS.getAllMovies(mReq)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleDeletionUser, this::handleErr);
    }

    private void handleErr(Throwable throwable) {
        Log.e(TAG, "handleErr: " + throwable.getMessage() );
    }

    private void handleDeletionUser(ShowRes showRes) {
        List<Show> movies =  new ArrayList<>();
        for (CatShow show : showRes.getShows()) {
            movies.addAll(show.getShow());
        }
        mShow.setValue(movies);
    }
}
