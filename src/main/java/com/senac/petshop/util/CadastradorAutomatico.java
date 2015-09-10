package com.senac.petshop.util;

import com.senac.petshop.bean.Animal;
import com.senac.petshop.bean.CorPredominante;
import com.senac.petshop.bean.Dono;
import com.senac.petshop.bean.TipoAnimal;
import com.senac.petshop.infra.BancoDados;
import java.util.Date;

/**
 * Classe criada para agilizar as demonstrações
 * em sala de aula, contendo alguns registros
 * previamente cadastrados.
 * 
 * @author lossurdo
 */
public class CadastradorAutomatico {
    
    public static final void popular() {
        Dono d1 = new Dono(123);
        d1.setCpf("123456789");
        d1.setNome("João da Silva");
        d1.setDataNascimento(new Date());
        d1.setEmail("joao@gmail.com");
        d1.setTelefoneCelular("5556677");
        
        Dono d2 = new Dono(567);
        d2.setCpf("823456655");
        d2.setNome("Pedro de Carvalho");
        d2.setDataNascimento(new Date());
        d2.setEmail("pedroc@gmail.com");
        d2.setTelefoneCelular("5558899");
        
        Animal a1 = new Animal(111);
        a1.setCorPredominante(CorPredominante.PRETO);
        a1.setDataNascimento(new Date());
        a1.setNome("Rex");
        a1.setTipoAnimal(TipoAnimal.CACHORRO);
        d1.getAnimais().add(a1);
        
        Animal a2 = new Animal(222);
        a2.setCorPredominante(CorPredominante.CHAMPANHE);
        a2.setDataNascimento(new Date());
        a2.setNome("Tom");
        a2.setTipoAnimal(TipoAnimal.GATO);
        d2.getAnimais().add(a2);
        
        // cadastro de donos
        BancoDados.getInstance().getListaDono().add(d1);
        BancoDados.getInstance().getListaDono().add(d2);
        
        // cadastro de animais
        BancoDados.getInstance().getListaAnimal().add(a1);
        BancoDados.getInstance().getListaAnimal().add(a2);
    }
    
}
