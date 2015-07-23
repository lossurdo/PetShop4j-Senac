package com.senac.petshop.app;

import com.senac.petshop.util.Console;
import com.senac.petshop.util.MenuConsole;

/**
 *
 * @author lossurdo
 */
public class App {

    public static void main(String[] args) throws Exception {
        
        MenuConsole mc = new MenuConsole("PetShop4j Senac", 
                "Sistema utilizado na disciplina de LAB2 do Senac (ADS)",
                App.class);
        mc.adicionarAcao("Cadastrar Dono", "cadastrarDono");
        mc.adicionarAcao("Cadastrar Animal", "cadastrarAnimal");
        mc.adicionarAcao("Vincular Dono aos seus Animais", "vincularDonoAnimal");
        mc.adicionarAcao("Sair", "sair");

        System.out.println(mc.getTexto());

        Integer op = Console.lerInteger("Qual a sua opção:");

        mc.executarAcao(op);
               
    }
    
    public void cadastrarDono() {
        System.out.println("Método ok!");
    }
    
    public void sair() {
        System.exit(0);
    }
}
