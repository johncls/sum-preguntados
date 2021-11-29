/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author jonce
 */
public class SumModel {
    
    private int a;
    private int b;

    public SumModel(int a, int b) {
        this.a = a;
        this.b = b;
    }

    
    
    public int suma(){
     return a+b;
    }
    
}
