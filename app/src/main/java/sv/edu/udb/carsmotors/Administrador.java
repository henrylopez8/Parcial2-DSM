package sv.edu.udb.carsmotors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import sv.edu.udb.carsmotors.adaptadores.listaAutomovilesAdapter;
import sv.edu.udb.carsmotors.Db;

public class Administrador extends AppCompatActivity {
    Button btncolores,btnmarcas,btntipo,btnautomovil,btnusuarios;
    RecyclerView listacoches;
    ArrayList<Automovil_Class> listaArrayCoches;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);

        listacoches = findViewById(R.id.listaAutomoviles);
        listacoches.setLayoutManager(new LinearLayoutManager(this));
        listaArrayCoches = new ArrayList<>();

        listaAutomovilesAdapter adapter = new listaAutomovilesAdapter(Db.mostrarAutomoviles());
        listacoches.setAdapter(adapter);

        btncolores= (Button) findViewById(R.id.btncolores);
        btncolores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Colores.class);
                startActivity(intent);
            }
        });

        btnmarcas=(Button) findViewById(R.id.btnmarcas);
        btnmarcas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Marcas.class);
                startActivity(intent);
            }
        });
        btntipo=(Button) findViewById(R.id.btntipoauto);
        btntipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),TipoAutomovil.class);
                startActivity(intent);
            }
        });
        btnautomovil=(Button) findViewById(R.id.btnauto);
        btnautomovil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Automovil.class);
                startActivity(intent);
            }
        });
        btnusuarios=(Button) findViewById(R.id.btnusuarios);
        btnusuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Usuarios.class);
                startActivity(intent);
            }
        });

    }
}