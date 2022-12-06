package CriptografiaRSA;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author facci
 */
public class Arquivo {

    public void escreverChaves() {
        try {
            RSA rsa= new RSA();
            rsa.gerarChaves();   
            FileWriter myWriter = new FileWriter("chave.txt");
            myWriter.write(rsa.n + ";" + rsa.e);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException erro) {
            System.out.println("An error occurred.");
            erro.printStackTrace();
        }
    }

    public String[] pegarChavesArquivo() {
        try {
            File arquivo = new File("chave.txt");
           
            String data = "";
            if(!arquivo.exists()){
                escreverChaves();
            }
            Scanner myReader = new Scanner(arquivo);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                //System.out.println(data);
            }
            myReader.close();
            String[] chaves = data.split(";");
           
            return chaves;
        } catch (FileNotFoundException erro) {
            System.out.println("An error occurred.");
            erro.printStackTrace();
            return null;
        }
    }

}
