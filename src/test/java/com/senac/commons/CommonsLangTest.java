package com.senac.commons;

import java.util.Calendar;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.WordUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.junit.Test;

/**
 *
 * @author lossurdo
 */
public class CommonsLangTest {

    @Test
    public void testWordUtils() {
        // capitaliza primeiras letras
        System.out.println(WordUtils.capitalize("joão da SILVA"));
        // capitaliza primeiras e coloca em minúsculo as outras
        System.out.println(WordUtils.capitalizeFully("joão da SILVA"));
    }

    @Test
    public void testValidate() {
        // valida não nulo lançando exceção
        String texto = "game of thrones";
        Validate.notNull(texto);
        
        // valida condição verdadeira lançando exceção
        Validate.isTrue(texto.equals("game of thrones"), 
                "Variável 'texto' diferente do esperado");
    }
    
    @Test
    public void testStringUtils() {
        // centraliza no tamanho definido
        System.out.println(StringUtils.center("HelloWorld", 80));
        
        // conta palavras
        System.out.println(StringUtils.countMatches("HelloWorld", "l"));
        
        // compara valores similares
        System.out.println(StringUtils.getLevenshteinDistance("game of thrones", "game of trones"));

        // inverte string
        System.out.println(StringUtils.reverse("Anotaram a Data da Maratona"));
        System.out.println(StringUtils.reverse("Socorram-me! Subi no ônibus em Marrocos!"));
     
        // valida somente letras
        System.out.println(StringUtils.isAlpha("abc123abc"));
        System.out.println(StringUtils.isAlpha("abcXXXabc"));

        // preenche zeros à esquerda
        System.out.println(StringUtils.leftPad("123", 10, "0"));
        
        // repete um texto n vezes
        System.out.println(StringUtils.repeat("¡Hola que tal! ", 5));
    }
    
    @Test
    public void testSystemUtils() {
        // onde fica o java instalado?
        System.out.println(SystemUtils.getJavaHome().toString());
    }
    
    @Test
    public void testNumberUtils() {
        // valida se String é numérica
        System.out.println(NumberUtils.isNumber("123.55"));
    }
    
    @Test
    public void testExceptionUtils() {
        try {
            double x = 10 / 0;
        } catch (Exception e) {
            // retorna string contendo stacktrace da exceção
            System.out.println(ExceptionUtils.getFullStackTrace(e));
        }
    }
    
    @Test
    public void testDateTime() {
        Calendar cal = Calendar.getInstance();
        
        // formata uma data
        System.out.println(DateFormatUtils.format(cal, "dd/MM/yyyy HH:mm"));

        // adiciona uma hora à data
        System.out.println(DateFormatUtils.format(DateUtils.addHours(cal.getTime(), 1), "dd/MM/yyyy HH:mm"));
        
        // transforma millis em h:m:s...
        // 0:01:05.465
        System.out.println(DurationFormatUtils.formatDurationHMS(65465));
    }
}
