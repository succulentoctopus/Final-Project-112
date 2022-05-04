import java.awt.Color;
import java.awt.Container;
import javax.swing.*;

public class DisplayPicture {
    JFrame window;
    Container con;
    JPanel picturePanel;
    JLabel pictureLabel;
    ImageIcon image;

    public DisplayPicture() {
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();

        picturePanel = new JPanel();
        picturePanel.setBounds(150,100,600,500);
        picturePanel.setBackground(Color.black);
        con.add(picturePanel);

        pictureLabel = new JLabel();

        image = new ImageIcon("unnamed.png");
        pictureLabel.setIcon(image);
        picturePanel.add(pictureLabel);

        window.setVisible(true);

    }

}
