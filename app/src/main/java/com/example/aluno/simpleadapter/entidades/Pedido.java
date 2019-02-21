package com.example.aluno.simpleadapter.entidades;

import java.math.BigDecimal;

public class Pedido {

    protected Long id;
    protected String cliente;
    protected String data;
    protected BigDecimal valor;

    public Pedido(Long id, String cliente, String data, BigDecimal valor) {

        this.id = id;
        this.cliente = cliente;
        this.data = data;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
