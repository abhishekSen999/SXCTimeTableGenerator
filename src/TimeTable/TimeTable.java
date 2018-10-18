package TimeTable;
import GeneticAlgorithm.*;

import java.io.*;
import GUI.*;
import Database.Database;

public class TimeTable 
{
    
    
    public TimeTable(JFrameMenu jFM) throws IOException
    //public static void main(String args[]) throws IOException
    {
               
        Database d=new Database();
        FinalTimeTable ftt=new FinalTimeTable();
        ftt.start(jFM);
        JTableSXC ob=new JTableSXC(FinalTimeTable.time,FinalTimeTable.room,FinalTimeTable.day,FinalTimeTable.ancillaryTime,FinalTimeTable.ancillaryDay);
    }
}
