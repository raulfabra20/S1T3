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

   public static void runHashSetWithFor(HashSet<Month> hashSet) {

       for (Month month : hashSet) {
           System.out.println(month.getName());
       }
   }
   public static void runHashSetWithIterator(HashSet<Month> hashSet){
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





