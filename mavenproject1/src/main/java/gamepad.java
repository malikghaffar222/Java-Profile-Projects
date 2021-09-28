/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class gamepad {
    public void gameped(){
    //int[] L1={1,2,3,4,5,6,7,8,9,10};
    String paid[][]=new String[10][10];
    for(int i=0;i>paid.length;i++)
        for(int j=0;j<i;j++)
        {
        if((i==1 && j==3)||(i==7 && j==6)||(i==3 && j==7))
        {
            paid[i][j]="E";
            System.out.println("E");
        }
        else
        {
            paid[i][j]="-";
        System.out.println("-");}
        }}
    }
    
