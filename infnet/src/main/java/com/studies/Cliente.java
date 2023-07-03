package com.studies;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Cliente {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nome, cliente.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    public String bloqueiaCompra(Assinatura assinatura, List<Pagamento> pagamentos) {
        Optional<Pagamento> clientePagamentoAssinatura = pagamentos
            .stream()
            .takeWhile(pagamento -> !pagamento.getProdutos().isEmpty())
            .filter(pagamento -> assinatura.isPagamentoAtrasado())
            .findFirst();

        return clientePagamentoAssinatura.isPresent()
            ? String.format(
                "%s está com restrição de compra devido a falta de pagamento de sua assinatura!%n",
                getNome()
            )
            : String.format(
                "Status para %s - Compra-Ok.%n",
                getNome()
            );
        //
    }
}