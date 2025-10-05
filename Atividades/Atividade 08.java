/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atividade_08;

/**
 *
 * @author Aluno
 */
import java.lang.Math;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Atividade_08 {
    
    public class Questao_01 {
        public int delta(int b, int a, int c){
            return (b*b)-4*a*c;
        }
        public double x1(int b, int a, int c){
            double raiz1=Math.sqrt((b*b)-4*a*c);
            double resultado1=(-b+raiz1)/(2*a);
            return resultado1;
        }
        public double x2(int b, int a, int c){
            double raiz2=Math.sqrt((b*b)-4*a*c);
            double resultado2=(-b-raiz2)/(2*a);
            return resultado2;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada= new Scanner(System.in);
        
        Atividade_08 calcular = new Atividade_08();
        double resultado;
        double x11, x22;
        System.out.println("Dada a equação do 2° grau -3x²+4x+2=0 \nCalcule o valor de x¹ e x² e mostre o resultado.");
        
        resultado=calcular.delta(4, -3, 2);
        System.out.println(resultado);
        x11=calcular.x1(4, -3, 2);
        x22=calcular.x2(4, -3, 2);
        
        
        
    }
    
}
