/**
 * This program is a decision tree to make decision whether to live in college or not.
 *
 * @author (Faiz Ikhwan & Hidayat)
 * @version (09 November 2017)
 */
import java.awt.*;
import java.util.*;
import javax.swing.*;
public class College
{
   public static void main(String args[])
   {
      String name=null, transport=null, budget=null, curfew=null, activity=null; //Declare name variables
      double numTransport = 0.0, numBudget = 0.0, numCurfew = 0.0, numActivity = 0.0, result = 0.0; //Declare calculation variables
      int replyTransport = 5, replyBudget = 5, replyCurfew = 5, replyActivity = 5, replyResult = 5; //Declare temp values for dialog replies
      String[] questionButton = { "Yes", "No", "Help" }; //Declare texts of buttons to use on each question
      String[] homeButton = { "About", "Continue", "Cancel" }; //Declare texts of buttons to use on homepage
      
      ImageIcon iconWelcome = new ImageIcon(College.class.getResource("/resource/welcome.jpg"));
      ImageIcon iconTransport = new ImageIcon(College.class.getResource("/resource/transport3.jpg"));
      ImageIcon iconBudget = new ImageIcon(College.class.getResource("/resource/budget3.jpg"));
      ImageIcon iconCurfew = new ImageIcon(College.class.getResource("/resource/curfew.jpg"));
      ImageIcon iconActivity = new ImageIcon(College.class.getResource("/resource/activity3.jpg"));
      ImageIcon iconProgrammer = new ImageIcon(College.class.getResource("/resource/programmers.jpg"));
      
      JPanel panTemp = new JPanel(); //Only for homepage - declare panel
      panTemp.setLayout(new BoxLayout(panTemp, BoxLayout.Y_AXIS)); //Set panel to use box positioning
      panTemp.add(new JLabel("<html><img src=\"" + iconWelcome + "\"><br/><br/><br/>" +"Welcome! Hello, what is your name?<br/></html>")); //Text on homepage
      JTextField tempInput = new JTextField(10); //Make input text field
      panTemp.add(tempInput); //Add input text field into panel
      
      while(name==null)
      {
         int optResult = JOptionPane.showOptionDialog(null, panTemp, "Stay in college or stay outside?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, homeButton, null);
         if (optResult == JOptionPane.YES_OPTION) //YES_OPTION corresponds to "About" button
         {
            JOptionPane.showMessageDialog(null, "<html><b>Stay in college or stay outside?</b><br/><i>version 171109</i><br/><br/>Written by:<br/><img src=\"" + iconProgrammer + "\"><br/>1. Muhammad Nur Hidayat<br/>2. Faiz Ikhwan<br/></html>", "About us", JOptionPane.PLAIN_MESSAGE);//About us
         }else if (optResult == JOptionPane.NO_OPTION) //NO_OPTION corresponds to "Continue" button
         {
            name = tempInput.getText();
            if (name.isEmpty())
            {
               JOptionPane.showMessageDialog(null, "You did not write your name!", "Empty name!", JOptionPane.ERROR_MESSAGE);
               name = null;
            }
         }else if (optResult == JOptionPane.CANCEL_OPTION) //CANCEL_OPTION corresponds to "Cancel" button
         {
            int sureCancel = JOptionPane.showConfirmDialog(null, "Do you really want to cancel and exit?", "Confirm exit?", JOptionPane.YES_NO_OPTION);
            if (sureCancel == JOptionPane.YES_OPTION)
            { System.exit(0); }
         }
      }
      
      while(replyTransport==5)  // transport pane                                                                                                                                                                                                                                                                                                                        
      {
         replyTransport = JOptionPane.showOptionDialog(null, "<html><img src=\"" + iconTransport + "\"><br/><br/>"+name+", do you have your own transport?<br/></html>", "Stay in college or stay outside?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, questionButton, null);
         if (replyTransport == JOptionPane.YES_OPTION)
         {
            numTransport = -0.7;
            transport = "Yes";
         } else if(replyTransport == JOptionPane.NO_OPTION)
         {
            numTransport = 0.7;
            transport = "No";
         } else
         {
            JOptionPane.showMessageDialog(null, "<html>Do you have any bike, car or access to public transport services?<br/>You'll be better to stay in college if you don't have transport,<br/>but it would not be too matter if you have transport.</html>", "Help", JOptionPane.PLAIN_MESSAGE);//Help - Transport
            replyTransport=5;
         }
      }
      
      while(replyBudget==5) //   budget pane                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
      {
         replyBudget = JOptionPane.showOptionDialog(null, "<html><img src=\"" + iconBudget + "\"><br/><br/>"+name+", do you have any extra money to stay outside?<br/></html>", "Stay in college or stay outside?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, questionButton, null);
         if (replyBudget == JOptionPane.YES_OPTION)
         {
            numBudget = -0.6;
            budget = "Yes";
         } else if(replyBudget == JOptionPane.NO_OPTION)
         {
            numBudget = 0.6;
            budget = "No";
         } else
         {
            JOptionPane.showMessageDialog(null, "<html>You will need at least RM700 per month to survive outside.<br/>You'll be better to stay in college if you don't have extra money,<br/>but it would not be too matter if you have extra money.</html>", "Help", JOptionPane.PLAIN_MESSAGE);//Help - Budget
            replyBudget=5;
         }
      }

      while(replyCurfew==5) //   curfew pane                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
      {
         replyCurfew = JOptionPane.showOptionDialog(null, "<html><img src=\"" + iconCurfew + "\"><br/><br/>"+name+", are you okay with college curfew?<br/></html>", "Stay in college or stay outside?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, questionButton, null);
         if (replyCurfew == JOptionPane.YES_OPTION)
         {
            numCurfew = 0.3;
            curfew = "Yes";
         } else if(replyCurfew == JOptionPane.NO_OPTION)
         {
            numCurfew = -0.3;
            curfew = "No";
         } else
         {
            JOptionPane.showMessageDialog(null, "<html>Curfew is a regulation requiring people to remain indoors typically at night.<br/>You'll be better to stay outside if you don't like college curfew,<br/>otherwise, stay in college.</html>", "Help", JOptionPane.PLAIN_MESSAGE);//Help - Curfew
            replyCurfew=5;
         }
      }

       while(replyActivity==5) //   activity pane                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
      {
         replyActivity = JOptionPane.showOptionDialog(null, "<html><img src=\"" + iconActivity + "\"><br/><br/>"+name+", do you like to join college activities?<br/></html>", "Stay in college or stay outside?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, questionButton, null);
         if (replyActivity == JOptionPane.YES_OPTION)
         {
            numActivity = 0.4;
            activity = "Yes";
         } else if(replyActivity == JOptionPane.NO_OPTION)
         {
            numActivity = -0.4;
            activity = "No";
         } else
         {
            JOptionPane.showMessageDialog(null, "<html>College activities provides coupon that needs to be collected in order to stay in college.<br/>You'll be better to stay outside if you don't like to join college activities,<br/>otherwise, stay in college.</html>", "Help", JOptionPane.PLAIN_MESSAGE);//Help - Activity
            replyActivity=5;
         }
      }   

      result = numTransport + numBudget + numCurfew + numActivity; // calculation for sum
      
      if (result < -0.5)
            {JOptionPane.showMessageDialog(null, "Transportation answer:  " + transport + "\nBudget answer:                 " + budget + "\nCurfew answer:                 " + curfew + "\nActivity answer:                 " + activity + "\nSuggestion:                         Definitely stay outside", "Result", JOptionPane.PLAIN_MESSAGE); }
      else if (result >= -0.5 && result < 0)
            {JOptionPane.showMessageDialog(null, "Transportation answer:  " + transport + "\nBudget answer:                 " + budget + "\nCurfew answer:                 " + curfew + "\nActivity answer:                 " + activity + "\nSuggestion:                         Maybe stay outside", "Result", JOptionPane.PLAIN_MESSAGE);}
      else if (result >= 0 && result < 0.5)  
            {JOptionPane.showMessageDialog(null, "Transportation answer:  " + transport + "\nBudget answer:                 " + budget + "\nCurfew answer:                 " + curfew + "\nActivity answer:                 " + activity + "\nSuggestion:                         Maybe stay college", "Result", JOptionPane.PLAIN_MESSAGE);}
      else if (result >= 0.5)
            {JOptionPane.showMessageDialog(null, "Transportation answer:  " + transport + "\nBudget answer:                 " + budget + "\nCurfew answer:                 " + curfew + "\nActivity answer:                 " + activity + "\nSuggestion:                         Definitely stay college", "Result", JOptionPane.PLAIN_MESSAGE);}
   }
}