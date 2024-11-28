package com.example.financemanager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financemanager.mvc.Operation;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Operation> operations = new ArrayList<>();

        operations.add(new Operation(1234L, "Credit card"));
        operations.add(new Operation(12L, "Bank account"));
        operations.add(new Operation(3334L, "Credit card"));
        operations.add(new Operation(1933L, "Bank account"));
        operations.add(new Operation(118L, "Credit card"));
        operations.add(new Operation(4L, "Bank account"));
        operations.add(new Operation(12L, "Credit card"));
        operations.add(new Operation(9L, "Bank account"));
        operations.add(new Operation(15L, "Credit card"));
        operations.add(new Operation(73L, "Bank account"));

        OperationAdapter adapter = new OperationAdapter(operations);

        RecyclerView rv = super.findViewById(R.id.rv);

        rv.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rv.setLayoutManager(linearLayoutManager);

        findViewById(R.id.btnFab).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            startActivityForResult(intent, RESULT_OK);
        });

        adapter.setOnItemClickListener(new OperationAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Operation operation) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("operation", operation);
                startActivityForResult(intent, RESULT_OK);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            Operation operation = (Operation) data.getSerializableExtra("operation");
            Log.d("operation in main", operation.toString());
        }
    }
}