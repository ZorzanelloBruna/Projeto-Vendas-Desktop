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
import projetovendas.model.Vendas;

/**
 *
 * @author Usuario
 */
public class VendasDAO {
       private Connection con;

    public VendasDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    //cadastrar Venda
    public void cadastrarVenda(Vendas obj){
          try {
            String sql = "insert into tb_vendas(cliente_id, data_venda, total_venda, observacoes) values (?,?,?,?)";
            //organizando as informações para irem p banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getDataVendas());
            stmt.setDouble(3, obj.getTotalVenda());
            stmt.setString(4, obj.getObs());

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar a venda." + e);
        }
    }        
        //retorna a última venda
    public int retornaUltimaVenda() {
        try {
            int idVenda = 0;

            String sql = "select max(id) id from tb_vendas";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Vendas p = new Vendas();
                p.setId(rs.getInt("id"));
                idVenda = p.getId();
            }
            return idVenda;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //método que filtra venda por data
     public List<Vendas> listarVendasPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        try {
            //1 passo - criar a lista             
            List<Vendas> lista = new ArrayList<>();

            //2 passo -criar o comando sql,organizar e executar
            String sql = "select v.id, date_format(v.data_venda,  '%d/%m/%Y') as data_formatada , c.nome, v.total_venda, v.observacoes from tb_vendas as v "
                    + " inner join tb_clientes as c on(v.cliente_id = c.id) where v.data_venda between ? and ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, dataInicio.toString());
            stmt.setString(2, dataFim.toString());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Vendas obj = new Vendas();
                Clientes objClientes = new Clientes();
                
                obj.setId(rs.getInt("v.id"));
                obj.setDataVendas(rs.getString("data_formatada"));
                objClientes.setNome(rs.getString("c.nome"));
                obj.setTotalVenda(rs.getDouble("v.total_venda"));
                obj.setObs(rs.getString("observacoes"));
                
                obj.setCliente(objClientes);
                lista.add(obj);
            }
            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os dados!" + e);
            return null;
        }
    }
     
     //Método que calcula total da venda por data
     public double retornaTotalVendaPorData(LocalDate dataVenda){
         try {
             double totalVenda =0;
             String sql = "select sum(total_venda) as total from tb_vendas where data_venda=?";
             PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setString(1,dataVenda.toString());
             
             ResultSet rs = stmt.executeQuery();
             
             if(rs.next()){
                 totalVenda = rs.getDouble("total");
             }
             return totalVenda;
         } catch (SQLException e) {
            throw new RuntimeException();
         }
     }
}
