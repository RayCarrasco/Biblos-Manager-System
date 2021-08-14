package interfaz;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class BMS extends javax.swing.JFrame {
    Thread t;
    int dias;
    String fF;
    int id;
    
public String contrasenaguardada;
int ultimoLibroNISBN;
public String clavet;
funciones.ConexionMYSQL conexion=new funciones.ConexionMYSQL();
//Tanlas<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>
String[] enPrestados={"Código préstamo","ISBN","Fecha de préstamo","Fecha de devolución"};
    Object[][] tbPrestados=new String[1][1];
    

String[] enUsuarios={"Clave","Paterno","Materno","Nombres","Fecha nacimiento","Sanción"};
    Object[][] tbUsuarios=new String[6][6];
    Object[][] BMSUsuarios=new String[6][6];
    
String[] enSanciones={"Clave","Paterno","Materno","Nombres","Fecha nacimiento","e-Mail","Sanción"};    
    Object[][] BMSSanciones=new String[7][6];
    
String[] enLibros={"ISBN","Disponible","Título","Autor","Apellidos","Editorial","Edición","Género"};
    Object[][] tbLibros=new String[8][8];
    Object[][] BMSLibros=new String[8][8];

DefaultTableModel usuarios,libros,prestados;
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<

    public BMS() { 
        try{
        conexion.Conectar(); 
        initComponents();
        Comprobacion();//Funcion para actualizar todos los registros
        
        
        
        prestados=new DefaultTableModel(tbPrestados,enPrestados);
        tablaPrestados.setModel(prestados);
        
        usuarios=new DefaultTableModel(tbUsuarios,enUsuarios);
        tablaUsuarios.setModel(usuarios);
        
        usuarios=new DefaultTableModel(BMSUsuarios,enUsuarios);
        xu_tablaUsuarios.setModel(usuarios);
        
        usuarios=new DefaultTableModel(BMSSanciones,enUsuarios);
        xs_tablaSanciones.setModel(usuarios);
        
        libros=new DefaultTableModel(tbLibros,enLibros);
        tablaConsulta.setModel(libros);
        
        libros=new DefaultTableModel(BMSLibros,enLibros);
        xl_tablaBorrarRegistros.setModel(libros);
        
        c_RealizarPrestamo.setEnabled(false);
        llenarAnios();
        ObtenerContrasenia();
        LlenarGeneros();        
        
        if(contrasenaguardada==null){
                 contrasenaguardada="111";
             }
        
        xPanelDeConfiguraciones.setVisible(true);
        
        try{
            String sentenciaSQL1=
                "select max(nISBN) from nISBN";
             PreparedStatement comando1=conexion.driver.prepareStatement(sentenciaSQL1);
             ResultSet r=comando1.executeQuery();
             while(r.next()){
             ultimoLibroNISBN=r.getInt(1);
             }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "ERROR\n"+e);
        }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,"Error al conectar base de datos");
        }
        xPanelDeConfiguraciones.setVisible(false);
        b_Bloquear.setVisible(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        TabbedPane = new javax.swing.JTabbedPane();
        usuarios_Panel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        u_idUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        u_BuscarDatos = new javax.swing.JButton();
        u_aPaterno = new javax.swing.JTextField();
        u_aMaterno = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        u_Nombre = new javax.swing.JTextField();
        u_BuscarClave = new javax.swing.JButton();
        uNuevaBusqueda = new javax.swing.JButton();
        realizarDevolucion = new javax.swing.JButton();
        u_Contraseña = new javax.swing.JPasswordField();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tablaPrestados = new javax.swing.JTable();
        jLabel60 = new javax.swing.JLabel();
        consultas_Panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        c_ISBN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        c_Titulo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConsulta = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        c_Categoria = new javax.swing.JComboBox();
        c_MostrarTodo = new javax.swing.JButton();
        c_Nombre = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        c_Apellido = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        c_BuscarNombreApellido = new javax.swing.JButton();
        c_BuscarISBN = new javax.swing.JButton();
        c_BuscarTitulo = new javax.swing.JButton();
        c_BuscarGenero = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        c_BuscarAvanzada = new javax.swing.JButton();
        c_RealizarPrestamo = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        c_Contraseña = new javax.swing.JPasswordField();
        c_Usuario = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        c_Validacion = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        b_Desbloquear = new javax.swing.JButton();
        b_Bloquear = new javax.swing.JButton();
        xPanelDeConfiguraciones = new javax.swing.JTabbedPane();
        x_Usuarios = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        xu_tablaUsuarios = new javax.swing.JTable();
        xu_Borrar = new javax.swing.JButton();
        xu_aPaterno = new javax.swing.JTextField();
        xu_aMaterno = new javax.swing.JTextField();
        xu_Nombres = new javax.swing.JTextField();
        xu_Mail = new javax.swing.JTextField();
        xu_idUsuario = new javax.swing.JTextField();
        xu_Guardar = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        xu_Anio = new javax.swing.JComboBox();
        xu_Mes = new javax.swing.JComboBox();
        xu_Dia = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        xu_BorrarSeleccion = new javax.swing.JButton();
        x_Sanciones = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        xs_tablaSanciones = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        xs_isUsuario = new javax.swing.JTextField();
        xs_BuscaridUsuario = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        xs_aPaterno = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        xs_aMaterno = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        xs_Nombres = new javax.swing.JTextField();
        xs_BuscarPMN = new javax.swing.JButton();
        xs_MostrarDatos = new javax.swing.JButton();
        xs_QuitarSancion = new javax.swing.JButton();
        x_Libros = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        xl_ISBN = new javax.swing.JTextField();
        xl_Titulo = new javax.swing.JTextField();
        xl_nAutor = new javax.swing.JTextField();
        xl_aAutor = new javax.swing.JTextField();
        xl_Editorial = new javax.swing.JTextField();
        BMSGuardarRLibros = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        xl_ISBNActualizar = new javax.swing.JTextField();
        xl_Comprobar = new javax.swing.JButton();
        xl_TituloComprobar = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        xl_Actualizar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        xl_tablaBorrarRegistros = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        xl_ISBNBorrar = new javax.swing.JTextField();
        xl_Borrar = new javax.swing.JButton();
        xl_Ejemplares = new javax.swing.JSpinner();
        xl_ActualizarEjemplares = new javax.swing.JSpinner();
        xl_sinISBN = new javax.swing.JCheckBox();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        xl_Categoria = new javax.swing.JComboBox();
        xl_Edicion = new javax.swing.JSpinner();
        xl_CancelarActualizacion = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        xl_borrarSeleccion = new javax.swing.JButton();
        x_Configuraciones = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        xc_Actual = new javax.swing.JPasswordField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        xc_AceptarContraseña = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        xc_NuevaCategoria = new javax.swing.JTextField();
        xc_GuardarNCategoria = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        xc_Categoria = new javax.swing.JComboBox();
        xc_BorrarCategoria = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        xc_BorrarPrestamos = new javax.swing.JButton();
        xc_UsuarioPrestamos = new javax.swing.JButton();
        xc_Restablecer = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        xc_Nueva = new javax.swing.JTextField();
        xc_Rectificar = new javax.swing.JTextField();
        b_contraseña = new javax.swing.JPasswordField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAuda = new javax.swing.JMenu();
        ayuda = new javax.swing.JMenuItem();
        menuAcerca = new javax.swing.JMenu();
        acercaBiblos = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblos Manager System");
        setBackground(new java.awt.Color(153, 153, 153));
        setResizable(false);

        jLabel5.setText("Clave de usuario");

        jLabel6.setText("Apellido Paterno");

        jLabel7.setText("Apellido Materno");

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaUsuarios.setAutoscrolls(false);
        jScrollPane2.setViewportView(tablaUsuarios);

        u_BuscarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Search_16x16.png"))); // NOI18N
        u_BuscarDatos.setText("Buscar");
        u_BuscarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_BuscarDatosActionPerformed(evt);
            }
        });

        u_aPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_aPaternoActionPerformed(evt);
            }
        });

        jLabel35.setText("Por nombre");

        jLabel36.setText("Nombre");

        u_BuscarClave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Search_16x16.png"))); // NOI18N
        u_BuscarClave.setText("Buscar");
        u_BuscarClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_BuscarClaveActionPerformed(evt);
            }
        });

        uNuevaBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Favorites_16x16.png"))); // NOI18N
        uNuevaBusqueda.setText("Nueva Búsqueda");
        uNuevaBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uNuevaBusquedaActionPerformed(evt);
            }
        });

        realizarDevolucion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Stock Index Down_16x16.png"))); // NOI18N
        realizarDevolucion.setText("Realizar devolución");
        realizarDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realizarDevolucionActionPerformed(evt);
            }
        });

        u_Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_ContraseñaActionPerformed(evt);
            }
        });

        jLabel55.setText("Se requiere haber selecionado al usuario en la tabla y haber ingresado la contraseña correctamente");

        tablaPrestados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaPrestados.setAutoscrolls(false);
        jScrollPane12.setViewportView(tablaPrestados);

        jLabel60.setText("Préstamos");

        javax.swing.GroupLayout usuarios_PanelLayout = new javax.swing.GroupLayout(usuarios_Panel);
        usuarios_Panel.setLayout(usuarios_PanelLayout);
        usuarios_PanelLayout.setHorizontalGroup(
            usuarios_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usuarios_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(usuarios_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane12)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, usuarios_PanelLayout.createSequentialGroup()
                        .addGroup(usuarios_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uNuevaBusqueda)
                            .addGroup(usuarios_PanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(u_idUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(u_BuscarClave))
                            .addComponent(jLabel35)
                            .addGroup(usuarios_PanelLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(u_aPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(u_aMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(u_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(u_BuscarDatos))
                            .addGroup(usuarios_PanelLayout.createSequentialGroup()
                                .addComponent(realizarDevolucion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(u_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel55)))
                        .addGap(0, 328, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(usuarios_PanelLayout.createSequentialGroup()
                .addGap(530, 530, 530)
                .addComponent(jLabel60)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        usuarios_PanelLayout.setVerticalGroup(
            usuarios_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usuarios_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(uNuevaBusqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(usuarios_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(u_idUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(u_BuscarClave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(usuarios_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(u_aPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(u_aMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(u_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(u_BuscarDatos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(usuarios_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(realizarDevolucion)
                    .addComponent(u_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55))
                .addContainerGap(265, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Usuarios y devoluciones", usuarios_Panel);

        jLabel1.setText("ISBN");

        jLabel2.setText("Autor");

        jLabel3.setText("Título");

        tablaConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaConsulta);

        jLabel4.setText("Género");

        c_MostrarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Find_24x24.png"))); // NOI18N
        c_MostrarTodo.setText("Mostrar todos los libros");
        c_MostrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_MostrarTodoActionPerformed(evt);
            }
        });

        c_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_NombreActionPerformed(evt);
            }
        });

        jLabel32.setText("Nombre");

        jLabel33.setText("Apellidos");

        c_BuscarNombreApellido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Search_16x16.png"))); // NOI18N
        c_BuscarNombreApellido.setText("Buscar");
        c_BuscarNombreApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_BuscarNombreApellidoActionPerformed(evt);
            }
        });

        c_BuscarISBN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Search_16x16.png"))); // NOI18N
        c_BuscarISBN.setText("Buscar");
        c_BuscarISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_BuscarISBNActionPerformed(evt);
            }
        });

        c_BuscarTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Search_16x16.png"))); // NOI18N
        c_BuscarTitulo.setText("Buscar");
        c_BuscarTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_BuscarTituloActionPerformed(evt);
            }
        });

        c_BuscarGenero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Search_16x16.png"))); // NOI18N
        c_BuscarGenero.setText("Buscar");
        c_BuscarGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_BuscarGeneroActionPerformed(evt);
            }
        });

        jLabel34.setText("La búsqueda avanzada requiere de los campos \"Título\" y \"Nombre\" y \"Apellidos\" de la seccion autor");

        c_BuscarAvanzada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Zoom In_24x24.png"))); // NOI18N
        c_BuscarAvanzada.setText("Búsqueda avanzada");
        c_BuscarAvanzada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_BuscarAvanzadaActionPerformed(evt);
            }
        });

        c_RealizarPrestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Stock Index Up_16x16.png"))); // NOI18N
        c_RealizarPrestamo.setText("Realizar préstamo");
        c_RealizarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_RealizarPrestamoActionPerformed(evt);
            }
        });

        jLabel37.setText("Seleccione un libro desde la tabla para usar esta opción e ingrese correctamente la contraseña");

        c_Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_ContraseñaActionPerformed(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel58.setText("Préstamos");

        jLabel59.setText("Clave de usuario");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Check_16x16.png"))); // NOI18N
        jButton6.setText("Validar usuario");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        c_Validacion.setAutoscrolls(false);
        c_Validacion.setFocusable(false);
        c_Validacion.setRequestFocusEnabled(false);
        c_Validacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_ValidacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout consultas_PanelLayout = new javax.swing.GroupLayout(consultas_Panel);
        consultas_Panel.setLayout(consultas_PanelLayout);
        consultas_PanelLayout.setHorizontalGroup(
            consultas_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consultas_PanelLayout.createSequentialGroup()
                .addGroup(consultas_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(consultas_PanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_BuscarAvanzada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
                        .addComponent(c_MostrarTodo))
                    .addGroup(consultas_PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(consultas_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(consultas_PanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel33))
                            .addGroup(consultas_PanelLayout.createSequentialGroup()
                                .addGroup(consultas_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_ISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_BuscarISBN)))
                        .addGap(31, 31, 31)
                        .addGroup(consultas_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(consultas_PanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(c_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(consultas_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(consultas_PanelLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(c_BuscarNombreApellido))
                            .addGroup(consultas_PanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_BuscarTitulo)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_BuscarGenero)))
                        .addGap(0, 312, Short.MAX_VALUE))
                    .addGroup(consultas_PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(consultas_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(consultas_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(consultas_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_Validacion, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(consultas_PanelLayout.createSequentialGroup()
                        .addComponent(c_RealizarPrestamo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(consultas_PanelLayout.createSequentialGroup()
                        .addGap(520, 520, 520)
                        .addComponent(jLabel58)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        consultas_PanelLayout.setVerticalGroup(
            consultas_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consultas_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(consultas_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(c_ISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(c_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_BuscarISBN)
                    .addComponent(c_BuscarTitulo)
                    .addComponent(jLabel4)
                    .addComponent(c_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_BuscarGenero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addGroup(consultas_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(c_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(c_BuscarNombreApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(consultas_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(c_BuscarAvanzada)
                    .addComponent(c_MostrarTodo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel58)
                .addGroup(consultas_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59)
                    .addComponent(jButton6)
                    .addComponent(c_Validacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(consultas_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_RealizarPrestamo)
                    .addComponent(c_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addGap(124, 124, 124))
        );

        TabbedPane.addTab("Consulta y préstamos", consultas_Panel);

        jLabel8.setText("Contraseña");

        b_Desbloquear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Key_24x24.png"))); // NOI18N
        b_Desbloquear.setText("Desbloquear");
        b_Desbloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_DesbloquearActionPerformed(evt);
            }
        });

        b_Bloquear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Log Out_24x24.png"))); // NOI18N
        b_Bloquear.setText("Bloquear");
        b_Bloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_BloquearActionPerformed(evt);
            }
        });

        jLabel9.setText("Agregar Usuario");

        jLabel11.setText("Apellido Paterno");

        jLabel12.setText("Apellido Materno");

        jLabel13.setText("Nombre(s)");

        jLabel14.setText("e-Mail");

        jLabel15.setText("Borrar Usuario");

        jLabel16.setText("Clave de usuario");

        xu_tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(xu_tablaUsuarios);

        xu_Borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Cancel_24x24.png"))); // NOI18N
        xu_Borrar.setText("Borrar por clave usuario");
        xu_Borrar.setToolTipText("Borrar");
        xu_Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xu_BorrarActionPerformed(evt);
            }
        });

        xu_aPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xu_aPaternoActionPerformed(evt);
            }
        });

        xu_Nombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xu_NombresActionPerformed(evt);
            }
        });

        xu_idUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                xu_idUsuarioKeyReleased(evt);
            }
        });

        xu_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Add_24x24.png"))); // NOI18N
        xu_Guardar.setText("Guardar Registo");
        xu_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xu_GuardarActionPerformed(evt);
            }
        });

        jLabel38.setText("Fecha de nacimiento");

        jLabel39.setText("Año");

        jLabel40.setText("Mes");

        jLabel41.setText("Día");

        xu_Mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        xu_Dia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Find_24x24.png"))); // NOI18N
        jButton1.setText("Mostrar todos los registros");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        xu_BorrarSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Cancel_24x24.png"))); // NOI18N
        xu_BorrarSeleccion.setText("Borrar por selección");
        xu_BorrarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xu_BorrarSeleccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout x_UsuariosLayout = new javax.swing.GroupLayout(x_Usuarios);
        x_Usuarios.setLayout(x_UsuariosLayout);
        x_UsuariosLayout.setHorizontalGroup(
            x_UsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(x_UsuariosLayout.createSequentialGroup()
                .addGroup(x_UsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(x_UsuariosLayout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(jLabel9))
                    .addGroup(x_UsuariosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel38)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(x_UsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(x_UsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(x_UsuariosLayout.createSequentialGroup()
                        .addGroup(x_UsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(x_UsuariosLayout.createSequentialGroup()
                                .addGroup(x_UsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(x_UsuariosLayout.createSequentialGroup()
                                        .addGroup(x_UsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(x_UsuariosLayout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(jLabel39)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(xu_Anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel40)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(xu_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel41)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(xu_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(x_UsuariosLayout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(xu_Nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11)))
                                        .addGroup(x_UsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(x_UsuariosLayout.createSequentialGroup()
                                                .addGap(72, 72, 72)
                                                .addComponent(jLabel15))
                                            .addGroup(x_UsuariosLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(xu_aPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(xu_aMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(x_UsuariosLayout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(xu_idUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(xu_Borrar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(xu_BorrarSeleccion)))
                                .addGap(0, 433, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(x_UsuariosLayout.createSequentialGroup()
                        .addGroup(x_UsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(x_UsuariosLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(54, 54, 54)
                                .addComponent(xu_Mail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(xu_Guardar)
                            .addComponent(jButton1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        x_UsuariosLayout.setVerticalGroup(
            x_UsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(x_UsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(x_UsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(xu_Nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(xu_aPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(xu_aMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(x_UsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(x_UsuariosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15))
                    .addGroup(x_UsuariosLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(x_UsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41)
                            .addComponent(xu_Anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xu_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xu_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(x_UsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(xu_Mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xu_Guardar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(x_UsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(xu_idUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xu_Borrar)
                    .addComponent(xu_BorrarSeleccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(145, 145, 145))
        );

        xPanelDeConfiguraciones.addTab("Usuarios", x_Usuarios);

        xs_tablaSanciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(xs_tablaSanciones);

        jLabel31.setText("Clave de usuario");

        xs_BuscaridUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Search_24x24.png"))); // NOI18N
        xs_BuscaridUsuario.setText("Buscar");
        xs_BuscaridUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xs_BuscaridUsuarioActionPerformed(evt);
            }
        });

        jLabel10.setText("Apellido paterno");

        jLabel42.setText("Apellido materno");

        jLabel43.setText("Nombre");

        xs_Nombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xs_NombresActionPerformed(evt);
            }
        });

        xs_BuscarPMN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Search_24x24.png"))); // NOI18N
        xs_BuscarPMN.setText("Buscar");
        xs_BuscarPMN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xs_BuscarPMNActionPerformed(evt);
            }
        });

        xs_MostrarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Find_24x24.png"))); // NOI18N
        xs_MostrarDatos.setText("Ver todos los registros");
        xs_MostrarDatos.setToolTipText("Se necesita haber seleccionado un usuario de la tabla con anterioridad");
        xs_MostrarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xs_MostrarDatosActionPerformed(evt);
            }
        });

        xs_QuitarSancion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Properties_16x16.png"))); // NOI18N
        xs_QuitarSancion.setText("Quitar sanción");
        xs_QuitarSancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xs_QuitarSancionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout x_SancionesLayout = new javax.swing.GroupLayout(x_Sanciones);
        x_Sanciones.setLayout(x_SancionesLayout);
        x_SancionesLayout.setHorizontalGroup(
            x_SancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, x_SancionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(x_SancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, x_SancionesLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xs_aPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xs_aMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xs_Nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xs_BuscarPMN))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, x_SancionesLayout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xs_isUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xs_BuscaridUsuario)))
                .addContainerGap(207, Short.MAX_VALUE))
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(x_SancionesLayout.createSequentialGroup()
                .addComponent(xs_MostrarDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(xs_QuitarSancion)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        x_SancionesLayout.setVerticalGroup(
            x_SancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(x_SancionesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(x_SancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(xs_isUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xs_BuscaridUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(x_SancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(xs_aPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(xs_aMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(xs_Nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xs_BuscarPMN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(x_SancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xs_MostrarDatos)
                    .addComponent(xs_QuitarSancion)))
        );

        xPanelDeConfiguraciones.addTab("Sanciones", x_Sanciones);

        jLabel17.setText("ISBN");

        jLabel18.setText("Título");

        jLabel19.setText("Nombre del autor");

        jLabel20.setText("Apellidos del autor");

        jLabel21.setText("Editorial");

        xl_Titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xl_TituloActionPerformed(evt);
            }
        });

        BMSGuardarRLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Save_24x24.png"))); // NOI18N
        BMSGuardarRLibros.setText("Guardar Registro");
        BMSGuardarRLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BMSGuardarRLibrosActionPerformed(evt);
            }
        });

        jLabel22.setText("Modificar Registro de Libros");

        jLabel23.setText("Ejemplares");

        jLabel24.setText("Agregar Registro");

        jLabel25.setText("Actualizar ejemplares");

        jLabel26.setText("ISBN");

        jLabel27.setText("Título");

        xl_ISBNActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xl_ISBNActualizarActionPerformed(evt);
            }
        });

        xl_Comprobar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Properties_16x16.png"))); // NOI18N
        xl_Comprobar.setText("Comprobar");
        xl_Comprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xl_ComprobarActionPerformed(evt);
            }
        });

        xl_TituloComprobar.setEditable(false);
        xl_TituloComprobar.setFocusable(false);

        jLabel28.setText("Ejemplares");

        xl_Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Refresh_16x16.png"))); // NOI18N
        xl_Actualizar.setText("Actualizar");
        xl_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xl_ActualizarActionPerformed(evt);
            }
        });

        xl_tablaBorrarRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(xl_tablaBorrarRegistros);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("Borrar Registro ");

        jLabel30.setText("ISBN");

        xl_ISBNBorrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                xl_ISBNBorrarKeyReleased(evt);
            }
        });

        xl_Borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Cancel_24x24.png"))); // NOI18N
        xl_Borrar.setText("Borrar por ISBN");
        xl_Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xl_BorrarActionPerformed(evt);
            }
        });

        xl_sinISBN.setText("No tiene ISBN");
        xl_sinISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xl_sinISBNActionPerformed(evt);
            }
        });

        jLabel56.setText("Edición");

        jLabel57.setText("Género");

        xl_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xl_CategoriaActionPerformed(evt);
            }
        });

        xl_CancelarActualizacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Remove_16x16.png"))); // NOI18N
        xl_CancelarActualizacion.setText("Cancelar");
        xl_CancelarActualizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xl_CancelarActualizacionActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Find_24x24.png"))); // NOI18N
        jButton2.setText("Mostrar todos los libros");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        xl_borrarSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Cancel_24x24.png"))); // NOI18N
        xl_borrarSeleccion.setText("Borrar por selección");
        xl_borrarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xl_borrarSeleccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout x_LibrosLayout = new javax.swing.GroupLayout(x_Libros);
        x_Libros.setLayout(x_LibrosLayout);
        x_LibrosLayout.setHorizontalGroup(
            x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(x_LibrosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, x_LibrosLayout.createSequentialGroup()
                        .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addGroup(x_LibrosLayout.createSequentialGroup()
                                .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addGap(77, 77, 77)
                                .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(xl_ISBN)
                                    .addComponent(xl_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(x_LibrosLayout.createSequentialGroup()
                                .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel20)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, x_LibrosLayout.createSequentialGroup()
                                            .addComponent(jLabel56)
                                            .addGap(55, 55, 55)))
                                    .addGroup(x_LibrosLayout.createSequentialGroup()
                                        .addComponent(jLabel57)
                                        .addGap(55, 55, 55)))
                                .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(x_LibrosLayout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(xl_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(xl_Editorial, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(xl_Edicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(xl_Ejemplares, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(xl_aAutor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(x_LibrosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(xl_Comprobar)
                                .addGap(150, 150, 150))
                            .addGroup(x_LibrosLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(xl_sinISBN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addGroup(x_LibrosLayout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(xl_ISBNActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())))
                    .addGroup(x_LibrosLayout.createSequentialGroup()
                        .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(x_LibrosLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(164, 164, 164)
                                .addComponent(BMSGuardarRLibros)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, x_LibrosLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(xl_nAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(x_LibrosLayout.createSequentialGroup()
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(xl_ActualizarEjemplares, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(xl_Actualizar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(xl_CancelarActualizacion))
                                    .addGroup(x_LibrosLayout.createSequentialGroup()
                                        .addComponent(jLabel27)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(xl_TituloComprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, x_LibrosLayout.createSequentialGroup()
                .addGap(551, 561, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addGap(459, 459, 459))
            .addGroup(x_LibrosLayout.createSequentialGroup()
                .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(x_LibrosLayout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(jLabel22))
                    .addGroup(x_LibrosLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xl_ISBNBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xl_Borrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xl_borrarSeleccion)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        x_LibrosLayout.setVerticalGroup(
            x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(x_LibrosLayout.createSequentialGroup()
                .addComponent(jLabel22)
                .addGap(7, 7, 7)
                .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(xl_ISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(xl_ISBNActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xl_sinISBN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(xl_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xl_Comprobar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(xl_nAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(xl_TituloComprobar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(xl_aAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(xl_Actualizar)
                        .addComponent(xl_CancelarActualizacion)
                        .addComponent(xl_ActualizarEjemplares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(xl_Editorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56)
                    .addComponent(xl_Edicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xl_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(BMSGuardarRLibros)
                    .addComponent(xl_Ejemplares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(x_LibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(xl_ISBNBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(xl_Borrar)
                    .addComponent(xl_borrarSeleccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
        );

        xPanelDeConfiguraciones.addTab("Libros", x_Libros);

        jLabel44.setText("Cambio de contraseña");

        jLabel45.setText("Actual");

        jLabel46.setText("Nueva contraseña");

        jLabel47.setText("Verificar");

        xc_AceptarContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Check_16x16.png"))); // NOI18N
        xc_AceptarContraseña.setText("Aceptar");
        xc_AceptarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xc_AceptarContraseñaActionPerformed(evt);
            }
        });

        jLabel48.setText("Editar Categorías");

        jLabel49.setText("Nuevo Género");

        xc_GuardarNCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Save_16x16.png"))); // NOI18N
        xc_GuardarNCategoria.setText("Guardar");
        xc_GuardarNCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xc_GuardarNCategoriaActionPerformed(evt);
            }
        });

        jLabel50.setText("Seleccione categoría a borrar");

        xc_BorrarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Remove_16x16.png"))); // NOI18N
        xc_BorrarCategoria.setText("Borrar");
        xc_BorrarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xc_BorrarCategoriaActionPerformed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setText("Manipular base de datos");

        jLabel52.setText("Restablecer Base de datos y BIBLOS");

        jTextPane1.setEditable(false);
        jTextPane1.setText("Esta opción eliminará toda información sobre libros, usuarios y préstamos o cualquier otra información relacionada con biblos. ESTA ACCIÓN ES IRREVERSIBILE y dejará a Biblos en un estado inicial. No se recomienda hacer uso de esta opción al menos que sea sumamente necesario y como última opción.");
        jTextPane1.setFocusable(false);
        jScrollPane6.setViewportView(jTextPane1);

        jLabel53.setText("Borrar datos de usuarios y préstamos");

        jTextPane2.setText("Esta opción elimina toda la información que pertenesca a los usuarios y a los préstamos realizados por la biblioteca dejando intactos los datos de los libros. LAS DISPONIBILIDADES DE LOS LIBROS NO SE ALTERARÁN ASÍ COMO TAMPOCO LAS CONFIGURACIONES DE Biblos.");
        jTextPane2.setFocusable(false);
        jScrollPane7.setViewportView(jTextPane2);

        jLabel54.setText("Eliminar préstamos");

        jTextPane3.setText("Esta opción elimina todos los registros de préstamos en la base de datos de BIBLOS sin afectar los datos de los usuarios, de los libros o de las configuraciones de BIBLOS(esta opcion no modifica la disponibilidad de los libros).");
        jTextPane3.setFocusable(false);
        jScrollPane8.setViewportView(jTextPane3);

        xc_BorrarPrestamos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Remove_24x24.png"))); // NOI18N
        xc_BorrarPrestamos.setText("Borrar préstamos");
        xc_BorrarPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xc_BorrarPrestamosActionPerformed(evt);
            }
        });

        xc_UsuarioPrestamos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Remove_24x24.png"))); // NOI18N
        xc_UsuarioPrestamos.setText("Borrar usuarios y préstamos");
        xc_UsuarioPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xc_UsuarioPrestamosActionPerformed(evt);
            }
        });

        xc_Restablecer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Remove_24x24.png"))); // NOI18N
        xc_Restablecer.setText("Borrar Todos los datos y restablecer\n ajustes principales");
        xc_Restablecer.setToolTipText("Restablecer.Acción irreversible ");
        xc_Restablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xc_RestablecerActionPerformed(evt);
            }
        });

        jTextPane4.setEditable(false);
        jTextPane4.setText("Las opciones de a continuación son sólo para el uso del administrador, cualquier modificación realizada por una de las siguientes opciones es irreversible. Si no está seguro de lo que implican no las utilice");
        jTextPane4.setAutoscrolls(false);
        jTextPane4.setFocusable(false);
        jScrollPane9.setViewportView(jTextPane4);

        xc_Nueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xc_NuevaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout x_ConfiguracionesLayout = new javax.swing.GroupLayout(x_Configuraciones);
        x_Configuraciones.setLayout(x_ConfiguracionesLayout);
        x_ConfiguracionesLayout.setHorizontalGroup(
            x_ConfiguracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(x_ConfiguracionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(x_ConfiguracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addGroup(x_ConfiguracionesLayout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xc_Actual, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xc_Nueva, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xc_Rectificar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(xc_AceptarContraseña))
                    .addGroup(x_ConfiguracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(x_ConfiguracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(x_ConfiguracionesLayout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(jLabel51)))
                        .addGroup(x_ConfiguracionesLayout.createSequentialGroup()
                            .addGroup(x_ConfiguracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(x_ConfiguracionesLayout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(jLabel49)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(xc_NuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel48))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(xc_GuardarNCategoria)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel50)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(xc_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(xc_BorrarCategoria)))
                    .addGroup(x_ConfiguracionesLayout.createSequentialGroup()
                        .addGroup(x_ConfiguracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, x_ConfiguracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(x_ConfiguracionesLayout.createSequentialGroup()
                                    .addComponent(jLabel52)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(x_ConfiguracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(xc_BorrarPrestamos)
                            .addComponent(xc_UsuarioPrestamos)
                            .addComponent(xc_Restablecer)))
                    .addComponent(jLabel54))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        x_ConfiguracionesLayout.setVerticalGroup(
            x_ConfiguracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(x_ConfiguracionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(x_ConfiguracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xc_Actual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47)
                    .addComponent(xc_AceptarContraseña)
                    .addComponent(xc_Nueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xc_Rectificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(x_ConfiguracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(x_ConfiguracionesLayout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel49))
                    .addGroup(x_ConfiguracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(xc_NuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(xc_GuardarNCategoria)
                        .addComponent(jLabel50)
                        .addComponent(xc_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(xc_BorrarCategoria)))
                .addGap(43, 43, 43)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(x_ConfiguracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xc_BorrarPrestamos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(x_ConfiguracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xc_UsuarioPrestamos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(x_ConfiguracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(x_ConfiguracionesLayout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(xc_Restablecer))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        xc_Restablecer.getAccessibleContext().setAccessibleDescription("");

        xPanelDeConfiguraciones.addTab("Configuraciones", x_Configuraciones);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xPanelDeConfiguraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_Desbloquear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_Bloquear)
                        .addContainerGap(591, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(b_Desbloquear)
                    .addComponent(b_Bloquear)
                    .addComponent(b_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xPanelDeConfiguraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabbedPane.addTab("BMS", jPanel1);

        menuAuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Help_16x16.png"))); // NOI18N
        menuAuda.setText("Ayuda");

        ayuda.setText("Ayuda Biblos");
        ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayudaActionPerformed(evt);
            }
        });
        menuAuda.add(ayuda);

        jMenuBar1.add(menuAuda);

        menuAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Information_16x16.png"))); // NOI18N
        menuAcerca.setText("Acerca");
        menuAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAcercaActionPerformed(evt);
            }
        });

        acercaBiblos.setText("Acerca de Biblos");
        acercaBiblos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acercaBiblosActionPerformed(evt);
            }
        });
        menuAcerca.add(acercaBiblos);

        jMenuBar1.add(menuAcerca);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAcercaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_menuAcercaActionPerformed

    private void acercaBiblosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acercaBiblosActionPerformed
        opciones.Acerca ventana=new opciones.Acerca();
        ventana.setVisible(true);
    }//GEN-LAST:event_acercaBiblosActionPerformed

    private void xl_BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xl_BorrarActionPerformed
if(xl_ISBNBorrar.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "El campo clave debe contener los datos");
        }else{
        int boleano=JOptionPane.showConfirmDialog(null,"¿Desea eliminar el registro seleccionado");
        if(boleano==0){
        try{
            String sentenciaSQL=
                "delete from libros where ISBN='"+xl_ISBNBorrar.getText()+"'";
             PreparedStatement comando=conexion.driver.prepareStatement(sentenciaSQL);
             comando.executeUpdate(sentenciaSQL);
             xl_ISBNBorrar.setText("");
             JOptionPane.showMessageDialog(this,"Registro de libro eliminado");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "ERROR\n"+e);
        }
        }
}
    }//GEN-LAST:event_xl_BorrarActionPerformed

    private void xl_ISBNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xl_ISBNActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xl_ISBNActualizarActionPerformed

    private void xl_TituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xl_TituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xl_TituloActionPerformed

    private void xu_NombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xu_NombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xu_NombresActionPerformed

    private void xu_aPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xu_aPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xu_aPaternoActionPerformed

    private void b_BloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_BloquearActionPerformed
        xPanelDeConfiguraciones.setVisible(false);
        b_Desbloquear.setVisible(true);
        b_Bloquear.setVisible(false);
    }//GEN-LAST:event_b_BloquearActionPerformed

    private void b_DesbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_DesbloquearActionPerformed
        char[] q;
        q=b_contraseña.getPassword();
        String p=new String(q);

        if(contrasenaguardada.equals(p)){
            xPanelDeConfiguraciones.setVisible(true);
            b_Desbloquear.setVisible(false);
            b_Bloquear.setVisible(true);
        }else{
           
        }
        b_contraseña.setText("");
    }//GEN-LAST:event_b_DesbloquearActionPerformed

    private void u_aPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_aPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_u_aPaternoActionPerformed

    private void xs_BuscaridUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xs_BuscaridUsuarioActionPerformed
        try{
            String sentenciaSQL=
                    "select id_usuario,paterno,materno,nombres,fecha_na,email,sancion from usuarios where id_usuario="+xs_isUsuario.getText()+" and sancion='sancionado'";
            
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            BMSSanciones=new String[20][7];
            int i=0;
            while(resultado.next()){
                BMSSanciones[i][0]=resultado.getString(1);
                BMSSanciones[i][1]=resultado.getString(2);
                BMSSanciones[i][2]=resultado.getString(3);
                BMSSanciones[i][3]=resultado.getString(4);
                BMSSanciones[i][4]=resultado.getString(5);
                BMSSanciones[i][5]=resultado.getString(6);
                BMSSanciones[i][6]=resultado.getString(7);
                i++;
            }
            resultado.close();
        usuarios=new DefaultTableModel(BMSSanciones,enSanciones);
        xs_tablaSanciones.setModel(usuarios);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la"+"recuperación de los datos \n"+e);
        }
    }//GEN-LAST:event_xs_BuscaridUsuarioActionPerformed

    private void c_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_NombreActionPerformed

    private void c_BuscarISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_BuscarISBNActionPerformed

        int counter=0;
        try{
            String sentenciaSQL="select count(isbn) from libros";
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                counter=resultado.getInt(1);
            }
            resultado.close();
        }catch(SQLException ex){JOptionPane.showMessageDialog(this, "Errore\n"+ex);}
        
        try{
            String sentenciaSQL=
                    "select ISBN,disponibilidad,nombre_libro,autor,aAutor,editorial,edicion,genero from libros where ISBN="+c_ISBN.getText().trim()+"";
           
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            tbLibros=new String[counter][8];
            int i=0;
            while(resultado.next()){
                tbLibros[i][0]=resultado.getString(1);
                tbLibros[i][1]=resultado.getString(2);
                tbLibros[i][2]=resultado.getString(3);
                tbLibros[i][3]=resultado.getString(4);
                tbLibros[i][4]=resultado.getString(5);
                tbLibros[i][5]=resultado.getString(6);
                tbLibros[i][6]=resultado.getString(7);
                tbLibros[i][7]=resultado.getString(8);
                i++;
            }
            resultado.close();
        libros=new DefaultTableModel(tbLibros,enLibros);
        tablaConsulta.setModel(libros);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la"+"recuperación de los datos \n"+e);
        }
    }//GEN-LAST:event_c_BuscarISBNActionPerformed

    private void c_RealizarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_RealizarPrestamoActionPerformed
        clavet=null;
        c_Validacion.setText("");
        int temp=tablaConsulta.getSelectedRow();
        int disponibles=0;
        int prestados=0;
        try{
            clavet=tablaConsulta.getModel().getValueAt(temp, 0).toString();
             if(clavet=="-1"){
                 JOptionPane.showMessageDialog(this, "Seleccione una libro");
             }else{
                 char[] q;
                 q=c_Contraseña.getPassword();
                 String p=new String(q);
                 if(contrasenaguardada.equals(p)){
                    c_Contraseña.setText("");                          
         int ultimoPrestamo=0;
         
        try{
            String sentenciaSQL=
                "select max(codigo_prestamo) from prestamos";
             PreparedStatement comando1=conexion.driver.prepareStatement(sentenciaSQL);
             ResultSet r=comando1.executeQuery();
             while(r.next()){
             ultimoPrestamo=r.getInt(1);
             }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "ERROR\n"+e);
        }
        try{
            String sentenciaSQL=
                "select disponibilidad from libros where isbn='"+clavet+"'";
             PreparedStatement comando1=conexion.driver.prepareStatement(sentenciaSQL);
             ResultSet r=comando1.executeQuery();
             
             while(r.next()){
             disponibles=r.getInt(1);
             }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "ERROR\n"+e);
        }
        
        try{
            String sentenciaSQL=
                "select count(id_usuario) from prestamos where id_usuario='"+c_Usuario.getText()+"'";
             PreparedStatement comando1=conexion.driver.prepareStatement(sentenciaSQL);
             ResultSet r=comando1.executeQuery();
             while(r.next()){
             prestados=r.getInt(1);
             }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "ERROR\n"+e);
        }
        
        if(disponibles>1 && prestados<3){
        
        ultimoPrestamo++;
                    
                    try{
                        String sentenciaSQL1=
                  "insert into prestamos values ("+ultimoPrestamo+",'"+clavet+"','"+c_Usuario.getText()+"',curdate(),date_add(curdate(),interval 7 day))";
          PreparedStatement comando2=conexion.driver.prepareStatement(sentenciaSQL1);
          comando2.executeUpdate(sentenciaSQL1);
                        
                        
                    
                         sentenciaSQL1=
                  "update libros set disponibilidad="+(disponibles-1)+" where isbn='"+clavet+"'";
           comando2=conexion.driver.prepareStatement(sentenciaSQL1);
          comando2.executeUpdate(sentenciaSQL1);
                        
                        JOptionPane.showMessageDialog(this,"Prestamo realizado");
                    }catch(SQLException ex){
                        JOptionPane.showMessageDialog(this,"Error al realizar prestamo "+ex);
                    }
        }else{
            JOptionPane.showMessageDialog(this, "No hay suficientes libos disponibles para \n realizar préstamo o se ha excedido el número \n de libros prestados");
        }
                    
                 }else{
                     JOptionPane.showMessageDialog(this, "Contraseña Errónea entrada "+p+"  Guardada "+contrasenaguardada);
                  }
             }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,"Seleccione un libro");
        } 
        c_Usuario.setText("");
        c_Validacion.setText("");
        c_Contraseña.setText("");
        c_RealizarPrestamo.setEnabled(false);
    }//GEN-LAST:event_c_RealizarPrestamoActionPerformed

    private void xs_NombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xs_NombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xs_NombresActionPerformed

    private void ayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaActionPerformed
        opciones.Ayuda ventana=new opciones.Ayuda();
        ventana.setVisible(true);
    }//GEN-LAST:event_ayudaActionPerformed

    private void xc_BorrarPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xc_BorrarPrestamosActionPerformed
        try{
          String sentenciaSQL1=
                  "delete from prestamos";
          PreparedStatement comando2=conexion.driver.prepareStatement(sentenciaSQL1);
          comando2.executeUpdate(sentenciaSQL1);
          
          JOptionPane.showMessageDialog(this, "Datos eliminados");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error al borrar "+ex);
        }
    }//GEN-LAST:event_xc_BorrarPrestamosActionPerformed

    private void realizarDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realizarDevolucionActionPerformed
        char[] q;
        q=u_Contraseña.getPassword();
        String p=new String(q);
        int disponibles=0;
        clavet=null;
        
        if(contrasenaguardada.equals(p)){
        
        int temp=tablaUsuarios.getSelectedRow();
        clavet=tablaUsuarios.getModel().getValueAt(temp, 0).toString();
        int boleano;
        String cPrestamo=null;
        temp=tablaPrestados.getSelectedRow();
        cPrestamo=tablaPrestados.getModel().getValueAt(temp, 0).toString();
        
        try{
            if(clavet=="-1" && cPrestamo=="-1"){
                JOptionPane.showMessageDialog(this,"Seleccione un registro con datos");
            }else{
                boleano=JOptionPane.showConfirmDialog(null,"¿Desea realizar la devolución del ejemplar?");
            if(boleano==0){
        try{
            String sentenciaSQL=
                "delete from prestamos where codigo_prestamo='"+cPrestamo+"' and id_usuario="+clavet+"";
             PreparedStatement comando=conexion.driver.prepareStatement(sentenciaSQL);
             comando.executeUpdate(sentenciaSQL);
             JOptionPane.showMessageDialog(this,"Devolución realizada");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "ERROR\n"+e);
        }

        String isbn=tablaPrestados.getModel().getValueAt(temp,1).toString();
        
        try{
            String sentenciaSQL=
                "select disponibilidad from libros where isbn='"+isbn+"'";
             PreparedStatement comando1=conexion.driver.prepareStatement(sentenciaSQL);
             ResultSet r=comando1.executeQuery();
             
             while(r.next()){
             disponibles=r.getInt(1);
             }
             r.close();
             
             sentenciaSQL=
                  "update libros set disponibilidad="+(disponibles+1)+" where isbn='"+isbn+"'";
           comando1=conexion.driver.prepareStatement(sentenciaSQL);
          comando1.executeUpdate(sentenciaSQL);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "ERROR\n"+e);
        }
            }    
            }
        }catch(Exception ex){JOptionPane.showMessageDialog(null,"Seleccione una fila con datos");}
        u_Contraseña.setText("");

        }else{
        JOptionPane.showMessageDialog(null,"Contraseña Erronea");
    }
        u_Contraseña.setText("");
        
    }//GEN-LAST:event_realizarDevolucionActionPerformed

    private void u_ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_ContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_u_ContraseñaActionPerformed

    private void c_ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_ContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_ContraseñaActionPerformed

    private void xc_BorrarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xc_BorrarCategoriaActionPerformed
        try{
            String sentenciaSQL=
                "delete from generos where genero='"+xc_Categoria.getSelectedItem()+"'";
             PreparedStatement comando=conexion.driver.prepareStatement(sentenciaSQL);
             comando.executeUpdate(sentenciaSQL);
             LlenarGeneros();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "ERROR\n"+e);
        }
    }//GEN-LAST:event_xc_BorrarCategoriaActionPerformed

    private void xu_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xu_GuardarActionPerformed
        int ultimoUsuario;
        ultimoUsuario=0;
        try{
            String sentenciaSQL1=
                "select max(id_usuario) from usuarios";
             PreparedStatement comando1=conexion.driver.prepareStatement(sentenciaSQL1);
             ResultSet r=comando1.executeQuery();
             while(r.next()){
             ultimoUsuario=r.getInt(1);
             }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "ERROR\n"+e);
        }
        
        ultimoUsuario++;
        
        try{
          String sentenciaSQL2=
                  "insert into usuarios values("+ultimoUsuario+",'"+xu_aPaterno.getText()+"','"+xu_aMaterno.getText()+"','"+xu_Nombres.getText()+"','"+xu_Anio.getSelectedItem()+"-"+xu_Mes.getSelectedItem()+"-"+xu_Dia.getSelectedItem()+"','"+xu_Mail.getText()+"','Ninguna')";
          PreparedStatement comando2=conexion.driver.prepareStatement(sentenciaSQL2);
          comando2.executeUpdate(sentenciaSQL2);
          
          JOptionPane.showMessageDialog(this, "El Usuario se ha agregado a la base de datos de Biblos");
          xu_aPaterno.setText("");
          xu_aMaterno.setText("");
          xu_Nombres.setText("");
          xu_Mail.setText("");
          
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error al crear registro:_"+ex);
        }
        
    }//GEN-LAST:event_xu_GuardarActionPerformed

    private void BMSGuardarRLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMSGuardarRLibrosActionPerformed
       if(xl_sinISBN.isSelected()){
           xl_ISBN.setText("Asignado Automático");
       }
       
        if(xl_ISBN.getText().trim().equals("") ||xl_Edicion.getValue().equals(0) || xl_Ejemplares.getValue().equals(0) || xl_Titulo.getText().trim().equals("")
                || xl_nAutor.getText().trim().equals("") || xl_aAutor.getText().trim().equals("") || xl_Editorial.getText().trim().equals("") || xl_Categoria.getSelectedItem().equals("")){
            
            JOptionPane.showMessageDialog(this, "Todos los campos son requeridos \n no se permite en edicion y ejemplares el valor cero");
        }else{

        if(xl_sinISBN.isSelected()){
            ultimoLibroNISBN++;
            try{
          String sentenciaSQL1=
                  "insert into libros values('"+ultimoLibroNISBN+"',"+xl_Ejemplares.getValue()+","+xl_Ejemplares.getValue()+",'"+xl_Titulo.getText()+"','"+xl_nAutor.getText()+"','"+xl_aAutor.getText()+"','"+xl_Editorial.getText()+"','"+xl_Edicion.getValue()+"','"+xl_Categoria.getSelectedItem()+"')";
          PreparedStatement comando2=conexion.driver.prepareStatement(sentenciaSQL1);
          comando2.executeUpdate(sentenciaSQL1);
          
          JOptionPane.showMessageDialog(this, "El Libro se ha agregado a la base de datos de Biblos");
          xl_ISBN.setText("");
          xl_Titulo.setText("");
          xl_nAutor.setText("");
          xl_aAutor.setText("");
          xl_Editorial.setText("");
          
          
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error al crear registro: "+ex);
        }
        }else{
            
        try{
          String sentenciaSQL1=
                  "insert into libros values('"+xl_ISBN.getText().trim() +"',"+xl_Ejemplares.getValue()+","+xl_Ejemplares.getValue()+",'"+xl_Titulo.getText()+"','"+xl_nAutor.getText()+"','"+xl_aAutor.getText()+"','"+xl_Editorial.getText()+"','"+xl_Edicion.getValue()+"','"+xl_Categoria.getSelectedItem()+"')";
          PreparedStatement comando2=conexion.driver.prepareStatement(sentenciaSQL1);
          comando2.executeUpdate(sentenciaSQL1);
          
          JOptionPane.showMessageDialog(this, "El Libro se ha agregado a la base de datos de Biblos");
          xl_ISBN.setText("");
          xl_Titulo.setText("");
          xl_nAutor.setText("");
          xl_aAutor.setText("");
          xl_Editorial.setText("");
          
          
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error al crear registro: "+ex);
        }
        }
        }
        
    }//GEN-LAST:event_BMSGuardarRLibrosActionPerformed

    private void xl_ComprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xl_ComprobarActionPerformed
        String Titulo;
        Titulo=null;
        try{
            String sentenciaSQL4=
                "select nombre_libro from libros where ISBN="+xl_ISBNActualizar.getText()+"";
             PreparedStatement comando4=conexion.driver.prepareStatement(sentenciaSQL4);
             ResultSet r=comando4.executeQuery();
             while(r.next()){
             Titulo=r.getString(1);
             }
             xl_TituloComprobar.setText(Titulo);
             
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "ERROR\n"+e);
        }
    }//GEN-LAST:event_xl_ComprobarActionPerformed

    private void xl_CancelarActualizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xl_CancelarActualizacionActionPerformed
        xl_ISBNActualizar.setText("");
        xl_TituloComprobar.setText("");
    }//GEN-LAST:event_xl_CancelarActualizacionActionPerformed

    private void xl_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xl_ActualizarActionPerformed
        if(xl_TituloComprobar.getText().trim().equals("")){
            
        }
        else{//Principal
            int copias=0;
            int disponibilidad=0;
            int actualizacion=Integer.parseInt(xl_ActualizarEjemplares.getValue().toString());
            int x=0;
            
            try{
            String sentenciaSQL1=
                "select copias from libros";
             PreparedStatement comando1=conexion.driver.prepareStatement(sentenciaSQL1);
             ResultSet r=comando1.executeQuery();
             while(r.next()){
             copias=r.getInt(1);
             }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "ERROR\n"+e);
        }
            
            try{
            String sentenciaSQL1=
                "select disponibilidad from libros";
             PreparedStatement comando1=conexion.driver.prepareStatement(sentenciaSQL1);
             ResultSet r=comando1.executeQuery();
             while(r.next()){
             disponibilidad=r.getInt(1);
             }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "ERROR\n"+e);
        }
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<se obtuieron datos
        if(copias<actualizacion){// Comprobar actualizacion
            x=actualizacion-copias;
            disponibilidad=disponibilidad+x;
            try{
          String sentenciaSQL1=
                  "update libros set copias="+actualizacion+",disponibilidad="+disponibilidad+" where ISBN='"+xl_ISBNActualizar.getText()+"'";
          PreparedStatement comando2=conexion.driver.prepareStatement(sentenciaSQL1);
          comando2.executeUpdate(sentenciaSQL1);
          
          JOptionPane.showMessageDialog(this, "Actualización exitosa");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error al Actualizar "+ex);
        }
            
        }// F Comprobar actualizacione
        else{
            x=copias-actualizacion;
            disponibilidad=disponibilidad-x;
            if(disponibilidad<0){
                JOptionPane.showMessageDialog(this,"La cantidad de disponibilidad no puede ser negativa");
            }else{
                try{
          String sentenciaSQL1=
                  "update libros set copias="+actualizacion+",disponibilidad="+disponibilidad+"";
          PreparedStatement comando2=conexion.driver.prepareStatement(sentenciaSQL1);
          comando2.executeUpdate(sentenciaSQL1);
          
          JOptionPane.showMessageDialog(this, "Actualización exitosa");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error al Actualizar "+ex);
        }
            }
        }
        }
    }//GEN-LAST:event_xl_ActualizarActionPerformed

    private void xc_UsuarioPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xc_UsuarioPrestamosActionPerformed
        try{
          String sentenciaSQL1=
                  "delete from prestamos";
          PreparedStatement comando1=conexion.driver.prepareStatement(sentenciaSQL1);
          comando1.executeUpdate(sentenciaSQL1);
          
          String sentenciaSQL2=
                  "delete from usuarios";
          PreparedStatement comando2=conexion.driver.prepareStatement(sentenciaSQL2);
          comando2.executeUpdate(sentenciaSQL2);
          
          JOptionPane.showMessageDialog(this, "Datos eliminados");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error al borrar "+ex);
        }
    }//GEN-LAST:event_xc_UsuarioPrestamosActionPerformed

    private void xc_RestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xc_RestablecerActionPerformed
        try{
          String sentenciaSQL1=
                  "delete from prestamos";
          PreparedStatement comando1=conexion.driver.prepareStatement(sentenciaSQL1);
          comando1.executeUpdate(sentenciaSQL1);
          
          String sentenciaSQL2=
                  "delete from usuarios";
          PreparedStatement comando2=conexion.driver.prepareStatement(sentenciaSQL2);
          comando2.executeUpdate(sentenciaSQL2);
          
          String sentenciaSQL3=
                  "delete from libros";
          PreparedStatement comando3=conexion.driver.prepareStatement(sentenciaSQL3);
          comando3.executeUpdate(sentenciaSQL3);
          
          String sentenciaSQL4=
                  "delete from contrasena";
          PreparedStatement comando4=conexion.driver.prepareStatement(sentenciaSQL4);
          comando4.executeUpdate(sentenciaSQL4);
          
          String sentenciaSQL5=
                  "delete from nisbn";
          PreparedStatement comando5=conexion.driver.prepareStatement(sentenciaSQL5);
          comando5.executeUpdate(sentenciaSQL5);
          
          String sentenciaSQL6=
                  "delete from generos";
          PreparedStatement comando6=conexion.driver.prepareStatement(sentenciaSQL6);
          comando6.executeUpdate(sentenciaSQL6);
          
          JOptionPane.showMessageDialog(this, "Datos eliminados");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error al borrar "+ex);
        }
        JOptionPane.showMessageDialog(this, "La contraseña se ha restaurado al valor por default");
        contrasenaguardada="111";
        b_Desbloquear.setVisible(true);
        b_Bloquear.setVisible(false);
        xPanelDeConfiguraciones.setVisible(false);
    }//GEN-LAST:event_xc_RestablecerActionPerformed

    private void xc_GuardarNCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xc_GuardarNCategoriaActionPerformed

        try{
        String sentenciaSQL=
                  "insert into generos values('"+xc_NuevaCategoria.getText()+"')";
          PreparedStatement comando=conexion.driver.prepareStatement(sentenciaSQL);
          comando.executeUpdate(sentenciaSQL);
          
          JOptionPane.showMessageDialog(this, "Género agregado");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error agregar. \n "+ex);
        }
        LlenarGeneros();
        xc_NuevaCategoria.setText("");
    }//GEN-LAST:event_xc_GuardarNCategoriaActionPerformed

    private void xc_AceptarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xc_AceptarContraseñaActionPerformed
        char[] q;
        q=xc_Actual.getPassword();
        String p=new String(q);
       
        
        if(contrasenaguardada.equals(p)){
           if(xc_Nueva.getText().trim().equals(xc_Rectificar.getText().trim())){
               try{
               String sql="delete from contrasena";
               PreparedStatement comando=conexion.driver.prepareStatement(sql);
               comando.executeUpdate(sql);
               
               String sql2="insert into contrasena values('"+xc_Nueva.getText()+"')";
               PreparedStatement comando2=conexion.driver.prepareStatement(sql2);
               comando2.executeUpdate(sql2);
               
               ObtenerContrasenia();
               JOptionPane.showMessageDialog(this, "Contraseña cambiada");
               }catch(SQLException ex){
                   JOptionPane.showMessageDialog(this, "Error al guardar contraseña: \n"+ex);
               }
           }else{
               JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden");
           }   
           
        }else{
            JOptionPane.showMessageDialog(this, "Contraseña actual errónea ");
        }
        xc_Actual.setText("");
        xc_Rectificar.setText("");
        xc_Nueva.setText("");
    }//GEN-LAST:event_xc_AceptarContraseñaActionPerformed

    private void xc_NuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xc_NuevaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xc_NuevaActionPerformed

    private void u_BuscarClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_BuscarClaveActionPerformed
      
        try{
            String sentenciaSQL=
                    "select id_usuario,paterno,materno,nombres,fecha_na,sancion from usuarios where id_usuario="+u_idUsuario.getText()+"";
            
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            tbUsuarios=new String[20][6];
            int i=0;
            while(resultado.next()){
                tbUsuarios[i][0]=resultado.getString(1);
                tbUsuarios[i][1]=resultado.getString(2);
                tbUsuarios[i][2]=resultado.getString(3);
                tbUsuarios[i][3]=resultado.getString(4);
                tbUsuarios[i][4]=resultado.getString(5);
                tbUsuarios[i][5]=resultado.getString(6);
                i++;
            }
            resultado.close();
        usuarios=new DefaultTableModel(tbUsuarios,enUsuarios);
        tablaUsuarios.setModel(usuarios);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la"+"recuperación de los datos \n"+e);
        }
        
        try{
            String sql="select codigo_prestamo,isbn,fecha_prestamo,fecha_devolucion from prestamos where id_usuario="+u_idUsuario.getText();
            PreparedStatement comando=conexion.driver.prepareStatement(sql);
            ResultSet r=comando.executeQuery();
            tbPrestados =new String [3][4];
            int i=0;
            while(r.next()){
                tbPrestados[i][0]=r.getString(1);
                tbPrestados[i][1]=r.getString(2);
                tbPrestados[i][2]=r.getString(3);
                tbPrestados[i][3]=r.getString(4);
                i++;
            }
            r.close();
            prestados=new DefaultTableModel(tbPrestados,enPrestados);
            tablaPrestados.setModel(prestados);
            
        }catch(SQLException ex){JOptionPane.showMessageDialog(null,"Error \n"+ex);}
        
        u_idUsuario.setEditable(false);
    }//GEN-LAST:event_u_BuscarClaveActionPerformed

    private void u_BuscarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_BuscarDatosActionPerformed

        try{
            String sentenciaSQL=
                    "select id_usuario,paterno,materno,nombres,fecha_na,sancion from usuarios where paterno='"+u_aPaterno.getText()+"' and materno='"+u_aMaterno.getText()+"' and nombres='"+u_Nombre.getText()+"'";
            
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            tbUsuarios=new String[20][6];
            int i=0;
            while(resultado.next()){
                tbUsuarios[i][0]=resultado.getString(1);
                tbUsuarios[i][1]=resultado.getString(2);
                tbUsuarios[i][2]=resultado.getString(3);
                tbUsuarios[i][3]=resultado.getString(4);
                tbUsuarios[i][4]=resultado.getString(5);
                tbUsuarios[i][5]=resultado.getString(6);
                i++;
            }
            resultado.close();
        usuarios=new DefaultTableModel(tbUsuarios,enUsuarios);
        tablaUsuarios.setModel(usuarios);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la"+"recuperación de los datos \n"+e);
        }
        
        try{
            String sql="select codigo_prestamo,isbn,fecha_prestamo,fecha_devolucion from prestamos where id_usuario=(select id_usuario from usuarios where nombres='"+u_Nombre.getText()+"' and paterno='"+u_aPaterno.getText()+"' and materno='"+u_aMaterno.getText()+"')";
            PreparedStatement comando=conexion.driver.prepareStatement(sql);
            ResultSet r=comando.executeQuery();
            tbPrestados=new String[3][4];
            int i=0;
            while(r.next()){
                tbPrestados[i][0]=r.getString(1);
                tbPrestados[i][1]=r.getString(2);
                tbPrestados[i][2]=r.getString(3);
                i++;
            }
            r.close();
            prestados=new DefaultTableModel(tbPrestados,enPrestados);
            tablaPrestados.setModel(prestados);
            
        }catch(SQLException ex){JOptionPane.showMessageDialog(null,"Error \n"+ex);}
        
        u_aPaterno.setEditable(false);
        u_aMaterno.setEditable(false);
        u_Nombre.setEditable(false);
        
    }//GEN-LAST:event_u_BuscarDatosActionPerformed

    private void uNuevaBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uNuevaBusquedaActionPerformed
        u_idUsuario.setText("");
        u_aPaterno.setText("");
        u_aMaterno.setText("");
        u_Nombre.setText("");
        
        u_idUsuario.setEditable(true);
        u_aPaterno.setEditable(true);
        u_aMaterno.setEditable(true);
        u_Nombre.setEditable(true);
    }//GEN-LAST:event_uNuevaBusquedaActionPerformed

    private void c_BuscarGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_BuscarGeneroActionPerformed

        int counter=0;
        try{
            String sentenciaSQL="select count(isbn) from libros";
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                counter=resultado.getInt(1);
            }
            resultado.close();
        }catch(SQLException ex){JOptionPane.showMessageDialog(this, "Errore\n"+ex);}
        
        try{
            String sentenciaSQL=
                    "select ISBN,disponibilidad,nombre_libro,autor,aAutor,editorial,edicion,genero from libros where genero='"+c_Categoria.getSelectedItem()+"'";
           
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            tbLibros=new String[counter][8];
            int i=0;
            while(resultado.next()){
                tbLibros[i][0]=resultado.getString(1);
                tbLibros[i][1]=resultado.getString(2);
                tbLibros[i][2]=resultado.getString(3);
                tbLibros[i][3]=resultado.getString(4);
                tbLibros[i][4]=resultado.getString(5);
                tbLibros[i][5]=resultado.getString(6);
                tbLibros[i][6]=resultado.getString(7);
                tbLibros[i][7]=resultado.getString(8);
                i++;
            }
            resultado.close();
        libros=new DefaultTableModel(tbLibros,enLibros);
        tablaConsulta.setModel(libros);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la"+"recuperación de los datos \n"+e);
        }
    }//GEN-LAST:event_c_BuscarGeneroActionPerformed

    private void c_BuscarTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_BuscarTituloActionPerformed

        int counter=0;
        try{
            String sentenciaSQL="select count(isbn) from libros";
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                counter=resultado.getInt(1);
            }
            resultado.close();
        }catch(SQLException ex){JOptionPane.showMessageDialog(this, "Errore\n"+ex);}
        
        try{
            String sentenciaSQL=
                    "select ISBN,disponibilidad,nombre_libro,autor,aAutor,editorial,edicion,genero from libros where nombre_libro='"+c_Titulo.getText()+"'";
           
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            tbLibros=new String[counter][8];
            int i=0;
            while(resultado.next()){
                tbLibros[i][0]=resultado.getString(1);
                tbLibros[i][1]=resultado.getString(2);
                tbLibros[i][2]=resultado.getString(3);
                tbLibros[i][3]=resultado.getString(4);
                tbLibros[i][4]=resultado.getString(5);
                tbLibros[i][5]=resultado.getString(6);
                tbLibros[i][6]=resultado.getString(7);
                tbLibros[i][7]=resultado.getString(8);
                i++;
            }
            resultado.close();
        libros=new DefaultTableModel(tbLibros,enLibros);
        tablaConsulta.setModel(libros);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la"+"recuperación de los datos \n"+e);
        }
    }//GEN-LAST:event_c_BuscarTituloActionPerformed

    private void c_BuscarNombreApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_BuscarNombreApellidoActionPerformed

        int counter=0;
        try{
            String sentenciaSQL="select count(isbn) from libros";
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                counter=resultado.getInt(1);
            }
            resultado.close();
        }catch(SQLException ex){JOptionPane.showMessageDialog(this, "Errore\n"+ex);}
        
        try{
            String sentenciaSQL=
                    "select ISBN,disponibilidad,nombre_libro,autor,aAutor,editorial,edicion,genero from libros where autor='"+c_Nombre.getText()+"' and aAutor='"+c_Apellido.getText()+"'";
           
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            tbLibros=new String[counter][8];
            int i=0;
            while(resultado.next()){
                tbLibros[i][0]=resultado.getString(1);
                tbLibros[i][1]=resultado.getString(2);
                tbLibros[i][2]=resultado.getString(3);
                tbLibros[i][3]=resultado.getString(4);
                tbLibros[i][4]=resultado.getString(5);
                tbLibros[i][5]=resultado.getString(6);
                tbLibros[i][6]=resultado.getString(7);
                tbLibros[i][7]=resultado.getString(8);
                i++;
            }
            resultado.close();
        libros=new DefaultTableModel(tbLibros,enLibros);
        tablaConsulta.setModel(libros);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la"+"recuperación de los datos \n"+e);
        }
    }//GEN-LAST:event_c_BuscarNombreApellidoActionPerformed

    private void c_BuscarAvanzadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_BuscarAvanzadaActionPerformed

        int counter=0;
        try{
            String sentenciaSQL="select count(isbn) from libros";
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                counter=resultado.getInt(1);
            }
            resultado.close();
        }catch(SQLException ex){JOptionPane.showMessageDialog(this, "Errore\n"+ex);}
        
        try{
            String sentenciaSQL=
                    "select ISBN,disponibilidad,nombre_libro,autor,aAutor,editorial,edicion,genero from libros where autor='"+c_Nombre.getText()+"' and aAutor='"+c_Apellido.getText()+"' and nombre_libro='"+c_Titulo.getText()+"'";
           
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            tbLibros=new String[counter][8];
            int i=0;
            while(resultado.next()){
                tbLibros[i][0]=resultado.getString(1);
                tbLibros[i][1]=resultado.getString(2);
                tbLibros[i][2]=resultado.getString(3);
                tbLibros[i][3]=resultado.getString(4);
                tbLibros[i][4]=resultado.getString(5);
                tbLibros[i][5]=resultado.getString(6);
                tbLibros[i][6]=resultado.getString(7);
                tbLibros[i][7]=resultado.getString(8);
                i++;
            }
            resultado.close();
        libros=new DefaultTableModel(tbLibros,enLibros);
        tablaConsulta.setModel(libros);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la"+"recuperación de los datos \n"+e);
        }
    }//GEN-LAST:event_c_BuscarAvanzadaActionPerformed

    private void c_MostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_MostrarTodoActionPerformed

        int counter=0;
        try{
            String sentenciaSQL="select count(isbn) from libros";
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                counter=resultado.getInt(1);
            }
            resultado.close();
        }catch(SQLException ex){JOptionPane.showMessageDialog(this, "Errore\n"+ex);}
        
        try{
            String sentenciaSQL=
                    "select ISBN,disponibilidad,nombre_libro,autor,aAutor,editorial,edicion,genero from libros";
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            tbLibros=new String[counter][8];
            int i=0;
            while(resultado.next()){
                tbLibros[i][0]=resultado.getString(1);
                tbLibros[i][1]=resultado.getString(2);
                tbLibros[i][2]=resultado.getString(3);
                tbLibros[i][3]=resultado.getString(4);
                tbLibros[i][4]=resultado.getString(5);
                tbLibros[i][5]=resultado.getString(6);
                tbLibros[i][6]=resultado.getString(7);
                tbLibros[i][7]=resultado.getString(8);
                i++;
            }
            resultado.close();
        libros=new DefaultTableModel(tbLibros,enLibros);
        tablaConsulta.setModel(libros);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la"+"recuperación de los datos \n"+e);
        }
    }//GEN-LAST:event_c_MostrarTodoActionPerformed

    private void xu_BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xu_BorrarActionPerformed
        if(xu_idUsuario.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "El campo clave debe contener los datos");
        }else{
        int boleano=JOptionPane.showConfirmDialog(null,"¿Desea eliminar el registro seleccionado");
        if(boleano==0){
        try{
            String sentenciaSQL=
                "delete from usuarios where id_usuario='"+xu_idUsuario.getText()+"'";
             PreparedStatement comando=conexion.driver.prepareStatement(sentenciaSQL);
             comando.executeUpdate(sentenciaSQL);
             xu_idUsuario.setText("");
             JOptionPane.showMessageDialog(this,"Registro de usuario eliminado");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "ERROR\n"+e);
        }
        }
        }
    }//GEN-LAST:event_xu_BorrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int counter=0;
        try{
            String sentenciaSQL="select count(id_usuario) from usuarios";
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                counter=resultado.getInt(1);
            }
            resultado.close();
        }catch(SQLException ex){JOptionPane.showMessageDialog(this, "Errore\n"+ex);}
        
        try{
            String sentenciaSQL=
                    "select id_usuario,paterno,materno,nombres,fecha_na,sancion from usuarios";
            
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            BMSUsuarios=new String[counter][6];
            int i=0;
            while(resultado.next()){
                BMSUsuarios[i][0]=resultado.getString(1);
                BMSUsuarios[i][1]=resultado.getString(2);
                BMSUsuarios[i][2]=resultado.getString(3);
                BMSUsuarios[i][3]=resultado.getString(4);
                BMSUsuarios[i][4]=resultado.getString(5);
                BMSUsuarios[i][5]=resultado.getString(6);
                i++;
            }
            resultado.close();
        libros=new DefaultTableModel(BMSUsuarios,enUsuarios);
        xu_tablaUsuarios.setModel(libros);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la"+"recuperación de los datos \n"+e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void xu_idUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xu_idUsuarioKeyReleased
        try{
            String sentenciaSQL=
                    "select id_usuario,paterno,materno,nombres,fecha_na,sancion from usuarios where id_usuario like '"+xu_idUsuario.getText()+"%'";
            
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            BMSUsuarios=new String[20][6];
            int i=0;
            while(resultado.next()){
                BMSUsuarios[i][0]=resultado.getString(1);
                BMSUsuarios[i][1]=resultado.getString(2);
                BMSUsuarios[i][2]=resultado.getString(3);
                BMSUsuarios[i][3]=resultado.getString(4);
                BMSUsuarios[i][4]=resultado.getString(5);
                BMSUsuarios[i][5]=resultado.getString(6);
                i++;
            }
            resultado.close();
        libros=new DefaultTableModel(BMSUsuarios,enUsuarios);
        xu_tablaUsuarios.setModel(libros);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la"+"recuperación de los datos \n"+e);
        }
    }//GEN-LAST:event_xu_idUsuarioKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int counter=0;
        try{
            String sentenciaSQL="select count(isbn) from libros";
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                counter=resultado.getInt(1);
            }
            resultado.close();
        }catch(SQLException ex){JOptionPane.showMessageDialog(this, "Errore\n"+ex);}
        
        try{
            String sentenciaSQL=
                    "select ISBN,disponibilidad,nombre_libro,autor,aAutor,editorial,edicion,genero from libros";
           
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            BMSLibros=new String[counter][8];
            int i=0;
            while(resultado.next()){
                BMSLibros[i][0]=resultado.getString(1);
                BMSLibros[i][1]=resultado.getString(2);
                BMSLibros[i][2]=resultado.getString(3);
                BMSLibros[i][3]=resultado.getString(4);
                BMSLibros[i][4]=resultado.getString(5);
                BMSLibros[i][5]=resultado.getString(6);
                BMSLibros[i][6]=resultado.getString(7);
                BMSLibros[i][7]=resultado.getString(8);
                i++;
            }
            resultado.close();
        libros=new DefaultTableModel(BMSLibros,enLibros);
        xl_tablaBorrarRegistros.setModel(libros);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la"+"recuperación de los datos \n"+e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void xl_ISBNBorrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xl_ISBNBorrarKeyReleased
        try{
            String sentenciaSQL=
                    "select ISBN,disponibilidad,nombre_libro,autor,aAutor,editorial,edicion,genero from libros where ISBN like '"+xl_ISBNBorrar.getText()+"%'";
           
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            BMSLibros=new String[100][8];
            int i=0;
            while(resultado.next()){
                BMSLibros[i][0]=resultado.getString(1);
                BMSLibros[i][1]=resultado.getString(2);
                BMSLibros[i][2]=resultado.getString(3);
                BMSLibros[i][3]=resultado.getString(4);
                BMSLibros[i][4]=resultado.getString(5);
                BMSLibros[i][5]=resultado.getString(6);
                BMSLibros[i][6]=resultado.getString(7);
                BMSLibros[i][7]=resultado.getString(8);
                i++;
            }
            resultado.close();
        libros=new DefaultTableModel(BMSLibros,enLibros);
        xl_tablaBorrarRegistros.setModel(libros);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la"+"recuperación de los datos \n"+e);
        }
    }//GEN-LAST:event_xl_ISBNBorrarKeyReleased

    private void xs_MostrarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xs_MostrarDatosActionPerformed
        int counter=0;
        try{
            String sentenciaSQL="select count(id_usuario) from usuarios where sancion='sancionado'";
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                counter=resultado.getInt(1);
            }
            resultado.close();
        }catch(SQLException ex){JOptionPane.showMessageDialog(this, "Errore\n"+ex);}
        
        try{
            String sentenciaSQL=
                    "select id_usuario,paterno,materno,nombres,fecha_na,email,sancion from usuarios where sancion='sancionado'";
            
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            BMSSanciones=new String[7][counter];
            int i=0;
            while(resultado.next()){
                BMSSanciones[i][0]=resultado.getString(1);
                BMSSanciones[i][1]=resultado.getString(2);
                BMSSanciones[i][2]=resultado.getString(3);
                BMSSanciones[i][3]=resultado.getString(4);
                BMSSanciones[i][4]=resultado.getString(5);
                BMSSanciones[i][5]=resultado.getString(6);
                BMSSanciones[i][6]=resultado.getString(7);
                i++;
            }
            resultado.close();
        usuarios=new DefaultTableModel(BMSSanciones,enSanciones);
        xs_tablaSanciones.setModel(usuarios);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la"+"recuperación de los datos \n"+e);
        }
    }//GEN-LAST:event_xs_MostrarDatosActionPerformed

    private void xs_BuscarPMNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xs_BuscarPMNActionPerformed
        try{
            String sentenciaSQL=
                    "select id_usuario,paterno,materno,nombres,fecha_na,email,sancion from usuarios where paterno='"+xs_aPaterno.getText()+"' and materno='"+xs_aMaterno.getText()+"' and nombres='"+xs_Nombres.getText()+"' and sancion='sancionado'";
            
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            BMSSanciones=new String[20][7];
            int i=0;
            while(resultado.next()){
                BMSSanciones[i][0]=resultado.getString(1);
                BMSSanciones[i][1]=resultado.getString(2);
                BMSSanciones[i][2]=resultado.getString(3);
                BMSSanciones[i][3]=resultado.getString(4);
                BMSSanciones[i][4]=resultado.getString(5);
                BMSSanciones[i][5]=resultado.getString(6);
                BMSSanciones[i][6]=resultado.getString(7);
                i++;
            }
            resultado.close();
        usuarios=new DefaultTableModel(BMSSanciones,enSanciones);
        xs_tablaSanciones.setModel(usuarios);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la"+"recuperación de los datos \n"+e);
        }
    }//GEN-LAST:event_xs_BuscarPMNActionPerformed

    private void xl_sinISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xl_sinISBNActionPerformed
        if(xl_sinISBN.isSelected()){
            xl_ISBN.setText("");
            xl_ISBN.setEnabled(false);
        }else{
            xl_ISBN.setText("");
            xl_ISBN.setEnabled(true);
        }
        
    }//GEN-LAST:event_xl_sinISBNActionPerformed

    private void xl_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xl_CategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xl_CategoriaActionPerformed

    private void xl_borrarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xl_borrarSeleccionActionPerformed
        clavet=null;
        int boleano=1;
        try{
        int temp=xl_tablaBorrarRegistros.getSelectedRow();
        clavet=xl_tablaBorrarRegistros.getModel().getValueAt(temp, 0).toString();
        if(clavet=="-1"){
            JOptionPane.showMessageDialog(this, "Seleccione una columna");
        }else{
            boleano=JOptionPane.showConfirmDialog(null,"¿Desea eliminar el registro seleccionado");
            if(boleano==0){
        try{
            String sentenciaSQL=
                "delete from libros where ISBN='"+clavet+"'";
             PreparedStatement comando=conexion.driver.prepareStatement(sentenciaSQL);
             comando.executeUpdate(sentenciaSQL);
             xl_ISBNBorrar.setText("");
             JOptionPane.showMessageDialog(this,"Registro de libro eliminado");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "ERROR\n"+e);
        }
        }
        }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Seleccione una fila con datos");
        }
        
        
    }//GEN-LAST:event_xl_borrarSeleccionActionPerformed

    private void xu_BorrarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xu_BorrarSeleccionActionPerformed
        clavet=null;
        int boleano=1;
        try{
        int temp=xu_tablaUsuarios.getSelectedRow();
        clavet=xu_tablaUsuarios.getModel().getValueAt(temp, 0).toString();
        if(clavet=="-1"){
            JOptionPane.showMessageDialog(this, "Seleccione una columna");
        }else{
            boleano=JOptionPane.showConfirmDialog(null,"¿Desea eliminar el registro seleccionado");
            if(boleano==0){
        try{
            String sentenciaSQL=
                "delete from usuarios where id_usuario='"+clavet+"'";
             PreparedStatement comando=conexion.driver.prepareStatement(sentenciaSQL);
             comando.executeUpdate(sentenciaSQL);
             xl_ISBNBorrar.setText("");
             JOptionPane.showMessageDialog(this,"Registro de usuario eliminado");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "ERROR\n"+e);
        }
        }
        }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Seleccione una fila con datos=");
        }
    }//GEN-LAST:event_xu_BorrarSeleccionActionPerformed

    private void c_ValidacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_ValidacionActionPerformed
        if(c_Validacion.getText().trim().equals("")){
            
        }else{
            c_RealizarPrestamo.setEnabled(true);
        }
    }//GEN-LAST:event_c_ValidacionActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       c_Validacion.setText("");
        
        String cpa="";
       String cma="";
       String cnos="";
        try{
            String sentenciaSQL=
                    "select paterno,materno,nombres from usuarios where id_usuario="+c_Usuario.getText();

             PreparedStatement comando1=conexion.driver.prepareStatement(sentenciaSQL);
             ResultSet r=comando1.executeQuery();
             while(r.next()){
             cpa=r.getString(1);
             cma=r.getString(2);
             cnos=r.getString(3);
             }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "ERROR\n"+e);
        }
       
       c_Validacion.setText(cnos+" "+cpa+" "+cma);
       
       if(c_Validacion.getText().trim().equals("")){
            c_RealizarPrestamo.setEnabled(false);
        }else{
            c_RealizarPrestamo.setEnabled(true);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void xs_QuitarSancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xs_QuitarSancionActionPerformed
        int temp=xs_tablaSanciones.getSelectedRow();
        clavet=xs_tablaSanciones.getModel().getValueAt(temp, 0).toString();
        
        try{
            String sql="update usuarios set sancion='Ninguna' where id_usuario='"+clavet+"'";
            PreparedStatement comando=conexion.driver.prepareStatement(sql);
            comando.executeUpdate(sql);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error \n"+ex);
        }
        
        try{
            String sentenciaSQL=
                    "select id_usuario,paterno,materno,nombres,fecha_na,sancion from usuarios where sancion='sancionado'";
            
            PreparedStatement comando =conexion.driver.prepareStatement(sentenciaSQL);
            ResultSet resultado=comando.executeQuery();
            BMSSanciones=new String[20][6];
            int i=0;
            while(resultado.next()){
                BMSSanciones[i][0]=resultado.getString(1);
                BMSSanciones[i][1]=resultado.getString(2);
                BMSSanciones[i][2]=resultado.getString(3);
                BMSSanciones[i][3]=resultado.getString(4);
                BMSSanciones[i][4]=resultado.getString(5);
                BMSSanciones[i][5]=resultado.getString(6);
                i++;
            }
            resultado.close();
        usuarios=new DefaultTableModel(BMSSanciones,enUsuarios);
        xs_tablaSanciones.setModel(usuarios);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la"+"recuperación de los datos \n"+e);
        }
        
    }//GEN-LAST:event_xs_QuitarSancionActionPerformed

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
            java.util.logging.Logger.getLogger(BMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BMS().setVisible(true);
            }
        });
    }
    
    public void llenarAnios(){
        int i;
        i=1930;
        while (i<=2100){
            xu_Anio.addItem(i);
            i++;
        }
    }
    
    public void LlenarGeneros(){
        xc_Categoria.removeAllItems();
        c_Categoria.removeAllItems();
        xl_Categoria.removeAllItems();
        try{
         PreparedStatement comando=conexion.driver.prepareStatement("select* from generos order by genero");
         ResultSet r=comando.executeQuery();
         
                while(r.next()){
                    xc_Categoria.addItem(r.getObject(1));
                    c_Categoria.addItem(r.getObject(1));
                    xl_Categoria.addItem(r.getObject(1));
                }
                comando.close();
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Error\n"+ex);
         }
    }
    
    public void ObtenerContrasenia(){
        
               try{
            String sentenciaSQL1=
                "select * from contrasena";
             PreparedStatement comando1=conexion.driver.prepareStatement(sentenciaSQL1);
             ResultSet r=comando1.executeQuery();
             
             while(r.next()){
                 contrasenaguardada=r.getString(1);
             }
                         
             //JOptionPane.showMessageDialog(this, "Ray es genial "+contrasenaguardada);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "ERROR\n"+e);
        }
    }
    
    public void obtenerDatosTablaUsuarios(){
        int temp=tablaUsuarios.getSelectedRow();
        clavet=tablaUsuarios.getModel().getValueAt(temp, 0).toString();
        JOptionPane.showMessageDialog(this, "Valor seleccionado= "+clavet);
    }
    
    public void setNombre(String nom){
        int temp=tablaUsuarios.getSelectedRow();
        clavet=tablaUsuarios.getModel().getValueAt(temp, 1).toString();
        this.clavet=nom;
    }
    
    public String getNombre(){
        return this.clavet;
    }
    
     public void Comprobacion(){
        try{
            String obtenerID="select id_usuario from usuarios";
            PreparedStatement comandoA=conexion.driver.prepareStatement(obtenerID);
            ResultSet rID=comandoA.executeQuery();
            while(rID.next()){
                id=rID.getInt(1); //JOptionPane.showMessageDialog(null, " "+id);
                
                String obtenerFechas="select fecha_devolucion from prestamos where id_usuario="+id;
                PreparedStatement comandoB=conexion.driver.prepareStatement(obtenerFechas);
                ResultSet rfechas=comandoB.executeQuery();  
                while(rfechas.next()){

                    fF=rfechas.getString(1); //JOptionPane.showMessageDialog(null, " "+fF);
                    
                    String diferenciaDias="select datediff(curdate(),'"+fF+"');";
                    PreparedStatement comandoC=conexion.driver.prepareCall(diferenciaDias);
                    ResultSet rDiferencia=comandoC.executeQuery();
                    while(rDiferencia.next()){
                        dias=rDiferencia.getInt(1); //JOptionPane.showMessageDialog(null, " "+dias);
                        
                        if(dias>0){
                            String sancionar="update usuarios set sancion='Sancionado' where id_usuario="+id;
                            PreparedStatement comandoD=conexion.driver.prepareStatement(sancionar);
                            comandoD.executeUpdate(sancionar);
                        }
                        
                    }
                    
                }
            }
            
        }catch(SQLException ex){JOptionPane.showMessageDialog(null, "Error \n "+ex);}
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BMSGuardarRLibros;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JMenuItem acercaBiblos;
    private javax.swing.JMenuItem ayuda;
    private javax.swing.JButton b_Bloquear;
    private javax.swing.JButton b_Desbloquear;
    private javax.swing.JPasswordField b_contraseña;
    private javax.swing.JTextField c_Apellido;
    private javax.swing.JButton c_BuscarAvanzada;
    private javax.swing.JButton c_BuscarGenero;
    private javax.swing.JButton c_BuscarISBN;
    private javax.swing.JButton c_BuscarNombreApellido;
    private javax.swing.JButton c_BuscarTitulo;
    private javax.swing.JComboBox c_Categoria;
    private javax.swing.JPasswordField c_Contraseña;
    private javax.swing.JTextField c_ISBN;
    private javax.swing.JButton c_MostrarTodo;
    private javax.swing.JTextField c_Nombre;
    private javax.swing.JButton c_RealizarPrestamo;
    private javax.swing.JTextField c_Titulo;
    private javax.swing.JTextField c_Usuario;
    private javax.swing.JTextField c_Validacion;
    private javax.swing.JPanel consultas_Panel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JMenu menuAcerca;
    private javax.swing.JMenu menuAuda;
    private javax.swing.JButton realizarDevolucion;
    private javax.swing.JTable tablaConsulta;
    private javax.swing.JTable tablaPrestados;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JButton uNuevaBusqueda;
    private javax.swing.JButton u_BuscarClave;
    private javax.swing.JButton u_BuscarDatos;
    private javax.swing.JPasswordField u_Contraseña;
    private javax.swing.JTextField u_Nombre;
    private javax.swing.JTextField u_aMaterno;
    private javax.swing.JTextField u_aPaterno;
    private javax.swing.JTextField u_idUsuario;
    private javax.swing.JPanel usuarios_Panel;
    private javax.swing.JTabbedPane xPanelDeConfiguraciones;
    private javax.swing.JPanel x_Configuraciones;
    private javax.swing.JPanel x_Libros;
    private javax.swing.JPanel x_Sanciones;
    private javax.swing.JPanel x_Usuarios;
    private javax.swing.JButton xc_AceptarContraseña;
    private javax.swing.JPasswordField xc_Actual;
    private javax.swing.JButton xc_BorrarCategoria;
    private javax.swing.JButton xc_BorrarPrestamos;
    private javax.swing.JComboBox xc_Categoria;
    private javax.swing.JButton xc_GuardarNCategoria;
    private javax.swing.JTextField xc_Nueva;
    private javax.swing.JTextField xc_NuevaCategoria;
    private javax.swing.JTextField xc_Rectificar;
    private javax.swing.JButton xc_Restablecer;
    private javax.swing.JButton xc_UsuarioPrestamos;
    private javax.swing.JButton xl_Actualizar;
    private javax.swing.JSpinner xl_ActualizarEjemplares;
    private javax.swing.JButton xl_Borrar;
    private javax.swing.JButton xl_CancelarActualizacion;
    private javax.swing.JComboBox xl_Categoria;
    private javax.swing.JButton xl_Comprobar;
    private javax.swing.JSpinner xl_Edicion;
    private javax.swing.JTextField xl_Editorial;
    private javax.swing.JSpinner xl_Ejemplares;
    private javax.swing.JTextField xl_ISBN;
    private javax.swing.JTextField xl_ISBNActualizar;
    private javax.swing.JTextField xl_ISBNBorrar;
    private javax.swing.JTextField xl_Titulo;
    private javax.swing.JTextField xl_TituloComprobar;
    private javax.swing.JTextField xl_aAutor;
    private javax.swing.JButton xl_borrarSeleccion;
    private javax.swing.JTextField xl_nAutor;
    private javax.swing.JCheckBox xl_sinISBN;
    private javax.swing.JTable xl_tablaBorrarRegistros;
    private javax.swing.JButton xs_BuscarPMN;
    private javax.swing.JButton xs_BuscaridUsuario;
    private javax.swing.JButton xs_MostrarDatos;
    private javax.swing.JTextField xs_Nombres;
    private javax.swing.JButton xs_QuitarSancion;
    private javax.swing.JTextField xs_aMaterno;
    private javax.swing.JTextField xs_aPaterno;
    private javax.swing.JTextField xs_isUsuario;
    private javax.swing.JTable xs_tablaSanciones;
    private javax.swing.JComboBox xu_Anio;
    private javax.swing.JButton xu_Borrar;
    private javax.swing.JButton xu_BorrarSeleccion;
    private javax.swing.JComboBox xu_Dia;
    private javax.swing.JButton xu_Guardar;
    private javax.swing.JTextField xu_Mail;
    private javax.swing.JComboBox xu_Mes;
    private javax.swing.JTextField xu_Nombres;
    private javax.swing.JTextField xu_aMaterno;
    private javax.swing.JTextField xu_aPaterno;
    private javax.swing.JTextField xu_idUsuario;
    private javax.swing.JTable xu_tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}
