/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

/**
 *
 * @author tiennh
 */
public class DemoCheckBox extends JFrame {
    private JCheckBox ckbC, ckbCs, ckbPhp, ckbJava;

    public DemoCheckBox() {
        this.ckbC = new JCheckBox("C/C++");
        this.ckbCs = new JCheckBox("C#");
        this.ckbPhp = new JCheckBox("PHP");

        ImageIcon uncheckedIcon = new ImageIcon("src/main/java/lesson2/java_bw.png");
        ImageIcon checkedIcon = new ImageIcon("src/main/java/lesson2/java.png");
        this.ckbJava = new JCheckBox("Java", checkedIcon, true);
        this.ckbJava.setIconTextGap(20);
        
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(this.ckbC);
        this.getContentPane().add(this.ckbCs);
        this.getContentPane().add(this.ckbPhp);
        this.getContentPane().add(this.ckbJava);
        
        DemoCheckBox that = this;
        this.ckbJava.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isSelected = that.ckbJava.isSelected();
                if (isSelected) {
                    that.ckbJava.setIcon(checkedIcon);
                } else {
                    that.ckbJava.setIcon(uncheckedIcon);
                }
            }
        });
    }
    
    public static void main(String[] args) {
        DemoCheckBox gui = new DemoCheckBox();
        
        gui.setSize(500, 500);
        gui.setVisible(true);
    }
}
