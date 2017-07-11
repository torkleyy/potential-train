package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.HighscoreEntry;
import observe.HighscoreObserver;
import controller.HighscoreController;

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
        JOptionPane.showMessageDialog(this, "Es ist ein Fehler aufgetreten:\n" +
                message + "\n\nDas Programm muss beendet werden.");
        System.exit(-1);
    }

    @Override
    public void onRetrieveScores(HighscoreEntry[] entries) {

    }

    @Override
    public void onReceiveMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * Create the frame.
     */
    public HighscoreView() {
        controller = new HighscoreController(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

    }
}
