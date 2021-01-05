package com.example.galgeleg.Views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galgeleg.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

   ArrayList<String> data1;
   ArrayList<String> data2;
   Context context;

    public MyAdapter(HighScore ct, ArrayList<String> usernames, ArrayList<String> scores) {
        context = ct;
        data1 = usernames;
        data2 = scores;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView text1, text2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.userName);
            text2 = itemView.findViewById(R.id.score_ord);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.text1.setText(data1.get(position));
        holder.text2.setText(data2.get(position));
    }


    @Override
    public int getItemCount() {
        return data1.size();
    }
}
