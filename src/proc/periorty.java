
package proc;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

class procss { //دا كلاس بتاخد فيه كل المعلومات بتاعت البروسيس

    int pn;// procss no.
    int ar;//arrival time
    int bt;//burst time 
    int prn; //priority

    int wt;//wait time
    int tr;
}
/**
 *
 * @author mohamed shaban
 */
public class periorty {
        public void action()
        {
            Scanner in = new Scanner(System.in);
        System.out.println("enter no. of procsses");
        int n = in.nextInt();
        ArrayList<procss> arr = new ArrayList<>(n);//array هحط فيها الobjects
        for (int i = 0; i < n; i++) {

            procss p = new procss();
            System.out.println("enter procsses name");
            p.pn = in.nextInt();
            System.out.println("enter procsses arrival time");
            p.ar = in.nextInt();
            System.out.println("enter procsses burst time ");
            p.bt = in.nextInt();
            System.out.println("enter procsses priority ");
            p.prn = in.nextInt();
            arr.add(p);

        }
        /* for(int i =0 ; i < n-1 ; i++){
    int pos = i;
    for (int j = i+1 ; j < n ; i++){
      if (arr[j].ar < arr[pos].ar)
      pos = j ;
    }
    procss temp =arr[i];
    arr[i]=arr[pos];
    arr[pos]= temp;
  }*/
        int time = 0; //هبدا من عند تابم زيرو 
        procss pp = new procss();//بعمل اوبجيكت عشان احط فيه اللي هاخده من ال array
        pp = arr.get(0);
        pp.wt = 0;
        pp.tr = pp.bt;

        System.out.println("p"+pp.pn + "\n");
        System.out.println(pp.ar + "\n");
        System.out.println(pp.bt + "\n");
        System.out.println(pp.prn + "\n");
        System.out.println(pp.tr + "\n");
        System.out.println(pp.wt + "\n\n\n");
        time = pp.bt; //  بغير في التايم اللي فوق اللي هو بزود عليها قيمة ال الوقت القعده اول مهمه 
        arr.remove(0);
        int tempprn = 0;// temporary priority no.
        int tempi = 0;// بشيل فيه رقم عنصر من الarray
        procss pb = new procss();
        int avgwait=0;
        int avgtr=0;
        while (arr.size() > 0) { //بلف لحد ما لما مش هيبقي فاضل عناصر
            for (int i = 0; i < arr.size(); i++) {// بلف بعدد العناصر
                //بعمل اوبجيكت عشان احط فيه اللي هاخده من ال array
                pp = arr.get(i);
                if (pp.ar <= time && pp.prn > tempprn) {// ازا كان العنصر اللي انا واقف عنده دا وصل في او قبل الوقت اللي انا واقف عنده و ال افضليه بتاعته اعلي من اللي قبله
                    tempprn = pp.prn;// تغير قيمة الافضليه لقيمه العنصر اللي انا واقف عنده
                    tempi = i;//دا هتاجه تحت في سطر ٧١
                }

            }
            //procss pb = new procss();
            pb = arr.get(tempi);
            time = time + pb.bt; //  بغير في التايم اللي فوق اللي هو بزود عليها قيمة ال الوقت القعده اول مهمه 
            pb.tr = time - pb.ar;
            pb.wt = pb.tr - pb.bt;
            avgwait +=pb.wt;
            avgtr+=pb.tr;
            System.out.println("p"+pb.pn + "\n");
            System.out.println(pb.ar + "\n");
            System.out.println(pb.bt + "\n");
            System.out.println(pb.prn + "\n");
            System.out.println(pb.tr + "\n");
            System.out.println(pb.wt + "\n\n\n");

            tempprn = 0;
            arr.remove(tempi);
            procss o=new procss();
            int tempi2=0,tempprn2=1000000;
            for(int i=0;i<arr.size();i++)
            {
                o = arr.get(i);
                if(o.prn<tempprn2)
                {
                    tempprn2 = o.prn;
                    tempi2=i;
                }
            }
           // arr.get(tempi2)prn +=1;
            
    //المفروض كان في سطر بيشيل العنصر اللي طبعته من ال array

        }
        System.out.print("avarage wait = "+(avgwait/n)+"avarage tern round = "+(avgtr/n));
        }
}
