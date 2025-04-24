package com.projeto.trigonometria;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<List<String>> operacoes = new ArrayList<>();

        operacoes.add(Arrays.asList("Ponto no plano cartesiano", "Distância entre pontos", "criar reta","mostrar informações da reta"));
        operacoes.add(Arrays.asList(""));
        operacoes.add(Arrays.asList(""));

        System.out.println("Escolha o assunto:");
        System.out.println("[0] - Plano cartesiano");
        System.out.println("[1] - Cosseno");
        System.out.println("[2] - Tangente");

        int assunto = scanner.nextInt();

        if (assunto < 0 || assunto >= operacoes.size()) {
            System.out.println("Assunto inválido.");
            return;
        }

        System.out.println("Escolha a operação:");
        List<String> listaOperacoes = operacoes.get(assunto);
        for (int i = 0; i < listaOperacoes.size(); i++) {
            System.out.println("[" + i + "] - " + listaOperacoes.get(i));
        }

        int operacao = scanner.nextInt();

        if (operacao < 0 || operacao >= listaOperacoes.size()) {
            System.out.println("Operação inválida.");
            return;
        }

        System.out.println("Você escolheu: " + listaOperacoes.get(operacao));


////////////////////////////////// Operaçoes //////////////////////////////////
            ///////////// Assunto 0 - Plano cartesiano /////////////
int escolha = assunto * 100 + operacao;

switch (escolha) {
    case 0: // assunto 0: Plano cartesiano, operação 0: Ponto no plano cartesiano
        new CartesianPlaneChart().mostrarGrafico();
        break;

    case 1: // assunto 0, operação 1: distância entre pontos
        new CartesianPlaneChart().calcularDistanciaEntrePontos();
        break;
    
    case 2: // assunto 0, operação 2: criar reta
        new CartesianPlaneChart().mostrarGraficoComReta();
        break;
        
    case 3: // assunto 0 (Plano cartesiano), operação 2 (Inclinação da reta)
        new CartesianPlaneChart().mostrarGraficoComRetaInclinação();
        break;
    

    default:
        System.out.println("Operação ainda não implementada.");
}

            ///////////// Assunto 1 - XXXX /////////////
    }

}