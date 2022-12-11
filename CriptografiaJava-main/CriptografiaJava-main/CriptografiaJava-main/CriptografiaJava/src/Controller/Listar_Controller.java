/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import Model.UserDAO;
import View.Listar;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author facci
 */
public class Listar_Controller {
    Listar listar;
    UserDAO dao = new UserDAO();
    public Listar_Controller(Listar listarUsuarios) {
        this.listar = listarUsuarios;
    }
    
    public void initController(){
        listar.getButton_Listar().addActionListener(e->listarUsuarios());
    }
    public void listarUsuarios(){
        ArrayList<User> listaUsuarios = dao.listarUsuarios();
        DefaultTableModel model = ((DefaultTableModel) listar.getTabela().getModel());
        
        for(int i= 0; i<listaUsuarios.size();i++){
            model.addRow(new String[] {
            listaUsuarios.get(i).getNome(),
            listaUsuarios.get(i).getSenha(),
            listaUsuarios.get(i).getEmail()});
        }
    }
}
