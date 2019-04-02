/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.ya.algo;

/**
 *
 * @author YERLAN
 */
public class OpenSystemsDevelopment {

    public static void main(String[] args) {
        int N = 5;
        int[][] A = {
            {3, 7, 2, 10, 1},
            {6, 8, 2, 9, 7},
            {17, 15, 13, 8, 12},
            {6, 3, 1, 2, 9},
            {7, 8, 5, 1, 2}
        };

        int max = A[0][0];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                if (A[i][j] > max) {
                    max = A[i][j];
                }
            }
        }

        System.out.println(max);
    }
}
