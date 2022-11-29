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
public class Tela_Controller {
   Cadastro cadastro;
   ListarUsuarios listarUsuarios;
   public Tela_Controller(Cadastro cadastro, ListarUsuarios listarUsuarios){
       this.cadastro = cadastro;
       this.listarUsuarios = listarUsuarios;
   }
   public void initController(){
       cadastro.getButton_Tabela().addActionListener(e->exibirListarUsuarios());
       listarUsuarios.getButton_voltar().addActionListener(e->exibirCadastro());
   }
   public void exibirListarUsuarios(){
       listarUsuarios.setVisible(true);
       cadastro.dispose();
       
   }
   public void exibirCadastro(){
       cadastro.setVisible(true);
       listarUsuarios.dispose();
   }
}
