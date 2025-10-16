/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.pratico;

/**
 *
 * @author Aluno
 */

import java.util.Scanner;

public class RegistroVeiculo {
    public int tipo;
    public String placa;
    public String nome;
    public String marca;
    public String modelo;
    public String cor;
    public int hora;
    public int minuto;
    public int codigo = 0;
    
    public void Registrar(){

        Scanner input = new Scanner(System.in);
        
        
        
         do{
             
            // TIPO
             do{
                System.out.print("--- Tipo de Veículo ---\n"
                + " 1- Carro\n"
                + " 2- Moto\n"
                + " 3- Caminhão/Caminhonete\n"
                + " Digite o tipo do veículo: ");
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
                        System.out.println("Placa invalida!");}
                }while (placa.length() != 7);
                
            // INFORMAÇÕES NÃO USADA!    
                System.out.print("Digite o nome do condutor: ");
                nome = input.nextLine();
                
                System.out.print("Digite a marca do veículo: ");
                marca = input.nextLine();
                
                System.out.println("Digite a cor do veículo");
                cor = input.nextLine();
                
                // HORA
                    do{
                        System.out.print("Digite a hora de entrada (0-23): ");
                        hora = input.nextInt();
                        if (hora <0 || hora >23);
                        System.out.println("Hora invalida! Digite apenas entre 0 as 23 horas.");
                    }while (hora <0 || hora >23);
                    
                    // MINUTO
                        do{
                            System.out.println("Digite o minuto da entrada (0-59)");
                            minuto = input.nextInt();
                            if (minuto <0 || minuto >59);
                                System.out.println("Minuto invalido! Digite apenas entre 0 as 59 minutos.");
                        }while (minuto <0 || minuto >59);
                        
                        codigo = codigo + 1;
                        
                        System.out.println("Veículo registrado com suceso na vaga" + vaga + ".\nCódigo do v´eículo: " + codigo);
                        
                        
                
                
                
                
   
              
            }
                
        
        
    }while 
}
    }
