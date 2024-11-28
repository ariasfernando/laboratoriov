package com.example.financemanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financemanager.mvc.Operation;

import java.util.List;

public class OperationAdapter extends RecyclerView.Adapter<OperationViewHolder> {

    List<Operation> operations;
    OnItemClickListener listener;

    public OperationAdapter(List<Operation> operations){
        this.operations = operations;
    }

    @NonNull
    @Override
    public OperationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.operation, parent, false);
        return new OperationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OperationViewHolder holder, int position) {
        Operation operation = this.operations.get(position);
        TextView monto = holder.itemView.findViewById(R.id.txtTitle);
        TextView tipo = holder.itemView.findViewById(R.id.txtSubtitle);

        monto.setText(String.valueOf(operation.getMonto()));
        tipo.setText(operation.getMetodoPago());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(operation);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.operations.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(Operation operation);
    }

}
