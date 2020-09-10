
package proc;

import java.util.ArrayList;
import java.util.Scanner;

public class AGfactor {
    public ArrayList<process> arr = new ArrayList<>();
    public ArrayList<process> readyq = new ArrayList<>();
    public ArrayList<Integer>wait= new ArrayList<Integer>();
    public ArrayList<Integer>tr= new ArrayList<Integer>();
    public ArrayList<String>updatearr=new ArrayList<String>();
    public void action()
    {
          Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter the numper of proccess");
         int numofproccess = myObj.nextInt(); 
         for(int i=0;i<numofproccess;i++)
         {   process a=new process();
             a.ProcessName=i;
             System.out.println("arrival time");
             a.ProcessArrivalTime=myObj.nextInt();
             System.out.println("burst time");
             a.ProcessBurstTime=myObj.nextInt();
             System.out.println("priority number");
             a.ProcessPriorityNumber=myObj.nextInt();
             System.out.println("Quantum");
             a.Quantum=myObj.nextInt();
             arr.add(a);
         }
        for (int i = 0; i < arr.size(); i++) {
            process min = new process();
            for (int j = i + 1; j < arr.size(); j++) {

                if (arr.get(i).ProcessArrivalTime > arr.get(j).ProcessArrivalTime) {
                    min = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, min);
                }
            }
        }
        int at = -1, index = -1, count = 0;//arrival time count
        while (arr.size()>0) {
            int z;
            z = uppercase((float) arr.get(count).Quantum / 2);
            readyq.add(arr.get(count));
            for (int i = 0; i < arr.get(count).Quantum; i += 1) {
                at+=1;
                arr.get(count).ProcessBurstTime -= 1;
                if ((i == z)) {
                    index = cheak_at(count, at);
                    if (index > -1) {
                        arr.get(count).Quantum += (arr.get(count).Quantum - i);
                        update();
                        print(arr.get(count),at,(i+1));
                        count=index;
                        index = -1;
                        break;
                    }
                }
                if (arr.get(count).ProcessBurstTime == 0) {
                    print(arr.get(count),at,(i+1));
                    arr.remove(count);
                    
                    
            }
             if(i==arr.get(count).Quantum){
                arr.get(count).Quantum = mean() + arr.get(count).Quantum;
                count=arr.indexOf(readyq.get(0));
             }
        }
            if(arr.size()==0)
            {
                break;
            }
    }    
        printall();
    }
    public int uppercase (float data)
    {
        int data1 = Math.round(data);
        if (data > data1) {
            return (data1 + 1);
        }
        return data1;

    }
       public int cheak_at(int x, int arivaltime) {
        int v = 0;
        for (int i = 0; i < arr.size(); i++) {
            if ((arr.get(x).agfactor > arr.get(i).agfactor) && (arr.get(i).ProcessArrivalTime <= arivaltime)&&(arr.get(v).agfactor<arr.get(i).agfactor)){
                v = i;
            }

        }
        return v;
    }
       public int mean() {
        int maenvalue = 0;
        for (int i = 0; i < arr.size(); i++) {
            maenvalue += arr.get(i).Quantum;
        }
        return uppercase(maenvalue / (arr.size() * 10));
    }
       void print(process a,int b,int v)
       {
           int tern_round=b+v-a.ProcessArrivalTime;
           int wait1=tern_round-a.ProcessBurstTime;
           wait.add(wait1);
           tr.add(tern_round);
           System.out.print("p  "+a.ProcessName+" order "+b+" tern round"+tern_round+" wait time "+wait1);
           
       }
       
    void printall()
    {
        int avwait=0;
        int avtr=0;
        for(int i=0;i<wait.size();i++)
        {
            avwait+=wait.get(i);
            avtr+=tr.get(i);
        }
        for(int i=0;i<updatearr.size();i++)
        {
            System.out.print(updatearr.get(i));
        }
        System.out.print("\n\n\navarege wait time = "+(avwait/wait.size())+"\navarege wait time ="+(avtr/wait.size()));
    }
    void update()
    {
        String b=String.valueOf(arr.get(0).Quantum)+" , ";;
        for(int i=1;i<arr.size();i++)
        {
            b+=String.valueOf(arr.get(i).Quantum)+" , ";
        }
        b+=")";
        updatearr.add(b);
    }
}
