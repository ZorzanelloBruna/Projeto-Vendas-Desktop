/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetovendas.view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projetovendas.dao.ClientesDAO;
import projetovendas.dao.FornecedoresDAO;
import projetovendas.dao.ProdutosDAO;
import projetovendas.model.Clientes;
import projetovendas.model.Fornecedores;
import projetovendas.model.Produtos;
import projetovendas.model.Utilitarios;

/**
 *
 * @author Usuario
 */
public class FrmProdutos extends javax.swing.JFrame {

    // método listar na tabela
    public void listarTabela() {

        ProdutosDAO dao = new ProdutosDAO();
        List<Produtos> lista = dao.listarProdutos();

        DefaultTableModel dados = (DefaultTableModel) tabelaproutos.getModel();
        dados.setNumRows(0);

        for (Produtos produto : lista) {
            dados.addRow(new Object[]{
                produto.getId(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getQdeEstoque(),
                produto.getFornecedor().getNome()
            });
        }
    }

    /**
     * Creates new form Frmcliente
     */
    public FrmProdutos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        paineldados = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtdescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtpreco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtestoque = new javax.swing.JTextField();
        txtcodigo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbfornecedor = new javax.swing.JComboBox();
        btnpesq = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtpesquisa = new javax.swing.JTextField();
        btnpesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaproutos = new javax.swing.JTable();
        btnnovo = new javax.swing.JButton();
        btnsalvar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btnexcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro de Produtos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        paineldados.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Descrição:");

        txtdescricao.setBackground(new java.awt.Color(255, 255, 255));
        txtdescricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtdescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescricaoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Código: ");

        txtpreco.setBackground(new java.awt.Color(255, 255, 255));
        txtpreco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Preço:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Qde Estoque:");

        txtestoque.setBackground(new java.awt.Color(255, 255, 255));
        txtestoque.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtcodigo.setEditable(false);
        txtcodigo.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Fornecedor:");

        cbfornecedor.setBackground(new java.awt.Color(255, 255, 255));
        cbfornecedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbfornecedor.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbfornecedorAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        btnpesq.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnpesq.setText("Pesquisar");
        btnpesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paineldadosLayout = new javax.swing.GroupLayout(paineldados);
        paineldados.setLayout(paineldadosLayout);
        paineldadosLayout.setHorizontalGroup(
            paineldadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paineldadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paineldadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paineldadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(paineldadosLayout.createSequentialGroup()
                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addComponent(btnpesq))
                    .addComponent(txtestoque)
                    .addComponent(txtpreco, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtdescricao, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbfornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        paineldadosLayout.setVerticalGroup(
            paineldadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paineldadosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(paineldadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpesq))
                .addGap(18, 18, 18)
                .addGroup(paineldadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(paineldadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(paineldadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtestoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(paineldadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(cbfornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados do Produto", paineldados);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Nome:");

        txtpesquisa.setBackground(new java.awt.Color(255, 255, 255));
        txtpesquisa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtpesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpesquisaKeyPressed(evt);
            }
        });

        btnpesquisar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnpesquisar.setText("Pesquisar");
        btnpesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesquisarActionPerformed(evt);
            }
        });

        tabelaproutos.setBackground(new java.awt.Color(255, 255, 255));
        tabelaproutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição ", "Preço", "Qde Estoque", "Fornecedor"
            }
        ));
        tabelaproutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaproutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaproutos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnpesquisar)
                        .addGap(0, 56, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consulta de Produtos", jPanel3);

        btnnovo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnnovo.setText("NOVO");
        btnnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnovoActionPerformed(evt);
            }
        });

        btnsalvar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnsalvar.setText("SALVAR");
        btnsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvarActionPerformed(evt);
            }
        });

        btneditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btneditar.setText("EDITAR");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btnexcluir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnexcluir.setText("EXCLUIR");
        btnexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnnovo)
                .addGap(32, 32, 32)
                .addComponent(btnsalvar)
                .addGap(26, 26, 26)
                .addComponent(btneditar)
                .addGap(37, 37, 37)
                .addComponent(btnexcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btneditar, btnexcluir, btnnovo, btnsalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnovo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalvar)
                    .addComponent(btneditar)
                    .addComponent(btnexcluir))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btneditar, btnexcluir, btnnovo, btnsalvar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnpesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesquisarActionPerformed
        // botão pesquisar
        String nome = "%" + txtpesquisa.getText() + "%";
        ClientesDAO dao = new ClientesDAO();
        List<Clientes> lista = dao.buscarPorNome(nome);

        DefaultTableModel dados = (DefaultTableModel) tabelaproutos.getModel();
        dados.setNumRows(0);

        for (Clientes clientes : lista) {
            dados.addRow(new Object[]{
                clientes.getId(),
                clientes.getNome(),
                clientes.getRg(),
                clientes.getCpf(),
                clientes.getEmail(),
                clientes.getTelefone(),
                clientes.getCelular(),
                clientes.getCep(),
                clientes.getEndereco(),
                clientes.getNumero(),
                clientes.getComplemento(),
                clientes.getBairro(),
                clientes.getCidade(),
                clientes.getEstado()
            });
        }
    }//GEN-LAST:event_btnpesquisarActionPerformed

    private void btnnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnovoActionPerformed
        // limpar tela
        new Utilitarios().limparTela(paineldados);
    }//GEN-LAST:event_btnnovoActionPerformed

    private void btnsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvarActionPerformed
        // botão salvar
        Produtos produto = new Produtos();
        produto.setDescricao(txtdescricao.getText());
        produto.setPreco(Double.parseDouble(txtpreco.getText()));
        produto.setQdeEstoque(Integer.parseInt(txtestoque.getText()));

        //criar objeto de fornecedor
        Fornecedores f = new Fornecedores();
        f = (Fornecedores) cbfornecedor.getSelectedItem();
        produto.setFornecedor(f);

        ProdutosDAO dao = new ProdutosDAO();
        dao.cadastrar(produto);

        new Utilitarios().limparTela(paineldados);

    }//GEN-LAST:event_btnsalvarActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        // editar
        Produtos obj = new Produtos();
        obj.setId(Integer.parseInt(txtcodigo.getText()));
        obj.setDescricao(txtdescricao.getText());
        obj.setPreco(Double.parseDouble(txtpreco.getText()));
        obj.setQdeEstoque(Integer.parseInt(txtestoque.getText()));
        
        //criar um objeto de fornecedor
        Fornecedores f = new Fornecedores();
        f = (Fornecedores) cbfornecedor.getSelectedItem();
        
        obj.setFornecedor(f);
        
        ProdutosDAO dao = new ProdutosDAO();
        dao.alterar(obj);

        new Utilitarios().limparTela(paineldados);
    }//GEN-LAST:event_btneditarActionPerformed

    private void btnexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluirActionPerformed
        // excluir        
        Produtos obj = new Produtos();
        obj.setId(Integer.parseInt(txtcodigo.getText()));

        ProdutosDAO dao = new ProdutosDAO();
        dao.excluir(obj);
        new Utilitarios().limparTela(paineldados);
    }//GEN-LAST:event_btnexcluirActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // carregar a lista
        listarTabela();
    }//GEN-LAST:event_formWindowActivated

    private void tabelaproutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaproutosMouseClicked
        // ao clicar no item selecionado da aba desejada, ele ira direcionar na primeira aba da dela, ou a que desejar basta trocar o indice
        jTabbedPane1.setSelectedIndex(0);
        //esse campo vai carregar os dados do cliente q foi selecionado na primera aba(aba de cadastro de clientes)
        txtcodigo.setText(tabelaproutos.getValueAt(tabelaproutos.getSelectedRow(), 0).toString());
        txtdescricao.setText(tabelaproutos.getValueAt(tabelaproutos.getSelectedRow(), 1).toString());
        txtpreco.setText(tabelaproutos.getValueAt(tabelaproutos.getSelectedRow(), 2).toString());
        txtestoque.setText(tabelaproutos.getValueAt(tabelaproutos.getSelectedRow(), 3).toString());
        
        Fornecedores f = new Fornecedores();
        FornecedoresDAO dao = new FornecedoresDAO();
        
        f = dao.consultaPorNome(tabelaproutos.getValueAt(tabelaproutos.getSelectedRow(), 4).toString());        
        cbfornecedor.removeAllItems();
        cbfornecedor.getModel().setSelectedItem(f);
    }//GEN-LAST:event_tabelaproutosMouseClicked

    private void txtpesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisaKeyPressed
        // TODO add your handling code here:
        String nome = "%" + txtpesquisa.getText() + "%";
        ProdutosDAO dao = new ProdutosDAO();
        List<Produtos> lista = dao.buscarPorNome(nome);

        DefaultTableModel dados = (DefaultTableModel) tabelaproutos.getModel();
        dados.setNumRows(0);

        for (Produtos produtos : lista) {
            dados.addRow(new Object[]{
               produtos.getId(),
               produtos.getDescricao(),
               produtos.getPreco(),
               produtos.getQdeEstoque(),
               produtos.getFornecedor().getNome()
            });
        }
    }//GEN-LAST:event_txtpesquisaKeyPressed

    private void btnpesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesqActionPerformed
        // pesquisar primeira tela
        String nome = txtdescricao.getText();
        Produtos obj = new Produtos();
        ProdutosDAO dao = new ProdutosDAO();

        obj = dao.consultaPorNome(nome);

        if (obj.getDescricao() != null) {
            //exibir os dados d o obj nos campos de texto
            txtcodigo.setText(String.valueOf(obj.getId()));
            txtdescricao.setText(obj.getDescricao());
            txtpreco.setText(String.valueOf(obj.getPreco()));
            txtestoque.setText(String.valueOf(obj.getQdeEstoque()));
            cbfornecedor.setSelectedItem(obj.getFornecedor().getNome());
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado");
        }
    }//GEN-LAST:event_btnpesqActionPerformed

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoActionPerformed

    private void txtdescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescricaoActionPerformed

    private void cbfornecedorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbfornecedorAncestorAdded
        // Carregando bobobox de fornecedores        
        FornecedoresDAO dao = new FornecedoresDAO();
        List<Fornecedores> listaFornecedores = dao.listarFornecedoreses();
        cbfornecedor.removeAll();
        for (Fornecedores forn : listaFornecedores) {
            cbfornecedor.addItem(forn);
        }
    }//GEN-LAST:event_cbfornecedorAncestorAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btnexcluir;
    private javax.swing.JButton btnnovo;
    private javax.swing.JButton btnpesq;
    private javax.swing.JButton btnpesquisar;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JComboBox cbfornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel paineldados;
    private javax.swing.JTable tabelaproutos;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtdescricao;
    private javax.swing.JTextField txtestoque;
    private javax.swing.JTextField txtpesquisa;
    private javax.swing.JTextField txtpreco;
    // End of variables declaration//GEN-END:variables
}
