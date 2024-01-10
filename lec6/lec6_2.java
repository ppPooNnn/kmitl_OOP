import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.event.*;

public class lec6_2 {
    JFrame f;
    JButton btn;
    JTextField tf;
    lec6_2 (){
        f = new JFrame("App title");
        tf = new JTextField("fullname");
        btn = new JButton("click me");

        tf.setBounds(50,50,150,20);
        btn.setBounds(50,100,80,30);

        // MyActionListener listener = new MyActionListener();
        // ActionListener listener = new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         tf.setText("form annony");
        //     }
        // };
        // btn.addActionListener(listener); // or btn.addActionListener(this); if you not create private class to implements Actionlistener

        btn.addActionListener(ev -> tf.setText("from lambda"));

        f.add(tf);
        f.add(btn);

        f.setSize(400,400);

        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        // demoOptionPane();
        lec6_2 app = new lec6_2();
    }


    static void demoOptionPane()
    {
        String name = JOptionPane.showInputDialog("what is your name ");
        JOptionPane.showMessageDialog(null, "hello " + name);
    }

    // private class MyActionListener implements ActionListener // ท่าง่ายคือประกาศเป็น inner class เพราะถ้าแยกต้องส่ง parameter วุ่นวายเยอะแยะ
    // {

    //     @Override
    //     public void actionPerformed(ActionEvent e) {
    //         tf.setText("form lec6_2");
    //     }
        
    // }
}
