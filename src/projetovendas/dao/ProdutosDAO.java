/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetovendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import projetovendas.jdbc.ConnectionFactory;
import projetovendas.model.Fornecedores;
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

    public List<Produtos> listarProdutos() {
        try {
            //1 passo - criar a lista             
            List<Produtos> lista = new ArrayList<>();

            //2 passo -criar o comando sql,organizar e executar
            String sql = "select p.id, p.descricao, p.preco, p. qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id)";

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();

                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQdeEstoque(rs.getInt("p.qtd_estoque"));

                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);

                lista.add(obj);
            }
            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os dados!" + e);
            return null;
        }
    }
    
        public void alterar(Produtos obj) {
        try {
            String sql = "update tb_produtos set descricao=?, preco=?, qtd_estoque=?, for_id=? where id=?";
            //organizando as informações para irem p banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQdeEstoque());
            stmt.setInt(4, obj.getFornecedor().getId());
            
            stmt.setInt(5,obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto alterado com Sucesso");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar o Produto." + e);
        }
    }
    public void excluir(Produtos obj) {
        try {
            String sql = "delete from tb_produtos where id=?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getId());
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto excluido com Sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o produto." + e);
        }

    }    
       //metodo consulta cliente por nome
    public Produtos consultaPorNome(String nome) {
        Produtos obj = new Produtos();
        Fornecedores f = new Fornecedores();
        try {
            //1 passo -criar o comando sql,organizar e executar
            String sql = "select p.id, p.descricao, p.preco, p. qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getDouble("preco"));
                obj.setQdeEstoque(rs.getInt("qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);
            }
            return obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado" + e);
            return null;
        }
    }
       //metodo busca produto por código
    public Produtos buscaPorCodigo(int id) {
        Produtos obj = new Produtos();
        Fornecedores f = new Fornecedores();
        try {
            //1 passo -criar o comando sql,organizar e executar
            String sql = "select p.id, p.descricao, p.preco, p. qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.id like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getDouble("preco"));
                obj.setQdeEstoque(rs.getInt("qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);
            }
            return obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado" + e);
            return null;
        }
    }
    
    
     //método buscar cliente por nome
    public List<Produtos> buscarPorNome(String nome) {
        try {
            //1 passo - criar a lista             
            List<Produtos> lista = new ArrayList<>();
            
            //2 passo -criar o comando sql,organizar e executar
            String sql = "select p.id, p.descricao, p.preco, p. qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getDouble("preco"));
                obj.setQdeEstoque(rs.getInt("qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);
                lista.add(obj);
            }
            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os dados!" + e);
            return null;
        }
    }
}
