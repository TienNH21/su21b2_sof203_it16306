/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DemoGridLayout extends JFrame {
    public DemoGridLayout() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        GridLayout layout = new GridLayout(3, 3);
        this.getContentPane().setLayout(layout);
        
        for (int i = 0; i < 9; i++) {
            JButton btn = new JButton("Button " + (i + 1));
            
            this.getContentPane().add(btn);
        }
    }
    
    public static void main(String args[]) {
        JFrame f = new DemoGridLayout();
        f.setSize(400, 400);
        f.setVisible(true);
    }
}
