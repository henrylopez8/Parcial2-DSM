package sv.edu.udb.carsmotors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Administrador extends AppCompatActivity {
    Button btncolores,btnmarcas,btntipo,btnautomovil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);

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

    }
}