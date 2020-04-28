package com.example.examen_practico_ordinario_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MyViewHolder> {
    private ArrayList<String> myDataSet;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView dato;
        public MyViewHolder(View itemView) {
            super(itemView);
            dato = itemView.findViewById(R.id.tvUser);
        }
    }

    public Adaptador(ArrayList<String> myDataset){
        this.myDataSet = myDataset;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.componente, null, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.dato.setText(myDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return myDataSet.size();
    }

}
