package com.senac.petshop.rn;

import com.senac.petshop.bd.AgendaBD;
import com.senac.petshop.bean.Agenda;
import com.senac.petshop.infra.CrudBD;
import com.senac.petshop.rnval.AgendaRNVal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lossurdo
 */
public class AgendaRN extends CrudBD<Agenda> {
    private final AgendaBD agendaBD;
    private final AgendaRNVal agendaRNVal;

    public AgendaRN() {
        agendaBD = new AgendaBD();
        agendaRNVal = new AgendaRNVal();
    }    
    
    @Override
    public void salvar(Agenda bean) {
        agendaRNVal.validarSalvar(bean);
        agendaBD.salvar(bean);
    }

    @Override
    public void excluir(Agenda bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Agenda consultar(Agenda bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Agenda bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Agenda> pesquisar(String pesquisa) {
        return new ArrayList<>();
    }
    
}
