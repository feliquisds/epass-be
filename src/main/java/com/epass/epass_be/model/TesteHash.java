package com.epass.epass_be.model;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// CRIEI PARA GERAR UMA SENHA HASH, PARA INSERIR MANUAL NO BANCO DE DADOS, IGUAL NO PHP...
public class TesteHash {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash = encoder.encode("1234");
        System.out.println(hash);
    }
}