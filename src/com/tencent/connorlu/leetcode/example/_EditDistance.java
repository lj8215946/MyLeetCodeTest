package com.tencent.connorlu.leetcode.example;

public class _EditDistance {

    public static int eidtDistance(String a,String b){

        System.out.println("将字符串:'"+b+"'变为'"+a+"'");

        if(a == null || a.length() ==0){
            return b.length();
        }

        if(b == null || b.length() ==0){
            return a.length();
        }

        int[][] distanceMatrix = new int[a.length()+1][b.length()+1];
        String[][] distanceMathod = new String[a.length()+1][b.length()+1];


        //初始化距离矩阵
        for (int i=0;i<a.length()+1;i++){
            distanceMatrix[i][0]=i;
            if(i>0) {
                distanceMathod[i][0] = distanceMathod[i-1][0] + "*在第" + i+  "号位置之后增加'" +  a.charAt(i - 1) +"'\n";
            }else {
                distanceMathod[i][0] = "";
            }
        }

        for (int i=0;i<b.length()+1;i++){
            distanceMatrix[0][i]=i;
            if(i>0) {
                distanceMathod[0][i] =  distanceMathod[0][i-1] + "*删除第" + i+ "号位置的'"+ b.charAt(i - 1)  +"'\n";
            }else {
                distanceMathod[0][i] = "";
            }
        }

        boolean isSameChar;
        int leftTop;
        int left;
        int top;

        for (int i=2;i<a.length()+b.length()+1;i++){

            for (int j=1;j<i;j++){
                if(j<=a.length() && i-j<=b.length()){
                    if(a.charAt(j-1) == b.charAt(i-j-1)){
                        isSameChar = true;
                        leftTop = distanceMatrix[j-1][i-j-1];
                    }else {
                        isSameChar = false;
                        leftTop = distanceMatrix[j-1][i-j-1]+1;
                    }

                    left = distanceMatrix[j-1][i-j]+1;
                    top = distanceMatrix[j][i-j-1]+1;

                    int minValue = Math.min(Math.min(left,top),leftTop);
                    distanceMatrix[j][i-j] = minValue;

                    if(minValue == leftTop){
                        if(!isSameChar){
                            distanceMathod[j][i-j] = distanceMathod[j-1][i-j-1] + "*在第" + (i-j) + "号位置将'" + b.charAt(i-j-1) +"'更新为'" + a.charAt(j-1)  + "'\n";
                        }else {
                            distanceMathod[j][i-j] = distanceMathod[j-1][i-j-1];
                        }
                    }else if(minValue == top){
                        distanceMathod[j][i-j] = distanceMathod[j][i-j-1] + "*删除第" + (i-j) + "号位置的'"+ b.charAt(i-j-1) +"'\n";
                    }else {
                        distanceMathod[j][i-j] = distanceMathod[j-1][i-j] + "*在第" + (i-j) + "号位置之后增加'" + a.charAt(j-1) +"'\n";
                    }

                }
            }
        }
        System.out.println("共编辑:"+distanceMatrix[a.length()][b.length()]+"次");
//        System.out.println("距离矩阵:"+distanceMatrix);
        System.out.println("具体操作方法如下:\n"+distanceMathod[a.length()][b.length()]);
        return distanceMatrix[a.length()][b.length()];
    }


    public static void main(String[] args){
        eidtDistance("abcde","afbg");

        eidtDistance("abcde","abce");

        eidtDistance("abce","abcbe");

        eidtDistance("我爱你中国","我爱中国你");
    }

}
