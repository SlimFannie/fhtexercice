package com.example.fhtexercice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterProduit extends RecyclerView.Adapter {

    List<Produit> liste;

    public AdapterProduit(List<Produit> l) {
        this.liste = l;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.carte_produit,parent,false);
        return new MonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MonViewHolder monViewHolder = (MonViewHolder) holder;
        monViewHolder.tvTitre.setText(liste.get(position).getTitle());
        monViewHolder.tvCategorie.setText(liste.get(position).getCategory());
        monViewHolder.tvDescription.setText(liste.get(position).getDescription());
        monViewHolder.tvPrix.setText(liste.get(position).getPrice().toString());
        String url = liste.get(position).getImage();
        Picasso.get().load(url).into(monViewHolder.img);
    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    public class MonViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitre, tvDescription, tvPrix, tvCategorie;
        ImageView img;
        public MonViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitre = itemView.findViewById(R.id.tvTitre);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvCategorie = itemView.findViewById(R.id.tvCategorie);
            tvPrix = itemView.findViewById(R.id.tvPrix);
            img = itemView.findViewById(R.id.imageView);
        }
    }
}
