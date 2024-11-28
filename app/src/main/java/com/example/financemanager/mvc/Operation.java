package com.example.financemanager.mvc;

import java.io.Serializable;
import java.util.Date;

public class Operation implements Serializable {
    private Long monto;
    private String metodoPago;

    public Operation() {
    }

    public Operation(Long monto, String metodoPago) {
        this.monto = monto;
        this.metodoPago = metodoPago;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "monto=" + monto + ", metodoPago=" + metodoPago;
    }
}
