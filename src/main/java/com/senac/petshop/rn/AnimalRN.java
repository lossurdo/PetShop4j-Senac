package com.senac.petshop.rn;

import com.senac.petshop.bd.AnimalBD;
import com.senac.petshop.bean.Animal;
import java.util.List;

/**
 *
 * @author lossurdo
 */
public class AnimalRN extends GenericoRN<Animal> {

    public AnimalRN() {
        super(new AnimalBD());
    }

    @Override
    public Animal salvar(Animal objeto) {
        if (objeto.getCodigo() == null) {
            throw new RuntimeException("Campo Código não informado");
        }

        if (objeto.getNome() == null) {
            throw new RuntimeException("Campo Nome não informado");
        }

        if (objeto.getDono() == null || objeto.getDono().getCodigo() == null) {
            throw new RuntimeException("Campo Dono não informado");
        }

        return (Animal) getObjetoBD().salvar(objeto);
    }

    @Override
    public Animal consultar(Animal objeto) {
        return (Animal) getObjetoBD().consultar(objeto);
    }

    @Override
    public void excluir(Animal objeto) {
        getObjetoBD().excluir(objeto);
    }

    @Override
    public List<Animal> pesquisar(Animal objeto) {
        return getObjetoBD().pesquisar(objeto);
    }

}
