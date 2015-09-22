package com.senac.petshop.util;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author lossurdo
 */
public class ValidacaoSimplesTest {
    
    public ValidacaoSimplesTest() {
    }

    @Test
    public void testIsVazio_String() {
        System.out.println("isVazio");
        String valor = "";
        boolean resultadoEsperado = true;
        boolean resultado = ValidacaoSimples.isVazio(valor);
        Assert.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testIsVazio_Number() {
        System.out.println("isVazio");
        Number valor = null;
        boolean resultadoEsperado = true;
        boolean resultado = ValidacaoSimples.isVazio(valor);
        Assert.assertEquals(resultadoEsperado, resultado);
    }
    
}
