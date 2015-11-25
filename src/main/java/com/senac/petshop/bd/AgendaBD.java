package com.senac.petshop.bd;

import com.senac.petshop.bean.Agenda;
import com.senac.petshop.bean.Animal;
import com.senac.petshop.bean.Procedimento;
import com.senac.petshop.infra.CrudBD;
import com.senac.petshop.rn.AnimalRN;
import com.senac.petshop.rn.ProcedimentoRN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("DELETE FROM agenda_animal WHERE agenda_codigo=?");
            pstm.setInt(1, bean.getCodigo());

            logger.debug("Excluindo: " + bean);
            pstm.execute();
            
            pstm = conn.prepareStatement("DELETE FROM agenda WHERE codigo=?");            
            pstm.setInt(1, bean.getCodigo());

            logger.debug("Excluindo: " + bean);
            pstm.execute();
            
            commitTransacao(conn);
            logger.debug("Exclusão executada com sucesso");
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }

    @Override
    public Agenda consultar(Agenda bean) {
        // definição do SQL com base nos dados informados para pesquisa
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM agenda a WHERE a.codigo = ?");

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setInt(1, bean.getCodigo());

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                logger.debug("Registro encontrado");
                
                Agenda animal = new Agenda(rs.getInt("codigo"));
                animal.setData(new Date(rs.getTimestamp("data_hora").getTime()));
                animal.setDescricao(rs.getString("descricao"));
                animal.setValorTotal(rs.getDouble("valor_total"));
                animal.setEntradaAnimal(rs.getBoolean("entrada_animal"));
                animal.setSaidaAnimal(rs.getBoolean("saida_animal"));

                // buscando lista de animais de uma agenda
                sql = new StringBuilder();
                sql.append("SELECT * FROM animal a INNER JOIN agenda_animal aa on aa.animal_codigo=a.codigo WHERE aa.agenda_codigo = ?");
                pstm = conn.prepareStatement(sql.toString());
                pstm.setInt(1, bean.getCodigo());
                
                ResultSet rsa = pstm.executeQuery();
                AnimalRN animalRN = new AnimalRN();
                while(rsa.next()) {
                    animal.getAnimais().add(animalRN.consultar(new Animal(rsa.getInt("codigo"))));
                }
                
                // buscando lista de procedimentos de uma agenda
                sql = new StringBuilder();
                sql.append("SELECT * FROM procedimento p INNER JOIN agenda_animal aa on aa.procedimento_id=p.codigo WHERE aa.agenda_codigo = ?");
                pstm = conn.prepareStatement(sql.toString());
                pstm.setInt(1, bean.getCodigo());

                ResultSet rsp = pstm.executeQuery();
                ProcedimentoRN procedimentoRN = new ProcedimentoRN();
                while(rsp.next()) {
                    animal.getProcedimentos().add(procedimentoRN.consultar(new Procedimento(rsp.getInt("codigo"))));
                }
                
                return animal;
            }                        
            logger.debug("Pesquisa executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        
        return null;
    }

    @Override
    public void alterar(Agenda bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE agenda  ");
            sql.append("SET data_hora = ?, descricao = ?, entrada_animal = ?, saida_animal = ?, valor_total = ? ");
            sql.append("WHERE codigo = ?  ");

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setTimestamp(1, new Timestamp(bean.getData().getTime()));
            pstm.setString(2, bean.getDescricao());
            pstm.setBoolean(3, bean.getEntradaAnimal());
            pstm.setBoolean(4, bean.getSaidaAnimal());
            pstm.setDouble(5, bean.getValorTotal());
            pstm.setInt(6, bean.getCodigo());

            logger.debug("Alterando: " + bean);
            pstm.execute();
            
            logger.debug("Excluindo N:N");
            pstm = conn.prepareStatement("DELETE FROM agenda_animal WHERE agenda_codigo = ?");
            pstm.setInt(1, bean.getCodigo());
            pstm.execute();
            
            sql = new StringBuilder();
            sql.append("INSERT INTO agenda_animal ");
            sql.append("(agenda_codigo, animal_codigo, procedimento_id)  ");
            sql.append("VALUES  ");
            sql.append("(?,?,?) ");
            
            // grava relaçao n:n
            for(Animal a : bean.getAnimais()) {
                for(Procedimento p : bean.getProcedimentos()) {
                    pstm = conn.prepareStatement(sql.toString());
                    pstm.setInt(1, bean.getCodigo());
                    pstm.setInt(2, a.getCodigo());
                    pstm.setInt(3, p.getCodigo());
                    
                    logger.debug("Salvando: " + bean);
                    pstm.execute();
                }
            }
            
            commitTransacao(conn);
            logger.debug("Alteração executada com sucesso");
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }

    @Override
    public List<Agenda> pesquisar(String pesquisa) {
        List<Agenda> lista = new ArrayList<>();

        // definição do SQL com base nos dados informados para pesquisa
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM agenda a");

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement(sql.toString());

            logger.debug("Pesquisando: " + pesquisa);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                logger.debug("Registro encontrado");
                
                Agenda a = new Agenda(rs.getInt("codigo"));
                a.setData(new Date(rs.getTimestamp("data_hora").getTime()));
                a.setDescricao(rs.getString("descricao"));
                a.setValorTotal(rs.getDouble("valor_total"));
                a.setEntradaAnimal(rs.getBoolean("entrada_animal"));
                a.setSaidaAnimal(rs.getBoolean("saida_animal"));
                
                lista.add(a);
            }
                        
            for (Agenda lis : lista) {
                // buscando lista de animais de uma agenda
                sql = new StringBuilder();
                sql.append("SELECT * FROM animal a INNER JOIN agenda_animal aa on aa.animal_codigo=a.codigo WHERE aa.agenda_codigo = ?");
                pstm = conn.prepareStatement(sql.toString());
                pstm.setInt(1, lis.getCodigo());
                
                ResultSet rsa = pstm.executeQuery();
                AnimalRN animalRN = new AnimalRN();
                while(rsa.next()) {
                    lis.getAnimais().add(animalRN.consultar(new Animal(rsa.getInt("codigo"))));
                }
                
                // buscando lista de procedimentos de uma agenda
                sql = new StringBuilder();
                sql.append("SELECT * FROM procedimento p INNER JOIN agenda_animal aa on aa.procedimento_id=p.codigo WHERE aa.agenda_codigo = ?");
                pstm = conn.prepareStatement(sql.toString());
                pstm.setInt(1, lis.getCodigo());

                ResultSet rsp = pstm.executeQuery();
                ProcedimentoRN procedimentoRN = new ProcedimentoRN();
                while(rsp.next()) {
                    lis.getProcedimentos().add(procedimentoRN.consultar(new Procedimento(rsp.getInt("codigo"))));
                }
            }
            
            logger.debug("Pesquisa executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }

        return lista;
    }
    
}
