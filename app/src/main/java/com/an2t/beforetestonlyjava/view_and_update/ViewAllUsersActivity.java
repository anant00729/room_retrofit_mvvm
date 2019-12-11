package com.an2t.beforetestonlyjava.view_and_update;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.an2t.beforetestonlyjava.db.AppDatabase;
import com.an2t.beforetestonlyjava.adapters.MainAdapter;
import com.an2t.beforetestonlyjava.R;
import com.an2t.beforetestonlyjava.User;
import com.an2t.beforetestonlyjava.callback.OnItemClick;
import com.an2t.beforetestonlyjava.viewmodels.ViewAllUsersViewModel;

import java.util.ArrayList;
import java.util.List;

public class ViewAllUsersActivity extends AppCompatActivity implements OnItemClick {



    private RecyclerView rv_main;

    ArrayList<User> mUsers;
    MainAdapter mMainAdater;


    ViewAllUsersViewModel mVM;


    private static final String TAG = ViewAllUsersActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);


        mVM = ViewModelProviders.of(this).get(ViewAllUsersViewModel.class);
        mVM.initRoomObject(getApplicationContext());
        rv_main = findViewById(R.id.rv_main);

        initRV();
        observe();

    }

    private void observe() {
        mVM.getmUserLD().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                mUsers.clear();
                mUsers.addAll(users);
                mMainAdater.notifyDataSetChanged();
            }
        });



        mVM.getOnDeleted().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                Toast.makeText(ViewAllUsersActivity.this, "User Deleted Id is " + user.deletedId, Toast.LENGTH_SHORT).show();
                mUsers.remove(user);
                mMainAdater.notifyDataSetChanged();
            }
        });
    }

    private void initRV() {
        mUsers = new ArrayList<>();
        rv_main.setHasFixedSize(true);
        rv_main.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mMainAdater = new MainAdapter(this, mUsers, this);
        rv_main.setAdapter(mMainAdater);
    }

    @Override
    public void onItemClick(final Integer i) {
        try {
            mVM.removeUser(mUsers.get(i));
        }
        catch (WindowManager.BadTokenException e) {
            Log.e(TAG, "onItemClick: "   + e );
        }
    }
}
