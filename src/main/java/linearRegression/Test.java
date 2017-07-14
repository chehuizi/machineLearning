package linearRegression;

import linearRegression.model.LinearModel;

public class Test {
	public static void main(String args[]) {
		double[][] arrX = {{1,2104,3},
				{1,1600,3},
				{1,2400,3},
				{1,1416,2},
				{1,3000,4}};
		CommonUtils.scale(arrX);
		CommonUtils.print(arrX);
		double[] arrY = {400,330,369,232,540};
		CommonUtils.scale(arrY);
		CommonUtils.print(arrY);
		try {
			GradientDescent gd = new GradientDescent();
			LinearModel lm = new LinearModel();
			lm.setInput(arrX);
			lm.setOutput(arrY);
			lm.setDeviation(0.1);
			lm.setStep(0.05);
			gd.setLinearModel(lm);
			gd.batchGD();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
