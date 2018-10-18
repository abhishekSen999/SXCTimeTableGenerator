package GeneticAlgorithm;
import java.io.*;
import GUI.*;

public class SetupEvolution{
    
    JFrameMenu jFM;
    public DNA generate(JFrameMenu jFM)throws IOException
    //public static void  main(String args[]) throws IOException
    {
        this.jFM=jFM;
        
        DNA finalTimeTable;
        double mutationRate=0.001;
        int populationSize=100;
        double crossoverRate=0.9;
        int elite=populationSize*5/100;
        int allowedClassGaps=0;//(total gaps in between classes  )
        finalTimeTable=draw(populationSize,mutationRate,crossoverRate,elite,allowedClassGaps);
        return finalTimeTable;
    }
    public DNA draw(int populationSize,double mutationRate,double crossoverRate,int elite,int allowedClassGaps)throws IOException
    {
        DNA finalTimeTable;
        Population p=new Population(populationSize,mutationRate,crossoverRate,elite,allowedClassGaps);
	p.calculateFitness(); 
        //sorting the population in the order of best DNA - worst DNA
        p.sort();
             
        do
	{
            p.generate();
            p.calculateFitness();
            //sorting the population in the order of best DNA - worst DNA
            p.sort();
            finalTimeTable=p.checkCompletion();
            
            
            
            
            
            
            
           // jFM.println("generations: "+p.generations+"\tFitness: "+p.population[0].individualFitness);
            
            
        }while (!p.getFinished());

	jFM.println("Total number of generations required = "+p.getGenerations());
        return finalTimeTable;
    }
    
}
