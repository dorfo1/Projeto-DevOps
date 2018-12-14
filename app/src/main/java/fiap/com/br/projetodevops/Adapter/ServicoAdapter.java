package fiap.com.br.projetodevops.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fiap.com.br.projetodevops.Model.Servico;
import fiap.com.br.projetodevops.R;

public class ServicoAdapter extends RecyclerView.Adapter<ServicoAdapter.ServicoHolder> {

    private List<Servico> servicos;
    private Context context;

    public ServicoAdapter(List<Servico> servicos, Context context) {
        this.servicos = servicos;
        this.context = context;
    }

    @NonNull
    @Override
    public ServicoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.servico_item_row,viewGroup,false);

        return new ServicoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicoHolder servicoHolder, int position) {

    }


    @Override
    public int getItemCount() {
        return servicos.size();
    }



    public class ServicoHolder extends RecyclerView.ViewHolder {

        public ServicoHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
