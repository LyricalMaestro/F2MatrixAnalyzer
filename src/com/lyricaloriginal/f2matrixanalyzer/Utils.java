package com.lyricaloriginal.f2matrixanalyzer;

/**
 * 行列に関する操作をまとめたクラスです。
 * 
 * @author LyricalMaestro
 * 
 */
public class Utils {

	/**
	 * 入力した行列の要素を標準出力に出力します。
	 * 
	 * @param target
	 *            入力した行列
	 */
	public static void printMatrix(int[][] target) {
		if (target == null) {
			System.out.println("NULL");
			return;
		}

		int n = target.length;
		for (int i = 0; i < n; i++) {
			int m = target[i].length;
			for (int j = 0; j < m; j++) {
				System.out.print(target[i][j]);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
