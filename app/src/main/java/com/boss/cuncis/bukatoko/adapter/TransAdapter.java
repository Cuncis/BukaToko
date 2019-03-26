package com.boss.cuncis.bukatoko.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.boss.cuncis.bukatoko.R;
import com.boss.cuncis.bukatoko.data.model.transaction.TransUser;

import java.util.List;

public class TransAdapter extends RecyclerView.Adapter<TransAdapter.TransHolder> {

    private List<TransUser.Data> transUnpaid;
    private Context context;

    public TransAdapter(List<TransUser.Data> transUnpaid, Context context) {
        this.transUnpaid = transUnpaid;
        this.context = context;
    }

    @NonNull
    @Override
    public TransHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_trans, parent, false);
        return new TransHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransHolder holder, int i) {
        TransUser.Data data = transUnpaid.get(i);

        holder.tvTitle.setText(data.getTransaction_code());
        holder.tvStatus.setText(data.getStatus_transaction());
    }

    @Override
    public int getItemCount() {
        return transUnpaid.size();
    }

    class TransHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvStatus;
        Button btnAction;

        public TransHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvStatus = itemView.findViewById(R.id.tv_status);
            btnAction = itemView.findViewById(R.id.btn_action);
        }
    }

}
