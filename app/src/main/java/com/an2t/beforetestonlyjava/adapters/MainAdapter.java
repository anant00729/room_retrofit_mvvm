package com.an2t.beforetestonlyjava.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.an2t.beforetestonlyjava.R;
import com.an2t.beforetestonlyjava.User;
import com.an2t.beforetestonlyjava.callback.OnItemClick;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {


    private Context mContext;
    private ArrayList<User> mList;
    private OnItemClick onItemClick;

    public MainAdapter(Context context, ArrayList<User> mList, OnItemClick onItemClick) {
        this.mContext = context;
        this.mList = mList;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, final int position) {
        User i = mList.get(position);
        holder.tv_main.setText(i.getName());
        holder.tv_email.setText(i.getEmail());

        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onItemClick(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_main;
        private TextView tv_email;
        private Button btn_delete;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_main = itemView.findViewById(R.id.tv_main);
            tv_email = itemView.findViewById(R.id.tv_email);
            btn_delete = itemView.findViewById(R.id.btn_delete);
        }
    }
}
