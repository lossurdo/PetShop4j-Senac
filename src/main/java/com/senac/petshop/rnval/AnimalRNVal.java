package com.senac.petshop.rnval;

import com.senac.petshop.bean.Animal;
import com.senac.petshop.infra.ValidacaoRN;

/**
 *
 * @author lossurdo
 */
public class AnimalRNVal implements ValidacaoRN<Animal>{

    @Override
    public void validarSalvar(Animal bean) {
        if (bean.getCodigo() == null) {
            throw new RuntimeException("Campo Código não informado");
        }

        if (bean.getNome() == null) {
            throw new RuntimeException("Campo Nome não informado");
        }

        if (bean.getDono() == null || bean.getDono().getCodigo() == null) {
            throw new RuntimeException("Campo Dono não informado");
        }
    }

    @Override
    public void validarExcluir(Animal bean) {
        validarConsultar(bean);
    }

    @Override
    public void validarConsultar(Animal bean) {
        if (bean.getCodigo() == null) {
            throw new RuntimeException("Campo Código não informado");
        }
    }

    @Override
    public void validarAlterar(Animal bean) {
        validarSalvar(bean);
    }
    
}
