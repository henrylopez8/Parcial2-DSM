package sv.edu.udb.carsmotors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText User, Password;
    Button btniniciarsesion;
    Db DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        User = (EditText) findViewById(R.id.txtuser);
        Password = (EditText) findViewById(R.id.txtcontra);
        btniniciarsesion = (Button) findViewById(R.id.btiniciosesion);
        DB = new Db(this);
        btniniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = User.getText().toString();
                String pass = Password.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(Login.this, "Por favor complete los campos", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.RevisarUsuariosyContra(user, pass);
                    if (checkuserpass == true ) {
                        Toast.makeText(Login.this, "Incio de sesión correctamente", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Administrador.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Login.this, "Credenciales invalidas", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}


