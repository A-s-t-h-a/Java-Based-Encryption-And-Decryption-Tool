
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageOperation {

    public static void operate(int key) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        // file FileInputStream
        try {

            FileInputStream fis = new FileInputStream(file);

            byte[] data = new byte[fis.available()];
            fis.read(data);
            int i = 0;
            for (byte b : data) {
                System.out.println(b);
                data[i] = (byte) (b ^ key);
                i++;
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("this is testing");

        JFrame f = new JFrame();
        f.setTitle("Image and text file Operation");
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = f.getContentPane();
        c.setLayout(null);
        Font font = new Font("Tahoma", Font.PLAIN, 20);

        JLabel label = new JLabel("For Image File");
        label.setBounds(140, 20, 155, 35);
        label.setFont(font);
        JLabel label1 = new JLabel("For Text File");
        label1.setBounds(140, 160, 155, 35);
        label1.setFont(font);
        JButton button = new JButton();
        JButton button1 = new JButton();
        button.setText("Encrypt Image");
        button.setFont(font);
        button.setBounds(100, 60, 200, 30);

        var textField = new JTextField(10);
        textField.setFont(font);
        textField.setBounds(100, 270, 200, 30);
        textField.setText(null);

        var textField1 = new JTextField(10);
        textField1.setFont(font);
        textField1.setBounds(100, 300, 200, 30);
        textField1.setText(null);

        button.addActionListener(e -> {
            System.out.println("button clicked");
            String text = textField.getText();
            int temp = Integer.parseInt(text);
            operate(temp);
        });
        c.add(label);
        c.add(button);
        c.add(button1);
        c.add(label1);
        c.add(textField);
        f.setVisible(true);

    }
}