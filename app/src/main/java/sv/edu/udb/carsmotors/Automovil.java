package sv.edu.udb.carsmotors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Automovil extends AppCompatActivity {
    EditText modelo,numerovin,numerochasis,numeromotor,numeroasientos,anio,capacidadasientos,precio,uriimg,descripcion;
    Button agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automovil);

    modelo=(EditText) findViewById(R.id.txtmodelo);
    numerovin=(EditText) findViewById(R.id.txtnumerovin);
    numerochasis=(EditText) findViewById(R.id.txtnumemrochasis);
    numeromotor=(EditText) findViewById(R.id.txtnumeromotor);
    numeroasientos=(EditText) findViewById(R.id.txtnumeroAsientos);
    anio=(EditText) findViewById(R.id.txtanio);
    capacidadasientos=(EditText) findViewById(R.id.txtcapacidadasientos);
    precio=(EditText) findViewById(R.id.txtprecio);
    uriimg=(EditText) findViewById(R.id.txturlauto);
    descripcion=(EditText) findViewById(R.id.txtdescripcionauto);
    agregar=(Button) findViewById(R.id.btnagregarauto);

    agregar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(!modelo.getText().toString().equals("") ) {


                Db dbAuto = new Db(Automovil.this);

                long id = dbAuto.Insertarautomovil(modelo.getText().toString(),numerovin.getText().toString(),numerochasis.getText().toString(),numeromotor.getText().toString(),Integer.parseInt(numeroasientos.getText().toString()),anio.getText().toString(),
                       Integer.parseInt( capacidadasientos.getText().toString()),Float.parseFloat(precio.getText().toString()),uriimg.getText().toString(),descripcion.getText().toString());

                if (id > 0) {
                    Toast.makeText(Automovil.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(Automovil.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();

                }
            }else{
                Toast.makeText(Automovil.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
            }
        }
    });




    }
    private void limpiar() {
        modelo.setText("");
        numerovin.setText("");
        numerochasis.setText("");
        numeromotor.setText("");
        numeroasientos.setText("");
        anio.setText("");
        capacidadasientos.setText("");
        precio.setText("");
        uriimg.setText("");
        descripcion.setText("");


    }
}