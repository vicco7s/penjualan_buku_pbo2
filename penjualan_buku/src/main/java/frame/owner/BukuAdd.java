/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frame.owner;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Buku;
import model.JenisBuku;

/**
 *
 * @author cero
 */
public class BukuAdd extends javax.swing.JFrame {

    /**
     * Creates new form BukuAdd
     */
//    public String status;
    
    public BukuAdd() {
        initComponents();
        setLocationRelativeTo(null);
        isiDataCb();
        tfId.setEnabled(false);
        tfId.setText("NULL");
        tfNamaBuku.requestFocus();
//        status = "TAMBAH";
    }

    public BukuAdd(Buku buku) {
       initComponents();
        setLocationRelativeTo(null);
        isiDataCb();
        tfId.setEnabled(false);
        tfId.setText(String.valueOf(buku.getId()));
        
        buku.find();
        tfNamaBuku.setText(buku.getNamaBuku());
        tfHarga.setText(String.valueOf(buku.getHarga()));
        
        for (int i = 0; i < cbJenisBuku.getItemCount(); i++) {
            JenisBuku jenisBuku = new JenisBuku();
            cbJenisBuku.setSelectedIndex(i);
            jenisBuku.setId(((JenisBuku) cbJenisBuku.getSelectedItem()).getId());
            if (jenisBuku.getId() == buku.getJenisBuku().getId()) {
                cbJenisBuku.setSelectedIndex(i);
                break;
            }
        }
        tfNamaBuku.requestFocus();
       
    }
    
        public void isiDataCb() {
        JenisBuku jenisBuku = new JenisBuku();
        ArrayList<JenisBuku> list = jenisBuku.read();
        
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            
            for (int i = 0; i < list.size(); i++) {
                JenisBuku jb = list.get(i);
                model.addElement(jb);
            }
            cbJenisBuku.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfNamaBuku = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbJenisBuku = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        tfHarga = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setText("Input Data Buku");

        jLabel3.setText("Id Buku");

        jLabel1.setText("Nama Buku");

        tfNamaBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaBukuActionPerformed(evt);
            }
        });

        jLabel4.setText("Jenis Barang");

        cbJenisBuku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbJenisBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJenisBukuActionPerformed(evt);
            }
        });

        jLabel5.setText("Harga");

        tfHarga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfHarga.setText("0");
        tfHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfHargaKeyTyped(evt);
            }
        });

        jButton6.setText("Simpan");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Tutup");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfId)
                            .addComponent(tfNamaBuku, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                            .addComponent(cbJenisBuku, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfHarga)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNamaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbJenisBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton6))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNamaBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaBukuActionPerformed

    private void tfHargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfHargaKeyTyped
        char enter = evt.getKeyChar();
        if (!Character.isDigit(enter) && enter != KeyEvent.VK_PERIOD) {
            evt.consume();
            //            System.out.println(enter);
        }
    }//GEN-LAST:event_tfHargaKeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        JenisBuku jb = (JenisBuku)cbJenisBuku.getSelectedItem();
        
        Buku buku = new Buku();
        buku.setNamaBuku(tfNamaBuku.getText());
        buku.setJenisBuku(jb);
        buku.setHarga(Float.parseFloat(tfHarga.getText()));

        if(tfId.getText().equals("NULL")){
            if(buku.create()){
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Gagal Insert Data");
            }
        } else {
            buku.setId(Integer.parseInt(tfId.getText()));
            if(buku.update()){
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Gagal Update Data");
            }
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void cbJenisBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJenisBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbJenisBukuActionPerformed

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
            java.util.logging.Logger.getLogger(BukuAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BukuAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BukuAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BukuAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BukuAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbJenisBuku;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNamaBuku;
    // End of variables declaration//GEN-END:variables
}
