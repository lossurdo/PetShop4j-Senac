package com.senac.petshop.infra;

import java.util.Set;

interface Crud<T> {

    void salvar(T bean);
    void excluir(T bean);
    T consultar(T bean);
    void alterar(T bean);
    Set<T> pesquisar(String pesquisa);
    
}
