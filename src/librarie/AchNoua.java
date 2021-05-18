/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarie;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import static librarie.LogIn.adm;
import static librarie.LogIn.lovelyID;

/**
 *
 * @author camel
 */
public class AchNoua extends javax.swing.JFrame {

    /**
     * Creates new form AchNoua
     */
    public AchNoua() {
        initComponents();  
            ANouaProdELabel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(ANouaProdELabel.isSelected()==true)
                {
                    prod.setEnabled(true);
                    ANouaProdNLabel.setSelected(false);
                    codp.setEnabled(false);
                    prod1.setEnabled(false);
                    cat.setEnabled(false);
                    subcat.setEnabled(false);
                    pret.setEnabled(false);
                    um.setEnabled(false);
                    red.setEnabled(false);
                    tva.setEnabled(false);
                    eco.setEnabled(false);
                }
                else
                {prod.setEnabled(false);}
            }
        });
        ANouaProdNLabel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(ANouaProdNLabel.isSelected()==true)
                {
                    prod.setEnabled(false);
                    ANouaProdELabel.setSelected(false);
                    codp.setEnabled(true);
                    prod1.setEnabled(true);
                    cat.setEnabled(true);
                    subcat.setEnabled(true);
                    pret.setEnabled(true);
                    um.setEnabled(true);
                    red.setEnabled(true);
                    tva.setEnabled(true);
                    eco.setEnabled(true);
                }
                else
                {
                    codp.setEnabled(false);
                    prod1.setEnabled(false);
                    cat.setEnabled(false);
                    subcat.setEnabled(false);
                    pret.setEnabled(false);
                    um.setEnabled(false);
                    red.setEnabled(false);
                    tva.setEnabled(false);
                    eco.setEnabled(false);
                }
            }
        });
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie","root","");  
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select nume from distribuitor;");
                while (rs.next())
                dis.addItem(rs.getString(1));

            con.close();}
         catch(Exception e){ System.out.println(e);}
        
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie","root","");  
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select denumire from tip_produs;");
                while (rs.next())
                prod.addItem(rs.getString(1));

            con.close();}
         catch(Exception e){ System.out.println(e);}
        
                nrf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = nrf.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' && l<11) || ke.getKeyChar()==8 ) {
                    nrf.setEditable(true);
                } else {
                    nrf.setEditable(false);
                }
            }
        });
            codp.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = codp.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' && l<11) || ke.getKeyChar()==8 ) {
                    codp.setEditable(true);
                } else {
                    codp.setEditable(false);
                }
            }
        });
            pret.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = pret.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' && l<11) || ke.getKeyChar()==8 || ke.getKeyChar()=='.' ) {
                    pret.setEditable(true);
                } else {
                    pret.setEditable(false);
                }
            }
        });
            red.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = red.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' && l<2) || ke.getKeyChar()==8 ) {
                    red.setEditable(true);
                } else {
                    red.setEditable(false);
                }
            }
        });
            tva.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = tva.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' && l<2) || ke.getKeyChar()==8 ) {
                    tva.setEditable(true);
                } else {
                    tva.setEditable(false);
                }
            }
        });
            eco.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = eco.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' && l<2) || ke.getKeyChar()==8 ) {
                    eco.setEditable(true);
                } else {
                    eco.setEditable(false);
                }
            }
        });
            prod1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = prod1.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'z' && l<50) || ke.getKeyChar()==8 || ke.getKeyChar()==' ') {
                    prod1.setEditable(true);
                } else {
                    prod1.setEditable(false);
                }
            }
        });
            subcat.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = subcat.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'z' && l<50) || ke.getKeyChar()==8 || ke.getKeyChar()==' ') {
                    subcat.setEditable(true);
                } else {
                    subcat.setEditable(false);
                }
            }
        });
            um.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = um.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= 'z' && l<30) || ke.getKeyChar()==8 || ke.getKeyChar()==' ') {
                    um.setEditable(true);
                } else {
                    um.setEditable(false);
                }
            }
        });
            cant.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = cant.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' && l<11) || ke.getKeyChar()==8 ) {
                    cant.setEditable(true);
                } else {
                    cant.setEditable(false);
                }
            }
        });
            cost.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = cost.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' && l<11) || ke.getKeyChar()==8 || ke.getKeyChar()=='.' ) {
                    cost.setEditable(true);
                } else {
                    cost.setEditable(false);
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

        AchNouaPanel = new javax.swing.JPanel();
        ANouaNrfLabel = new javax.swing.JLabel();
        ANouaDisLabel = new javax.swing.JLabel();
        ANouaProdLabel = new javax.swing.JLabel();
        ANouaCantLabel = new javax.swing.JLabel();
        ANouaCostLabel = new javax.swing.JLabel();
        ANouaProdELabel = new javax.swing.JCheckBox();
        ANouaProdNLabel = new javax.swing.JCheckBox();
        ANouaCodLabel = new javax.swing.JLabel();
        ANouaDenLabel = new javax.swing.JLabel();
        ANouaCatLabel = new javax.swing.JLabel();
        ANouaSubcatLabel = new javax.swing.JLabel();
        ANouaPretLabel = new javax.swing.JLabel();
        ANouaUMLabel = new javax.swing.JLabel();
        ANouaRedLabel = new javax.swing.JLabel();
        ANouaTVALabel = new javax.swing.JLabel();
        ANouaEcoLabel = new javax.swing.JLabel();
        nrf = new javax.swing.JTextField();
        dis = new javax.swing.JComboBox<>();
        prod = new javax.swing.JComboBox<>();
        codp = new javax.swing.JTextField();
        prod1 = new javax.swing.JTextField();
        cat = new javax.swing.JComboBox<>();
        subcat = new javax.swing.JTextField();
        pret = new javax.swing.JTextField();
        um = new javax.swing.JTextField();
        red = new javax.swing.JTextField();
        tva = new javax.swing.JTextField();
        eco = new javax.swing.JTextField();
        cant = new javax.swing.JTextField();
        cost = new javax.swing.JTextField();
        ANouaAddButton = new javax.swing.JButton();
        ANouaBackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("AchNouaFrame"); // NOI18N

        AchNouaPanel.setBackground(new java.awt.Color(255, 247, 240));

        ANouaNrfLabel.setText("Nr. factură");

        ANouaDisLabel.setText("Distribuitor");

        ANouaProdLabel.setText("Produs");

        ANouaCantLabel.setText("Cantitate");

        ANouaCostLabel.setText("Cost");

        ANouaProdELabel.setBackground(new java.awt.Color(255, 247, 240));
        ANouaProdELabel.setSelected(true);
        ANouaProdELabel.setText("Produs existent");

        ANouaProdNLabel.setBackground(new java.awt.Color(255, 247, 240));
        ANouaProdNLabel.setText("Produs Nou");

        ANouaCodLabel.setText("Cod produs");

        ANouaDenLabel.setText("Denumire");

        ANouaCatLabel.setText("Categorie");

        ANouaSubcatLabel.setText("Subcategorie");

        ANouaPretLabel.setText("Preț vânzare");

        ANouaUMLabel.setText("Unitate de măsură");

        ANouaRedLabel.setText("Reducere");

        ANouaTVALabel.setText("TVA");

        ANouaEcoLabel.setText("Taxa ecologica");

        cat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cărți", "Papetărie", "Birotică", "Filme", "Jocuri" }));

        ANouaAddButton.setText("Înregistrează achiziția");
        ANouaAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ANouaAddButtonActionPerformed(evt);
            }
        });

        ANouaBackButton.setText("Înapoi");
        ANouaBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ANouaBackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AchNouaPanelLayout = new javax.swing.GroupLayout(AchNouaPanel);
        AchNouaPanel.setLayout(AchNouaPanelLayout);
        AchNouaPanelLayout.setHorizontalGroup(
            AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AchNouaPanelLayout.createSequentialGroup()
                .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AchNouaPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ANouaProdNLabel)
                            .addGroup(AchNouaPanelLayout.createSequentialGroup()
                                .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ANouaCantLabel)
                                    .addComponent(ANouaProdELabel)
                                    .addComponent(ANouaCostLabel))
                                .addGap(27, 27, 27)
                                .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AchNouaPanelLayout.createSequentialGroup()
                                        .addComponent(ANouaProdLabel)
                                        .addGap(59, 59, 59)
                                        .addComponent(prod, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(AchNouaPanelLayout.createSequentialGroup()
                                        .addComponent(ANouaCodLabel)
                                        .addGap(37, 37, 37)
                                        .addComponent(codp, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(AchNouaPanelLayout.createSequentialGroup()
                                        .addComponent(ANouaCatLabel)
                                        .addGap(45, 45, 45)
                                        .addComponent(cat, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(nrf)
                                        .addComponent(dis, 0, 235, Short.MAX_VALUE))
                                    .addGroup(AchNouaPanelLayout.createSequentialGroup()
                                        .addComponent(ANouaPretLabel)
                                        .addGap(30, 30, 30)
                                        .addComponent(pret, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(AchNouaPanelLayout.createSequentialGroup()
                                        .addComponent(ANouaRedLabel)
                                        .addGap(46, 46, 46)
                                        .addComponent(red, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                        .addComponent(cant, javax.swing.GroupLayout.Alignment.LEADING))))))
                    .addGroup(AchNouaPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(ANouaBackButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ANouaDisLabel)
                            .addComponent(ANouaNrfLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AchNouaPanelLayout.createSequentialGroup()
                        .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(AchNouaPanelLayout.createSequentialGroup()
                                .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ANouaDenLabel)
                                    .addComponent(ANouaSubcatLabel))
                                .addGap(25, 25, 25)
                                .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(prod1)
                                    .addComponent(subcat, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)))
                            .addGroup(AchNouaPanelLayout.createSequentialGroup()
                                .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ANouaUMLabel)
                                    .addGroup(AchNouaPanelLayout.createSequentialGroup()
                                        .addComponent(ANouaTVALabel)
                                        .addGap(38, 38, 38)
                                        .addComponent(tva, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(47, 47, 47)
                                .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AchNouaPanelLayout.createSequentialGroup()
                                        .addComponent(ANouaEcoLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                        .addComponent(eco, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(um))))
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AchNouaPanelLayout.createSequentialGroup()
                        .addComponent(ANouaAddButton)
                        .addGap(178, 178, 178))))
        );
        AchNouaPanelLayout.setVerticalGroup(
            AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AchNouaPanelLayout.createSequentialGroup()
                .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AchNouaPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ANouaNrfLabel)
                            .addComponent(nrf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AchNouaPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ANouaBackButton)))
                .addGap(20, 20, 20)
                .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ANouaDisLabel)
                    .addComponent(dis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ANouaProdELabel)
                    .addComponent(ANouaProdLabel)
                    .addComponent(prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ANouaProdNLabel)
                    .addComponent(ANouaCodLabel)
                    .addComponent(ANouaDenLabel)
                    .addComponent(codp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ANouaCatLabel)
                    .addComponent(ANouaSubcatLabel)
                    .addComponent(cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subcat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ANouaPretLabel)
                    .addComponent(ANouaUMLabel)
                    .addComponent(pret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(um, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ANouaRedLabel)
                    .addComponent(ANouaTVALabel)
                    .addComponent(ANouaEcoLabel)
                    .addComponent(red, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ANouaCantLabel)
                    .addComponent(cant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AchNouaPanelLayout.createSequentialGroup()
                        .addGroup(AchNouaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ANouaCostLabel)
                            .addComponent(cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AchNouaPanelLayout.createSequentialGroup()
                        .addComponent(ANouaAddButton)
                        .addGap(49, 49, 49))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(AchNouaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(AchNouaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ANouaAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANouaAddButtonActionPerformed
        if(nrf.getText().isEmpty() || cant.getText().isEmpty() || cost.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Există câmpuri necompletate.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
        else if(ANouaProdNLabel.isSelected() && (codp.getText().isEmpty() || prod1.getText().isEmpty() || subcat.getText().isEmpty() ||
                pret.getText().isEmpty() || um.getText().isEmpty() || red.getText().isEmpty() || tva.getText().isEmpty() || eco.getText().isEmpty()))
            JOptionPane.showMessageDialog(null, "Există câmpuri necompletate.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
        else{
        String fac=nrf.getText().toString();
        String distribuitor=dis.getSelectedItem().toString();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String data=formatter.format(date);
        SimpleDateFormat formatter2= new SimpleDateFormat("HH:mm:ss");
        Date time = new Date(System.currentTimeMillis());
        String ora=formatter2.format(time);
        String quant=cant.getText().toString();
        String costA=cost.getText().toString();
        String aidi="", aidiha="";
        if(ANouaProdELabel.isSelected())
        {
             try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie","root","");  
            Statement stmt=con.createStatement();
            stmt.executeUpdate("update tip_produs set in_stoc=in_stoc+"+quant+" where idp=(select idp from tip_produs where denumire='"+prod.getSelectedItem().toString()+"');");
            //System.out.println("check");
            con.close();
            }
        catch(Exception e){ System.out.println(e);}  
        }
        else if(ANouaProdNLabel.isSelected())
        {
            try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie","root","");  
            Statement stmt=con.createStatement();
            stmt.executeUpdate("insert into tip_produs values ("+codp.getText().toString()+", '"+prod1.getText().toString()+"', '"+
                    cat.getSelectedItem().toString()+"', '"+subcat.getText().toString()+"', "+quant+", "+pret.getText().toString()+", '"+
                    um.getText().toString()+"', "+red.getText().toString()+", "+tva.getText().toString()+", "+eco.getText().toString()+");");
            con.close();
            }
        catch(Exception e){ System.out.println(e);}}
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie","root","");  
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select idp from tip_produs where denumire='"+prod.getSelectedItem().toString()+"';");
            if(rs.next())
                aidi=rs.getString(1);
            
            //Statement stmt1=con.createStatement();
            String eee="select cui from distribuitor where nume='"+distribuitor+"';";
            ResultSet rs1=stmt.executeQuery(eee);
            if(rs1.next())
                aidiha=rs1.getString(1);
            Statement stmt2=con.createStatement();
            String que="insert into achizitie values ("+fac+", "+aidiha+", "+aidi+", '"+data+"', '"+ora+"', "+quant+", "+costA+");";
            System.out.println(que);
            stmt2.executeUpdate(que);
            con.close();
            }
        catch(Exception e){ System.out.println(e);}  
        }
    }//GEN-LAST:event_ANouaAddButtonActionPerformed

    private void ANouaBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANouaBackButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new Meniu().setVisible(true);
    }//GEN-LAST:event_ANouaBackButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AchNoua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AchNoua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AchNoua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AchNoua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AchNoua().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ANouaAddButton;
    private javax.swing.JButton ANouaBackButton;
    private javax.swing.JLabel ANouaCantLabel;
    private javax.swing.JLabel ANouaCatLabel;
    private javax.swing.JLabel ANouaCodLabel;
    private javax.swing.JLabel ANouaCostLabel;
    private javax.swing.JLabel ANouaDenLabel;
    private javax.swing.JLabel ANouaDisLabel;
    private javax.swing.JLabel ANouaEcoLabel;
    private javax.swing.JLabel ANouaNrfLabel;
    private javax.swing.JLabel ANouaPretLabel;
    private javax.swing.JCheckBox ANouaProdELabel;
    private javax.swing.JLabel ANouaProdLabel;
    private javax.swing.JCheckBox ANouaProdNLabel;
    private javax.swing.JLabel ANouaRedLabel;
    private javax.swing.JLabel ANouaSubcatLabel;
    private javax.swing.JLabel ANouaTVALabel;
    private javax.swing.JLabel ANouaUMLabel;
    private javax.swing.JPanel AchNouaPanel;
    private javax.swing.JTextField cant;
    private javax.swing.JComboBox<String> cat;
    private javax.swing.JTextField codp;
    private javax.swing.JTextField cost;
    private javax.swing.JComboBox<String> dis;
    private javax.swing.JTextField eco;
    private javax.swing.JTextField nrf;
    private javax.swing.JTextField pret;
    private javax.swing.JComboBox<String> prod;
    private javax.swing.JTextField prod1;
    private javax.swing.JTextField red;
    private javax.swing.JTextField subcat;
    private javax.swing.JTextField tva;
    private javax.swing.JTextField um;
    // End of variables declaration//GEN-END:variables
}
