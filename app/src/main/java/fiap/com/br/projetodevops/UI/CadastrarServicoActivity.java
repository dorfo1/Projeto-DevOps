package fiap.com.br.projetodevops.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fiap.com.br.projetodevops.R;

public class CadastrarServicoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_servico);
        getSupportActionBar().setTitle("Novo Serviço");
    }
}
