package com.wzx.pro.question;

import java.util.*;

public class Q20_c {

    public static boolean solution(String str) {
        if (str.length() % 2 > 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack stack = new Stack();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            Character left = map.get(c);
            if(left!=null){
                if(stack.isEmpty() || stack.peek()!=left){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "({(){}}){";
        boolean solution = solution(str);
        System.out.println(solution);
    }
}
