package com.senac.petshop.bd;

import com.senac.petshop.bean.Agenda;
import com.senac.petshop.infra.CrudBD;
import java.util.List;

/**
 *
 * @author lossurdo
 */
public class AgendaBD extends CrudBD<Agenda> {

    @Override
    public void salvar(Agenda bean) {

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
