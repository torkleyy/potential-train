package view;

import controller.GameController;
import observe.GameObserver;
import potentialtrain.Main;
import question.Answer;
import question.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GameView extends JFrame implements GameObserver {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final GameController controller;

    private JLabel lblScore;
    private JLabel lblQuestion;
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


    /**
     * Create the frame.
     */
    public GameView() {
        controller = new GameController(this);

        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image image = Toolkit.getDefaultToolkit().createImage(Main.LOGO_PATH);
        JLabel btBild = new JLabel(new ImageIcon(image));
        btBild.setBounds(70, 5, 460, 100);
        btBild.setText("JLabel");
        getContentPane().add(btBild);
        lblScore = new JLabel();
        lblScore.setBounds(460, 240, 300, 10);
        lblScore.setText("Punkte: 0");
        getContentPane().add(lblScore);
        lblQuestion = new JLabel("Frage", JLabel.CENTER);
        lblQuestion.setBounds(0, 100, 600, 30);// setting button position
        lblQuestion.setBackground(Color.YELLOW);
        getContentPane().add(lblQuestion);//adding button into frame  
        answer1 = new Button("Antwort 1");
        answer1.setBounds(200, 150, 200, 50);// setting button position
        answer1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.registerAnswer(0);
            }
        });
        getContentPane().add(answer1);//adding button into frame  
        answer2 = new Button("Antwort 2");
        answer2.setBounds(200, 210, 200, 50);// setting button position
        answer2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.registerAnswer(1);
            }
        });
        getContentPane().add(answer2);//adding button into frame  
        answer3 = new Button("Antwort 3");
        answer3.setBounds(200, 270, 200, 50);// setting button position
        answer3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.registerAnswer(2);
            }
        });
        getContentPane().add(answer3);//adding button into frame
        Button z = new Button("Zurueck");
        z.setBounds(10, 320, 80, 25);// setting button position
        z.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainView main = new MainView();
                main.setVisible(true);
                GameView.this.setVisible(false);
                GameView.this.dispose();
            }
        });
        getContentPane().add(z);//adding button into frame  
        setSize(600, 400);//frame size 300 width and 300 height
        setLayout(null);//no layout manager
        getContentPane().setLayout(null);//no layout manager
        setVisible(true);//now frame will be visible, by default not visible

        controller.requestQuestion();
    }

    private void loadQuestion(Question q) {
        lblQuestion.setText(q.getQuestion());
        Answer[] answers = q.getAnswers();
        answer1.setLabel(answers[0].toString());
        answer2.setLabel(answers[1].toString());
        answer3.setLabel(answers[2].toString());
    }

    @Override
    public void onError(String message) {
        JOptionPane.showMessageDialog(this, "Es ist ein Fehler aufgetreten:\n" +
                message + "\n\nDas Programm muss beendet werden.");
        System.exit(-1);
    }

    @Override
    public void onAnswerCorrect() {
        lblScore.setText("Punkte: " + controller.getScore());
    }

    @Override
    public void onAnswerWrong() {
        FailureView failure = new FailureView();
        failure.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }

    @Override
    public void onRetrieveQuestion(Question q) {
        if (q == null) {
            JOptionPane.showMessageDialog(this, "Du hast alle Fragen beantwortet!");
            System.exit(0);
        } else {
            loadQuestion(q);
        }
    }
}
