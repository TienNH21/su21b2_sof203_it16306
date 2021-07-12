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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;

/**
 *
 * @author tiennh
 */
public class DemoPasswordField extends JFrame {
    private JPasswordField pwd;
    private JButton btnToggle;
    private ImageIcon iconOn, iconOff;
    private boolean showPwd;

    public DemoPasswordField() {
        this.getContentPane().setLayout(new FlowLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.showPwd = false;
        this.iconOn = new ImageIcon("src/main/java/lesson2/on.png");
        this.iconOff = new ImageIcon("src/main/java/lesson2/off.png");
        this.btnToggle = new JButton();
        this.btnToggle.setIcon(this.iconOff);
        this.pwd = new JPasswordField();
        this.pwd.setEchoChar('!');
        this.pwd.setColumns(20);

        this.getContentPane().add(this.pwd);
        this.getContentPane().add(this.btnToggle);
        
        this.addAction();
    }
    
    private void addAction() {
        DemoPasswordField that = this;
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                that.showPwd = !that.showPwd;
                if (that.showPwd) {
                    that.btnToggle.setIcon(that.iconOn);
                    that.pwd.setEchoChar((char)0);
                } else {
                    that.btnToggle.setIcon(that.iconOff);
                    that.pwd.setEchoChar('!');
                }
            }
        };
        
        this.btnToggle.addActionListener(listener);
    }
    
    public static void main(String args[]) {
        DemoPasswordField gui = new DemoPasswordField();
        
        gui.setSize(500, 500);
        gui.setVisible(true);
    }
}
