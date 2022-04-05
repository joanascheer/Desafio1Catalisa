import java.util.Scanner;
import java.text.DecimalFormat;

public class CalculoImpostoSimCity {
    public static void main(String[] args) {
        String nome = "";
        String profissao = "";
        double salario = 0;

        calculoImposto(nome, profissao, salario);
        
    }

    public static void calculoImposto (String nome, String profissao, double salario) {

        DecimalFormat formata = new DecimalFormat();
		formata.setMaximumFractionDigits(2);

        Scanner leitor = new Scanner(System.in);

        Double [] salarios = new Double [12];
        Double [] salarioComDesconto = new Double[12];
        Double [] impostoAPagar = new Double[12];

        int opcao = 0;
        double imposto = 0;

    do {
      System.out.println("\n");
      System.out.println("************************");
      System.out.println("   SEJA BEM VINDO(A)!   ");
      System.out.println("************************ \n");

      System.out.println("O que deseja fazer? \n");

      System.out.println("1 - Cadastrar habitante");
      System.out.println("2 - Consultar cadastro de habitante");
      System.out.println("3 - Mostrar salários cadastrados");
      System.out.println("4 - Calcular o imposto mensal");
      System.out.println("5 - Sair \n");
      System.out.println("Digite uma opção: ");
      
      opcao = leitor.nextInt();
      leitor.nextLine();

      if (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5) {
            System.out.println("Opção inválida");
            System.exit(0);

      } else if (opcao == 1) {

        System.out.println("**** Cadastro de Habitante ****\n");
        System.out.println("Digite o nome do habitante: ");
        nome = leitor.nextLine();

        System.out.println("Digite a profissão do habitante: ");
        profissao = leitor.nextLine();

        System.out.println("Cadastro de salários a partir de Janeiro: ");
        System.out.println("(Digite 0 para os meses anteriores à entrada na empresa.) \n");
        
        for (int i = 0; i < salarios.length; i++) {
            System.out.printf("Digite o salário no %2do mês: ", (i+1));
            salario = leitor.nextDouble();

            salarios[i] = salario;
        }

    } else if (opcao == 2) {

            System.out.println("Dados Cadastrados: ");
            System.out.println("Nome: " +nome+ " | Profissão: " +profissao+ "\n");
    
    } else if (opcao == 3) {
        System.out.println("**** Salários Cadastrados **** \n");
        
        for (int i = 0; i < salarios.length; i++) {
            System.out.printf("%2do mês: R$" +formata.format(salarios[i])+ "\n", (i+1));
        }

        // ATE AQUI OK

    } else if (opcao == 4) {

        System.out.println("Cálculo de Imposto: \n");

        for (int i = 0; i < salarios.length; i++) {
            if (salarios[i] <= 2000.0) {
                imposto = 0;
                impostoAPagar[i] = imposto;
                salarioComDesconto[i] = salarios[i] - imposto;

            } else if (salarios[i] >= 2001.00 && salarios[i] <= 3000.0) {

                imposto = (salarios[i] * 8) / 100;
                impostoAPagar[i] = imposto;
                salarioComDesconto[i] = salarios[i] - imposto;

            } else if (salarios[i] >= 3001.0 && salarios[i] <= 4500.0) {
                imposto = (salarios[i] * 18) / 100;
                impostoAPagar[i] = imposto;
                salarioComDesconto[i] = salarios[i] - imposto;

            } else if (salarios[i] > 4500.0) {
                imposto = (salarios[i] * 28) / 100;
                impostoAPagar[i] = imposto;
                salarioComDesconto[i] = salarios[i] - imposto;
                
            }

        }

        System.out.println("**** Salário Líquido **** \n");

        for (int i = 0; i < salarioComDesconto.length; i++) {
            System.out.printf("%2do mês | a receber: R$" +formata.format(salarioComDesconto[i])+ " - Imposto a pagar: R$" +formata.format(impostoAPagar[i])+ "\n", (i+1));
        }

    } else if (opcao == 5) {
        System.out.println("Obrigado(a) por utilizar nosso sistema!");
        System.exit(0);

    }

    } while (opcao != 5);
    
    }
}
