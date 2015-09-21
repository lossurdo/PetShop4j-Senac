package com.senac.commons;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

/**
 *
 * @author lossurdo
 */
public class CommonsIOTest {

    @Test
    public void testFileUtils() throws IOException {
        // lê arquivo texto linha a linha
        for (String linha : FileUtils.readLines(new File("lorem.txt"))) {
            System.out.println(linha);
        }

        // lê arquivo diretamente para string
        String arquivo = FileUtils.readFileToString(new File("lorem.txt"));
        System.out.println(arquivo);

        // grava texto em arquivo
        FileUtils.writeStringToFile(new File("gravacao.txt"), "gravando em arquivo texto!!");

        /*
         Diversos outros métodos para tratamento de arquivos
         */
    }

    @Test
    public void testFileSystemUtils() throws IOException {
        // tamanho disponível no disco
        long freeSpace = FileSystemUtils.freeSpaceKb();
        System.out.println(freeSpace);
    }
}
