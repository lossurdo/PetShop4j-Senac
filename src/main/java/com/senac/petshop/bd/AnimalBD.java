package com.senac.petshop.bd;

import com.senac.petshop.bean.Animal;
import com.senac.petshop.util.BancoDados;
import java.util.List;

/**
 *
 * @author lossurdo
 */
public class AnimalBD extends GenericoBD<Animal> {

    @Override
    public Animal salvar(Animal objeto) {
        BancoDados.getInstance().getListaAnimal().add(objeto);
        return objeto;
    }

    @Override
    public Animal consultar(Animal objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Animal objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Animal> pesquisar(Animal objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
