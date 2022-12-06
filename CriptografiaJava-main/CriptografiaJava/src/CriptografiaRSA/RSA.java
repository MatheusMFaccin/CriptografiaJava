package CriptografiaRSA;

import java.math.BigInteger;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author facci
 */
public class RSA {

    int tamanhoPrimo = 100;
    BigInteger n, q, p;
    BigInteger z;
    BigInteger e;
    BigInteger d;

    public void inicializarChaves() {
        Arquivo arquivo = new Arquivo();
        String[] chaves = arquivo.pegarChavesArquivo();
        n = new BigInteger(chaves[0]);
        e = new BigInteger(chaves[1]);

    }

    public void gerarPrimos() {
        p = new BigInteger(tamanhoPrimo, 10, new Random());

        do {
            q = new BigInteger(tamanhoPrimo, 10, new Random());
        } while (q.compareTo(p) == 0);

    }

    public void gerarChaves() {
        gerarPrimos();
        //n = p * q;
        n = p.multiply(q);
        //z = (p - 1) * (q - 1);
        z = p.subtract(BigInteger.valueOf(1));
        z = z.multiply(q.subtract(BigInteger.valueOf(1)));
        do {
            e = new BigInteger(tamanhoPrimo * 2, new Random());

        } while ((e.compareTo(z) != -1) || (e.gcd(z).compareTo(BigInteger.valueOf(1)) != 0));

        d = e.modInverse(z);

    }

    public String encriptar(String menssagem) {
        int i;
        byte[] temp = new byte[1];
        byte[] digitos = menssagem.getBytes();
        String senha = new String(digitos);
        BigInteger[] bigdigitos = new BigInteger[digitos.length];
        inicializarChaves();
        String menssagemBytes = juntarBytes(digitos);
        BigInteger encriptador = new BigInteger(menssagemBytes);
        String encriptado = encriptador.modPow(e, n) + "";

        return encriptado;
    }
    /*public String descriptar(String encriptado){
        BigInteger numerosCriptografados = new BigInteger(encriptado);
        BigInteger numerosDescriptografados = numerosCriptografados.modPow(d, n);
        String numerosString = numerosDescriptografados.toString();
        //int[] numerosInt = numerosString.split("[2][5][6][2][5][7]");
        
    }*/

    public String juntarBytes(byte[] digitos) {
        String numero = "";
        for (int i = 0; i < digitos.length; i++) {
            //System.out.println(digitos[i]);
            numero = numero + digitos[i] + "";
        }
        return numero;
    }

}
