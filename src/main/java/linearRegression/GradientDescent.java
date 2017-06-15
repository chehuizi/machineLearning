package linearRegression;

public class GradientDescent {
	
	/**
	 * h(x) = m0 + m1*x1
	 * 步长: 0.5
	 * input: (1, 2), (2, 4), (3, 6), (4, 8), (5, 10)
	 * 误差: 0.01
	 */
	public void calc() {
		double m1 = 0, m0 = 0;
		double[][] input = {{1, 2}, {2, 4}, {3, 6}, {4, 8}, {5, 10}};
		double deviation = 0.0000001;
		double step = 0.15;
		
		double dd = 0;
		int times = 0;
		do {
			times++;
			dd = 0;
			for (int i=0; i<input.length; i++) {
				double x = input[i][0];
				double y = input[i][1];
				double h = m0 + m1 * x;
				dd += (h - y) * (h - y);
			}
			dd = 1.0/2.0 * 1/input.length * dd;
			if (dd > deviation) {
				double temp = 0;
				for (int i=0; i<input.length; i++) {
					temp += (m0 + m1 * input[i][0] - input[i][1]) * 1;
				}
				m0 = m0 - step * 1/input.length * temp;
				temp = 0;
				for (int i=0; i<input.length; i++) {
					temp += (m0 + m1 * input[i][0] - input[i][1]) * input[i][0];
				}
				m1 = m1 - step * 1/input.length * temp;
			}
			System.out.println("dd=" + dd + ", m0=" + m0 + ", m1=" + m1 + ", times=" + times);
		} while (dd > deviation);
	}
	
	
	public static void main(String args[]) {
		GradientDescent gd = new GradientDescent();
		gd.calc();
	}
}
