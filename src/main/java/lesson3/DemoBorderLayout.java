/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author tiennh
 */
public class DemoBorderLayout extends JFrame {

    public DemoBorderLayout() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JButton btnCenter = new JButton("Center"),
            btnTop = new JButton("Page Start"),
            btnBot = new JButton("Page End"),
            btnLeft = new JButton("Line Start"),
            btnRight = new JButton("Line End");
        
        BorderLayout layout = new BorderLayout();
        this.getContentPane().setLayout(layout);
        
        this.getContentPane().add(btnCenter, BorderLayout.CENTER);
        this.getContentPane().add(btnTop, BorderLayout.PAGE_START);
        this.getContentPane().add(btnBot, BorderLayout.PAGE_END);
        this.getContentPane().add(btnLeft, BorderLayout.LINE_START);
        this.getContentPane().add(btnRight, BorderLayout.LINE_END);
    }

    public static void main(String[] args) {
        JFrame f1 = new DemoBorderLayout();
        
        f1.setSize(400, 500);
        f1.setVisible(true);
    }
}
