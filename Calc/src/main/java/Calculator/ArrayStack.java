/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

import java.util.Stack;

/**
 *
 * @author ehn19
 */
public class ArrayStack<T> extends Stack {
    private T[] data = null;


    public ArrayStack() {
        data = (T[]) new Object[10];
    }
}
