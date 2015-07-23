package com.senac.petshop.util;

import java.util.Scanner;

/**
 *
 * @author lossurdo
 */
public class Console {

    private static final Scanner scanner = new Scanner(System.in);
    
    public static String lerString(String texto) {        
        System.out.print(texto + " ");
        String valor = scanner.next();
        System.out.println("");
        return valor;
    }
    
    public static Double lerDouble(String texto) {        
        System.out.print(texto + " ");
        Double valor = scanner.nextDouble();
        System.out.println("");
        return valor;
    }
    
    public static Long lerLong(String texto) {        
        System.out.print(texto + " ");
        Long valor = scanner.nextLong();
        System.out.println("");
        return valor;
    }
    
    public static Integer lerInteger(String texto) {        
        System.out.print(texto + " ");
        Integer valor = scanner.nextInt();
        System.out.println("");
        return valor;
    }
    
}
