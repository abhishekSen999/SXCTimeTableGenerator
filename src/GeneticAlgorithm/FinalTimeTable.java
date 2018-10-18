package GeneticAlgorithm;
import java.io.*;
import GUI.JFrameMenu;
public class FinalTimeTable {
    static public int[][] time;//time slots for all courses (hon)
    static public int[][] room;//room for all courses (hon)
    static public int[][] day;//day for all courses (hon)
    static public int[] ancillaryTime;//time slots for all courses (ancillary)
    static public int[] ancillaryDay;//day for all courses (ancillary)
    public void start(JFrameMenu jFM)throws IOException
    {
        //initiating evolution
        SetupEvolution se=new SetupEvolution();
        DNA finalTimeTable=se.generate(jFM);
        
        time=new int[finalTimeTable.time.length][];
        for(int i=0;i<finalTimeTable.time.length;i++)
        { 
            time[i]=new int[finalTimeTable.time[i].length];
        }
        for(int i=0;i<finalTimeTable.time.length;i++)
        { 
            for(int j=0;j<finalTimeTable.time[i].length;j++)
            {
                time[i][j]=finalTimeTable.time[i][j];
            }
        }
        
        room=new int[finalTimeTable.room.length][];
        for(int i=0;i<finalTimeTable.room.length;i++)
        { 
            room[i]=new int[finalTimeTable.room[i].length];
        }
        for(int i=0;i<finalTimeTable.room.length;i++)
        { 
            for(int j=0;j<finalTimeTable.room[i].length;j++)
            {
                room[i][j]=finalTimeTable.room[i][j];
            }
        }
        
        day=new int[finalTimeTable.day.length][];
        for(int i=0;i<finalTimeTable.day.length;i++)
        { 
            day[i]=new int[finalTimeTable.day[i].length];
        }
        for(int i=0;i<finalTimeTable.day.length;i++)
        { 
            for(int j=0;j<finalTimeTable.day[i].length;j++)
            {
                day[i][j]=finalTimeTable.day[i][j];
            }
        }
        ancillaryTime=new int[finalTimeTable.ancillaryTime.length];
        for(int i=0;i<finalTimeTable.ancillaryTime.length;i++)
            ancillaryTime[i]=finalTimeTable.ancillaryTime[i];
        ancillaryDay=new int[finalTimeTable.ancillaryDay.length];
        for(int i=0;i<finalTimeTable.ancillaryDay.length;i++)
            ancillaryDay[i]=finalTimeTable.ancillaryDay[i];
        
    }
    
}
