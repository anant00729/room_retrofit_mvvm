package com.an2t.beforetestonlyjava.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.an2t.beforetestonlyjava.User;
import com.an2t.beforetestonlyjava.db.AppDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ViewAllUsersViewModel extends ViewModel {



    private MutableLiveData<List<User>> mUserLD = new MutableLiveData<>();
    private MutableLiveData<User> onDeleted = new MutableLiveData<>();
    public static AppDatabase mDb;

    public LiveData<User> getOnDeleted() {
        return onDeleted;
    }

    public LiveData<List<User>> getmUserLD() {
        return mUserLD;
    }



    public void initRoomObject(Context mContext){
        mDb = Room
                .databaseBuilder(mContext, AppDatabase.class, "user_db")
                .build();


        Observable.fromCallable(() -> mDb.userDao().getAllUsers())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResAllUser, this::handleErr);

//        Observable.just(mDb.userDao().getAllUsers())
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(this::handleResAllUser, this::handleErr);


    }



    private void handleResAllUser(List<User> users) {
        mUserLD.postValue(users);
    }

    private void handleErr(Throwable throwable) {
    }


    public void removeUser(User u) {

        Observable.fromCallable(() -> mDb.userDao().deleteUser(u))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Integer i) -> { this.handleDeletionUser(i,u);}, this::handleErr);
    }



    private void handleDeletionUser(Integer i, User u) {
        u.deletedId = i;
        onDeleted.postValue(u);
    }


}
