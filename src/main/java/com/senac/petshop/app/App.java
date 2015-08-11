package com.senac.petshop.app;

import com.senac.petshop.bean.Dono;
import com.senac.petshop.util.Console;
import com.senac.petshop.util.MenuConsole;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lossurdo
 */
public class App {

    private static ArrayList<Dono> listaDonoAnimal = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        // enquanto não optado por "sair"
        while (true) { 
            MenuConsole mc = new MenuConsole("PetShop4j Senac",
                    "Controle de Pet Shop (Desktop)",
                    App.class);
            mc.adicionarAcao("Cadastrar Dono", "cadastrarDono");
            mc.adicionarAcao("Cadastrar Animal", "cadastrarAnimal");
            mc.adicionarAcao("Vincular Dono aos seus Animais", "vincularDonoAnimal");
            mc.adicionarAcao("Listar Tudo", "listarTudo");
            mc.adicionarAcao("Sair", "sair");

            System.out.println(mc.getTexto());

            Integer op = Console.lerInteger("Qual a sua opção:");

            mc.executarAcao(op);
        }

    }

    public void listarTudo() {
        Console.cabecalho("Listando Tudo");
        for (Dono dono : listaDonoAnimal) {
            Console.mensagem(dono);
        }
    }
    
    public void cadastrarDono() throws Exception {
        Console.cabecalho("Cadastro de Dono");

        // dados do dono pra leitura via teclado
        Integer codigo;
        String nome;
        String cpf;
        String telefoneResidencial;
        String telefoneCelular;
        String email;
        Date dataNascimento;

        boolean cadastroOK = true;
        do {
            codigo = Console.lerInteger("Código");
            nome = Console.lerString("Nome");
            cpf = Console.lerString("CPF");
            telefoneResidencial = Console.lerString("Tel. Residencial");
            telefoneCelular = Console.lerString("Tel. Celular");
            email = Console.lerString("Email");
            String dataNascimentoTexto = Console.lerString("Data de Nascimento (ex. 31/12/2015)");
            dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoTexto);
        } while (!cadastroOK);

        Dono dono = new Dono();
        dono.setCodigo(codigo);
        dono.setNome(nome);
        dono.setCpf(cpf);
        dono.setEmail(email);
        dono.setTelefoneCelular(telefoneCelular);
        dono.setTelefoneResidencial(telefoneResidencial);
        dono.setDataNascimento(dataNascimento);

        listaDonoAnimal.add(dono);

        Console.mensagem("Dono cadastrado com sucesso!");
    }

    public void sair() {
        System.exit(0);
    }
}
