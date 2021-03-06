package com.senac.petshop.rnval;

import com.senac.petshop.bean.Agenda;
import com.senac.petshop.infra.ValidacaoRN;

/**
 *
 * @author lossurdo
 */
public class AgendaRNVal implements ValidacaoRN<Agenda> {

    @Override
    public void validarSalvar(Agenda bean) {
        if (bean.getData() == null) {
            throw new RuntimeException("Campo Data não informado");
        }
        if (bean.getAnimais() == null) {
            throw new RuntimeException("Campo Animais não informado");
        }
        if (bean.getProcedimentos() == null) {
            throw new RuntimeException("Campo Procedimentos não informado");
        }
    }

    @Override
    public void validarExcluir(Agenda bean) {

    }

    @Override
    public void validarConsultar(Agenda bean) {

    }

    @Override
    public void validarAlterar(Agenda bean) {

    }
    
}
