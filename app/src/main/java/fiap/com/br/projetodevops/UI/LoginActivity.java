package fiap.com.br.projetodevops.UI;

import android.content.Intent;
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

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "TESTE" ;
    private EditText campo_login,campo_senha;
    private Button btn_cadastrar,btn_login;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");
        mAuth = FirebaseAuth.getInstance();

        campo_login = findViewById(R.id.campo_login);
        campo_senha = findViewById(R.id.campo_senha);
        
        progressBar = findViewById(R.id.progressBar);

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
                        progressBar.setVisibility(View.VISIBLE);
                        btn_login.setVisibility(View.INVISIBLE);
                        btn_cadastrar.setVisibility(View.INVISIBLE);
                        String login = campo_login.getText().toString();
                        String senha = campo_senha.getText().toString();
                        autenticarFB(login,senha);
                    }
                });
            }
        });
    }

    private void autenticarFB(String login, String senha) {
        mAuth.signInWithEmailAndPassword(login, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(LoginActivity.this,ListaActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Falha ao realizar login.",
                                    Toast.LENGTH_SHORT).show();
                            atualizarUI();
                        }
                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizarUI();
    }

    private void atualizarUI() {
        btn_cadastrar.setVisibility(View.VISIBLE);
        btn_login.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
    }
}
