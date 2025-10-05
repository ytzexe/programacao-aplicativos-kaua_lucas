package atividade06;

import java.util.Scanner;

public class Atividade06 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // ================== Atividade 01 ==================
        /*
        double nota;
        do {
            System.out.print("Digite uma nota (0 a 10): ");
            nota = entrada.nextDouble();
        } while (nota >= 11);

        System.out.println("Nota válida: " + nota);

        if (nota < 0) {
            System.out.println("Valor inválido! Tente novamente.");
        }
        */

        // ================== Atividade 02 ==================
        /*
        int num1, soma;
        double media, quantidade;

        quantidade = -1;
        soma = 0;
        media = 0;

        do {
            System.out.println("Digite um número (0 encerra): ");
            num1 = entrada.nextInt();

            soma = soma + num1;
            quantidade = quantidade + 1;
        } while (num1 != 0);

        media = soma / quantidade;
        System.out.println("Soma: " + soma);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Média: " + media);
        */

        // ================== Atividade 03 ==================
        /*
        int aleatorio, palpite, quantidade;
        quantidade = 0;

        aleatorio = (int) (Math.random() * 100) + 1;

        do {
            System.out.println("Digite o seu palpite: ");
            palpite = entrada.nextInt();
            quantidade++;

            if (palpite < aleatorio) {
                System.out.println("Palpite: " + palpite);
                System.out.println("Muito baixo!");
            }
            if (palpite > aleatorio) {
                System.out.println("Palpite: " + palpite);
                System.out.println("Muito alto!");
            }
        } while (palpite != aleatorio);

        System.out.println("Palpite: " + palpite);
        System.out.println("Acertou em " + quantidade + " tentativas!");
        */

        // ================== Atividade 04 ==================
        /*
        int n, contagem;
        String opcao;

        do {
            do {
                System.out.println("Digite N (>0): ");
                n = entrada.nextInt();
                entrada.nextLine();
                contagem = n;

                if (n <= 0) {
                    System.out.println("Valor inválido. Tente novamente!");
                } else {
                    while (contagem >= 0) {
                        System.out.println(contagem);
                        contagem--;
                    }
                    break;
                }
            } while (n <= 0);

            System.out.println("Repetir? (s / n): ");
            opcao = entrada.nextLine();
        } while (opcao.equalsIgnoreCase("s"));
        */

        // ================== Atividade 05 ==================
        /*
        String senha, senha_correta;
        int tentativas = 3;

        senha_correta = "senai123";

        do {
            System.out.println("Digite a senha: ");
            senha = entrada.nextLine();

            if (!senha.equals(senha_correta)) {
                tentativas--;
                System.out.println("Senha incorreta! Tentativas restantes: " + tentativas);
            } else {
                System.out.println("Acesso concedido!");
                break;
            }
        } while (!senha.equals(senha_correta) && tentativas > 0);
        */

        // ================== Atividade 06 ==================
        /*
        int n, resultado;

        System.out.println("Digite o valor de N para tabuada: ");
        n = entrada.nextInt();

        for (int i = 1; i <= 10; i++) {
            resultado = i * n;
            System.out.println(n + " * " + i + " = " + resultado);
        }
        */

        // ================== Atividade 07 ==================
        /*
        int impar = 0, par = 0, n;

        do {
            System.out.println("Digite um valor (N>0): ");
            n = entrada.nextInt();

            if (n <= 0) {
                System.out.println("Valor inválido!");
            } else {
                for (int i = 1; i <= n; i++) {
                    if (i % 2 == 0) {
                        par += i;
                    } else {
                        impar += i;
                    }
                }
                System.out.println("Soma dos pares: " + par);
                System.out.println("Soma dos ímpares: " + impar);
            }
        } while (n <= 0);
        */

        // ================== Atividade 08 ==================
        /*
        int n;

        do {
            System.out.println("Digite um número inteiro maior que 1: ");
            n = entrada.nextInt();

            if (n <= 1) {
                System.out.println("Número inválido!");
            } else {
                for (int i = 2; i <= n; i++) {
                    boolean primo = true;
                    for (int k = 2; k * k <= i; k++) {
                        if (i % k == 0) {
                            primo = false;
                            break;
                        }
                    }
                    if (primo) {
                        System.out.print(i + ", ");
                    }
                }
            }
        } while (n <= 1);
        */

        entrada.close();
    }
}
