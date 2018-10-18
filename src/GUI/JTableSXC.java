package GUI;

// Demonstrate JTable.
import java.awt.*;
import javax.swing.*;
import Database.Database;
import java.awt.event.*;

public class JTableSXC extends JFrame implements ActionListener
{
    JTable table,table1,table2;
    public JTableSXC(int[][] time,int[][] room,int[][] day,int[] ancillaryTime,int[] ancillaryDay)
    {
        setLayout(new GridLayout(4,1,0,30));
        
        JPanel panel1=new JPanel();
        /*JButton b1=new JButton("sem2 print");
        b1.addActionListener(this);
        panel1.add(b1);*/
            

        /*JButton b2=new JButton("sem4 print");
        b2.addActionListener(this);
        panel1.add(b2);*/

        /*JButton b3=new JButton("sem6 print");
        b3.addActionListener(this);
        panel1.add(b3);
        add(panel1);*/

        
        //Table for semester 2
	// Initialize column headings.
        String[] colHeads = { "SEM2","Timeslot","MTMA", "RNo", "PHSA","RNo","CEMA","RNo","CMSA","RNo" ,"MCBA","RNo","ECOA","RNo","STSA","RNo"};
        // Initialize data.
        int t,r,d;
        int R,C;
        Object data[][]=new Object [48][16];
        for(int i=0;i<48;i++)
            for(int j=0;j<16;j++)
		data[i][j]="";
        Database db=new Database();
        for(int i=0,j=0;i<42;i+=7)
        {
            data[i][0]=Database.dayName[j++];
            if(j>6)j=0;
        }
        for(int i=0,j=0;i<42;i++)
        {
            data[i][1]=Database.timeSlots[j++];
            if(j>6)j=0;
        }
        //for semester 2, all departments honours classes
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<time[i].length;j++)
            {
		t=time[i][j];
		r=room[i][j];
		d=day[i][j];
                R=d*7+(t);
		C=(i*2)+2;
		data[R][C]=Database.classes[i][j];
		data[R][C+1]=Database.rooms[r];
            }
        }
        //for ancillary,semester 2
         for(int i=0;i<7;i++)
        {
            for(int j=0;j<ancillaryTime.length;j++)
            {
		t=ancillaryTime[j];
		d=ancillaryDay[j];
                R=d*7+(t);
		C=(i*2)+2;
		data[R][C]=Database.ancillary[j];
            }
        }
        // Creating the table.
       table = new JTable(data, colHeads);
        // Adding the table to a scroll pane.
        JScrollPane jsp = new JScrollPane(table);
        // Add the scroll pane to the content pane.
        add(jsp);
        JButton b1=new JButton("sem2 print");
        b1.addActionListener(this);
        panel1.add(b1);
            
        
        //Table for semester 4
        //Initializing column heads
        String[] colHeads1 = { "SEM4","Timeslot","MTMA", "RNo ", "PHSA","RNo ","CEMA","RNo ","CMSA","RNo" ,"MCBA","RNo","ECOA","RNo","STSA","RNo"};
        // Initialize data.
        Object data1[][]=new Object [48][16];
        for(int i=0;i<48;i++)
            for(int j=0;j<16;j++)
		data1[i][j]="";
        for(int i=0,j=0;i<42;i+=7)
        {
            data1[i][0]=Database.dayName[j++];
            if(j>6)j=0;
        }
        for(int i=0,j=0;i<42;i++)
        {
            data1[i][1]=Database.timeSlots[j++];
            if(j>6)j=0;
        }

        //for semester 4, all departments
        for(int i=7;i<14;i++)
        {
            for(int j=0;j<time[i].length;j++)
            {
		t=time[i][j];
		r=room[i][j];
		d=day[i][j];
                R=d*7+(t);
		C=((i-7)*2)+2;
		data1[R][C]=Database.classes[i][j];
                data1[R][C+1]=Database.rooms[r];
            }
        }
        // Creating the table.
        table1 = new JTable(data1, colHeads1);
        // Adding the table to a scroll pane.
        JScrollPane jsp1 = new JScrollPane(table1);
        // Add the scroll pane to the content pane.
        add(jsp1);
        JButton b2=new JButton("sem4 print");
        b2.addActionListener(this);
        panel1.add(b2);
        
        //Table for semester 6
        //Initializing column heads
        String[] colHeads2 = { "SEM6","Timeslot","MTMA", "RNo ", "PHSA","RNo ","CEMA","RNo ","CMSA","RNo " ,"MCBA","RNo","ECOA","RNo","STSA","RNo"};
        // Initialize data.

        Object data2[][]=new Object [48][16];
        for(int i=0;i<48;i++)
            for(int j=0;j<16;j++)
		data2[i][j]="";
        for(int i=0,j=0;i<42;i+=7)
        {
            data2[i][0]=Database.dayName[j++];
            if(j>6)j=0;
        }
        for(int i=0,j=0;i<42;i++)
        {
            data2[i][1]=Database.timeSlots[j++];
            if(j>6)j=0;
        }

        //for semester 6, all departments
        for(int i=14;i<21;i++)
        {
            for(int j=0;j<time[i].length;j++)
            {
		t=time[i][j];
		r=room[i][j];
                d=day[i][j];
		R=d*7+(t);
		C=((i-14)*2)+2;
		data2[R][C]=Database.classes[i][j];
		data2[R][C+1]=Database.rooms[r];
            }
        }
        // Creating the table.
        table2 = new JTable(data2, colHeads2);
        // Adding the table to a scroll pane.
        JScrollPane jsp2 = new JScrollPane(table2);
        // Adding the scroll pane to the content pane.
        add(jsp2);
        JButton b3=new JButton("sem6 print");
        b3.addActionListener(this);
        panel1.add(b3);
        
        
        JButton b4=new JButton("back");
        b4.addActionListener(this);
        panel1.add(b4);
        add(panel1);
        

       setSize(800,800);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent evt)
    {
        try{
            String str = evt.getActionCommand();
            if(str.equals("sem2 print"))
                table.print();
            else if(str.equals("sem4 print"))
                table1.print();
            else if (str.equals("sem4 print"))
                table2.print();
            else if (str.equals("back"))
            {
                setVisible(false);
            }
                
        }catch(Exception e){System.out.println(e);}
    }
  //  private javax.swing.JButton jButton_back;
  //  private void jButton_backActionPerformed(java.awt.event.ActionEvent evt) 
  //  {                                             
  //      GUI.JFrameMenu ob= new JFrameMenu();
  //      ob.setSize(500,500);
  //      ob.setVisible(true);
        
   // }                                            
    
    
    /*
    private void makeGUI() 
    {
    }

    public static void main(String ar[])
    {
    //new JTableSXC();
    }
    */
}