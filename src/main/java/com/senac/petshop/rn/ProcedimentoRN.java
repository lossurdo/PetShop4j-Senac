package com.senac.petshop.rn;

import com.senac.petshop.bd.ProcedimentoBD;
import com.senac.petshop.bean.Procedimento;
import com.senac.petshop.infra.Crud;
import java.util.List;

/**
 *
 * @author lossurdo
 */
public class ProcedimentoRN implements Crud<Procedimento> {
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
