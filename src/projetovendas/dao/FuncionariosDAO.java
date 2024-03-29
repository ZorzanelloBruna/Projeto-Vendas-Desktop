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
import projetovendas.model.Funcionarios;
import projetovendas.view.FrmLogin;
import projetovendas.view.FrmMenu;

/**
 *
 * @author Usuario
 */
public class FuncionariosDAO {
    //Conexão
    private Connection con;

    public FuncionariosDAO() {
        this.con =  new ConnectionFactory().getConnection();
    }    
    //Método Cadastrar Funcionário
    public void cadastrarFuncionario(Funcionarios obj) {
        try {
            //1° passo - criar comamndo sql
            String sql = " insert into tb_funcionarios(nome, rg, cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            //2° passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getEstado());

            //3° passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastro realizado com Sucesso!!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar o cadastro." + e);
        }

    }
        
    //Método alterar dados do Funcionário
    public void alterarFuncionario(Funcionarios obj) {
        try {
            //1° passo - criar comamndo sql
            String sql = " update tb_funcionarios set nome=?, rg=?, cpf=?,email=?,senha=?,cargo=?,nivel_acesso=?,telefone=?,celular=?,cep=?,endereco=?,numero=?,complemento=?,"
                    + "bairro=?,cidade=?,estado=?  where id=?";

            //2° passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getEstado());
            stmt.setInt(17, obj.getId());

            //3° passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alteração realizada com Sucesso!!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar alteração." + e);
        }
    }
      //LISTAR FUNCIONÁRIOS 
        public List<Funcionarios> listarFuncionarios(){
        try {
            //1 passo - criar a lista             
            List<Funcionarios> lista = new ArrayList<>();

            //2 passo -criar o comando sql,organizar e executar
            String sql = "select * from tb_funcionarios";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionarios obj = new Funcionarios();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
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
    //Excluir Dados funcionário
    public void excluirFuncionario(Funcionarios obj) {
        try {
            //1° passo - criar comamndo sql
            String sql = " delete from tb_funcionarios where id=?";

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
    
    //metodo pesquisar por nome
     public Funcionarios consultaPorNome(String nome) {
        Funcionarios obj = new Funcionarios();
        try {
            //1 passo -criar o comando sql,organizar e executar
            String sql = "select * from tb_funcionarios where nome =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
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
        //método buscar funcionario por nome
    public List<Funcionarios> buscarFuncionarioPorNome(String nome) {
        try {
            //1 passo - criar a lista             
            List<Funcionarios> lista = new ArrayList<>();

            //2 passo -criar o comando sql,organizar e executar
            String sql = "select * from tb_funcionarios where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionarios obj = new Funcionarios();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                 obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
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
    
    //Método efetuar login
    public void efetuarLogin(String email, String senha) {
        try {
            //comando sql
            String sql = "select * from tb_funcionarios where email=? and senha=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);

            //toda vez que se usa um select deve-se usar o ResultSet
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                //usuario logou - usuario admin
                if (rs.getString("nivel_acesso").equals("Admin")) {
                    JOptionPane.showMessageDialog(null, "Seja bem vido ao sistema!");
                    //comando para aparecer menu após efetuar login
                    FrmMenu tela = new FrmMenu();
                    tela.usuarioLogado = rs.getString("nome"); //pegando o nome do usuário logado para aparecer na tela do menuprincipal
                    tela.setVisible(true);
                    //usuario do tipo limitado
                } else if (rs.getString("nivel_acesso").equals("Usuário")) {
                    JOptionPane.showMessageDialog(null, "Seja bem vido ao sistema!");
                    //comando para aparecer menu após efetuar login
                    FrmMenu tela = new FrmMenu();
                    tela.usuarioLogado = rs.getString("nome"); //pegando o nome do usuário logado para aparecer na tela do menuprincipal
                    //desabilitar os menus
                    tela.menuPosicao.setEnabled(false);
                    tela.menuHistoricoVendas.setVisible(false);
                    
                    tela.setVisible(true);
                }

            } else {
                //Dados incoretos
                JOptionPane.showMessageDialog(null, "Dados incorretos, impossível efetuar login!");
                new FrmLogin().setVisible(true);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
}
