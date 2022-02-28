package com.wzx.pro.question;

import com.google.common.collect.Lists;

import java.util.List;

public class Q22_c {

    public static  List<String> solution(int num){
        List<String> result =Lists.newArrayList();
        int leftCount =0;
        int rightCount =0;
        back(result,num,"",leftCount,rightCount);
        return result;
    }

    private static void back(List<String> result,int num,String str,int leftCount,int rightCount){
        if(str.length()==num*2){
            result.add(str);
            return;
        }
        if(leftCount<num){
            back(result,num,str+"(",leftCount+1,rightCount);
        }
        if(rightCount<leftCount){
            back(result,num,str+")",leftCount,rightCount+1);
        }
    }

    public static void main(String[] args) {
        List<String> solution = solution(3);
        System.out.println(solution);
    }

}