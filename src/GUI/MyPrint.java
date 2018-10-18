/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author abhis
 */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.Date;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
 
public class MyPrint extends JFrame {
    /**
     * The text area which is used for displaying logging information.
     */
    static private JTextArea textArea;
     
     
    private PrintStream standardOut;
    
    public MyPrint()
    {
    }
    
    public void initiate() {
        
         
        textArea = new JTextArea(50, 10);
        textArea.setEditable(false);
        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
         
        // keeps reference of standard output stream
        standardOut = System.out;
         
        // re-assigns standard output stream and error output stream
        System.setOut(printStream);
        System.setErr(printStream);
 
        // creates the GUI
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
         
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
         
        add(new JScrollPane(textArea), constraints);
         
        
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(2000,70 );
        setLocationRelativeTo(null);    // centers on screen  
    
         
       
         
        
         
        
    }
    public static void print(String x)
    {
        System.out.print(x);
    }
    public static void println(String x)
    {
        System.out.println(x);
    }
    /**
     * Prints log statements for testing in a thread
     */
    
     
    /**
     * Runs the program
     */
    public static void main(String[] args)
    {
        
        MyPrint m=new MyPrint();
        m.setVisible(true);
        m.initiate();
        for(long i=0;i<150000;i++)
        {
            m.println("helloehedhdghdgdhdgdgdgdgdgdgdgdgdgdgdgdgdgdgdgdgdgdgd generations: "+i);
            
        }   
    }
        
    
}