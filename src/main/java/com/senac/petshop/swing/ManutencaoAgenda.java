package com.senac.petshop.swing;

import com.jdf.swing.helper.JButtonHelper;
import com.jdf.swing.helper.JComboBoxHelper;
import com.jdf.swing.helper.JListHelper;
import com.senac.petshop.bean.Agenda;
import com.senac.petshop.rn.AgendaRN;
import com.senac.petshop.rn.AnimalRN;
import com.senac.petshop.rn.ProcedimentoRN;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author lossurdo
 */
public class ManutencaoAgenda extends javax.swing.JInternalFrame {

    private JButtonHelper selData;
    private JButtonHelper selHora;
    private JListHelper selAnimais;
    private JListHelper selProcedimentos;

    private JComboBoxHelper comboboxAgenda;

    public ManutencaoAgenda() {
        initComponents();

        selData = new JButtonHelper(btnData);
        selData.transformToDateButton(new Date());

        selHora = new JButtonHelper(btnHora);
        selHora.transformToTimeButton(new Date());

        selAnimais = new JListHelper(listAnimais);
        AnimalRN rnA = new AnimalRN();
        selAnimais.setModel(rnA.pesquisar(""));

        selProcedimentos = new JListHelper(listProcedimentos);
        ProcedimentoRN rnP = new ProcedimentoRN();
        selProcedimentos.setModel(rnP.pesquisar(""));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        checkEntrada = new javax.swing.JCheckBox();
        checkSaida = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAnimais = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listProcedimentos = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        txtValorTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboSelecaoAgenda = new javax.swing.JComboBox();
        btnData = new javax.swing.JButton();
        btnHora = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAgendar = new javax.swing.JButton();
        btnAtualizarAgenda = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Manutenção da Agenda");

        jLabel1.setText("Código");

        jLabel2.setText("Data do Agendamento");

        checkEntrada.setText("Entrada?");

        checkSaida.setText("Saída?");

        jLabel3.setText("Animais");

        jScrollPane1.setViewportView(listAnimais);

        jLabel4.setText("Procedimentos");

        jScrollPane2.setViewportView(listProcedimentos);

        jLabel5.setText("Descrição");

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane3.setViewportView(txtDescricao);

        jLabel6.setText("Valor Total");

        comboSelecaoAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSelecaoAgendaActionPerformed(evt);
            }
        });

        btnData.setText("jButton1");

        btnHora.setText("jButton1");

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAgendar.setText("Agendar");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        btnAtualizarAgenda.setText("Atualizar Agenda");
        btnAtualizarAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarAgendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnData)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnHora)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(checkEntrada)
                                        .addGap(26, 26, 26)
                                        .addComponent(checkSaida))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(comboSelecaoAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnAtualizarAgenda)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgendar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnExcluir))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkEntrada)
                    .addComponent(checkSaida)
                    .addComponent(btnData)
                    .addComponent(btnHora))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(comboSelecaoAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnAgendar)
                    .addComponent(btnAtualizarAgenda))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed

        try {
            Agenda agenda = new Agenda();
            agenda.setData(JButtonHelper.toDateTime(selData, selHora));
            agenda.setDescricao(txtDescricao.getText());
            agenda.setEntradaAnimal(checkEntrada.isSelected());
            agenda.setSaidaAnimal(checkSaida.isSelected());
            agenda.setAnimais(selAnimais.getSelectedObjects());
            agenda.setProcedimentos(selProcedimentos.getSelectedObjects());

            AgendaRN rn = new AgendaRN();

            if (txtCodigo.getText().isEmpty()) {
                rn.salvar(agenda);
                JOptionPane.showMessageDialog(this, "Registro incluído com sucesso!");
            } else {
                agenda.setCodigo(Integer.parseInt(txtCodigo.getText()));
                rn.alterar(agenda);
                JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_btnAgendarActionPerformed

    private void comboSelecaoAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSelecaoAgendaActionPerformed

        if (comboSelecaoAgenda.getSelectedIndex() != -1) { // somente se algum selecionado
            Agenda agendaSelecionada = (Agenda) comboSelecaoAgenda.getSelectedItem();
            
            AgendaRN rn = new AgendaRN();
            agendaSelecionada = rn.consultar(agendaSelecionada);
            
            txtCodigo.setText(agendaSelecionada.getCodigo().toString());
            txtDescricao.setText(agendaSelecionada.getDescricao());
            txtValorTotal.setText(agendaSelecionada.getValorTotal().toString());

            checkEntrada.setSelected(agendaSelecionada.getEntradaAnimal());
            checkSaida.setSelected(agendaSelecionada.getSaidaAnimal());

            selData.setDate(agendaSelecionada.getData());
            selHora.setTime(agendaSelecionada.getData());
            
            selAnimais.setSelectedModel(agendaSelecionada.getAnimais());
            selProcedimentos.setSelectedModel(agendaSelecionada.getProcedimentos());
        }

    }//GEN-LAST:event_comboSelecaoAgendaActionPerformed

    private void btnAtualizarAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarAgendaActionPerformed

        AgendaRN rnAg = new AgendaRN();
        comboboxAgenda = new JComboBoxHelper(comboSelecaoAgenda);
        comboboxAgenda.setModel(rnAg.pesquisar(""));

    }//GEN-LAST:event_btnAtualizarAgendaActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        if (txtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Código deve ser informado");
        } else {
            if (JOptionPane.showConfirmDialog(this,
                    "Deseja mesmo excluir este registro?") == JOptionPane.OK_OPTION) {
                try {
                    AgendaRN rn = new AgendaRN();
                    rn.excluir(new Agenda(Integer.parseInt(txtCodigo.getText())));
                    JOptionPane.showMessageDialog(this, "Registro excluído com sucesso!");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
        }

    }//GEN-LAST:event_btnExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnAtualizarAgenda;
    private javax.swing.JButton btnData;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnHora;
    private javax.swing.JCheckBox checkEntrada;
    private javax.swing.JCheckBox checkSaida;
    private javax.swing.JComboBox comboSelecaoAgenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listAnimais;
    private javax.swing.JList listProcedimentos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
