/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm;
import java.io.*;
import GUI.*;
/**
 *
 * @author abhis
 */
public class testDNA 
{
    public static void main(String args[])throws IOException
    {
        for(int i=0;i<100;i++)
        mai1();
                
    }
    public static void mai1()throws IOException
    {
        MyPrint m=new MyPrint();
        m.setVisible(true);
        m.initiate();
        mai();
    }
    public static void mai()throws IOException
    {
        
        for(long i=0;i<1500;i++)
        {
            MyPrint.println("helloehedhdghdgdhdgdgdgdgdgdgdgdgdgdgdgdgdgdgdgdgdgdgd generations: "+i);
            
        }   
        /* //printimg
        System.out.println("time slots hon");
        for(int i=0;i<21;i++)
        {
            for(int j=0;j<g.time[i].length;j++)
            {
                System.out.print(g.time[i][j]+"\t");
            }
            System.out.println();
        }
        
        System.out.println("days hon");
        for(int i=0;i<21;i++)
        {
            for(int j=0;j<g.day[i].length;j++)
            {
                System.out.print(g.day[i][j]+"\t");
            }
            System.out.println();
        }
        
        System.out.println("room hon");
        for(int i=0;i<21;i++)
        {
            for(int j=0;j<g.room[i].length;j++)
            {
                System.out.print(g.room[i][j]+"\t");
            }
            System.out.println();
        }
        
        System.out.println("day for ancillary");
        for(int i=0;i<g.ancillaryDay.length;i++)
        {
            System.out.print(g.ancillaryDay[i]+"\t");
        }
        System.out.println();
        System.out.println("time for ancillary");
        for(int i=0;i<g.ancillaryTime.length;i++)
        {
            System.out.print(g.ancillaryTime[i]+"\t");
        }
        */
       
    }
    
}
