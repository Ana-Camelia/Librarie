/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarie;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author camel
 */
public class LogIn extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
    static String adm;
    static String lovelyID;
    public LogIn() {
        initComponents();
        LogID.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = LogID.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' && l<11) || ke.getKeyChar()==8 ) {
                    LogID.setEditable(true);
                } else {
                    LogID.setEditable(false);
                }
            }
        });
        
        LogPar.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = LogPar.getText();
                int l = value.length();
                if (l<20 || ke.getKeyChar()==8 ) {
                    LogPar.setEditable(true);
                } else {
                    LogPar.setEditable(false);
                }
                //jpar.setText("");
            }
        });
        
        NewID.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = NewID.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' && l<11) || ke.getKeyChar()==8 ) {
                    NewID.setEditable(true);
                } else {
                    NewID.setEditable(false);
                }
            }
        });
        
        num.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = num.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'z' && l<20) || ke.getKeyChar()==8 || ke.getKeyChar()==' ') {
                    num.setEditable(true);
                } else {
                    num.setEditable(false);
                }
            }
        });
        
        pren.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = pren.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'z' && l<30) || ke.getKeyChar()==8 || ke.getKeyChar()==' ') {
                    pren.setEditable(true);
                } else {
                    pren.setEditable(false);
                }
            }
        });
        
        cnp.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = cnp.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' && l<13) || ke.getKeyChar()==8 ) {
                    cnp.setEditable(true);
                } else {
                    cnp.setEditable(false);
                }
            }
        });
        
        tel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = tel.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' && l<10) || ke.getKeyChar()==8 ) {
                    tel.setEditable(true);
                } else {
                    tel.setEditable(false);
                }
            }
        });
        
        jadm.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
            }
        });
        
        par.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = par.getText();
                int l = value.length();
                if (l<20 || ke.getKeyChar()==8 ) {
                    par.setEditable(true);
                } else {
                    par.setEditable(false);
                }
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogInPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        IDLabel = new javax.swing.JLabel();
        NumeLabel = new javax.swing.JLabel();
        PrenumeLabel = new javax.swing.JLabel();
        CNPLabel = new javax.swing.JLabel();
        AdminLabel = new javax.swing.JLabel();
        NewParLabel = new javax.swing.JLabel();
        NewID = new javax.swing.JTextField();
        num = new javax.swing.JTextField();
        pren = new javax.swing.JTextField();
        cnp = new javax.swing.JTextField();
        jadm = new javax.swing.JComboBox<>();
        par = new javax.swing.JTextField();
        ContNouButton = new javax.swing.JButton();
        TelefonLabel = new javax.swing.JLabel();
        tel = new javax.swing.JTextField();
        NewIDLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ParLabel = new javax.swing.JLabel();
        LogID = new javax.swing.JTextField();
        LogPar = new javax.swing.JTextField();
        LogInButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 247, 240));

        LogInPanel.setBackground(new java.awt.Color(255, 247, 240));
        LogInPanel.setAutoscrolls(true);

        jLabel2.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabel2.setText("Creează un cont nou");

        IDLabel.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        IDLabel.setText("ID");

        NumeLabel.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        NumeLabel.setText("Nume");

        PrenumeLabel.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        PrenumeLabel.setText("Prenume");

        CNPLabel.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        CNPLabel.setText("CNP");

        AdminLabel.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        AdminLabel.setText("Admin");

        NewParLabel.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        NewParLabel.setText("Parolă");

        NewID.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        NewID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewIDActionPerformed(evt);
            }
        });

        num.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N

        pren.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        pren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prenActionPerformed(evt);
            }
        });

        cnp.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N

        jadm.setBackground(new java.awt.Color(255, 102, 255));
        jadm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nu", "Da" }));

        par.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N

        ContNouButton.setBackground(new java.awt.Color(255, 181, 198));
        ContNouButton.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        ContNouButton.setForeground(new java.awt.Color(102, 0, 102));
        ContNouButton.setText("Cont nou");
        ContNouButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ContNouButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ContNouButtonMouseExited(evt);
            }
        });
        ContNouButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContNouButtonActionPerformed(evt);
            }
        });

        TelefonLabel.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        TelefonLabel.setText("Telefon");

        tel.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N

        NewIDLabel.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        NewIDLabel.setText("ID");

        jLabel3.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabel3.setText("Intră în cont");

        ParLabel.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        ParLabel.setText("Parolă");

        LogID.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N

        LogPar.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N

        LogInButton.setBackground(new java.awt.Color(255, 181, 198));
        LogInButton.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        LogInButton.setForeground(new java.awt.Color(102, 0, 102));
        LogInButton.setText("Log in");
        LogInButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogInButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogInButtonMouseExited(evt);
            }
        });
        LogInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LogInPanelLayout = new javax.swing.GroupLayout(LogInPanel);
        LogInPanel.setLayout(LogInPanelLayout);
        LogInPanelLayout.setHorizontalGroup(
            LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogInPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogInPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(LogInPanelLayout.createSequentialGroup()
                        .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ParLabel)
                            .addComponent(IDLabel))
                        .addGap(57, 57, 57)
                        .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LogInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(LogID, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LogPar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogInPanelLayout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LogInPanelLayout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(AdminLabel)
                                .addGap(26, 26, 26)
                                .addComponent(jadm, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TelefonLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogInPanelLayout.createSequentialGroup()
                                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CNPLabel)
                                    .addComponent(NumeLabel)
                                    .addComponent(NewIDLabel)
                                    .addComponent(PrenumeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cnp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pren, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(num, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NewID, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogInPanelLayout.createSequentialGroup()
                                .addComponent(NewParLabel)
                                .addGap(69, 69, 69)
                                .addComponent(par, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogInPanelLayout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(ContNouButton)
                        .addGap(115, 115, 115)))
                .addGap(62, 62, 62))
        );
        LogInPanelLayout.setVerticalGroup(
            LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogInPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LogInPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(37, 37, 37)
                        .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NewID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NewIDLabel))
                        .addGap(18, 18, 18)
                        .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NumeLabel))
                        .addGap(18, 18, 18)
                        .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pren, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PrenumeLabel))
                        .addGap(18, 18, 18)
                        .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cnp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CNPLabel))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jadm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AdminLabel)
                            .addComponent(TelefonLabel)
                            .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(par, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NewParLabel))
                        .addGap(28, 28, 28))
                    .addGroup(LogInPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(86, 86, 86)
                        .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IDLabel)
                            .addComponent(LogID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(LogInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ParLabel)
                            .addComponent(LogPar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98)
                        .addComponent(LogInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(ContNouButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LogInPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogInPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LogInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInButtonActionPerformed
        // TODO add your handling code here:
        String id=LogID.getText().toString();
        String pas = LogPar.getText().toString();
        
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie","root","");  
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select ida, admin from `angajat` where ida='"+id+"' and parola='"+pas+"' and activ='Da';");
            if (rs.next())
            {
                lovelyID=rs.getString(1).toString();
                adm=rs.getString(2).toString();
                dispose();
                new Meniu().setVisible(true);
                //System.out.println(Meniu.admin);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Acest cont nu există sau este inactiv.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
            }
            con.close();
            }
        catch(Exception e){ System.out.println(e);}  
    }//GEN-LAST:event_LogInButtonActionPerformed

    private void prenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prenActionPerformed

    private void ContNouButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContNouButtonActionPerformed
        // TODO add your handling code here:
        if (NewID.getText().isEmpty() || num.getText().isEmpty() || pren.getText().isEmpty() || cnp.getText().isEmpty() || tel.getText().isEmpty() || par.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Există câmpuri necompletate.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie","root","");  
            Statement stmt=con.createStatement();
            Statement stmt2=con.createStatement();
            ResultSet rs =stmt2.executeQuery("select ida from `angajat` where ida="+NewID.getText().toString()+";");
            if(rs.next())
                JOptionPane.showMessageDialog(null, "Există deja un utilizator cu acest ID.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
            
            else
            {
                stmt.executeUpdate("insert into `angajat` values ("+NewID.getText().toString()+", '"+
                    num.getText().toString()+"', '"+pren.getText().toString()+"', '"+cnp.getText().toString()+"', '"
                    +jadm.getSelectedItem().toString()+"', '"+tel.getText().toString()+"', '"+par.getText().toString()+"', 'Da');");
                JOptionPane.showMessageDialog(null, "Contul a fost creat cu succes.", "Notificare", JOptionPane.INFORMATION_MESSAGE);
            }
            con.close();
            }
        catch(Exception e){ System.out.println(e);}  
        }
    }//GEN-LAST:event_ContNouButtonActionPerformed

    private void NewIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewIDActionPerformed

    private void LogInButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInButtonMouseEntered
this.LogInButton.setBackground(Color.decode("#FFCCD8"));      // TODO add your handling code here:
    }//GEN-LAST:event_LogInButtonMouseEntered

    private void LogInButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInButtonMouseExited

        this.LogInButton.setBackground(Color.decode("#FFB5C6"));        // TODO add your handling code here:
    }//GEN-LAST:event_LogInButtonMouseExited

    private void ContNouButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContNouButtonMouseEntered
this.ContNouButton.setBackground(Color.decode("#FFCCD8"));       // TODO add your handling code here:
    }//GEN-LAST:event_ContNouButtonMouseEntered

    private void ContNouButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContNouButtonMouseExited

        this.ContNouButton.setBackground(Color.decode("#FFB5C6"));        // TODO add your handling code here:
    }//GEN-LAST:event_ContNouButtonMouseExited

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       /* try{ UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       } catch (Exception e){e.printStackTrace();
       }*/
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdminLabel;
    private javax.swing.JLabel CNPLabel;
    private javax.swing.JButton ContNouButton;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JTextField LogID;
    private javax.swing.JButton LogInButton;
    private javax.swing.JPanel LogInPanel;
    private javax.swing.JTextField LogPar;
    private javax.swing.JTextField NewID;
    private javax.swing.JLabel NewIDLabel;
    private javax.swing.JLabel NewParLabel;
    private javax.swing.JLabel NumeLabel;
    private javax.swing.JLabel ParLabel;
    private javax.swing.JLabel PrenumeLabel;
    private javax.swing.JLabel TelefonLabel;
    private javax.swing.JTextField cnp;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> jadm;
    private javax.swing.JTextField num;
    private javax.swing.JTextField par;
    private javax.swing.JTextField pren;
    private javax.swing.JTextField tel;
    // End of variables declaration//GEN-END:variables
}
