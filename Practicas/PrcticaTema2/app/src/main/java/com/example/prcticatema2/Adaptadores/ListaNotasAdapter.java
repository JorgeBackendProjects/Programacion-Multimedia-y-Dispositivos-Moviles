package com.example.prcticatema2.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prcticatema2.Entidades.Notas;
import com.example.prcticatema2.R;
import com.example.prcticatema2.VisualizarNotas;

import java.util.ArrayList;

/**
 * Esta clase contendrá en un ArrayList todas las notas que
 * se hayan creado y almacenado en la base de datos.
 */
public class ListaNotasAdapter extends RecyclerView.Adapter<ListaNotasAdapter.NotaViewHolder> {

    ArrayList<Notas> listaNotas;

    /**
     * Constructor por parámetros.
     * @param lista Recibe un ArrayList de notas.
     */
    public ListaNotasAdapter(ArrayList<Notas> lista){
        this.listaNotas = lista;
    }

    /**
     * Esta subclase hereda de RecyclerView.ViewHolder.
     */
    public class NotaViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewDescripcion, viewFecha, viewTelefono;

        /**
         * Este constructor por parámetros se usa para enlazar los TextView
         * con sus respectivos input, además de refrescar la actividad.
         *
         * @param itemView
         */
        public NotaViewHolder(@Nullable View itemView) {
            super(itemView);
            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewDescripcion = itemView.findViewById(R.id.viewDescripcion);
            viewFecha = itemView.findViewById(R.id.viewFecha);
            viewTelefono = itemView.findViewById(R.id.viewTelefono);

            itemView.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, VisualizarNotas.class);
                    intent.putExtra("ID", listaNotas.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }

    /**
     * Este método infla la vista de la lista con todos los resultados obtenidos.
     *
     * @param parent
     * @param viewType
     *
     * @return Devuelve un objeto de la clase NotaViewHolder.
     */
    @NonNull
    @Override
    public NotaViewHolder onCreateViewHolder(@Nullable ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_notas, null, false);
        return new NotaViewHolder(view);
    }

    /**
     * Este método asigna a cada input el texto obtenido de cada tabla de la base de datos.
     *
     * @param holder
     * @param position
     */
    public void onBindViewHolder(@Nullable NotaViewHolder holder, int position) {
        holder.viewNombre.setText(listaNotas.get(position).getNombre());
        holder.viewDescripcion.setText(listaNotas.get(position).getDescripcion());
        holder.viewFecha.setText(listaNotas.get(position).getFecha());
        holder.viewTelefono.setText(listaNotas.get(position).getTelefono());
    }

    /**
     * Método Getter
     * @return Devuelve el tamaño del ArrayList
     */
    public int getItemCount() {
        return listaNotas.size();
    }
}
