/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import CriptografiaRSA.Arquivo;
import CriptografiaRSA.RSA;
import View.Cadastro;
import View.Logado;
import View.Login;
import java.math.BigInteger;

/**
 *
 * @author laboratorio
 */
public class Main {
    public static void main(String[] args ){
        /*RSA rsa = new RSA(100);
        rsa.salvarChaves();*/
        
        
        Logado listaUsuarios = new Logado();
        Cadastro cadastro = new Cadastro();
        Login login = new Login();
        cadastro_Controller cadastro_controller = new cadastro_Controller(cadastro);
        Login_Controller login_controller = new Login_Controller(login,listaUsuarios);  
        Tela_Controller tela_controller = new Tela_Controller(cadastro,listaUsuarios,login);
        tela_controller.initController();
        cadastro_controller.initController();
        login_controller.initController();
        cadastro.setVisible(true);
        
        
    }
}
