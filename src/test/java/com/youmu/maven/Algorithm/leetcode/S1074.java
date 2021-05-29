package com.youmu.maven.Algorithm.leetcode;

public class S1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[j].length; i++) {
                count += numSubmatrixSumTarget(matrix, i, j, target);
            }
        }
        return count;
    }

    /**
     * matrix[y][x]
     *
     * @param matrix
     * @param startX
     * @param startY
     * @param target
     * @return
     */
    public int numSubmatrixSumTarget(int[][] matrix, int startX, int startY, int target) {
        int count = 0;
        int[][] sumMap = new int[matrix.length - startY][matrix[0].length - startX];
        for (int j = startY; j < matrix.length; j++) {
            int rowSum = 0;
            for (int i = startX; i < matrix[j].length; i++) {
                rowSum += matrix[j][i];
                int matrixSum = rowSum;
                if (j > startY) {
                    //不是第一行加上一行的结果
                    matrixSum += sumMap[j - startY - 1][i - startX];
                }
                sumMap[j - startY][i - startX] = matrixSum;
                if (matrixSum == target) {
                    count++;
                }
            }
        }
        return count;
    }

    public int sum(int[][] matrix, int startX, int endX, int startY, int endY) {
        int sum = 0;
        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                sum += matrix[i][j];
            }
        }
        System.out.printf("matrix(%d,%d,%d,%d)=%d\n", startX, startY, endX, endY, sum);
        return sum;
    }


    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        System.out.println(new S1074().numSubmatrixSumTarget(matrix, 0));
    }
}
