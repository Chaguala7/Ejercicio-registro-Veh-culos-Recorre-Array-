package Gui;

import ejercicio1y2poe.Ejercicio1y2Poe;
import ejercicio1y2poe.Nodo;
import ejercicio1y2poe.Vehiculo;
import ejercicio1y2poe.Persona;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class Ventana extends JFrame {

    /*
    Realizar una interfaz AGRADABLE que permita capturar la información de un 
    VEHICULO teniendo en cuenta  los siguientes aspectos:
    Datos: código, placa, descripción, propietario: (nombre, dirección), 
    ciudad de la placa (que sean del departamento del Caquetá),  
    Tipo vehículo, Estado (activo, inactivo, suspendido), color (seleccionable), 
    cantidad de pasajeros, etc
    Incluya componentes de cada tipo visto en clase 
    Incluir los siguientes botones con imágenes para GUARDAR, 
    LIMPIAR,  SALIR   (aunque no hagan nada)
     */
    JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7;
    JTextField boxT1, boxT2, boxT3;
    JTextArea areaT1;
    JComboBox cbBox1;
    JButton btn1;
    DefaultTableModel model;
    JTable tabla;
    JScrollPane scrollPane;

    public Ventana() {
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        KeyListener soloNumeros = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };

        KeyListener soloLetras = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isLetter(e.getKeyChar()) && !Character.isSpaceChar(e.getKeyChar())) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };

        lb1 = new JLabel("Bienvenido");
        lb1.setBounds(310, 20, 180, 40);
        lb1.setFont(new Font("Tahoma", Font.BOLD, 30));

        lb2 = new JLabel("Digita la informacion para agregar un nuevo vehiculo");
        lb2.setBounds(50, 80, 400, 20);
        lb2.setFont(new Font("Cambria", Font.ITALIC, 14));
        lb2.setForeground(Color.GRAY);

        lb3 = new JLabel("Placa:");
        lb3.setBounds(50, 120, 50, 20);
        lb3.setFont(new Font("Cambria", Font.ROMAN_BASELINE, 16));

        boxT1 = new JTextField();
        boxT1.setBounds(100, 120, 120, 22);
        boxT1.setFont(new Font("Cambria", Font.PLAIN, 14));

        lb4 = new JLabel("Describa brevemente el Vehiculo:");
        lb4.setBounds(50, 150, 300, 20);
        lb4.setFont(new Font("Cambria", Font.ROMAN_BASELINE, 16));

        areaT1 = new JTextArea();
        areaT1.setBounds(50, 185, 330, 60);
        areaT1.setFont(new Font("Cambria", Font.PLAIN, 14));

        lb5 = new JLabel("Nombre del dueño del Vehiculo:");
        lb5.setBounds(50, 260, 240, 20);
        lb5.setFont(new Font("Cambria", Font.ROMAN_BASELINE, 16));

        boxT2 = new JTextField();
        boxT2.setBounds(50, 290, 240, 22);
        boxT2.setFont(new Font("Cambria", Font.PLAIN, 14));
        boxT2.addKeyListener(soloLetras);

        lb6 = new JLabel("Cc. del dueño del Vehiculo:");
        lb6.setBounds(50, 330, 190, 20);
        lb6.setFont(new Font("Cambria", Font.ROMAN_BASELINE, 16));

        boxT3 = new JTextField();
        boxT3.setBounds(240, 330, 145, 22);
        boxT3.setFont(new Font("Cambria", Font.PLAIN, 14));
        boxT3.addKeyListener(soloNumeros);
        //(moto, automovil, camioneta, autobus). 

        lb7 = new JLabel("Tipo de Vehiculo:");
        lb7.setBounds(50, 370, 120, 20);
        lb7.setFont(new Font("Cambria", Font.ROMAN_BASELINE, 16));

        String[] tipos = {"  - Seleccione -  ", "moto", "automovil", "camioneta", "autobus"};
        cbBox1 = new JComboBox(tipos);
        cbBox1.setBounds(180, 370, 140, 22);

        btn1 = new JButton("Guardar Nuevo Vehiculo");
        btn1.setBounds(300, 500, 180, 30);
        btn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boolean a = false, b = false, c = false, d = false;
                boolean ef = false;
                if (cbBox1.getSelectedIndex() == 0) {
                    cbBox1.setBorder(new LineBorder(Color.RED));
                    a = false;
                } else {
                    cbBox1.setBorder(null);
                    a = true;
                }
                if (validarTextoVacio(boxT1)) {
                    boxT1.setBorder(new LineBorder(Color.RED));
                    b = false;
                } else {
                    boxT1.setBorder(null);
                    b = true;
                }
                if (validarTextoVacio(boxT2)) {
                    boxT2.setBorder(new LineBorder(Color.RED));
                    c = false;
                } else {
                    boxT2.setBorder(null);
                    c = true;
                }
                if (validarTextoVacio(boxT3)) {
                    boxT3.setBorder(new LineBorder(Color.RED));
                    d = false;
                } else {
                    boxT3.setBorder(null);
                    d = true;
                }
                if (validarTextoVacioInArea(areaT1)) {
                    areaT1.setBorder(new LineBorder(Color.RED));
                    ef = false;
                } else {
                    areaT1.setBorder(null);
                    ef = true;
                } 
                
                if (a&&b&&c&&d&&ef) {
                    LocalDateTime fechaHoraActual = LocalDateTime.now();
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyMMddHHmmss");
                    String fechaHoraFormateada = fechaHoraActual.format(formato);
                    Persona dueno = new Persona(boxT2.getText(), Long.parseLong(boxT3.getText()));
                    Vehiculo f = new Vehiculo(boxT1.getText(), dueno, cbBox1.getSelectedItem().toString(), Long.parseLong(fechaHoraFormateada), areaT1.getText());
                    Ejercicio1y2Poe.vehiculos.Insertar_Ultimo(f);
                    llenarTabla();
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor digita los cuadros Faltantes");
                }
            }
        });

        model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        model.addColumn("ID");
        model.addColumn("Placa");
        model.addColumn("Nombre Nueño");
        model.addColumn("Cc. Nueño");

        tabla = new JTable(model);
        llenarTabla();
        tabla.setBounds(400, 80, 350, 400);
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tabla.rowAtPoint(e.getPoint());
                Object value = tabla.getValueAt(row, 1);
                Vehiculo x = (Vehiculo)Ejercicio1y2Poe.vehiculos.BuscarPorPlaca(value + "");
                
                String[] botones = {"Eliminar","Modificar","ok"}; 
                int opcion = JOptionPane.showOptionDialog(null, "Id: " + x.getCodigo() + ", Placa: " + x.getPlaca() + ", Tipo: " + x.getTipo() + ", Dueño: " + x.getDueno().getNombre()+ ", Cc. " + x.getDueno().getIdentificacion() + " \nDescripcion del vehiculo:\n" + x.getDescripcion()
                        , "Vehiculo", 0, JOptionPane.QUESTION_MESSAGE, null, botones, "ok");
                switch(opcion){
                    case 0:
                        String[] boton = {"Eliminar","Cancelar"};
                        int op = JOptionPane.showOptionDialog(null, "Realmente quieres Elimanar la informacion de este vehiculo", "Vehiculo", 0, JOptionPane.QUESTION_MESSAGE, null, boton, "Cancelar");
                        switch (op) {
                            case 0:
                                Ejercicio1y2Poe.vehiculos.Eliminar_PorPlaca(x.getPlaca());
                                llenarTabla();
                                break;
                            case 1:
                                break;
                        }
                        break;
                    case 1:
                        VentanaAjuste ajus = new VentanaAjuste(x);
                        ajus.setVisible(true);
                        dispose();
                        break;
                }
            }
        });
        scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(400, 80, 350, 400);

        add(lb1);
        add(lb2);
        add(lb3);
        add(lb4);
        add(lb5);
        add(lb6);
        add(lb7);
        add(boxT1);
        add(boxT2);
        add(boxT3);
        add(areaT1);
        add(cbBox1);
        add(btn1);
        add(scrollPane);
    }

    public boolean validarTextoVacio(JTextField cuadro) {
        return cuadro.getText().trim().equals("");
    }

    public boolean validarTextoVacioInArea(JTextArea cuadro) {
        return cuadro.getText().trim().equals("");
    }

    public void limpiar() {
        boxT1.setText("");
        boxT2.setText("");
        boxT3.setText("");
        areaT1.setText("");
        cbBox1.setSelectedIndex(0);
    }

    public void llenarTabla() {
        model.setRowCount(0);
        Nodo temp = Ejercicio1y2Poe.vehiculos.getPrimero();
        while (temp != null) {
            Vehiculo aux = (Vehiculo) temp.getDato();
            model.addRow(new Object[]{aux.getCodigo(), aux.getPlaca(), aux.getDueno().getNombre(), aux.getDueno().getIdentificacion()});
            temp = temp.getSiguiente();
        }
    }
}
