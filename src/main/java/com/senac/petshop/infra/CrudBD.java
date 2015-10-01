package com.senac.petshop.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 * Classe que, posteriormente, será utilizada para armazenar dados de conexão
 * com banco de dados.
 *
 * @author lossurdo
 */
public abstract class CrudBD<T> implements Crud<T> {

    private static final Logger logger = Logger.getLogger(CrudBD.class);

    protected final String BD_STRING_CONEXAO = Propriedades.getInstance().get("db.string");
    protected final String BD_USERNAME = Propriedades.getInstance().get("db.user");
    protected final String BD_PASSWORD = Propriedades.getInstance().get("db.pass");

    public CrudBD() {
        try {
            logger.debug("Identificando Driver JDBC");
            Class.forName(Propriedades.getInstance().get("db.driver"));
            logger.debug("Driver JDBC identificado com sucesso");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Connection abrirConexao() {
        try {
            logger.debug("Abrindo a conexão com o banco de dados");
            return DriverManager.getConnection(BD_STRING_CONEXAO, BD_USERNAME, BD_PASSWORD);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            logger.debug("Conexão com o banco de dados aberta com sucesso!");
        }
    }

    protected void fecharConexao(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            logger.error("Problema ao fechar conexão com banco de dados", e);
        }
    }
}
