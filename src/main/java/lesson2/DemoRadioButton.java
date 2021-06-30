/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2;

import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/**
 *
 * @author tiennh
 */
public class DemoRadioButton extends JFrame {
    private JRadioButton rdoNam, rdoNu;
    private ButtonGroup btnGroup;

    public DemoRadioButton() {
        this.btnGroup = new ButtonGroup();
        ImageIcon iconMale = new ImageIcon("src/main/java/lesson2/male.png");
        ImageIcon iconFemale = new ImageIcon("src/main/java/lesson2/female.png");

        this.rdoNam = new JRadioButton("Nam", iconMale, true);
        this.rdoNu = new JRadioButton("Nữ", iconFemale, false);
        this.btnGroup.add(rdoNam);
        this.btnGroup.add(rdoNu);
        
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(this.rdoNam);
        this.getContentPane().add(this.rdoNu);
    }
    
    public static void main(String[] args) {
        DemoRadioButton gui = new DemoRadioButton();
        
        gui.setSize(500, 500);
        gui.setVisible(true);
    }
}
