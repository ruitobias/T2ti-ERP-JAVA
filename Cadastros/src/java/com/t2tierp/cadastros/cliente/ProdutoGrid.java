/*
 * The MIT License
 * 
 * Copyright: Copyright (C) 2014 T2Ti.COM
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * The author may be contacted at: t2ti.com@gmail.com
 *
 * @author Claudio de Barros (T2Ti.com)
 * @version 2.0
 */
package com.t2tierp.cadastros.cliente;

import org.openswing.swing.client.GridControl;
import org.openswing.swing.mdi.client.InternalFrame;

public class ProdutoGrid extends InternalFrame {

    public ProdutoGrid(ProdutoGridController controller) {
        initComponents();
        gridControl1.setController(controller);
        gridControl1.setGridDataLocator(controller);
    }

    public GridControl getGrid1() {
        return gridControl1;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        insertButton1 = new org.openswing.swing.client.InsertButton();
        deleteButton1 = new org.openswing.swing.client.DeleteButton();
        reloadButton1 = new org.openswing.swing.client.ReloadButton();
        navigatorBar1 = new org.openswing.swing.client.NavigatorBar();
        gridControl1 = new org.openswing.swing.client.GridControl();
        textColumn11 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn3 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn6 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn7 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn8 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn9 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn10 = new org.openswing.swing.table.columns.client.TextColumn();
        decimalColumn15 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn23 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn25 = new org.openswing.swing.table.columns.client.DecimalColumn();
        comboColumn28 = new org.openswing.swing.table.columns.client.ComboColumn();
        comboColumn29 = new org.openswing.swing.table.columns.client.ComboColumn();
        dateColumn30 = new org.openswing.swing.table.columns.client.DateColumn();
        dateColumn46 = new org.openswing.swing.table.columns.client.DateColumn();
        comboColumn47 = new org.openswing.swing.table.columns.client.ComboColumn();

        setTitle("T2Ti ERP - Cadastros");
        setPreferredSize(new java.awt.Dimension(700, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Produto"));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel1.add(insertButton1);
        jPanel1.add(deleteButton1);
        jPanel1.add(reloadButton1);
        jPanel1.add(navigatorBar1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        gridControl1.setDeleteButton(deleteButton1);
        gridControl1.setFunctionId("produto");
        gridControl1.setInsertButton(insertButton1);
        gridControl1.setNavBar(navigatorBar1);
        gridControl1.setReloadButton(reloadButton1);
        gridControl1.setValueObjectClassName("com.t2tierp.cadastros.java.ProdutoVO");
        gridControl1.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        textColumn11.setColumnFilterable(true);
        textColumn11.setColumnName("nome");
        textColumn11.setColumnSortable(true);
        textColumn11.setHeaderColumnName("Nome");
        textColumn11.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        textColumn11.setPreferredWidth(300);
        gridControl1.getColumnContainer().add(textColumn11);

        textColumn3.setColumnFilterable(true);
        textColumn3.setColumnName("unidadeProduto.sigla");
        textColumn3.setColumnSortable(true);
        textColumn3.setHeaderColumnName("Unidade");
        textColumn3.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        gridControl1.getColumnContainer().add(textColumn3);

        textColumn6.setColumnFilterable(true);
        textColumn6.setColumnName("produtoMarca.nome");
        textColumn6.setColumnSortable(true);
        textColumn6.setHeaderColumnName("Marca");
        textColumn6.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        gridControl1.getColumnContainer().add(textColumn6);

        textColumn7.setColumnFilterable(true);
        textColumn7.setColumnName("produtoSubGrupo.nome");
        textColumn7.setColumnSortable(true);
        textColumn7.setHeaderColumnName("Sub Grupo");
        textColumn7.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl1.getColumnContainer().add(textColumn7);

        textColumn8.setColumnFilterable(true);
        textColumn8.setColumnName("gtin");
        textColumn8.setColumnSortable(true);
        textColumn8.setHeaderColumnName("Gtin");
        textColumn8.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        gridControl1.getColumnContainer().add(textColumn8);

        textColumn9.setColumnFilterable(true);
        textColumn9.setColumnName("codigoInterno");
        textColumn9.setColumnSortable(true);
        textColumn9.setHeaderColumnName("Codigo Interno");
        textColumn9.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        gridControl1.getColumnContainer().add(textColumn9);

        textColumn10.setColumnFilterable(true);
        textColumn10.setColumnName("ncm");
        textColumn10.setColumnSortable(true);
        textColumn10.setHeaderColumnName("Ncm");
        textColumn10.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        gridControl1.getColumnContainer().add(textColumn10);

        decimalColumn15.setColumnFilterable(true);
        decimalColumn15.setColumnName("valorVenda");
        decimalColumn15.setColumnSortable(true);
        decimalColumn15.setDecimals(2);
        decimalColumn15.setHeaderColumnName("Valor Venda");
        decimalColumn15.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        gridControl1.getColumnContainer().add(decimalColumn15);

        decimalColumn23.setColumnFilterable(true);
        decimalColumn23.setColumnName("quantidadeEstoque");
        decimalColumn23.setColumnSortable(true);
        decimalColumn23.setDecimals(2);
        decimalColumn23.setHeaderColumnName("Quantidade Estoque");
        decimalColumn23.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        decimalColumn23.setPreferredWidth(130);
        gridControl1.getColumnContainer().add(decimalColumn23);

        decimalColumn25.setColumnFilterable(true);
        decimalColumn25.setColumnName("estoqueMinimo");
        decimalColumn25.setColumnSortable(true);
        decimalColumn25.setDecimals(2);
        decimalColumn25.setHeaderColumnName("Estoque Minimo");
        decimalColumn25.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        gridControl1.getColumnContainer().add(decimalColumn25);

        comboColumn28.setColumnFilterable(true);
        comboColumn28.setColumnName("excluido");
        comboColumn28.setColumnSortable(true);
        comboColumn28.setDomainId("simnao");
        comboColumn28.setHeaderColumnName("Excluido");
        comboColumn28.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        gridControl1.getColumnContainer().add(comboColumn28);

        comboColumn29.setColumnFilterable(true);
        comboColumn29.setColumnName("inativo");
        comboColumn29.setColumnSortable(true);
        comboColumn29.setDomainId("simnao");
        comboColumn29.setHeaderColumnName("Inativo");
        comboColumn29.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        gridControl1.getColumnContainer().add(comboColumn29);

        dateColumn30.setColumnFilterable(true);
        dateColumn30.setColumnName("dataCadastro");
        dateColumn30.setColumnSortable(true);
        dateColumn30.setHeaderColumnName("Data Cadastro");
        dateColumn30.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        gridControl1.getColumnContainer().add(dateColumn30);

        dateColumn46.setColumnFilterable(true);
        dateColumn46.setColumnName("dataAlteracao");
        dateColumn46.setColumnSortable(true);
        dateColumn46.setHeaderColumnName("Data Alteracao");
        dateColumn46.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        gridControl1.getColumnContainer().add(dateColumn46);

        comboColumn47.setColumnFilterable(true);
        comboColumn47.setColumnName("tipo");
        comboColumn47.setColumnSortable(true);
        comboColumn47.setDomainId("produtoTipo");
        comboColumn47.setHeaderColumnName("Tipo");
        comboColumn47.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        gridControl1.getColumnContainer().add(comboColumn47);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(gridControl1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.table.columns.client.ComboColumn comboColumn28;
    private org.openswing.swing.table.columns.client.ComboColumn comboColumn29;
    private org.openswing.swing.table.columns.client.ComboColumn comboColumn47;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn30;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn46;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn15;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn23;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn25;
    private org.openswing.swing.client.DeleteButton deleteButton1;
    private org.openswing.swing.client.GridControl gridControl1;
    private org.openswing.swing.client.InsertButton insertButton1;
    private javax.swing.JPanel jPanel1;
    private org.openswing.swing.client.NavigatorBar navigatorBar1;
    private org.openswing.swing.client.ReloadButton reloadButton1;
    private org.openswing.swing.table.columns.client.TextColumn textColumn10;
    private org.openswing.swing.table.columns.client.TextColumn textColumn11;
    private org.openswing.swing.table.columns.client.TextColumn textColumn3;
    private org.openswing.swing.table.columns.client.TextColumn textColumn6;
    private org.openswing.swing.table.columns.client.TextColumn textColumn7;
    private org.openswing.swing.table.columns.client.TextColumn textColumn8;
    private org.openswing.swing.table.columns.client.TextColumn textColumn9;
    // End of variables declaration//GEN-END:variables
}
