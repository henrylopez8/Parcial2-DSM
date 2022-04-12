package sv.edu.udb.carsmotors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import sv.edu.udb.carsmotors.adaptadores.listaAutomovilesAdapter;
import sv.edu.udb.carsmotors.adaptadores.listaMarcasAdapter;

public class ver_marcas extends AppCompatActivity {
    RecyclerView listamarcas;
    ArrayList<Marca_Class> listaArrayMarcas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_marcas);

        listamarcas = findViewById(R.id.listaMarcas);
        listamarcas.setLayoutManager(new LinearLayoutManager(this));
        listaArrayMarcas = new ArrayList<>();
        Db p = new Db(ver_marcas.this);
        listaMarcasAdapter adapter = new listaMarcasAdapter(p.mostrarMarcas());
        listamarcas.setAdapter(adapter);
    }
}