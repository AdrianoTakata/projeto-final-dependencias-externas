package br.com.ProjetoFinalDependenciasExternas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class OperacaoBancaria {

    private LocalDateTime dataHoraOperacao;
    private String operador;
    private String tipoOperacao;
    private String valor;
    private Conta conta;

    @Override
    public int hashCode() {
        return this.conta.getIdConta().charAt(0);
    }
}
