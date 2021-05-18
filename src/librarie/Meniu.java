/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarie;

import java.awt.Color;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.*;
import static librarie.Profil.cuteID;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

/**
 *
 * @author camel
 */
public class Meniu extends javax.swing.JFrame {

    /**
     * Creates new form Meniu
     */
    static String admin = LogIn.adm;
    static String niceID = LogIn.lovelyID;
    String hostname = "Unknown";
    static String nm;
    static String pr;
    static String cn;
    static String tl;
    int countDis, countAch, countPro, countBon, countAng;

    public Meniu() {

        initComponents();
        //System.out.println(admin);
        if (admin.equals("Nu")) {
            MeniuAngButton.setVisible(false);
        }

        MeniuIDLabel.setText("ID: " + niceID);

        try {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
            MeniuTerminalLabel.setText("Terminal: " + hostname);
        } catch (UnknownHostException ex) {
            System.out.println("Hostname can not be resolved");
        }

        //////////////// DISTRIBUITORI //////////////
        dcui.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = dcui.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' && l < 10) || ke.getKeyChar() == 8) {
                    dcui.setEditable(true);
                } else {
                    dcui.setEditable(false);
                }
            }
        });
        dnum.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = dnum.getText();
                int l = value.length();
                if (l < 50 || ke.getKeyChar() == 8) {
                    dnum.setEditable(true);
                } else {
                    dnum.setEditable(false);
                }
            }
        });
        dadr.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = dadr.getText();
                int l = value.length();
                if (l < 50 || ke.getKeyChar() == 8) {
                    dadr.setEditable(true);
                } else {
                    dadr.setEditable(false);
                }
            }
        });
        dtel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = dtel.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' && l < 10) || ke.getKeyChar() == 8) {
                    dtel.setEditable(true);
                } else {
                    dtel.setEditable(false);
                }
            }
        });

        dact.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
            }
        });
        MeniuAngButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
            }
        });

        /////////////// ANGAJATI ////////////////
        idA.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = idA.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' && l < 11) || ke.getKeyChar() == 8) {
                    idA.setEditable(true);
                } else {
                    idA.setEditable(false);
                }
            }
        });

        numeA.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = numeA.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'z' && l < 20) || ke.getKeyChar() == 8 || ke.getKeyChar() == ' ') {
                    numeA.setEditable(true);
                } else {
                    numeA.setEditable(false);
                }
            }
        });

        prenA.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = prenA.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'z' && l < 30) || ke.getKeyChar() == 8 || ke.getKeyChar() == ' ') {
                    prenA.setEditable(true);
                } else {
                    prenA.setEditable(false);
                }
            }
        });

        Tabdis.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int row = Tabdis.getSelectedRow();
                    dcui.setText(Tabdis.getModel().getValueAt(row, 0).toString());
                    dnum.setText(Tabdis.getModel().getValueAt(row, 1).toString());
                    dadr.setText(Tabdis.getModel().getValueAt(row, 2).toString());
                    dtel.setText(Tabdis.getModel().getValueAt(row, 3).toString());
                    dact.setSelectedItem(Tabdis.getModel().getValueAt(row, 4));
                }
            }
        });

        Tabang.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int row = Tabang.getSelectedRow();
                    idA.setText(Tabang.getModel().getValueAt(row, 0).toString());
                    numeA.setText(Tabang.getModel().getValueAt(row, 1).toString());
                    prenA.setText(Tabang.getModel().getValueAt(row, 2).toString());
                    admA.setSelectedItem(Tabang.getModel().getValueAt(row, 3));
                    actA.setSelectedItem(Tabang.getModel().getValueAt(row, 5));
                }
            }
        });

    }

    public void ClearTable(javax.swing.JTable tab) {
        DefaultTableModel dm = (DefaultTableModel) tab.getModel();
        int rowCount = dm.getRowCount();
//Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MeniuPanel = new javax.swing.JPanel();
        MeniuTopPanel = new javax.swing.JPanel();
        MeniuTitluLabel = new javax.swing.JLabel();
        MeniuLogOutButton = new javax.swing.JButton();
        MeniuIDLabel = new javax.swing.JLabel();
        MeniuTerminalLabel = new javax.swing.JLabel();
        MeniuSetariButton = new javax.swing.JButton();
        MeniuNavPanel = new javax.swing.JPanel();
        MeniuDisButton = new javax.swing.JButton();
        MeniuProdButton = new javax.swing.JButton();
        MeniuBonButton = new javax.swing.JButton();
        MeniuAchButton = new javax.swing.JButton();
        MeniuAngButton = new javax.swing.JButton();
        MeniuCenterPanel = new javax.swing.JPanel();
        distrib = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabdis = new javax.swing.JTable();
        DisCUILabel = new javax.swing.JLabel();
        DisNumLabel = new javax.swing.JLabel();
        DisAdrLabel = new javax.swing.JLabel();
        DisTelLabel = new javax.swing.JLabel();
        dcui = new javax.swing.JTextField();
        dnum = new javax.swing.JTextField();
        dadr = new javax.swing.JTextField();
        dtel = new javax.swing.JTextField();
        DisAddButton = new javax.swing.JButton();
        DisDelButton = new javax.swing.JButton();
        DisSaveButton = new javax.swing.JButton();
        DisShowButton = new javax.swing.JButton();
        DisActLabel = new javax.swing.JLabel();
        dact = new javax.swing.JComboBox<>();
        DisClearButton = new javax.swing.JButton();
        DisExpButton = new javax.swing.JButton();
        DisImpButton = new javax.swing.JButton();
        achiz = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabach = new javax.swing.JTable();
        AchShowButton = new javax.swing.JButton();
        AchAddButton = new javax.swing.JButton();
        AchExpButton = new javax.swing.JButton();
        AchImpButton = new javax.swing.JButton();
        prods = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabpro = new javax.swing.JTable();
        ProdShowButton = new javax.swing.JButton();
        ProdSearchField = new javax.swing.JTextField();
        ProdExpButton = new javax.swing.JButton();
        ProdImpButton = new javax.swing.JButton();
        bonf = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tabbon = new javax.swing.JTable();
        BonAddButton = new javax.swing.JButton();
        BonShowButton = new javax.swing.JButton();
        BonDelButton = new javax.swing.JButton();
        BonExpButton = new javax.swing.JButton();
        BonImpButton = new javax.swing.JButton();
        ang = new javax.swing.JPanel();
        AngDelButton = new javax.swing.JButton();
        AngShowButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        Tabang = new javax.swing.JTable();
        AngIDLabel = new javax.swing.JLabel();
        AngNumLabel = new javax.swing.JLabel();
        AngPrenLabel = new javax.swing.JLabel();
        AngAdmLabel = new javax.swing.JLabel();
        AngActLabel = new javax.swing.JLabel();
        idA = new javax.swing.JTextField();
        numeA = new javax.swing.JTextField();
        prenA = new javax.swing.JTextField();
        admA = new javax.swing.JComboBox<>();
        actA = new javax.swing.JComboBox<>();
        AngClearButton = new javax.swing.JButton();
        AngSaveButton = new javax.swing.JButton();
        AngExpButton = new javax.swing.JButton();
        AngImpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MeniuPanel.setLayout(new java.awt.BorderLayout());

        MeniuTopPanel.setBackground(new java.awt.Color(240, 219, 239));

        MeniuTitluLabel.setFont(new java.awt.Font("Serif", 2, 48)); // NOI18N
        MeniuTitluLabel.setText("Librărie");

        MeniuLogOutButton.setBackground(new java.awt.Color(255, 181, 198));
        MeniuLogOutButton.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        MeniuLogOutButton.setForeground(new java.awt.Color(102, 0, 102));
        MeniuLogOutButton.setText("LOG OUT");
        MeniuLogOutButton.setMargin(new java.awt.Insets(5, 5, 2, 5));
        MeniuLogOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MeniuLogOutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MeniuLogOutButtonMouseExited(evt);
            }
        });
        MeniuLogOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeniuLogOutButtonActionPerformed(evt);
            }
        });

        MeniuIDLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        MeniuIDLabel.setText("ID:");

        MeniuTerminalLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        MeniuTerminalLabel.setText("Terminal:");

        MeniuSetariButton.setBackground(new java.awt.Color(255, 181, 198));
        MeniuSetariButton.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        MeniuSetariButton.setForeground(new java.awt.Color(102, 0, 102));
        MeniuSetariButton.setText("SETĂRI PROFIL");
        MeniuSetariButton.setMargin(new java.awt.Insets(5, 5, 2, 5));
        MeniuSetariButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MeniuSetariButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MeniuSetariButtonMouseExited(evt);
            }
        });
        MeniuSetariButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeniuSetariButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MeniuTopPanelLayout = new javax.swing.GroupLayout(MeniuTopPanel);
        MeniuTopPanel.setLayout(MeniuTopPanelLayout);
        MeniuTopPanelLayout.setHorizontalGroup(
            MeniuTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MeniuTopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MeniuTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MeniuIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MeniuTerminalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
                .addGap(103, 103, 103)
                .addComponent(MeniuTitluLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(MeniuSetariButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MeniuLogOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        MeniuTopPanelLayout.setVerticalGroup(
            MeniuTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MeniuTopPanelLayout.createSequentialGroup()
                .addGroup(MeniuTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MeniuTopPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(MeniuIDLabel)
                        .addGap(18, 18, 18)
                        .addComponent(MeniuTerminalLabel))
                    .addGroup(MeniuTopPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(MeniuTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MeniuTitluLabel)
                            .addGroup(MeniuTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(MeniuSetariButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MeniuLogOutButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        MeniuPanel.add(MeniuTopPanel, java.awt.BorderLayout.PAGE_START);

        MeniuNavPanel.setBackground(new java.awt.Color(255, 181, 198));
        MeniuNavPanel.setPreferredSize(new java.awt.Dimension(150, 436));

        MeniuDisButton.setBackground(new java.awt.Color(255, 181, 198));
        MeniuDisButton.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        MeniuDisButton.setForeground(new java.awt.Color(102, 0, 102));
        MeniuDisButton.setText("DISTRIBUITORI");
        MeniuDisButton.setMargin(new java.awt.Insets(5, 5, 2, 5));
        MeniuDisButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MeniuDisButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MeniuDisButtonMouseExited(evt);
            }
        });
        MeniuDisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeniuDisButtonActionPerformed(evt);
            }
        });

        MeniuProdButton.setBackground(new java.awt.Color(255, 181, 198));
        MeniuProdButton.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        MeniuProdButton.setForeground(new java.awt.Color(102, 0, 102));
        MeniuProdButton.setText("PRODUSE");
        MeniuProdButton.setMargin(new java.awt.Insets(5, 5, 2, 5));
        MeniuProdButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MeniuProdButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MeniuProdButtonMouseExited(evt);
            }
        });
        MeniuProdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeniuProdButtonActionPerformed(evt);
            }
        });

        MeniuBonButton.setBackground(new java.awt.Color(255, 181, 198));
        MeniuBonButton.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        MeniuBonButton.setForeground(new java.awt.Color(102, 0, 102));
        MeniuBonButton.setText("BONURI FISCALE");
        MeniuBonButton.setMargin(new java.awt.Insets(5, 5, 2, 5));
        MeniuBonButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MeniuBonButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MeniuBonButtonMouseExited(evt);
            }
        });
        MeniuBonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeniuBonButtonActionPerformed(evt);
            }
        });

        MeniuAchButton.setBackground(new java.awt.Color(255, 181, 198));
        MeniuAchButton.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        MeniuAchButton.setForeground(new java.awt.Color(102, 0, 102));
        MeniuAchButton.setText("ACHIZIȚII");
        MeniuAchButton.setMargin(new java.awt.Insets(5, 5, 2, 5));
        MeniuAchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MeniuAchButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MeniuAchButtonMouseExited(evt);
            }
        });
        MeniuAchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeniuAchButtonActionPerformed(evt);
            }
        });

        MeniuAngButton.setBackground(new java.awt.Color(255, 181, 198));
        MeniuAngButton.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        MeniuAngButton.setForeground(new java.awt.Color(102, 0, 102));
        MeniuAngButton.setText("ANGAJAȚI");
        MeniuAngButton.setMargin(new java.awt.Insets(5, 5, 2, 5));
        MeniuAngButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MeniuAngButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MeniuAngButtonMouseExited(evt);
            }
        });
        MeniuAngButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeniuAngButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MeniuNavPanelLayout = new javax.swing.GroupLayout(MeniuNavPanel);
        MeniuNavPanel.setLayout(MeniuNavPanelLayout);
        MeniuNavPanelLayout.setHorizontalGroup(
            MeniuNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MeniuNavPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MeniuNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MeniuDisButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MeniuProdButton, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(MeniuBonButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(MeniuAchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(MeniuAngButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addContainerGap())
        );
        MeniuNavPanelLayout.setVerticalGroup(
            MeniuNavPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MeniuNavPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(MeniuDisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(MeniuAchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(MeniuProdButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(MeniuBonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(MeniuAngButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        MeniuPanel.add(MeniuNavPanel, java.awt.BorderLayout.LINE_START);

        MeniuCenterPanel.setBackground(new java.awt.Color(255, 247, 240));
        MeniuCenterPanel.setLayout(new java.awt.CardLayout());

        distrib.setBackground(new java.awt.Color(255, 247, 240));
        distrib.setToolTipText("Golește câmpurile");
        distrib.setName(""); // NOI18N

        Tabdis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod Unic de Identificare", "Nume distribuitor", "Adresă", "Telefon", "Colaborare activă"
            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    Tabdis.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    jScrollPane1.setViewportView(Tabdis);

    DisCUILabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
    DisCUILabel.setText("Cod Unic de Identificare:");

    DisNumLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
    DisNumLabel.setText("Nume distribuitor:");

    DisAdrLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
    DisAdrLabel.setText("Adresă:");

    DisTelLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
    DisTelLabel.setText("Telefon:");

    dcui.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            dcuiActionPerformed(evt);
        }
    });

    DisAddButton.setText("Adaugă");
    DisAddButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            DisAddButtonActionPerformed(evt);
        }
    });

    DisDelButton.setText("Șterge");
    DisDelButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            DisDelButtonActionPerformed(evt);
        }
    });

    DisSaveButton.setText("Salvează");
    DisSaveButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            DisSaveButtonActionPerformed(evt);
        }
    });

    DisShowButton.setText("Afișează");
    DisShowButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            DisShowButtonActionPerformed(evt);
        }
    });

    DisActLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
    DisActLabel.setText("Activ:");

    dact.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Da", "Nu", " " }));

    DisClearButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
    DisClearButton.setText("X");
    DisClearButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
    DisClearButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            DisClearButtonActionPerformed(evt);
        }
    });

    DisExpButton.setText("Export as XLS");
    DisExpButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            DisExpButtonActionPerformed(evt);
        }
    });

    DisImpButton.setText("Import XLS");
    DisImpButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            DisImpButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout distribLayout = new javax.swing.GroupLayout(distrib);
    distrib.setLayout(distribLayout);
    distribLayout.setHorizontalGroup(
        distribLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(distribLayout.createSequentialGroup()
            .addGap(24, 24, 24)
            .addGroup(distribLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(distribLayout.createSequentialGroup()
                    .addComponent(DisImpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(34, 34, 34)
                    .addComponent(DisExpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(distribLayout.createSequentialGroup()
                    .addGroup(distribLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(DisCUILabel)
                        .addComponent(DisNumLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(DisAdrLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(DisTelLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGap(18, 18, 18)
                    .addGroup(distribLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(distribLayout.createSequentialGroup()
                            .addComponent(dcui, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(171, 171, 171)
                            .addComponent(DisClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(distribLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dadr, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addGroup(distribLayout.createSequentialGroup()
                                .addComponent(dtel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(DisActLabel)
                                .addGap(31, 31, 31)
                                .addComponent(dact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dnum)))
                    .addGap(106, 106, 106)
                    .addGroup(distribLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(DisAddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DisDelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DisSaveButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DisShowButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(133, Short.MAX_VALUE))
    );
    distribLayout.setVerticalGroup(
        distribLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, distribLayout.createSequentialGroup()
            .addGroup(distribLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(distribLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(distribLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(distribLayout.createSequentialGroup()
                            .addGroup(distribLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(dcui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(DisCUILabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(DisNumLabel)
                            .addGap(7, 7, 7))
                        .addGroup(distribLayout.createSequentialGroup()
                            .addComponent(DisClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(dnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(10, 10, 10)
                    .addGroup(distribLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dadr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DisAdrLabel))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(distribLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dtel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DisTelLabel)
                        .addComponent(DisActLabel)
                        .addComponent(dact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(distribLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(distribLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(distribLayout.createSequentialGroup()
                            .addComponent(DisAddButton)
                            .addGap(35, 35, 35))
                        .addComponent(DisDelButton))
                    .addGap(9, 9, 9)
                    .addComponent(DisSaveButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(DisShowButton)
                    .addGap(18, 18, 18)))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(distribLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(DisExpButton)
                .addComponent(DisImpButton))
            .addGap(34, 34, 34))
    );

    MeniuCenterPanel.add(distrib, "card2");

    achiz.setBackground(new java.awt.Color(255, 247, 240));

    Tabach.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Nr. de factură", "Distribuitor", "Produs", "Data", "Ora", "Cantitate", "Cost"
        }
    )
    {public boolean isCellEditable(int row, int column){return false;}}
    );
    Tabach.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    jScrollPane2.setViewportView(Tabach);

    AchShowButton.setText("Vezi achizițiile");
    AchShowButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            AchShowButtonActionPerformed(evt);
        }
    });

    AchAddButton.setText("Adaugă achiziție");
    AchAddButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            AchAddButtonActionPerformed(evt);
        }
    });

    AchExpButton.setText("Export as XLS");
    AchExpButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            AchExpButtonActionPerformed(evt);
        }
    });

    AchImpButton.setText("Import XLS");
    AchImpButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            AchImpButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout achizLayout = new javax.swing.GroupLayout(achiz);
    achiz.setLayout(achizLayout);
    achizLayout.setHorizontalGroup(
        achizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, achizLayout.createSequentialGroup()
            .addGroup(achizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(achizLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(AchExpButton))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, achizLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(achizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(achizLayout.createSequentialGroup()
                            .addComponent(AchAddButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 472, Short.MAX_VALUE)
                            .addComponent(AchShowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGap(84, 84, 84))
        .addGroup(achizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(achizLayout.createSequentialGroup()
                .addGap(502, 502, 502)
                .addComponent(AchImpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE)))
    );
    achizLayout.setVerticalGroup(
        achizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, achizLayout.createSequentialGroup()
            .addContainerGap(34, Short.MAX_VALUE)
            .addGroup(achizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(AchShowButton)
                .addComponent(AchAddButton))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(AchExpButton)
            .addGap(27, 27, 27))
        .addGroup(achizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(achizLayout.createSequentialGroup()
                .addGap(385, 385, 385)
                .addComponent(AchImpButton)
                .addContainerGap(28, Short.MAX_VALUE)))
    );

    MeniuCenterPanel.add(achiz, "card3");

    prods.setBackground(new java.awt.Color(255, 247, 240));

    Tabpro.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Cod produs", "Denumire", "Categorie", "Subcategorie", "În stoc", "Pret per unitate (RON)", "Unitate de măsură", "Reducere (în procente)", "TVA(în procente)", "Taxa ecologică (RON)"
        }
    )
    {public boolean isCellEditable(int row, int column){return false;}}
    );
    Tabpro.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    jScrollPane3.setViewportView(Tabpro);

    ProdShowButton.setText("Vezi produsele");
    ProdShowButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ProdShowButtonActionPerformed(evt);
        }
    });

    ProdExpButton.setText("Export as XLS");
    ProdExpButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ProdExpButtonActionPerformed(evt);
        }
    });

    ProdImpButton.setText("Import XLS");
    ProdImpButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ProdImpButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout prodsLayout = new javax.swing.GroupLayout(prods);
    prods.setLayout(prodsLayout);
    prodsLayout.setHorizontalGroup(
        prodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(prodsLayout.createSequentialGroup()
            .addGap(42, 42, 42)
            .addGroup(prodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(prodsLayout.createSequentialGroup()
                    .addComponent(ProdImpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(ProdExpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(prodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(prodsLayout.createSequentialGroup()
                        .addComponent(ProdSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ProdShowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(105, Short.MAX_VALUE))
    );
    prodsLayout.setVerticalGroup(
        prodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, prodsLayout.createSequentialGroup()
            .addContainerGap(33, Short.MAX_VALUE)
            .addGroup(prodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(ProdShowButton)
                .addComponent(ProdSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(prodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(ProdExpButton)
                .addComponent(ProdImpButton))
            .addGap(24, 24, 24))
    );

    MeniuCenterPanel.add(prods, "card4");

    bonf.setBackground(new java.awt.Color(255, 247, 240));

    Tabbon.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Nr. bon", "Terminal", "Angajat", "Data", "Ora", "Număr de produse", "Pret total", "Tip plata", "Numerar", "Rest", "Card"
        }
    ));
    Tabbon.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    jScrollPane4.setViewportView(Tabbon);

    BonAddButton.setText("Adaugă bon");

    BonShowButton.setText("Vezi bonuri");
    BonShowButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BonShowButtonActionPerformed(evt);
        }
    });

    BonDelButton.setText("Șterge bon");
    BonDelButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BonDelButtonActionPerformed(evt);
        }
    });

    BonExpButton.setText("Export as XLS");
    BonExpButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BonExpButtonActionPerformed(evt);
        }
    });

    BonImpButton.setText("Import XLS");
    BonImpButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BonImpButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout bonfLayout = new javax.swing.GroupLayout(bonf);
    bonf.setLayout(bonfLayout);
    bonfLayout.setHorizontalGroup(
        bonfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bonfLayout.createSequentialGroup()
            .addGroup(bonfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(bonfLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(BonImpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)
                    .addComponent(BonExpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bonfLayout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(bonfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bonfLayout.createSequentialGroup()
                            .addComponent(BonAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(BonDelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 345, Short.MAX_VALUE)
                            .addComponent(BonShowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGap(81, 81, 81))
    );
    bonfLayout.setVerticalGroup(
        bonfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bonfLayout.createSequentialGroup()
            .addContainerGap(34, Short.MAX_VALUE)
            .addGroup(bonfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(BonAddButton)
                .addComponent(BonShowButton)
                .addComponent(BonDelButton))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(bonfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(BonExpButton)
                .addComponent(BonImpButton))
            .addGap(23, 23, 23))
    );

    MeniuCenterPanel.add(bonf, "card5");

    ang.setBackground(new java.awt.Color(255, 247, 240));

    AngDelButton.setText("Șterge angajat");
    AngDelButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            AngDelButtonActionPerformed(evt);
        }
    });

    AngShowButton.setText("Vezi angajati");
    AngShowButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            AngShowButtonActionPerformed(evt);
        }
    });

    Tabang.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "ID Angajat", "Nume", "Prenume", "Admin", "Telefon", "Activ"
        }
    )
    {public boolean isCellEditable(int row, int column){return false;}}
    );
    Tabang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    jScrollPane5.setViewportView(Tabang);

    AngIDLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
    AngIDLabel.setText("ID");

    AngNumLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
    AngNumLabel.setText("Nume");

    AngPrenLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
    AngPrenLabel.setText("Prenume");

    AngAdmLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
    AngAdmLabel.setText("Admin");

    AngActLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
    AngActLabel.setText("Activ");

    admA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Da", "Nu", " " }));

    actA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Da", "Nu", " " }));

    AngClearButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
    AngClearButton.setText("X");
    AngClearButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            AngClearButtonActionPerformed(evt);
        }
    });

    AngSaveButton.setText("Salvează");
    AngSaveButton.setToolTipText("Se pot modifica doar calitățile Admin și Activ.");
    AngSaveButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            AngSaveButtonActionPerformed(evt);
        }
    });

    AngExpButton.setText("Export as XLS");
    AngExpButton.setToolTipText("");
    AngExpButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            AngExpButtonActionPerformed(evt);
        }
    });

    AngImpButton.setText("Import XLS");
    AngImpButton.setToolTipText("");
    AngImpButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            AngImpButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout angLayout = new javax.swing.GroupLayout(ang);
    ang.setLayout(angLayout);
    angLayout.setHorizontalGroup(
        angLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(angLayout.createSequentialGroup()
            .addGap(34, 34, 34)
            .addGroup(angLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(angLayout.createSequentialGroup()
                    .addComponent(AngImpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(AngExpButton)))
            .addGroup(angLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(angLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addGroup(angLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, angLayout.createSequentialGroup()
                            .addGroup(angLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(AngNumLabel)
                                .addComponent(AngIDLabel)
                                .addComponent(AngPrenLabel)
                                .addComponent(AngAdmLabel)
                                .addComponent(AngActLabel))
                            .addGap(18, 18, 18)
                            .addGroup(angLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(numeA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                .addComponent(admA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(actA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idA, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(prenA)))
                        .addComponent(AngDelButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(angLayout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(angLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(AngClearButton, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(AngSaveButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AngShowButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGap(76, 76, 76))
    );
    angLayout.setVerticalGroup(
        angLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, angLayout.createSequentialGroup()
            .addGroup(angLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(angLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(angLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(AngIDLabel)
                        .addComponent(idA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(angLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AngNumLabel)
                        .addComponent(numeA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(29, 29, 29)
                    .addGroup(angLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AngPrenLabel)
                        .addComponent(prenA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(25, 25, 25)
                    .addGroup(angLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AngAdmLabel)
                        .addComponent(admA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(34, 34, 34)
                    .addGroup(angLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AngActLabel)
                        .addComponent(actA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                    .addComponent(AngClearButton)
                    .addGap(18, 18, 18)
                    .addComponent(AngSaveButton)
                    .addGap(18, 18, 18)
                    .addComponent(AngShowButton))
                .addGroup(angLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
            .addGap(18, 18, 18)
            .addGroup(angLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(AngDelButton)
                .addComponent(AngExpButton)
                .addComponent(AngImpButton))
            .addGap(22, 22, 22))
    );

    MeniuCenterPanel.add(ang, "card6");

    MeniuPanel.add(MeniuCenterPanel, java.awt.BorderLayout.CENTER);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(MeniuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(MeniuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MeniuProdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeniuProdButtonActionPerformed
        // TODO add your handling code here:
        achiz.setVisible(false);
        bonf.setVisible(false);
        ang.setVisible(false);
        distrib.setVisible(false);
        prods.setVisible(true);
    }//GEN-LAST:event_MeniuProdButtonActionPerformed

    private void MeniuDisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeniuDisButtonActionPerformed
        // TODO add your handling code here:
        achiz.setVisible(false);
        prods.setVisible(false);
        bonf.setVisible(false);
        ang.setVisible(false);
        distrib.setVisible(true);
    }//GEN-LAST:event_MeniuDisButtonActionPerformed

    private void MeniuBonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeniuBonButtonActionPerformed
        // TODO add your handling code here:
        achiz.setVisible(false);
        prods.setVisible(false);
        ang.setVisible(false);
        distrib.setVisible(false);
        bonf.setVisible(true);
    }//GEN-LAST:event_MeniuBonButtonActionPerformed

    private void MeniuAchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeniuAchButtonActionPerformed
        // TODO add your handling code here:
        prods.setVisible(false);
        bonf.setVisible(false);
        ang.setVisible(false);
        distrib.setVisible(false);
        achiz.setVisible(true);
    }//GEN-LAST:event_MeniuAchButtonActionPerformed

    private void MeniuAngButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeniuAngButtonActionPerformed
        // TODO add your handling code here:
        achiz.setVisible(false);
        prods.setVisible(false);
        bonf.setVisible(false);
        distrib.setVisible(false);
        ang.setVisible(true);
    }//GEN-LAST:event_MeniuAngButtonActionPerformed

    private void MeniuDisButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeniuDisButtonMouseEntered
        this.MeniuDisButton.setBackground(Color.decode("#FFCCD8")); // TODO add your handling code here:
    }//GEN-LAST:event_MeniuDisButtonMouseEntered

    private void MeniuDisButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeniuDisButtonMouseExited
        // TODO add your handling code here:
        this.MeniuDisButton.setBackground(Color.decode("#FFB5C6"));
    }//GEN-LAST:event_MeniuDisButtonMouseExited

    private void MeniuAchButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeniuAchButtonMouseEntered
        // TODO add your handling code here:
        this.MeniuAchButton.setBackground(Color.decode("#FFCCD8"));
    }//GEN-LAST:event_MeniuAchButtonMouseEntered

    private void MeniuAchButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeniuAchButtonMouseExited
        // TODO add your handling code here:
        this.MeniuAchButton.setBackground(Color.decode("#FFB5C6"));
    }//GEN-LAST:event_MeniuAchButtonMouseExited

    private void MeniuProdButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeniuProdButtonMouseExited
        // TODO add your handling code here:
        this.MeniuProdButton.setBackground(Color.decode("#FFB5C6"));
    }//GEN-LAST:event_MeniuProdButtonMouseExited

    private void MeniuProdButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeniuProdButtonMouseEntered
        // TODO add your handling code here:
        this.MeniuProdButton.setBackground(Color.decode("#FFCCD8"));
    }//GEN-LAST:event_MeniuProdButtonMouseEntered

    private void MeniuBonButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeniuBonButtonMouseEntered
        // TODO add your handling code here:
        this.MeniuBonButton.setBackground(Color.decode("#FFCCD8"));
    }//GEN-LAST:event_MeniuBonButtonMouseEntered

    private void MeniuBonButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeniuBonButtonMouseExited
        // TODO add your handling code here:
        this.MeniuBonButton.setBackground(Color.decode("#FFB5C6"));
    }//GEN-LAST:event_MeniuBonButtonMouseExited

    private void MeniuAngButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeniuAngButtonMouseEntered
        // TODO add your handling code here:
        this.MeniuAngButton.setBackground(Color.decode("#FFCCD8"));
    }//GEN-LAST:event_MeniuAngButtonMouseEntered

    private void MeniuAngButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeniuAngButtonMouseExited
        // TODO add your handling code here:
        this.MeniuAngButton.setBackground(Color.decode("#FFB5C6"));
    }//GEN-LAST:event_MeniuAngButtonMouseExited

    private void DisShowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisShowButtonActionPerformed
        countDis = 0;
        ClearTable(Tabdis);
        DefaultTableModel tdis = (DefaultTableModel) Tabdis.getModel();
        String que = "select * from distribuitor";
        int start = 0;
        if (!dcui.getText().toString().isEmpty()) {
            start = 1;
            que += " where cui=" + dcui.getText().toString();
        }
        if (!dnum.getText().toString().isEmpty()) {
            if (start == 1) {
                que += " and ";
            } else {
                start = 1;
                que += " where ";
            }
            que += "nume like '%" + dnum.getText().toString() + "%'";
        }
        if (!dadr.getText().toString().isEmpty()) {
            if (start == 1) {
                que += " and ";
            } else {
                start = 1;
                que += " where ";
            }
            que += "adresa like '%" + dadr.getText().toString() + "%'";
        }
        if (!dtel.getText().toString().isEmpty()) {
            if (start == 1) {
                que += " and ";
            } else {
                start = 1;
                que += " where ";
            }
            que += "telefon='" + dtel.getText().toString() + "'";
        }
        if (dact.getSelectedItem().toString().equals("Da") || dact.getSelectedItem().toString().equals("Nu")) {
            if (start == 1) {
                que += " and ";
            } else {
                start = 1;
                que += " where ";
            }
            que += "col_activa='" + dact.getSelectedItem().toString() + "'";
        }
        que += ";";
        System.out.println(que);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(que);
            while (rs.next()) {
                int cui = rs.getInt(1);
                String nm = rs.getString(2);
                String adr = rs.getString(3);
                String tlf = rs.getString(4);
                String act = rs.getString(5);
                //System.out.println(cui+"  "+nm+"  "+adr+"  "+tlf);
                tdis.addRow(new Object[]{cui, nm, adr, tlf, act});
                countDis++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_DisShowButtonActionPerformed

    private void AchShowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AchShowButtonActionPerformed
        countAch = 0;
        ClearTable(Tabach);
        DefaultTableModel tach = (DefaultTableModel) Tabach.getModel();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select nrf, Nume, denumire, data, ora, cantitate, cost from `achizitie`, `distribuitor`, `tip_produs` \n"
                    + "where achizitie.CUI=distribuitor.CUI and achizitie.idp=tip_produs.idp;");
            while (rs.next()) {
                int nrf = rs.getInt(1);
                String nd = rs.getString(2);
                String den = rs.getString(3);
                String dt = rs.getString(4);
                String ora = rs.getString(5);
                String cant = rs.getString(6);
                float cost = rs.getFloat(7);
                tach.addRow(new Object[]{nrf, nd, den, dt, ora, cant, cost});
                countAch++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_AchShowButtonActionPerformed

    private void ProdShowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdShowButtonActionPerformed
        countPro = 0;
        ClearTable(Tabpro);
        String que;
        if (ProdSearchField.getText().isEmpty()) {
            que = "select * from `tip_produs`;";
        } else {
            String cheie = ProdSearchField.getText().toString();
            que = "select * from `tip_produs` where denumire like '%" + cheie + "%' or categorie like '%" + cheie + "%' or subcategorie like '%" + cheie + "%';";
            System.out.println(que);
        }
        DefaultTableModel tpro = (DefaultTableModel) Tabpro.getModel();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(que);
            while (rs.next()) {
                int idp = rs.getInt(1);
                String den = rs.getString(2);
                String cat = rs.getString(3);
                String subcat = rs.getString(4);
                int stoc = rs.getInt(5);
                float ini = rs.getFloat(6);
                String um = rs.getString(7);
                int red = rs.getInt(8);
                int t = rs.getInt(9);
                int eco = rs.getInt(10);
                tpro.addRow(new Object[]{idp, den, cat, subcat, stoc, ini, um, red, t, eco});
                countPro++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_ProdShowButtonActionPerformed

    private void BonShowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BonShowButtonActionPerformed
        countBon = 0;
        ClearTable(Tabbon);
        DefaultTableModel tbon = (DefaultTableModel) Tabbon.getModel();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idb,terminal,concat(nume,' ',prenume),data,ora,nr_de_prod,pret_total,tip_plata,numerar,rest,card from bon_fiscal,angajat where bon_fiscal.ida=angajat.ida;");
            while (rs.next()) {
                int idb = rs.getInt(1);
                String term = rs.getString(2);
                String ang = rs.getString(3);
                String dt = rs.getString(4);
                String h = rs.getString(5);
                int nr = rs.getInt(6);
                float pr = rs.getFloat(7);
                String tip = rs.getString(8);
                float num = rs.getFloat(9);
                float rest = rs.getFloat(10);
                String card = rs.getString(11);
                tbon.addRow(new Object[]{idb, term, ang, dt, h, nr, pr, tip, num, rest, card});
                countBon++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_BonShowButtonActionPerformed

    private void AngShowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AngShowButtonActionPerformed
        countAng = 0;
        ClearTable(Tabang);
        DefaultTableModel tpro = (DefaultTableModel) Tabang.getModel();
        String que = "select ida, nume, prenume, admin, telefon, activ from angajat";
        int start = 0;
        if (!idA.getText().toString().isEmpty()) {
            start = 1;
            que += " where ida=" + idA.getText().toString();
        }
        if (!numeA.getText().toString().isEmpty()) {
            if (start == 1) {
                que += " and ";
            } else {
                start = 1;
                que += " where ";
            }
            que += "nume like '%" + numeA.getText().toString() + "%'";
        }
        if (!prenA.getText().toString().isEmpty()) {
            if (start == 1) {
                que += " and ";
            } else {
                start = 1;
                que += " where ";
            }
            que += "prenume like '%" + prenA.getText().toString() + "%'";
        }
        if (admA.getSelectedItem().toString().equals("Da") || admA.getSelectedItem().toString().equals("Nu")) {
            if (start == 1) {
                que += " and ";
            } else {
                start = 1;
                que += " where ";
            }
            que += "admin='" + admA.getSelectedItem().toString() + "'";
        }
        if (actA.getSelectedItem().toString().equals("Da") || actA.getSelectedItem().toString().equals("Nu")) {
            if (start == 1) {
                que += " and ";
            } else {
                start = 1;
                que += " where ";
            }
            que += "activ='" + actA.getSelectedItem().toString() + "'";
        }
        que += ";";
        System.out.println(que);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(que);
            while (rs.next()) {
                int ida = rs.getInt(1);
                String nm = rs.getString(2);
                String pren = rs.getString(3);
                String adm = rs.getString(4);
                String tlf = rs.getString(5);
                String act = rs.getString(6);
                tpro.addRow(new Object[]{ida, nm, pren, adm, tlf, act});
                countAng++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_AngShowButtonActionPerformed

    private void MeniuLogOutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeniuLogOutButtonMouseEntered
        this.MeniuLogOutButton.setBackground(Color.decode("#FFCCD8"));
    }//GEN-LAST:event_MeniuLogOutButtonMouseEntered

    private void MeniuLogOutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeniuLogOutButtonMouseExited
        this.MeniuLogOutButton.setBackground(Color.decode("#FFB5C6"));
    }//GEN-LAST:event_MeniuLogOutButtonMouseExited

    private void MeniuLogOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeniuLogOutButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new LogIn().setVisible(true);
    }//GEN-LAST:event_MeniuLogOutButtonActionPerformed

    private void DisAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisAddButtonActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (dcui.getText().isEmpty() || dnum.getText().isEmpty() || dadr.getText().isEmpty() || dtel.getText().isEmpty() || dact.getSelectedItem().toString().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Există câmpuri necompletate.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie", "root", "");
                Statement stmt = con.createStatement();
                Statement stmt2 = con.createStatement();
                ResultSet rs = stmt2.executeQuery("select cui from `distribuitor` where cui=" + dcui.getText().toString() + ";");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Există deja un distribuitor cu acest Cod Unic de Identificare.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    stmt.executeUpdate("insert into `distribuitor` values (" + dcui.getText().toString() + ", '"
                            + dnum.getText().toString() + "', '" + dadr.getText().toString() + "', '" + dtel.getText().toString() + "', '" + dact.getSelectedItem().toString() + "');");
                    JOptionPane.showMessageDialog(null, "Distribuitorul a fost adăugat cu succes.", "Notificare", JOptionPane.INFORMATION_MESSAGE);
                }
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_DisAddButtonActionPerformed

    private void DisDelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisDelButtonActionPerformed
        // TODO add your handling code here:
        int yon = JOptionPane.showConfirmDialog(null, "Dacă alegeți yes, vor fi șterse și achizițiile de la acest distribuitor. Dacă doriți să marcați încheierea colaborării\nfără a șterge istoricul achizițiilor, apăsați no și modificați câmpul „Colaborare activă”.", "Confirmare", JOptionPane.YES_NO_OPTION);
        if (yon == 0) {
            int column = 0;
            int row = Tabdis.getSelectedRow();
            String indice = Tabdis.getModel().getValueAt(row, column).toString();
            System.out.println(column + " " + row + " " + indice);
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie", "root", "");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("delete from `achizitie` where cui=" + indice + ";");
                stmt.executeUpdate("delete from `distribuitor` where cui=" + indice + ";");
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            DefaultTableModel model = (DefaultTableModel) Tabdis.getModel();
            model.removeRow(row);
        }

    }//GEN-LAST:event_DisDelButtonActionPerformed

    private void AngDelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AngDelButtonActionPerformed
        // TODO add your handling code here:
        int yon = JOptionPane.showConfirmDialog(null, "Dacă alegeți yes, vor fi șterse și bonurile fiscale emise de acest angajat. Dacă doriți să marcați încheierea colaborării\nfără a șterge istoricul vânzărilor, apăsați no și modificați câmpul „Activ”.", "Confirmare", JOptionPane.YES_NO_OPTION);
        if (yon == 0) {
            int column = 0;
            int row = Tabang.getSelectedRow();
            String indice = Tabang.getModel().getValueAt(row, column).toString();
            System.out.println(column + " " + row + " " + indice);
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie", "root", "");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("delete from `vandut` where idb in (select idb from `bon_fiscal` where ida=" + indice + ");");
                stmt.executeUpdate("delete from `bon_fiscal` where ida=" + indice + ";");
                stmt.executeUpdate("delete from `angajat` where ida=" + indice + ";");
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            DefaultTableModel model = (DefaultTableModel) Tabang.getModel();
            model.removeRow(row);
        }
    }//GEN-LAST:event_AngDelButtonActionPerformed

    private void DisClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisClearButtonActionPerformed
        // TODO add your handling code here:
        dcui.setText("");
        dnum.setText("");
        dadr.setText("");
        dtel.setText("");
        dact.setSelectedIndex(2);
    }//GEN-LAST:event_DisClearButtonActionPerformed

    private void DisSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisSaveButtonActionPerformed
        if (dcui.getText().toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CUI inexistent sau necompletat.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/librarie", "root", "");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("update `distribuitor` set nume='" + dnum.getText().toString() + "', adresa='" + dadr.getText().toString() + "', telefon='" + dtel.getText().toString() + "', col_activa='" + dact.getSelectedItem().toString() + "' where cui=" + dcui.getText().toString() + ";");
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(null, "Salvarea s-a efectuat cu succes.", "Notificare", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_DisSaveButtonActionPerformed

    private void AngClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AngClearButtonActionPerformed
        // TODO add your handling code here:
        idA.setText("");
        numeA.setText("");
        prenA.setText("");
        admA.setSelectedIndex(2);
        actA.setSelectedIndex(2);
    }//GEN-LAST:event_AngClearButtonActionPerformed

    private void AngSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AngSaveButtonActionPerformed
        if (idA.getText().toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID inexistent sau necompletat.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/librarie", "root", "");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("update `angajat` set admin='" + admA.getSelectedItem().toString() + "', activ='" + actA.getSelectedItem().toString() + "' where ida=" + idA.getText().toString() + ";");
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(null, "Salvarea s-a efectuat cu succes.", "Notificare", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_AngSaveButtonActionPerformed

    private void MeniuSetariButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeniuSetariButtonActionPerformed
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/librarie", "root", "");
            Statement stmt = con.createStatement();
            String que = "select * from `angajat` where ida=" + cuteID + ";";
            ResultSet rs = stmt.executeQuery(que);
            if (rs.next()) {
                System.out.println(que);
                nm = rs.getString(2);
                pr = rs.getString(3);
                cn = rs.getString(4);
                tl = rs.getString(6);
                Profil.nm1 = nm;
                Profil.pr1 = pr;
                Profil.cn1 = cn;
                Profil.tl1 = tl;
                System.out.println(nm);
                dispose();
                new Profil().setVisible(true);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_MeniuSetariButtonActionPerformed

    private void AchAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AchAddButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new AchNoua().setVisible(true);
    }//GEN-LAST:event_AchAddButtonActionPerformed

    private void BonDelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BonDelButtonActionPerformed
        int column = 0;
        int row = Tabbon.getSelectedRow();
        String indice = Tabbon.getModel().getValueAt(row, column).toString();
        System.out.println(column + " " + row + " " + indice);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie", "root", "");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from `vandut` where idb=" + indice + ";");
            stmt.executeUpdate("delete from `bon_fiscal` where idb=" + indice + ";");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        DefaultTableModel model = (DefaultTableModel) Tabang.getModel();
        model.removeRow(row);
    }//GEN-LAST:event_BonDelButtonActionPerformed

    private void MeniuSetariButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeniuSetariButtonMouseEntered
        this.MeniuSetariButton.setBackground(Color.decode("#FFCCD8"));
    }//GEN-LAST:event_MeniuSetariButtonMouseEntered

    private void MeniuSetariButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeniuSetariButtonMouseExited
        this.MeniuSetariButton.setBackground(Color.decode("#FFB5C6"));
    }//GEN-LAST:event_MeniuSetariButtonMouseExited

    private void DisExpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisExpButtonActionPerformed
        JFileChooser saveD = new JFileChooser("");
        String indice;
        if (countDis == 0) {
            JOptionPane.showMessageDialog(null, "Tabelul este gol.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
        } else {
            saveD.showSaveDialog(null);
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Distribuitori");
            String path = saveD.getSelectedFile().getAbsolutePath();
            //String filename=saveD.getSelectedFile().getName();
            //System.out.print(path+filename+".xls");
            HSSFRow row = sheet.createRow(0);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue("Cod Unic de Identificare");
            cell = row.createCell(1);
            cell.setCellValue("Nume distribuitor");
            cell = row.createCell(2);
            cell.setCellValue("Adresă");
            cell = row.createCell(3);
            cell.setCellValue("Telefon");
            cell = row.createCell(4);
            cell.setCellValue("Colaborare activă");
            for (int i = 0; i < countDis; i++) {
                row = sheet.createRow(i + 1);
                for (int j = 0; j < 5; j++) {
                    indice = Tabdis.getModel().getValueAt(i, j).toString();
                    cell = row.createCell(j);
                    cell.setCellValue(indice);
                }
            }
            sheet.autoSizeColumn(1);

            try {
                workbook.write(new FileOutputStream(path + ".xls"));
                workbook.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_DisExpButtonActionPerformed

    private void dcuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dcuiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dcuiActionPerformed

    private void AchExpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AchExpButtonActionPerformed
        JFileChooser saveD = new JFileChooser("");
        String indice;
        if (countAch == 0) {
            JOptionPane.showMessageDialog(null, "Tabelul este gol.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
        } else {
            saveD.showSaveDialog(null);
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Achizitii");
            String path = saveD.getSelectedFile().getAbsolutePath();
            HSSFRow row = sheet.createRow(0);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue("Nr. de factură");
            cell = row.createCell(1);
            cell.setCellValue("Distribuitor");
            cell = row.createCell(2);
            cell.setCellValue("Produs");
            cell = row.createCell(3);
            cell.setCellValue("Data");
            cell = row.createCell(4);
            cell.setCellValue("Ora");
            cell = row.createCell(5);
            cell.setCellValue("Cantitate");
            cell = row.createCell(6);
            cell.setCellValue("Cost");
            for (int i = 0; i < countAch; i++) {
                row = sheet.createRow(i + 1);
                for (int j = 0; j < 7; j++) {
                    indice = Tabang.getModel().getValueAt(i, j).toString();
                    cell = row.createCell(j);
                    cell.setCellValue(indice);
                }
            }
            sheet.autoSizeColumn(1);

            try {
                workbook.write(new FileOutputStream(path + ".xls"));
                workbook.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_AchExpButtonActionPerformed

    private void ProdExpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdExpButtonActionPerformed
        JFileChooser saveD = new JFileChooser("");
        String indice;
        if (countPro == 0) {
            JOptionPane.showMessageDialog(null, "Tabelul este gol.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
        } else {
            saveD.showSaveDialog(null);
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Produse");
            String path = saveD.getSelectedFile().getAbsolutePath();
            HSSFRow row = sheet.createRow(0);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue("Cod produs");
            cell = row.createCell(1);
            cell.setCellValue("Denumire");
            cell = row.createCell(2);
            cell.setCellValue("Categorie");
            cell = row.createCell(3);
            cell.setCellValue("Subcategorie");
            cell = row.createCell(4);
            cell.setCellValue("În stoc");
            cell = row.createCell(5);
            cell.setCellValue("Pret per unitate (RON)");
            cell = row.createCell(6);
            cell.setCellValue("Unitate de măsură");
            cell = row.createCell(7);
            cell.setCellValue("Reducere (%)");
            cell = row.createCell(8);
            cell.setCellValue("TVA (%)");
            cell = row.createCell(9);
            cell.setCellValue("Taxa ecologică (RON)");
            for (int i = 0; i < countPro; i++) {
                row = sheet.createRow(i + 1);
                for (int j = 0; j < 10; j++) {
                    indice = Tabpro.getModel().getValueAt(i, j).toString();
                    cell = row.createCell(j);
                    cell.setCellValue(indice);
                }
            }
            sheet.autoSizeColumn(1);

            try {
                workbook.write(new FileOutputStream(path + ".xls"));
                workbook.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ProdExpButtonActionPerformed

    private void BonExpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BonExpButtonActionPerformed
        JFileChooser saveD = new JFileChooser("");
        String indice;
        if (countBon == 0) {
            JOptionPane.showMessageDialog(null, "Tabelul este gol.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
        } else {
            saveD.showSaveDialog(null);
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Bonuri");
            String path = saveD.getSelectedFile().getAbsolutePath();
            HSSFRow row = sheet.createRow(0);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue("Nr. bon");
            cell = row.createCell(1);
            cell.setCellValue("Terminal");
            cell = row.createCell(2);
            cell.setCellValue("Angajat");
            cell = row.createCell(3);
            cell.setCellValue("Data");
            cell = row.createCell(4);
            cell.setCellValue("Ora");
            cell = row.createCell(5);
            cell.setCellValue("Numar de produse");
            cell = row.createCell(6);
            cell.setCellValue("Pret total");
            cell = row.createCell(7);
            cell.setCellValue("Tip plata");
            cell = row.createCell(8);
            cell.setCellValue("Rest");
            cell = row.createCell(9);
            cell.setCellValue("Card");
            for (int i = 0; i < countBon; i++) {
                row = sheet.createRow(i + 1);
                for (int j = 0; j < 10; j++) {
                    indice = Tabbon.getModel().getValueAt(i, j).toString();
                    cell = row.createCell(j);
                    cell.setCellValue(indice);
                }
            }
            sheet.autoSizeColumn(1);

            try {
                workbook.write(new FileOutputStream(path + ".xls"));
                workbook.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BonExpButtonActionPerformed

    private void AngExpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AngExpButtonActionPerformed
        JFileChooser saveD = new JFileChooser("");
        String indice;
        if (countAng == 0) {
            JOptionPane.showMessageDialog(null, "Tabelul este gol.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
        } else {
            saveD.showSaveDialog(null);
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Angajati");
            String path = saveD.getSelectedFile().getAbsolutePath();
            HSSFRow row = sheet.createRow(0);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue("ID Angajat");
            cell = row.createCell(1);
            cell.setCellValue("Nume");
            cell = row.createCell(2);
            cell.setCellValue("Prenume");
            cell = row.createCell(3);
            cell.setCellValue("Admin");
            cell = row.createCell(4);
            cell.setCellValue("Telefon");
            cell = row.createCell(5);
            cell.setCellValue("Activ");
            for (int i = 0; i < countAng; i++) {
                row = sheet.createRow(i + 1);
                for (int j = 0; j < 6; j++) {
                    indice = Tabang.getModel().getValueAt(i, j).toString();
                    cell = row.createCell(j);
                    cell.setCellValue(indice);
                }
            }
            sheet.autoSizeColumn(1);

            try {
                workbook.write(new FileOutputStream(path + ".xls"));
                workbook.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_AngExpButtonActionPerformed

    private void DisImpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisImpButtonActionPerformed
        JFileChooser loadD = new JFileChooser("");
        loadD.showOpenDialog(null);
        String path = loadD.getSelectedFile().getAbsolutePath();
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(path));
            HSSFSheet sheet = workbook.getSheetAt(0);
            HSSFRow row;
            for(int i=0;i<=sheet.getLastRowNum();i++) {
                row = sheet.getRow(i);
                for(int j=0;j<5;j++) {
                    row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                }
                String cuid = row.getCell(0).getStringCellValue();
                //String cuistring = cuid.toString();
                String numed = row.getCell(1).getStringCellValue();
                String adrd = row.getCell(2).getStringCellValue();
                String teld = row.getCell(3).getStringCellValue();
                String actd = row.getCell(4).getStringCellValue();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie", "root", "");
                    Statement stmt = con.createStatement();
                    stmt.executeUpdate("insert into `distribuitor` values (" + cuid + ", '"
                            + numed + "', '" + adrd + "', '" + teld + "', '" + actd + "');");
                    con.close();
                    JOptionPane.showMessageDialog(null, "Importul a fost efectuat cu succes.", "Info", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Importul a esuat.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Importul a esuat.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_DisImpButtonActionPerformed

    private void AchImpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AchImpButtonActionPerformed
        JFileChooser loadD = new JFileChooser("");
        loadD.showOpenDialog(null);
        String path = loadD.getSelectedFile().getAbsolutePath();

        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(path));
            HSSFSheet sheet = workbook.getSheetAt(0);
            HSSFRow row;
            for(int i=0;i<=sheet.getLastRowNum();i++) {
                row = sheet.getRow(i);
                //"Nr. de factură", "Distribuitor", "Produs", "Data", "Ora", "Cantitate", "Cost"
                for(int j=0;j<7;j++) {
                    if(j!=3 && j!=4) {
                        row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                    }
                }
                String fact = row.getCell(0).getStringCellValue();
                String dist = row.getCell(1).getStringCellValue();
                String prod = row.getCell(2).getStringCellValue();
                
                java.util.Date obj = row.getCell(3).getDateCellValue();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String data= df.format(obj);
                
                
                obj=row.getCell(4).getDateCellValue();
                DateFormat tf = new SimpleDateFormat("HH:mm:ss");
                String ora = tf.format(obj);
                
                String cant = row.getCell(5).getStringCellValue();
                String cost = row.getCell(6).getStringCellValue();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie", "root", "");
                    Statement stmt = con.createStatement();
                    System.out.println("insert into `achizitie` values (" + fact + ", "
                            + dist + ", " + prod + ", '" + data + "', '" + ora +"', " + cant +", "+cost+ ");");
                    stmt.executeUpdate("insert into `achizitie` values (" + fact + ", "
                            + dist + ", " + prod + ", '" + data + "', '" + ora +"', " + cant +", "+cost+ ");");
                    con.close();
                    JOptionPane.showMessageDialog(null, "Importul a fost efectuat cu succes.", "Info", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Importul a esuat.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Importul a esuat.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_AchImpButtonActionPerformed

    private void ProdImpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdImpButtonActionPerformed
        JFileChooser loadD = new JFileChooser("");
        loadD.showOpenDialog(null);
        String path = loadD.getSelectedFile().getAbsolutePath();

        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(path));
            HSSFSheet sheet = workbook.getSheetAt(0);
            HSSFRow row;
            for(int i=0;i<=sheet.getLastRowNum();i++) {
                row = sheet.getRow(i);
                //"Cod produs", "Denumire", "Categorie", "Subcategorie", "În stoc", "Pret per unitate (RON)", "Unitate de măsură", "Reducere (în procente)", "TVA(în procente)", "Taxa ecologică (RON)"
                for(int j=0;j<10;j++) {
                    row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                }
                String codp = row.getCell(0).getStringCellValue();
                String denp = row.getCell(1).getStringCellValue();
                String catp = row.getCell(2).getStringCellValue();
                String subp = row.getCell(3).getStringCellValue();
                String stocp = row.getCell(4).getStringCellValue();
                String pretp = row.getCell(5).getStringCellValue();
                String ump = row.getCell(6).getStringCellValue();
                String redp = row.getCell(7).getStringCellValue();
                String tvap = row.getCell(8).getStringCellValue();
                String ecop = row.getCell(9).getStringCellValue();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie", "root", "");
                    Statement stmt = con.createStatement();
                    Statement stmt1 = con.createStatement();
                    Statement stmt2 = con.createStatement();
                    ResultSet rs = stmt2.executeQuery("select idp from `tip_produs` where idp="+codp+";");
                    if(rs.next()) {
                        stmt1.executeUpdate("update `tip_produs` set in_stoc=in_stoc+"+stocp+", pret_init="+pretp+", reducere="+redp+
                                        " where idp="+codp+";");
                    }
                    else{
                    System.out.println("insert into `tip_produs` values (" + codp + ", '"
                            + denp + "', '" + catp + "', '" + subp + "', " + stocp +", " + pretp +", '"+ump+ "', "+redp+", "+tvap+", "+ecop+");");
                    stmt.executeUpdate("insert into `tip_produs` values (" + codp + ", '"
                            + denp + "', '" + catp + "', '" + subp + "', " + stocp +", " + pretp +", '"+ump+ "', "+redp+", "+tvap+", "+ecop+");");                        
                    }
                    con.close();
                    JOptionPane.showMessageDialog(null, "Importul a fost efectuat cu succes.", "Info", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Importul a esuat.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Importul a esuat.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ProdImpButtonActionPerformed

    private void BonImpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BonImpButtonActionPerformed
        JFileChooser loadD = new JFileChooser("");
        loadD.showOpenDialog(null);
        String path = loadD.getSelectedFile().getAbsolutePath();

        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(path));
            HSSFSheet sheet = workbook.getSheetAt(0);
            HSSFRow row;
            for(int i=0;i<=sheet.getLastRowNum();i++) {
                row = sheet.getRow(i);
                //"Cod produs", "Denumire", "Categorie", "Subcategorie", "În stoc", "Pret per unitate (RON)", "Unitate de măsură", "Reducere (în procente)", "TVA(în procente)", "Taxa ecologică (RON)"
                for(int j=0;j<11;j++) {
                    if(j!=3 && j!=4) {
                        row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                    }
                }
                String codb = row.getCell(0).getStringCellValue();
                String term = row.getCell(1).getStringCellValue();
                String angaj = row.getCell(2).getStringCellValue();
                
                java.util.Date obj = row.getCell(3).getDateCellValue();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String data= df.format(obj);
                
                
                obj=row.getCell(4).getDateCellValue();
                DateFormat tf = new SimpleDateFormat("HH:mm:ss");
                String ora = tf.format(obj);
                
                String nrprod = row.getCell(5).getStringCellValue();
                String total = row.getCell(6).getStringCellValue();
                String tip = row.getCell(7).getStringCellValue();
                String num = row.getCell(8).getStringCellValue();
                String rest = row.getCell(9).getStringCellValue();
                String card = row.getCell(10).getStringCellValue();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie", "root", "");
                    Statement stmt = con.createStatement();
                    System.out.println("insert into `bon_fiscal` values (" + codb + ", '"
                            + term + "', " + angaj + ", '" + data + "', '" + ora +"', " + nrprod +", "+total+ ", '"+tip+"', "+num+", "+rest+", '"+card+"');");
                    stmt.executeUpdate("insert into `bon_fiscal` values (" + codb + ", '"
                            + term + "', " + angaj + ", '" + data + "', '" + ora +"', " + nrprod +", "+total+ ", '"+tip+"', "+num+", "+rest+", '"+card+"');");                        
                    
                    con.close();
                    JOptionPane.showMessageDialog(null, "Importul a fost efectuat cu succes.", "Info", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Importul a esuat.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Importul a esuat.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BonImpButtonActionPerformed

    private void AngImpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AngImpButtonActionPerformed
        JFileChooser loadD = new JFileChooser("");
        loadD.showOpenDialog(null);
        String path = loadD.getSelectedFile().getAbsolutePath();

        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(path));
            HSSFSheet sheet = workbook.getSheetAt(0);
            HSSFRow row;
            for(int i=0;i<=sheet.getLastRowNum();i++) {
                row = sheet.getRow(i);
                //"Cod produs", "Denumire", "Categorie", "Subcategorie", "În stoc", "Pret per unitate (RON)", "Unitate de măsură", "Reducere (în procente)", "TVA(în procente)", "Taxa ecologică (RON)"
                for(int j=0;j<8;j++) {
                    row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                }
                String id = row.getCell(0).getStringCellValue();
                String num = row.getCell(1).getStringCellValue();
                String pren = row.getCell(2).getStringCellValue();
                String cnp = row.getCell(3).getStringCellValue();
                String adm = row.getCell(4).getStringCellValue();
                String tel = row.getCell(5).getStringCellValue();
                String par = row.getCell(6).getStringCellValue();
                String act = row.getCell(7).getStringCellValue();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarie", "root", "");
                    Statement stmt = con.createStatement();
                    System.out.println("insert into `angajat` values (" + id + ", '"
                            + num + "', '" + pren + "', '" + cnp + "', '" + adm +"', '" + tel +"', '"+par+ "', '"+act+"');");
                    stmt.executeUpdate("insert into `angajat` values (" + id + ", '"
                            + num + "', '" + pren + "', '" + cnp + "', '" + adm +"', '" + tel +"', '"+par+ "', '"+act+"');");                        
                    con.close();
                    JOptionPane.showMessageDialog(null, "Importul a fost efectuat cu succes.", "Info", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Importul a esuat.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Meniu.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Importul a esuat.", "Eroare", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_AngImpButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Meniu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Meniu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Meniu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Meniu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Meniu().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AchAddButton;
    private javax.swing.JButton AchExpButton;
    private javax.swing.JButton AchImpButton;
    private javax.swing.JButton AchShowButton;
    private javax.swing.JLabel AngActLabel;
    private javax.swing.JLabel AngAdmLabel;
    private javax.swing.JButton AngClearButton;
    private javax.swing.JButton AngDelButton;
    private javax.swing.JButton AngExpButton;
    private javax.swing.JLabel AngIDLabel;
    private javax.swing.JButton AngImpButton;
    private javax.swing.JLabel AngNumLabel;
    private javax.swing.JLabel AngPrenLabel;
    private javax.swing.JButton AngSaveButton;
    private javax.swing.JButton AngShowButton;
    private javax.swing.JButton BonAddButton;
    private javax.swing.JButton BonDelButton;
    private javax.swing.JButton BonExpButton;
    private javax.swing.JButton BonImpButton;
    private javax.swing.JButton BonImpButton1;
    private javax.swing.JButton BonShowButton;
    private javax.swing.JLabel DisActLabel;
    private javax.swing.JButton DisAddButton;
    private javax.swing.JLabel DisAdrLabel;
    private javax.swing.JLabel DisCUILabel;
    private javax.swing.JButton DisClearButton;
    private javax.swing.JButton DisDelButton;
    private javax.swing.JButton DisExpButton;
    private javax.swing.JButton DisImpButton;
    private javax.swing.JLabel DisNumLabel;
    private javax.swing.JButton DisSaveButton;
    private javax.swing.JButton DisShowButton;
    private javax.swing.JLabel DisTelLabel;
    private javax.swing.JButton MeniuAchButton;
    private javax.swing.JButton MeniuAngButton;
    private javax.swing.JButton MeniuBonButton;
    private javax.swing.JPanel MeniuCenterPanel;
    private javax.swing.JButton MeniuDisButton;
    private javax.swing.JLabel MeniuIDLabel;
    private javax.swing.JButton MeniuLogOutButton;
    private javax.swing.JPanel MeniuNavPanel;
    private javax.swing.JPanel MeniuPanel;
    private javax.swing.JButton MeniuProdButton;
    private javax.swing.JButton MeniuSetariButton;
    private javax.swing.JLabel MeniuTerminalLabel;
    private javax.swing.JLabel MeniuTitluLabel;
    private javax.swing.JPanel MeniuTopPanel;
    private javax.swing.JButton ProdExpButton;
    private javax.swing.JButton ProdImpButton;
    private javax.swing.JTextField ProdSearchField;
    private javax.swing.JButton ProdShowButton;
    private javax.swing.JTable Tabach;
    private javax.swing.JTable Tabang;
    private javax.swing.JTable Tabbon;
    private javax.swing.JTable Tabdis;
    private javax.swing.JTable Tabpro;
    private javax.swing.JPanel achiz;
    private javax.swing.JComboBox<String> actA;
    private javax.swing.JComboBox<String> admA;
    private javax.swing.JPanel ang;
    private javax.swing.JPanel bonf;
    private javax.swing.JComboBox<String> dact;
    private javax.swing.JTextField dadr;
    private javax.swing.JTextField dcui;
    private javax.swing.JPanel distrib;
    private javax.swing.JTextField dnum;
    private javax.swing.JTextField dtel;
    private javax.swing.JTextField idA;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField numeA;
    private javax.swing.JTextField prenA;
    private javax.swing.JPanel prods;
    // End of variables declaration//GEN-END:variables
}
