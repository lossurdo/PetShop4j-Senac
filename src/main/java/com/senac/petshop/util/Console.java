package com.senac.petshop.util;

import java.util.Scanner;

/**
 *
 * @author lossurdo
 */
public class Console {

    private static final Scanner scanner = new Scanner(System.in);
    
    private static void imprimir(String texto) {
        System.out.print(">>> " + texto + " ");
    }
    
    private static void pularLinha() {
        System.out.println();
    }
    
    public static String lerString(String texto) {        
        imprimir(texto);
        String valor = scanner.next();
        pularLinha();
        return valor;
    }
    
    public static Double lerDouble(String texto) {        
        imprimir(texto);
        Double valor = scanner.nextDouble();
        pularLinha();
        return valor;
    }
    
    public static Long lerLong(String texto) {        
        imprimir(texto);
        Long valor = scanner.nextLong();
        pularLinha();
        return valor;
    }
    
    public static Integer lerInteger(String texto) {        
        imprimir(texto);
        Integer valor = scanner.nextInt();
        pularLinha();
        return valor;
    }
    
}
