package com.example.financemanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.financemanager.mvc.Controlador;
import com.example.financemanager.mvc.Operation;
import com.example.financemanager.mvc.Vista;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Operation operation = (Operation) intent.getSerializableExtra("operation");

        Vista vista = new Vista(operation, this);
        Controlador controlador = new Controlador(operation, vista);
        vista.setControlador(controlador);
        vista.mostrarModelo();
    }
}