/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author tiennh
 */
public class DemoJLabel extends JFrame {
    private JLabel lblEmpty, lblStr, lblAlignment;
    private JLabel lblImg;

    public DemoJLabel() {
        this.lblEmpty = new JLabel();
        this.lblStr = new JLabel("TienNH21");
        this.lblAlignment = new JLabel("FPT Polytechnic", SwingConstants.RIGHT);

        this.lblImg = new JLabel();
        
        ImageIcon img = new ImageIcon("src/main/java/lesson2/happy.png");
        this.lblImg.setIcon(img);
        
        this.lblEmpty.setText("Empty");
        
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(this.lblEmpty);
        this.getContentPane().add(this.lblStr);
        this.getContentPane().add(this.lblAlignment);
        this.getContentPane().add(this.lblImg);
    }
    
    public static void main(String[] args) {
        DemoJLabel gui = new DemoJLabel();
        
        gui.setSize(500, 500);
        gui.setVisible(true);
    }
}
