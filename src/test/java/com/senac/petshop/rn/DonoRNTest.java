package com.senac.petshop.rn;

import com.senac.petshop.bean.Dono;
import java.util.Date;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author lossurdo
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DonoRNTest {
    
    private Dono dono = null;
    
    @Before
    public void init() {
        dono = new Dono(99999);
        dono.setCpf("9999888855");
        dono.setNome("Anna Faris");
        dono.setDataNascimento(new Date());
        dono.setEmail("anna.f@gmail.com");
        dono.setTelefoneCelular("5559999");    
    }
    
    @Test
    public void test_A_Salvar() {
        System.out.println("salvar");
        DonoRN rn = new DonoRN();
        rn.salvar(dono);
        Assert.assertNotNull(rn.consultar(dono));
    }

    @Test
    public void test_B_Consultar() {
        System.out.println("consultar");
        DonoRN rn = new DonoRN();
        Assert.assertNull(rn.consultar(new Dono(22222)));
    }

    @Test
    public void test_C_Pesquisar() {
        System.out.println("pesquisar");
        DonoRN rn = new DonoRN();
        Set<Dono> resultado = rn.pesquisar(new Dono(99999));
        Assert.assertTrue(resultado.size()>0);
    }
    
}
