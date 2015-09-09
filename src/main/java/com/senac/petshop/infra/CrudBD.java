package com.senac.petshop.infra;

/**
 * Classe que, posteriormente, será utilizada
 * para armazenar dados de conexão com banco de dados.
 * 
 * @author lossurdo
 */
public abstract class CrudBD<T> implements Crud<T> {

    protected final String BD_STRING_CONEXAO = "";
    protected final String BD_USERNAME = "";
    protected final String BD_PASSWORD = "";
    
    public CrudBD() {
        try {
            //Class.forName("");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
