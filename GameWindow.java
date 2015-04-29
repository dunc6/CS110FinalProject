/**
   Tyler Whitaker
   CS110
   GameWindow class creates the GUI for the game of war to be played.
*/

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame
{
   public GameWindow()
   {
      //Set background color
      getContentPane().setBackground(Color.RED);
      
      //Set title
      setTitle("War");
      
      //Set layout
      setLayout(new BorderLayout(400,200));
      
      //Set exit
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //Create panels
      JPanel north = new JPanel();
      JPanel south = new JPanel();
      JPanel east = new JPanel();
      JPanel west = new JPanel();
      JPanel center = new JPanel();
      
      //Create the titel label
      JLabel title = new JLabel("War");
      title.setFont(new Font("Serif", Font.BOLD, 50));
      north.setBackground(Color.GRAY);
      
      //Names
      JTextField player1 = new JTextField("Player One", 10);
      JTextField player2 = new JTextField("Player Two", 10);
      
      //Flip button 
      JButton flip = new JButton("Flip");
      flip.addActionListener(new FlipButtonListener());
      
      //War button created
      JButton war = new JButton("War!");
      war.setBackground(Color.RED);
      war.addActionListener(new WarButtonListener());
      
      //Display each players points
      JLabel points1 = new JLabel("Player One Points: ");
      points1.setFont(new Font("Serif", Font.BOLD, 20));
      
      
      //Display each players points
      JLabel points2 = new JLabel("Player One Points: ");
      points2.setFont(new Font("Serif", Font.BOLD, 20));
      
      
      //Button for the exit and display winner
      JButton end = new JButton("End game");      //Image for player 1 deck in West
      ImageIcon backW = new ImageIcon("back.jpg");
      JLabel backWest = new JLabel(backW);
      
      //Image for player 2 deck in East
      ImageIcon backE = new ImageIcon("back.jpg");
      JLabel backEast = new JLabel(backE);
      
      // End game
      end.addActionListener(new EndButtonListener());
      
      
      //Create north panel 
      north.add(player1);
      north.add(title);
      north.add(player2);
      
      //Create south panel
      south.add(points1);
      south.add(end);
      south.add(points2);
      
      //Create west panel
      west.add(backWest);
      
      //Create east panel
      east.add(backEast);
      
      //Create center panel
      center.add(flip);
      center.add(war);
      
      //add all panels
      add(north, BorderLayout.NORTH);
      add(south, BorderLayout.SOUTH);
      add(center, BorderLayout.CENTER);
      add(west, BorderLayout.WEST);
      add(east, BorderLayout.EAST);
      
      //pack and display the window
      pack();
      
      setVisible(true);      
            
   }
   
   /**
      FlipButtonListener class for when the flip button is clicked, implements ActionListener
   */
   class FlipButtonListener implements ActionListener
   {
      public void actionPerformed (ActionEvent e)
      {
         //Flip cards over
         ImageIcon one = new ImageIcon("10d.jpg");
         JLabel flip1 = new JLabel(one);
         
         ImageIcon two = new ImageIcon("2d.jpg");
         JLabel flip2 = new JLabel(two);
         
      }
   }
   
   private class WarButtonListener implements ActionListener
   {
      public void actionPerformed (ActionEvent e)
      {
         //When the war button is pushed four cards for each player are put down
         //The first three are face down and the last is face up.
         
         ImageIcon one = new ImageIcon("back.jpg");
         JLabel flip1 = new JLabel(one);
         
         ImageIcon two = new ImageIcon("back.jpg");
         JLabel flip2 = new JLabel(two);

         ImageIcon three = new ImageIcon("back.jpg");
         JLabel flip3 = new JLabel(three);
         
         ImageIcon four = new ImageIcon("10d.jpg");
         JLabel flip4 = new JLabel(four);
         
         ImageIcon five = new ImageIcon("back.jpg");
         JLabel flip5 = new JLabel(five);
         
         ImageIcon six = new ImageIcon("back.jpg");
         JLabel flip6 = new JLabel(six);

         ImageIcon seven = new ImageIcon("back.jpg");
         JLabel flip7 = new JLabel(seven);
         
         ImageIcon eight = new ImageIcon("2d.jpg");
         JLabel flip8 = new JLabel(eight);
         
     }
  }
  
  private class EndButtonListener implements ActionListener
  {
     public void actionPerformed (ActionEvent e)
     {
        //Display winner
        JOptionPane.showMessageDialog(null, "The winner is: "/* Winner name*/);
        
        //north.setBackground
        System.exit(0);
     }
  }           
}
