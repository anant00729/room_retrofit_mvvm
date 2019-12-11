package com.an2t.beforetestonlyjava.view_pager;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.an2t.beforetestonlyjava.R;
import com.an2t.beforetestonlyjava.view_pager.models.Show;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPagerFragment extends Fragment {


    public ViewPagerFragment() {
        // Required empty public constructor
    }


    private TextView tv_display;
    private ImageView img_movie_vp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
        tv_display = view.findViewById(R.id.tv_display);
        img_movie_vp = view.findViewById(R.id.img_movie_vp);
        if (getArguments().getParcelable("pos") != null) {
            Show s = getArguments().getParcelable("pos");
            tv_display.setText("" + s.getTitle());


            Picasso.get()
                    .load(s.getMovieCardImg())
                    .placeholder(R.drawable.ic_local_movies_black_24dp)
                    .error(R.drawable.ic_local_movies_black_24dp)
                    .into(img_movie_vp);
        }


        return view;
    }



}
