package com.senac.petshop.rn;

import com.senac.petshop.bd.AnimalBD;
import com.senac.petshop.bean.Animal;
import com.senac.petshop.bean.Dono;
import com.senac.petshop.infra.Crud;
import com.senac.petshop.rnval.AnimalRNVal;
import java.util.List;

/**
 *
 * @author lossurdo
 */
public class AnimalRN implements Crud<Animal> {
    
    private final AnimalBD animalBD;
    private final AnimalRNVal animalRNVal;

    public AnimalRN() {
        animalBD = new AnimalBD();
        animalRNVal = new AnimalRNVal();
    }

    @Override
    public void salvar(Animal bean) {
        animalRNVal.validarSalvar(bean);
        animalBD.salvar(bean);
    }

    @Override
    public void excluir(Animal bean) {
        animalRNVal.validarExcluir(bean);
        animalBD.excluir(bean);
    }

    @Override
    public Animal consultar(Animal bean) {
        animalRNVal.validarConsultar(bean);
        return animalBD.consultar(bean);
    }

    @Override
    public void alterar(Animal bean) {
        animalRNVal.validarAlterar(bean);
        animalBD.alterar(bean);
    }

    @Override
    public List<Animal> pesquisar(String pesquisa) {
        return animalBD.pesquisar(pesquisa);
    }

    public List<Animal> consultarPorDono(Dono bean) {
        return animalBD.consultarPorDono(bean);
    }
}
