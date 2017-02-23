package menùristorante;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.Dimension;

/**
 *
 * @author LucaSosti
 */
public class Menu extends JFrame implements ActionListener {

    JFrame frame1 = new JFrame("Scegli Piatti");
    JPanel p = new JPanel();
    JLabel label = new JLabel();
    JButton esci = new JButton("Uscita");

    //costruttore
    public Menu() {

        JMenuBar menubar = new JMenuBar();

        p.add(label);
        add(p);

        JMenu m1 = new JMenu("Primo");
        JMenu m2 = new JMenu("Secondo");
        JMenu m3 = new JMenu("Dolci");

        menubar.add(m1);
        menubar.add(m2);
        menubar.add(m3);

        JMenuItem i1 = new JMenuItem("Penne Alla Norcina", new ImageIcon(((new ImageIcon("Norcina.jpg").getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH))));
        JMenuItem i2 = new JMenuItem("Penne All'Arrabbiata", new ImageIcon(((new ImageIcon("Arrabbiata.jpg").getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH))));;
        JMenuItem i3 = new JMenuItem("Bistecca con contorno di patatine fritte",new ImageIcon((((new ImageIcon("Bistecca.jpg").getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)))));
        JMenuItem i4 = new JMenuItem("Pesce", new ImageIcon((((new ImageIcon("Pesce.png").getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)))));
        JMenuItem i5 = new JMenuItem("Tiramisu",new ImageIcon((((new ImageIcon("Tiramisu.jpg").getImage()).getScaledInstance(30, 30,java.awt.Image.SCALE_SMOOTH)))));
        p.add(menubar);
        add(p);

        m1.add(i1);
        m1.add(i2);
        m2.add(i3);
        m2.add(i4);
        m3.add(i5);

        menubar.add(esci);

        //stringa per evento di uscita
        esci.setActionCommand("Uscita");

        i1.setActionCommand("Penne Alla Norcina");
        i1.addActionListener(this);

        i2.setActionCommand("Penne All'Arrabbiata");
        i2.addActionListener(this);

        i3.setActionCommand("Bistecca con contorno di patatine fritte");
        i3.addActionListener(this);

        i4.setActionCommand("Pesce");
        i4.addActionListener(this);

        i5.setActionCommand("Tiramisu");
        i5.addActionListener(this);

        esci.setActionCommand("Uscita");
        esci.addActionListener(this);

        frame1.setVisible(true);
        frame1.setSize(500, 500);
        frame1.setJMenuBar(menubar);
        frame1.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if ("Penne Alla Norcina".equals(ae.getActionCommand())) {
            System.out.println("Penna Alla Norcina");
            label.setIcon(new ImageIcon("Norcina.jpg"));
            label.setVisible(false);
            label.setVisible(true);

        }

        if ("Penne All'Arrabbiata".equals(ae.getActionCommand())) {
            System.out.println("Penne All'Arrabbiata");
            label.setIcon(new ImageIcon("Arrabbiata.jpg"));
            label.setVisible(false);
            label.setVisible(true);
        }

        if ("Bistecca con contorno di patatine fritte".equals(ae.getActionCommand())) {
            System.out.println("Bistecca con contorno di patatine fritte");
            label.setIcon(new ImageIcon("Bistecca.jpg"));
            label.setVisible(false);
            label.setVisible(true);

        }
        if ("Pesce".equals(ae.getActionCommand())) {
            System.out.println("Pesce");
            label.setIcon(new ImageIcon("Pesce.png"));
            label.setVisible(false);
            label.setVisible(true);
        }

        if ("Tiramisu".equals(ae.getActionCommand())) {
            System.out.println("Tiramisu");
            label.setIcon(new ImageIcon("Tiramisu.jpg"));
            label.setVisible(false);
            label.setVisible(true);
        }

        if ("Uscita".equals(ae.getActionCommand())) {

            int n = JOptionPane.showConfirmDialog(null, "Confermi la tua ordinazione?",
                    "Uscita Dal Menù", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                //System.exit(0);
                String prova = (String) JOptionPane.showInputDialog(null, "Seleziona il Tavolo:", "Inviare alla Cucina?", JOptionPane.INFORMATION_MESSAGE, null, null, "Tav_01");
                System.out.println("Selezionato:" + prova);
                JOptionPane.showMessageDialog(null, "Ordinazione Confermata", "Finestra di Conferma", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

        }
    }
}
