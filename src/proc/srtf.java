package proc;

import java.util.*;

/**
 *
 * @author mohamed shaban
 */
public class srtf {
      public void action()
      {
          Scanner input=new Scanner(System.in);
	System.out.print("enter no of process:");
        int numOfProcess =input.nextInt();
        
	int totnumOfProcess=0;
        int starttime=0;
        
	int processnum[] = new int[numOfProcess ];
	int Arrivtime[] = new int[numOfProcess ];
	int Burstime[] = new int[numOfProcess ];
        int newBurstime[] = new int[numOfProcess];
	int Finishtime[] = new int[numOfProcess ]; 
        
	int Waitingtime[] = new int[numOfProcess ];
        int Turnaroundtime[] = new int[numOfProcess ];
        
        float averagewaitingtime=0;
        float averageturnaroundtime=0;
        
        int check[] = new int[numOfProcess ];
        
        int Ganttchart[]=new int[numOfProcess ];
        
        int swit;
	for (int i=0;i<numOfProcess;i++)
	{
	    processnum[i]= i+1;
	    System.out.println ("enter process " +(i+1)+ " arrival time:");
	    Arrivtime[i]= input.nextInt();
	    System.out.println("enter process " +(i+1)+ " burst time:");
	    Burstime[i]= input.nextInt();
	    newBurstime[i]= Burstime[i];
	    check[i]= 0;
	}
        System.out.println("Enter Switch:");
        swit=input.nextInt();
	    
	while(true)
        {
	    int min=99,c=numOfProcess;
          
	    for (int i=0;i<numOfProcess;i++)
	    {
	    	if ((Arrivtime[i]<=starttime) && (check[i]==0) && (Burstime[i]<min))
	    	{	
                    min=Burstime[i];
                    c=i;
                    //System.out.println("P"+processnum[i]+"\t"+(Ganttchart[i]));
	    	}
	    }
	    Burstime[c]--;
	    starttime++;
            
            //System.out.println("P"+processnum[c]+"\t"+(Ganttchart[c]));
            
	    if (Burstime[c]==0)
	    {
                starttime+=swit;
	    	Finishtime[c]= starttime;
	    	check[c]=1;
	    	totnumOfProcess++;
                Finishtime[c]+=swit;
                Ganttchart[c]=Finishtime[c];
                System.out.println("P"+processnum[c]+"\t"+Ganttchart[c]);
            }
            
            if (totnumOfProcess==numOfProcess)
	    	break;
        }
	    
	for(int i=0;i<numOfProcess;i++)
	{
	    Turnaroundtime[i] = Finishtime[i] - Arrivtime[i];
	    Waitingtime[i] = Turnaroundtime[i] - newBurstime[i];
	    averagewaitingtime+= Waitingtime[i];
	    averageturnaroundtime+= Turnaroundtime[i];
	}
        System.out.println();
        System.out.println();
        
	for(int i=0;i<numOfProcess;i++)
	{
            averagewaitingtime+= Waitingtime[i];
            averageturnaroundtime +=  Turnaroundtime[i];
            System.out.print("processnum :"+processnum[i]+"   ");
            System.out.print("Arrivaltime :"+Arrivtime[i]+"   ");
            System.out.print("BurstTime :"+newBurstime[i]+"   ");
            System.out.print("Finish Time :"+Finishtime[i]+"   ");
            System.out.print("TurnAround Time :"+Turnaroundtime[i]+"   ");
            System.out.print("Waiting Time :"+Waitingtime[i]+"   ");
            System.out.println();
	}
	 
        
	System.out.println();
        System.out.println ("average waiting time is "+ (float)(averageturnaroundtime/numOfProcess));
        System.out.println();
        System.out.println ("average turnaround time is "+ (float)(averagewaitingtime/numOfProcess));
        System.out.println();
      }
}
