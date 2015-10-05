package com.senac.petshop.rn;

import com.senac.petshop.bd.DonoBD;
import com.senac.petshop.bean.Animal;
import com.senac.petshop.bean.Dono;
import com.senac.petshop.infra.CrudBD;
import com.senac.petshop.rnval.DonoRNVal;
import java.util.List;

/**
 *
 * @author lossurdo
 */
public class DonoRN extends CrudBD<Dono>{
    private final DonoBD donoBD;
    private final DonoRNVal donoRNVal;

    public DonoRN() {
        donoBD = new DonoBD();
        donoRNVal = new DonoRNVal();
    }

    @Override
    public void salvar(Dono bean) {
        donoRNVal.validarSalvar(bean);
        donoBD.salvar(bean);
    }

    @Override
    public void excluir(Dono bean) {
        donoRNVal.validarExcluir(bean);
        donoBD.excluir(bean);
    }

    @Override
    public Dono consultar(Dono bean) {
        donoRNVal.validarConsultar(bean);
        return donoBD.consultar(bean);
    }

    @Override
    public void alterar(Dono bean) {
        donoRNVal.validarAlterar(bean);
        donoBD.alterar(bean);
    }

    @Override
    public List<Dono> pesquisar(String pesquisa) {
        return donoBD.pesquisar(pesquisa);
    }

    public Dono consultaDonoPorAnimal(Animal animal) {
        return donoBD.consultaDonoPorAnimal(animal);
    }

}
