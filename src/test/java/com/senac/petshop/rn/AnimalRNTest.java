package com.senac.petshop.rn;

import com.senac.petshop.bean.Animal;
import com.senac.petshop.bean.CorPredominante;
import com.senac.petshop.bean.Dono;
import com.senac.petshop.bean.TipoAnimal;
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
public class AnimalRNTest {

    private static Dono dono = null;
    private static Animal animal = null;

    @BeforeClass
    public static void init() {
        dono = new Dono();
        dono.setCpf("9999888855");
        dono.setNome("Anna Faris");
        dono.setDataNascimento(new Date());
        dono.setEmail("anna.f@gmail.com");
        dono.setTelefoneCelular("5559999");

        // salva dono para teste dos animais
        System.out.println("salvar para associação");
        DonoRN rn = new DonoRN();
        rn.salvar(dono);
        dono = (Dono) rn.pesquisar("Anna Faris").toArray()[0];
        Assert.assertNotNull(rn.consultar(dono));        
        
        animal = new Animal();
        animal.setCorPredominante(CorPredominante.PRETO);
        animal.setTipoAnimal(TipoAnimal.CACHORRO);
        animal.setDataNascimento(new Date());
        animal.setDescricao("Teste de descrição");
        animal.setDono(dono);
        animal.setNome("Dogão");
    }
    
    @Test
    public void test_A_Salvar() {
        System.out.println("salvar");
        AnimalRN rn = new AnimalRN();
        rn.salvar(animal);

        animal = (Animal) rn.pesquisar("Dogão").toArray()[0];

        Assert.assertNotNull(rn.consultar(animal));
    }

    @Test
    public void test_B_Consultar() {
        System.out.println("consultar");
        AnimalRN rn = new AnimalRN();
        Animal animalConsultar = (Animal) rn.pesquisar("Dogão").toArray()[0];
        Assert.assertNotNull(rn.consultar(animalConsultar));
    }

    @Test
    public void test_C_Pesquisar() {
        System.out.println("pesquisar");
        AnimalRN rn = new AnimalRN();
        List<Animal> resultado = rn.pesquisar("Dogão");
        Assert.assertTrue(resultado.size() > 0);
    }

    @Test
    public void test_D_Excluir() {
        System.out.println("excluir");
        AnimalRN rn = new AnimalRN();
        List<Animal> resultado = rn.pesquisar("Dogão");
        Assert.assertTrue(resultado.size() > 0);
        Animal animalExcluir = (Animal) rn.pesquisar("Dogão").toArray()[0];
        rn.excluir(animalExcluir);
        
        DonoRN donoRN = new DonoRN();
        donoRN.excluir(animalExcluir.getDono());
    }

}
