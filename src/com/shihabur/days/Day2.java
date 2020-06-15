package com.shihabur.days;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day2 {

    static File file = new File("input/intcode.txt");

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String input = br.readLine();
            //each value is separated via split based on ","
            String[] strInputs = input.split(",");
            //lambda expression where string array is converted to a int array
            int[] inputs = Arrays.stream(strInputs).mapToInt(Integer::parseInt).toArray();
            boolean run = true;
            //counter allows the positions to be assigned appropriately within the inputs
            int counter = 0;
            while (run) {
                int opcode = inputs[counter];
                int pos1;
                int pos2;
                int val;
                //if the operation is 1 it will do an add function
                if (opcode == 1) {
                    pos1 = inputs[counter + 1];
                    pos2 = inputs[counter + 2];
                    val = inputs[pos1] + inputs[pos2];
                    inputs[counter + 3] = val;
                }
                //if the operation is 2 it will do an multiply function
                else if (opcode == 2) {
                    pos1 = inputs[counter + 1];
                    pos2 = inputs[counter + 2];
                    val = inputs[pos1] * inputs[pos2];
                    inputs[counter + 3] = val;
                }
                //if it is neither 1 or 2 it can only be 99 meaning end of program
                else {run = false;}
                counter += 4;
            }
        } catch(IOException e){ e.printStackTrace();}
    }

}
