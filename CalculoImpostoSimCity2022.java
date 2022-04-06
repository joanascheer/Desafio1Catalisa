import java.util.Scanner;
import java.text.DecimalFormat;

public class CalculoImpostoSimCity2022 {
    public static void main(String[] args) {

        Scanner lemenu = new Scanner(System.in);

        String[] dadosHabitante = new String[2];
        Double[] salarios = new Double[12];
        Double [] salarioComDesconto = new Double[12];
        Double [] impostoAPagar = new Double[12];
    
        int opcao = 0;
        
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
            
            opcao = lemenu.nextInt();

            if (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5) {

                System.out.println("Opção inválida");
                System.exit(0);

            } else if (opcao == 1) {

                dadosDoHabitante(dadosHabitante);

            } else if (opcao == 2) {

                mostraDados(dadosHabitante);

            } else if (opcao == 3) {

                mostraSalario(salarios);

            } else if (opcao == 4) {

                calculaImposto(salarios, salarioComDesconto, impostoAPagar);
                mostraImposto(impostoAPagar, salarioComDesconto);
                
            } else if (opcao == 5) {
                System.out.println("Obrigado(a) por utilizar nosso sistema!");
                System.exit(0);
            }

        } while (opcao != 5);

        lemenu.close();
    }

    // Cadastro do Habitante
    public static String[] dadosDoHabitante (String[] dadosHabitante) {
        
            Scanner leDados = new Scanner(System.in);
            System.out.println("Digite o nome do habitante:");
            dadosHabitante[0] = leDados.nextLine();
    
            System.out.println("Digite a profissão do habitante:");
            dadosHabitante[1] = leDados.nextLine();

            return dadosHabitante;
        
    }

    // Mostra dados do Habitante
    public static void mostraDados (String[] dadosHabitante) {
            
        if (dadosHabitante[0] == null && dadosHabitante[1] == null) {
            System.out.println("Você precisa cadastrar os dados para continuar");
            System.exit(0);
        } else {
            System.out.println("Dados Cadastrados: ");
            System.out.println("Nome: " +dadosHabitante[0]+ " | Profissão: " +dadosHabitante[1]+ "\n");
            System.out.println();
        }
        
    }

    // Mostra salário
    public static void mostraSalario(Double salarios[]) {
        Scanner leSalario = new Scanner(System.in);
        
        DecimalFormat formata = new DecimalFormat();
		formata.setMaximumFractionDigits(2);

        System.out.println("**** Salários Cadastrados a partir de Janeiro ****");
        System.out.println("Caso não tenha cadastrado os salários, o faremos a seguir.");
        System.out.println("(Digite 0 para os meses anteriores à entrada na empresa.) \n");
        
        for (int i=0; i<salarios.length; i++) {
            if (salarios[i] != null) {
                System.out.printf("%2do mês: R$" +formata.format(salarios[i])+ "\n", (i+1));
            } else {

            System.out.printf("Digite o salário no %2do mês: ", (i+1));
                salarios[i] = leSalario.nextDouble();

            }

        }
    }
       

    // Calcula imposto
    public static Double[] calculaImposto(Double[] salarios, Double[] impostoAPagar, Double[] salarioComDesconto) {

        System.out.println("Cálculo de Imposto: \n");

        for (int i = 0; i < salarios.length; i++) {
            if (salarios[i] <= 2000.0) {
                impostoAPagar[i] = 0.0;
                salarioComDesconto[i] = salarios[i] - impostoAPagar[i];

            } else if (salarios[i] >= 2001.00 && salarios[i] <= 3000.0) {
                impostoAPagar[i] = salarios[i] * 8 / 100;
                salarioComDesconto[i] = salarios[i] - impostoAPagar[i];

            } else if (salarios[i] >= 3001.0 && salarios[i] <= 4500.0) {
                impostoAPagar[i] = (salarios[i] * 18) / 100;
                salarioComDesconto[i] = salarios[i] - impostoAPagar[i];

            } else if (salarios[i] > 4500.0) {
                impostoAPagar[i] = (salarios[i] * 28) / 100;
                salarioComDesconto[i] = salarios[i] - impostoAPagar[i];

            }

        }

        return impostoAPagar;
    }

    // Mostrar imposto e salário com desconto
    public static void mostraImposto(Double salarioComDesconto[], Double impostoAPagar[]) {
        DecimalFormat formata = new DecimalFormat();
		formata.setMaximumFractionDigits(2);

        System.out.println("**** Impostos a pagar **** \n");

        for (int i = 0; i < impostoAPagar.length; i++) {
            System.out.printf("%2do mês | Valor do imposto: R$" +formata.format(impostoAPagar[i])+ " - Valor a receber: R$" +formata.format(salarioComDesconto[i])+ "\n", (i+1));
        }

    }
      
}


    
