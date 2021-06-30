/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author tiennh
 */
public class DemoJTextField extends JFrame {
    private JTextField txtEmpty, txtUsername, txtFullname, txtEditable, txtEnable;

    public DemoJTextField() {
        this.txtEmpty = new JTextField();
        this.txtEmpty.setColumns(30);
        this.txtUsername = new JTextField("TienNH21");
        this.txtFullname = new JTextField("FPT Polytechnic", 30);
        this.txtEditable = new JTextField("Editable");
        this.txtEnable = new JTextField("Enabled");
        
        this.txtEditable.setEditable(false);
        this.txtEnable.setEnabled(false);
        
        this.getContentPane().setLayout(new FlowLayout());

        this.getContentPane().add(this.txtEmpty);
        this.getContentPane().add(this.txtUsername);
        this.getContentPane().add(this.txtFullname);
        this.getContentPane().add(this.txtEditable);
        this.getContentPane().add(this.txtEnable);
    }
    
    public static void main(String args[]) {
        DemoJTextField gui = new DemoJTextField();
        
        gui.setSize(500, 500);
        gui.setVisible(true);
    }
}
