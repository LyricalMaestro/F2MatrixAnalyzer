package com.lyricaloriginal.f2matrixanalyzer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

/**
 * Analyzerクラスのテストクラスです。<BR>
 * このクラスではKernel空間を構成する基底についてのテストを行います。
 * 
 * @author LyricalMaestro
 * 
 */
public class AnalyzerTest3 {
	@Test
	public void analize2D1() {
		//@formatter:off
		int[][] inputMatrix = new int[][]{
				{1, 0},
				{0, 1}
			};
		//@formatter:on

		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		assertThat(report.getKernelVectors(), nullValue());
	}

	@Test
	public void analize2D2() {
		//@formatter:off
		int[][] inputMatrix = new int[][] { 
				{ 1, 1 }, 
				{ 1, 1 }
			};
		int[][] kernelvectors = new int[][] { 
				{ 1, 1 }
			};
		//@formatter:on

		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		assertThat(report.getKernelVectors(), is(kernelvectors));
	}

	@Test
	public void analize3D1() {
		//@formatter:off
		int[][] inputMatrix = new int[][] { 
				{ 0, 1, 1 }, 
				{ 1, 0, 0 },
				{ 1, 1, 0 } 
			};
		//@formatter:on

		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		assertThat(report.getKernelVectors(), nullValue());
	}

	@Test
	public void analyze3D2() {
		//@formatter:off
		int[][] inputMatrix = new int[][] {
				{ 0, 1, 1 }, 
				{ 1, 0, 1 },
				{ 1, 1, 0 }
			};
		int[][] kernelvectors = new int[][] { 
				{ 1, 1, 1 }
			};
		//@formatter:on

		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		assertThat(report.getKernelVectors(), is(kernelvectors));
	}

	@Test
	public void analyze4D1() {
		//@formatter:off
		int[][] inputMatrix = new int[][] {
				{ 1, 1, 1, 1 },
				{ 0, 1, 1, 1 },
				{ 0, 1, 1, 1 },
				{ 0, 1, 1, 1 },
			};
		int[][] kernelVectors = new int[][] { 
				{ 0, 1, 1, 0 },
				{ 0, 1, 0, 1 }
			};
		//@formatter:on

		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		assertThat(report.getKernelVectors(), is(kernelVectors));
	}

	@Test
	public void analyze16D1() {
		//@formatter:off
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
		int[][] kernelVectors = new int[][] {
				{ 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0 },
				{ 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0 },
				{ 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1 },
		};
		//@formatter:on

		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		assertThat(report.getKernelVectors(), is(kernelVectors));
	}
}
