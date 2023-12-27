/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetovendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
