package br.com.ProjetoFinalDependenciasExternas;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class OperacaoArquivo {

    public static List<String[]> lerArquivo(String nomeAqruivo) {

        List<String[]> dadosConta = new ArrayList<>();

        try {
            Reader reader = Files.newBufferedReader(Paths.get(nomeAqruivo));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            dadosConta = csvReader.readAll();
            System.out.println("Não Há Errors");

        } catch (IOException e) {
            System.out.println("Há Error");
            e.printStackTrace();
        }

        return dadosConta;
    }

    public static void escreverExtratos(List<OperacaoBancaria> dadosPorConta) {
        new File("extratos").mkdir();
        String nameFile = "extratos/extrato-" + dadosPorConta.get(0).getConta().getIdConta()+".txt";

        try{
            double saldo = 0.0;
            double valor;
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write("Id conta: " + dadosPorConta.get(0).getConta().getIdConta()+"\n");
            myWriter.write("Banco: " + dadosPorConta.get(0).getConta().getNomeBanco()+"\n");
            myWriter.write("Agência: " + dadosPorConta.get(0).getConta().getNumeroAgencia()+"\n");
            myWriter.write("Conta: " + dadosPorConta.get(0).getConta().getNumeroConta()+"\n");
            myWriter.write("\n");

            myWriter.write("Data da Operação\t\t Operador\t\t Tipo da Operação\t\t Valor \n");
            for (OperacaoBancaria operacao : dadosPorConta){
                valor = Double.parseDouble(operacao.getValor());
                if (operacao.getOperador().length() < 7) {
                    if (operacao.getTipoOperacao().equals("DEPOSITO")) {
                        myWriter.write(operacao.getDataHoraOperacao() + "\t\t "
                                + operacao.getOperador() + "\t\t\t " + operacao.getTipoOperacao() + "\t\t\t\t "
                                + "+" + operacao.getValor() + "\n");

                        saldo += valor;
                    } else {
                        myWriter.write(operacao.getDataHoraOperacao() + "\t\t "
                                + operacao.getOperador() + "\t\t\t " + operacao.getTipoOperacao() + "\t\t\t\t\t "
                                + "-" + operacao.getValor() + "\n");
                        saldo -= valor;
                    }
                } else {
                    if (operacao.getTipoOperacao().equals("DEPOSITO")) {
                        myWriter.write(operacao.getDataHoraOperacao() + "\t\t "
                                + operacao.getOperador() + "\t\t " + operacao.getTipoOperacao() + "\t\t\t\t "
                                + "+" + operacao.getValor() + "\n");
                        saldo += valor;
                    } else {
                        myWriter.write(operacao.getDataHoraOperacao() + "\t\t "
                                + operacao.getOperador() + "\t\t " + operacao.getTipoOperacao() + "\t\t\t\t\t "
                                + "-" + operacao.getValor() + "\n");
                        saldo -= valor;
                    }
                }
            }
            myWriter.write("\n");
            if (saldo >=0){
                myWriter.write("Saldo\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t " + "+" + saldo);
            } else {
                myWriter.write("Saldo\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t " + saldo);
            }

            myWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
