import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Ethan on 10/16/2017.
 */
public class WordCounter {
    private static int x,y, count;
    JTextField wordCount = new JTextField();
    JFrame window = new JFrame();
    JTextArea textField = new JTextArea(4,4);
    JScrollPane scroll = new JScrollPane(textField);
    Font f = new Font("serif", Font.PLAIN, 50);

    public WordCounter() {
        //find screen resolution for scaling
        x = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        y = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();

        //sets preferences
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        textField.setPreferredSize(new Dimension(x/3,y/3));
        textField.setLineWrap(true);
        wordCount.setSize(new Dimension(x/6,y/2));
        wordCount.setBackground(Color.RED);
        wordCount.setText("Input contains 0 words");
        wordCount.setFont(f);
        textField.setFont(f);

        //builds gui
        window.add(wordCount, BorderLayout.NORTH);
        window.add(textField, BorderLayout.SOUTH);
        window.add(scroll, BorderLayout.EAST);

        //finishes window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.pack();

        //detect when a key is pressed to find entered words
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

    public static void main(String[] args) {
        WordCounter wc = new WordCounter();
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
}
