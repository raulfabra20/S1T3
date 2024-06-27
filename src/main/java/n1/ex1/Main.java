package n1.ex1;

import n1.ex1.models.Month;

import java.util.ArrayList;
import java.util.HashSet;

import static n1.ex1.models.Month.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Month> months = new ArrayList<>();

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

        //Print the array without August:
        System.out.println("Array without August:");
        runArray(months);

        //Add August to the array:
        Month month8 = new Month("August");
        months.add(7, month8);

        //Print the array with August included:
        System.out.println("Array with August:");
        runArray(months);

        //Create HashSet:
        HashSet<Month> hashSet = new HashSet<>(months);

        //Add a duplicate month to the HashSet
        hashSet.add(month7);

        System.out.println("Run  the HashSet with for:");
        runHashSetWithFor(hashSet);

        System.out.println("Run the HashSet with Iterator:");
        runHashSetWithIterator(hashSet);

        }
    }


