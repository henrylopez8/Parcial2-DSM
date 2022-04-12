package sv.edu.udb.carsmotors.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sv.edu.udb.carsmotors.Color_Class;
import sv.edu.udb.carsmotors.Marca_Class;
import sv.edu.udb.carsmotors.R;

public class listaColoresAdapter extends RecyclerView.Adapter<listaColoresAdapter.colorViewHolder>{

    ArrayList<Color_Class> listaColores;
    public listaColoresAdapter(ArrayList<Color_Class> listaColores)
    {
        this.listaColores = listaColores;
    }
    @NonNull
    @Override

    public colorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lista_item_colores,null,false);
        return new listaColoresAdapter.colorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull colorViewHolder holder, int position) {
        holder.viewDescripcion.setText(listaColores.get(position).getDescripcion());
        holder.viewId.setText(listaColores.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return listaColores.size();
    }

    public class colorViewHolder extends RecyclerView.ViewHolder {
        TextView viewDescripcion,viewId;
        public colorViewHolder(@NonNull View itemView) {
            super(itemView);
            viewDescripcion = itemView.findViewById(R.id.viewDescripcion);
            viewId = itemView.findViewById((R.id.viewId));
        }
    }
}
