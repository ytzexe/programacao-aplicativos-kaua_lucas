
package projeto.pratico;

import java.util.Scanner;

public class ProjetoPratico {
    

   
    public static void main(String[] args) {
        
        
         RegistroVeiculo rv = new RegistroVeiculo();
         ConsultarVagas cs = new ConsultarVagas();
         Scanner input = new Scanner(System.in);
        
       int escolha;
     do {
            System.out.print(
                    """
                    ==== MENU INICIAL DO ESTACIONAMENTO ====
                     1 - REGISTRAR VEÍCULO EM VAGA
                     2 - FINALIZAR USO DO VEÍCULO NA VAGA
                     3 - CONSULTAR DISPONIBILIDADE DE VAGAS
                     4 - CONSULTAR SALDO E HISTÓRICO DE PAGAMENTOS
                     0 - SAIR""");
                     System.out.print("\nDIGITE A OPÇÃO DESEJADA: ");
                     
            
            escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1 -> rv.registrar();
                case 2 -> System.out.println("Finalizar uso do veículo na vaga...");
                case 3 -> cs.consulta();
                case 4 -> System.out.println("Consultar saldo e histórico de pagamentos...");
                case 0 -> System.out.println("\nEncerrando o sistema...");
                default -> System.out.println("\nOpção inválida! Tente novamente.\n");
            }

            System.out.println();

        } while (escolha != 0);
    }
}
