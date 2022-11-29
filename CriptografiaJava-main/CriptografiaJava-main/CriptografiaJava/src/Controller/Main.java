/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Cadastro;
import View.ListarUsuarios;

/**
 *
 * @author laboratorio
 */
public class Main {
    public static void main(String[] args ){
        ListarUsuarios listaUsuarios = new ListarUsuarios();
        Cadastro cadastro = new Cadastro();
        cadastro_Controller cc = new cadastro_Controller(cadastro);
        Listar_Controller lc = new Listar_Controller(listaUsuarios);
        Tela_Controller tc = new Tela_Controller(cadastro,listaUsuarios);
        tc.initController();
        cc.initController();
        lc.initController();
        cadastro.setVisible(true);
        
    }
}
