/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

/**
 *
 * @author Sebastian Murrieta Verduzco -233463
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        panelRound1 = new controlador.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        panelGlowingGradient3 = new javaswingdev.pggb.PanelGlowingGradient();
        jLabel6 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        panelGlowingGradient2 = new javaswingdev.pggb.PanelGlowingGradient();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        panelRound3 = new controlador.PanelRound();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Fondo.setBackground(new java.awt.Color(24, 40, 54));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(58, 107, 128));
        panelRound1.setRoundBottomLeft(60);
        panelRound1.setRoundBottomRight(60);
        panelRound1.setRoundTopLeft(60);
        panelRound1.setRoundTopRight(60);

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INICIO");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(188, 188, 188))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        Fondo.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 32, 440, -1));

        panelGlowingGradient3.setBackground(new java.awt.Color(24, 40, 54));
        panelGlowingGradient3.setBackgroundLight(new java.awt.Color(24, 40, 54));
        panelGlowingGradient3.setGradientColor1(new java.awt.Color(102, 255, 255));
        panelGlowingGradient3.setGradientColor2(new java.awt.Color(0, 153, 204));

        jLabel6.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(159, 159, 159));
        jLabel6.setText("Contraseña:");
        panelGlowingGradient3.add(jLabel6);
        jLabel6.setBounds(30, 30, 121, 30);

        jPasswordField1.setBackground(new java.awt.Color(24, 40, 54));
        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));
        panelGlowingGradient3.add(jPasswordField1);
        jPasswordField1.setBounds(160, 30, 260, 30);

        Fondo.add(panelGlowingGradient3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 450, 91));

        panelGlowingGradient2.setBackground(new java.awt.Color(24, 40, 54));
        panelGlowingGradient2.setBackgroundLight(new java.awt.Color(24, 40, 54));
        panelGlowingGradient2.setGradientColor1(new java.awt.Color(102, 255, 255));
        panelGlowingGradient2.setGradientColor2(new java.awt.Color(0, 153, 204));

        jLabel5.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(159, 159, 159));
        jLabel5.setText("Correo:");
        panelGlowingGradient2.add(jLabel5);
        jLabel5.setBounds(30, 30, 80, 30);

        jTextField2.setBackground(new java.awt.Color(24, 40, 54));
        jTextField2.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        panelGlowingGradient2.add(jTextField2);
        jTextField2.setBounds(110, 30, 310, 30);

        Fondo.add(panelGlowingGradient2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 450, 91));

        jLabel4.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(159, 159, 159));
        jLabel4.setText("Registrarse");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        Fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 600, -1, -1));

        panelRound3.setBackground(new java.awt.Color(81, 137, 161));
        panelRound3.setCursorHandEnabled(true);
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Iniciar sesion");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(49, 49, 49))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Fondo.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 310, 60));

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField2;
    private javaswingdev.pggb.PanelGlowingGradient panelGlowingGradient2;
    private javaswingdev.pggb.PanelGlowingGradient panelGlowingGradient3;
    private controlador.PanelRound panelRound1;
    private controlador.PanelRound panelRound3;
    // End of variables declaration//GEN-END:variables
}
