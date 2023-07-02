package br.com.studies.infnet;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Assinatura {

    private BigDecimal mensalidade;
    private Periodo periodo;
    private Cliente cliente;
    private Plano plano;
    private boolean pagamentoAtrasado;

    public Assinatura(BigDecimal mensalidade, Periodo periodo, Plano plano, Cliente cliente,
            boolean pagamentoAtrasado) {
        this.mensalidade = mensalidade;
        this.periodo = periodo;
        this.cliente = cliente;
        this.plano = plano;
        this.pagamentoAtrasado = pagamentoAtrasado;
    }

    public Plano getPlano() {
        return plano;
    }

    public Double getTaxa() {
        Double taxa = getPlano()
            .equals(Plano.TRIMESTRAL) ? 0.05 : getPlano()
            .equals(Plano.SEMESTRAL) ? 0.03 : 0;
        return taxa;
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

    public boolean isPagamentoAtrasado() {
        return pagamentoAtrasado;
    }

    public void setPagamentoAtrasado(boolean pagamentoAtrasado) {
        this.pagamentoAtrasado = pagamentoAtrasado;
    }

    public BigDecimal somaAssinaturas(LocalDateTime ultimoDia) {
        long periodoContratado = ChronoUnit.MONTHS.between(periodo.getBegin(), periodo.getEnd().orElse(ultimoDia));
        long inicioContratoAteHoje = ChronoUnit.MONTHS.between(periodo.getBegin(), ultimoDia);

        BigDecimal totalAssinatura = BigDecimal.valueOf(0);
        BigDecimal anterior = BigDecimal.valueOf(0);

        for(int i = 1; i <= Math.min(inicioContratoAteHoje, periodoContratado); i++){
            BigDecimal montante = getMensalidade().multiply(BigDecimal.valueOf(Math.pow((1 + getTaxa()), i)));
            BigDecimal juros = montante.subtract(getMensalidade().subtract(anterior));
            anterior = anterior.add(juros);

            totalAssinatura = totalAssinatura.add(montante).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
        // return getMensalidade().multiply(BigDecimal.valueOf(Math.min(inicioContratoAteHoje, periodoContratado)));
        return totalAssinatura;
    }

    @Override
    public String toString() {
        return "Assinatura{" +
                "mensalidade=" + mensalidade +
                ", periodoBegin=" + periodo +
                ", periodoEnd=" + periodo +
                ", cliente=" + cliente +
                ", pagamentoAtrasado=" + pagamentoAtrasado +
                '}';
    }
}