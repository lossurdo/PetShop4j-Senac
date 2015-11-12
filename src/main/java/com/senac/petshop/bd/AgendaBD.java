package com.senac.petshop.bd;

import com.senac.petshop.bean.Agenda;
import com.senac.petshop.bean.Animal;
import com.senac.petshop.bean.Procedimento;
import com.senac.petshop.infra.CrudBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author lossurdo
 */
public class AgendaBD extends CrudBD<Agenda> {

    @Override
    public void salvar(Agenda bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO agenda ");
            sql.append("(data_hora, descricao, entrada_animal, saida_animal, valor_total)  ");
            sql.append("VALUES  ");
            sql.append("(?,?,?,?,?) ");

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setTimestamp(1, new Timestamp(bean.getData().getTime()));
            pstm.setString(2, bean.getDescricao());
            pstm.setBoolean(3, bean.getEntradaAnimal());
            pstm.setBoolean(4, bean.getSaidaAnimal());
            pstm.setDouble(5, bean.getValorTotal());

            logger.debug("Salvando: " + bean);
            pstm.execute();

            // coleta id do autoincrement
            ResultSet res = conn.createStatement().executeQuery("SELECT LAST_INSERT_ID() FROM agenda");
            res.next();
            Integer lastID = res.getInt(1);
            
            sql = new StringBuilder();
            sql.append("INSERT INTO agenda_animal ");
            sql.append("(agenda_codigo, animal_codigo, procedimento_id)  ");
            sql.append("VALUES  ");
            sql.append("(?,?,?) ");
            
            // grava relaçao n:n
            for(Animal a : bean.getAnimais()) {
                for(Procedimento p : bean.getProcedimentos()) {
                    pstm = conn.prepareStatement(sql.toString());
                    pstm.setInt(1, lastID);
                    pstm.setInt(2, a.getCodigo());
                    pstm.setInt(3, p.getCodigo());
                    
                    logger.debug("Salvando: " + bean);
                    pstm.execute();
                }
            }
            
            commitTransacao(conn);
            logger.debug("Salvamento executado com sucesso");
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
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
