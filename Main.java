import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<List<String>> operacoes = new ArrayList<>();

        operacoes.add(Arrays.asList("Ponto no plano cartesiano", "Distância entre pontos", "Inclinação da reta"));
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
    }
}
