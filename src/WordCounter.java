import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
/**
 * Created by Ethan on 10/16/2017.
 */

//goal is to have it count live, without hitting the count button :)
    // use an action listiner on the text field
public class WordCounter {
    private static int x,y, count;
    JTextField wordCount = new JTextField();

    public WordCounter() {
        x = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        y = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();

        JFrame window = new JFrame();
        JPanel panel = new JPanel();
        JTextArea textField = new JTextArea();

        textField.setPreferredSize(new Dimension(x/3,y/3));
        wordCount.setSize(new Dimension(x/6,y/2));
        panel.setBackground(Color.GREEN);
        wordCount.setBackground(Color.RED);
        wordCount.setText("Input contains 0 words");
        Font f = new Font("serif", Font.PLAIN, 50);
        wordCount.setFont(f);
        textField.setFont(f);

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        textField.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(200,200,200,200)));

        window.add(panel);
        window.add(wordCount, BorderLayout.NORTH);
        window.add(textField, BorderLayout.SOUTH);



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
