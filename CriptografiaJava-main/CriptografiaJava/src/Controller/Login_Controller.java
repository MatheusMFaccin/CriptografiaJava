/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.UserDAO;
import View.Logado;
import View.Login;

/**
 *
 * @author facci
 */
public class Login_Controller {
    Login login;
    Logado listarUsuario;
    public Login_Controller(Login login,Logado listarUsuario){
        this.login = login;
        this.listarUsuario = listarUsuario;
    }
    public void initController(){
        login.getButton_Login().addActionListener(e->verificarLogin());
    }
    public void verificarLogin(){
        UserDAO dao = new UserDAO();
        String nome = login.getInput_Nome().getText();
        String senha = login.getInput_Senha().getText();
        int verificador = dao.loginPessoa(nome, senha);
        if(verificador == 1){
            exibirListarUsuarios();
        }else if(verificador == 0){
            System.out.println("você errou a senha ou o nome tente novamente");
        }else{
            System.out.println("erro no codigo");
        }
    }
    public void exibirListarUsuarios(){
       listarUsuario.setVisible(true);
       login.dispose();       
   }
}
