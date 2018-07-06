package sample;
import java.util.Arrays;
import java.util.List;
import java.io.*;
import java.util.*;

/*
When the lengths are not equal, make the elements 
from the array of the bigger length to be the key 
and then for extra keys just fill in NuLL
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
