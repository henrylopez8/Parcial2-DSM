package sv.edu.udb.carsmotors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TipoAutomovil extends AppCompatActivity {
    EditText txtTipoAuto;
    Button btnAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_automovil);
        txtTipoAuto=(EditText) findViewById(R.id.txtdescripcionTipoAutomovil);
        btnAgregar=(Button) findViewById(R.id.btnAgregarTipoAuto);


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!txtTipoAuto.getText().toString().equals("") ) {


                    Db dbTipo = new Db(TipoAutomovil.this);

                    long id = dbTipo.InsertarTipoAutomovil(txtTipoAuto.getText().toString());

                    if (id > 0) {
                        Toast.makeText(TipoAutomovil.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                        limpiar();
                    } else {
                        Toast.makeText(TipoAutomovil.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();

                    }
                }else{
                    Toast.makeText(TipoAutomovil.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void limpiar() {
        txtTipoAuto.setText("");

    }
}