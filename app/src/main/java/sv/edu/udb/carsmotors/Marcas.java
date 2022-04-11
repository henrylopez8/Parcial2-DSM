package sv.edu.udb.carsmotors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Marcas extends AppCompatActivity {
    EditText txtNombreMarca;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcas);

        txtNombreMarca= (EditText) findViewById(R.id.txtnombresMarcas);
        btnAgregar=(Button) findViewById(R.id.btnagregarMarcas);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!txtNombreMarca.getText().toString().equals("") ) {


                    Db DbMarcas = new Db(Marcas.this);

                    long id = DbMarcas.InsertarMarca(txtNombreMarca.getText().toString());

                    if (id > 0) {
                        Toast.makeText(Marcas.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                        limpiar();
                    } else {
                        Toast.makeText(Marcas.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();

                    }
                }else{
                    Toast.makeText(Marcas.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    private void limpiar() {
        txtNombreMarca.setText("");

    }
}