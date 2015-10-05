package com.senac.petshop.bd;

import com.senac.petshop.bean.Animal;
import com.senac.petshop.bean.Dono;
import com.senac.petshop.infra.CrudBD;
import com.senac.petshop.rn.AnimalRN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
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
            conn = abrirConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO dono ");
            sql.append("(nome, cpf, tel_residencial, tel_celular, email, data_nascimento)  ");
            sql.append("VALUES  ");
            sql.append("(?,?,?,?,?,?) ");

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1, bean.getNome());
            pstm.setString(2, bean.getCpf());
            pstm.setString(3, bean.getTelefoneResidencial());
            pstm.setString(4, bean.getTelefoneCelular());
            pstm.setString(5, bean.getEmail());
            pstm.setDate(6, new java.sql.Date(bean.getDataNascimento().getTime()));

            logger.debug("Salvando: " + bean);
            pstm.execute();
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
    public void excluir(Dono bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("DELETE FROM dono WHERE codigo=?");
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
    public Dono consultar(Dono bean) {
        Dono donoRetorno = null;

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM dono WHERE codigo=?");
            pstm.setInt(1, bean.getCodigo());

            logger.debug("Consultando: " + bean);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                logger.debug("Registro encontrado");
                donoRetorno = new Dono();
                donoRetorno.setCodigo(rs.getInt("codigo"));
                donoRetorno.setNome(rs.getString("nome"));
                donoRetorno.setCpf(rs.getString("cpf"));
                donoRetorno.setEmail(rs.getString("email"));
                donoRetorno.setTelefoneCelular(rs.getString("tel_celular"));
                donoRetorno.setTelefoneResidencial(rs.getString("tel_residencial"));
                donoRetorno.setDataNascimento(new Date(rs.getDate("data_nascimento").getTime()));
                
                // consulta animais de um dono
                AnimalRN rn = new AnimalRN();
                donoRetorno.setAnimais(rn.consultarPorDono(donoRetorno));
            }
            logger.debug("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }

        return donoRetorno;
    }

    @Override
    public void alterar(Dono bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE dono  ");
            sql.append("SET nome = ?, cpf = ?, tel_residencial = ?,  ");
            sql.append("tel_celular = ?, email = ?,  ");
            sql.append("data_nascimento = ?  ");
            sql.append("WHERE codigo = ?  ");

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1, bean.getNome());
            pstm.setString(2, bean.getCpf());
            pstm.setString(3, bean.getTelefoneResidencial());
            pstm.setString(4, bean.getTelefoneCelular());
            pstm.setString(5, bean.getEmail());
            pstm.setDate(6, new java.sql.Date(bean.getDataNascimento().getTime()));
            pstm.setInt(7, bean.getCodigo());

            logger.debug("Alterando: " + bean);
            pstm.execute();
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
    public Set<Dono> pesquisar(String pesquisa) {
        Set<Dono> lista = new TreeSet<>();

        // definição do SQL com base nos dados informados para pesquisa
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT *  ");
        sql.append("FROM dono  ");
        sql.append("WHERE ");
        sql.append("nome like ? ");
        sql.append("OR cpf like ? ");
        sql.append("OR email like ? ");

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1, "%" + pesquisa + "%");
            pstm.setString(2, "%" + pesquisa + "%");
            pstm.setString(3, "%" + pesquisa + "%");

            logger.debug("Pesquisando: " + pesquisa);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                logger.debug("Registro encontrado");
                
                Dono dono = new Dono();
                dono.setCodigo(rs.getInt("codigo"));
                dono.setNome(rs.getString("nome"));
                dono.setCpf(rs.getString("cpf"));
                dono.setEmail(rs.getString("email"));
                dono.setTelefoneCelular(rs.getString("tel_celular"));
                dono.setTelefoneResidencial(rs.getString("tel_residencial"));
                dono.setDataNascimento(new Date(rs.getDate("data_nascimento").getTime()));
                
                // consulta animais de um dono
                AnimalRN rn = new AnimalRN();
                dono.setAnimais(rn.consultarPorDono(dono));

                lista.add(dono);
            }
            logger.debug("Pesquisa executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }

        return lista;
    }

    public Dono consultaDonoPorAnimal(Animal bean) {
        Dono donoRetorno = null;

        Connection conn = null;
        try {
            conn = abrirConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT d.* ");
            sql.append("from dono d ");
            sql.append("inner join animal a on a.dono_codigo=d.codigo ");
            sql.append("where a.codigo=? ");            
            
            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setInt(1, bean.getCodigo());

            logger.debug("Consultando: " + bean);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                logger.debug("Registro encontrado");
                donoRetorno = new Dono();
                donoRetorno.setCodigo(rs.getInt("codigo"));
                donoRetorno.setNome(rs.getString("nome"));
                donoRetorno.setCpf(rs.getString("cpf"));
                donoRetorno.setEmail(rs.getString("email"));
                donoRetorno.setTelefoneCelular(rs.getString("tel_celular"));
                donoRetorno.setTelefoneResidencial(rs.getString("tel_residencial"));
                donoRetorno.setDataNascimento(new Date(rs.getDate("data_nascimento").getTime()));
                
                // consulta animais de um dono
                AnimalRN rn = new AnimalRN();
                donoRetorno.setAnimais(rn.consultarPorDono(donoRetorno));
            }
            logger.debug("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }

        return donoRetorno;
    }

}
