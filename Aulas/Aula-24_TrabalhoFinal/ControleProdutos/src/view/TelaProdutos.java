package view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import controller.Buscador;
import controller.Comparadores;
import controller.Medidor;
import controller.Ordenador;
import controller.Relatorio;
import model.ArquivoProduto;
import model.Produto;

/*
 * Trabalho III Pesquisa e Ordenação
 *
 * Autor: Vitor Dorneles
 */
public class TelaProdutos extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger
            .getLogger(TelaProdutos.class.getName());
    
    private List<Produto> listaOriginal = new ArrayList<>();
    private List<Produto> listaAgora = new ArrayList<>();
    private List<Produto> listaPorID = new ArrayList<>();
    private HashMap<Integer, Produto> mapaId = new HashMap<>();
    private HashMap<String, List<Produto>> mapaCategoria = new HashMap<>();

    public TelaProdutos() {
        initComponents();
    }

    private void preencheTabela(List<Produto> lista) {
        DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
        modelo.setRowCount(0);

        for (Produto produto : lista) {
            modelo.addRow(new Object[] {
                    produto.getId(),
                    produto.getNome(),
                    produto.getCategoria(),
                    produto.getPreco(),
                    produto.getQtdEstoque()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnCarregar = new javax.swing.JButton();
        lblCampo = new javax.swing.JLabel();
        cmbCampo = new javax.swing.JComboBox<>();
        lblAlgoritmo = new javax.swing.JLabel();
        cmbAlgoritmo = new javax.swing.JComboBox<>();
        btnOrdenar = new javax.swing.JButton();
        lblBusca = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();
        lblTecnica = new javax.swing.JLabel();
        cmbTecnica = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        lblTempo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("Controle de Produtos");

        btnCarregar.setText("Carregar arquivo");
        btnCarregar.addActionListener(this::btnCarregarActionPerformed);

        lblCampo.setText("Ordenar por:");

        cmbCampo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Preço" }));

        lblAlgoritmo.setText("Algoritmo:");

        cmbAlgoritmo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bolha", "Merge" }));

        btnOrdenar.setText("Ordenar");
        btnOrdenar.addActionListener(this::btnOrdenarActionPerformed);

        lblBusca.setText("Buscar:");

        lblTecnica.setText("Técnica:");

        cmbTecnica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Linear", "Binária", "HashMap", "Categoria" }));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(this::btnExportarActionPerformed);

        btnRelatorio.setText("Gerar relatório");
        btnRelatorio.addActionListener(this::btnRelatorioActionPerformed);

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Categoria", "Preço", "Estoque"
            }
        ));
        jScrollPane1.setViewportView(tblProdutos);

        lblTempo.setText("Tempo: -");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(btnCarregar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCampo)
                            .addComponent(lblAlgoritmo)
                            .addComponent(lblBusca)
                            .addComponent(lblTecnica))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbAlgoritmo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTecnica, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOrdenar)
                            .addComponent(btnBuscar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExportar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRelatorio))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTempo))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(btnCarregar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCampo)
                    .addComponent(cmbCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlgoritmo)
                    .addComponent(cmbAlgoritmo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrdenar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBusca)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTecnica)
                    .addComponent(cmbTecnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExportar)
                    .addComponent(btnRelatorio))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTempo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarregarActionPerformed
        JFileChooser seletor = new JFileChooser("Dados");
        if (seletor.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        String caminho = seletor.getSelectedFile().getPath();
        listaOriginal = new ArquivoProduto(caminho).leArquivo();

        if (listaOriginal.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não foi possível ler o arquivo: " + caminho);
            return;
        }

        listaAgora = new ArrayList<>(listaOriginal);

        listaPorID = new ArrayList<>(listaOriginal);
        Ordenador.merge(listaPorID, Comparadores::comparaID );
        
        mapaId = Buscador.montaMapaId(listaAgora);
        mapaCategoria = Buscador.montaMapaCategoria(listaAgora);

        preencheTabela(listaAgora);
        lblTempo.setText(listaOriginal.size() + " produtos carregados");
    }//GEN-LAST:event_btnCarregarActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        Comparator<Produto> criterio;
        if (cmbCampo.getSelectedIndex() == 0) {
            criterio = Comparadores::comparaNome;
        } else {
            criterio = Comparadores::comparaPreco;
        }

        listaAgora = new ArrayList<>(listaOriginal);

        long tempo;
        String algoritmo;
        if (cmbAlgoritmo.getSelectedIndex() == 0) {
            algoritmo = "Bolha";
            tempo = Medidor.medirBolha(listaAgora, criterio);
        } else {
            algoritmo = "Merge";
            tempo = Medidor.medirMerge(listaAgora, criterio);
        }

        preencheTabela(listaAgora);
        lblTempo.setText(algoritmo + ": " + String.format(Locale.US, "%.2f", tempo / 1_000_000.0) + " ms");
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String texto = txtBusca.getText().trim();
        int tecnica = cmbTecnica.getSelectedIndex();

        if (tecnica == 3) {
            long tempo = Medidor.medirBuscaCategoria(mapaCategoria, texto);
            List<Produto> produtosDaCategoria = mapaCategoria.get(texto);

            if (produtosDaCategoria == null) {
                JOptionPane.showMessageDialog(this,
                        "Categoria não encontrada: " + texto + "\nDisponíveis: " + mapaCategoria.keySet());
                 preencheTabela(new ArrayList<>());
             } else {

                 preencheTabela(produtosDaCategoria);
                 
             }
             lblTempo.setText("Categoria: " + tempo + " ns (média de " + Medidor.repeticoes + ")");
             return;
        }
        int id;
        try {
            id = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite um id valido");
            return;
        }
        
        long tempo;
        Produto encontrado;
        String nomeTecnica;
        if (tecnica == 0) {
            nomeTecnica = "Linear";
            tempo = Medidor.medirBuscaLinear(listaOriginal, id);
            encontrado = Buscador.buscaLinear(listaOriginal, id);
        } else if (tecnica == 1) {
            nomeTecnica = "Binária";
            tempo = Medidor.medirBuscaBinaria(listaPorID, id);
            encontrado = Buscador.pesquisaBinaria(listaPorID, id);
        } else {
            nomeTecnica = "HashMap";
            tempo = Medidor.medirBuscaHash(mapaId, id);
            encontrado = Buscador.buscaHash(mapaId, id);
        }

        List<Produto> resultado = new ArrayList<>();
        if (encontrado != null) {
            resultado.add(encontrado);
        } else {
            JOptionPane.showMessageDialog(this, "Produto " + id + " não encontrado.");
        }
        preencheTabela(resultado);
        lblTempo.setText(nomeTecnica + ": " + tempo + " ns (média de " + Medidor.repeticoes + ")");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        JFileChooser seletor = new JFileChooser("Dados");
        if (seletor.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        String caminho = seletor.getSelectedFile().getPath();

        new ArquivoProduto(caminho).gravaArquivo(listaAgora, caminho);

        JOptionPane.showMessageDialog(this, listaAgora.size() + " produtos exportados para " + caminho);
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        btnRelatorio.setEnabled(false);
        lblTempo.setText("Gerando relatório... aguarde");

        SwingWorker<Void, Void> tarefa = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                Relatorio.gerarRelatorio();
                return null;
            }

            @Override
            protected void done() {
                btnRelatorio.setEnabled(true);
                try {
                    get();
                lblTempo.setText("Relatório gerado");
                    JOptionPane.showMessageDialog(TelaProdutos.this, "relatorio.txt gerado na pasta do projeto.");
                } catch (Exception e) {
                lblTempo.setText("Erro ao gerar o relatório");
                JOptionPane.showMessageDialog(TelaProdutos.this, "Erro ao gerar o relatório: " + e.getCause());
                }
            }
        };
        tarefa.execute();
    }//GEN-LAST:event_btnRelatorioActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new TelaProdutos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCarregar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JComboBox<String> cmbAlgoritmo;
    private javax.swing.JComboBox<String> cmbCampo;
    private javax.swing.JComboBox<String> cmbTecnica;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlgoritmo;
    private javax.swing.JLabel lblBusca;
    private javax.swing.JLabel lblCampo;
    private javax.swing.JLabel lblTecnica;
    private javax.swing.JLabel lblTempo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
