package com.senac.petshop.rn;

import com.senac.petshop.bean.Dono;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author lossurdo
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DonoRNTest {

    private static Dono dono = null;

    @BeforeClass
    public static void init() {
        dono = new Dono();
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

        dono = (Dono) rn.pesquisar("Anna Faris").toArray()[0];

        Assert.assertNotNull(rn.consultar(dono));
    }

    @Test
    public void test_B_Consultar() {
        System.out.println("consultar");
        DonoRN rn = new DonoRN();
        Dono donoConsultar = (Dono) rn.pesquisar("Anna Faris").toArray()[0];
        Assert.assertNotNull(rn.consultar(donoConsultar));
    }

    @Test
    public void test_C_Pesquisar() {
        System.out.println("pesquisar");
        DonoRN rn = new DonoRN();
        List<Dono> resultado = rn.pesquisar("Anna Faris");
        Assert.assertTrue(resultado.size() > 0);
    }

    @Test
    public void test_D_Excluir() {
        System.out.println("excluir");
        DonoRN rn = new DonoRN();
        List<Dono> resultado = rn.pesquisar("Anna Faris");
        Assert.assertTrue(resultado.size() > 0);
        Dono donoExcluir = (Dono) rn.pesquisar("Anna Faris").toArray()[0];
        rn.excluir(donoExcluir);
    }

}
