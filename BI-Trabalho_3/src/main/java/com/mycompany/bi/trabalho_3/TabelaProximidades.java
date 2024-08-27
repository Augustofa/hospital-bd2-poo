/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bi.trabalho_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Augusto
 */
public class TabelaProximidades extends javax.swing.JFrame {

    DefaultTableModel modelo;
    int numColunaId;
    /**
     * Creates new form TabelaPessoas
     */
    
    public TabelaProximidades(){
        initComponents();
        
        this.modelo = (DefaultTableModel) this.tabela.getModel();
        tabela.setDefaultEditor(Object.class, null);
        
        this.titulo.setText("Lista de Clientes similares");
        this.modelo.addColumn("Renda Mensal");
        this.modelo.addColumn("Dias desde criação da conta");
        this.modelo.addColumn("Idade");
        this.modelo.addColumn("Graduado");
        this.modelo.addColumn("Casado");
        this.modelo.addColumn("Solteiro");
        this.modelo.addColumn("Nº de crianças");
        this.modelo.addColumn("Nº de adolescentes");
        this.modelo.addColumn("Dias desde última compra");
        this.modelo.addColumn("Compras com desconto");
        this.modelo.addColumn("Compras no site");
        this.modelo.addColumn("Compras no catálogo");
        this.modelo.addColumn("Compras na loja");
        this.modelo.addColumn("Visitas mensais ao site");
        this.modelo.addColumn("Campanhas aceitas");
        this.modelo.addColumn("Reclamações");
        this.modelo.addColumn("Cluster");
    }
    
    //Se for um valor repetido, ele remove a linha antiga
    public void adicionaLinha(List<Object> listaDados){
        this.modelo.addRow(listaDados.toArray());
    }
    
    public ArrayList<List<Object>> csvReader(){
        ArrayList<List<Object>> registros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Augusto\\OneDrive\\Documents\\NetBeansProjects\\BI-Trabalho_2\\src\\bi\\trabalho_2\\Clusters.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                registros.add(new ArrayList<>(Arrays.asList(values)));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TabelaProximidades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TabelaProximidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        registros.remove(0);
        
        this.titulo.setText("Lista de Clientes");
        
        return registros;
    }
    
    public void visualizarRegistros(){
        ArrayList<List<Object>> registros = csvReader();
        
        for(List<Object> linha : registros){
            this.modelo.addRow(linha.toArray());
        }
    }
    
    public void calcDistancias(List<Object> novoRegistro){
        ArrayList<List<Object>> registros = csvReader();
        
        registros.remove(0);
        int tam = 15;
        
        List<Double> c1 = new ArrayList<>(List.of(69527.32532347504, 2514.1146025878, 
                53.29852125693161, 0.922365988909427, 0.6497227356746765, 
                0.35027726432532347, 0.11090573012939002, 0.37153419593345655,
                49.06007393715342, 2.22365988909427, 5.5286506469500925, 
                4.5258780036968576, 8.11275415896488, 3.9648798521256934, 
                0.4926062846580407, 0.006469500924214418));
        
        List<Double> c2 = new ArrayList<>(List.of(34370.572573463935, 2511.373107747106, 
                48.97328584149599, 0.8504007123775601, 0.6402493321460374, 
                0.3597506678539626, 0.4666073018699911, 0.30008904719501334, 
                48.95992876224399, 2.409617097061443, 2.7248441674087265, 
                0.8334817453250223, 3.6179875333926983, 6.658949243098842, 
                0.11308993766696349, 0.01157613535173642)); 
        
        double clusters[] = new double[2];
        clusters[0] = 0.0;
        clusters[1] = 0.0;
        for(int i = 0; i < tam; i++){
            clusters[0] += pow(((int) novoRegistro.get(i)) - c1.get(i), 2);
            clusters[1] += pow(((int) novoRegistro.get(i)) - c2.get(i), 2);
        }
        
        Integer cluster = -1;
        if(clusters[0] > clusters[1]){
            cluster = 0;
        }else{
            cluster = 1;
        }
        
        this.modelo.addColumn("Distância");
        
        for(List<Object> linha : registros){
            Double distancia = 0.0;
            for(int i = 0; i < tam; i++){
                distancia += pow((int) novoRegistro.get(i) - Double.parseDouble(linha.get(i).toString()), 2);
            }
            
            linha.add(distancia);
        }
        
        registros.sort((a,b) -> {
            return Double.compare(Double.parseDouble(a.get(17).toString()),Double.parseDouble(b.get(17).toString()));
        });
        
        for(List<Object> linha : registros){
            if(Integer.parseInt(linha.get(16).toString()) == cluster){
                this.modelo.addRow(linha.toArray());
            }
        }
        
        DetalhesCluster detalhes = new DetalhesCluster(cluster, this);
        detalhes.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        titulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabela.setShowGrid(true);
        jScrollPane1.setViewportView(tabela);

        titulo.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Título");

        jPanel1.setLayout(new java.awt.GridBagLayout());

        botaoVoltar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.ipady = 56;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(6, 271, 6, 258);
        jPanel1.add(botaoVoltar, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.dispose();
        new Menu().setVisible(true);
    }//GEN-LAST:event_botaoVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
