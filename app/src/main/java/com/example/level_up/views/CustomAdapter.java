package com.example.level_up.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.level_up.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    ArrayList<String> personNames;
    public CustomAdapter(Context context, ArrayList username){
        this.context = context;
        this.personNames = username;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {

        holder.username.setText(personNames.get(i));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.personNames.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView profilepic;
        TextView username;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            profilepic = (ImageView) itemView.findViewById(R.id.profileImage);
            username  = (TextView) itemView.findViewById(R.id.username);
        }
    }
}
