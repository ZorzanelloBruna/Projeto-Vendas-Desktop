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
import projetovendas.model.Clientes;
import projetovendas.model.Fornecedores;

/**
 *
 * @author Usuario
 */
public class FornecedoresDAO {

    private Connection con;

    public FornecedoresDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void cadastrarFornecedores(Fornecedores obj) {

        try {
            //1° passo - criar comamndo sql
            String sql = " insert into tb_fornecedores(nome, cnpj ,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?)";

            //2° passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getEstado());

            //3° passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastro realizado com Sucesso!!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar o cadastro." + e);
        }
    }

    public void excluirFornecedor(Fornecedores obj) {
        try {
            //1° passo - criar comamndo sql
            String sql = " delete from tb_fornecedores where id=?";

            //2° passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            //3° passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuário." + e);
        }
    }

    public void alterarFornecedor(Fornecedores obj) {
        try {
            //1° passo - criar comamndo sql
            String sql = " update tb_fornecedores set nome=?, cnpj=?,email=?,telefone=?,celular=?,cep=?,endereco=?,numero=?,complemento=?,"
                    + "bairro=?,cidade=?,estado=?  where id=?";

            //2° passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getEstado());
            stmt.setInt(13, obj.getId());

            //3° passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alteração realizada com Sucesso!!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar alteração." + e);
        }
    }
    
        public List<Fornecedores> listarFornecedoreses() {

        try {

            //1 passo - criar a lista             
            List<Fornecedores> lista = new ArrayList<>();

            //2 passo -criar o comando sql,organizar e executar
            String sql = "select * from tb_fornecedores";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedores obj = new Fornecedores();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));

                lista.add(obj);
            }
            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os dados!" + e);
            return null;
        }
    }
           //metodo consulta cliente por nome

    public Fornecedores consultaPorNome(String nome) {
        Fornecedores obj = new Fornecedores();
        try {
            //1 passo -criar o comando sql,organizar e executar
            String sql = "select * from tb_fornecedores where nome =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
            }
            return obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado" + e);
            return null;
        }
    }
    
       //método buscar cliente por nome
    public List<Fornecedores> buscarPorNome(String nome) {
        try {
            //1 passo - criar a lista             
            List<Fornecedores> lista = new ArrayList<>();

            //2 passo -criar o comando sql,organizar e executar
            String sql = "select * from tb_fornecedores where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedores obj = new Fornecedores();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));

                lista.add(obj);
            }
            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os dados!" + e);
            return null;
        }
    }
}
