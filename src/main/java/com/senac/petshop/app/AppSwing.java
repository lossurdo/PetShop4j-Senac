package com.senac.petshop.app;

import com.senac.petshop.swing.ManutencaoDono;

/**
 *
 * @author lossurdo
 */
public class AppSwing extends javax.swing.JFrame {

    public AppSwing() {
        initComponents();
        
        // centraliza janela
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menubar = new javax.swing.JMenuBar();
        menuAtendimento = new javax.swing.JMenu();
        menuItemAgendamento = new javax.swing.JMenuItem();
        menuItemManutencao = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuItemSair = new javax.swing.JMenuItem();
        menuDono = new javax.swing.JMenu();
        menuItemManutDono = new javax.swing.JMenuItem();
        menuAnimal = new javax.swing.JMenu();
        menuItemManutAnimal = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuAtendimento.setText("Atendimento");

        menuItemAgendamento.setText("Agendamento");
        menuAtendimento.add(menuItemAgendamento);

        menuItemManutencao.setText("Manutenção");
        menuAtendimento.add(menuItemManutencao);
        menuAtendimento.add(jSeparator1);

        menuItemSair.setText("Sair");
        menuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSairActionPerformed(evt);
            }
        });
        menuAtendimento.add(menuItemSair);

        menubar.add(menuAtendimento);

        menuDono.setText("Dono");

        menuItemManutDono.setText("Manutenção");
        menuItemManutDono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemManutDonoActionPerformed(evt);
            }
        });
        menuDono.add(menuItemManutDono);

        menubar.add(menuDono);

        menuAnimal.setText("Animal");

        menuItemManutAnimal.setText("Manutenção");
        menuAnimal.add(menuItemManutAnimal);

        menubar.add(menuAnimal);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemManutDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemManutDonoActionPerformed
                
        ManutencaoDono md = new ManutencaoDono();        
        desktopPane.add(md);
        md.setVisible(true);
        
    }//GEN-LAST:event_menuItemManutDonoActionPerformed

    private void menuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSairActionPerformed
        
        System.exit(0);
        
    }//GEN-LAST:event_menuItemSairActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppSwing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu menuAnimal;
    private javax.swing.JMenu menuAtendimento;
    private javax.swing.JMenu menuDono;
    private javax.swing.JMenuItem menuItemAgendamento;
    private javax.swing.JMenuItem menuItemManutAnimal;
    private javax.swing.JMenuItem menuItemManutDono;
    private javax.swing.JMenuItem menuItemManutencao;
    private javax.swing.JMenuItem menuItemSair;
    private javax.swing.JMenuBar menubar;
    // End of variables declaration//GEN-END:variables
}
