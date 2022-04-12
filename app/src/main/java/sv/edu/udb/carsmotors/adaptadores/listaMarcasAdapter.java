package sv.edu.udb.carsmotors.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sv.edu.udb.carsmotors.Automovil_Class;
import sv.edu.udb.carsmotors.Marca_Class;
import sv.edu.udb.carsmotors.R;

public class listaMarcasAdapter  extends RecyclerView.Adapter<listaMarcasAdapter.marcaViewHolder>{

    ArrayList<Marca_Class> listamarcas;
    public listaMarcasAdapter(ArrayList<Marca_Class> listamarcas)
    {
        this.listamarcas = listamarcas;
    }
    @NonNull
    @Override
    public marcaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lista_item_marca,null,false);
        return new listaMarcasAdapter.marcaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull marcaViewHolder holder, int position) {
        holder.viewNombre.setText(listamarcas.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return listamarcas.size();
    }

    public class marcaViewHolder extends RecyclerView.ViewHolder {
        TextView viewNombre;
        public marcaViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNombre = itemView.findViewById(R.id.viewNombre);
        }
    }
}
