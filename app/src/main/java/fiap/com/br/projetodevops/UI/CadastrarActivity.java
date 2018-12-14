package fiap.com.br.projetodevops.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fiap.com.br.projetodevops.R;

public class CadastrarActivity extends AppCompatActivity {

    private EditText campo_login,campo_senha,campo_confirmar_senha;
    private Button btn_cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        getSupportActionBar().setTitle("Cadastrar");

        campo_login = findViewById(R.id.campo_login_cadastro);
        campo_senha = findViewById(R.id.campo_senha_cadastro);
        campo_confirmar_senha = findViewById(R.id.campo_senha_novamente_cadastro);

        btn_cadastrar = findViewById(R.id.btn_cadastrar);

        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String login = campo_login.getText().toString();
//                String senha = campo_senha.getText().toString();
//                String confirmar_senha = campo_confirmar_senha.getText().toString();

                finish();
            }
        });


    }
}
