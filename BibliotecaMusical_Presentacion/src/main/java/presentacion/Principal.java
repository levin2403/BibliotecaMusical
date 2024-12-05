/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import com.bdm.conexion.ConexionMongo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import controlador.RenderCeldas;
import org.bson.Document;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Sebastian Murrieta Verduzco -233463
 */
public class Principal extends javax.swing.JFrame {

    private boolean isMenuVisible = true;

    public Principal() {
        initComponents();
        configurarTabla(); // Método para configurar la tabla
        // Mueve el panel fuera de la vista al iniciar el frame
        menuDesplegablePanel.setLocation(-menuDesplegablePanel.getWidth(), menuDesplegablePanel.getY());
    }

    /**
     * Filtra las filas de la tabla de acuerdo con el término de búsqueda.
     *
     * @param searchTerm El término de búsqueda para filtrar los datos.
     */
    private void filterTable(String searchTerm) {
        DefaultTableModel model = (DefaultTableModel) tablaAlbum.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tablaAlbum.setRowSorter(sorter);

        RowFilter<DefaultTableModel, Object> filter = RowFilter.regexFilter(
                "(?i)" + searchTerm, 1, 2
        ); // Buscar en las columnas de nombre del álbum y artista
        sorter.setRowFilter(filter);
    }

    /**
     * Configura la tabla de la aplicación. Define el modelo de la tabla y la
     * apariencia visual. Agrega las columnas y configura la tabla para que no
     * se puedan editar las celdas.
     */
    private void configurarTabla() {
        /// Configurar el modelo de la tabla sin datos precargados
        DefaultTableModel modelo = new DefaultTableModel(new String[]{"IMAGEN", "NOMBRE DEL ALBUM", "ARTISTA"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer la tabla no editable
            }
        };
        tablaAlbum.setModel(modelo);

        // Evitar que las columnas se reordenen
        tablaAlbum.getTableHeader().setReorderingAllowed(false);

        // Deshabilitar la modificación del tamaño de las columnas
        for (int i = 0; i < tablaAlbum.getColumnModel().getColumnCount(); i++) {
            tablaAlbum.getColumnModel().getColumn(i).setResizable(false);
        }

        // Configurar alineaciones específicas para cada columna
        RenderCeldas render = new RenderCeldas(tablaAlbum);
        render.setColumnAlignment(0, SwingConstants.CENTER); // Imagen centrada
        render.setColumnAlignment(1, SwingConstants.CENTER); // Nombre centrado
        render.setColumnAlignment(2, SwingConstants.LEFT);   // Artista a la izquierda

        // Configurar colores y apariencia de la tabla
        tablaAlbum.setBackground(new Color(35, 58, 68)); // Fondo oscuro
        tablaAlbum.setForeground(Color.WHITE);           // Texto blanco
        tablaAlbum.setRowHeight(50);                     // Altura de las filas
        tablaAlbum.setSelectionBackground(new Color(58, 107, 128)); // Fondo de selección
        tablaAlbum.setSelectionForeground(Color.WHITE);             // Texto de selección
        tablaAlbum.setShowHorizontalLines(true);        // Mostrar líneas horizontales
        tablaAlbum.setShowVerticalLines(false);         // Ocultar líneas verticales
        tablaAlbum.setGridColor(new Color(255, 255, 255, 50)); // Color de las líneas de cuadrícula

        // Configurar el header de la tabla con el color específico y centrado
        tablaAlbum.getTableHeader().setBackground(new Color(35, 58, 68));
        tablaAlbum.getTableHeader().setForeground(Color.WHITE);

        // Configurar el scroll pane
        jScrollPane1.setBorder(null);
        jScrollPane1.getViewport().setBackground(new Color(35, 58, 68));

        // Ajustar el ancho de las columnas
        tablaAlbum.getColumnModel().getColumn(0).setPreferredWidth(200); // Imagen
        tablaAlbum.getColumnModel().getColumn(1).setPreferredWidth(150); // Nombre
        tablaAlbum.getColumnModel().getColumn(2).setPreferredWidth(100); // Artista

        // Llenar la tabla con los datos de la base de datos
        cargarDatosDeLaBaseDeDatos(modelo);
    }

    /**
     * Carga los datos de la base de datos y los agrega a la tabla.
     *
     * @param modelo El modelo de la tabla al que se agregarán los datos.
     */
    private void cargarDatosDeLaBaseDeDatos(DefaultTableModel modelo) {
        // Obtener la instancia de la conexión a MongoDB
        ConexionMongo conexionMongo = ConexionMongo.getInstance();
        MongoCollection<Document> coleccion = conexionMongo.getCollection("albums"); // Cambia el nombre de la colección si es necesario

        try (MongoCursor<Document> cursor = coleccion.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                String imagen = doc.getString("imagen"); // Cambia el nombre de los campos si es necesario
                String nombreAlbum = doc.getString("nombre_album");
                String artista = doc.getString("artista");

                // Agregar los datos a la tabla
                modelo.addRow(new Object[]{imagen, nombreAlbum, artista});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de MongoDB: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        menuDesplegablePanel = new javax.swing.JPanel();
        albumLb = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        albumFavLb = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        artistaLb = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        artistasFavLb = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        salir = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        perfilLb = new javax.swing.JLabel();
        panelRound1 = new controlador.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        panelRound3 = new controlador.PanelRound();
        busqueda = new javax.swing.JTextField();
        buscarBtn = new javax.swing.JButton();
        menuBtn = new javax.swing.JButton();
        generoFiltro = new javax.swing.JComboBox<>();
        panelInformacionAlbum = new controlador.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ImagenAlbumPanel = new javax.swing.JPanel();
        imagenAlbum = new javax.swing.JLabel();
        nombreDelAlbumTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Canciones = new javax.swing.JScrollPane();
        cancionesDelAlbum = new javax.swing.JTable();
        nombreArtistaTxt = new javax.swing.JTextField();
        panelRound5 = new controlador.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlbum = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Fondo.setBackground(new java.awt.Color(24, 40, 54));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuDesplegablePanel.setBackground(new java.awt.Color(58, 107, 128));
        menuDesplegablePanel.setPreferredSize(new java.awt.Dimension(290, 660));

        albumLb.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        albumLb.setForeground(new java.awt.Color(255, 255, 255));
        albumLb.setText("Album");
        albumLb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        albumLb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                albumLbMouseClicked(evt);
            }
        });

        albumFavLb.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        albumFavLb.setForeground(new java.awt.Color(255, 255, 255));
        albumFavLb.setText("Album Favoritos");
        albumFavLb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        albumFavLb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                albumFavLbMouseClicked(evt);
            }
        });

        artistaLb.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        artistaLb.setForeground(new java.awt.Color(255, 255, 255));
        artistaLb.setText("Artista");
        artistaLb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        artistaLb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                artistaLbMouseClicked(evt);
            }
        });

        artistasFavLb.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        artistasFavLb.setForeground(new java.awt.Color(255, 255, 255));
        artistasFavLb.setText("Artistas Favoritos");
        artistasFavLb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        artistasFavLb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                artistasFavLbMouseClicked(evt);
            }
        });

        salir.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setText("SALIR");
        salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMouseClicked(evt);
            }
        });

        perfilLb.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        perfilLb.setForeground(new java.awt.Color(255, 255, 255));
        perfilLb.setText("Mi perfil");
        perfilLb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        perfilLb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                perfilLbMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menuDesplegablePanelLayout = new javax.swing.GroupLayout(menuDesplegablePanel);
        menuDesplegablePanel.setLayout(menuDesplegablePanelLayout);
        menuDesplegablePanelLayout.setHorizontalGroup(
            menuDesplegablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuDesplegablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuDesplegablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(albumLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(albumFavLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(artistaLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(artistasFavLb, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator5)
                    .addGroup(menuDesplegablePanelLayout.createSequentialGroup()
                        .addComponent(salir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(menuDesplegablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(menuDesplegablePanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(perfilLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        menuDesplegablePanelLayout.setVerticalGroup(
            menuDesplegablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuDesplegablePanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(albumLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(albumFavLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(artistaLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(artistasFavLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 401, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(salir)
                .addGap(8, 8, 8))
            .addGroup(menuDesplegablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuDesplegablePanelLayout.createSequentialGroup()
                    .addContainerGap(582, Short.MAX_VALUE)
                    .addComponent(perfilLb)
                    .addGap(52, 52, 52)))
        );

        Fondo.add(menuDesplegablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 290, 660));

        panelRound1.setBackground(new java.awt.Color(58, 107, 128));

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Album");

        panelRound3.setBackground(new java.awt.Color(35, 58, 68));
        panelRound3.setCursorHandEnabled(true);
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);

        busqueda.setBackground(new java.awt.Color(35, 58, 68));
        busqueda.setForeground(new java.awt.Color(255, 255, 255));
        busqueda.setBorder(null);
        busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaActionPerformed(evt);
            }
        });

        buscarBtn.setBackground(new java.awt.Color(35, 58, 68));
        buscarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/lupa.png"))); // NOI18N
        buscarBtn.setBorder(null);
        buscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(busqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buscarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buscarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        menuBtn.setBackground(new java.awt.Color(58, 107, 128));
        menuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/menu.png"))); // NOI18N
        menuBtn.setBorder(null);
        menuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBtnActionPerformed(evt);
            }
        });

        generoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(menuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(372, 372, 372)
                .addComponent(generoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(generoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(menuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Fondo.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-9, -5, 1290, 80));

        panelInformacionAlbum.setBackground(new java.awt.Color(35, 58, 68));
        panelInformacionAlbum.setRoundBottomLeft(30);
        panelInformacionAlbum.setRoundBottomRight(30);
        panelInformacionAlbum.setRoundTopLeft(30);
        panelInformacionAlbum.setRoundTopRight(30);

        jLabel3.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Artista:");

        jPanel1.setBackground(new java.awt.Color(26, 26, 26));

        ImagenAlbumPanel.setBackground(new java.awt.Color(153, 255, 255));
        ImagenAlbumPanel.setPreferredSize(new java.awt.Dimension(119, 119));

        javax.swing.GroupLayout ImagenAlbumPanelLayout = new javax.swing.GroupLayout(ImagenAlbumPanel);
        ImagenAlbumPanel.setLayout(ImagenAlbumPanelLayout);
        ImagenAlbumPanelLayout.setHorizontalGroup(
            ImagenAlbumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImagenAlbumPanelLayout.createSequentialGroup()
                .addComponent(imagenAlbum)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ImagenAlbumPanelLayout.setVerticalGroup(
            ImagenAlbumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImagenAlbumPanelLayout.createSequentialGroup()
                .addComponent(imagenAlbum)
                .addGap(0, 119, Short.MAX_VALUE))
        );

        nombreDelAlbumTxt.setBackground(new java.awt.Color(26, 26, 26));
        nombreDelAlbumTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nombreDelAlbumTxt.setForeground(new java.awt.Color(255, 255, 255));
        nombreDelAlbumTxt.setText("Nombre Del Album");
        nombreDelAlbumTxt.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nombreDelAlbumTxt)
                    .addComponent(ImagenAlbumPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(ImagenAlbumPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nombreDelAlbumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("OCR A Extended", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Informacion");

        jPanel3.setBackground(new java.awt.Color(35, 58, 68));

        Canciones.setBackground(new java.awt.Color(35, 58, 68));

        cancionesDelAlbum.setBackground(new java.awt.Color(35, 58, 68));
        cancionesDelAlbum.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        cancionesDelAlbum.setForeground(new java.awt.Color(255, 255, 255));
        cancionesDelAlbum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Canciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Canciones.setViewportView(cancionesDelAlbum);
        if (cancionesDelAlbum.getColumnModel().getColumnCount() > 0) {
            cancionesDelAlbum.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Canciones, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(Canciones, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );

        nombreArtistaTxt.setEditable(false);
        nombreArtistaTxt.setBackground(new java.awt.Color(35, 58, 68));
        nombreArtistaTxt.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        nombreArtistaTxt.setForeground(new java.awt.Color(255, 255, 255));
        nombreArtistaTxt.setBorder(null);

        javax.swing.GroupLayout panelInformacionAlbumLayout = new javax.swing.GroupLayout(panelInformacionAlbum);
        panelInformacionAlbum.setLayout(panelInformacionAlbumLayout);
        panelInformacionAlbumLayout.setHorizontalGroup(
            panelInformacionAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionAlbumLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelInformacionAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInformacionAlbumLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(panelInformacionAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelInformacionAlbumLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(nombreArtistaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(panelInformacionAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacionAlbumLayout.createSequentialGroup()
                    .addContainerGap(183, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(149, 149, 149)))
        );
        panelInformacionAlbumLayout.setVerticalGroup(
            panelInformacionAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionAlbumLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreArtistaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacionAlbumLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(panelInformacionAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelInformacionAlbumLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(220, Short.MAX_VALUE)))
        );

        Fondo.add(panelInformacionAlbum, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 590, 300));

        panelRound5.setBackground(new java.awt.Color(35, 58, 68));
        panelRound5.setRoundBottomLeft(30);
        panelRound5.setRoundBottomRight(30);
        panelRound5.setRoundTopLeft(30);
        panelRound5.setRoundTopRight(30);

        tablaAlbum.setBackground(new java.awt.Color(35, 58, 68));
        tablaAlbum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Imagen", "Nombre", "Artista"
            }
        ));
        tablaAlbum.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaAlbum.setGridColor(new java.awt.Color(35, 58, 68));
        tablaAlbum.setSelectionBackground(new java.awt.Color(35, 58, 68));
        jScrollPane1.setViewportView(tablaAlbum);
        if (tablaAlbum.getColumnModel().getColumnCount() > 0) {
            tablaAlbum.getColumnModel().getColumn(0).setPreferredWidth(200);
        }

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );

        Fondo.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 510, 600));

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaActionPerformed
        String searchTerm = busqueda.getText().trim();
        if (!searchTerm.isEmpty()) {
            filterTable(searchTerm);
        } else {
        }
    }//GEN-LAST:event_busquedaActionPerformed

    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBtnActionPerformed
        busquedaActionPerformed(evt);
    }//GEN-LAST:event_buscarBtnActionPerformed

    private void perfilLbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perfilLbMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_perfilLbMouseClicked

    private void artistasFavLbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_artistasFavLbMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_artistasFavLbMouseClicked

    private void menuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBtnActionPerformed
        int panelWidth = menuDesplegablePanel.getWidth();
        int targetX = isMenuVisible ? -panelWidth : 0; // Determina el objetivo según el estado
        isMenuVisible = !isMenuVisible; // Alternar estado

        // Desactivar tabla cuando el menú está visible
        tablaAlbum.setEnabled(!isMenuVisible);

        javax.swing.Timer timer = new javax.swing.Timer(15, new java.awt.event.ActionListener() {
            int currentX = menuDesplegablePanel.getX();

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if ((isMenuVisible && currentX < targetX) || (!isMenuVisible && currentX > targetX)) {
                    currentX += isMenuVisible ? 15 : -15; // Mover según el estado
                    menuDesplegablePanel.setLocation(currentX, menuDesplegablePanel.getY());
                } else {
                    ((javax.swing.Timer) e.getSource()).stop();
                }
            }
        });

        timer.start();

    }//GEN-LAST:event_menuBtnActionPerformed

    private void artistaLbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_artistaLbMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_artistaLbMouseClicked

    private void albumFavLbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_albumFavLbMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_albumFavLbMouseClicked

    private void albumLbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_albumLbMouseClicked
        new Album().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_albumLbMouseClicked

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea salir?",
                "Confirmar Salida",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_salirMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Canciones;
    private javax.swing.JPanel Fondo;
    private javax.swing.JPanel ImagenAlbumPanel;
    private javax.swing.JLabel albumFavLb;
    private javax.swing.JLabel albumLb;
    private javax.swing.JLabel artistaLb;
    private javax.swing.JLabel artistasFavLb;
    private javax.swing.JButton buscarBtn;
    private javax.swing.JTextField busqueda;
    private javax.swing.JTable cancionesDelAlbum;
    private javax.swing.JComboBox<String> generoFiltro;
    private javax.swing.JLabel imagenAlbum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JButton menuBtn;
    private javax.swing.JPanel menuDesplegablePanel;
    private javax.swing.JTextField nombreArtistaTxt;
    private javax.swing.JTextField nombreDelAlbumTxt;
    private controlador.PanelRound panelInformacionAlbum;
    private controlador.PanelRound panelRound1;
    private controlador.PanelRound panelRound3;
    private controlador.PanelRound panelRound5;
    private javax.swing.JLabel perfilLb;
    private javax.swing.JLabel salir;
    private javax.swing.JTable tablaAlbum;
    // End of variables declaration//GEN-END:variables

}
