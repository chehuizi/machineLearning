package linearRegression;

public class CommonUtils {
	public static void print(double[][] input) {
		for (int i=0; i<input.length; i++) {
			String str = "";
			for (int j=0; j<input[i].length; j++) {
				str += input[i][j] + " ";
			}
			System.out.println(str);
		}
	}
	
	public static void print(double[] input) {
		String str = "";
		for (int i=0; i<input.length; i++) {
			str += input[i] + " ";
		}
		System.out.println(str);
	}
	
	public static void scale(double[][] input) {
		for (int j=0; j<input[0].length; j++) {
			double avg = 0;
			for (int i=0; i<input.length; i++) {
				avg += input[i][j];
			}
			avg = avg/input.length;
			
			double vv = 0;
			for (int i=0; i<input.length; i++) {
				vv += (input[i][j] - avg) * (input[i][j] - avg);
			}
			vv = vv/input.length;
			
			for (int i=0; i<input.length; i++) {
				if (vv == 0) {
					input[i][j] = input[i][j]/avg;
				} else {
					input[i][j] = (input[i][j] - avg)/Math.sqrt(vv);
				}
			}
		}
	}
	
	public static void scale(double[] input) {
		double avg = 0;
		for (int i=0; i<input.length; i++) {
			avg += input[i];
		}
		avg = avg/input.length;
		
		double vv = 0;
		for (int i=0; i<input.length; i++) {
			vv += (input[i] - avg) * (input[i] - avg);
		}
		vv = vv/input.length;
		
		for (int i=0; i<input.length; i++) {
			input[i] = (input[i] - avg)/Math.sqrt(vv);
		}
	}
}
