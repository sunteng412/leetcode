package com.qingxuan.algorithm;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个共有
 *  阶的楼梯，你每步可以上
 *  阶或者
 *  阶，请问有多少种方案可以爬到楼顶？
 *  https://www.hello-algo.com/chapter_dynamic_programming/intro_to_dynamic_programming/
 * */
public class ClimbStairs {

    public static void main(String[] args) {

        //方案1
        Plan plan = new Backtracking();
        System.out.println(plan.getStep(0, new ArrayList<>(List.of(1, 2)), 3));
    }

    interface Plan{

        int getStep(int startN, List<Integer> choices,int endN);

    }

    /**
     * 回溯算法
     * */
    @Data
    static class Backtracking implements Plan{


        @Override
        public int getStep(int startN, List<Integer> choices,int endN) {
            List<Integer> resp = new ArrayList<>();
            resp.add(0); // 使用 res[0] 记录方案数量
            backtrack(choices, startN, endN, resp);
            return resp.getFirst();
        }

        /**
         * 比如3阶，步进1/2
         *
         * */
        private void backtrack(List<Integer> choices, int startN, int endN, List<Integer> resp) {
//            if(startN > endN){
//                return;
//            }
//            if(startN == endN){
//                resp.set(0, resp.get(0) + 1);
//                return;
//            }

            for (Integer choice : choices) {
                if(startN + choice > endN){
                    return;
                } else if(startN + choice == endN){
                    resp.set(0, resp.getFirst() + 1);
                }
                backtrack(choices, startN + choice, endN, resp);
            }






//            if (startN > endN) {
//                return;
//            }
//            if (startN == endN) {
//                resp.set(0, resp.get(0) + 1);
//                return;
//            }
//            for (Integer choice : choices) {
//                backtrack(choices, startN + choice, endN, resp);
//            }

        }
    }
}
