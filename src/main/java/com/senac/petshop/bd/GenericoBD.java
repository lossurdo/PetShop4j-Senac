package com.senac.petshop.bd;

import java.util.List;

/**
 *
 * @author lossurdo
 */
public abstract class GenericoBD<T> {
    
    public abstract T salvar(T objeto);
    public abstract T consultar(T objeto);
    public abstract void excluir(T objeto);
    public abstract List<T> pesquisar(T objeto);
    
}
