package com.an2t.beforetestonlyjava.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.an2t.beforetestonlyjava.R;

import com.an2t.beforetestonlyjava.callback.OnItemClick;
import com.an2t.beforetestonlyjava.view_pager.models.Show;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MainViewHolder> {


    private Context mContext;
    private ArrayList<Show> mList;
    private OnItemClick onItemClick;

    public MovieAdapter(Context context, List<Show> mList, OnItemClick onItemClick) {
        this.mContext = context;
        this.mList = (ArrayList<Show>) mList;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.movie_item_horizontal,parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, final int position) {
        Show i = mList.get(position);
        holder.tv_mov_name.setText(i.getTitle());



        Picasso.get()
                .load(i.getMovieCardImg())
                .placeholder(R.drawable.ic_local_movies_black_24dp)
                .error(R.drawable.ic_local_movies_black_24dp)
                .into(holder.img_movie);




//        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onItemClick.onItemClick(position);
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_mov_name;
        private ImageView img_movie;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_mov_name = itemView.findViewById(R.id.tv_mov_name);
            img_movie = itemView.findViewById(R.id.img_movie);

        }
    }
}
