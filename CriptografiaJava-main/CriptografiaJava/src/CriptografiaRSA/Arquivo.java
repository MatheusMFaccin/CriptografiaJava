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

    public void escreverChaves(BigInteger d, BigInteger n, BigInteger e) {
        try {
            FileWriter myWriter = new FileWriter("chaves.txt");
            myWriter.write(d + ";" + n + ";" + e);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException erro) {
            System.out.println("An error occurred.");
            erro.printStackTrace();
        }
    }

    public String[] pegarChavesArquivo() {
        try {
            File myObj = new File("chaves.txt");
            Scanner myReader = new Scanner(myObj);
            String data = "";
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
