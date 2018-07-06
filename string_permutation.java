package sample;
import java.util.Arrays;
import java.util.List;
import java.io.*;
import java.util.*;

/*
Given a smaller strings and a bigger string b, design an algorithm
to  nd all permuta­ tions of the shorter string within the longer one

 s: abbc
b: cbabadcbbabbcbabaabccbabc
 */
public class Main {

    public static void main(String[] args) {
        int counter = 0;
        String bigStr = "cbabadcbbabbcbababbccbabc";
        String smallStr = "abbc";
        String tempStr = "";
        Boolean enter = false;
        int tempIndex;
        for(int i = 0; i<bigStr.length()-smallStr.length(); i++)
        {
            tempStr = bigStr.substring(i, i+smallStr.length());

            if(smallStr.equals(tempStr)){
                counter++;
            }
        }

        System.out.println(counter);
    }
}
