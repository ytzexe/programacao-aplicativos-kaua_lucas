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
    
    public static final int MAX_VAGAS = 10;
    private static RegistroVeiculo[] vagas = new RegistroVeiculo[MAX_VAGAS];
     
    public static RegistroVeiculo getVeiculoNaVaga(int indice) {
        if (indice >= 0 && indice < MAX_VAGAS) {
            return vagas[indice];
        }
        return null;
    }
   
    public void setTipo(int tipo){
        this.tipo = tipo;
    }
    
    public void setTipo(){
        System.out.println(tipo);
    }
    
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
            
                do {
                    System.out.print("Digite o nome do condutor: ");
                    nome = input.nextLine();
                    if (nome.length() == 0){
                        System.out.println("O nome do condutor não pode estar vazio!");
                    }
                }while(nome.length() == 0);
                
                do{
                    System.out.print("Digite a marca do veículo: ");
                    marca = input.nextLine();
                    if (marca.length() == 0){
                        System.out.println("A marca não pode estar vazia!");
                    }
                }while(marca.length() == 0);
                
                do{
                    System.out.print("Digite o modelo do veículo:");
                    modelo = input.nextLine();
                    if (modelo.length() == 0){
                        System.out.println("O modelo não pode estar vazio!");
                    }
                }while(modelo.length() == 0);
                
                do{
                    System.out.print("Digite a cor do veículo:");
                    cor = input.nextLine();
                    if(cor.length() == 0){
                        System.out.println("A cor não pode estar vazio");
                    }
                }while(cor.length() == 0);
                                       
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
                            System.out.print("Digite o minuto da entrada (0-59): ");
                            minuto = input.nextInt();
                            if (minuto <0 || minuto >59){
                                System.out.println("Minuto invalido! Digite apenas entre 0 as 59 minutos.");
                            }
                           
                        }while (minuto <0 || minuto >59);
                        
                        // ATRIBUIÇÃO DE VAGA E CÓDIGO
                        
//                        vaga = proximaVaga;
//                        proximaVaga++;
//                        codigo++;
                        
                           RegistroVeiculo veiculo = new RegistroVeiculo();
                            veiculo.tipo = this.tipo;
                            veiculo.placa = this.placa;
                            veiculo.hora = this.hora;
                            veiculo.minuto = this.minuto;
                            veiculo.vaga = codigo;
                            vagas[codigo] = veiculo;
                            
                            System.out.println("Veículo registrado com sucesso na vaga " + (codigo + 1) + ".");
                            codigo++;
                        
                        // VERIFICAR SE DESEJA REGISTRAR OU VOLTAR AO MENU
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
