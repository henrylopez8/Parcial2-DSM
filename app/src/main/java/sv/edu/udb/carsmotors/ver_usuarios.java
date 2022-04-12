package sv.edu.udb.carsmotors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import sv.edu.udb.carsmotors.adaptadores.listaColoresAdapter;
import sv.edu.udb.carsmotors.adaptadores.listaUsuariosAdapter;

public class ver_usuarios extends AppCompatActivity {

    RecyclerView listausuarios;
    ArrayList<Marca_Class> listaArrayUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_usuarios);
        listausuarios = findViewById(R.id.listaUsuarios);
        listausuarios.setLayoutManager(new LinearLayoutManager(this));
        listaArrayUsuario = new ArrayList<>();
        Db p = new Db(ver_usuarios.this);
        listaUsuariosAdapter adapter = new listaUsuariosAdapter(p.mostrarUsuarios());
        listausuarios.setAdapter(adapter);
    }
}