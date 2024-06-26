package n1.ex2;

import java.util.ArrayList;
import java.util.ListIterator;

public class TestList {

    public static void listsCreated(){
        ArrayList<Integer> list1 = createList1();
        ArrayList<Integer> list2 = createList2(list1);

        System.out.println("List 1: ");
        System.out.println(list1);

        System.out.println("List 2:");
        System.out.println(list2);

    }
    public static ArrayList<Integer> createList1(){
        ArrayList<Integer> list1 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);

        return list1;

    }
    public static ArrayList<Integer> createList2(ArrayList<Integer> list1 ){
        ArrayList<Integer> list2 = new ArrayList<>();

        ListIterator<Integer> itr = list1.listIterator(list1.size());


        while(itr.hasPrevious()){
            list2.add(itr.previous());
        }
        return list2;
    }



}

