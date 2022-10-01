package pemodelan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.Color;
import java.sql.SQLException;


public class LoginSql extends javax.swing.JFrame {
    
    public static Connection con;
    public static Statement stm;
    public static String url;
    public static String dbname;
    public static String user;
    public static String passw;
    
    String color, database = "";
    char[] pass;
    
    public LoginSql() {
        initComponents();
    }
    
    public void koneksiDBUser(String url, String user, String pass){
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = DriverManager.getConnection(url,user, pass);
            stm = (Statement) con.createStatement();
            PDPB bf = new PDPB();
            bf.setVisible(true);
            this.dispose();
        } catch (SQLException e) {
            color = "16719175";
            txtketerangan.setForeground(Color.decode(color));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelusername = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        panelpassword = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        btnproceed = new javax.swing.JButton();
        txtketerangan = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtdatabase = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login MySql");
        setPreferredSize(new java.awt.Dimension(1060, 725));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1060, 725));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome to PCK");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(131, 91, 400, 64);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Sign in SQL to continue");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(130, 160, 170, 20);

        panelusername.setBackground(new java.awt.Color(58, 58, 58));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("USERNAME");

        txtusername.setBackground(new java.awt.Color(58, 58, 58));
        txtusername.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtusername.setForeground(new java.awt.Color(255, 255, 255));
        txtusername.setBorder(null);
        txtusername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtusernameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelusernameLayout = new javax.swing.GroupLayout(panelusername);
        panelusername.setLayout(panelusernameLayout);
        panelusernameLayout.setHorizontalGroup(
            panelusernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelusernameLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelusernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panelusernameLayout.setVerticalGroup(
            panelusernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelusernameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.add(panelusername);
        panelusername.setBounds(130, 320, 270, 70);

        panelpassword.setBackground(new java.awt.Color(58, 58, 58));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("PASSWORD");

        txtpassword.setBackground(new java.awt.Color(58, 58, 58));
        txtpassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtpassword.setForeground(new java.awt.Color(255, 255, 255));
        txtpassword.setBorder(null);

        javax.swing.GroupLayout panelpasswordLayout = new javax.swing.GroupLayout(panelpassword);
        panelpassword.setLayout(panelpasswordLayout);
        panelpasswordLayout.setHorizontalGroup(
            panelpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelpasswordLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panelpasswordLayout.setVerticalGroup(
            panelpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelpasswordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.add(panelpassword);
        panelpassword.setBounds(130, 410, 270, 70);

        btnproceed.setBackground(new java.awt.Color(0, 204, 102));
        btnproceed.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        btnproceed.setForeground(new java.awt.Color(51, 51, 51));
        btnproceed.setText("       PROCEED                      >");
        btnproceed.setToolTipText("");
        btnproceed.setBorder(null);
        btnproceed.setBorderPainted(false);
        btnproceed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnproceed.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnproceed.setFocusable(false);
        btnproceed.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnproceed.setRequestFocusEnabled(false);
        btnproceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproceedActionPerformed(evt);
            }
        });
        jPanel1.add(btnproceed);
        btnproceed.setBounds(130, 530, 270, 50);

        txtketerangan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtketerangan.setForeground(new java.awt.Color(51, 51, 51));
        txtketerangan.setText("Databases, Username or password doesn't valid");
        txtketerangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtketeranganMouseClicked(evt);
            }
        });
        jPanel1.add(txtketerangan);
        txtketerangan.setBounds(130, 200, 350, 20);

        jPanel4.setBackground(new java.awt.Color(58, 58, 58));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("DATABASE");

        txtdatabase.setBackground(new java.awt.Color(58, 58, 58));
        txtdatabase.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtdatabase.setForeground(new java.awt.Color(255, 255, 255));
        txtdatabase.setBorder(null);
        txtdatabase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtdatabaseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(130, 230, 270, 70);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pemodelan/Logo Aplikasi.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(130, 40, 1040, 690);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1050, 690);

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnproceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproceedActionPerformed
        StringBuilder sbf = new StringBuilder();
        pass = txtpassword.getPassword();
        passw = sbf.append(pass).toString();
        StringBuilder urlsb = new StringBuilder("jdbc:mysql://localhost/");
        database = txtdatabase.getText();
        dbname = txtdatabase.getText();
        this.dbname = dbname;
        String url = urlsb.append(database).toString();
        user = txtusername.getText();
        this.url = url;
        this.user = user;
        this.passw = passw;
        if(!(txtdatabase.getText().equals("")) && !(txtusername.getText().equals(""))){
            koneksiDBUser(url, user, passw);
        } else{
            if((txtdatabase.getText().equals(""))){
                color = "16719175";
                txtdatabase.setForeground(Color.decode(color));
                txtdatabase.setText("Can't be empty");
            }
            if((txtusername.getText().equals(""))){
                color = "16719175";
                txtusername.setForeground(Color.decode(color));
                txtusername.setText("Can't be empty");
            }
        }
    }//GEN-LAST:event_btnproceedActionPerformed

    private void txtketeranganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtketeranganMouseClicked
        if(color == "16719175"){
            color = "3355443";
            txtketerangan.setForeground(Color.decode(color));
        }
    }//GEN-LAST:event_txtketeranganMouseClicked

    private void txtdatabaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdatabaseMouseClicked
        if(txtdatabase.getText().equals("Can't be empty") && txtusername.getText().equals("Can't be empty" )){
            clearText();
        } else if(txtdatabase.getText().equals("Can't be empty" )){
            color = "16777215";
            txtdatabase.setForeground(Color.decode(color));
            txtdatabase.setText("");
        }
    }//GEN-LAST:event_txtdatabaseMouseClicked

    private void txtusernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtusernameMouseClicked
        if(txtusername.getText().equals("Can't be empty" ) && txtdatabase.getText().equals("Can't be empty")){
            clearText();
        } else if(txtusername.getText().equals("Can't be empty" )){
            color = "16777215";
            txtusername.setForeground(Color.decode(color));
            txtusername.setText("");
        }
    }//GEN-LAST:event_txtusernameMouseClicked

   public void clearText(){
       color = "16777215";
       txtdatabase.setForeground(Color.decode(color));
       txtusername.setForeground(Color.decode(color));
       txtpassword.setForeground(Color.decode(color));
       txtdatabase.setText("");
       txtusername.setText("");
       txtpassword.setText("");
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
            java.util.logging.Logger.getLogger(LoginSql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginSql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginSql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginSql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginSql().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnproceed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panelpassword;
    private javax.swing.JPanel panelusername;
    private javax.swing.JTextField txtdatabase;
    private javax.swing.JLabel txtketerangan;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
