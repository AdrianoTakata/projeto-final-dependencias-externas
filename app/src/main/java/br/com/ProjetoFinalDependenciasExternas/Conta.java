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

}
