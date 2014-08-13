/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.os.rh.util;

/**
 *
 * @author 'Pedro
 */
public class FatorialRecursivo {
    
    
    public static int fatorialRecursivo(int n){
        int fat=1;
        if(n>0){
            fat = n* fatorialRecursivo(n-1);
        } else {
            return fat;
        }
        return fat;
    }
    
    public static int fatorialIterativo(int n){
        int fat = 1;
        for (int i = n; i > 0; i--) {
            fat = fat * i;            
        }
        return fat;
    }
    
    public static void main(String[] args) {
        System.out.println(fatorialRecursivo(5));
    }
}
