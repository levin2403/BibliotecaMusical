/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Sebastian Murrieta Verduzco -233463
 */
public class Registro extends javax.swing.JFrame {

    // Variables para manejar las imágenes de Registro
    private ArrayList<ImageIcon> imagenesRegistro;
    private int imagenActual;
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_NAME_LENGTH = 50;
    private static final int MAX_EMAIL_LENGTH = 100;

    public Registro() {
        initComponents();
        initImagenes();
        setupComponents();

        // Inicializar y configurar imageLabel
        imageLabel = new javax.swing.JLabel();
        imagenDeRegistro.setPreferredSize(new java.awt.Dimension(300, 300));
        imageLabel.setBounds(0, 0, imagenDeRegistro.getWidth(), imagenDeRegistro.getHeight());
        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagenDeRegistro.setLayout(null); // Usar diseño absoluto
        imagenDeRegistro.add(imageLabel); // Agregar el JLabel al PanelRound

        // Llamar a actualizar la imagen cuando la ventana esté lista
        java.awt.EventQueue.invokeLater(() -> actualizarImagenRegistro());
    }

    private boolean validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            mostrarError("El nombre no puede estar vacío");
            return false;
        }

        if (nombre.length() > MAX_NAME_LENGTH) {
            mostrarError("El nombre no puede exceder los " + MAX_NAME_LENGTH + " caracteres");
            return false;
        }

        // Validar que solo contenga letras y espacios
        if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            mostrarError("El nombre solo puede contener letras y espacios");
            return false;
        }

        return true;
    }

    private boolean validarCorreo(String correo) {
        if (correo == null || correo.trim().isEmpty()) {
            mostrarError("El correo no puede estar vacío");
            return false;
        }

        if (correo.length() > MAX_EMAIL_LENGTH) {
            mostrarError("El correo no puede exceder los " + MAX_EMAIL_LENGTH + " caracteres");
            return false;
        }

        // Patrón para validar el formato del correo
        String emailPattern
                = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        if (!Pattern.compile(emailPattern).matcher(correo).matches()) {
            mostrarError("El formato del correo electrónico no es válido");
            return false;
        }

        return true;
    }

    private boolean validarContraseña(String contraseña, String confirmacion) {
        if (contraseña == null || contraseña.isEmpty()) {
            mostrarError("La contraseña no puede estar vacía");
            return false;
        }

        if (contraseña.length() < MIN_PASSWORD_LENGTH) {
            mostrarError("La contraseña debe tener al menos " + MIN_PASSWORD_LENGTH + " caracteres");
            return false;
        }

        // Validar que la contraseña contenga al menos una mayúscula, una minúscula y un número
        if (!contraseña.matches(".*[A-Z].*")) {
            mostrarError("La contraseña debe contener al menos una letra mayúscula");
            return false;
        }

        if (!contraseña.matches(".*[a-z].*")) {
            mostrarError("La contraseña debe contener al menos una letra minúscula");
            return false;
        }

        if (!contraseña.matches(".*\\d.*")) {
            mostrarError("La contraseña debe contener al menos un número");
            return false;
        }

        // Validar caracteres especiales
        if (!contraseña.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*")) {
            mostrarError("La contraseña debe contener al menos un carácter especial");
            return false;
        }

        // Validar que las contraseñas coincidan
        if (!contraseña.equals(confirmacion)) {
            mostrarError("Las contraseñas no coinciden");
            return false;
        }

        return true;
    }

    private void guardarCambios() {
        try {
            String nombre = nombreTxt.getText();
            String correo = correoTxt.getText();
            String contraseña = new String(contraseñaTxt.getPassword());
            String confirmarContraseña = new String(confirmarContraseñaTxt.getPassword());

            // Realizar todas las validaciones
            boolean nombreValido = validarNombre(nombre);
            boolean correoValido = validarCorreo(correo);
            boolean contraseñaValida = validarContraseña(contraseña, confirmarContraseña);

            // Solo proceder si todas las validaciones son exitosas
            if (nombreValido && correoValido && contraseñaValida) {
                // Aquí iría el código para guardar en la base de datos

                // Mostrar mensaje de éxito
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Los cambios se han guardado exitosamente",
                        "Éxito",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE
                );

                // Cerrar ventana actual y abrir Principal
                dispose();
                java.awt.EventQueue.invokeLater(() -> {
                    try {
                        new Principal().setVisible(true);
                    } catch (Exception e) {
                        mostrarError("Error al abrir la ventana principal: " + e.getMessage());
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            mostrarError("Error al procesar los datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void mostrarError(String mensaje) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Error de validación",
                javax.swing.JOptionPane.ERROR_MESSAGE
        );
    }

    private void initImagenes() {
        imagenesRegistro = new ArrayList<>();
        String[] imagePaths = {
            "/usuario/usuario1.png",
            "/usuario/usuario2.png",
            "/usuario/usuario3.png"
        };

        boolean loadedAny = false;
        for (String path : imagePaths) {
            URL imageUrl = getClass().getResource(path);
            if (imageUrl != null) {
                imagenesRegistro.add(new ImageIcon(imageUrl));
                loadedAny = true;
            } else {
                System.err.println("Failed to load image: " + path);
            }
        }

        if (!loadedAny) {
            // Add a default placeholder image or show error
            mostrarError("No se pudieron cargar las imágenes de usuario. Verificar la ubicación de los recursos.");
        }

        imagenActual = 0;
        actualizarImagenRegistro();
    }

    private void setupComponents() {
        imagenDeRegistro.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                actualizarImagenRegistro(); // Redimensionar imagen al cambiar tamaño del panel
            }
        });

        anteriorImagenBtn.addActionListener(evt -> navegarImagenAnterior());
        siguienteImagenBtn.addActionListener(evt -> navegarImagenSiguiente());

        registroBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarCambios();
            }
        });
    }

    private void actualizarImagenRegistro() {
        if (!imagenesRegistro.isEmpty() && imagenDeRegistro.getWidth() > 0 && imagenDeRegistro.getHeight() > 0) {
            // Obtener la imagen actual
            ImageIcon imgIcon = imagenesRegistro.get(imagenActual);

            // Escalar la imagen al tamaño de imagenDeRegistro
            Image img = imgIcon.getImage().getScaledInstance(
                    imagenDeRegistro.getWidth(),
                    imagenDeRegistro.getHeight(),
                    Image.SCALE_SMOOTH
            );

            // Establecer la imagen escalada en imageLabel
            imageLabel.setIcon(new ImageIcon(img));
        }
    }

    private void navegarImagenAnterior() {
        if (imagenActual > 0) {
            imagenActual--;
        } else {
            imagenActual = imagenesRegistro.size() - 1;
        }
        actualizarImagenRegistro();
    }

    private void navegarImagenSiguiente() {
        if (imagenActual < imagenesRegistro.size() - 1) {
            imagenActual++;
        } else {
            imagenActual = 0;
        }
        actualizarImagenRegistro();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        panelRound1 = new controlador.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        panelGlowingGradient1 = new javaswingdev.pggb.PanelGlowingGradient();
        jLabel3 = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JTextField();
        panelGlowingGradient3 = new javaswingdev.pggb.PanelGlowingGradient();
        jLabel6 = new javax.swing.JLabel();
        confirmarContraseñaTxt = new javax.swing.JPasswordField();
        panelGlowingGradient4 = new javaswingdev.pggb.PanelGlowingGradient();
        jLabel7 = new javax.swing.JLabel();
        contraseñaTxt = new javax.swing.JPasswordField();
        panelGlowingGradient2 = new javaswingdev.pggb.PanelGlowingGradient();
        jLabel5 = new javax.swing.JLabel();
        correoTxt = new javax.swing.JTextField();
        atrasBtn = new javax.swing.JLabel();
        registroBtn = new controlador.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        imagenDeRegistro = new controlador.PanelRound();
        imageLabel = new javax.swing.JLabel();
        anteriorImagenBtn = new javax.swing.JButton();
        siguienteImagenBtn = new javax.swing.JButton();

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
        jLabel1.setText("REGISTRO");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(211, 211, 211))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );

        Fondo.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 32, 440, -1));

        panelGlowingGradient1.setBackground(new java.awt.Color(24, 40, 54));
        panelGlowingGradient1.setBackgroundLight(new java.awt.Color(24, 40, 54));
        panelGlowingGradient1.setGradientColor1(new java.awt.Color(102, 255, 255));
        panelGlowingGradient1.setGradientColor2(new java.awt.Color(0, 153, 204));

        jLabel3.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(159, 159, 159));
        jLabel3.setText("Nombre:");
        panelGlowingGradient1.add(jLabel3);
        jLabel3.setBounds(30, 20, 90, 30);

        nombreTxt.setBackground(new java.awt.Color(24, 40, 54));
        nombreTxt.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        nombreTxt.setForeground(new java.awt.Color(255, 255, 255));
        panelGlowingGradient1.add(nombreTxt);
        nombreTxt.setBounds(110, 20, 320, 30);

        Fondo.add(panelGlowingGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 450, 70));

        panelGlowingGradient3.setBackground(new java.awt.Color(24, 40, 54));
        panelGlowingGradient3.setBackgroundLight(new java.awt.Color(24, 40, 54));
        panelGlowingGradient3.setGradientColor1(new java.awt.Color(102, 255, 255));
        panelGlowingGradient3.setGradientColor2(new java.awt.Color(0, 153, 204));

        jLabel6.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(159, 159, 159));
        jLabel6.setText("Contraseña:");
        panelGlowingGradient3.add(jLabel6);
        jLabel6.setBounds(30, 20, 130, 30);

        confirmarContraseñaTxt.setBackground(new java.awt.Color(24, 40, 54));
        confirmarContraseñaTxt.setForeground(new java.awt.Color(255, 255, 255));
        panelGlowingGradient3.add(confirmarContraseñaTxt);
        confirmarContraseñaTxt.setBounds(160, 20, 270, 30);

        Fondo.add(panelGlowingGradient3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 450, 70));

        panelGlowingGradient4.setBackground(new java.awt.Color(24, 40, 54));
        panelGlowingGradient4.setBackgroundLight(new java.awt.Color(24, 40, 54));
        panelGlowingGradient4.setGradientColor1(new java.awt.Color(102, 255, 255));
        panelGlowingGradient4.setGradientColor2(new java.awt.Color(0, 153, 204));

        jLabel7.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(159, 159, 159));
        jLabel7.setText("Contraseña:");
        panelGlowingGradient4.add(jLabel7);
        jLabel7.setBounds(30, 20, 121, 30);

        contraseñaTxt.setBackground(new java.awt.Color(24, 40, 54));
        contraseñaTxt.setForeground(new java.awt.Color(255, 255, 255));
        panelGlowingGradient4.add(contraseñaTxt);
        contraseñaTxt.setBounds(160, 20, 270, 30);

        Fondo.add(panelGlowingGradient4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 450, 70));

        panelGlowingGradient2.setBackground(new java.awt.Color(24, 40, 54));
        panelGlowingGradient2.setBackgroundLight(new java.awt.Color(24, 40, 54));
        panelGlowingGradient2.setGradientColor1(new java.awt.Color(102, 255, 255));
        panelGlowingGradient2.setGradientColor2(new java.awt.Color(0, 153, 204));

        jLabel5.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(159, 159, 159));
        jLabel5.setText("Correo:");
        panelGlowingGradient2.add(jLabel5);
        jLabel5.setBounds(30, 20, 80, 30);

        correoTxt.setBackground(new java.awt.Color(24, 40, 54));
        correoTxt.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        correoTxt.setForeground(new java.awt.Color(255, 255, 255));
        panelGlowingGradient2.add(correoTxt);
        correoTxt.setBounds(110, 20, 320, 30);

        Fondo.add(panelGlowingGradient2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 450, 70));

        atrasBtn.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        atrasBtn.setForeground(new java.awt.Color(159, 159, 159));
        atrasBtn.setText("Regresar");
        atrasBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atrasBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atrasBtnMouseClicked(evt);
            }
        });
        Fondo.add(atrasBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 600, -1, -1));

        registroBtn.setBackground(new java.awt.Color(81, 137, 161));
        registroBtn.setCursorHandEnabled(true);
        registroBtn.setRoundBottomLeft(50);
        registroBtn.setRoundBottomRight(50);
        registroBtn.setRoundTopLeft(50);
        registroBtn.setRoundTopRight(50);
        registroBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registroBtnMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registrarse");

        javax.swing.GroupLayout registroBtnLayout = new javax.swing.GroupLayout(registroBtn);
        registroBtn.setLayout(registroBtnLayout);
        registroBtnLayout.setHorizontalGroup(
            registroBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroBtnLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel2)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        registroBtnLayout.setVerticalGroup(
            registroBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registroBtnLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Fondo.add(registroBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 310, 60));

        imagenDeRegistro.setBackground(new java.awt.Color(81, 137, 161));
        imagenDeRegistro.setMinimumSize(new java.awt.Dimension(300, 300));
        imagenDeRegistro.setRoundBottomLeft(300);
        imagenDeRegistro.setRoundBottomRight(300);
        imagenDeRegistro.setRoundTopLeft(300);
        imagenDeRegistro.setRoundTopRight(300);

        javax.swing.GroupLayout imagenDeRegistroLayout = new javax.swing.GroupLayout(imagenDeRegistro);
        imagenDeRegistro.setLayout(imagenDeRegistroLayout);
        imagenDeRegistroLayout.setHorizontalGroup(
            imagenDeRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenDeRegistroLayout.createSequentialGroup()
                .addComponent(imageLabel)
                .addGap(0, 300, Short.MAX_VALUE))
        );
        imagenDeRegistroLayout.setVerticalGroup(
            imagenDeRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenDeRegistroLayout.createSequentialGroup()
                .addComponent(imageLabel)
                .addGap(0, 300, Short.MAX_VALUE))
        );

        Fondo.add(imagenDeRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, -1, -1));

        anteriorImagenBtn.setBackground(new java.awt.Color(81, 137, 161));
        anteriorImagenBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        anteriorImagenBtn.setForeground(new java.awt.Color(255, 255, 255));
        anteriorImagenBtn.setText("<");
        anteriorImagenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorImagenBtnActionPerformed(evt);
            }
        });
        Fondo.add(anteriorImagenBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 470, 70, 30));

        siguienteImagenBtn.setBackground(new java.awt.Color(81, 137, 161));
        siguienteImagenBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        siguienteImagenBtn.setForeground(new java.awt.Color(255, 255, 255));
        siguienteImagenBtn.setText(">");
        siguienteImagenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteImagenBtnActionPerformed(evt);
            }
        });
        Fondo.add(siguienteImagenBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, 70, 30));

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void atrasBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasBtnMouseClicked
        new Inicio().setVisible(true);
    }//GEN-LAST:event_atrasBtnMouseClicked


    private void siguienteImagenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteImagenBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_siguienteImagenBtnActionPerformed

    private void anteriorImagenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorImagenBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anteriorImagenBtnActionPerformed

    private void registroBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registroBtnMouseClicked
        
    }//GEN-LAST:event_registroBtnMouseClicked

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton anteriorImagenBtn;
    private javax.swing.JLabel atrasBtn;
    private javax.swing.JPasswordField confirmarContraseñaTxt;
    private javax.swing.JPasswordField contraseñaTxt;
    private javax.swing.JTextField correoTxt;
    private javax.swing.JLabel imageLabel;
    private controlador.PanelRound imagenDeRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nombreTxt;
    private javaswingdev.pggb.PanelGlowingGradient panelGlowingGradient1;
    private javaswingdev.pggb.PanelGlowingGradient panelGlowingGradient2;
    private javaswingdev.pggb.PanelGlowingGradient panelGlowingGradient3;
    private javaswingdev.pggb.PanelGlowingGradient panelGlowingGradient4;
    private controlador.PanelRound panelRound1;
    private controlador.PanelRound registroBtn;
    private javax.swing.JButton siguienteImagenBtn;
    // End of variables declaration//GEN-END:variables
}
