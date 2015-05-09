package com.lyricaloriginal.f2matrixanalyzer;

/**
 * 解析結果をまとめたクラスです。
 * 
 * @author LyricalMaestro
 * 
 */
public final class Report {

	private int[][] _inverse = null;
	private int[][] _generalizedInverse = null;

	private int[][] _kernelVectors = null;

	/**
	 * コンストラクタ。<BR>
	 * 可逆行列が存在する場合に使用します。
	 * 
	 * @param inverse
	 *            逆行列
	 */
	Report(int[][] inverse) {
		_inverse = inverse;
		_generalizedInverse = inverse;
	}

	/**
	 * コンストラクタ<BR>
	 * 可逆行列が存在しない場合に使用します。
	 * 
	 * @param generalizedInverse
	 *            一般化逆行列
	 * @param kernelVectors
	 *            Kernel空間を構成するベクトル
	 */
	Report(int[][] generalizedInverse, int[][] kernelVectors) {
		_generalizedInverse = generalizedInverse;
		_kernelVectors = kernelVectors;
	}

	/**
	 * 逆行列を取得します。
	 * 
	 * @return 逆行列。逆行列が存在しなかった場合はnullを返す。
	 */
	public int[][] getInverseMatrix() {
		return _inverse != null ? _inverse.clone() : null;
	}

	/**
	 * 一般化逆行列を取得します。<BR>
	 * この一般化逆行列Fは、入力行列Aに対してFAが<BR>
	 * 準対角化された状態になるようなものである。 TODO: この「準対角化」された行列についての記載をどこかにする。
	 * 
	 * @return 一般化逆行列
	 */
	public int[][] getGeneralizedInverse() {
		return _generalizedInverse.clone();
	}

	/**
	 * 入力行列Aに対するKernelの次元を取得します。<BR>
	 * つまり、Ax = 0 を満たすn次元ベクトルx全体の次元を取得します。
	 * 
	 * @return Kernelの次元
	 */
	public int getKernelDim() {
		return _kernelVectors != null ? _kernelVectors.length : 0;
	}

	/**
	 * 入力行列Aに対するKernel空間内の一次独立なベクトル達を取得します。
	 * 
	 * @return 一次独立なベクトル達
	 */
	public int[][] getKernelVectors() {
		return _kernelVectors != null ? _kernelVectors.clone() : null;
	}
}
