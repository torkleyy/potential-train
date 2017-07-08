package view;

import controller.HighscoreController;
import model.HighscoreEntry;
import observe.HighscoreObserver;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class HighscoreView extends JFrame implements HighscoreObserver {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private final HighscoreController controller;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HighscoreView frame = new HighscoreView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onRetrieveScores(HighscoreEntry[] entries) {

    }

    @Override
    public void onReceiveMessage(String message) {

    }
    /**
     * Create the frame.
     */
    public HighscoreView() {
        controller = new HighscoreController();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        
    }
}
