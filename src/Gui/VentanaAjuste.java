/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import ejercicio1y2poe.Persona;
import ejercicio1y2poe.Vehiculo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author estudiante
 */
public class VentanaAjuste extends JFrame{
     JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7;
    JTextField boxT1, boxT2, boxT3;
    JTextArea areaT1;
    JComboBox cbBox1;
    JButton btn1;
    public VentanaAjuste(Vehiculo vehiculo) {
        iniciarComponentes(vehiculo);
    }

    public void iniciarComponentes(Vehiculo ajuste) {
        setSize(450, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

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

        lb1 = new JLabel("Modificar");
        lb1.setBounds(120, 20, 160, 40);
        lb1.setFont(new Font("Tahoma", Font.BOLD, 30));

        lb2 = new JLabel("Digita la informacion que quieres modificar");
        lb2.setBounds(50, 80, 400, 20);
        lb2.setFont(new Font("Cambria", Font.ITALIC, 14));
        lb2.setForeground(Color.GRAY);

        lb3 = new JLabel("Placa:");
        lb3.setBounds(50, 120, 50, 20);
        lb3.setFont(new Font("Cambria", Font.ROMAN_BASELINE, 16));

        boxT1 = new JTextField(ajuste.getPlaca());
        boxT1.setBounds(100, 120, 120, 22);
        boxT1.setFont(new Font("Cambria", Font.PLAIN, 14));

        lb4 = new JLabel("Describa brevemente el Vehiculo:");
        lb4.setBounds(50, 150, 300, 20);
        lb4.setFont(new Font("Cambria", Font.ROMAN_BASELINE, 16));

        areaT1 = new JTextArea(ajuste.getDescripcion());
        areaT1.setBounds(50, 185, 330, 60);
        areaT1.setFont(new Font("Cambria", Font.PLAIN, 14));

        lb5 = new JLabel("Nombre del dueño del Vehiculo:");
        lb5.setBounds(50, 260, 240, 20);
        lb5.setFont(new Font("Cambria", Font.ROMAN_BASELINE, 16));

        boxT2 = new JTextField(ajuste.getDueno().getNombre());
        boxT2.setBounds(50, 290, 240, 22);
        boxT2.setFont(new Font("Cambria", Font.PLAIN, 14));
        boxT2.addKeyListener(soloLetras);

        lb6 = new JLabel("Cc. del dueño del Vehiculo:");
        lb6.setBounds(50, 330, 190, 20);
        lb6.setFont(new Font("Cambria", Font.ROMAN_BASELINE, 16));

        boxT3 = new JTextField(ajuste.getDueno().getIdentificacion() + "");
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
        cbBox1.setSelectedItem(ajuste.getTipo());

        btn1 = new JButton("Guardar Modificacion");
        btn1.setBounds(200, 500, 160, 30);
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
                    Persona dueno = new Persona(boxT2.getText(), Long.parseLong(boxT3.getText()));
                    ajuste.setDescripcion(areaT1.getText());
                    ajuste.setDueno(dueno);
                    ajuste.setPlaca(boxT1.getText());
                    ajuste.setTipo(cbBox1.getSelectedItem().toString());
                    dispose();
                    JOptionPane.showMessageDialog(null, "Se guardo correctamente");
                    Ventana x = new Ventana();
                    x.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor digita los cuadros Faltantes");
                }
            }
        });
        
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
    }

    public boolean validarTextoVacio(JTextField cuadro) {
        return cuadro.getText().trim().equals("");
    }

    public boolean validarTextoVacioInArea(JTextArea cuadro) {
        return cuadro.getText().trim().equals("");
    }
}
