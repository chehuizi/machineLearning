package linearRegression;

import org.junit.Test;

public class GradientDescentTest {

	@Test
	public void testBatchGD() {
		int paramSize =1;
		double[][] input = {{1}, {2}, {3}, {4}, {5}};
		double[] output = {2, 4, 6, 8, 10}; 
		double deviation = 0.0000001;
		double step = 0.18;
		
		GradientDescent.batchGD(paramSize, input, output, deviation, step);
	}
	
	@Test
	public void testStochasticGD() {
		int paramSize =1;
		int size = 30;
		double[][] input = new double[size][];
		double[] output = new double[size];
		for (int i=0; i<size; i++) {
			input[i] = new double[]{i+1};
			output[i] = (i+1) * 2;
		}
		double step = 0.18;
		
		GradientDescent.stochasticGD(paramSize, input, output, step);
	}
}
