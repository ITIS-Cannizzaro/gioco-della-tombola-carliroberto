import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JButton sortEcanc = new JButton("SORTEGGIA E CANCELLA");
    JTextArea nrand = new JTextArea("Il numero estratto è:");
    JTable tabellone = new JTable(9,10);
    JTextArea tab = new JTextArea("TABELLONE NUMERI TOMBOLA");
    JTextArea c1 = new JTextArea("CARTELLA NUMERO UNO");
    JTextArea c2 =new JTextArea("CARTELLA NUMERO DUE");
    JTable cartella1 = new JTable(3,9);
    JTable cartella2 = new JTable(3,9);

    public MyFrame(){
        super("TOMBOLA");
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());

        c.add(tab);
        tab.setPreferredSize(new Dimension(180, 16));
        tab.setEditable(false);

        c.add(tabellone);

        c.add(c1);
        c1.setPreferredSize(new Dimension(145, 16));
        c1.setEditable(false);
        c.add(cartella1);

        c.add(c2);
        c2.setPreferredSize(new Dimension(145, 16));
        c2.setEditable(false);
        c.add(cartella2);

        c.add(sortEcanc);
        sortEcanc.addActionListener(e->sorteggia());
        sortEcanc.setPreferredSize(new Dimension(250, 30));

        c.add(nrand);
        nrand.setPreferredSize(new Dimension(170, 16));
        nrand.setEditable(false);

        setSize(800, 500);
        setVisible(true);
        setResizable(false);
    }

    public void sorteggia(){
        boolean cond=true;
        while (cond){
            int randomNum = (int)(Math.random() * 91);
            int row = (randomNum - 1)/10;
            int col = (randomNum - 1)%10;
            Object valoreCella = tabellone.getValueAt(row, col);
            if(valoreCella == null){
                tabellone.setValueAt(randomNum, row, col);
                nrand.setText("Il numero estratto è: "+randomNum);
                cond=false;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==sortEcanc){
            sorteggia();
        }
    }
}