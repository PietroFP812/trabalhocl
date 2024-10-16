package clayton.services;

import clayton.entities.Pessoa;

public class CalculadoraImpostoRenda {
    private Pessoa pessoa;

    public CalculadoraImpostoRenda(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    private double calcularImpostoSalario() {
        double rendaSalario = pessoa.getRendaSalario();
        if (rendaSalario < 3000 * 12) {
            return 0;
        } else if (rendaSalario < 5000 * 12) {
            return rendaSalario * 0.10;
        } else {
            return rendaSalario * 0.20;
        }
    }

    private double calcularImpostoServico() {
        return pessoa.getRendaServico() * 0.15;
    }

    private double calcularImpostoGanhoCapital() {
        return pessoa.getGanhoCapital() * 0.20;
    }

    private double calcularAbatimento(double impostoBruto) {
        double gastosTotais = pessoa.getGastosSaude() + pessoa.getGastosEducacao();
        double limiteAbatimento = impostoBruto * 0.30;
        return Math.min(gastosTotais, limiteAbatimento);
    }

    public double calcularImpostoLiquido() {
        double impostoSalario = calcularImpostoSalario();
        double impostoServico = calcularImpostoServico();
        double impostoGanhoCapital = calcularImpostoGanhoCapital();

        double impostoBruto = impostoSalario + impostoServico + impostoGanhoCapital;
        double abatimento = calcularAbatimento(impostoBruto);

        return impostoBruto - abatimento;
    }

    public void exibirRelatorio() {
        double impostoSalario = calcularImpostoSalario();
        double impostoServico = calcularImpostoServico();
        double impostoGanhoCapital = calcularImpostoGanhoCapital();
        double impostoBruto = impostoSalario + impostoServico + impostoGanhoCapital;
        double abatimento = calcularAbatimento(impostoBruto);
        double impostoLiquido = calcularImpostoLiquido();

        System.out.println("\n### RELATÓRIO DE IMPOSTO DE RENDA ###");
        System.out.println("* CONSOLIDADO DE RENDA:");
        System.out.printf("Imposto sobre salário: R$ %.2f%n", impostoSalario);
        System.out.printf("Imposto sobre serviços: R$ %.2f%n", impostoServico);
        System.out.printf("Imposto sobre ganho de capital: R$ %.2f%n", impostoGanhoCapital);
        System.out.println("* DEDUÇÕES:");
        System.out.printf("Máximo dedutível: R$ %.2f%n", abatimento);
        System.out.printf("Gastos dedutíveis: R$ %.2f%n", pessoa.getGastosSaude() + pessoa.getGastosEducacao());
        System.out.println("* RESUMO:");
        System.out.printf("Imposto bruto total: R$ %.2f%n", impostoBruto);
        System.out.printf("Abatimento: R$ %.2f%n", abatimento);
        System.out.printf("Imposto devido: R$ %.2f%n", impostoLiquido);
    }
}
