package com.senac.petshop.rnval;

import com.senac.petshop.bean.Dono;
import com.senac.petshop.infra.ValidacaoRN;
import com.senac.petshop.infra.ValidacaoRNException;

/**
 *
 * @author lossurdo
 */
public class DonoRNVal implements ValidacaoRN<Dono> {

    @Override
    public void validarSalvar(Dono bean) {
        if (bean.getCpf() == null) {
            throw new ValidacaoRNException("Campo CPF não informado");
        }
        
        if (bean.getNome() == null) {
            throw new ValidacaoRNException("Campo Nome não informado");
        }
        
        if (bean.getTelefoneCelular() == null) {
            throw new ValidacaoRNException("Campo Telefone Celular não informado");
        }
    }

    @Override
    public void validarExcluir(Dono bean) {
        validarConsultar(bean);
    }

    @Override
    public void validarConsultar(Dono bean) {
        if (bean.getCodigo() == null) {
            throw new ValidacaoRNException("Campo Código não informado");
        }
    }

    @Override
    public void validarAlterar(Dono bean) {
        validarConsultar(bean);
    }
    
}
