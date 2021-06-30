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
import javax.swing.JOptionPane;

/**
 *
 * @author tiennh
 */
public class DemoJButton extends JFrame {
    private JButton btnText, btnIcon;

    public DemoJButton() {
        this.btnText = new JButton("Click me");
        
        ImageIcon icon = new ImageIcon("src/main/java/lesson2/happy_24px.png");
        this.btnIcon = new JButton(icon);
        
        this.getContentPane().setLayout(new FlowLayout());
        
        this.getContentPane().add(this.btnText);
        this.getContentPane().add(this.btnIcon);
        
        DemoJButton that = this;
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(that, "Meow", "Click", JOptionPane.PLAIN_MESSAGE, icon);
            }
        };
        
        this.btnIcon.addActionListener(listener);
    }
    
    public static void main(String[] args) {
        DemoJButton gui = new DemoJButton();
        
        gui.setSize(500, 500);
        gui.setVisible(true);
    }
}
