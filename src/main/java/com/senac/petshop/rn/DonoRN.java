package com.senac.petshop.rn;

import com.senac.petshop.bean.Dono;

/**
 *
 * @author lossurdo
 */
public class DonoRN {

    public boolean validaIncluir(Dono dono) {
        boolean registroOK = true;

        if (dono.getCodigo() == null) {
            registroOK = false;
        }
        
        if (dono.getCpf() == null) {
            registroOK = false;
        }
        
        if (dono.getNome() == null) {
            registroOK = false;
        }
        
        if (dono.getTelefoneCelular() == null) {
            registroOK = false;
        }
        
        return registroOK;
    }

}
