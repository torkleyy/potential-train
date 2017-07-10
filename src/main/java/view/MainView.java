package view;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainView extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private final MainView view = this;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainView frame = new MainView();
                  
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
    public MainView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        Image image = Toolkit.getDefaultToolkit().createImage("H:"+File.separator+"LehrerTriviaQuiz"+File.separator+"logo.jpg");
        JLabel btBild= new JLabel(new ImageIcon(image));
        btBild.setBounds(70,50,460,100);
        btBild.setText("JLabel");
        add(btBild);
        Button b=new Button("Start");  
        b.setBounds(260,200,80,30);// setting button position
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameView game = new GameView();
                game.setVisible(true);
                view.setVisible(false);
                view.dispose();
            }
        });
        add(b);//adding button into frame  
        Button a=new Button("Optionen");  
        a.setBounds(273,250,55,25);// setting button position
        a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreferencesView prefs = new PreferencesView();
                prefs.setVisible(true);
                view.setVisible(false);
                view.dispose();
            }
        });
        add(a);//adding button into frame  
        setSize(600,400);//frame size 300 width and 300 height  
        setLayout(null);//no layout manager  
        setVisible(true);//now frame will be visible, by default not visible
    }

}
