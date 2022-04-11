package sv.edu.udb.carsmotors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtnombres,txtapellidos,txtemail,txtuser,txtpass,txtrepass;
    Spinner txttipo;
    Button btnregistar,btnusuario;
    Db DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombres =(EditText) findViewById(R.id.txtnombres);
        txtapellidos=(EditText) findViewById(R.id.txtapellidos);
        txtemail=(EditText) findViewById(R.id.txtemail);
        txtuser=(EditText) findViewById(R.id.txtusuario);
        txtpass=(EditText) findViewById(R.id.txtpass);
        txtrepass=(EditText) findViewById(R.id.txtrepass);
        txttipo=(Spinner) findViewById(R.id.txttipo);
        btnregistar=(Button) findViewById(R.id.btnregistrar);
        btnusuario=(Button) findViewById(R.id.btnusuario);
        DB = new Db(this);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.combo_usuarios, android.R.layout.simple_spinner_item);
        txttipo.setAdapter(adapter);
        btnregistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nombres = txtnombres.getText().toString();
                String Apellidos = txtapellidos.getText().toString();
                String Email = txtemail.getText().toString();
                String User = txtuser.getText().toString();
                String Pass = txtpass.getText().toString();
                String Repass = txtrepass.getText().toString();
                String Tipo =(String) txttipo.getSelectedItem();
                txttipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                         String dato=adapterView.getItemAtPosition(i).toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                //String Tipo =txttipo.getText().toString();





                if(Nombres.equals("")||Apellidos.equals("")||Email.equals("") || User.equals("") || Pass.equals("") || Repass.equals("") || Tipo.equals(""))
                    Toast.makeText(MainActivity.this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
                else{
                    if(Pass.equals(Repass)){
                        Boolean RevisarUser = DB.RevisarUsuario(User);
                        if(RevisarUser==false){
                            Boolean insert = DB.insertData(Nombres, Apellidos,Email,User,Pass, Tipo);
                            if(insert==true && Tipo.equals("Admin")){
                                Toast.makeText(MainActivity.this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Administrador.class);
                                startActivity(intent);
                            }if(insert==true && Tipo.equals("Client")){
                                Toast.makeText(MainActivity.this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Cliente.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(MainActivity.this, "El registro fallo", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "El usuario ya existe, por favor inicie sesión", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }
                } }
        });
        btnusuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });

    }
}