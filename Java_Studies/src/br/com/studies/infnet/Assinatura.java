package br.com.studies.infnet;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Assinatura {

    private BigDecimal mensalidade;
    private Periodo periodo;
    private Cliente cliente;

    public Assinatura(BigDecimal mensalidade, Periodo periodo, Cliente cliente) {
        this.mensalidade = mensalidade;
        this.periodo = periodo;
        this.cliente = cliente;
    }

    public BigDecimal getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(BigDecimal mensalidade) {
        this.mensalidade = mensalidade;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal somarAssinaturas(LocalDateTime ultimoDia, BigDecimal mensalidade) {

        long periodoContratado = ChronoUnit.MONTHS.between(periodo.getBegin(), periodo.getEnd().orElse(ultimoDia));
        long inicioContratoAteHoje = ChronoUnit.MONTHS.between(periodo.getBegin(), ultimoDia);
        BigDecimal temp = new BigDecimal(
                (inicioContratoAteHoje>=periodoContratado)?periodoContratado:inicioContratoAteHoje
        );
        BigDecimal mensalidadeTotal = mensalidade.multiply(temp);
        return mensalidadeTotal;
    }

    @Override
    public String toString() {
        return "Assinatura{" +
                "mensalidade=" + mensalidade +
                ", periodoBegin=" + periodo +
                ", periodoEnd=" + periodo +
                ", cliente=" + cliente +
                '}';
    }
}