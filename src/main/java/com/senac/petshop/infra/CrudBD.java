package com.senac.petshop.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;


/**
 * Classe que, posteriormente, será utilizada para armazenar dados de conexão
 * com banco de dados.
 *
 * @author lossurdo
 */
public abstract class CrudBD<T> implements Crud<T> {

    protected static final Logger logger = Logger.getLogger(CrudBD.class.getName());

    protected final String BD_STRING_CONEXAO = Propriedades.getInstance().get("db.string");
    protected final String BD_USERNAME = Propriedades.getInstance().get("db.user");
    protected final String BD_PASSWORD = Propriedades.getInstance().get("db.pass");

    public CrudBD() {
        try {
            logger.info("Identificando Driver JDBC");
            Class.forName(Propriedades.getInstance().get("db.driver"));
            logger.info("Driver JDBC identificado com sucesso");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Connection abrirConexao() {
        try {
            logger.info("Abrindo a conexão com o banco de dados");
            final Connection conexao = DriverManager.getConnection(BD_STRING_CONEXAO, BD_USERNAME, BD_PASSWORD);

            /*
             Desliga o commit automático, deixando este controle 
             para o desenvolvedor...
             */
            conexao.setAutoCommit(false);

            return conexao;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            logger.info("Conexão com o banco de dados aberta com sucesso!");
        }
    }

    protected void fecharConexao(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
                logger.info("Conexão com o banco de dados encerrada com sucesso");
            }
        } catch (Exception e) {
            logger.severe("Problema ao fechar conexão com banco de dados: " + e.getMessage());
        }
    }

    protected void commitTransacao(Connection connection) {
        if (connection != null) {
            try {
                connection.commit();
                logger.info("COMMIT da transação efetuado");
            } catch (SQLException ex) {
                logger.severe("Problema ao efetuar COMMIT no banco de dados: " + ex.getMessage());
            }
        }
    }

    protected void rollbackTransacao(Connection connection) {
        if (connection != null) {
            try {
                connection.rollback();
                logger.info("ROLLBACK da transação efetuado");
            } catch (SQLException ex) {
                logger.severe("Problema ao efetuar ROLLBACK no banco de dados: " + ex.getMessage());
            }
        }
    }
}
