/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ACER
 */
public class Ejercicio extends JFrame{
    int contador = 0;
    JLabel letr;
    JButton btn1,btn2,btn3;
    public Ejercicio()  {
        setSize(400, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        btn1 = new JButton("Cerrar");
        btn1.setBounds(50, 50, 120, 25);
        btn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        btn2 = new JButton("sumar");
        btn2.setBounds(190, 50, 120, 25);
        btn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                contador++;
                letr.setText(contador + "");
            }
        });
        
        letr = new JLabel();
        letr.setBounds(50, 100, 120, 25);
        
        add(btn1);
        add(btn2);
        add(letr);
    }

    
}
