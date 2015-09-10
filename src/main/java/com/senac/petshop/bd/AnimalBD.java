package com.senac.petshop.bd;

import com.senac.petshop.infra.CrudBD;
import com.senac.petshop.bean.Animal;
import com.senac.petshop.infra.BancoDados;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author lossurdo
 */
public class AnimalBD extends CrudBD<Animal>{

    @Override
    public void salvar(Animal bean) {
        BancoDados.getInstance().getListaAnimal().add(bean);
    }

    @Override
    public void excluir(Animal bean) {
        BancoDados.getInstance().getListaAnimal().remove(bean);
    }

    @Override
    public Animal consultar(Animal bean) {
        Animal animalRetorno = null;
        for(Animal a : BancoDados.getInstance().getListaAnimal()) {
            if(a.equals(bean)) {
                animalRetorno = a;
            }
        }        
        return animalRetorno;
    }

    @Override
    public void alterar(Animal bean) {
        BancoDados.getInstance().getListaAnimal().remove(bean);
        BancoDados.getInstance().getListaAnimal().add(bean);
    }

    @Override
    public Set<Animal> pesquisar(Animal bean) {
        Set<Animal> lista = new TreeSet<>();
        for(Animal a : BancoDados.getInstance().getListaAnimal()) {
            // pesquisa por código
            if(bean.getCodigo()!=null && a.getCodigo().equals(bean.getCodigo())) {
                lista.add(a);
            }
            
            // pesquisa por nome
            if(bean.getNome()!=null && a.getNome().contains(bean.getNome())) {
                lista.add(a);
            }
        }        
        return lista;
    }
    
}
