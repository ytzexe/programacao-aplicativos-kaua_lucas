/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.questao_08;

/**
 *
 * @author rafael
 */

import java.lang.Math;
import java.util.Scanner;


public class Questao_08 {
    
    public static class Atividade_08{
        
        public void menu_principal(){
            Scanner entrada = new Scanner(System.in);
            Cachorro pet = null;
            int escolha;
            do{
                System.out.println("=== MENU PRINCIPAL ===");
                System.out.println("1. Cadastrar Pet");
                System.out.println("2. Escolher Serviço");
                System.out.println("3. Exibir Ficha");
                System.out.println("0. Sair");
                System.out.println("Escolha a opção desejada: ");
                escolha = entrada.nextInt();
                entrada.nextLine();
                
                switch(escolha){
                    case 1 -> pet = Cachorro.cadastrar();
                    case 2 -> {
                        if (pet!=null){
                            pet.procedimento();
                        }else{
                            System.out.println("Cadastre um Pet primeiro!");
                        }
                    }
                    case 3 -> {
                        if (pet!=null){
                            pet.exibir();
                        }else{
                            System.out.println("Cadastre um Pet primeiro!");
                        }
                    }
                    case 0 -> System.out.println("Encerrando o sistema!");
                    default -> System.out.println("Escoha invalida! \nDigite 1, 2 ou 3.");
                }
            }while(escolha!=0);
        }
    }
    
    

    public static void main(String[] args) {
        
        Scanner entrada=new Scanner(System.in);
        
           Atividade_08 programa = new Atividade_08();
                    programa.menu_principal();
        
        
    }
}






/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.questao_08;

/**
 *
 * @author rafael
 */
import java.util.Scanner;

public class Cachorro {
    
    public String nome_pet;
    public String raca;
    public int idade;
    public String nome_dono;
    public String contato_dono;
    public String servico_escolhido;
    

    public Cachorro(String nome_pet, String raca, int idade, String nome_dono, String contato_dono, String servico_escolhido){
        this.nome_pet = nome_pet;
        this.raca = raca;
        this.idade = idade;
        this.nome_dono = nome_dono;
        this.contato_dono = contato_dono;
        this.servico_escolhido = servico_escolhido;
        }
    
    public static Cachorro cadastrar(){
        Scanner entrada=new Scanner(System.in);
        System.out.print("=== Cadastro Pet Shop Amigo Fiel===\n");
        
        System.out.println("Digite o nome do Pet: ");
        String nome_pet=entrada.nextLine();
        
        System.out.println("Digite a raça do Pet: ");
        String raca=entrada.nextLine();
        
        System.out.println("Digite a idade do Pet: ");
        int idade=entrada.nextInt();
        entrada.nextLine();
        
        System.out.println("Digite o nome do dono: ");
        String nome_dono=entrada.nextLine();
        
        System.out.println("Digite o telefone de contato: ");
        String contato_dono=entrada.nextLine();
        
        return new Cachorro(nome_pet, raca, idade, nome_dono, contato_dono, null);
                
            }
    
    public void exibir(){
        
        System.out.print("=========================================\n");
        System.out.print("=== FICHA DE ATENDIMENTO - AMIGO FIEL ===\n");
        System.out.print("=========================================\n");
        System.out.print("Nome do Pet....: "+nome_pet+"\n");
        System.out.print("Raça...........: "+raca+"\n");
        System.out.print("Idade..........: "+idade+"\n");
        System.out.print("Dono(a)........: "+nome_dono+"\n");
        System.out.print("Contato........: "+contato_dono+"\n");
        System.out.print("-----------------------------------------\n");
        System.out.print("Procedimento...: "+servico_escolhido+"\n");
    }
    
    public void procedimento(){
        Scanner entrada = new Scanner(System.in);
        servico_escolhido=null;
        System.out.print("=== Menu de Serviços ===\n");
        System.out.print("1. Banho \n");
        System.out.print("2. Tosa \n");
        System.out.print("3. Banho e Tosa \n");
        System.out.print("4. Consulta Veterinaria \n");
        System.out.println("Escolha o serviço desejado: ");
        int servico=entrada.nextInt();
        
        switch(servico){
            case 1 -> servico_escolhido="Banho";
            case 2 -> servico_escolhido="Tosa";
            case 3 -> servico_escolhido="Banho e Tosa";
            case 4 -> servico_escolhido="Consulta Veterinaria";
            default -> System.out.println("Serviço invalido!");
        }
    }
    
}
