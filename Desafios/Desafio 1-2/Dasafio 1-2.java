// MAIN


package caixa_rapido_refatorado;

import java.util.Scanner;


public class Caixa_rapido_refatorado {

    public static class Menu_Opcao{
        public int escolha(){
            String opcao;
            Scanner entrada = new Scanner(System.in);

            while (true){
                    System.out.println("Deseja voltar ao menu inicial (V) ou encerrar o programa (E)?");
                    opcao = entrada.nextLine();
                    
                    if (opcao.equalsIgnoreCase("e") || opcao.equalsIgnoreCase("v")){
                        if (opcao.equalsIgnoreCase("e")){
                            System.out.println("Encerrando o sistema.");
                            return 0;
                        }
                        if (opcao.equalsIgnoreCase("v")){
                            return -1;
                        }
                    }
                    else{
                        System.out.println("Opção invalida! \nDigite apenas (V) ou (E).");
                    }
                    }
        }
    }
   
   
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ContaBancaria saldo = new ContaBancaria(100.00, 0.00);
        Extrato movimentacao = new Extrato();
        Menu_Opcao menu = new Menu_Opcao();
        SimuladorEmprestimo emprestimo = new SimuladorEmprestimo();
        ServicoCambio cambio = new ServicoCambio();
        
        int escolha, escolhaCambio;
        double deposito;
        
        
        System.out.println("Iniciando o sistema!");
        
        do{
            System.out.print("=== Caixa Rápido === \n" );
            System.out.print("1- Saldo \n");
            System.out.print("2- Depósito \n");
            System.out.print("3- Extrato \n");
            System.out.print("4- Simular Empréstimo \n");
            System.out.print("5- Comprar Dolar \n");
            System.out.print("0- Sair \n");
            escolha = entrada.nextInt();
            
            
            switch (escolha){
                case 1 : 
                    saldo.exibir();
                    escolha = menu.escolha();
                    break;
                    
                    
                case 2 :
                    boolean depositoValido = false;
                    do{
                    System.out.println("Digite o valor a ser depositado: (R$0,01 a R$5,000,00) ");
                    deposito=entrada.nextDouble();
                    entrada.nextLine();
                    
                    if (deposito>=0.01 && deposito<=5000){
                        saldo.depositar(deposito);
                        System.out.println("Deposito realizado com sucesso!");
                        movimentacao.salvarDepositoReal(deposito);
                        depositoValido=true;
                        escolha = menu.escolha();
                    break;
                    }
                    else {
                        System.out.println("Valor inválido!");
                        depositoValido=false;
                    }
                    }while(depositoValido==false);
                    break;
                    
                case 3:
                    movimentacao.exibir();
                    escolha = menu.escolha();
                    break;
                    
                case 4:
                    emprestimo.simular();
                    escolha = menu.escolha();
                    break;
                    
                    case 5:
                        boolean repetirCambio = true;
                            while (repetirCambio) {
                                repetirCambio = cambio.comprarDolar(saldo, movimentacao);
                            }
                        escolha = menu.escolha();
                        break;

                    
                case 0:
                    System.out.println("Encerrando o sistema!");
                    break;
                default: escolha=-1;
                    
            }
            
        }while(escolha!=0);
        
    
    }
    
}




// CLASSE CONTA BANCARIA


package caixa_rapido_refatorado;


public class ContaBancaria {
    
    public double saldoReal;
    public double saldoDolar;
    public double deposito;
    public double depositoDolar;
    public double compraDolar;
    
    public ContaBancaria(double saldoReal, double saldoDolar){
        this.saldoReal = saldoReal;
        this.saldoDolar = saldoDolar;
        
    }
    
    public double getSaldoReal(){
        return saldoReal;
    }
    
    public void setSaldoReal(double saldoReal){
        this.saldoReal = saldoReal;
    }
    
    public double getSaldoDolar(){
        return saldoDolar;
    }
    
    public void setSaldoDolar(double saldoDolar){
        this.saldoDolar = saldoDolar;
    }
    
    public void exibir(){
        
        System.out.println("Saldo em Reais: R$"+saldoReal + "\nSaldo em Dólares: US$"+saldoDolar);
    }
    
    public double depositar(double deposito){
        this.deposito = deposito;
        return saldoReal = saldoReal + deposito;
    }
    public double depositarDolar(double depositoDolar){
        this.depositoDolar = depositoDolar;
        return saldoDolar = saldoDolar + depositoDolar;
    }
    public double comprarDolar(double compraDolar){
        this.compraDolar = compraDolar;
        return saldoReal = saldoReal - compraDolar;
    }
    
}



// CLASSE EXTRATO


package caixa_rapido_refatorado;

public class Extrato {
    public String [] movimentacao = new String[10];
    public int posicaoExtrato = 0;

    
    public void salvarDepositoReal(double depositoReal){

        
        if (posicaoExtrato < movimentacao.length){
            movimentacao[posicaoExtrato]=String.format("Deposito +R$ %.2f ", depositoReal);
            posicaoExtrato++;
        }
        else{
            for (int i=0;i<movimentacao.length-1; i++) {
                movimentacao[i]=movimentacao[i+1];
            }
            movimentacao[movimentacao.length-1]=String.format("Deposito +R$ %.2f ", depositoReal);
        }
    }
    
    public void exibir(){

        System.out.println("Extrato de últimos depósitos:");
        boolean vazio=true;
        for (int i=posicaoExtrato-1; i>=0; i--){
            if (movimentacao[i]!=null){
            System.out.println(movimentacao[i]);
            vazio=false;
            }
        }
        if (vazio){
            System.out.println("Nenhum extrato!");
        }
    }
    
    public void salvarCompraDolar(double quantidade, double custo) {
    if (posicaoExtrato < movimentacao.length - 1) {
        movimentacao[posicaoExtrato] = String.format("Compra de US$: -R$%.2f", custo);
        posicaoExtrato++;
        movimentacao[posicaoExtrato] = String.format("Depósito em dólar: +US$%.2f", quantidade);
        posicaoExtrato++;
    } else {
        for (int i = 0; i < movimentacao.length - 2; i++) {
            movimentacao[i] = movimentacao[i + 2];
        }
        movimentacao[movimentacao.length - 2] = String.format("Compra de US$: -R$%.2f", custo);
        movimentacao[movimentacao.length - 1] = String.format("Depósito em dólar: +US$%.2f", quantidade);
    }
}

    
}


// CLASSE SIMULADOR DE EMPRESTIMO



package caixa_rapido_refatorado;
import java.util.Scanner;
import java.util.Random;

public class SimuladorEmprestimo {
    
    public double emprestimo;
    public double salario;
    public int parcela;
    public double valorParcela;
    public double juros;
    public double totalParcela;
    public double parcelaMax;
    public double totalEmprestimo;
    public int protocolo;
    
    public void simular(){
        Random rd = new Random();
        protocolo = 10000+rd.nextInt(99999);
        
        
        Scanner entrada = new Scanner(System.in);
        do{
            System.out.println("Digite o valor do emprestimo desejado: (R$200,00 a R$100,000,00) ");
            emprestimo= entrada.nextDouble();
            entrada.nextLine();
            
            if (emprestimo>=200 && emprestimo<=100000){
                System.out.println("Digite o seu salario bruto: ");
                salario=entrada.nextDouble();
                entrada.nextLine();
                do {
                    System.out.println("Escolha a quantidade de parcelas: \n(6, 12, 18, 24, 30, 36, 40, 48, 56, 60 ou 72)");
                    parcela=entrada.nextInt();
                    entrada.nextLine();
                    
                    switch (parcela){
                            case 6:
                                valorParcela = emprestimo/parcela;
                                juros = valorParcela*0.02;
                                totalParcela = valorParcela + juros;
                                parcelaMax = salario*0.30;
                                totalEmprestimo = totalParcela * parcela;
                                
                                if(valorParcela>parcelaMax){
                                    System.out.println("Emprestimo indisponivel!");
                                    break;
                                    
                                }
                                else{
                                    System.out.println("Emprestimo disponivel, entre em contato com a central e informe o numero de protocolo EM"+protocolo);
                                    System.out.printf("Valor da parcela; R$%.2f",totalParcela," x 6 %n");
                                    System.out.printf("Valor do emprestimo: R$%.2f %n",emprestimo);
                                    System.out.printf("Valor total do emprestimo a ser pago: R$%.2f %n",totalEmprestimo);
                                    break;
                                }
                            case 12:
                                valorParcela = emprestimo/parcela;
                                juros = valorParcela*0.02;
                                totalParcela = valorParcela + juros;
                                parcelaMax = salario*0.30;
                                totalEmprestimo = totalParcela * parcela;
                                
                                if(valorParcela>parcelaMax){
                                    System.out.println("Emprestimo indisponivel!");
                                    break;
                                    
                                }
                                else{
                                    System.out.println("Emprestimo disponivel, entre em contato com a central e informe o numero de protocolo EM"+protocolo);
                                    System.out.printf("Valor da parcela; R$%.2f",totalParcela," x 12 %n");
                                    System.out.printf("Valor do emprestimo: R$%.2f %n",emprestimo);
                                    System.out.printf("Valor total do emprestimo a ser pago: R$%.2f %n",totalEmprestimo);
                                    break;
                                }
                            case 18:
                                valorParcela = emprestimo/parcela;
                                juros = valorParcela*0.02;
                                totalParcela = valorParcela + juros;
                                parcelaMax = salario*0.30;
                                totalEmprestimo = totalParcela * parcela;
                                
                                if(valorParcela>parcelaMax){
                                    System.out.println("Emprestimo indisponivel!");
                                    break;
                                    
                                }
                                else{
                                    System.out.println("Emprestimo disponivel, entre em contato com a central e informe o numero de protocolo EM"+protocolo);
                                    System.out.printf("Valor da parcela; R$%.2f",totalParcela," x 18 %n");
                                    System.out.printf("Valor do emprestimo: R$%.2f %n",emprestimo);
                                    System.out.printf("Valor total do emprestimo a ser pago: R$%.2f %n",totalEmprestimo);
                                    break;
                                }
                            case 24:
                                valorParcela = emprestimo/parcela;
                                juros = valorParcela*0.02;
                                totalParcela = valorParcela + juros;
                                parcelaMax = salario*0.30;
                                totalEmprestimo = totalParcela * parcela;
                                
                                if(valorParcela>parcelaMax){
                                    System.out.println("Emprestimo indisponivel!");
                                    break;
                                    
                                }
                                else{
                                    System.out.println("Emprestimo disponivel, entre em contato com a central e informe o numero de protocolo EM"+protocolo);
                                    System.out.printf("Valor da parcela; R$%.2f",totalParcela," x 24 %n");
                                    System.out.printf("Valor do emprestimo: R$%.2f %n",emprestimo);
                                    System.out.printf("Valor total do emprestimo a ser pago: R$%.2f %n",totalEmprestimo);
                                    break;
                                }
                            case 30:
                                valorParcela = emprestimo/parcela;
                                juros = valorParcela*0.02;
                                totalParcela = valorParcela + juros;
                                parcelaMax = salario*0.30;
                                totalEmprestimo = totalParcela * parcela;
                                
                                if(valorParcela>parcelaMax){
                                    System.out.println("Emprestimo indisponivel!");
                                    break;
                                    
                                }
                                else{
                                    System.out.println("Emprestimo disponivel, entre em contato com a central e informe o numero de protocolo EM"+protocolo);
                                    System.out.printf("Valor da parcela; R$%.2f",totalParcela," x 30 %n");
                                    System.out.printf("Valor do emprestimo: R$%.2f %n",emprestimo);
                                    System.out.printf("Valor total do emprestimo a ser pago: R$%.2f %n",totalEmprestimo);
                                    break;
                                }
                            case 36:
                                valorParcela = emprestimo/parcela;
                                juros = valorParcela*0.02;
                                totalParcela = valorParcela + juros;
                                parcelaMax = salario*0.30;
                                totalEmprestimo = totalParcela * parcela;
                                
                                if(valorParcela>parcelaMax){
                                    System.out.println("Emprestimo indisponivel!");
                                    break;
                                    
                                }
                                else{
                                    System.out.println("Emprestimo disponivel, entre em contato com a central e informe o numero de protocolo EM"+protocolo);
                                    System.out.printf("Valor da parcela; R$%.2f",totalParcela," x 36 %n");
                                    System.out.printf("Valor do emprestimo: R$%.2f %n",emprestimo);
                                    System.out.printf("Valor total do emprestimo a ser pago: R$%.2f %n",totalEmprestimo);
                                    break;
                                }
                            case 40:
                                valorParcela = emprestimo/parcela;
                                juros = valorParcela*0.02;
                                totalParcela = valorParcela + juros;
                                parcelaMax = salario*0.30;
                                totalEmprestimo = totalParcela * parcela;
                                
                                if(valorParcela>parcelaMax){
                                    System.out.println("Emprestimo indisponivel!");
                                    break;
                                    
                                }
                                else{
                                    System.out.println("Emprestimo disponivel, entre em contato com a central e informe o numero de protocolo EM"+protocolo);
                                    System.out.printf("Valor da parcela; R$%.2f",totalParcela," x 40 %n");
                                    System.out.printf("Valor do emprestimo: R$%.2f %n",emprestimo);
                                    System.out.printf("Valor total do emprestimo a ser pago: R$%.2f %n",totalEmprestimo);
                                    break;
                                }
                            case 48:
                                valorParcela = emprestimo/parcela;
                                juros = valorParcela*0.02;
                                totalParcela = valorParcela + juros;
                                parcelaMax = salario*0.30;
                                totalEmprestimo = totalParcela * parcela;
                                
                                if(valorParcela>parcelaMax){
                                    System.out.println("Emprestimo indisponivel!");
                                    break;
                                    
                                }
                                else{
                                    System.out.println("Emprestimo disponivel, entre em contato com a central e informe o numero de protocolo EM"+protocolo);
                                    System.out.printf("Valor da parcela; R$%.2f",totalParcela," x 48 %n");
                                    System.out.printf("Valor do emprestimo: R$%.2f %n",emprestimo);
                                    System.out.printf("Valor total do emprestimo a ser pago: R$%.2f %n",totalEmprestimo);
                                    break;
                                }
                            case 56:
                                valorParcela = emprestimo/parcela;
                                juros = valorParcela*0.02;
                                totalParcela = valorParcela + juros;
                                parcelaMax = salario*0.30;
                                totalEmprestimo = totalParcela * parcela;
                                
                                if(valorParcela>parcelaMax){
                                    System.out.println("Emprestimo indisponivel!");
                                    break;
                                    
                                }
                                else{
                                    System.out.println("Emprestimo disponivel, entre em contato com a central e informe o numero de protocolo EM"+protocolo);
                                    System.out.printf("Valor da parcela; R$%.2f",totalParcela," x 56 %n");
                                    System.out.printf("Valor do emprestimo: R$%.2f %n",emprestimo);
                                    System.out.printf("Valor total do emprestimo a ser pago: R$%.2f %n",totalEmprestimo);
                                    break;
                                }
                            case 60:
                                valorParcela = emprestimo/parcela;
                                juros = valorParcela*0.02;
                                totalParcela = valorParcela + juros;
                                parcelaMax = salario*0.30;
                                totalEmprestimo = totalParcela * parcela;
                                
                                if(valorParcela>parcelaMax){
                                    System.out.println("Emprestimo indisponivel!");
                                    break;
                                    
                                }
                                else{
                                    System.out.println("Emprestimo disponivel, entre em contato com a central e informe o numero de protocolo EM"+protocolo);
                                    System.out.printf("Valor da parcela; R$%.2f",totalParcela," x 60 %n");
                                    System.out.printf("Valor do emprestimo: R$%.2f %n",emprestimo);
                                    System.out.printf("Valor total do emprestimo a ser pago: R$%.2f %n",totalEmprestimo);
                                    break;
                                }
                            case 72:
                                valorParcela = emprestimo/parcela;
                                juros = valorParcela*0.02;
                                totalParcela = valorParcela + juros;
                                parcelaMax = salario*0.30;
                                totalEmprestimo = totalParcela * parcela;
                                
                                if(valorParcela>parcelaMax){
                                    System.out.println("Emprestimo indisponivel!");
                                    break;
                                    
                                }
                                else{
                                    System.out.println("Emprestimo disponivel, entre em contato com a central e informe o numero de protocolo EM"+protocolo);
                                    System.out.printf("Valor da parcela; R$%.2f",totalParcela," x 72 %n");
                                    System.out.printf("Valor do emprestimo: R$%.2f %n",emprestimo);
                                    System.out.printf("Valor total do emprestimo a ser pago: R$%.2f %n",totalEmprestimo);
                                    break;
                                }
                            default:
                                System.out.println("Parcela invalida!");
                                break;
                        }
                        
                        
                        }while (parcela != 6 && parcela != 12 && parcela != 18 && parcela != 24 && parcela != 30 && parcela != 36 && parcela != 40 && parcela != 48 && parcela != 56 && parcela != 60 && parcela != 72);
                        }
                    
                    
                    else {
                        System.out.println("Valor invalido!");
                    }
                    
            
        }while(emprestimo<200 || emprestimo>100000);
    }
    
    
}



 // CLASSE SERVIÇO DE CAMBIO


package caixa_rapido_refatorado;
import java.util.Scanner;

public class ServicoCambio {
    
    public double cotacao = 5.32;
    public double quantidade;
    public double custo;
    public double consultaSaldoReal;
    public double consultaSaldoDolar;
    
    public double attSaldoReal(double consultaSaldoReal){
        this.consultaSaldoReal = consultaSaldoReal;
        return consultaSaldoReal;
    }
    
    public double attSaldoDolar(double consultaSaldoDolar){
        this.consultaSaldoDolar = consultaSaldoDolar;
        return consultaSaldoDolar;
    }
    
    
    public boolean comprarDolar(ContaBancaria conta, Extrato extrato){
        Scanner entrada = new Scanner(System.in);
        
        String opcao;
        String confirmacao;
        
        
        do{
            double saldoReal = conta.getSaldoReal();
            double saldoDolar = conta.getSaldoDolar();
            
            System.out.printf("Saldo R$%.2f %n",saldoReal);
            System.out.println("1 USD = R$5,32 \nDigite a quantidade de US$ que deseja comprar: ");
            quantidade=entrada.nextDouble();
            entrada.nextLine();
            custo=quantidade*cotacao;
            
            if (custo>saldoReal){
                System.out.printf("Custo em Reais: R$%.2f %n",custo);
                System.out.println("Saldo insuficiente!");
                System.out.println("Deseja simular novamente (R), voltar ao menu (V) ou encerrar o programa(E)");
                opcao = entrada.nextLine();
                
                if (opcao.equalsIgnoreCase("R")){
                        return true;
                    }
                    if (opcao.equalsIgnoreCase("E")){
                        System.exit(0);
                       return false;
                    }
                    if (opcao.equalsIgnoreCase("V")){
                        return false;
                    }
                    }
                else {
                    System.out.printf("Custo em Reais: R$%.2f %n",custo);
                    System.out.println("Confirmar compra? (s/n)");
                    confirmacao=entrada.nextLine();
                        if (confirmacao.equalsIgnoreCase("s")){
                            conta.comprarDolar(custo);
                            conta.depositarDolar(quantidade);
                            System.out.printf("Compra realizada com sucesso! %nNovo saldo: %n-Reais R$%.2f %n-Dólares US$%.2f %n", conta.getSaldoReal(), conta.getSaldoDolar());
                            
                            extrato.salvarCompraDolar(quantidade, custo);
                             return false;
}

                        else{
                            System.out.println("Operação cancelada.");
                    return false;
                        }


                        }
                        
        }while(true);
        
    }
}
