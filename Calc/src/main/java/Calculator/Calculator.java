/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ehn19
 */
public class Calculator {
    
    static ArrayStack<Integer> nums = new ArrayStack();

    public static void main(String[] args) {

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter values:" + "\n");
            String s = " ";

            while (!s.equals("x")) {
                s = br.readLine();

                String[] arr = s.split(" ");

                cal(arr);
            }

        } catch (IOException ex) {
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void print(ArrayStack<Integer> list) {
        if (list.isEmpty()) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println("> " + list.get(i));
        }

        list.clear();
    }

    public static void cal(String[] arr) {
        ArrayList<String> operands = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("+") && !arr[i].equals("-") && !arr[i].equals("/") && !arr[i].equals("*")) {
                nums.push(arr[i]);
            }
            operands.add(arr[i]);
        }

        for (int i = 0; i < operands.size(); i++) {

            String operand = operands.get(i);
            operands.remove(i);
            i = 0;

            switch (operand) {

                case "+":
                    Integer sumfirstStack = Integer.parseInt(nums.pop().toString());
                    Integer sumnextStack = Integer.parseInt(nums.pop().toString());
                    nums.push(sumfirstStack + sumnextStack);
                    break;
                case "-":
                    int subfirstStack = Integer.parseInt(nums.pop().toString());
                    int subnextStack = Integer.parseInt(nums.pop().toString());
                    nums.push(subfirstStack - subnextStack);
                    break;
                case "*":
                    int addfirstStack = Integer.parseInt(nums.pop().toString());
                    int addnextStack = Integer.parseInt(nums.pop().toString());
                    nums.push(addfirstStack * addnextStack);
                    break;

                case "/":
                    int divfirstStack = Integer.parseInt(nums.pop().toString());
                    int divnextStack = Integer.parseInt(nums.pop().toString());
                    nums.push(divfirstStack / divnextStack);
                    break;
            }

        }

        print(nums);
    }
}
