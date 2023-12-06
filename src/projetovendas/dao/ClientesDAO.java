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

/**
 *
 * @author Usuario
 */
public class ClientesDAO {
    
    private Connection con;
    
    public ClientesDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    public void cadastrarCilente(Clientes obj){
        
        try {
            //1° passo - criar comamndo sql
            String sql = " insert into tb_clientes(nome, rg, cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                                                                 + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            //2° passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());
            
            //3° passo - executar o comando sql
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Cadastro realizado com Sucesso!!");
            
        } catch (SQLException e) {
              JOptionPane.showMessageDialog(null,"Erro ao realizar o cadastro." + e);
        }
        
    }
    
      public void alterarCilente(Clientes obj){
        try {
            //1° passo - criar comamndo sql
            String sql = " update tb_clientes set nome=?, rg=?, cpf=?,email=?,telefone=?,celular=?,cep=?,endereco=?,numero=?,complemento=?,"
                    + "bairro=?,cidade=?,estado=?  where id=?";
            
            //2° passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());
            stmt.setInt(14, obj.getId());
            
            //3° passo - executar o comando sql
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Alteração realizada com Sucesso!!");
            
        } catch (SQLException e) {
              JOptionPane.showMessageDialog(null,"Erro ao realizar alteração." + e);
        }
    }
    
     public void excluirCilente(Clientes obj){
        try {
            //1° passo - criar comamndo sql
            String sql = " delete from tb_clientes where id=?";
            
            //2° passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
                       
            //3° passo - executar o comando sql
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Excluido com Sucesso!!");
            
        } catch (SQLException e) {
              JOptionPane.showMessageDialog(null,"Erro ao excluir usuário." + e);
        }
    }
     
     public List<Clientes> listarCliente(){
         
         try {
             
             //1 passo - criar a lista             
             List<Clientes> lista = new ArrayList<>();
             
             //2 passo -criar o comando sql,organizar e executar
             String sql = "select * from tb_clientes";
             PreparedStatement stmt = con.prepareStatement(sql);             
             ResultSet rs = stmt.executeQuery();
             
             while(rs.next()){
                 Clientes obj = new Clientes();
                 obj.setId(rs.getInt("id"));
                 obj.setNome(rs.getString("nome"));
                 obj.setRg(rs.getString("rg"));
                 obj.setCpf(rs.getString("cpf"));
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
             return  lista;
             
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro ao listar os dados!" + e);
             return null;
         }
         
     }
    
}
