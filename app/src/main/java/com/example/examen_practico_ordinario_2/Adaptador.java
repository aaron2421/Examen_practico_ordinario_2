package com.example.examen_practico_ordinario_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MyViewHolder> implements View.OnClickListener {
    private ArrayList<Usuario> myDataSet;
    private View.OnClickListener click;

    public void setOnClickListener(View.OnClickListener listener){
        this.click = listener;
    }

    @Override
    public void onClick(View v) {
        if (click!=null){
            click.onClick(v);

        }
    }

    public Adaptador(ArrayList<Usuario> myDataset){
        this.myDataSet = myDataset;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.componente, null, false);

        v.setOnClickListener(this);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nombre.setText(myDataSet.get(position).getNombre());
        holder.username.setText(myDataSet.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return myDataSet.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nombre, username;
        public MyViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombre);
            username = itemView.findViewById(R.id.tvUsername);
        }
    }

}
