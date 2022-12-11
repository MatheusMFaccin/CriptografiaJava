/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import CriptografiaRSA.Arquivo;
import CriptografiaRSA.RSA;
import View.Cadastro;
import View.Listar;
import View.Login;
import java.math.BigInteger;

/**
 *
 * @author laboratorio
 */
public class Main {
    public static void main(String[] args ){
        
        
        
        Listar listaUsuarios = new Listar();
        Cadastro cadastro = new Cadastro();
        Login login = new Login();
        cadastro_Controller cadastro_controller = new cadastro_Controller(cadastro);
        Login_Controller login_controller = new Login_Controller(login,listaUsuarios);  
        Tela_Controller tela_controller = new Tela_Controller(cadastro,listaUsuarios,login);
        Listar_Controller listar_Controller = new Listar_Controller(listaUsuarios);
        tela_controller.initController();
        cadastro_controller.initController();
        login_controller.initController();
        listar_Controller.initController();
       
        cadastro.setVisible(true);
        
        
    }
}
