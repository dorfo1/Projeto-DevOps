package fiap.com.br.projetodevops.UI;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fiap.com.br.projetodevops.Adapter.ServicoAdapter;
import fiap.com.br.projetodevops.Model.Servico;
import fiap.com.br.projetodevops.R;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ListaActivity extends AppCompatActivity {

    private RecyclerView listaServicos;
    private FloatingActionButton novoServico;
    private ServicoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        getSupportActionBar().setTitle("Lista de Serviços");

        listaServicos = findViewById(R.id.rv_listaServicos);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        listaServicos.setLayoutManager(manager);
        novoServico = findViewById(R.id.fab_novoServico);

        novoServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListaActivity.this,CadastrarServicoActivity.class);
                startActivity(i);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        BuscarListaServiços task = new BuscarListaServiços();
        task.execute();
    }

    private class BuscarListaServiços extends AsyncTask {
        List<Servico> servicoList;

        @Override
        protected Object doInBackground(Object[] objects) {
            servicoList = new ArrayList<>();
            OkHttpClient client = new OkHttpClient();


            Request request = new Request.Builder()
                    .url(" https://devopstrabalho.mybluemix.net/api/services")
                    .addHeader("type", "application/json")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("cache-control", "no-cache")
                    .build();

            try {
                Response response = client.newCall(request).execute();
                String resposta = response.body().string();
                Log.d("JAYOB",resposta);
//                JSONObject jsonObject = new JSONObject(resposta);
                JSONArray array = new JSONArray(resposta);
                for(int i =0;i<array.length();i++){
                    JSONObject jsonService = array.getJSONObject(i);
                    Servico s = new Servico();
                    s.setNome(jsonService.getString("nome"));
                    s.setCategoria(jsonService.getString("categoria"));
                    s.setValor(jsonService.getDouble("valor"));
                    servicoList.add(s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            adapter = new ServicoAdapter(servicoList,ListaActivity.this);
            listaServicos.setAdapter(adapter);
        }
    }
}
