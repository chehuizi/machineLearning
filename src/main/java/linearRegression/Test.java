package linearRegression;

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
			GradientDescent.batchGD(arrX, arrY, 0.1, 0.05);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
