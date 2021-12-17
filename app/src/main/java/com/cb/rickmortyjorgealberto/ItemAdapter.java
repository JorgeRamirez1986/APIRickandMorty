package com.cb.rickmortyjorgealberto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ResultsViewHolder> {

    private Context context;
    private List<Result> nameList;
    private List<Result> listadatos;


    public ItemAdapter(Context context, List<Result> nameList) {
        super();
        this.context = context;
        this.nameList = nameList;
        this.listadatos = nameList;


    }

    @NonNull
    @Override
    public ResultsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_layout, viewGroup, false);
        return new ResultsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultsViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.title.setText("Nombrre: " + listadatos.get(position).getName());


        Glide
                .with(context)
                .load(listadatos.get(position).getImage())
                .centerCrop()
                .placeholder(R.drawable.rickandmorty)
                .into(holder.character_image);



       /* holder.card_view_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             //modal


            }
        });*/
    }

    @Override
    public int getItemCount() {
        return listadatos.size();
    }


    class ResultsViewHolder extends RecyclerView.ViewHolder {


        private TextView title;
        private ImageView character_image;

        ResultsViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            character_image = itemView.findViewById(R.id.character_image);


        }
    }


}