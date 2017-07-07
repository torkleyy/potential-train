package view;

import controller.GameController;
import observe.GameObserver;
import question.Question;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameView extends JFrame implements GameObserver {

    private final GameController controller;
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
                    GameView frame = new GameView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onRetrieveQuestion(Question q) {

    }

    @Override
    public void onAnswerCorrect() {

    }

    @Override
    public void onAnswerWrong() {
        
    }

    @Override
    public void onError(String message) {

    }

    /**
     * Create the frame.
     */
    public GameView() {
        controller = new GameController();

        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image image = Toolkit.getDefaultToolkit().createImage("H:"+File.separator+"LehrerTriviaQuiz"+File.separator+"logo.jpg");
        JLabel btBild= new JLabel(new ImageIcon(image));
        btBild.setBounds(70,5,460,100);
        btBild.setText("JLabel");
        add(btBild);
        Label l=new Label("Frage");  
        l.setBounds(260,100,80,30);// setting button position 
        l.setBackground(Color.YELLOW);
        add(l);//adding button into frame  
        Button b=new Button("Antwort 1");  
        b.setBounds(200,150,200,50);// setting button position  
        add(b);//adding button into frame  
        Button c=new Button("Antwort 2");  
        c.setBounds(200,210,200,50);// setting button position  
        add(c);//adding button into frame  
        Button d=new Button("Antwort 3");  
        d.setBounds(200,270,200,50);// setting button position  
        add(d);//adding button into frame  
        Button z=new Button("Zur�ck");  
        z.setBounds(10,320,80,25);// setting button position  
        add(z);//adding button into frame  
        setSize(600,400);//frame size 300 width and 300 height  
        setLayout(null);//no layout manager  
        setVisible(true);//now frame will be visible, by default not visible
    }

}
