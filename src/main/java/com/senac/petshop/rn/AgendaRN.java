package com.senac.petshop.rn;

import com.senac.petshop.bd.AgendaBD;
import com.senac.petshop.bean.Agenda;
import com.senac.petshop.bean.Procedimento;
import com.senac.petshop.infra.Crud;
import com.senac.petshop.rnval.AgendaRNVal;
import java.util.List;

/**
 *
 * @author lossurdo
 */
public class AgendaRN implements Crud<Agenda> {

    private final AgendaBD agendaBD;
    private final AgendaRNVal agendaRNVal;

    public AgendaRN() {
        agendaBD = new AgendaBD();
        agendaRNVal = new AgendaRNVal();
    }

    @Override
    public void salvar(Agenda bean) {
        agendaRNVal.validarSalvar(bean);
        calcularPreco(bean);
        agendaBD.salvar(bean);
    }

    @Override
    public void excluir(Agenda bean) {
        agendaRNVal.validarExcluir(bean);
        agendaBD.excluir(bean);
    }

    @Override
    public Agenda consultar(Agenda bean) {
        agendaRNVal.validarConsultar(bean);
        return agendaBD.consultar(bean);
    }

    @Override
    public void alterar(Agenda bean) {
        agendaRNVal.validarSalvar(bean);
        calcularPreco(bean);
        agendaBD.alterar(bean);
    }

    @Override
    public List<Agenda> pesquisar(String pesquisa) {
        return agendaBD.pesquisar(pesquisa);
    }

    private void calcularPreco(Agenda bean) {
        // calculando preço
        double total = 0.0;
        for(Procedimento p : bean.getProcedimentos()) {
            total += p.getPreco();
        }
        bean.setValorTotal(total * bean.getAnimais().size());
    }
    
}
