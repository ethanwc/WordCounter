import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * Created by Ethan on 10/16/2017.
 */
//scrollbar isn't appearing

public class WordCounter {
    private static int x,y, count;
    JScrollPane scroll = new JScrollPane();
    JTextField wordCount = new JTextField();
    JFrame window = new JFrame();
    JPanel panel = new JPanel();
    JTextArea textField = new JTextArea(4,4);
    Font f = new Font("serif", Font.PLAIN, 50);

    public WordCounter() {
        x = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        y = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();

        textField.setPreferredSize(new Dimension(x/3,y/3));
        textField.setLineWrap(true);

        wordCount.setSize(new Dimension(x/6,y/2));
        wordCount.setBackground(Color.RED);
        wordCount.setText("Input contains 0 words");
        wordCount.setFont(f);
        textField.setFont(f);


        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        window.add(panel);
        window.add(wordCount, BorderLayout.NORTH);
        window.add(textField, BorderLayout.SOUTH);
        textField.add(scroll);


        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.pack();

        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                updateCount(textField.getText());
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void updateCount(String input) {
        count = 0;
        if (input.equals("")) {
            wordCount.setText("Input contains 0 words");
            return;
        }
        else
            for (int i = 0; i < input.length(); i++) {
                if (input.substring(i,i+1).equals(" ")) count++;
            }
        count++;
        wordCount.setText("Input contains: " +count + " words.");
    }

    public static void main(String[] args) {
        WordCounter wc = new WordCounter();
    }
}
