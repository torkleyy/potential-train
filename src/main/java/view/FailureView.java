package view;

import potentialtrain.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FailureView extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FailureView frame = new FailureView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public FailureView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        Image image = Toolkit.getDefaultToolkit().createImage(Main.LOGO_PATH);
        JLabel btBild = new JLabel(new ImageIcon(image));
        btBild.setBounds(70, 5, 460, 100);
        btBild.setText("JLabel");
        add(btBild);
        Label l = new Label("Das war falsch, du Noob!");
        l.setBounds(225, 100, 200, 30);
        add(l);
        Button z = new Button("Zur\u00fcck");
        z.setBounds(10, 320, 80, 25);// setting button position
        z.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainView main = new MainView();
                main.setVisible(true);
                FailureView.this.setVisible(false);
                FailureView.this.dispose();
            }
        });
        add(z);//adding button into frame  
        setSize(600, 400);//frame size 300 width and 300 height
        setLayout(null);//no layout manager   
        setVisible(true);//now frame will be visible, by default not visible  
    }

}
