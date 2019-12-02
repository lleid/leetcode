package com.leo.leetcode;

public class RobotReturnToOrigin_657 {
    public boolean judgeCircle(String moves) {
        int xCount = 0;
        int yCount = 0;
        for (int i = 0; i < moves.toCharArray().length; i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    xCount += 1;
                    break;
                case 'D':
                    xCount += -1;
                    break;
                case 'L':
                    yCount += 1;
                    break;
                case 'R':
                    yCount += -1;
                    break;
                default:
                    break;
            }
        }

        return xCount == 0 && yCount == 0;
    }


    public static void main(String[] args) {
        RobotReturnToOrigin_657 test = new RobotReturnToOrigin_657();
        boolean flag = test.judgeCircle("UDL");
        System.out.println(flag);
    }
}
