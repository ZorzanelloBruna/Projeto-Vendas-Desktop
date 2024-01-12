/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetovendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import projetovendas.jdbc.ConnectionFactory;
import projetovendas.model.Clientes;
import projetovendas.model.ItemVenda;
import projetovendas.model.Produtos;

/**
 *
 * @author Usuario
 */
public class ItemVendaDAO {
           private Connection con;

    public ItemVendaDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    //método que cadastra itens
    public void cadastraItem(ItemVenda obj){
          try {
            String sql = "insert into tb_itensvendas(venda_id, produto_id, qtd, subtotal) values (?,?,?,?)";
            //organizando as informações para irem p banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getVenda().getId());
            stmt.setInt(2, obj.getProduto().getId());
            stmt.setInt(3, obj.getQtd());
            stmt.setDouble(4, obj.getSubtotal());

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar a venda." + e);
        }
    }
    
    //método que lista itens de uma venda por id
      public List<ItemVenda> listarItensPorVenda(int vendaId) {
        try {
            //1 passo - criar a lista             
            List<ItemVenda> lista = new ArrayList<>();

            //2 passo -criar o comando sql,organizar e executar
            String sql = "select  i.id, p.descricao, i.qtd, p.preco, i.subtotal from tb_itensvendas as i "
                    + " inner join tb_produtos as p on(i.produto_id = p.id) where i.venda_id = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, vendaId);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ItemVenda itemVenda = new ItemVenda();
                Produtos produto = new Produtos();
                
                itemVenda.setId(rs.getInt("i.id"));
                produto.setDescricao(rs.getString("p.descricao"));
                itemVenda.setQtd(rs.getInt("i.qtd"));
                produto.setPreco(rs.getDouble("p.preco"));
                itemVenda.setSubtotal(rs.getDouble("i.subtotal"));   
                
                itemVenda.setProduto(produto);
                lista.add(itemVenda);
            }
            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os dados!" + e);
            return null;
        }
    }
}
