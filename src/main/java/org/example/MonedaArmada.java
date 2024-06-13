package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MonedaArmada {
    Date fecha;
    double montoIngresado;
    String monedaBase;
    String divisaABuscar;

    Double monedaFinal;



    public MonedaArmada() {
    }

    public MonedaArmada(Date fecha, double montoIngresado, String monedaBase, String divisaABuscar, Double monedaFinal) {
        this.fecha = fecha;
        this.montoIngresado = montoIngresado;
        this.monedaBase = monedaBase;
        this.divisaABuscar = divisaABuscar;
        this.monedaFinal = monedaFinal;
    }
    @Override
    public String toString() {
        return "Converision Hecha{" +
                " con Fecha=" + fecha +
                ", El monto Ingresado=" + montoIngresado +
                ", con la moneda base='" + monedaBase + '\'' +
                ", Divisa usada='" + divisaABuscar + '\'' +
                ", Moneda final=" + monedaFinal +
                '}';
    }
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }



    public double getMontoIngresado() {
        return montoIngresado;
    }

    public void setMontoIngresado(double montoIngresado) {
        this.montoIngresado = montoIngresado;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getDivisaABuscar() {
        return divisaABuscar;
    }

    public void setDivisaABuscar(String divisaABuscar) {
        this.divisaABuscar = divisaABuscar;
    }
    public Double getMonedaFinal() {
        return monedaFinal;
    }

    public void setMonedaFinal(Double monedaFinal) {
        this.monedaFinal = monedaFinal;
    }
}
