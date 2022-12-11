/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Cadastro;

/**
 *
 * @author laboratorio
 */
public class Main {
    public static void main(String[] args ){
        Tela_Controller tc = new Tela_Controller();
        Cadastro cadastro = new Cadastro();
        cadastro_Controller cc = new cadastro_Controller(cadastro);
        cc.initController();
        cadastro.setVisible(true);
        
    }
}
