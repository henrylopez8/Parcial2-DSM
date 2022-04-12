package sv.edu.udb.carsmotors.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sv.edu.udb.carsmotors.Automovil_Class;
import sv.edu.udb.carsmotors.R;

public class listaAutomovilesAdapter extends RecyclerView.Adapter<listaAutomovilesAdapter.automovilViewHolder> {
    ArrayList<Automovil_Class> listacoches;
    public listaAutomovilesAdapter(ArrayList<Automovil_Class> listacoches)
    {
        this.listacoches = listacoches;
    }
    @NonNull
    @Override
    public automovilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_automoviles,null,false);
        return new automovilViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull automovilViewHolder holder, int position) {
        holder.viewNombre.setText(listacoches.get(position).getModelo());
        holder.viewModelo.setText(listacoches.get(position).getAnio());
        holder.viewPrecio.setText("$"+listacoches.get(position).getPrecio().toString());
    }

    @Override
    public int getItemCount() {
        return listacoches.size();
    }

    public class automovilViewHolder extends RecyclerView.ViewHolder {
        TextView viewNombre,viewModelo,viewPrecio;
        public automovilViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewModelo = itemView.findViewById(R.id.viewModelo);
            viewPrecio = itemView.findViewById(R.id.viewPrecio);
        }
    }
}
