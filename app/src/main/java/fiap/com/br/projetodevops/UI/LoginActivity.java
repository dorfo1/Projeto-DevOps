package fiap.com.br.projetodevops.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fiap.com.br.projetodevops.R;

public class LoginActivity extends AppCompatActivity {

    private EditText campo_login,campo_senha;
    private Button btn_cadastrar,btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");

        campo_login = findViewById(R.id.campo_login);
        campo_senha = findViewById(R.id.campo_senha);



        btn_cadastrar = findViewById(R.id.btn_cadastrar);
        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,CadastrarActivity.class);
                startActivity(i);
            }
        });

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        String login = campo_login.getText().toString();
//                        String senha = campo_senha.getText().toString();

                        Intent i = new Intent(LoginActivity.this,ListaActivity.class);
                        startActivity(i);
                    }
                });
            }
        });
    }
}
