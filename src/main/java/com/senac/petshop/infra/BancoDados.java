package com.senac.petshop.infra;

import com.senac.petshop.bean.Agenda;
import com.senac.petshop.bean.Animal;
import com.senac.petshop.bean.Dono;
import com.senac.petshop.bean.Procedimento;
import java.util.HashSet;

/**
 * Simulação intermediária para persistência
 * em banco de dados. Posteriormente será
 * utilizada a conexão JDBC.
 * 
 * Exemplo do Design Pattern: Singleton
 * https://sourcemaking.com/design_patterns/singleton
 * 
 * @author lossurdo
 */
public class BancoDados {
    
    private static HashSet<Agenda> listaAgenda;
    private static HashSet<Animal> listaAnimal;
    private static HashSet<Dono> listaDono;
    private static HashSet<Procedimento> listaProcedimento;
    
    private BancoDados() {
        listaAgenda = new HashSet<>();
        listaAnimal = new HashSet<>();
        listaDono = new HashSet<>();
        listaProcedimento = new HashSet<>();
    }
    
    public static BancoDados getInstance() {
        return BancoDadosHolder.INSTANCE;
    }
    
    private static class BancoDadosHolder {
        private static final BancoDados INSTANCE = new BancoDados();
    }

    public HashSet<Agenda> getListaAgenda() {
        return listaAgenda;
    }

    public HashSet<Animal> getListaAnimal() {
        return listaAnimal;
    }

    public HashSet<Dono> getListaDono() {
        return listaDono;
    }

    public HashSet<Procedimento> getListaProcedimento() {
        return listaProcedimento;
    }
        
}
