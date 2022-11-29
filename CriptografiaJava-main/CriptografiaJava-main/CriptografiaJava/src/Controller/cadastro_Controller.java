/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import Model.UserDAO;
import View.Cadastro;
import javax.swing.JOptionPane;

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

    public void initController() {
        cadastro.getButton_save().addActionListener(e -> insertUser());
    }

    public void limparCampos() {
        cadastro.getInput_name().setText("");
        cadastro.getInput_Password().setText("");
        cadastro.getInput_email().setText("");
    }

    public int verificarNome(String nome) {
        if (nome.matches("[a-zA-Z\s]+") == false) {

            return 0;
        }
        return 1;
    }

    public int verificarCampos(String name, String password, String email) {
        if (name.isEmpty() || password.isEmpty() || email.isEmpty()) {

            return 0;
        }
        return 1;
    }

    public int verificarEmail(String email) {
        if (email.contains("@") == false) {
            
            return 0;
        }

        return 1;

    }

    public int verificarErros(String name, String password, String email) {
        
        int erroCampos = verificarCampos(name, password, email);
        int erroNome = verificarNome(name);
        int erroEmail = verificarEmail(email);
        
        
        if (erroCampos == 0) {
            JOptionPane.showMessageDialog(null, "preencha todos os campos");
            limparCampos();
            return 0;
        }
        if (erroNome == 0) {
            JOptionPane.showMessageDialog(null, "o campo nome so pode conter apenas letras");
            limparCampos();
            cadastro.getInput_name().requestFocus();
            return 0;
        }
        if (erroEmail == 0) {
            JOptionPane.showMessageDialog(null, "email invalido");
            limparCampos();
            cadastro.getInput_email().requestFocus();
            return 0;
        }
        return 1;

    }

    public void insertUser() {
        String name = cadastro.getInput_name().getText();
        String password = cadastro.getInput_Password().getText();
        String email = cadastro.getInput_email().getText();
        int erro = verificarErros(name, password, email);
        
        if (erro == 1) {
            User user = new User(name, password, email);
            dao.inserirUsuario(user);
            limparCampos();
        }

        return;
    }

}
