package com.collections;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// new line added 
public class CollectionTest {

    public static void main(String args[]){

        Logger logger = LogManager.getLogger(CollectionTest.class);

        //UUID num = new UUID();
        System.out.println(Math.random());
        System.out.println(Math.random());
        System.out.println(Math.random());
        System.out.println(Math.random());
        System.out.println(Math.random());

        for (int i = 0; i < 15; i++) {

            System.out.println(UUID.randomUUID());
        }


        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("Raju");
        list2.add("Ravi");
        list2.add("Ramu");
        for (String str1 : cars) {
            System.out.println(str1);
        }


        ArrayList<Integer>  list1 = new ArrayList<Integer>();
        list1.add(10);
        list1.add(20);
        list1.add(10);
        list1.add(20);
        System.out.println(list1);
        System.out.println(list1.get(0));
        int I =0, J=1 ;
        while(I < list1.size())
        {
            int data1 = list1.get(I);
            while(J < list1.size())
            {
                int data2 = list1.get(J);
                 if(data1==data2) {
                     list1.remove(I);
                 }
                 J = J+1;
            }
            I = I +1;
        }
        System.out.println(list1);

        /*
        Stack<String> stack = new Stack<>();
        stack.add("Siddu");
        stack.push("Naveen");
        stack.push("Ganesh");
        System.out.println(stack);
        stack.empty();
        System.out.println(stack);
        stack.peek();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
  */
        /*
        List <data-type> list1= new ArrayList();
        List <data-type> list2 = new LinkedList();
        List <data-type> list3 = new Vector();
        List <data-type> list4 = new Stack();
         */

    }
}
