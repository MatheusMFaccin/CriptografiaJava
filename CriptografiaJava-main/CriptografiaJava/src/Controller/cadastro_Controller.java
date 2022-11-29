/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import Model.UserDAO;
import View.Cadastro;

/**
 *
 * @author facci
 */
public class cadastro_Controller {
    private Cadastro cadastro;

    public cadastro_Controller(Cadastro cadastro) {
        this.cadastro = cadastro;
    }
    UserDAO dao = new UserDAO(); 
    public void initController(){
       cadastro.getButton_save().addActionListener(e->insertUser());
    }
    public void insertUser(){
        String name = cadastro.getInput_name().getText();
        String password = cadastro.getInput_Password().getText();
        String email = cadastro.getInput_email().getText();
        User user = new User(name,password,email);
        dao.inserirUsuario(user);
    }
}
