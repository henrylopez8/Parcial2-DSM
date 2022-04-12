package sv.edu.udb.carsmotors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import sv.edu.udb.carsmotors.adaptadores.listaAutomovilesAdapter;

public class ver_automoviles extends AppCompatActivity {
    RecyclerView listacoches;
    ArrayList<Automovil_Class> listaArrayCoches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_automoviles);

        listacoches = findViewById(R.id.listaAutomoviles);
        listacoches.setLayoutManager(new LinearLayoutManager(this));
        listaArrayCoches = new ArrayList<>();
        Db p = new Db(ver_automoviles.this);
        listaAutomovilesAdapter adapter = new listaAutomovilesAdapter(p.mostrarAutomoviles());
        listacoches.setAdapter(adapter);
    }
}