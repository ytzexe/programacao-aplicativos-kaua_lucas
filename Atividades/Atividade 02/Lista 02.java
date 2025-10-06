package atividade02;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class Atividade_02 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
      
        double raio, circ, area;

        System.out.print("Digite o valor do raio do círculo: ");
        raio = entrada.nextDouble();

        area = Math.PI * (Math.pow(raio, 2));
        circ = 2 * Math.PI * raio;

        System.out.println("Área: " + area);
        System.out.println("Circunferência: " + circ);
        
