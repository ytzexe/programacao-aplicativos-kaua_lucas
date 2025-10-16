/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.pratico;

import java.util.Scanner;

public class RegistroVeiculo {

  
    
       private int tipo;
       private String placa;
       private String nome;
       private String marca;
       private String modelo;
       private String cor;
       private int hora;
       private int minuto;
       private int vaga;
       
    private static int codigo = 0;
    private static int proximaVaga = 1;   
    private static final int MAX_VAGAS = 10; 
     
    public void registrar(){

        Scanner input = new Scanner(System.in);
        char opcao;
        
        
        if (proximaVaga > MAX_VAGAS) {
            System.out.println("Estacionamento cheio!");
            return;
        }
        
         do{
             
            // TIPO
             do{
                System.out.print("\n--- Tipo de Veículo ---\n"
                + "1- Carro\n"
                + "2- Moto\n"
                + "3- Caminhão/Caminhonete\n"
                + "Digite o tipo do veículo: ");
                tipo = input.nextInt();
                input.nextLine();
                if (tipo <1 || tipo >3){
                    System.out.println("Tipo invalido! Digite 1, 2 ou 3.");
                }
             }while (tipo <1 || tipo >3);
             
            // PLACA 
                do{
                    System.out.print("Digite a placa do veículo: ");
                    placa = input.nextLine();
                    if (placa.length() != 7){
                        System.out.println("Placa invalida!");
                    }
                }while (placa.length() != 7);
                
            // INFORMAÇÕES NÃO USADA!    
                System.out.print("Digite o nome do condutor: ");
                nome = input.nextLine();
                
                System.out.print("Digite a marca do veículo: ");
                marca = input.nextLine();
                
                System.out.print("Digite o modelo do veículo:");
                modelo = input.nextLine();
                
                System.out.print("Digite a cor do veículo:");
                cor = input.nextLine();
                
                // HORA
                    do{
                        System.out.print("Digite a hora de entrada (0-23): ");
                        hora = input.nextInt();
                        if (hora <0 || hora >23){
                        System.out.println("Hora invalida! Digite apenas entre 0 as 23 horas.");
                        }
                    }while (hora <0 || hora >23);
                    
                    // MINUTO
                        do{
                            System.out.println("Digite o minuto da entrada (0-59)");
                            minuto = input.nextInt();
                            if (minuto <0 || minuto >59){
                                System.out.println("Minuto invalido! Digite apenas entre 0 as 59 minutos.");
                            }
                        }while (minuto <0 || minuto >59);
                        
                        // ATRIBUIÇÃO DE VAGA E CÓDIGO
                        
                        vaga = proximaVaga;
                        proximaVaga++;
                        codigo++;
                        
                        System.out.println("Veículo registrado com suceso na vaga" + vaga + ".\nCódigo do v´eículo: " + codigo);
                        
                        
                            System.out.print("Deseja registrar outro veículo? (S/N): ");
                            opcao = input.next().toUpperCase().charAt(0);
                            input.nextLine(); 
                            System.out.println();
                        
         }while (opcao == 'S'); 
         
    }
         
         
          // GETTERS
    public int getTipo() { return tipo; }
    public String getPlaca() { return placa; }
    public String getNome() { return nome; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getCor() { return cor; }
    public int getHora() { return hora; }
    public int getMinuto() { return minuto; }
    public int getVaga() { return vaga; }
  
    public static int getCodigo() { return codigo; }
}
