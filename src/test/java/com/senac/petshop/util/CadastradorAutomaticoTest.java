package com.senac.petshop.util;

import com.senac.petshop.infra.BancoDados;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author lossurdo
 */
public class CadastradorAutomaticoTest {

    @Before
    public void init() {
        CadastradorAutomatico.popular();
    }
    
    @Test
    public void testPopular() {
        System.out.println("popular");
        
        Assert.assertTrue(BancoDados.getInstance().getListaAgenda().isEmpty());
        Assert.assertTrue(BancoDados.getInstance().getListaProcedimento().isEmpty());

        Assert.assertTrue(BancoDados.getInstance().getListaDono().size()>0);
        Assert.assertTrue(BancoDados.getInstance().getListaAnimal().size()>0);
    }
    
}
