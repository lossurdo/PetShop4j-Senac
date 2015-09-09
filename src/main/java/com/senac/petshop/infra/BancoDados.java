package com.senac.petshop.infra;

import com.senac.petshop.bean.Agenda;
import com.senac.petshop.bean.Animal;
import com.senac.petshop.bean.Dono;
import com.senac.petshop.bean.Procedimento;
import java.util.ArrayList;
import java.util.List;

/**
 * Simulação intermediária para persistência
 * em banco de dados. Posteriormente será
 * utilizada a conexão JDBC.
 * 
 * @author lossurdo
 */
public class BancoDados {
    
    private static List<Agenda> listaAgenda;
    private static List<Animal> listaAnimal;
    private static List<Dono> listaDono;
    private static List<Procedimento> listaProcedimento;
    
    private BancoDados() {
        listaAgenda = new ArrayList<>();
        listaAnimal = new ArrayList<>();
        listaDono = new ArrayList<>();
        listaProcedimento = new ArrayList<>();
    }
    
    public static BancoDados getInstance() {
        return BancoDadosHolder.INSTANCE;
    }
    
    private static class BancoDadosHolder {
        private static final BancoDados INSTANCE = new BancoDados();
    }

    public List<Agenda> getListaAgenda() {
        return listaAgenda;
    }

    public List<Animal> getListaAnimal() {
        return listaAnimal;
    }

    public List<Dono> getListaDono() {
        return listaDono;
    }

    public List<Procedimento> getListaProcedimento() {
        return listaProcedimento;
    }
        
}
