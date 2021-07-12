/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author tiennh
 */
public class DemoJDialog extends JFrame {
    private JButton btnMessage, btnConfirm, btnInput, btnFile;

    public DemoJDialog() {
        this.getContentPane().setLayout(new FlowLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.btnMessage = new JButton("Message");
        this.btnConfirm = new JButton("Confirm");
        this.btnInput = new JButton("Input");
        this.btnFile = new JButton("File");
        
        DemoJDialog that = this;
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (cmd.equals("Message")) {
                    ImageIcon icon = new ImageIcon("src/main/java/lesson2/happy.png");
                    JOptionPane.showMessageDialog(that,
                        "Message Dialog", "Title", JOptionPane.PLAIN_MESSAGE, icon);
                } else if (cmd.equals("Confirm")) {
                    JOptionPane.showConfirmDialog(that,
                        "Bạn có người yêu chưa?", "Hỏi", JOptionPane.YES_NO_OPTION);
                } else if (cmd.equals("Input")) {
                    String kq = JOptionPane.showInputDialog(that, "Nhập tên người yêu:");
                    
                    System.out.println(kq);
                } else {
                    JFileChooser fChooser = new JFileChooser();
                    int returnVal = fChooser.showOpenDialog(that);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File f = fChooser.getSelectedFile();
                        JOptionPane.showMessageDialog(that, "Tên file: " + f.getName());
                    }
                }
            }
        };
        
        this.btnMessage.addActionListener(listener);
        this.btnConfirm.addActionListener(listener);
        this.btnInput.addActionListener(listener);
        this.btnFile.addActionListener(listener);
        
        this.getContentPane().add(this.btnMessage);
        this.getContentPane().add(this.btnConfirm);
        this.getContentPane().add(this.btnInput);
        this.getContentPane().add(this.btnFile);
    }
    
    public static void main(String args[]) {
        DemoJDialog gui = new DemoJDialog();
        
        gui.setSize(500, 500);
        gui.setVisible(true);
    }
}
