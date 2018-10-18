package GeneticAlgorithm;
import Database.Database;

public class DNA{
    int[][] time;//time slots for all courses (hon)
    int[][] room;//room for all courses (hon)
    int[][] day;//day for all courses (hon)
    int[] ancillaryTime;//time slots for all courses (ancillary)
    int[] ancillaryDay;//day for all courses (ancillary)
    int noOfCourses;
    int classGaps;
    int humanFactor;
    int collisions;
    double fitness;
    double individualFitness;
    int HW,SW,PH,CH,MB,ROOMS,noOfWorkingDays;
    public DNA()
    {
        noOfWorkingDays=6;
        collisions=0;
        individualFitness=0.0;
        fitness=0.0;
        Database d=new Database();
        // finding the index of the labs in the rooms[] in Database and the number of normal rooms;
        for(int i=0;i<d.rooms.length;i++)
        {
            if(Database.rooms[i].equals("LHW"))HW=i;
            else if(Database.rooms[i].equals("LSW"))SW=i;
            else if( Database.rooms[i].equals("LPH"))PH=i;
            else if(Database.rooms[i].equals("LCH"))CH=i;
            else if(Database.rooms[i].equals("LMB"))MB=i;
            else ROOMS++;
        }
        noOfCourses=Database.courses.length;//length of courses is initiated to the length of the courses[] array in Database
        //array declarations
        ancillaryTime=new int[Database.ancillary.length];//length of array is initiated to the length of the ancillary[] array in Database
        ancillaryDay=new int[Database.ancillary.length];//length of array is initiated to the length of the ancillary[] array in Database
        time=new int[noOfCourses][];
        room=new int[noOfCourses][];
        day=new int[noOfCourses][];
        for(int i=0;i<noOfCourses;i++)
        {
            time[i]=new int[Database.classes[i].length];
            room[i]=new int[Database.classes[i].length];
            day[i]=new int[Database.classes[i].length];
        }
        //random allotment of data to arrays(hon courses)
        for(int i=0;i<noOfCourses;i++)
        {
            for(int j=0;j<Database.classes[i].length;j++ )
            {
                if(Database.classes[i][j].startsWith("L"))
                {
                    //alloting labs
                    if(Database.classes[i][j].startsWith("LHW"))room[i][j]=HW;
                    else if(Database.classes[i][j].startsWith("LSW"))room[i][j]=SW;
                    else if(Database.classes[i][j].startsWith("LPH"))room[i][j]=PH;
                    else if(Database.classes[i][j].startsWith("LCH"))room[i][j]=CH;
                    else if(Database.classes[i][j].startsWith("LMB"))room[i][j]=MB;
                    
                    //alloting time slots and days to labs(first of the set of classes)
                    if(j==0 || !Database.classes[i][j].equals(Database.classes[i][j-1]))
                    {
                        //time slot assignment
                        while(true)
                        {
                            int t=((int)(Math.random()*1000))%Database.timeSlots.length;
                            if(t+Database.noOfClasses[i][j]<=Database.timeSlots.length && !(t<=Database.recess&&t+Database.noOfClasses[i][j]-1>Database.recess))//not allowing classes to go beyond && lab period not accross break
                            {
                                time[i][j]=t;
                                break;
                            }
                        }
                        //day assignment
                        while (true)
                        {
                            int dy=((int)(Math.random()*1000))%noOfWorkingDays;//as 6 working days
                            if(Database.courses[i].charAt(4)-48>4&&dy==Database.offDay[i%7])
                            {
                                continue;
                            }
                            else
                            {
                                day[i][j]=dy;
                                break;
                            }
                        }
                    }
                    //alloting time slots and days to labs(rest of the set of classes)
                    else
                    {  
                        time[i][j]=time[i][j-1]+1;
                        day[i][j]=day[i][j-1];
                    }
                }
                if(Database.classes[i][j].startsWith("H"))
                {
                    //alloting room
                    room[i][j]=i;//((int)(Math.random()*1000))%ROOMS;
                    //alloting time slot
                    time[i][j]=((int)(Math.random()*1000))%Database.timeSlots.length;
                    //assigning day of the week while avoiding the off day of the department
                    while (true)
                    {
                        int dy=((int)(Math.random()*1000))%6;//as 6 working days
                        if(Database.courses[i].charAt(4)-48>4&&dy==Database.offDay[i%7])
                        {
                            continue;
                        }
                        else
                        {
                            day[i][j]=dy;
                            break;
                        }
                    }
                }
                
            }
        }
        //random allotment of data to arrays(ancillary courses)
        for(int i=0;i<Database.ancillary.length;i++)
        {
            if(i==0 || !Database.ancillary[i].equals(Database.ancillary[i-1]))
            {
                //day allotment
                ancillaryDay[i]=((int)(Math.random()*1000))%6;//as 6 working days
                //time slot allotment
                while(true)
                {
                    int t=((int)(Math.random()*1000))%Database.timeSlots.length;
                    if(t+Database.classesAncillary[i]<=Database.timeSlots.length && !(t<=Database.recess&&t+Database.classesAncillary[i]-1>Database.recess))//not allowing ancillary sets to go beyond && not allowing ancillary sets to fall across recess
                    {
                        ancillaryTime[i]=t;
                        break;
                    }
                }
                
            }
            else
            {
                ancillaryDay[i]=ancillaryDay[i-1];
                ancillaryTime[i]=ancillaryTime[i-1]+1;
            }
            
        }
        
    }
    public void calculateFitness()
    {
        
        int collisionFitnessRoom=0,collisionFitnessStudents=0;
        individualFitness=0.0;
        humanFactor=0;
        collisions=0;
        classGaps=0;
        Database d=new Database();
        int[][][] roomCollision=new int[Database.rooms.length][noOfWorkingDays][Database.timeSlots.length];
        //initialising roomCollision with 0 
        for(int i=0;i<Database.rooms.length;i++)
        {
            for(int j=0;j<noOfWorkingDays;j++)
            {
                for(int k=0;k<Database.timeSlots.length;k++)
                {
                    roomCollision[i][j][k]=0;
                }
            }
        }
        
        //alloting freq of classes at a time in each class
        for(int i=0;i<Database.classes.length;i++)
        {
            for(int j=0;j<Database.classes[i].length;j++)
            {
                roomCollision[room[i][j]][day[i][j]][time[i][j]]++;
            }
        }
        
        int maxClasses=1;
        //calculating room collision
        for(int i=0;i<Database.rooms.length;i++)
        {
            if(i==SW)maxClasses=4;
            else maxClasses=1;
            for(int j=0;j<noOfWorkingDays;j++)
            {
                for(int k=0;k<Database.timeSlots.length;k++)
                {
                    if(roomCollision[i][j][k]>maxClasses)collisionFitnessRoom=collisionFitnessRoom+(roomCollision[i][j][k]-maxClasses);
                }
            }
        }
      
        //considering class collision for each student
        int[][] testClassCollision=new int[noOfWorkingDays][Database.timeSlots.length];
        //considering human factor for each student
        int[][] classes_HumanFactor=new int[noOfWorkingDays][Database.timeSlots.length];
        //considering class distributin of all departments for all days
        int[][] classDistribution=new int[Database.courses.length][Database.dayName.length];
        
        for(int i=0;i<Database.classes.length;i++)
        {
            //for each class re initializing the collision array
            for(int ri=0;ri<testClassCollision.length;ri++)
            {    
                for(int rj=0;rj<testClassCollision[ri].length;rj++)
                {
                    testClassCollision[ri][rj]=0;
                }
            }
            
            for(int j=0;j<Database.classes[i].length;j++)
            {
                testClassCollision[day[i][j]][time[i][j]]++;
            }
            
            if(Database.courses[i].charAt(4)-48<=3 )
            {
                for(int j=0;j<Database.ancillary.length;j++)
                {
                   testClassCollision[ancillaryDay[j]][ancillaryTime[j]]++;
                }
            }
            //finding collision
            for(int ri=0;ri<testClassCollision.length;ri++)
            {    
                for(int rj=0;rj<testClassCollision[ri].length;rj++)
                {
                    
                    if(testClassCollision[ri][rj]>1)
                    {
                        collisionFitnessStudents=collisionFitnessStudents+(testClassCollision[ri][rj]-1);
                    }
                }
            }
            //considering human factor
            //for each class re initializing the humanFactor array
            for(int ri=0;ri<classes_HumanFactor.length;ri++)
            {    
                for(int rj=0;rj<classes_HumanFactor[ri].length;rj++)
                {
                    classes_HumanFactor[ri][rj]=0;
                }
            }
            for(int j=0;j<Database.classes[i].length;j++)
            {
                classes_HumanFactor[day[i][j]][time[i][j]]=1;
            }
            if(Database.courses[i].charAt(4)-48<=3 )
            {
                for(int j=0;j<Database.ancillary.length;j++)
                {
                   classes_HumanFactor[ancillaryDay[j]][ancillaryTime[j]]=1;
                }
            }
            //finding gaps in classes and no of classes each day
            for(int ri=0;ri<classes_HumanFactor.length;ri++)
            {    
                int first=Database.timeSlots.length-1,last=0;
                for(int rj=0;rj<classes_HumanFactor[ri].length;rj++)
                {
                    if(classes_HumanFactor[ri][rj]==1&&rj<first)first=rj;
                    if(classes_HumanFactor[ri][rj]==1&&rj>last)last=rj;
                }
                classDistribution[i][ri]=last-first+1;
                
                if(!(Database.courses[i].charAt(4)-48>4&&ri==Database.offDay[i%7]))
                {
                    for(int rj=first+1;rj<last;rj++)
                    {
                        if(classes_HumanFactor[ri][rj]==0)classGaps++;
                    }
                }
            }
        }
        
        //cheching class distribution and calculating humanFactor
        for(int i=0;i<classDistribution.length;i++)
        {
            int max=0,min=7;//int total=0;
            for(int j=0;j<classDistribution[i].length;j++)
            {
              //  total+=classDistribution[i][j];
                if(Database.courses[i].charAt(4)-48>4&&j==Database.offDay[i%7])
                {
                    if(classDistribution[i][j]<min)min=classDistribution[i][j];
                    if(classDistribution[i][j]>max)max=classDistribution[i][j];
                }
            }
            //int avg=total/classDistribution[0].length;
            //for(int j=0;j<classDistribution[i].length;j++)
            //{
            //    if(Database.courses[i].charAt(4)-48>4&&j==Database.offDay[i%7])
            //    {
            //        humanFactor+=0;
            //    }
            //    else
            //    {
            //        if(Math.abs(classDistribution[i][j]-avg)>2)
            //            humanFactor+=1;
            //    }
            //}
            if(max-min>4)humanFactor=humanFactor+1;
        }
        collisions=collisionFitnessRoom+collisionFitnessStudents;//lower the collisions better the offspring
        individualFitness=1/(double)((collisions+1)*(collisions+1)*(collisions+1)*(collisions+1))*(1.0/(classGaps+1))*(1.0/(humanFactor+1))*(1.0/(humanFactor+1))*(1.0/(humanFactor+1))*100;
    }
    //partner and crossover rate
    public DNA crossover(DNA partner,double cr)
    {
        Database d=new Database();
        DNA offspring1,offspring2,bestOffspring;
        offspring1=new DNA();
        offspring2=new DNA();
        double probability=cr;
        //crossover in Hon Classes
        for(int i=0;i<Database.classes.length;i++)
        {
            if(Math.random()<=probability)
            {
               
               int point=((int)(Math.random()*1000))%Database.classes[i].length;
               while(point>0 && Database.classes[i][point].equals(Database.classes[i][point-1]))
               {
                   point--;
               }
               for(int j=0;j<point;j++)
               {
                   offspring1.time[i][j]=time[i][j];
                   offspring1.day[i][j]=day[i][j];
                   
                   offspring2.time[i][j]=partner.time[i][j];
                   offspring2.day[i][j]=partner.day[i][j];
               }
               for(int j=point;j<Database.classes[i].length;j++)
               {
                   offspring2.time[i][j]=time[i][j];
                   offspring2.room[i][j]=room[i][j];
                   offspring2.day[i][j]=day[i][j];
                   
                   offspring1.time[i][j]=partner.time[i][j];
                   offspring1.room[i][j]=partner.room[i][j];
                   offspring1.day[i][j]=partner.day[i][j];
               }
           }
        }
        //crossover for ancillary
        if(Math.random()<=probability)
           {
               int point=((int)(Math.random()*1000))%Database.ancillary.length;
               while(point>0 && Database.ancillary[point].equals(Database.ancillary[point-1]))
               {
                   point--;
               }
               for(int j=0;j<point;j++)
               {
                   offspring1.ancillaryTime[j]=ancillaryTime[j];
                   offspring1.ancillaryDay[j]=ancillaryDay[j];
                   
                   offspring2.ancillaryTime[j]=partner.ancillaryTime[j];
                   offspring2.ancillaryDay[j]=partner.ancillaryDay[j];
               }
               for(int j=point;j<Database.ancillary.length;j++)
               {
                   offspring2.ancillaryTime[j]=ancillaryTime[j];
                   offspring2.ancillaryDay[j]=ancillaryDay[j];
                   
                   offspring1.ancillaryTime[j]=partner.ancillaryTime[j];
                   offspring1.ancillaryDay[j]=partner.ancillaryDay[j];
               }
           }
        offspring1.calculateFitness();
        offspring2.calculateFitness();
        if(offspring1.compareTo(offspring2)==1)
        {
            bestOffspring=offspring1;
        }
        else 
        {
            bestOffspring=offspring2;
        }
            
        //System.out.println("offspring1: "+offspring1.collisions+" offspring2: "+offspring2.collisions+" bestOffspring: "+bestOffspring.collisions );
        return bestOffspring;
    }
    public void mutation(double mr)
    {
        
        double mutationRate=mr;
       
        for(int i=0;i<Database.classes.length;i++)
        {
            for(int j=0;j<Database.classes[i].length;j++)
            {
                //time & day mutation
                //it has to be the first class of the set
                if(j==0||!Database.classes[i][j].equals(Database.classes[i][j-1]))
                {
                    if(Math.random()<mr)
                    {
                        //changing time
                        while(true)
                        {
                            int t=((int)(Math.random()*1000))%Database.timeSlots.length;
                            if(Database.noOfClasses[i][j]==1)
                            {
                                time[i][j]=t;
                                break;
                            }
                            else if(t+Database.noOfClasses[i][j]<=Database.timeSlots.length && !(t<=Database.recess&&t+Database.noOfClasses[i][j]-1>Database.recess))//not allowing classes to go beyond && lab period not accross break
                            {
                                time[i][j]=t;
                                break;
                            }
                        }
                        //changing day
                        while (true)
                        {
                            int dy=((int)(Math.random()*1000))%noOfWorkingDays;//as 6 working days
                            if(Database.courses[i].charAt(4)-48>4&&dy==Database.offDay[i%7])
                            {
                                continue;
                            }
                            else
                            {
                                day[i][j]=dy;
                                break;
                            }
                        }
                    }
                }
                else
                {
                    time[i][j]=time[i][j-1]+1;
                    day[i][j]=day[i][j-1];
                }
                
                
            }
        }
    }
    //returns 1 if this DNA is better than DNA d ,-1 if DNA d is better than this DNA, else 0
    public int compareTo(DNA d)
    {
        if(collisions<d.collisions)
        {
            return 1;
        }
        else if(d.collisions<collisions)
        {
            return -1;
        }
        else if(classGaps<d.classGaps)
        {
            return 1;
        }
        else if(d.classGaps<classGaps)
        {
            return -1;
        }
        else if(humanFactor<d.humanFactor)
        {
            return 1;
            
        }
        else if(d.humanFactor<humanFactor)
        {
            return -1;
            
        } 
        else return 0;
    }
}
