package com.senac.petshop.bd;

import com.senac.petshop.bean.Procedimento;
import com.senac.petshop.infra.CrudBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lossurdo
 */
public class ProcedimentoBD extends CrudBD<Procedimento> {

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
        List<Procedimento> lista = new ArrayList<>();

        // definição do SQL com base nos dados informados para pesquisa
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT *  ");
        sql.append("FROM procedimento  ");
        sql.append("WHERE ");
        sql.append("nome like ? ");

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1, "%" + pesquisa + "%");

            logger.debug("Pesquisando: " + pesquisa);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                logger.debug("Registro encontrado");

                Procedimento p = new Procedimento();
                p.setCodigo(rs.getInt("codigo"));
                p.setDescricao(rs.getString("descricao"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setAtivo(rs.getBoolean("ativo"));
                
                lista.add(p);
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
