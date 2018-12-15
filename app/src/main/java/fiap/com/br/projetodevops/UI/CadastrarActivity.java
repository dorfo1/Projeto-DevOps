package fiap.com.br.projetodevops.UI;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import fiap.com.br.projetodevops.R;

public class CadastrarActivity extends AppCompatActivity {

    private static final String TAG = "TESTE";
    private EditText campo_login,campo_senha,campo_confirmar_senha;
    private Button btn_cadastrar;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        getSupportActionBar().setTitle("Cadastrar");
        mAuth = FirebaseAuth.getInstance();

        progressBar = findViewById(R.id.progressBar);
        campo_login = findViewById(R.id.campo_login_cadastro);
        campo_senha = findViewById(R.id.campo_senha_cadastro);
        campo_confirmar_senha = findViewById(R.id.campo_senha_novamente_cadastro);

        btn_cadastrar = findViewById(R.id.btn_cadastrar);

        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cadastrar.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                String login = campo_login.getText().toString();
                String senha = campo_senha.getText().toString();
                String confirmar_senha = campo_confirmar_senha.getText().toString();
                if(senha !=null && confirmar_senha!=null){
                    if(senha.equals(confirmar_senha)){
                        cadastrarFB(login,senha);
                    }else{
                        Toast.makeText(CadastrarActivity.this,"Senhas são diferentes",Toast.LENGTH_SHORT).show();
                        atualizarUI();
                    }
                }
            }
        });


    }

    private void cadastrarFB(String login,String senha){
        mAuth.createUserWithEmailAndPassword(login, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(CadastrarActivity.this, "Cadastro realizado com sucesso.",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(CadastrarActivity.this, "Falha ao cadastrar." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                            atualizarUI();
                        }
                    }
                });
    }


    private void atualizarUI() {
        btn_cadastrar.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
    }
}
