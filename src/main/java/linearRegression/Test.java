package linearRegression;

import linearRegression.model.LinearModel;

public class Test {
	public static void main(String args[]) {
		double[][] arrX = {{1,2104,3},
				{1,1600,3},
				{1,2400,3},
				{1,1416,2},
				{1,3000,4}};
		double[] arrY = {400,330,369,232,540};
		try {
			GradientDescent gd = new GradientDescent();
			LinearModel lm = new LinearModel();
			lm.setInput(arrX);
			lm.setOutput(arrY);
			lm.setDeviation(0.0145);
			lm.setStep(0.1);
			gd.setLinearModel(lm);
			lm.scale();
			gd.batchGD();
			gd.verify();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
