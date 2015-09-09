package com.senac.petshop.rn;

import com.senac.petshop.bd.GenericoBD;
import java.util.List;

/**
 *
 * @author lossurdo
 */
abstract class GenericoRN<T> {

    private GenericoBD objetoBD;
    
    public GenericoRN(GenericoBD objetoBD) {
        this.objetoBD = objetoBD;
    }

    public abstract T salvar(T objeto);
    public abstract T consultar(T objeto);
    public abstract void excluir(T objeto);
    public abstract List<T> pesquisar(T objeto);

    protected GenericoBD getObjetoBD() {
        return objetoBD;
    }
        
}
