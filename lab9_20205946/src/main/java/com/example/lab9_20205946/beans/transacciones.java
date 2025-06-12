package com.example.lab9_20205946.beans;
import java.util.Date;
public class transacciones {
    private int idtransacciones;
    private Double monto;
    private String descripcion;
    private String titulo;
    private Date fecha;
    private int usuarios_idusuarios;
    private String tipo;

    public transacciones() {}

    public int getIdtransacciones() {
        return idtransacciones;
    }

    public void setIdtransacciones(int idtransacciones) {
        this.idtransacciones = idtransacciones;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getUsuarios_idusuarios() {
        return usuarios_idusuarios;
    }

    public void setUsuarios_idusuarios(int usuarios_idusuarios) {
        this.usuarios_idusuarios = usuarios_idusuarios;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public transacciones(int idtransacciones, Double monto, String descripcion, String titulo, Date fecha, String tipo, int usuarios_idusuarios) {
        this.idtransacciones = idtransacciones;
        this.monto = monto;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.fecha = fecha;
        this.tipo = tipo;
        this.usuarios_idusuarios = usuarios_idusuarios;
    }
}
