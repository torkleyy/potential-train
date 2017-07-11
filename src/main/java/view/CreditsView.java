package view;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JTextPane;

public class CreditsView extends JDialog {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Create the dialog.
     */
    public CreditsView(Frame parent) {
        super (parent);
        setTitle("Credits");
        setBounds(100, 100, 450, 300);

        setModal(true);

        JTextPane txtpnLeitungUndOrganisation = new JTextPane();
        txtpnLeitungUndOrganisation.setEditable(false);
        txtpnLeitungUndOrganisation.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txtpnLeitungUndOrganisation.setText("Leitung und Organisation:\r\nSchaller Thomas\r\n\r\nProgrammierung der Logik:\r\nBudeus Markus\r\n\r\nProgrammierung der Oberfl\u00E4che:\r\nMeiburg Lara\r\nNeumair Helena\r\n\r\nDesign von Oberfl\u00E4che und Logo:\r\nEggert Melanie");
        txtpnLeitungUndOrganisation.setBounds(10, 11, 414, 239);
        getContentPane().add(txtpnLeitungUndOrganisation);
    }

}
