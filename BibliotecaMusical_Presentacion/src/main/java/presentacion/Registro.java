package presentacion;

import com.bmn.dto.UsuarioRegistrarDTO;
import com.bmn.excepciones.BOException;
import com.bmn.factories.BOFactory;
import com.bmn.interfaces.IRegistrarUsuarioBO;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastian Murrieta Verduzco -233463
 */
public class Registro extends javax.swing.JFrame {

    private IRegistrarUsuarioBO registrarUsuarioBO;
    private ArrayList<ImageIcon> imagenesRegistro;
    private int imagenActual;

    public Registro() {
        this(BOFactory.registrarUsuarioFactory());
        initComponents();
        inicializarImagenes();
        configurarEscuchasComponentes();
    }

    public Registro(IRegistrarUsuarioBO registrarUsuarioBO) {
        this.registrarUsuarioBO = registrarUsuarioBO;
        initComponents();
        inicializarImagenes();
        configurarEscuchasComponentes();
    }

    private void configurarEscuchasComponentes() {
        anteriorImagenBtn.addActionListener(evt -> navegarImagenAnterior());
        siguienteImagenBtn.addActionListener(evt -> navegarImagenSiguiente());

        registroBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarCambios();
            }
        });

        if (atrasBtn != null) {
            atrasBtn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    dispose();
                }
            });
        }
    }

    private void guardarCambios() {
        try {
            // Obtener los datos ingresados por el usuario
            String nombre = nombreTxt.getText().trim();
            String correo = correoTxt.getText().trim();
            String contrasena = new String(contraseñaTxt.getPassword());
            String confirmarContrasena = new String(confirmarContraseñaTxt.getPassword());

            // Validaciones básicas para evitar campos vacíos o inconsistencias
            if (nombre.isEmpty()) {
                // Validar que el campo "Nombre" no esté vacío
                System.out.println("Texto ingresado en el campo nombre: '" + nombre + "'");

                mostrarError("El nombre no puede estar vacío");
                return;
            }

            if (correo.isEmpty()) {
                // Validar que el campo "Correo" no esté vacío
                mostrarError("El correo no puede estar vacío");
                return;
            }

            if (contrasena.isEmpty() || confirmarContrasena.isEmpty()) {
                // Validar que ambos campos de contraseña no estén vacíos
                mostrarError("La contraseña no puede estar vacía");
                return;
            }

            if (!contrasena.equals(confirmarContrasena)) {
                // Validar que la contraseña y su confirmación sean iguales
                mostrarError("Las contraseñas no coinciden");
                return;
            }

            // Crear un objeto UsuarioRegistrarDTO utilizando el patrón Builder
            UsuarioRegistrarDTO usuario = new UsuarioRegistrarDTO.Builder()
                    .setNombre(nombre) // Asignar el nombre ingresado
                    .setCorreo(correo) // Asignar el correo ingresado
                    .setContrasena(contrasena) // Asignar la contraseña ingresada
                    .setImagenPerfil(obtenerRutaImagen()) // Asignar la imagen de perfil seleccionada
                    .build(); // Construir el objeto

            // Registrar al usuario llamando al método correspondiente en la capa de negocio
            registrarUsuarioBO.registrarUsuario(usuario);

            // Mostrar un mensaje de éxito al usuario
            JOptionPane.showMessageDialog(
                    this,
                    "Registro exitoso", // Mensaje principal
                    "Éxito", // Título de la ventana
                    JOptionPane.INFORMATION_MESSAGE // Tipo de mensaje
            );

            // Cerrar la ventana actual y abrir la ventana principal
            dispose(); // Cierra la ventana actual
            java.awt.EventQueue.invokeLater(() -> {
                try {
                    // Intenta abrir la ventana principal
                    new Principal().setVisible(true);
                } catch (Exception e) {
                    // Muestra un error si no se puede abrir la ventana principal
                    mostrarError("Error al abrir la ventana principal: " + e.getMessage());
                }
            });

        } catch (BOException ex) {
            // Capturar y mostrar errores relacionados con el registro de usuario
            mostrarError("Error al registrar usuario: " + ex.getMessage());
        }
    }

    private String obtenerRutaImagen() {
        // Verificar si hay imágenes disponibles y si el índice actual es válido
        if (!imagenesRegistro.isEmpty() && imagenActual >= 0 && imagenActual < imagenesRegistro.size()) {
            // Retorna la ruta de la imagen seleccionada según el índice actual
            return "/usuario/usuario" + (imagenActual + 1) + ".png";
        }
        // Retorna null si no se pudo determinar una imagen válida
        return null;
    }

    private void inicializarImagenes() {
        // Configurar el tamaño del panel que contiene la imagen
        imagenDeRegistro.setPreferredSize(new java.awt.Dimension(300, 300));
        imagenDeRegistro.setSize(300, 300);
        imagenDeRegistro.setMinimumSize(new java.awt.Dimension(300, 300));
        imagenDeRegistro.setMaximumSize(new java.awt.Dimension(300, 300));

        // Lista para almacenar las imágenes
        imagenesRegistro = new ArrayList<>();
        String[] rutasImagenes = {
            "/usuario/usuario1.png", // Ruta de la primera imagen
            "/usuario/usuario2.png", // Ruta de la segunda imagen
            "/usuario/usuario3.png" // Ruta de la tercera imagen
        };

        boolean seCargoAlgunaImagen = false; // Variable para verificar si alguna imagen se cargó
        for (String ruta : rutasImagenes) {
            // Cargar cada imagen desde su ruta
            URL urlImagen = getClass().getResource(ruta);
            if (urlImagen != null) {
                // Si se encuentra la imagen, se añade a la lista
                ImageIcon icono = new ImageIcon(urlImagen);
                imagenesRegistro.add(icono);
                seCargoAlgunaImagen = true;
            } else {
                // Si no se encuentra la imagen, se muestra un mensaje en la consola
                System.err.println("No se pudo cargar la imagen: " + ruta);
            }
        }

        if (!seCargoAlgunaImagen) {
            // Mostrar un error si ninguna imagen pudo ser cargada
            mostrarError("No se pudieron cargar las imágenes de usuario. Verificar la ubicación de los recursos.");
        }

        imagenActual = 0; // Inicializar el índice de la imagen actual
        actualizarImagenRegistro(); // Actualizar la imagen mostrada en la interfaz
    }

    private void actualizarImagenRegistro() {
        // Verificar si hay imágenes disponibles y si las dimensiones del panel son válidas
        if (!imagenesRegistro.isEmpty() && imagenDeRegistro.getWidth() > 0 && imagenDeRegistro.getHeight() > 0) {
            // Obtener la imagen actual
            ImageIcon iconoImagen = imagenesRegistro.get(imagenActual);

            // Escalar la imagen para ajustarse al tamaño del panel
            Image img = iconoImagen.getImage().getScaledInstance(
                    imagenDeRegistro.getWidth(),
                    imagenDeRegistro.getHeight(),
                    Image.SCALE_SMOOTH
            );

            // Establecer la imagen escalada en el componente
            imageLabel.setIcon(new ImageIcon(img));
        }
    }

    private void navegarImagenAnterior() {
        // Moverse a la imagen anterior en la lista
        imagenActual = (imagenActual > 0)
                ? imagenActual - 1
                : imagenesRegistro.size() - 1;
        actualizarImagenRegistro(); // Actualizar la imagen mostrada
    }

    private void navegarImagenSiguiente() {
        // Moverse a la siguiente imagen en la lista
        imagenActual = (imagenActual < imagenesRegistro.size() - 1)
                ? imagenActual + 1
                : 0;
        actualizarImagenRegistro(); // Actualizar la imagen mostrada
    }

    private void mostrarError(String mensaje) {
        // Mostrar un cuadro de diálogo con el mensaje de error
        JOptionPane.showMessageDialog(
                this,
                mensaje, // Mensaje que se mostrará
                "Error de registro", // Título del cuadro de diálogo
                JOptionPane.ERROR_MESSAGE // Tipo de mensaje (error)
        );
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
