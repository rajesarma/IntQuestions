package com.lakshmi.interviews.dell;

public class RotationPossible {
    public static void main(String[] args) {
        String s = "Lakshmi";
        String goal = "akshmiL";
        boolean ans = new RotationPossible().rotateString(s, goal);
        System.out.println(ans);
    }

    public boolean rotateString(String s, String goal) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (goal.equals(shift(s, i))) {
                return true;
            }
        }
        return false;
    }

    private String shift(String s, int num) {
        int length = s.length();
        String s1 = s.substring(length-num, length) + s.substring(0, length-num);
        return s1;
    }
}
