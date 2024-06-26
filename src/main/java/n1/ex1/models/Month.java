package n1.ex1.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Month {
    private String name;

    public Month(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
   public static void testApplication(ArrayList<Month> months){
      Month month1 = new Month("January");
       addMonths(months, month1);
       Month month2 = new Month("February");
       addMonths(months, month2);
       Month month3 = new Month("March");
       addMonths(months, month3);
       Month month4 = new Month("April");
       addMonths(months, month4);
       Month month5 = new Month("May");
       addMonths(months, month5);
       Month month6 = new Month("June");
       addMonths(months, month6);
       Month month7 = new Month("July");
       addMonths(months, month7);
       Month month9 = new Month("September");
       addMonths(months, month9);
       Month month10 = new Month("October");
       addMonths(months, month10);
       Month month11 = new Month("November");
       addMonths(months, month11);
       Month month12 = new Month("December");
       addMonths(months, month12);
       Month month8 = new Month("August");
       months.add(7, month8);

       System.out.println("Run the array:");
       runArray(months);

       HashSet<Month> hashSet = new HashSet<>(months);

       //Add a duplicate month to the HashSet
       hashSet.add(month7);
       System.out.println("Run  the HashSet:");
       runHashSet(hashSet);

   }
   public static void runHashSet(HashSet<Month> hashSet){
       for(Month month : hashSet){
           System.out.println(month.getName());
       }

      Iterator<Month> itr = hashSet.iterator();
       while(itr.hasNext()){
           System.out.println(itr.next().getName());
       }
   }

    public static void addMonths(ArrayList<Month> months, Month month){

        months.add(month);
    }
    public static void runArray(ArrayList<Month> months){
        for(Month month: months){
            System.out.println(month.getName());
        }
    }

    }





