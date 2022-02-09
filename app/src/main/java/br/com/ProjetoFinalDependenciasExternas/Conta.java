package br.com.ProjetoFinalDependenciasExternas;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Conta {

    private String idConta;
    private String nomeBanco;
    private String numeroAgencia;
    private String numeroConta;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conta conta = (Conta) o;

        if (idConta != null ? !idConta.equals(conta.idConta) : conta.idConta != null) return false;
        if (nomeBanco != null ? !nomeBanco.equals(conta.nomeBanco) : conta.nomeBanco != null) return false;
        if (numeroAgencia != null ? !numeroAgencia.equals(conta.numeroAgencia) : conta.numeroAgencia != null)
            return false;
        return numeroConta != null ? numeroConta.equals(conta.numeroConta) : conta.numeroConta == null;
    }

}
