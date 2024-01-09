import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.event.*;

public class lec6 /*implements ActionListener*/{
    JFrame f;
    JButton btn;
    JTextField tf;
    lec6 (){
        f = new JFrame("App title");
        tf = new JTextField("fullname");
        btn = new JButton("click me");

        tf.setBounds(50,50,150,20);
        btn.setBounds(50,100,80,30);

        MyActionListener listener = new MyActionListener();
        btn.addActionListener(listener); // or btn.addActionListener(this); if you not create private class to implements Actionlistener

        f.add(tf);
        f.add(btn);

        f.setSize(400,400);

        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        // demoOptionPane();
        lec6 app = new lec6();
    }


    static void demoOptionPane()
    {
        String name = JOptionPane.showInputDialog("what is your name ");
        JOptionPane.showMessageDialog(null, "hello " + name);
    }

    // @Override
    // public void actionPerformed(ActionEvent e) {  // use this when parents class use implements to Actionlistener
    //     tf.setText("from action performed");
        
    // }

    private class MyActionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            tf.setText("from private class Listner");
        }
        
    }
}
