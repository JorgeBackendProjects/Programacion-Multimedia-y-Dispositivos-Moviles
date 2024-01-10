package com.example.examentema2.Adaptador;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.examentema2.R;

public class ListaEntradasAdapter extends RecyclerView.Adapter<ListaEntradasAdapter.EntradaViewHolder> {

        @NonNull
        @Override
        public EntradaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista, null, false);
            return new EntradaViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull EntradaViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return
        }

        public class EntradaViewHolder extends RecyclerView.ViewHolder {

            TextView seccion, butaca, precio;

            public EntradaViewHolder(@NonNull View itemView) {
                super(itemView);

                //seccion.lista.findViewById(
            }
        }

}
