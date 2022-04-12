package sv.edu.udb.carsmotors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import sv.edu.udb.carsmotors.adaptadores.listaColoresAdapter;
import sv.edu.udb.carsmotors.adaptadores.listaTipoAdapter;

public class ver_tipocoches extends AppCompatActivity {

    RecyclerView listatipos;
    ArrayList<TipoCoche_Class> listaArrayTipos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_tipocoches);
        listatipos = findViewById(R.id.listaCoches);
        listatipos.setLayoutManager(new LinearLayoutManager(this));
        listaArrayTipos = new ArrayList<>();
        Db p = new Db(ver_tipocoches.this);
        listaTipoAdapter adapter = new listaTipoAdapter(p.mostrarTipoCoches());
        listatipos.setAdapter(adapter);
    }
}