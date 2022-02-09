package br.com.ProjetoFinalDependenciasExternas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static br.com.ProjetoFinalDependenciasExternas.OperacaoArquivo.escreverExtratos;
import static br.com.ProjetoFinalDependenciasExternas.OperacaoArquivo.lerArquivo;

public class OrganizacaoBancaria {

    List<String[]> dados = lerArquivo("dados-contas.csv");
    Collection<OperacaoBancaria> dadosConta = new HashSet<>();
    Collection<String> idContaLista = new HashSet<>();

    public void gerarExtrato() {

        gerarListaDados();
        obterIdConta();

        for (String idConta : idContaLista){
            List<OperacaoBancaria> dadosPorConta = dadosConta.stream()
                    .filter(operacao -> operacao.getConta().getIdConta().equals(idConta))
                    .collect(Collectors.toList());
            Collections.sort(dadosPorConta, Comparator.comparing(operacao -> operacao.getDataHoraOperacao()));
            escreverExtratos(dadosPorConta);
        }
    }

    public void gerarListaDados(){
        for (String[] pessoa : this.dados) {
            this.dadosConta.add(new OperacaoBancaria(LocalDateTime.parse(pessoa[0], DateTimeFormatter.ISO_DATE_TIME),
                    pessoa[5], pessoa[6], pessoa[7], new Conta(pessoa[1], pessoa[2], pessoa[3], pessoa[4])));
        }
    }

    public void obterIdConta() {
        for (OperacaoBancaria operacao: this.dadosConta){
            this.idContaLista.add(operacao.getConta().getIdConta());
        }
    }

}
