package linearRegression;

import org.junit.Test;

public class GradientDescentTest {

	@Test
	public void testBatchGD() {
		double[][] input = {{1}, {2}, {3}, {4}, {5}};
		double[] output = {2, 4, 6, 8, 10}; 
		double deviation = 0.0000001;
		double step = 0.18;
		
		GradientDescent gd = new GradientDescent();
		gd.getLinearModel().setInput(input);
		gd.getLinearModel().setOutput(output);
		gd.getLinearModel().setDeviation(deviation);
		gd.getLinearModel().setStep(step);
		
		gd.batchGD();
	}
	
	@Test
	public void testStochasticGD() {
		int size = 30;
		double[][] input = new double[size][];
		double[] output = new double[size];
		double deviation = 0.0000001;
		for (int i=0; i<size; i++) {
			input[i] = new double[]{i+1};
			output[i] = (i+1) * 2;
		}
		double step = 0.18;
		
		GradientDescent gd = new GradientDescent();
		gd.getLinearModel().setInput(input);
		gd.getLinearModel().setOutput(output);
		gd.getLinearModel().setDeviation(deviation);
		gd.getLinearModel().setStep(step);
		
		gd.stochasticGD(1, input, output, step);
	}
}
