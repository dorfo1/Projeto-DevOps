package fiap.com.br.projetodevops.UI;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import fiap.com.br.projetodevops.R;

public class ListaActivity extends AppCompatActivity {

    private RecyclerView listaServicos;
    private FloatingActionButton novoServico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        getSupportActionBar().setTitle("Lista de Serviços");

        listaServicos = findViewById(R.id.rv_listaServicos);
        novoServico = findViewById(R.id.fab_novoServico);

        novoServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListaActivity.this,CadastrarServicoActivity.class);
                startActivity(i);
            }
        });
    }
}
