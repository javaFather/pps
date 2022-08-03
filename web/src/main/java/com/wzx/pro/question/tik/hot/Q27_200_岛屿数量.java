package com.wzx.pro.question.tik.hot;

import java.util.LinkedList;
import java.util.Queue;

public class Q27_200_岛屿数量 {

    /**
     * 深度优先
     *
     * @param nums
     * @return
     */
    private static int solution(char[][] nums) {
        int max = 0;
        int rowLength = nums.length;
        int colLength = nums[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (nums[i][j] == '1') {
                    dfs(nums, i, j);
                    max++;
                }
            }
        }
        return max;
    }

    private static void dfs(char[][] nums, int i, int j) {
        if (i < 0 || j < 0 || i > nums.length - 1 || j > nums[0].length - 1 || nums[i][j] == '0') {
            return;
        }
        nums[i][j] = '0';
        dfs(nums, i - 1, j);
        dfs(nums, i + 1, j);
        dfs(nums, i, j - 1);
        dfs(nums, i, j + 1);
    }


    public static void main(String[] args) {
        char[][] nums = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int solution = solution2(nums);
        System.out.println(solution);
    }

    /**
     * 广度优先
     *
     * @param nums
     * @return
     */
    private static int solution2(char[][] nums) {
        int max = 0;
        int rowLength = nums.length;
        int colLength = nums[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (nums[i][j] == '1') {
                    bfs(nums, i, j);
                    max++;
                }
            }
        }
        return max;
    }

    private static void bfs(char[][] nums, int i, int j) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            i = cur[0];
            j = cur[1];
            if (i >= 0 && j >= 0 && i < nums.length && j < nums[0].length && nums[i][j] == '1') {
                nums[i][j] = '0';
                queue.add(new int[]{i + 1, j});
                queue.add(new int[]{i - 1, j});
                queue.add(new int[]{i, j - 1});
                queue.add(new int[]{i, j + 1});
            }

        }
    }
}
