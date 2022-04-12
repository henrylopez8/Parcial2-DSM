package sv.edu.udb.carsmotors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import sv.edu.udb.carsmotors.adaptadores.listaColoresAdapter;
import sv.edu.udb.carsmotors.adaptadores.listaMarcasAdapter;

public class ver_colores extends AppCompatActivity {

    RecyclerView listacolores;
    ArrayList<Marca_Class> listaArrayColores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_colores);

        listacolores = findViewById(R.id.listaColores);
        listacolores.setLayoutManager(new LinearLayoutManager(this));
        listaArrayColores = new ArrayList<>();
        Db p = new Db(ver_colores.this);
        listaColoresAdapter adapter = new listaColoresAdapter(p.mostrarColores());
        listacolores.setAdapter(adapter);
    }
}