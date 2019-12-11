package com.an2t.beforetestonlyjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

public class CURDMain extends AppCompatActivity {


    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curdmain);

        container = findViewById(R.id.container);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new MainViewFragment())
                .commit();



    }




}
