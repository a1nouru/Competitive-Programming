package sample;
import java.util.Arrays;
import java.util.List;
import java.io.*;
import java.util.*;
import java.util.LinkedList;


/**
 *****QUESTION******
 Remove Dups: Write code to remove duplicates from an unsorted linked list. FOLLOW UP
 How would you solve this problem if a temporary bu er is not allowed?

 EXPLANATION:
 The approach here is we are being naive about what the linkedlist contains but before this
 I confirm with my interviewer. I was first tempted to use the THE RUNNER TECHNIQUE
 or RECURSIVE technique but notice that there is no hint about this in the question.
 
 HINTS BY INTERVIEWER:
 A set should ring a bell when you see "duplicates" in the questions.

 TIME: 
 Big O(N) where N is the number of elements in the linked list.
 */

public class Main {
    static void deleteDuplicate(  LinkedList<Integer>  linkedList)
    {
        if (linkedList == null) return;

        HashSet<Integer> setData = new HashSet<Integer>();

        Iterator tempIter = linkedList.iterator();
        int i = 0;
        while (tempIter.hasNext()) {
            setData.add(linkedList.get(i));
            tempIter.next();
            i++;
        }
        print(setData, linkedList);
    }

    static void print(HashSet<Integer> setData, LinkedList<Integer> linkedList) {
        Iterator tempIter = setData.iterator();
        while (tempIter.hasNext()) {
            System.out.println(tempIter.next() + " ");
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(6);
        linkedList.add(4);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(8);
        linkedList.add(0);
        linkedList.add(0);
        linkedList.add(3);
        deleteDuplicate(linkedList);
    }
}

/*
*****OUTPUT*****
0
1
2
3
4
6
8
 */
