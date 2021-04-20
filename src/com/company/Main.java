package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        boolean out = false;
        boolean inside = false;
        int count = 0;
        ArrayList<Character> result = new ArrayList<Character>();

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the sequence:");

        String sequence = myObj.nextLine();
        char[] mySequence = sequence.toCharArray();

        for (int i = 0; i<mySequence.length; i++){

            if(mySequence[i] == '(' && out == true){
                inside = true;
                count = count + 1;
//                System.out.println(count + ":" + i + inside + out);
            }

             if(mySequence[i] == '(' && out == false){
                out = true;
                mySequence[i] = 'A';
                continue;

            }

            if(mySequence[i] == ')' && inside == true){
                if(count == 0)
                {
                    inside = false;
                    mySequence[i] = 'A';
                    out = false;
                    continue;
                }
                count = count - 1;
//                System.out.println(count + ":" + i + inside + out);
            }

            if(mySequence[i] == ')' && out == true && inside == false ){
                out = false;
                mySequence[i] = 'A';
            }

        }

        for(int i = 0; i<mySequence.length; i++){
            if (mySequence[i] != 'A'){
                result.add(mySequence[i]);
            }
        }

        String resultString = result.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining("", "", ""));
        System.out.println(resultString);


    }
}
