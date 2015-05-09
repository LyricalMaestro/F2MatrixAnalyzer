package com.lyricaloriginal.f2matrixanalyzer;

/**
 * このプログラムを動かすためのメインクラスです。<BR>
 * このプロジェクトをライブラリとして参照する場合には、このクラスを含める必要はありません。
 * 
 * @author LyricalMaestro
 * 
 */
public class Main {

	//@formatter:off
	private static final int[][] DEFAULT_INPUT_MATRIX = new int[][] {
			{ 0, 1, 1, 1 }, 
			{ 1, 1, 1, 0 }, 
			{ 1, 0, 1, 0 }, 
			{ 0, 1, 1, 0 }, 
		};
	//@formatter:on

	public static void main(String[] args) {
		int[][] inputMatrix = createInputMatrix(args);

		printInput(inputMatrix);

		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		printReport(report);

	}

	private static int[][] createInputMatrix(String[] args) {
		if (args == null || args.length == 0) {
			System.out.println("起動時引数を指定しなかったので、デフォルトの入力行列を使用します。");
			return DEFAULT_INPUT_MATRIX;
		}

		// 正方行列の指定
		int size = 0;
		String sizeStr = getValue(args, "-s");
		if (sizeStr.length() == 0) {
			System.out.println("オプション -s には1以上の自然数を指定してください。");
			System.exit(-1);
		}
		try {
			size = Integer.parseInt(sizeStr);
		} catch (NumberFormatException ex) {
			System.out.println("オプション -s には1以上の自然数を指定してください。");
			System.exit(-1);
		}
		if (size < 1) {
			System.out.println("オプション -s には1以上の自然数を指定してください。");
			System.exit(-1);
		}

		// 行列取得
		int[][] matrix = new int[size][];
		String matArray = getValue(args, "-mat");
		if (matArray.length() == 0) {
			System.out.println("オプション -mat には行列要素の値0, 1をカンマ区切りで指定してください。");
			System.exit(-1);
		}
		String[] vals = matArray.split(",");
		if (vals.length != size * size) {
			System.out.println("行列要素の値は" + (size * size) + "個指定してください。");
			System.exit(-1);
		}
		for (int i = 0; i < size; i++) {
			matrix[i] = new int[size];
			for (int j = 0; j < size; j++) {
				int val = -1;
				try {
					val = Integer.parseInt(vals[i * size + j]);
				} catch (NumberFormatException ex) {
					System.out.println(String.format(
							"第(%d, %d)成分[行列要素配列の第%d要素]は整数ではありません。", i + 1,
							j + 1, i * size + j));
					System.exit(-1);
				}
				matrix[i][j] = val % 2;
				if (matrix[i][j] < 0) {
					matrix[i][j] += 2;
				}
			}
		}
		return matrix;
	}

	private static String getValue(String[] args, String optionKey) {
		for (int i = 0; i < args.length - 1; i++) {
			if (optionKey.equals(args[i])) {
				return args[i + 1];
			}
		}
		return "";
	}

	private static void printInput(int[][] inputMatrix) {
		System.out.println("-----------------");
		System.out.println("Input Matrix");
		System.out.println("");
		Utils.printMatrix(inputMatrix);
	}

	private static void printReport(Report report) {
		System.out.println("-----------------");
		System.out.println("Output");
		System.out.println("");
		System.out.println("Inverse:");
		System.out.println("");
		Utils.printMatrix(report.getInverseMatrix());
		System.out.println("");
		if (report.getInverseMatrix() == null) {
			System.out.println("KernelDimension:" + report.getKernelDim());
			System.out.println("GeneralizedInverse:");
			System.out.println("");
			Utils.printMatrix(report.getGeneralizedInverse());
		}
	}
}
