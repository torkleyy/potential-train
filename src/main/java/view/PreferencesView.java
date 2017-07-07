package view;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PreferencesView extends JFrame {

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
                    PreferencesView frame = new PreferencesView();
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
    public PreferencesView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        
        Image image = Toolkit.getDefaultToolkit().createImage("H:"+File.separator+"LehrerTriviaQuiz"+File.separator+"logo.jpg");
        JLabel btBild= new JLabel(new ImageIcon(image));
        btBild.setBounds(70,10,460,100);
        btBild.setText("JLabel");
        add(btBild);
        Label o=new Label("Optionen");  
        o.setBounds(260,100,80,30);// setting button position  
        add(o);//adding button into frame
        Label l=new Label("Musik");  
        l.setBounds(250,150,80,30);// setting button position  
        add(l);//adding button into frame  
        Label a=new Label("Sound");  
        a.setBounds(250,200,80,30);// setting button position  
        add(a);//adding button into frame  
        Button b=new Button("Credits");  
        b.setBounds(260,250,80,30);// setting button position  
        add(b);//adding button into frame  
        Button z=new Button("Zurück");  
        z.setBounds(10,320,80,25);// setting button position  
        add(z);//adding button into frame  
        Checkbox m = new Checkbox(); 
        m.setBounds(330,140,50,50);
        add(m);
        Checkbox s = new Checkbox(); 
        s.setBounds(330,190,50,50);
        add(s);
        setSize(600,400);//frame size 300 width and 300 height  
        setLayout(null);//no layout manager  
        setVisible(true);//now frame will be visible, by default not visible  
    }

}
