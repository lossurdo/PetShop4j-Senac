package com.senac.petshop.bd;

import com.senac.petshop.bean.Animal;
import com.senac.petshop.bean.CorPredominante;
import com.senac.petshop.bean.Dono;
import com.senac.petshop.bean.TipoAnimal;
import com.senac.petshop.infra.CrudBD;
import com.senac.petshop.rn.DonoRN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lossurdo
 */
public class AnimalBD extends CrudBD<Animal> {

    @Override
    public void salvar(Animal bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO animal  ");
            sql.append("(nome, data_nascimento, tipo, descricao, cor_predominante, dono_codigo)  ");
            sql.append("VALUES  ");
            sql.append("(?,?,?,?,?,?) ");

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1, bean.getNome());
            pstm.setDate(2, new java.sql.Date(bean.getDataNascimento().getTime()));
            pstm.setString(3, bean.getTipoAnimal().toString());
            pstm.setString(4, bean.getDescricao());
            pstm.setString(5, bean.getCorPredominante().toString());
            pstm.setInt(6, bean.getDono().getCodigo());

            logger.info("Salvando: " + bean);
            pstm.execute();
            commitTransacao(conn);
            logger.info("Salvamento executado com sucesso");
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }

    @Override
    public void excluir(Animal bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("DELETE FROM animal WHERE codigo=?");
            pstm.setInt(1, bean.getCodigo());

            logger.info("Excluindo: " + bean);
            pstm.execute();
            commitTransacao(conn);
            logger.info("Exclusão executada com sucesso");
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }

    @Override
    public Animal consultar(Animal bean) {
        Animal animalRetorno = null;

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM animal WHERE codigo=?");
            pstm.setInt(1, bean.getCodigo());

            logger.info("Consultando: " + bean);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                logger.info("Registro encontrado");
                animalRetorno = new Animal();
                animalRetorno.setCodigo(rs.getInt("codigo"));
                animalRetorno.setNome(rs.getString("nome"));
                animalRetorno.setDescricao(rs.getString("descricao"));
                animalRetorno.setCorPredominante(CorPredominante.valueOf(rs.getString("cor_predominante")));
                animalRetorno.setTipoAnimal(TipoAnimal.valueOf(rs.getString("tipo")));
                animalRetorno.setDataNascimento(new Date(rs.getDate("data_nascimento").getTime()));

                // consulta dono do animal
                DonoRN rn = new DonoRN();
                animalRetorno.setDono(rn.consultaDonoPorAnimal(animalRetorno));
            }
            logger.info("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }

        return animalRetorno;
    }

    @Override
    public void alterar(Animal bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE animal  ");
            sql.append("SET nome = ?, tipo = ?, descricao = ?,  ");
            sql.append("cor_predominante = ?, data_nascimento = ? ");
            sql.append("WHERE codigo = ?  ");

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1, bean.getNome());
            pstm.setString(2, bean.getTipoAnimal().toString());
            pstm.setString(3, bean.getDescricao());
            pstm.setString(4, bean.getCorPredominante().toString());
            pstm.setDate(5, new java.sql.Date(bean.getDataNascimento().getTime()));
            pstm.setInt(6, bean.getCodigo());

            logger.info("Salvando: " + bean);
            pstm.execute();
            commitTransacao(conn);
            logger.info("Salvamento executado com sucesso");
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }

    @Override
    public List<Animal> pesquisar(String pesquisa) {
        List<Animal> lista = new ArrayList<>();

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM animal WHERE nome like ?");
            pstm.setString(1, "%" + pesquisa + "%");

            logger.info("Consultando: " + pesquisa);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                logger.info("Registro encontrado");
                Animal animalRetorno = new Animal();
                animalRetorno.setCodigo(rs.getInt("codigo"));
                animalRetorno.setNome(rs.getString("nome"));
                animalRetorno.setDescricao(rs.getString("descricao"));
                animalRetorno.setCorPredominante(CorPredominante.valueOf(rs.getString("cor_predominante")));
                animalRetorno.setTipoAnimal(TipoAnimal.valueOf(rs.getString("tipo")));
                animalRetorno.setDataNascimento(new Date(rs.getDate("data_nascimento").getTime()));

                // consulta dono do animal
                DonoRN rn = new DonoRN();
                animalRetorno.setDono(rn.consultaDonoPorAnimal(animalRetorno));

                lista.add(animalRetorno);
            }
            logger.info("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }

        return lista;
    }

    public List<Animal> consultarPorDono(Dono bean) {
        List<Animal> lista = new ArrayList<>();

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM animal WHERE dono_codigo=?");
            pstm.setInt(1, bean.getCodigo());

            logger.info("Consultando: " + bean);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                logger.info("Registro encontrado");

                Animal animalRetorno = new Animal();
                animalRetorno.setCodigo(rs.getInt("codigo"));
                animalRetorno.setNome(rs.getString("nome"));
                animalRetorno.setCorPredominante(CorPredominante.valueOf(rs.getString("cor_predominante")));
                animalRetorno.setTipoAnimal(TipoAnimal.valueOf(rs.getString("tipo")));
                animalRetorno.setDataNascimento(new Date(rs.getDate("data_nascimento").getTime()));
                animalRetorno.setDescricao(rs.getString("descricao"));

                lista.add(animalRetorno);
            }
            logger.info("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }

        return lista;
    }

}
