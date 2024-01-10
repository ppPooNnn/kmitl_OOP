import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class game 
{
    JFrame f;
    JButton btnNext;
    JLabel lbScore;
    JTextField tfScore;
    JButton leftTile;
    JButton rightTile;
    JButton btnNew;
    //second phase
    Icon blue300, orange300, wrong300, kitty300;
    //second phase

    // dummy
    boolean isLeftOpen = false, isRightOpen = false;
    // dummy

    boolean hasPlayed = false;

    int turnValue;

    game()
    {
        f = new JFrame();
        f.setSize(430, 500);

        detailComponents();

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void detailComponents()
    {
        btnNext = new JButton("next guess");
        lbScore = new JLabel("Score");
        tfScore = new JTextField("0");
        leftTile = new JButton("blue");
        rightTile = new JButton("red");
        btnNew = new JButton("new game");
        
        btnNext.setPreferredSize(new Dimension(100, 50));
        lbScore.setPreferredSize(new Dimension(50, 50));
        tfScore.setPreferredSize(new Dimension(50, 50));
        leftTile.setPreferredSize(new Dimension(200, 300));
        rightTile.setPreferredSize(new Dimension(200, 300));
        btnNew.setPreferredSize(new Dimension(200, 50));
        
        f.setLayout(new FlowLayout());
        
        f.add(btnNext); f.add(lbScore); f.add(tfScore);
        f.add(leftTile); f.add(rightTile); f.add(btnNew);

        second_phase();

        thirdPhase();
    }

    void second_phase()
    {
        try
        {
            blue300 = new ImageIcon("img/blue300.png");
            orange300 = new ImageIcon("img/orange300.png");
            wrong300 = new ImageIcon("img/wrong300.png");
            kitty300 = new ImageIcon("img/kitty300.png");
        }
        catch (Exception e)
        {
            System.err.println(e);;
        }
        leftTile.setIcon(blue300);
        rightTile.setIcon(orange300);
    }

    void thirdPhase()
    {
        MyActionListener listener = new MyActionListener();
        leftTile.addActionListener(listener);
        rightTile.addActionListener(listener);
        btnNext.addActionListener(listener);
        genAns();
        btnNew.addActionListener(listener);
    }

    private void genAns()
    {
        turnValue = Math.random() > 0.49 ? 1 : 0;
    }

    private class MyActionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton)e.getSource();

            if(source == leftTile && !hasPlayed)
            {
                if(turnValue == 0)
                {
                    leftTile.setIcon(kitty300);
                    int score = Integer.parseInt(tfScore.getText()) + 1;
                    tfScore.setText("" + score);
                }
                else
                    leftTile.setIcon(wrong300);
                hasPlayed = true;
            }
            else if(source == rightTile && !hasPlayed)
            {
                if(turnValue == 0)
                {
                    rightTile.setIcon(kitty300);
                    int score = Integer.parseInt(tfScore.getText()) + 1;
                    tfScore.setText("" + score);
                }
                else
                    rightTile.setIcon(wrong300);
                hasPlayed = true;
            }
            else if(source == btnNext)
            {
                rightTile.setIcon(orange300);
                leftTile.setIcon(blue300);
                hasPlayed = false;
                genAns();
            }
            else if(source == btnNew)
            {
                rightTile.setIcon(orange300);
                leftTile.setIcon(blue300);
                tfScore.setText("0");
                hasPlayed = false;
                genAns();
            }

            // if (source == leftTile)
            // {
            //     if(isLeftOpen)
            //     {
            //         leftTile.setIcon(blue300);
            //         isLeftOpen = !isLeftOpen;
            //     }
            //     else
            //     {
            //         leftTile.setIcon(kitty300);
            //         isLeftOpen = !isLeftOpen;
            //     }
            // }
            // else if (source == rightTile)
            // {
            //     if(isRightOpen)
            //     {
            //         rightTile.setIcon(orange300);
            //         isRightOpen = !isRightOpen;
            //     }
            //     else
            //     {
            //         rightTile.setIcon(wrong300);
            //         isRightOpen = !isRightOpen;
            //     }
            // }
        }
        
    }

    public static void main(String[] args) 
    {
        game game = new game();
    }
}
