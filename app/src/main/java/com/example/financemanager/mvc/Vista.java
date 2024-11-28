package com.example.financemanager.mvc;

import static android.provider.Settings.System.getString;

import android.app.Activity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.financemanager.R;

public class Vista {

    Operation operation;
    Activity activity;
    Controlador controlador;
    EditText editMonto;
    RadioGroup radioGroupPaymentMethod;

    public Activity getActivity() {
        return activity;
    }

    public Vista(Operation operation, Activity activity) {
        this.operation = operation;
        this.activity = activity;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        cargarElementos();
    }

    public void cargarElementos() {
        this.editMonto = activity.findViewById(R.id.editMonto);
        this.radioGroupPaymentMethod = activity.findViewById(R.id.paymentMethodGroup);
        Button btnAgregar = activity.findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(this.controlador);
    }

    public void cargarModelo() {
        this.operation.setMonto(Long.parseLong(this.editMonto.getText().toString()));
        int selectedId = radioGroupPaymentMethod.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = activity.findViewById(selectedId);
        this.operation.setMetodoPago(selectedRadioButton.getText().toString());
    }

    public void mostrarModelo() {
        if(this.operation != null) {
            Button btnAgregar = activity.findViewById(R.id.btnAgregar);
            btnAgregar.setText(R.string.label_button_modificar);
            this.editMonto.setText(String.valueOf(this.operation.getMonto()));
            if (this.activity.getString(R.string.label_tarjeta).equals(this.operation.getMetodoPago())) {
                RadioButton tarjetaRadioButton = activity.findViewById(R.id.creditCardOption);
                tarjetaRadioButton.setChecked(true);
            } else if (this.activity.getString(R.string.label_cuenta).equals(this.operation.getMetodoPago())) {
                RadioButton cuentaRadioButton = activity.findViewById(R.id.bankAccountOption);
                cuentaRadioButton.setChecked(true);
            }
        }
    }
}
