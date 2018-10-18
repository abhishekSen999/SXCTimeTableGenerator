package GeneticAlgorithm;
import java.io.*;
import GUI.*;
public class Population {

    boolean finished;
    double mutationRate;
    double crossoverRate;
    int allowedClassGaps;
    int generations;
    int elite;
    DNA[] population;
    MyPrint s;
    //size of population mutation rate crossover rate
    public Population(int size, double mr, double cr,int e,int acg) throws IOException 
    {
        //establishing output setup
       
        
        
        
        elite=e;
        allowedClassGaps=acg;
        mutationRate = mr;
        crossoverRate=cr;
        population = new DNA[size];// declaring a array of length size
        for (int i = 0; i < size; i++) {
            population[i] = new DNA();
        }
        finished = false;
        generations = 0;
    }

    public void calculateFitness() throws IOException {
        double totalFitness = 0;
        for (int i = 0; i < population.length; i++)
        {
            population[i].calculateFitness(); //calculating fitness of DNA stored at i location
            totalFitness+=population[i].individualFitness;
        }
        for(int i=0;i<population.length;i++)
        {
            population[i].fitness=population[i].individualFitness/totalFitness*100;
        }
    }

    int naturalSelection() {
        int check=0;
	while(true)
	{
	    check++; 
            int pi =(int)(Math.random()*(population.length-1));// choosing a random index from 0 - last index 
            double rnd = Math.random()*100;// choosing a random no 0-100
            if(population[pi].fitness>=rnd) return pi;// if fitness of parent > random chosen number then it's index is returned
            if(check==1000) return -1;  // keeping a check for infinite iteration caused by any error
	}
    }
    void sort()
    {
        int indexBestDNA=0;
        for(int i=0;i<population.length;i++)
        {
            indexBestDNA=i;
            for(int j=i+1;j<population.length;j++)
            {
                if(population[indexBestDNA].compareTo(population[j])==-1)indexBestDNA=j;
            }
            DNA temp=population[i];
            population[i]=population[indexBestDNA];
            population[indexBestDNA]=temp;
        }
    }
    //generate new population
    void elitism(DNA[] newPopulation)
    {
        for(int i=0;i<elite;i++)
        {
                newPopulation[i]=population[i];
        }
        
    }
    public void generate()
    {
        int stepGenerations=generations;
        int gap=700;
	int p1,p2;
	DNA parent1,parent2;
	DNA[] newPopulation=new DNA[population.length];// new population
        elitism(newPopulation);
	//getting parents by natural selection
	for(int i=elite;i<population.length;i++)
	{
            do
            {
            	p1=naturalSelection();
		p2=naturalSelection();
            }while(p1==-1||p2==-1||p1==p2);
            parent1=population[p1];
            parent2=population[p1];
            DNA child=parent1.crossover(parent2,crossoverRate);
            child.mutation(mutationRate);
            newPopulation[i]=child;
        }
	//replacing present population with new population
	for(int i=0;i<population.length;i++)
	{	
            population[i]=newPopulation[i];
        }
	generations++;
        if(generations>stepGenerations+gap)
        {
            mutationRate+=0.001;
            stepGenerations=generations;
        }
    }
    public DNA checkCompletion()throws IOException
    {
       
        int indexBestDNA=0;
        System.out.println("\tgenerations: "+generations+"fitness: "+population[indexBestDNA].fitness+"\tindividualFitness: "+population[indexBestDNA].individualFitness+"\tcollisions: "+population[indexBestDNA].collisions+"\tclassGaps: "+population[indexBestDNA].classGaps+"\thumanFactor"+population[indexBestDNA].humanFactor);
       
        if(population[indexBestDNA].collisions==0&&population[indexBestDNA].classGaps<=allowedClassGaps&&(population[indexBestDNA].humanFactor<=8||generations>20000))
        {
            finished=true;
            return population[indexBestDNA] ;
        }
        return population[indexBestDNA];
    }
    boolean getFinished(){return finished;}

    int getGenerations(){return generations;}
}
