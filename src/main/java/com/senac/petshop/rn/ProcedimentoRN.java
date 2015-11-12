/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.petshop.rn;

import com.senac.petshop.bd.ProcedimentoBD;
import com.senac.petshop.bean.Procedimento;
import com.senac.petshop.infra.CrudBD;
import java.util.List;

/**
 *
 * @author lossurdo
 */
public class ProcedimentoRN extends CrudBD<Procedimento> {
    private final ProcedimentoBD procedimentoBD;

    public ProcedimentoRN() {
        procedimentoBD = new ProcedimentoBD();
    }

    @Override
    public void salvar(Procedimento bean) {

    }

    @Override
    public void excluir(Procedimento bean) {

    }

    @Override
    public Procedimento consultar(Procedimento bean) {
        return null;
    }

    @Override
    public void alterar(Procedimento bean) {

    }

    @Override
    public List<Procedimento> pesquisar(String pesquisa) {
        return procedimentoBD.pesquisar(pesquisa);
    }
    
}
