package view;

import controller.GameController;
import observe.GameObserver;
import question.Answer;
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
    
    private Label lblQuestion;
    private Button answer1;
    private Button answer2;
    private Button answer3;
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

        Question q = controller.getNextQuestion();
        System.out.println("Frage: "+ q.toString());

        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image image = Toolkit.getDefaultToolkit().createImage("H:"+File.separator+"LehrerTriviaQuiz"+File.separator+"logo.jpg");
        JLabel btBild= new JLabel(new ImageIcon(image));
        btBild.setBounds(70,5,460,100);
        btBild.setText("JLabel");
        getContentPane().add(btBild);
        lblQuestion=new Label("Frage");  
        lblQuestion.setBounds(260,100,80,30);// setting button position 
        lblQuestion.setBackground(Color.YELLOW);
        getContentPane().add(lblQuestion);//adding button into frame  
        answer1 =new Button("Antwort 1");  
        answer1.setBounds(200,150,200,50);// setting button position  
        getContentPane().add(answer1);//adding button into frame  
        answer2=new Button("Antwort 2");  
        answer2.setBounds(200,210,200,50);// setting button position  
        getContentPane().add(answer2);//adding button into frame  
        answer3=new Button("Antwort 3");  
        answer3.setBounds(200,270,200,50);// setting button position  
        getContentPane().add(answer3);//adding button into frame  
        Button z=new Button("Zur�ck");
        z.setBounds(10,320,80,25);// setting button position  
        getContentPane().add(z);//adding button into frame  
        setSize(600,400);//frame size 300 width and 300 height
        setLayout(null);//no layout manager  
        setVisible(true);//now frame will be visible, by default not visible
        getContentPane().setLayout(null);//no layout manager  
        setVisible(true);//now frame will be visible, by default not visible
        
        loadQuestion(q);
    }
    
    private void loadQuestion(Question q) {
        lblQuestion.setText(q.getQuestion());
        Answer[] answers = q.getAnswers();
        answer1.setLabel(answers[0].toString());
        answer1.setLabel(answers[1].toString());
        answer1.setLabel(answers[2].toString());
    }

}
