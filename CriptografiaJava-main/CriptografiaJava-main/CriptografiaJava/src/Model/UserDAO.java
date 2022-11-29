/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import ConnectionFactory.ConnectionFactory;
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
    
    public void inserirUsuario(User usuario){
        String inserir = "insert into cadastros (nome,senha,email) values(?,?,?)";
        con = new ConnectionFactory().getConnection();
        try{
            PreparedStatement pst = con.prepareStatement(inserir);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getSenha());
            pst.setString(3, usuario.getEmail());
            pst.execute();
            con.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<User> listarUsuario(){
        String listar = "select nome, senha, email from cadastros";
        con = new ConnectionFactory().getConnection();
        ArrayList<User> listaUsuario = new ArrayList<User>();
        try{
            PreparedStatement pst = con.prepareStatement(listar);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String nome = rs.getString(1);
                String senha = rs.getString(2);
                String email = rs.getString(3);
                User user = new User(nome,senha,email);
                listaUsuario.add(user);
            }
            return listaUsuario;
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
