package com.lyricaloriginal.f2matrixanalyzer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Analyzerクラスのテストクラスです。<BR>
 * このクラスではKernelの次元、一般化逆行列計算のテストを行います。
 * 
 * @author LyricalMaestro
 * 
 */
public class AnalyzerTest2 {

	@Test
	public void analize2D1() {
		//@formatter:off
		int[][] inputMatrix = new int[][]{
				{1, 0},
				{0, 1}
			};
		int[][] expectedMatrix = new int[][]{
				{1, 0},
				{0, 1}
			};
		//@formatter:on

		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		assertThat(report.getGeneralizedInverse(), is(expectedMatrix));
		assertThat(report.getKernelDim(), is(0));
	}

	@Test
	public void analize2D2() {
		//@formatter:off
		int[][] inputMatrix = new int[][] { 
				{ 1, 1 }, 
				{ 1, 1 }
			};
		int[][] expectedMatrix = new int[][] { 
				{ 1, 0 },
				{ 1, 1 }
			};
		//@formatter:on

		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		assertThat(report.getGeneralizedInverse(), is(expectedMatrix));
		assertThat(report.getKernelDim(), is(1));
	}

	@Test
	public void analize3D1() {
		//@formatter:off
		int[][] inputMatrix = new int[][] { 
				{ 0, 1, 1 }, 
				{ 1, 0, 0 },
				{ 1, 1, 0 } 
			};
		int[][] expectedMatrix = new int[][] { 
				{ 0, 1, 0 }, 
				{ 0, 1, 1 },
				{ 1, 1, 1 } 
			};
		//@formatter:on

		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		assertThat(report.getGeneralizedInverse(), is(expectedMatrix));
		assertThat(report.getKernelDim(), is(0));
	}

	@Test
	public void analyze3D2() {
		//@formatter:off
		int[][] inputMatrix = new int[][] {
				{ 0, 1, 1 }, 
				{ 1, 0, 1 },
				{ 1, 1, 0 }
			};
		int[][] expectedMatrix = new int[][] { 
				{ 0, 1, 0 },
				{ 1, 0, 0 },
				{ 1, 1, 1 }
			};
		//@formatter:on

		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		assertThat(report.getGeneralizedInverse(), is(expectedMatrix));
		assertThat(report.getKernelDim(), is(1));
	}

	@Test
	public void analyze9D1() {
		//@formatter:off
		int[][] inputMatrix = new int[][] {
				{ 1, 1, 0, 1, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 0, 1, 0, 0, 0, 0 }, 
				{ 0, 1, 1, 0, 0, 1, 0, 0, 0 },
				{ 1, 0, 0, 1, 1, 0, 1, 0, 0 }, 
				{ 0, 1, 0, 1, 1, 1, 0, 1, 0 },
				{ 0, 0, 1, 0, 1, 1, 0, 0, 1 },
				{ 0, 0, 0, 1, 0, 0, 1, 1, 0 },
				{ 0, 0, 0, 0, 1, 0, 1, 1, 1 }, 
				{ 0, 0, 0, 0, 0, 1, 0, 1, 1 } 
			};
		int[][] expectedMatrix = new int[][] { 
				{ 1, 0, 1, 0, 0, 1, 1, 1, 0 },
				{ 0, 0, 0, 0, 1, 0, 1, 1, 1 },
				{ 1, 0, 1, 1, 0, 0, 0, 1, 1 },
				{ 0, 0, 1, 0, 1, 1, 0, 0, 1 }, 
				{ 0, 1, 0, 1, 1, 1, 0, 1, 0 },
				{ 1, 0, 0, 1, 1, 0, 1, 0, 0 }, 
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1 },
				{ 1, 1, 1, 0, 1, 0, 0, 0, 0 }, 
				{ 0, 1, 1, 1, 0, 0, 1, 0, 1 } 
			};
		//@formatter:on

		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		assertThat(report.getGeneralizedInverse(), is(expectedMatrix));
		assertThat(report.getKernelDim(), is(0));
	}

	@Test
	public void analyze16D1() {
		int[][] inputMatrix = new int[][] {
				{ 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1 }, };
		int[][] expectedMatrix = new int[][] {
				{ 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0 },
				{ 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0 },
				{ 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0 },

				{ 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0 },

				{ 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 },
				{ 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0 },

				{ 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0 },
				{ 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0 },
				{ 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1 } };

		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		assertThat(report.getGeneralizedInverse(), is(expectedMatrix));
		assertThat(report.getKernelDim(), is(4));
	}
}
