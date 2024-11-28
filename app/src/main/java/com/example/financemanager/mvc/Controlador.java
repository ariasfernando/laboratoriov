package com.example.financemanager.mvc;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

public class Controlador implements View.OnClickListener {
    private Operation operation;
    private Vista vista;

    public Controlador(Operation operation, Vista vista) {
        this.operation = operation;
        this.vista = vista;
    }

    @Override
    public void onClick(View view) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("operation", operation);
        vista.getActivity().setResult(Activity.RESULT_OK, resultIntent);
        vista.getActivity().finish();
    }
}
