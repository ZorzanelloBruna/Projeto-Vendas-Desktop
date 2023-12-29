/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetovendas.dao;

import java.sql.Connection;
import projetovendas.jdbc.ConnectionFactory;

/**
 *
 * @author Usuario
 */
public class ProdutosDAO {
        private Connection con;

    public ProdutosDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
}
