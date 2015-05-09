package com.lyricaloriginal.f2matrixanalyzer;

import org.junit.Test;

import com.lyricaloriginal.f2matrixanalyzer.Analyzer;
import com.lyricaloriginal.f2matrixanalyzer.Report;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * analyzerクラスのテストクラスです。<BR>
 * このクラスでは逆行列計算のテストを行います。
 * 
 * @author LyricalMaestro
 * 
 */
public class AnalyzerTest1 {

	@Test
	public void analyze2D1() {
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

		assertThat(report.getInverseMatrix(), is(expectedMatrix));
	}

	@Test
	public void analyze2D2() {
		//@formatter:off
		int[][] inputMatrix = new int[][]{
				{0, 1},
				{1, 0}
			};
		int[][] expectedMatrix = new int[][]{
				{0, 1},
				{1, 0}
			};
		//@formatter:on

		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		assertThat(report.getInverseMatrix(), is(expectedMatrix));
	}

	@Test
	public void analyze2D3() {
		//@formatter:off
		int[][] inputMatrix = new int[][]{
				{1, 1},
				{0, 0}
			};
		//@formatter:on		
		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		assertThat(report.getInverseMatrix(), nullValue());
	}

	@Test
	public void analyze3D1() {
		//@formatter:off
		int[][] inputMatrix = new int[][]{
				{0, 0, 1},
				{1, 0, 0},
				{0, 1, 0}
			};
		int[][] expectedMatrix = new int[][]{
				{0, 1, 0},
				{0, 0, 1},
				{1, 0, 0}
			};
		//@formatter:on

		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		assertThat(report.getInverseMatrix(), is(expectedMatrix));
	}

	@Test
	public void analyze3D2() {
		//@formatter:off
		int[][] inputMatrix = new int[][]{
				{0, 1, 1},
				{1, 0, 0},
				{1, 1, 0}
			};
		int[][] expectedMatrix = new int[][]{
				{0, 1, 0},
				{0, 1, 1},
				{1, 1, 1}
			};
		//@formatter:on

		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		assertThat(report.getInverseMatrix(), is(expectedMatrix));
	}

	@Test
	public void analyze3D3() {
		//@formatter:off
		int[][] inputMatrix = new int[][]{
				{0, 1, 1},
				{1, 0, 1},
				{1, 1, 0}
			};
		//@formatter:on

		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		assertThat(report.getInverseMatrix(), nullValue());
	}

	@Test
	public void analyze4D1() {
		//@formatter:off
		int[][] inputMatrix = new int[][]{
				{1, 1, 1, 0},
				{1, 1, 0, 1},
				{1, 0, 1, 1},
				{0, 1, 1, 1}
			};
		int[][] expectedMatrix = new int[][]{
				{1, 1, 1, 0},
				{1, 1, 0, 1},
				{1, 0, 1, 1},
				{0, 1, 1, 1}
			};
		//@formatter:on

		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		assertThat(report.getInverseMatrix(), is(expectedMatrix));
	}

	@Test
	public void analyze9D1() {
		//@formatter:off
		int[][] inputMatrix = new int[][]{
				{1, 1, 0, 1, 0, 0, 0, 0, 0},
				{1, 1, 1, 0, 1, 0, 0, 0, 0},
				{0, 1, 1, 0, 0, 1, 0, 0, 0},
				{1, 0, 0, 1, 1, 0, 1, 0, 0},
				{0, 1, 0, 1, 1, 1, 0, 1, 0},
				{0, 0, 1, 0, 1, 1, 0, 0, 1},
				{0, 0, 0, 1, 0, 0, 1, 1, 0},
				{0, 0, 0, 0, 1, 0, 1, 1, 1},
				{0, 0, 0, 0, 0, 1, 0, 1, 1}
			};
		int[][] expectedMatrix = new int[][]{
				{1, 0, 1, 0, 0, 1, 1, 1, 0},
				{0, 0, 0, 0, 1, 0, 1, 1, 1},
				{1, 0, 1, 1, 0, 0, 0, 1, 1},
				{0, 0, 1, 0, 1, 1, 0, 0, 1},
				{0, 1, 0, 1, 1, 1, 0, 1, 0},
				{1, 0, 0, 1, 1, 0, 1, 0, 0},
				{1, 1, 0, 0, 0, 1, 1, 0, 1},
				{1, 1, 1, 0, 1, 0, 0, 0, 0},
				{0, 1, 1, 1, 0, 0, 1, 0, 1}
			};
		//@formatter:on

		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		assertThat(report.getInverseMatrix(), is(expectedMatrix));
	}

	@Test
	public void analyze16D1() {
		//@formatter:off
		int[][] inputMatrix = new int[][]{
				{1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0},
				{0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0},
				{0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1},
				{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1},
			};
		//@formatter:on

		Analyzer analyzer = new Analyzer(inputMatrix);
		Report report = analyzer.analyze();

		assertThat(report.getInverseMatrix(), nullValue());
	}
}
