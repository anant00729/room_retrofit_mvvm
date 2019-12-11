package com.an2t.beforetestonlyjava;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.an2t.beforetestonlyjava.add.AddUserActivity;
import com.an2t.beforetestonlyjava.view_and_update.ViewAllUsersActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainViewFragment extends Fragment {


    public MainViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_view, container, false);
    }



    private Button btn_add;
    private Button btn_view;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_add = view.findViewById(R.id.btn_add);
        btn_view = view.findViewById(R.id.btn_view);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AddUserActivity.class);
                getActivity().startActivity(i);
            }
        });


        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ViewAllUsersActivity.class);
                getActivity().startActivity(i);
            }
        });
    }
}
