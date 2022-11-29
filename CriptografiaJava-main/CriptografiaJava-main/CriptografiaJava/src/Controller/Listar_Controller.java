/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import Model.UserDAO;
import View.ListarUsuarios;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author laboratorio
 */
public class Listar_Controller {
    ListarUsuarios listarUsuarios;
    public Listar_Controller(ListarUsuarios listarUsuarios){
        this.listarUsuarios = listarUsuarios;
    }
    public void initController(){
        listarUsuarios.getButton_Listar().addActionListener(e->exibirUsuarios());
    }
    public void exibirUsuarios(){
        UserDAO dao = new UserDAO();
        ArrayList<User> lista = dao.listarUsuario();
        DefaultTableModel model = ((DefaultTableModel) listarUsuarios.getTabela().getModel());
        //Limpar as linhas da tabela
        model.setRowCount(0);
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new String[]{
                lista.get(i).getNome(),
                lista.get(i).getSenha(),
                lista.get(i).getEmail()});
        }
    }
}
