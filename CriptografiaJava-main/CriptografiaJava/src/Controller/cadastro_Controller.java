/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import ConnectionFactory.ConnectionFactory;
import Model.User;
import Model.UserDAO;
import View.Cadastro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Connection;

/**
 *
 * @author facci
 */
public class cadastro_Controller {

    private Cadastro cadastro;
    private Connection con;

    public cadastro_Controller(Cadastro cadastro) {
        this.cadastro = cadastro;
    }
    UserDAO dao = new UserDAO();

    public void initController() {
        cadastro.getButton_save().addActionListener(e -> insertUser());
    }

    public void limparCampos() {
        cadastro.getInput_name().setText("");
        cadastro.getInput_senha().setText("");
        cadastro.getInput_email().setText("");
    }

    public int verificarNomeCaracter(String nome) {
        if (nome.matches("[a-zA-Z0-9\\s]+") == false) {

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

    public int verificarNomeRepetido(String nome) {
        String select = "select id from cadastros where nome = ?";
        con = new ConnectionFactory().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(select);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return 0;
            }
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int verificarSenhaTamanho(String senha) {
        if (senha.length() < 5 || senha.length() > 15) {
            return 0;
        }
        return 1;
    }

    public int verificarSenhaCaracter(String senha) {
        if (senha.matches("[a-z0-9\\s]+") == true) {
            
            return 0;
        }
        return 1;
    }

    public int verificarErros(String nome, String senha, String email) {

        int erroCampos = verificarCampos(nome, senha, email);
        int erroNomeCaracter = verificarNomeCaracter(nome);
        int erroEmail = verificarEmail(email);
        int erroNomeRepetido = verificarNomeRepetido(nome);
        int erroSenhaTamanho = verificarSenhaTamanho(senha);
        int erroSenhaCaracter = verificarSenhaCaracter(senha);

        if (erroCampos == 0) {
            JOptionPane.showMessageDialog(null, "preencha todos os campos");
            limparCampos();
            return 0;
        } else if (erroNomeCaracter == 0) {
            JOptionPane.showMessageDialog(null, "o campo nome so pode conter apenas letras");
            limparCampos();
            cadastro.getInput_name().requestFocus();
            return 0;
        } else if (erroEmail == 0) {
            JOptionPane.showMessageDialog(null, "email invalido");
            limparCampos();
            cadastro.getInput_email().requestFocus();
            return 0;
        } else if (erroNomeRepetido == 0) {
            JOptionPane.showMessageDialog(null, "esse nome ja foi cadastrado");
            return 0;
        } else if(erroSenhaTamanho==0){
            JOptionPane.showMessageDialog(null,"a senha deve ter entre 5 a 15 caracteres");
            return 0;
        } else if(erroSenhaCaracter==0){
            JOptionPane.showMessageDialog(null, "a senha deve ter pelo menos uma letra "
                    + "maiuscula");
            return 0;
        }
        
        return 1;
        

    }

    public void insertUser() {
        String name = cadastro.getInput_name().getText();
        String password = cadastro.getInput_senha().getText();
        String email = cadastro.getInput_email().getText();
        int erro = verificarErros(name, password, email);

        if (erro == 1) {
            User user = new User(name, password, email);
            dao.inserirUsuario(user);

        }
        limparCampos();
        return;
    }

}
