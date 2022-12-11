/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Cadastro;
import View.Listar;
import View.Login;

/**
 *
 * @author laboratorio
 */
public class Tela_Controller {
   Cadastro cadastro;
   Listar listarUsuarios;
   Login login;
   public Tela_Controller(Cadastro cadastro, Listar listarUsuarios,Login login){
       this.cadastro = cadastro;
       this.listarUsuarios = listarUsuarios;
       this.login = login;
   }
   public void initController(){
       cadastro.getButton_Tabela().addActionListener(e->exibirLogin());
       listarUsuarios.getButton_voltar().addActionListener(e->exibirLogin());
       login.getButton_Cadastro().addActionListener(e->exibirCadastro());
   }
   
   public void exibirCadastro(){
       cadastro.setVisible(true);
       login.dispose();
   }
   public void exibirLogin(){
       login.setVisible(true);
       listarUsuarios.dispose();
       cadastro.dispose();
   }
}
