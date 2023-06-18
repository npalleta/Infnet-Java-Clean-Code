package br.com.studies.infnet;

import java.math.BigDecimal;

public class Assinatura {

    private BigDecimal mensalidade;
    private BigDecimal begin;
    private BigDecimal end;
    private Cliente cliente;

    public Assinatura(BigDecimal mensalidade, BigDecimal begin, BigDecimal end, Cliente cliente) {
        this.mensalidade = mensalidade;
        this.begin = begin;
        this.end = end;
        this.cliente = cliente;
    }

    public Assinatura(BigDecimal mensalidade, BigDecimal begin, Cliente cliente) {
        this.mensalidade = mensalidade;
        this.begin = begin;
        this.cliente = cliente;
    }

    public BigDecimal getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(BigDecimal mensalidade) {
        this.mensalidade = mensalidade;
    }

    public BigDecimal getBegin() {
        return begin;
    }

    public void setBegin(BigDecimal begin) {
        this.begin = begin;
    }

    public BigDecimal getEnd() {
        return end;
    }

    public void setEnd(BigDecimal end) {
        this.end = end;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Assinatura{" +
                "mensalidade=" + mensalidade +
                ", begin=" + begin +
                ", end=" + end +
                ", cliente=" + cliente +
                '}';
    }
}