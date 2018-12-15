package fiap.com.br.projetodevops.UI;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import fiap.com.br.projetodevops.R;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CadastrarServicoActivity extends AppCompatActivity {

    private EditText campo_nome,campo_valor,campo_categoria;
    private Button btn_cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_servico);
        getSupportActionBar().setTitle("Novo Serviço");


        campo_nome = findViewById(R.id.campo_nome);
        campo_valor = findViewById(R.id.campo_valor);
        campo_categoria = findViewById(R.id.campo_categoria);

        btn_cadastrar = findViewById(R.id.btn_cadastrar);

        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject json = new JSONObject();
                try {
                    json.put("nome",campo_nome.getText().toString());
                    json.put("categoria",campo_categoria.getText().toString());
                    json.put("valor",campo_valor.getText().toString());
                    CadastrarServico task = new CadastrarServico(json);
                    task.execute();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private class CadastrarServico extends AsyncTask{

        private boolean sucesso;
        private JSONObject json;
        public CadastrarServico(JSONObject json) {
            this.json=json;
        }

        @Override
        protected Object doInBackground(Object[] objects) {

            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType,json.toString());
            Request request = new Request.Builder()
                    .url("https://devopstrabalho.mybluemix.net/api/service")
                            .post(body)
                            .addHeader("type", "application/json")
                            .addHeader("Content-Type", "application/json")
                            .addHeader("cache-control", "no-cache")
                            .build();

            try {
                Response response = client.newCall(request).execute();
                String resposta = response.body().string();
                Log.d("JAYOB",resposta);
                sucesso = response.isSuccessful();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            if(sucesso){
                Toast.makeText(CadastrarServicoActivity.this,"Serviço cadastrado com sucesso",Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(CadastrarServicoActivity.this,"Falaha ao cadastrado serviço",Toast.LENGTH_SHORT).show();
            }
        }
    }

}
