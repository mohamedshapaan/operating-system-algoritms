/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proc;

import java.util.Scanner;

public class sjf {
    public void action()
    {
         Scanner input = new Scanner(System.in);
        
	System.out.println ("Enter Number of processes you want:");
	int numOfProcess =input.nextInt();
        
        int totnumOfProcess=0;
        int starttime=0;
        
	int processnum[] = new int[numOfProcess ];
	int Arrivtime[] = new int[numOfProcess ];
	int Burstime[] = new int[numOfProcess ];
	int Finishtime[] = new int[numOfProcess ]; 
        
	int Waitingtime[] = new int[numOfProcess ];
        int Turnaroundtime[] = new int[numOfProcess ];
        
        float averagewaitingtime=0;
        float averageturnaroundtime=0;
        
        int check[] = new int[numOfProcess ];
        
        int Ganttchart[]=new int[numOfProcess ];
     
        for(int i=0;i<numOfProcess;i++)
	{
            System.out.println ("enter process " + (i+1) + " arrival time:");
            Arrivtime[i] = input.nextInt();
            
            System.out.println ("enter process " + (i+1) + " brust time:");
            Burstime[i] = input.nextInt();
            
            processnum[i] = i+1;
            check[i] = 0;
	}
        
	System.out.println("Gantt Chart:");
        
	while(true)
	{
            int minimum=100000;
            int mm=numOfProcess;
           
            for (int i=0; i<numOfProcess; i++)
            {
		if (Arrivtime[i] <= starttime)
		{
                    if (Burstime[i]<minimum)
                    {
                        if (check[i] == 0)
                        {
                            minimum=Burstime[i];
                            mm=i;
                        }
                    }
		}
            }
            
            Finishtime[mm]=starttime+Burstime[mm];
            starttime+=Burstime[mm];
            Turnaroundtime[mm]=Finishtime[mm]-Arrivtime[mm];
            Waitingtime[mm]=Turnaroundtime[mm]-Burstime[mm];
            check[mm]=1;
            totnumOfProcess++;
            Ganttchart[mm]=Finishtime[mm];
            
            System.out.print("P"+processnum[mm]+"   "+Ganttchart[mm]+"   ");
            
            if (totnumOfProcess == numOfProcess)
            {
                break;
            }
            
        }
        
        System.out.println();
        System.out.println();
        
	for(int i=0;i<numOfProcess;i++)
	{
            averagewaitingtime+= Waitingtime[i];
            averageturnaroundtime +=  Turnaroundtime[i];
            System.out.print("processnum :"+processnum[i]+"   ");
            System.out.print("Arrivaltime :"+Arrivtime[i]+"   ");
            System.out.print("BurstTime :"+Burstime[i]+"   ");
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
