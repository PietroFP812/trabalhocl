package clayton;

import clayton.entities.Pessoa;
import clayton.services.CalculadoraImpostoRenda;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        System.out.print("Informe a renda anual com salário: ");
        double rendaSalario = scanner.nextDouble();

        System.out.print("Informe a renda anual com prestação de serviços: ");
        double rendaServico = scanner.nextDouble();

        System.out.print("Informe a renda anual com ganho de capital: ");
        double ganhoCapital = scanner.nextDouble();

        System.out.print("Informe os gastos anuais com saúde: ");
        double gastosSaude = scanner.nextDouble();

        System.out.print("Informe os gastos anuais com educação: ");
        double gastosEducacao = scanner.nextDouble();

        // Criação de um objeto Pessoa com os dados fornecidos
        Pessoa pessoa = new Pessoa(rendaSalario, rendaServico, ganhoCapital, gastosSaude, gastosEducacao);

        // Cálculo do imposto de renda
        CalculadoraImpostoRenda calculadora = new CalculadoraImpostoRenda(pessoa);
        calculadora.exibirRelatorio();

        scanner.close();
    }
}
