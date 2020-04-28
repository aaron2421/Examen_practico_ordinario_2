package com.example.examen_practico_ordinario_2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArchivosAdapter extends RecyclerView.Adapter<ArchivosAdapter.MyViewHolder> {

    Context context;
    String dataArray[];

    public ArchivosAdapter(Context ctx, String array[]){
        context = ctx;
        dataArray = array;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.myrow, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtView1.setText(dataArray[position]);
    }

    @Override
    public int getItemCount() {
        System.out.println(dataArray.length);
        return dataArray.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtView1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtView1 = itemView.findViewById(R.id.txtViewRow);
        }
    }
}
