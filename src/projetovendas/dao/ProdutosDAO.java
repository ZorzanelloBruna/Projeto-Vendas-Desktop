/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetovendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import projetovendas.jdbc.ConnectionFactory;
import projetovendas.model.Produtos;

/**
 *
 * @author Usuario
 */
public class ProdutosDAO {

    private Connection con;

    public ProdutosDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void cadastrar(Produtos obj) {
        try {
            String sql = "insert into tb_produtos(descricao, preco, qtd_estoque,for_id) values (?,?,?,?)";
            //organizando as informações para irem p banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQdeEstoque());
            stmt.setInt(4, obj.getFornecedor().getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto cadastrado com Sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o Produto." + e);
        }
    }
}
