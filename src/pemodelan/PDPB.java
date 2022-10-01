package pemodelan;

import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;

public class PDPB extends javax.swing.JFrame {
    long balance, totalpemasukansementara, totalpemasukan = 0, totalpengeluaransementara, totalpengeluaran = 0;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    
    Object NO = null, Tanggal = null, Keterangan = null, Nominal = null;
    
    DefaultTableModel modelpm,modelpl;
    
    public PDPB() {
        initComponents();
        mula2();
        koneksiDB();
        createTable();
        tampilData();
        urutan();
        tablepengeluaran();
        tablepemasukan();
    }
    
    public static Statement stm;
    public static ResultSet res;
    public static Connection koneksi;
    
    public void mula2(){
        lblnumber.setVisible(false);
    }
    
    public void koneksiDB(){
        try{
            String url = LoginSql.url;
            String user = LoginSql.user;
            String pass = LoginSql.passw;
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            koneksi = DriverManager.getConnection(url,user, pass);
            stm = (Statement) koneksi.createStatement();
            lbldatabase.setText(LoginSql.dbname);
            lblusername.setText(LoginSql.user);
        } catch(SQLException e){
            int option = JOptionPane.showConfirmDialog(null, "Mysql Tidak terkoneksi, coba lagi?", "Koneksi Database", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION){
                koneksiDB();
            } else{
                System.exit(0);
            }
        }
    }
    
    public void createTable(){
        try{
            PreparedStatement ctpm = koneksi.prepareStatement("CREATE TABLE IF NOT EXISTS `tblpemasukan` (`no` SMALLINT(4) NOT NULL , `tgl` VARCHAR(15) NOT NULL , `ket` VARCHAR(50) NOT NULL , `nom` INT(8) NOT NULL ) ENGINE = InnoDB");
            ctpm.execute();
            PreparedStatement ctpl = koneksi.prepareStatement("CREATE TABLE IF NOT EXISTS `tblpengeluaran` (`no` SMALLINT(4) NOT NULL , `tgl` VARCHAR(15) NOT NULL , `ket` VARCHAR(50) NOT NULL , `nom` INT(8) NOT NULL ) ENGINE = InnoDB");
            ctpl.execute();
        } catch(SQLException e){}
    }
    
    public void tampilData(){
        DefaultTableModel modelpm = new DefaultTableModel();
        DefaultTableModel modelpl = new DefaultTableModel();
        modelpm.addColumn("No");
        modelpm.addColumn("Tanggal");
        modelpm.addColumn("Keterangan");
        modelpm.addColumn("Nominal");
        modelpl.addColumn("No");
        modelpl.addColumn("Tanggal");
        modelpl.addColumn("Keterangan");
        modelpl.addColumn("Nominal");
        tblpemasukan.setModel(modelpm);
        tblpengeluaran.setModel(modelpl);
        tblpemasukan.getColumnModel().getColumn(0).setMaxWidth(26);
        tblpemasukan.getColumnModel().getColumn(1).setMaxWidth(100);
        tblpemasukan.getColumnModel().getColumn(3).setMaxWidth(100);
        tblpengeluaran.getColumnModel().getColumn(0).setMaxWidth(26);
        tblpengeluaran.getColumnModel().getColumn(1).setMaxWidth(100);
        tblpengeluaran.getColumnModel().getColumn(3).setMaxWidth(100);
        
        try {
            res=stm.executeQuery("SELECT * FROM tblpemasukan");
            while(res.next()){
                modelpm.addRow(new Object[]{
                        res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                });
            }
            res=stm.executeQuery("SELECT * FROM tblpengeluaran");
            while(res.next()){
                modelpl.addRow(new Object[]{
                        res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                });
            }
        } catch (SQLException ex) {}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngkeperluan = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpemasukan = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblpengeluaran = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtbalance = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtketerangan = new javax.swing.JTextField();
        txtnominal = new javax.swing.JTextField();
        rbtnpemasukan = new javax.swing.JRadioButton();
        rbtnpengeluaran = new javax.swing.JRadioButton();
        dtctanggal = new com.toedter.calendar.JDateChooser();
        lblnumber = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtketeranganedit = new javax.swing.JTextField();
        txtnominaledit = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        dtctanggaledit = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        btnswap = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblpengeluarantertinggi = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblpemasukantertinggi = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btntambah = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbldatabase = new javax.swing.JLabel();
        lblusername = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Program Catatan Keuangan");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusable(false);
        setIconImages(null);
        setPreferredSize(new java.awt.Dimension(1060, 725));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tblpemasukan.setBackground(new java.awt.Color(228, 227, 227));
        tblpemasukan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Tanggal", "Keterangan", "Nominal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblpemasukan.setToolTipText("");
        tblpemasukan.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblpemasukan.setShowGrid(true);
        tblpemasukan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpemasukanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblpemasukan);
        if (tblpemasukan.getColumnModel().getColumnCount() > 0) {
            tblpemasukan.getColumnModel().getColumn(0).setMinWidth(30);
            tblpemasukan.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 366, -1, 160));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 204));
        jLabel5.setText("TABEL PEMASUKAN");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, -1, -1));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tblpengeluaran.setBackground(new java.awt.Color(228, 227, 227));
        tblpengeluaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Tanggal", "Keterangan", "Nominal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblpengeluaran.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblpengeluaran.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblpengeluaran.setShowGrid(true);
        tblpengeluaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpengeluaranMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblpengeluaran);
        if (tblpengeluaran.getColumnModel().getColumnCount() > 0) {
            tblpengeluaran.getColumnModel().getColumn(0).setMinWidth(30);
            tblpengeluaran.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 366, -1, 160));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 204));
        jLabel6.setText("TABEL PENGELUARAN");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("BALANCE");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 617, -1, -1));

        txtbalance.setEditable(false);
        txtbalance.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtbalance.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtbalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 639, 150, -1));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Keperluan");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nominal");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tanggal");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Keterangan");

        txtnominal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtnominalMouseClicked(evt);
            }
        });

        btngkeperluan.add(rbtnpemasukan);
        rbtnpemasukan.setForeground(new java.awt.Color(255, 255, 255));
        rbtnpemasukan.setText("Pemasukan");

        btngkeperluan.add(rbtnpengeluaran);
        rbtnpengeluaran.setForeground(new java.awt.Color(255, 255, 255));
        rbtnpengeluaran.setText("Pengeluaran");

        dtctanggal.setBackground(new java.awt.Color(51, 51, 51));

        lblnumber.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblnumber.setForeground(new java.awt.Color(255, 51, 0));
        lblnumber.setText("Only Number");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbtnpemasukan)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnpengeluaran))
                    .addComponent(txtketerangan, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtctanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtnominal, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblnumber)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtketerangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dtctanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtnominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnumber))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rbtnpemasukan)
                    .addComponent(rbtnpengeluaran))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 160, 290, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nominal");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tanggal");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Keterangan");

        txtnominaledit.setPreferredSize(new java.awt.Dimension(64, 25));
        txtnominaledit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtnominaleditMouseClicked(evt);
            }
        });

        btnsave.setBackground(new java.awt.Color(0, 204, 102));
        btnsave.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnsave.setText("SAVE");
        btnsave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        dtctanggaledit.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtctanggaledit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtnominaledit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnsave)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtketeranganedit))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtketeranganedit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtctanggaledit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtnominaledit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsave))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 179, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("EDIT DATA");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, -1, -1));

        btnswap.setBackground(new java.awt.Color(0, 204, 102));
        btnswap.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnswap.setText("<->");
        btnswap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnswap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnswapActionPerformed(evt);
            }
        });
        getContentPane().add(btnswap, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 404, 56, -1));

        btnhapus.setBackground(new java.awt.Color(0, 204, 102));
        btnhapus.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnhapus.setText("HAPUS");
        btnhapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 433, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("TABUNGAN");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 322, -1, -1));

        jTextField1.setEditable(false);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 338, 175, -1));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("(0701201151)");

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("(0701203068)");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("KELOMPOK 6");

        jLabel16.setForeground(new java.awt.Color(255, 204, 204));
        jLabel16.setText("- Fadhlun Nazry Lutfi");

        jLabel17.setForeground(new java.awt.Color(255, 255, 204));
        jLabel17.setText("- Khoiri Sutan Hasibuan");

        jLabel18.setForeground(new java.awt.Color(204, 255, 204));
        jLabel18.setText("- Putri Agustina");

        jLabel19.setForeground(new java.awt.Color(153, 153, 255));
        jLabel19.setText("- Ridho Andira Wibowo");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("(0701203038)");

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("(0701203048)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel22))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel21))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)))
                .addGap(6, 6, 6))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel23))
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, -1, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Pemasukan Tertinggi");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 531, -1, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Pengeluaran Tertinggi");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 531, -1, -1));

        tblpengeluarantertinggi.setBackground(new java.awt.Color(228, 227, 227));
        tblpengeluarantertinggi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "No", "Tanggal", "Keterangan", "Nominal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblpengeluarantertinggi.setEnabled(false);
        tblpengeluarantertinggi.setRowHeight(23);
        tblpengeluarantertinggi.setRowSelectionAllowed(false);
        jScrollPane3.setViewportView(tblpengeluarantertinggi);
        if (tblpengeluarantertinggi.getColumnModel().getColumnCount() > 0) {
            tblpengeluarantertinggi.getColumnModel().getColumn(0).setMinWidth(30);
            tblpengeluarantertinggi.getColumnModel().getColumn(0).setMaxWidth(30);
            tblpengeluarantertinggi.getColumnModel().getColumn(1).setMinWidth(100);
            tblpengeluarantertinggi.getColumnModel().getColumn(1).setMaxWidth(100);
            tblpengeluarantertinggi.getColumnModel().getColumn(3).setMinWidth(100);
            tblpengeluarantertinggi.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 553, -1, 52));

        tblpemasukantertinggi.setBackground(new java.awt.Color(228, 227, 227));
        tblpemasukantertinggi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "No", "Tanggal", "Keterangan", "Nominal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblpemasukantertinggi.setEnabled(false);
        tblpemasukantertinggi.setRowHeight(23);
        tblpemasukantertinggi.setRowSelectionAllowed(false);
        jScrollPane4.setViewportView(tblpemasukantertinggi);
        if (tblpemasukantertinggi.getColumnModel().getColumnCount() > 0) {
            tblpemasukantertinggi.getColumnModel().getColumn(0).setMinWidth(30);
            tblpemasukantertinggi.getColumnModel().getColumn(0).setMaxWidth(30);
            tblpemasukantertinggi.getColumnModel().getColumn(1).setMinWidth(100);
            tblpemasukantertinggi.getColumnModel().getColumn(1).setMaxWidth(100);
            tblpemasukantertinggi.getColumnModel().getColumn(3).setMinWidth(100);
            tblpemasukantertinggi.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 553, -1, 52));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(null);

        btntambah.setBackground(new java.awt.Color(0, 204, 102));
        btntambah.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btntambah.setText("TAMBAH");
        btntambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        jPanel4.add(btntambah);
        btntambah.setBounds(232, 312, 88, 30);

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(null);

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Connection           :");
        jPanel5.add(jLabel27);
        jLabel27.setBounds(10, 50, 100, 16);

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Username             :");
        jPanel5.add(jLabel26);
        jLabel26.setBounds(10, 30, 110, 16);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Database Name  :");
        jPanel5.add(jLabel14);
        jLabel14.setBounds(10, 10, 100, 16);

        lbldatabase.setForeground(new java.awt.Color(204, 204, 255));
        lbldatabase.setText("database");
        jPanel5.add(lbldatabase);
        lbldatabase.setBounds(120, 10, 120, 16);

        lblusername.setForeground(new java.awt.Color(204, 255, 204));
        lblusername.setText("username");
        jPanel5.add(lblusername);
        lblusername.setBounds(120, 30, 130, 16);

        jLabel28.setForeground(new java.awt.Color(255, 255, 204));
        jLabel28.setText("Mysql");
        jPanel5.add(jLabel28);
        jLabel28.setBounds(120, 50, 32, 16);

        jButton1.setBackground(new java.awt.Color(204, 153, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Sign Out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);
        jButton1.setBounds(200, 50, 78, 23);

        jPanel4.add(jPanel5);
        jPanel5.setBounds(30, 80, 290, 80);

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 204, 204));
        jLabel29.setText("Matakuliah Pemodelan dan Simulasi Semester 7");
        jPanel4.add(jLabel29);
        jLabel29.setBounds(30, 50, 330, 20);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 102));
        jLabel1.setText("PROGRAM CATATAN KEUANGAN");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(30, 20, 384, 32);

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 700));

        getAccessibleContext().setAccessibleDescription("Program Database Penjualan Barang Tiap Bulan");
        getAccessibleContext().setAccessibleParent(this);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        if(rbtnpemasukan.isSelected() && !(txtketerangan.getText().equals("")) && (!(txtnominal.getText().equals("")))){
            if(txtnominal.getText().matches("[0-9]+")){
                modelpm.addRow(new Object[]{NO, Tanggal,Keterangan,Nominal});
                tblpemasukan.setValueAt(tblpemasukan.getRowCount(), tblpemasukan.getRowCount()-1,0);
                tblpemasukan.setValueAt(format.format(dtctanggal.getDate()), tblpemasukan.getRowCount()-1,1);
                tblpemasukan.setValueAt(txtketerangan.getText(), tblpemasukan.getRowCount()-1,2);
                tblpemasukan.setValueAt(txtnominal.getText(), tblpemasukan.getRowCount()-1,3);
            } else {
                txtnominal.setBackground(Color.red);
                lblnumber.setVisible(true);
            }
        } else if(rbtnpengeluaran.isSelected() && !(txtketerangan.getText().equals("")) && (!(txtnominal.getText().equals("")))){
            if(txtnominal.getText().matches("[0-9]+")){
                modelpl.addRow(new Object[]{NO, Tanggal,Keterangan,Nominal});
                tblpengeluaran.setValueAt(tblpengeluaran.getRowCount(), tblpengeluaran.getRowCount()-1,0);
                tblpengeluaran.setValueAt(format.format(dtctanggal.getDate()), tblpengeluaran.getRowCount()-1,1);
                tblpengeluaran.setValueAt(txtketerangan.getText(), tblpengeluaran.getRowCount()-1,2);
                tblpengeluaran.setValueAt(txtnominal.getText(), tblpengeluaran.getRowCount()-1,3);
            } else {
                txtnominal.setBackground(Color.red);
                lblnumber.setVisible(true);
            }
        }
        urutan();
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        if(tblpemasukan.isCellSelected(tblpemasukan.getSelectedRow(), tblpemasukan.getSelectedColumn())){
            if(!txtketeranganedit.getText().equals("") && !dtctanggaledit.getDate().equals("") && !txtnominaledit.getText().equals("") ){
                if(txtnominaledit.getText().matches("[0-9]+")){
                    tblpemasukan.setValueAt(format.format(dtctanggaledit.getDate()), tblpemasukan.getSelectedRow(), 1);
                    tblpemasukan.setValueAt(txtketeranganedit.getText(), tblpemasukan.getSelectedRow(), 2);
                    tblpemasukan.setValueAt(txtnominaledit.getText(), tblpemasukan.getSelectedRow(), 3);
                } else {
                    txtnominaledit.setBackground(Color.red);
                }
            }
        } else if(tblpengeluaran.isCellSelected(tblpengeluaran.getSelectedRow(),tblpengeluaran.getSelectedColumn())){
            if(!txtketeranganedit.getText().equals("") && !dtctanggaledit.getDate().equals("") && !txtnominaledit.getText().equals("") ){
                if(txtnominaledit.getText().matches("[0-9]+")){
                    tblpengeluaran.setValueAt(format.format(dtctanggaledit.getDate()), tblpengeluaran.getSelectedRow(), 1);
                    tblpengeluaran.setValueAt(txtketeranganedit.getText(), tblpengeluaran.getSelectedRow(), 2);
                    tblpengeluaran.setValueAt(txtnominaledit.getText(), tblpengeluaran.getSelectedRow(), 3);
                } else{
                    txtnominaledit.setBackground(Color.red);
                }
            }
        }
        urutan();
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        if(tblpemasukan.isCellSelected(tblpemasukan.getSelectedRow(), tblpemasukan.getSelectedColumn())) {
            if(tblpemasukan.getSelectedRow() <= (tblpemasukan.getRowCount()-1)){
                int selek = tblpemasukan.getSelectedRow();
                modelpm.removeRow(tblpemasukan.getRowCount()-1);
                if(selek < (tblpemasukan.getRowCount()-1)){
                    for(int i = tblpemasukan.getSelectedRow()+1; i < tblpemasukan.getRowCount(); i++){
                        tblpemasukan.setValueAt(tblpemasukan.getValueAt(i, 1), i-1, 1);
                        tblpemasukan.setValueAt(tblpemasukan.getValueAt(i, 2), i-1, 2);
                        tblpemasukan.setValueAt(tblpemasukan.getValueAt(i, 3), i-1, 3);
                    }
                }
            }
        } else if(tblpengeluaran.isCellSelected(tblpengeluaran.getSelectedRow(), tblpengeluaran.getSelectedColumn())){
            if(tblpengeluaran.getSelectedRow() <= (tblpengeluaran.getRowCount()-1)){
                int selek = tblpengeluaran.getSelectedRow();
                modelpl.removeRow(tblpengeluaran.getRowCount()-1);
                if(selek < (tblpengeluaran.getRowCount()-1)){
                    for(int i = tblpengeluaran.getSelectedRow()+1; i < tblpengeluaran.getRowCount(); i++){
                        tblpengeluaran.setValueAt(tblpengeluaran.getValueAt(i, 1), i-1, 1);
                        tblpengeluaran.setValueAt(tblpengeluaran.getValueAt(i, 2), i-1, 2);
                        tblpengeluaran.setValueAt(tblpengeluaran.getValueAt(i, 3), i-1, 3);
                    }
                }
            }
        }
        urutan();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnswapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnswapActionPerformed
        if(tblpemasukan.isCellSelected(tblpemasukan.getSelectedRow(), tblpemasukan.getSelectedColumn())){
            modelpl.addRow(new Object[]{NO, Tanggal, Keterangan, Nominal });
            tblpengeluaran.setValueAt(tblpengeluaran.getRowCount(), tblpengeluaran.getRowCount()-1,0);
            for(int i = 1; i < tblpengeluaran.getColumnCount(); i++){
                tblpengeluaran.setValueAt(tblpemasukan.getValueAt(tblpemasukan.getSelectedRow(), i), tblpengeluaran.getRowCount()-1, i);
            }
            for(int i = tblpemasukan.getSelectedRow()+1; i < tblpemasukan.getRowCount(); i++){
                tblpemasukan.setValueAt(tblpemasukan.getValueAt(i, 1), i-1, 1);
                tblpemasukan.setValueAt(tblpemasukan.getValueAt(i, 2), i-1, 2);
                tblpemasukan.setValueAt(tblpemasukan.getValueAt(i, 3), i-1, 3);
            }
            modelpm.removeRow(tblpemasukan.getRowCount()-1);
        } else if(tblpengeluaran.isCellSelected(tblpengeluaran.getSelectedRow(), tblpengeluaran.getSelectedColumn())){
            modelpm.addRow(new Object[]{NO, Tanggal, Keterangan, Nominal });
            tblpemasukan.setValueAt(tblpemasukan.getRowCount(), tblpemasukan.getRowCount()-1,0);
            for(int i = 1; i < tblpemasukan.getColumnCount(); i++){
                tblpemasukan.setValueAt(tblpengeluaran.getValueAt(tblpengeluaran.getSelectedRow(), i), tblpemasukan.getRowCount()-1, i);
            }
            for(int i = tblpengeluaran.getSelectedRow()+1; i < tblpengeluaran.getRowCount(); i++){
                tblpengeluaran.setValueAt(tblpengeluaran.getValueAt(i, 1), i-1, 1);
                tblpengeluaran.setValueAt(tblpengeluaran.getValueAt(i, 2), i-1, 2);
                tblpengeluaran.setValueAt(tblpengeluaran.getValueAt(i, 3), i-1, 3);
            }
            modelpl.removeRow(tblpengeluaran.getRowCount()-1);
        }
        urutan();
    }//GEN-LAST:event_btnswapActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        tblpemasukan.clearSelection();
        tblpengeluaran.clearSelection();
        txtnominaledit.setBackground(Color.white);
        urutan();
    }//GEN-LAST:event_formMouseClicked

    private void txtnominalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtnominalMouseClicked
        lblnumber.setVisible(false);
        txtnominal.setBackground(Color.white);
    }//GEN-LAST:event_txtnominalMouseClicked

    private void txtnominaleditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtnominaleditMouseClicked
        txtnominaledit.setBackground(Color.white);
    }//GEN-LAST:event_txtnominaleditMouseClicked

    private void tblpemasukanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpemasukanMouseClicked
        tblpengeluaran.clearSelection();
        txtketeranganedit.setText(tblpemasukan.getValueAt(tblpemasukan.getSelectedRow(), 2).toString());
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) tblpemasukan.getValueAt(tblpemasukan.getSelectedRow(), 1));
            dtctanggaledit.setDate(date);
        } catch (ParseException e) {
            Logger.getLogger(PDPB.class.getName()).log(Level.SEVERE, null, e);
        }
        txtnominaledit.setText(tblpemasukan.getValueAt(tblpemasukan.getSelectedRow(), 3).toString());
        cekSeleksi();
    }//GEN-LAST:event_tblpemasukanMouseClicked

    private void tblpengeluaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpengeluaranMouseClicked
        tblpemasukan.clearSelection();
        txtnominaledit.setBackground(Color.white);
        txtketeranganedit.setText(tblpengeluaran.getValueAt(tblpengeluaran.getSelectedRow(), 2).toString());
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) tblpengeluaran.getValueAt(tblpengeluaran.getSelectedRow(), 1));
            dtctanggaledit.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(PDPB.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtnominaledit.setText(tblpengeluaran.getValueAt(tblpengeluaran.getSelectedRow(), 3).toString());
        cekSeleksi();
    }//GEN-LAST:event_tblpengeluaranMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LoginSql lsql = new LoginSql();
        lsql.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void urutan(){
        koneksiDB();
        cekSeleksi();
        balance();
        printBalance();
        pmtertinggi();
        pltertinggi();
        clearEditData();
        reinsert();
    }
    
    private void cekSeleksi(){
        if((tblpemasukan.isCellSelected(tblpemasukan.getSelectedRow(), tblpemasukan.getSelectedColumn()) || 
            tblpengeluaran.isCellSelected(tblpengeluaran.getSelectedRow(), tblpengeluaran.getSelectedColumn())) == false){
            txtketeranganedit.setEnabled(false);
            txtnominaledit.setEnabled(false);
            dtctanggaledit.setEnabled(false);
            btnsave.setEnabled(false);
        } else{
            txtketeranganedit.setEnabled(true);
            txtnominaledit.setEnabled(true);
            dtctanggaledit.setEnabled(true);
            btnsave.setEnabled(true);
        }
    }
    
    private void reinsert(){
        try{
            PreparedStatement hapuspm = koneksi.prepareStatement("DELETE FROM tblpemasukan");
            hapuspm.execute();
            PreparedStatement hapuspl = koneksi.prepareStatement("DELETE FROM tblpengeluaran");
            hapuspl.execute();
        }   catch(SQLException e){}
        
        for(int i = 0; i < tblpemasukan.getRowCount(); i++){
            try {
                String simpan = "insert into tblpemasukan values ('"+tblpemasukan.getValueAt(i,0)+"','"+tblpemasukan.getValueAt(i,1)+"','"+tblpemasukan.getValueAt(i, 2)+"','"+tblpemasukan.getValueAt(i, 3)+"')";
                PreparedStatement pst = koneksi.prepareStatement(simpan);
                pst.execute();
            } catch(SQLException e){} 
        }
        for(int i = 0; i < tblpengeluaran.getRowCount(); i++){
            try {
                String simpan = "insert into tblpengeluaran values ('"+tblpengeluaran.getValueAt(i,0)+"','"+tblpengeluaran.getValueAt(i,1)+"','"+tblpengeluaran.getValueAt(i, 2)+"','"+tblpengeluaran.getValueAt(i, 3)+"')";
                PreparedStatement pst = koneksi.prepareStatement(simpan);
                pst.execute();
            } catch(SQLException e){} 
        }
    }
    
    private void pltertinggi(){
        if(tblpengeluaran.getRowCount() > 0){
            long [] pltertinggi = new long[(tblpengeluaran.getRowCount())];
            for(int i = 0; i < tblpengeluaran.getRowCount(); i++){
                pltertinggi[i] = Long.parseLong((String) tblpengeluaran.getValueAt(i, 3));
            }
            long [] pltertinggi2 = Arrays.copyOf(pltertinggi,pltertinggi.length);
            Arrays.sort(pltertinggi);
            long pengeluarantertinggi = pltertinggi[tblpengeluaran.getRowCount()-1];
            for(int i = 0; i < tblpengeluarantertinggi.getColumnCount(); i++){
                tblpengeluarantertinggi.setValueAt(tblpengeluaran.getValueAt((int) findIndex(pltertinggi2,pengeluarantertinggi), i), 0, i);
            }
        } else if(tblpengeluaran.getRowCount() == 0){
            tblpengeluarantertinggi.setValueAt("", 0, 0);
            tblpengeluarantertinggi.setValueAt("", 0, 1);
            tblpengeluarantertinggi.setValueAt("", 0, 2);
            tblpengeluarantertinggi.setValueAt("", 0, 3);
        }
    }
    
    private void clearEditData(){
        if((tblpemasukan.isCellSelected(tblpemasukan.getSelectedRow(), NORMAL) || tblpengeluaran.isCellSelected(tblpengeluaran.getSelectedRow(), NORMAL)) == false){
            txtketeranganedit.setText("");
            dtctanggaledit.setCalendar(null);
            txtnominaledit.setText("");
        }
    }
    
    private void pmtertinggi(){
        if(tblpemasukan.getRowCount() > 0){
            long [] pmtertinggi = new long[tblpemasukan.getRowCount()];
            for(int i = 0; i < tblpemasukan.getRowCount(); i++){
                pmtertinggi[i] = Long.parseLong((String) tblpemasukan.getValueAt(i, 3));
            }
            long [] pmtertinggi2 = Arrays.copyOf(pmtertinggi, pmtertinggi.length);
            Arrays.sort(pmtertinggi);
            long pemasukantertinggi = pmtertinggi[tblpemasukan.getRowCount()-1];
            for(int i = 0; i < tblpemasukantertinggi.getColumnCount(); i++){
                tblpemasukantertinggi.setValueAt(tblpemasukan.getValueAt((int) findIndex(pmtertinggi2,pemasukantertinggi), i), 0, i);
            }
        } else if(tblpemasukan.getRowCount() == 0){
            tblpemasukantertinggi.setValueAt("", 0, 0);
            tblpemasukantertinggi.setValueAt("", 0, 1);
            tblpemasukantertinggi.setValueAt("", 0, 2);
            tblpemasukantertinggi.setValueAt("", 0, 3);
        }
    }
    
    public static long findIndex(long arr[], long t){
        int len = arr.length;
        return IntStream.range(0, len)
            .filter(i -> t == arr[i])
            .findFirst()
            .orElse(-1);
    }
    
    private void balance(){
        for(int i = 0; i < tblpemasukan.getRowCount(); i++){
            totalpemasukansementara = Long.parseLong((String)tblpemasukan.getValueAt(i,3));
            totalpemasukan += totalpemasukansementara;
        }
        for(int i = 0; i < tblpengeluaran.getRowCount(); i++){
            totalpengeluaransementara = Long.parseLong((String)tblpengeluaran.getValueAt(i,3));
            totalpengeluaran += totalpengeluaransementara;
        }
        balance = totalpemasukan - totalpengeluaran;
    }
    
    private void printBalance(){
        txtbalance.setText(String.valueOf(balance));
        String color = "0";
        if(balance > 0){
            color = "52326";
        } else if(balance < 0){
            color = "16719175";
        } else if(balance == 0){
            color = "16777215";
        }
        txtbalance.setBackground(Color.decode(color));
        totalpengeluaran = 0;
        totalpemasukan = 0;
    }
    
    public void tablepemasukan(){
        modelpm = (DefaultTableModel) tblpemasukan.getModel();
    }
    
    public void tablepengeluaran(){
        modelpl = (DefaultTableModel) tblpengeluaran.getModel();
    }
    
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
            java.util.logging.Logger.getLogger(PDPB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PDPB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PDPB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PDPB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PDPB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btngkeperluan;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnswap;
    private javax.swing.JButton btntambah;
    private com.toedter.calendar.JDateChooser dtctanggal;
    private com.toedter.calendar.JDateChooser dtctanggaledit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbldatabase;
    private javax.swing.JLabel lblnumber;
    private javax.swing.JLabel lblusername;
    private javax.swing.JRadioButton rbtnpemasukan;
    private javax.swing.JRadioButton rbtnpengeluaran;
    private javax.swing.JTable tblpemasukan;
    private javax.swing.JTable tblpemasukantertinggi;
    private javax.swing.JTable tblpengeluaran;
    private javax.swing.JTable tblpengeluarantertinggi;
    private javax.swing.JTextField txtbalance;
    private javax.swing.JTextField txtketerangan;
    private javax.swing.JTextField txtketeranganedit;
    private javax.swing.JTextField txtnominal;
    private javax.swing.JTextField txtnominaledit;
    // End of variables declaration//GEN-END:variables

}
