package com.shihabur.days;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {

    //file required from puzzle
    static File file = new File("input/fuel.txt");

    //runs the method
    public static void main(String[] args){
        getInput();
    }

    public static void getInput(){
        //try-catch to handle exceptions with files
        try {
            String line;
            double sum = 0;
            BufferedReader br = new BufferedReader(new FileReader(file));
            //loop until the line the buffered reader is on is empty.
            while((line = br.readLine()) != null){
                //(mass / 3) - 2, floor is to ensure it is rounded down.
                double mass = Double.parseDouble(line);
                //mass as its own variable will iterate the function for fuel until we reach 0 for 1 module (a line)
                while(mass > 0) {
                    double val = Math.floor(mass / 3) - 2;
                    //if the function != 0 it'll be added onto the sum
                    if (val > 0)
                        sum += val;
                    mass = val;
                }
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
