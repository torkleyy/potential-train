package view;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import observe.PreferencesObserver;
import potentialtrain.Main;
import controller.PreferencesController;

public class PreferencesView extends JFrame implements PreferencesObserver {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final PreferencesController controller;

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
        controller = new PreferencesController(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        Image image = Toolkit.getDefaultToolkit().createImage(Main.LOGO_PATH);
        JLabel btBild = new JLabel(new ImageIcon(image));
        btBild.setBounds(70, 10, 460, 100);
        btBild.setText("JLabel");
        add(btBild);
        Label o = new Label("Optionen");
        o.setBounds(260, 100, 80, 30);// setting button position
        add(o);//adding button into frame
        Label l = new Label("Musik");
        l.setBounds(250, 150, 80, 30);// setting button position
        add(l);//adding button into frame  
        Label a = new Label("Sound");
        a.setBounds(250, 200, 80, 30);// setting button position
        add(a);//adding button into frame  
        Button b = new Button("Credits");
        b.setBounds(260, 250, 80, 30);// setting button position
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreditsView credits = new CreditsView();
                credits.setVisible(true);
                PreferencesView.this.setVisible(false);
                PreferencesView.this.dispose();
            }
        });
        add(b);//adding button into frame  
        Button z = new Button("Zur\u00fcck");
        z.setBounds(10, 320, 80, 25);// setting button position
        z.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainView main = new MainView();
                main.setVisible(true);
                PreferencesView.this.setVisible(false);
                PreferencesView.this.dispose();
            }
        });
        add(z);//adding button into frame  
        final Checkbox m = new Checkbox();
        m.setBounds(330, 140, 50, 50);
        m.setState(controller.isMusicEnabled());
        m.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                controller.setMusicEnabled(m.getState());
            }
        });
        add(m);
        final Checkbox s = new Checkbox();
        s.setBounds(330, 190, 50, 50);
        s.setState(controller.isSoundsEnabled());
        s.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                controller.setSoundsEnabled(s.getState());
            }
        });
        add(s);
        setSize(600, 400);//frame size 300 width and 300 height
        setLayout(null);//no layout manager  
        setVisible(true);//now frame will be visible, by default not visible  
    }

    @Override
    public void onError(String message) {
        JOptionPane.showMessageDialog(this, "Es ist ein Fehler aufgetreten:\n" +
                message + "\n\nDas Programm muss beendet werden.");
        System.exit(-1);
    }
}
