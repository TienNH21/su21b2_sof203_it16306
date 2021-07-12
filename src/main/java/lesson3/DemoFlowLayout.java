/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author tiennh
 */
public class DemoFlowLayout extends JFrame {
    private JButton[] listBtn;
    public DemoFlowLayout() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        FlowLayout layout = new FlowLayout();
        this.getContentPane().setLayout(layout);
        
        this.listBtn = new JButton[10];
        
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton("Button " + (i + 1));
            this.listBtn[i] = btn;
            
            this.getContentPane().add(btn);
        }
    }

    public static void main(String[] args) {
        JFrame f1 = new DemoFlowLayout(),
            f2 = new DemoFlowLayout();
        
        f1.setSize(150, 500);
        f2.setSize(500, 500);
        
        f1.setVisible(true);
        f2.setVisible(true);
    }
}
