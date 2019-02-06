package arrays;

import java.util.Arrays;

public class T63 {
    public static int[] muptiply(int[] a,int[] b){
        int[] res=new int[a.length+b.length];
        int k;
        int t;
        boolean neg=false;
        if (a[0]* b[0]<0){
            neg=true;
        }
        a[0]=Math.abs(a[0]);
        b[0]=Math.abs(b[0]);
        for (int i=a.length-1;i>=0;i--){
            k=res.length-1-(a.length-1-i);
            t=0;
            for (int j=b.length-1;j>=0;j--){
                int z = res[k] + t + a[i] * b[j];
                res[k]= z %10;
                t= z /10;
                k--;
            }
            if (t>0){
                res[k]=t;
            }
        }
        if (neg) {
            for (int i = 0; i < res.length; i++) {
                if (res[i] != 0) {
                    res[i]=-res[i];
                    break;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(muptiply(new int []{1,2,9},new int []{1})));
        System.out.println(Arrays.toString(muptiply(new int []{9,9,9},new int []{1,2,9})));
        System.out.println(Arrays.toString(muptiply(new int []{1,2,3},new int []{0})));
        System.out.println(Arrays.toString(muptiply(new int []{9,6,2,9},new int []{-1,2,9})));
        System.out.println(Arrays.toString(muptiply(new int [1],new int [1])));
        System.out.println(Arrays.toString(muptiply(new int []{1,9,3, 7, 0,7, 7, 2,1},new int[]{-7, 6,1, 8,3,8, 2, 5, 7, 2, 8, 7})));
    }
}