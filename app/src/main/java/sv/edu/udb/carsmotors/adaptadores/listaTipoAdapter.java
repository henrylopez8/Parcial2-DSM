package sv.edu.udb.carsmotors.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sv.edu.udb.carsmotors.Color_Class;
import sv.edu.udb.carsmotors.R;
import sv.edu.udb.carsmotors.TipoCoche_Class;

public class listaTipoAdapter extends RecyclerView.Adapter<listaTipoAdapter.tipoViewHolder>{
    ArrayList<TipoCoche_Class> listaTipos;
    public listaTipoAdapter(ArrayList<TipoCoche_Class> listaTipos)
    {
        this.listaTipos = listaTipos;
    }
    @NonNull
    @Override
    public tipoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lista_item_tipocoche,null,false);
        return new listaTipoAdapter.tipoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull tipoViewHolder holder, int position) {
        holder.viewDescripcion.setText(listaTipos.get(position).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return listaTipos.size();
    }

    public class tipoViewHolder extends RecyclerView.ViewHolder {
        TextView viewDescripcion,viewId;
        public tipoViewHolder(@NonNull View itemView) {
            super(itemView);
            viewDescripcion = itemView.findViewById(R.id.viewDescripcion);
            viewId = itemView.findViewById((R.id.viewId));
        }
    }
}
