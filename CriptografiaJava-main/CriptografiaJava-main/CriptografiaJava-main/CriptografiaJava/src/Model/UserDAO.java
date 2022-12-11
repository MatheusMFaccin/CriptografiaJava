/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import ConnectionFactory.ConnectionFactory;
import CriptografiaRSA.RSA;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author facci
 */
public class UserDAO {

    private Connection con;

    public void inserirUsuario(User usuario) {
        String inserir = "insert into cadastros (nome,senha,email) values(?,?,?)";
        con = new ConnectionFactory().getConnection();
        try {
            RSA rsa = new RSA();
            String encriptado = rsa.encriptarString(usuario.getSenha());
            PreparedStatement pst = con.prepareStatement(inserir);
            pst.setString(1, usuario.getNome());
            pst.setString(2, encriptado);
            pst.setString(3, usuario.getEmail());
            pst.execute();
            con.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  

    public int loginPessoa(String nome, String senha) {
        String select = "select id from cadastros where nome = ? and senha = ?";
        con = new ConnectionFactory().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(select);
            RSA rsa = new RSA();
            String senhaEncripto = rsa.encriptarString(senha);
            pst.setString(1, nome);
            pst.setString(2, senhaEncripto);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return 1;
            }

            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 12;
        }
    }
    
        public ArrayList<User> listarUsuarios(){
        //criar lista de funcionario
        ArrayList<User> listaUsuarios = new ArrayList();
        //declarar a query utilizada para retonar dados de funcioanrios
        String read = "select nome, senha, email from cadastros;";
        try {
            //abrir a conexão
            con = new ConnectionFactory().getConnection();
            //preparar a query para execução no banco de dados
            PreparedStatement pst = con.prepareStatement(read);
            //executar a query e armazena em um RS
            ResultSet rs = pst.executeQuery();
            //passando os valores contidos no RS para a lista de func.
            while(rs.next()){
             
                String nome = rs.getString(1);
                String senha = rs.getString(2);
                String email = rs.getString(3);
                //adicionar um novo funcionario a Lista
                listaUsuarios.add(new User(nome, senha, email));
            }
            con.close();
            return listaUsuarios;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } 
    }

    
}
