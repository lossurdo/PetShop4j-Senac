package com.senac.petshop.rn;

import com.senac.petshop.bean.Animal;

/**
 *
 * @author lossurdo
 */
public class AnimalRN {

    public boolean validaIncluir(Animal animal) {
        boolean registroOK = true;

        if (animal.getCodigo() == null) {
            registroOK = false;
        }

        if (animal.getNome() == null) {
            registroOK = false;
        }

        if (animal.getDono() == null || animal.getDono().getCodigo() == null) {
            registroOK = false;
        }

        return registroOK;
    }

}
