package com.senac.commons;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 *
 * @author lossurdo
 */
public class CommonsCodec {

    @Test
    public void testDigest() {
        // conversão de string em MD5
        System.out.println(DigestUtils.md5Hex("minha_senha"));
    }
    
    @Test
    public void testBinary() {
        // conversão de string em base 64
        System.out.println(Base64.encodeBase64String("binário de um JPG".getBytes()));
    }
    
}
