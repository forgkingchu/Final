package com.example.tku_food_map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final Context mContext;
    private final ArrayList<Post> mData;

    public MyAdapter(Context context, ArrayList<Post> data) {
        this.mContext = context;
        this.mData = data;
    }

    public static class Post {
        public String Name;
        public String Address;
        public String Time;
        public String Type;

        public Post(String Name, String Address, String Time, String Type) {
            this.Name = Name;
            this.Address = Address;
            this.Time = Time;
            this.Type = Type;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.Name = (TextView) view.findViewById(R.id.locName);
        holder.Address = (TextView) view.findViewById(R.id.locAddress);
        holder.Time = (TextView) view.findViewById(R.id.locTime);
        holder.Type = (TextView) view.findViewById(R.id.locType);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post post = mData.get(position);
        holder.Name.setText(post.Name);
        holder.Address.setText(post.Address);
        holder.Time.setText(post.Time);
        holder.Type.setText(post.Type);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Name;
        public TextView Address;
        public TextView Time;
        public TextView Type;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}