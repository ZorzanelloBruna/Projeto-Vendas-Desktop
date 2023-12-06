/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetovendas.jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class TestaConexao {
    
    public static void main(String[] args) {
        
        try {
            
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null,"Conectado com Sucesso!!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Ops! aconteceu um erro " + e);
        }
    }
    
}
