package com.studies;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.OptionalDouble;

public class Pagamento {

    private List<Produto> produtos;
    private LocalDateTime dataCompra;
    private Cliente cliente;

    public Pagamento(List<Produto> produtos, LocalDateTime dataCompra, Cliente cliente) {
        this.produtos = produtos;
        this.dataCompra = dataCompra;
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal somaPrecosProdutosPagtoUsandoBigDecimal() {
        return produtos.stream().map(Produto::getPreco).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public OptionalDouble somaPrecosProdutosPagtoUsandoOptional() {
        return produtos.stream().mapToDouble(p -> p.getPreco().doubleValue()).reduce(Double::sum);
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "produtos=" + produtos +
                ", dataCompra=" + dataCompra +
                ", cliente=" + cliente +
                '}';
    }
}
