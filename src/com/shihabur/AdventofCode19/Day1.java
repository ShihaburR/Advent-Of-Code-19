package com.shihabur.AdventofCode19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1 {
    static List<Double> fuels = new ArrayList<>();
    static File file = new File("input/fuel.txt");
    public static void main(String[] args){
        getInput();
    }

    public static void getInput(){
        try {
            String line;
            double sum = 0;
            double val;
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                val = Math.floor(Double.parseDouble(line) / 3) - 2;
                sum += val;
                while(val > 0){
                    val = Math.floor(val / 3) - 2;
                    sum += val;
                }
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void workFuel(){
        double sum = 0;
        double val = 0;
        for(double i : fuels){
            val += Math.floor(i/3) - 2;
            while (val > 3) {
                val += Math.floor(i / 3) - 2;
                sum += val;
            }
            sum += val;
        }
        System.out.println(sum);
    }
}
