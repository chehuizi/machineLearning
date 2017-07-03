package linearRegression;

import Jama.Matrix;

/**
 * 正规方程式
 * @author chehuizi
 *
 */
public class NormalEquation {
	
	/**
	 * x0: 常数1
	 * x1: size(feet²)
	 * x2: number of bedrooms
	 * x3: number of floors
	 * x4: age of home(years)
	 * y : price($1000)
	 *  x0 |  x1  | x2 | x3 | x4 | y
		1  | 2104 | 5  | 1  | 45 | 460
		1  | 1416 | 3  | 2  | 40 | 232
		1  | 1534 | 3  | 2  | 30 | 315
		1  | 852  | 2  | 1  | 36 | 178
		
		Θ = (X)
	 */
	public static void demo() {
		double[][] arrX = {{1,2104,5,1,45},
						{1,1416,3,2,40},
						{1,1534,3,2,30},
						{1,852,2,1,36},
						{1,3000,4,1,38}};
		double[][] arrY = {{460},{232},{315},{178},{540}};
		
		Matrix X = Matrix.constructWithCopy(arrX);
		Matrix Y = Matrix.constructWithCopy(arrY);
		Matrix transX = X.transpose();
		Matrix exp1 = transX.times(X);
		Matrix exp2 = exp1.inverse();
		Matrix exp3 = exp2.times(transX);
		Matrix ne = exp3.times(Y);
		Matrix rst1 = X.times(ne);
		print(rst1);
		
		Matrix mx4 = exp3.inverse().times(ne);
		print(mx4);
	}
	
	private static void print(Matrix input) {
		double[][] paramArray = input.getArray();
		System.out.println("矩阵:" + paramArray.length + "行" + paramArray[0].length + "列");
		for (int i=0; i<paramArray.length; i++) {
			String output = "";
			for (int j=0; j<paramArray[i].length; j++) {
				output += paramArray[i][j] + ", ";
			}
			output = "[" + output.substring(0, output.length()-2) + "]";
			System.out.println(output);
		}
		
	}
	
	public static void main(String args[]) {
		demo();
	}
	
}
