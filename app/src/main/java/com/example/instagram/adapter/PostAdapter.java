package com.example.instagram.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram.databinding.RecyclerRowBinding;
import com.example.instagram.model.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
    private ArrayList<Post> postArrayList;
    public PostAdapter(ArrayList<Post> postArrayList){
        this.postArrayList = postArrayList;
    }
    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PostHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.recyclerRowBinding.recycleViewTxtEmail.setText(postArrayList.get(position).email);
        holder.recyclerRowBinding.recycleViewTxtComment.setText(postArrayList.get(position).comment);

        Picasso.get().load(postArrayList.get(position).downloadUrl).into(holder.recyclerRowBinding.recycleViewImageView);

    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

    class PostHolder extends RecyclerView.ViewHolder{
        RecyclerRowBinding recyclerRowBinding;
        public PostHolder(RecyclerRowBinding recyclerRowBinding) {
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding = recyclerRowBinding;
        }
    }

}