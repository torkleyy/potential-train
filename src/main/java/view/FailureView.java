package view;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
        Image image = Toolkit.getDefaultToolkit().createImage("H:"+File.separator+"LehrerTriviaQuiz"+File.separator+"logo.jpg");
        JLabel btBild= new JLabel(new ImageIcon(image));
        btBild.setBounds(70,5,460,100);
        btBild.setText("JLabel");
        add(btBild);
        Label l =new Label("Das war falsch, du Noob!");
        l.setBounds(225,100,200,30);
        add(l);
        Button z=new Button("Zur\u00fcck");
        z.setBounds(10,320,80,25);// setting button position  
        add(z);//adding button into frame  
        setSize(600,400);//frame size 300 width and 300 height  
        setLayout(null);//no layout manager   
        setVisible(true);//now frame will be visible, by default not visible  
    }

}
