package br.com.ProjetoFinalDependenciasExternas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperacaoBancaria that = (OperacaoBancaria) o;

        if (dataHoraOperacao != null ? !dataHoraOperacao.equals(that.dataHoraOperacao) : that.dataHoraOperacao != null)
            return false;
        if (operador != null ? !operador.equals(that.operador) : that.operador != null) return false;
        if (tipoOperacao != null ? !tipoOperacao.equals(that.tipoOperacao) : that.tipoOperacao != null) return false;
        if (valor != null ? !valor.equals(that.valor) : that.valor != null) return false;
        return conta != null ? conta.equals(that.conta) : that.conta == null;
    }

    @Override
    public int hashCode() {
        return this.conta.getIdConta().hashCode();
    }
}
