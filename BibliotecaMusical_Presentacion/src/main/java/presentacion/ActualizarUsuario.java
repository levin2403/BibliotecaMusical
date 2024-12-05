package presentacion;

import com.bmn.dto.UsuarioActualizarDTO;
import com.bmn.excepciones.BOException;
import com.bmn.factories.BOFactory;
import com.bmn.interfaces.IActualizarUsuarioBO;
import com.bmn.singletonUsuario.UsuarioST;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Clase para actualizar el perfil de usuario o solamente para consultar
 *
 * @author Sebastian Murrieta Verduzco
 */
public class ActualizarUsuario extends javax.swing.JFrame {

    private IActualizarUsuarioBO actualizarUsuarioBO;
    private ArrayList<ImageIcon> imagenesUsuario;
    private int imagenActual;
    private boolean estaUsuarioBaneado;

    public ActualizarUsuario() {
        initComponents();
        this.actualizarUsuarioBO = BOFactory.actualizarUsuarioFactory();
        inicializarImagenes();

        // Si no está baneado, proceder con la precarga de información
        if (!estaUsuarioBaneado) {
            precargarInformacionUsuario();

            // Configurar componentes
            nombreTxt.setEnabled(true);
            nombreTxt.setEditable(true);
            correoTxt.setEnabled(true);
            correoTxt.setEditable(true);
            contraseñaTxt.setEnabled(true);
            confirmarContraseñaTxt.setEnabled(true);
            aceptarBtn.setVisible(true);
            banBtn.setVisible(false);
        } else {
            // Si está baneado, deshabilitar campos de actualización
            deshabilitarCamposActualizacion();
            aceptarBtn.setVisible(false);
            banBtn.setVisible(true);
        }

        configurarEscuchasComponentes();
    }

    private void deshabilitarCamposActualizacion() {
        nombreTxt.setEnabled(false);
        nombreTxt.setEditable(false);
        correoTxt.setEnabled(false);
        correoTxt.setEditable(false);
        contraseñaTxt.setEnabled(false);
        confirmarContraseñaTxt.setEnabled(false);
        anteriorImagenBtn.setEnabled(false);
        siguienteImagenBtn.setEnabled(false);
    }

    private void precargarInformacionUsuario() {
        // Cargar información del usuario desde el singleton
        nombreTxt.setText(UsuarioST.getInstance().getNombre());
        correoTxt.setText(UsuarioST.getInstance().getCorreo());

        // Dejar contraseñas en blanco para que el usuario las reescriba
        contraseñaTxt.setText("");
        confirmarContraseñaTxt.setText("");
    }

    private void configurarEscuchasComponentes() {
        anteriorImagenBtn.addActionListener(evt -> navegarImagenAnterior());
        siguienteImagenBtn.addActionListener(evt -> navegarImagenSiguiente());

        aceptarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarCambios();
            }
        });

        if (regresarLb != null) {
            regresarLb.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    dispose();
                    new Principal().setVisible(true);
                }
            });
        }
    }

    private void guardarCambios() {
        try {
            // Verificar si el usuario está baneado antes de guardar cambios
            if (estaUsuarioBaneado) {
                mostrarError("No es posible actualizar un usuario baneado");
                return;
            }

            // Obtener los datos ingresados por el usuario
            String nombre = nombreTxt.getText().trim();
            String correo = correoTxt.getText().trim();
            String contrasena = new String(contraseñaTxt.getPassword());
            String confirmarContrasena = new String(confirmarContraseñaTxt.getPassword());

            // Validaciones
            if (nombre.isEmpty()) {
                mostrarError("El nombre no puede estar vacío");
                return;
            }

            if (correo.isEmpty()) {
                mostrarError("El correo no puede estar vacío");
                return;
            }

            if (contrasena.isEmpty() || confirmarContrasena.isEmpty()) {
                mostrarError("La contraseña no puede estar vacía");
                return;
            }

            if (!contrasena.equals(confirmarContrasena)) {
                mostrarError("Las contraseñas no coinciden");
                return;
            }

            // Crear DTO para actualizar usuario
            UsuarioActualizarDTO usuario = new UsuarioActualizarDTO.Builder()
                    .setNombre(nombre)
                    .setCorreo(correo)
                    .setContrasena(contrasena)
                    .setContrasenaConfirmar(confirmarContrasena)
                    .setImagenPerfil(obtenerRutaImagen())
                    .build();

            // Llamar al método de actualización
            actualizarUsuarioBO.ActualizarUsuario(usuario);

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(
                    this,
                    "Perfil actualizado exitosamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // Opcional: Cerrar ventana actual y abrir principal
            dispose();
            new Principal().setVisible(true);

        } catch (BOException ex) {
            mostrarError("Error al actualizar perfil: " + ex.getMessage());
        }
    }

    private String obtenerRutaImagen() {
        if (!imagenesUsuario.isEmpty() && imagenActual >= 0 && imagenActual < imagenesUsuario.size()) {
            return "/usuario/usuario" + (imagenActual + 1) + ".png";
        }
        return null;
    }

    private void inicializarImagenes() {
        // Similar a Registro, configurar panel de imagen
        imagenDeUsuario.setPreferredSize(new java.awt.Dimension(300, 300));
        imagenDeUsuario.setSize(300, 300);
        imagenDeUsuario.setMinimumSize(new java.awt.Dimension(300, 300));
        imagenDeUsuario.setMaximumSize(new java.awt.Dimension(300, 300));

        // Cargar imágenes de usuario
        imagenesUsuario = new ArrayList<>();
        String[] rutasImagenes = {
            "/usuario/usuario1.png",
            "/usuario/usuario2.png",
            "/usuario/usuario3.png"
        };

        boolean seCargoAlgunaImagen = false;
        for (String ruta : rutasImagenes) {
            URL urlImagen = getClass().getResource(ruta);
            if (urlImagen != null) {
                ImageIcon icono = new ImageIcon(urlImagen);
                imagenesUsuario.add(icono);
                seCargoAlgunaImagen = true;
            } else {
                System.err.println("No se pudo cargar la imagen: " + ruta);
            }
        }

        if (!seCargoAlgunaImagen) {
            mostrarError("No se pudieron cargar las imágenes de usuario.");
        }

        imagenActual = 0;
        actualizarImagenRegistro();
    }

    private void actualizarImagenRegistro() {
        if (!imagenesUsuario.isEmpty() && imagenDeUsuario.getWidth() > 0 && imagenDeUsuario.getHeight() > 0) {
            ImageIcon iconoImagen = imagenesUsuario.get(imagenActual);

            Image img = iconoImagen.getImage().getScaledInstance(
                    imagenDeUsuario.getWidth(),
                    imagenDeUsuario.getHeight(),
                    Image.SCALE_SMOOTH
            );

            imageLabel.setIcon(new ImageIcon(img));
        }
    }

    private void navegarImagenAnterior() {
        imagenActual = (imagenActual > 0)
                ? imagenActual - 1
                : imagenesUsuario.size() - 1;
        actualizarImagenRegistro();
    }

    private void navegarImagenSiguiente() {
        imagenActual = (imagenActual < imagenesUsuario.size() - 1)
                ? imagenActual + 1
                : 0;
        actualizarImagenRegistro();
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Error de actualización",
                JOptionPane.ERROR_MESSAGE
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
        regresarLb = new javax.swing.JLabel();
        banBtn = new controlador.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        imagenDeUsuario = new controlador.PanelRound();
        imageLabel = new javax.swing.JLabel();
        anteriorImagenBtn = new javax.swing.JButton();
        siguienteImagenBtn = new javax.swing.JButton();
        aceptarBtn = new controlador.PanelRound();
        jLabel8 = new javax.swing.JLabel();

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
        jLabel1.setText("USUARIO");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addComponent(jLabel1)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        Fondo.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 32, 800, -1));

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

        regresarLb.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        regresarLb.setForeground(new java.awt.Color(159, 159, 159));
        regresarLb.setText("Regresar");
        regresarLb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Fondo.add(regresarLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 670, -1, -1));

        banBtn.setBackground(new java.awt.Color(42, 89, 109));
        banBtn.setCursorHandEnabled(true);
        banBtn.setRoundBottomLeft(50);
        banBtn.setRoundBottomRight(50);
        banBtn.setRoundTopLeft(50);
        banBtn.setRoundTopRight(50);

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BANEADO");

        javax.swing.GroupLayout banBtnLayout = new javax.swing.GroupLayout(banBtn);
        banBtn.setLayout(banBtnLayout);
        banBtnLayout.setHorizontalGroup(
            banBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(banBtnLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel2)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        banBtnLayout.setVerticalGroup(
            banBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, banBtnLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Fondo.add(banBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 600, 310, 60));

        imagenDeUsuario.setBackground(new java.awt.Color(81, 137, 161));
        imagenDeUsuario.setMinimumSize(new java.awt.Dimension(300, 300));
        imagenDeUsuario.setRoundBottomLeft(300);
        imagenDeUsuario.setRoundBottomRight(300);
        imagenDeUsuario.setRoundTopLeft(300);
        imagenDeUsuario.setRoundTopRight(300);

        javax.swing.GroupLayout imagenDeUsuarioLayout = new javax.swing.GroupLayout(imagenDeUsuario);
        imagenDeUsuario.setLayout(imagenDeUsuarioLayout);
        imagenDeUsuarioLayout.setHorizontalGroup(
            imagenDeUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenDeUsuarioLayout.createSequentialGroup()
                .addComponent(imageLabel)
                .addGap(0, 300, Short.MAX_VALUE))
        );
        imagenDeUsuarioLayout.setVerticalGroup(
            imagenDeUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenDeUsuarioLayout.createSequentialGroup()
                .addComponent(imageLabel)
                .addGap(0, 300, Short.MAX_VALUE))
        );

        Fondo.add(imagenDeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, -1, -1));

        anteriorImagenBtn.setBackground(new java.awt.Color(81, 137, 161));
        anteriorImagenBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        anteriorImagenBtn.setForeground(new java.awt.Color(255, 255, 255));
        anteriorImagenBtn.setText("<");
        Fondo.add(anteriorImagenBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 470, 70, 30));

        siguienteImagenBtn.setBackground(new java.awt.Color(81, 137, 161));
        siguienteImagenBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        siguienteImagenBtn.setForeground(new java.awt.Color(255, 255, 255));
        siguienteImagenBtn.setText(">");
        Fondo.add(siguienteImagenBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, 70, 30));

        aceptarBtn.setBackground(new java.awt.Color(81, 137, 161));
        aceptarBtn.setCursorHandEnabled(true);
        aceptarBtn.setRoundBottomLeft(50);
        aceptarBtn.setRoundBottomRight(50);
        aceptarBtn.setRoundTopLeft(50);
        aceptarBtn.setRoundTopRight(50);

        jLabel8.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ACEPTAR");

        javax.swing.GroupLayout aceptarBtnLayout = new javax.swing.GroupLayout(aceptarBtn);
        aceptarBtn.setLayout(aceptarBtnLayout);
        aceptarBtnLayout.setHorizontalGroup(
            aceptarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aceptarBtnLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel8)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        aceptarBtnLayout.setVerticalGroup(
            aceptarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aceptarBtnLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Fondo.add(aceptarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 520, 310, 60));

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActualizarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private controlador.PanelRound aceptarBtn;
    private javax.swing.JButton anteriorImagenBtn;
    private controlador.PanelRound banBtn;
    private javax.swing.JPasswordField confirmarContraseñaTxt;
    private javax.swing.JPasswordField contraseñaTxt;
    private javax.swing.JTextField correoTxt;
    private javax.swing.JLabel imageLabel;
    private controlador.PanelRound imagenDeUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField nombreTxt;
    private javaswingdev.pggb.PanelGlowingGradient panelGlowingGradient1;
    private javaswingdev.pggb.PanelGlowingGradient panelGlowingGradient2;
    private javaswingdev.pggb.PanelGlowingGradient panelGlowingGradient3;
    private javaswingdev.pggb.PanelGlowingGradient panelGlowingGradient4;
    private controlador.PanelRound panelRound1;
    private javax.swing.JLabel regresarLb;
    private javax.swing.JButton siguienteImagenBtn;
    // End of variables declaration//GEN-END:variables
}
