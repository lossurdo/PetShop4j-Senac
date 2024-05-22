package com.senac.petshop.app;

import com.senac.petshop.bean.Animal;
import com.senac.petshop.bean.CorPredominante;
import com.senac.petshop.bean.Dono;
import com.senac.petshop.bean.TipoAnimal;
import com.senac.petshop.infra.Propriedades;
import com.senac.petshop.rn.AnimalRN;
import com.senac.petshop.rn.DonoRN;
import com.senac.petshop.util.Console;
import com.senac.petshop.util.MenuConsole;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;


/**
 *
 * @author lossurdo
 */
public class AppConsole {

    private static final Logger logger = Logger.getLogger(AppConsole.class.getName());
    
    public static void main(String[] args) throws Exception {
        // informação de versão do java que está rodando
        logger.info("Versão de Java: " + SystemUtils.JAVA_VERSION_FLOAT);
        logger.info("Java: " + SystemUtils.JAVA_VM_VENDOR);
        logger.info("Java instalado em: " + SystemUtils.JAVA_HOME);
        logger.info("Sistema operacional: " + SystemUtils.OS_NAME);
        
        // enquanto não optado por "sair"
        while (true) {
            MenuConsole mc = new MenuConsole(
                    Propriedades.getInstance().get("sistema.nome"),
                    Propriedades.getInstance().get("sistema.descricao"),
                    AppConsole.class); // exemplo de uso de Propriedades
            
            mc.adicionarAcao("Cadastrar Dono", "cadastrarDono");
            mc.adicionarAcao("Cadastrar Animal", "cadastrarAnimal");
            mc.adicionarAcao("Listar Animais vs. Donos", "listarTudo");
            mc.adicionarAcao("Sobre", "sobre");
            mc.adicionarAcao("Sair", "sair");

            System.out.println(mc.getTexto());

            Integer op = Console.lerInteger("Qual a sua opção:");

            mc.executarAcao(op);
        }

    }

    public void sobre() throws IOException {
        String txtSobre = FileUtils.readFileToString(new File("sobre.txt"));
        JOptionPane.showMessageDialog(null, txtSobre);
    }
    
    public void listarTudo() {
        Console.cabecalho("Listando Animais vs. Donos");
        DonoRN rn = new DonoRN();
        for (Dono dono : rn.pesquisar("")) {
            logger.info(dono.toString());
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

            // formatando nome do animal
            nome = StringUtils.capitalize(nome);

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

        DonoRN rn = new DonoRN();
        try {
            rn.salvar(dono);
            logger.info("Dono cadastrado com sucesso!");
        } catch (Exception e) {
            logger.severe("Problema no cadastramento: " + e.getMessage());
        }
    }

    public void cadastrarAnimal() throws Exception {
        Console.cabecalho("Cadastro de Animal");

        // dados do dono pra leitura via teclado
        Integer codigo;
        String nome;
        Date dataNascimento;
        String txtTipo;
        TipoAnimal tipoAnimal;
        String descricao;
        String txtCor;
        CorPredominante corPredominante;
        Dono dono;

        boolean cadastroOK = true;
        do {
            codigo = Console.lerInteger("Código");
            nome = Console.lerString("Nome");
            
            // formatando nome do animal
            nome = StringUtils.capitalize(nome);
            
            String dataNascimentoTexto = Console.lerString("Data de Nascimento (ex. 31/12/2015)");
            dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoTexto);

            txtTipo = Console.lerEnum("Tipo", TipoAnimal.class);
            tipoAnimal = TipoAnimal.valueOf(txtTipo);
            descricao = Console.lerString("Descrição");
            txtCor = Console.lerEnum("Cor", CorPredominante.class);
            corPredominante = CorPredominante.valueOf(txtCor);

            Console.mensagem("Listagem de Donos");
            HashMap<Integer, Dono> hm = new HashMap<>();
            int o = 1;
            DonoRN donoRN = new DonoRN();
            for (Dono d : donoRN.pesquisar("")) {
                Console.mensagem(o + "-" + d.getNome());
                hm.put(o, d);
                o++;
            }
            int opcao = Console.lerInteger("Qual a sua opção?");
            dono = hm.get(opcao);

            Animal a = new Animal();
            a.setCodigo(codigo);
            a.setNome(nome);
            a.setDataNascimento(dataNascimento);
            a.setDescricao(descricao);
            a.setCorPredominante(corPredominante);
            a.setTipoAnimal(tipoAnimal);

            // vinculando dono ao animal
            a.setDono(dono);

            AnimalRN rn = new AnimalRN();
            try {
                rn.salvar(a);
                logger.info("Animal cadastrado e vinculado ao seu Dono com sucesso!");
            } catch (Exception e) {
                logger.severe("Problema no cadastramento: " + e.getMessage());
            }
        } while (!cadastroOK);
    }

    public void sair() {
        System.exit(0);
    }
}
