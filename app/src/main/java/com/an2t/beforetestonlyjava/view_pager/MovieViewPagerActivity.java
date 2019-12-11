package com.an2t.beforetestonlyjava.view_pager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.an2t.beforetestonlyjava.R;
import com.an2t.beforetestonlyjava.User;
import com.an2t.beforetestonlyjava.adapters.MainAdapter;
import com.an2t.beforetestonlyjava.adapters.MovieAdapter;
import com.an2t.beforetestonlyjava.callback.OnItemClick;
import com.an2t.beforetestonlyjava.view_and_update.ViewAllUsersActivity;
import com.an2t.beforetestonlyjava.view_pager.models.Show;
import com.an2t.beforetestonlyjava.viewmodels.ViewPagerViewModel;

import java.util.ArrayList;
import java.util.List;

public class MovieViewPagerActivity extends AppCompatActivity implements OnItemClick {


    private ViewPager view_pager;
    private RecyclerView rv_view;
    private ProgressBar progressBar;



    private ViewPagerViewModel mVM;



    private List<Show> mShows;
    private Boolean isVP = true;
    private MovieAdapter mMainAdater;


    InFiniteViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_for_words);

        mVM = ViewModelProviders.of(this).get(ViewPagerViewModel.class);
        mVM.init();

        view_pager = findViewById(R.id.view_pager);
        rv_view = findViewById(R.id.rv_view);
        progressBar = findViewById(R.id.progress);

        mShows = new ArrayList<>();
        initVP();
        initRV();
        observe();

    }

    private void initVP() {
        mAdapter = new InFiniteViewPagerAdapter(getSupportFragmentManager(), mShows);
        view_pager.setAdapter(mAdapter);
    }


    private void initRV() {
        rv_view.setHasFixedSize(true);
        rv_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mMainAdater = new MovieAdapter(this, mShows, this);
        rv_view.setAdapter(mMainAdater);
        rv_view.setVisibility(View.GONE);
    }

    private void observe() {
        mVM.getmShow().observe(this, shows -> {
            mShows.clear();
            mShows.addAll(shows);
            mAdapter.notifyDataSetChanged();
            mMainAdater.notifyDataSetChanged();
            view_pager.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        });

    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_o:

                 item.setIcon(getResources().getDrawable(
                         isVP ?
                         R.drawable.ic_format_list_bulleted_black_24dp :
                                 R.drawable.ic_apps_black_24dp
                         ));




                isVP = !isVP;
                rv_view.setVisibility(isVP ? View.GONE : View.VISIBLE);
                view_pager.setVisibility(!isVP ? View.GONE : View.VISIBLE);

                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void onItemClick(Integer i) {

    }
}
