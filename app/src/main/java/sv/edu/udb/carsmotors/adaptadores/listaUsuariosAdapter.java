package sv.edu.udb.carsmotors.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sv.edu.udb.carsmotors.R;
import sv.edu.udb.carsmotors.TipoCoche_Class;
import sv.edu.udb.carsmotors.Usuario_Class;

public class listaUsuariosAdapter extends RecyclerView.Adapter<listaUsuariosAdapter.usuarioViewHolder>{
    ArrayList<Usuario_Class> listaUsuarios;
    public listaUsuariosAdapter(ArrayList<Usuario_Class> listaUsuarios)
    {
        this.listaUsuarios = listaUsuarios;
    }

    @NonNull
    @Override
    public usuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lista_item_usuario,null,false);
        return new listaUsuariosAdapter.usuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull usuarioViewHolder holder, int position) {
        holder.viewNombre.setText(listaUsuarios.get(position).getNombre());
        holder.viewApellido.setText(listaUsuarios.get(position).getApellido());
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public class usuarioViewHolder extends RecyclerView.ViewHolder {
        TextView viewNombre,viewId,viewApellido;
        public usuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewApellido = itemView.findViewById(R.id.viewApellido);
        }
    }
}
