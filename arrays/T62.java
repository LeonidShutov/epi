package arrays;

import java.util.Arrays;

public class T62 {
    public static int[] plusOne(int[] arr){
        int[] res=new int[arr.length];
        //no last nine
        if (arr[arr.length-1]!=9){
            for (int i=0;i<=arr.length-2;i++){
                res[i]=arr[i];
            }
            res[arr.length-1]=arr[arr.length-1]+1;
        } else {
        //there is last nine
            int i=arr.length -1;
            while (arr[i]==9){
                if (i==0){
                    //all nines
                    res=new int[arr.length+1];
                    res[0]=1;
                    for (int j=1;j<res.length;j++){
                        res[j]=0;
                    }
                    return res;
                }
                res[i]=0;
                i--;
            }
            res[i]=arr[i]+1;
            for (int j=0;j<i;j++){
                res[j]=arr[j];
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(plusOne(new int []{1,2,9})));
        System.out.println(Arrays.toString(plusOne(new int []{9,9,9})));
        System.out.println(Arrays.toString(plusOne(new int []{1,2,3})));
        System.out.println(Arrays.toString(plusOne(new int []{9,6,2,9})));
        System.out.println(Arrays.toString(plusOne(new int [1])));
        System.out.println(Arrays.toString(plusOne(new int []{1})));
    }
}