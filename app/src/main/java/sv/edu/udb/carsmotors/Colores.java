package sv.edu.udb.carsmotors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Colores extends AppCompatActivity {
    EditText txtdescripcioncolores;
    Button btnagregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colores);

        txtdescripcioncolores = (EditText) findViewById(R.id.txtdescripcioncolores);
        btnagregar = (Button) findViewById(R.id.btnagregarcolor);

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!txtdescripcioncolores.getText().toString().equals("") ) {


                    Db Dbcolores = new Db(Colores.this);

                    long id = Dbcolores.InsertarColor(txtdescripcioncolores.getText().toString());

                    if (id > 0) {
                    Toast.makeText(Colores.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(Colores.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();

                }
            }else{
                    Toast.makeText(Colores.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    private void limpiar() {
        txtdescripcioncolores.setText("");

    }
}