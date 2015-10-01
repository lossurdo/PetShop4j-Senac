package com.senac.petshop.bd;

import com.senac.petshop.bean.Dono;
import com.senac.petshop.infra.BancoDados;
import com.senac.petshop.infra.CrudBD;
import java.sql.Connection;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author lossurdo
 */
public class DonoBD extends CrudBD<Dono> {

    @Override
    public void salvar(Dono bean) {
        Connection conn = null;
        try {
            // pegaria a conexão para gravar em banco
            conn = abrirConexao();
            
            // salvaria em banco
            BancoDados.getInstance().getListaDono().add(bean);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }

    @Override
    public void excluir(Dono bean) {
        BancoDados.getInstance().getListaDono().remove(bean);
    }

    @Override
    public Dono consultar(Dono bean) {
        Dono donoRetorno = null;
        for(Dono d : BancoDados.getInstance().getListaDono()) {
            if(d.equals(bean)) {
                donoRetorno = d;
            }
        }        
        return donoRetorno;    
    }

    @Override
    public void alterar(Dono bean) {
        BancoDados.getInstance().getListaDono().remove(bean);
        BancoDados.getInstance().getListaDono().add(bean);
    }

    @Override
    public Set<Dono> pesquisar(Dono bean) {
        Set<Dono> lista = new TreeSet<>();
        for(Dono a : BancoDados.getInstance().getListaDono()) {
            // pesquisa por código
            if(bean.getCodigo()!=null && a.getCodigo().equals(bean.getCodigo())) {
                lista.add(a);
            }
            
            // pesquisa por nome
            if(bean.getNome()!=null && a.getNome().contains(bean.getNome())) {
                lista.add(a);
            }
        }        
        return lista;    
    }
    
}
