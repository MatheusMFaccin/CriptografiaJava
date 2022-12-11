/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import ConnectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
