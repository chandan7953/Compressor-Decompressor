import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton deCompressButton;

    public AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 500);
        this.setLocation(400,150);
        Color color = Color.decode("#3AA6B9");
        this.getContentPane().setBackground(color);
        this.setLayout(null); // Set layout to null for custom button positioning

        Color buttonColor = Color.decode("#FFD0D0");

        compressButton = new JButton("Select here for Compression");
        compressButton.setLocation(350, 160);
        compressButton.setSize(300, 50);
        compressButton.addActionListener(this);
        compressButton.setBackground(buttonColor);
        this.add(compressButton);

        deCompressButton = new JButton("Select here for DeCompression");
        deCompressButton.setLocation(350, 250);
        deCompressButton.setSize(300, 50);
        deCompressButton.addActionListener(this);
        deCompressButton.setBackground(buttonColor);
        this.add(deCompressButton);

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Compress.method(file);
                }catch (Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
        if(e.getSource()==deCompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    DeCompress.method(file);
                }catch (Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
    }
}
