package com.lyricaloriginal.f2matrixanalyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * 有限体F_2係数 n次元正方行列Aの解析を行うためのクラスです。<BR>
 * 解析内容は、<BR>
 * ・逆行列の計算 ・Ax = 0となるF_2ベクトルの次元 です。
 * 
 * @author LyricalMaestro
 * 
 */
public class Analyzer {

	private int[][] _leftSide;
	private int[][] _rightSide;
	private final int _dim;

	/**
	 * コンストラクタ
	 * 
	 * @param input
	 *            解析対象行列
	 */
	public Analyzer(int[][] input) {
		_leftSide = input;
		_dim = _leftSide.length;
		_rightSide = new int[_dim][];
		for (int i = 0; i < _dim; i++) {
			_rightSide[i] = new int[_dim];
			for (int j = 0; j < _dim; j++) {
				_rightSide[i][j] = i == j ? 1 : 0;
			}
		}
	}

	/**
	 * 解析を行います。
	 * 
	 * @return 解析結果
	 */
	public Report analyze() {
		// 掃き出し法で解析対象行列を上三角行列形式に変形する。
		for (int i = 0; i < _dim; i++) {
			pivod(i);
			calc(i);
		}

		// 準対角化する。
		for (int i = _dim - 1; 0 < i; i--) {
			calc2(i);
		}

		// 可逆行列の場合と不可逆の場合で処理を分ける。
		int kernelDim = calcKernelDim();
		if (kernelDim == 0) {
			// Kernelの次元が0なら可逆
			return new Report(_rightSide);
		} else {
			int[][] kernelVectors = createKernelVectors();
			return new Report(_rightSide, kernelVectors);
		}
	}

	private void pivod(int colNo) {
		if (_leftSide[colNo][colNo] != 0) {
			return;
		}

		for (int i = colNo + 1; i < _dim; i++) {
			if (_leftSide[i][colNo] != 0) {
				swapRow(colNo, i);
				return;
			}
		}
	}

	private void calc(int colNo) {
		if (_leftSide[colNo][colNo] == 0) {
			return;
		}

		for (int i = colNo + 1; i < _dim; i++) {
			if (_leftSide[i][colNo] != 0) {
				addRow(i, colNo);
			}
		}
	}

	private int calcKernelDim() {
		int kernelDim = 0;
		for (int i = 0; i < _dim; i++) {
			if (_leftSide[i][i] == 0) {
				kernelDim++;
			}
		}
		return kernelDim;
	}

	private int[][] createKernelVectors() {
		List<int[]> kernelVectors = new ArrayList<int[]>();
		for (int i = 0; i < _dim; i++) {
			if (_leftSide[i][i] == 0) {
				int[] vec = new int[_dim];
				for (int j = 0; j < _dim; j++) {
					vec[j] = _leftSide[j][i];
				}
				vec[i] = 1;
				kernelVectors.add(vec);
			}
		}
		return kernelVectors.toArray(new int[0][]);
	}

	private void calc2(int colNo) {
		if (_leftSide[colNo][colNo] == 0) {
			return;
		}

		for (int i = colNo - 1; 0 <= i; i--) {
			if (_leftSide[i][colNo] != 0) {
				addRow(i, colNo);
			}
		}
	}

	private void addRow(int targetCol, int inputCol) {
		for (int i = 0; i < _dim; i++) {
			int temp = _leftSide[targetCol][i];
			_leftSide[targetCol][i] = (temp + _leftSide[inputCol][i]) % 2;

			temp = _rightSide[targetCol][i];
			_rightSide[targetCol][i] = (temp + _rightSide[inputCol][i]) % 2;
		}
	}

	private void swapRow(int colNo1, int colNo2) {
		for (int i = 0; i < _dim; i++) {
			int temp = _leftSide[colNo1][i];
			_leftSide[colNo1][i] = _leftSide[colNo2][i];
			_leftSide[colNo2][i] = temp;

			temp = _rightSide[colNo1][i];
			_rightSide[colNo1][i] = _rightSide[colNo2][i];
			_rightSide[colNo2][i] = temp;
		}
	}
}
