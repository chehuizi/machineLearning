package linearRegression;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import linearRegression.model.LinearModel;

/**
 * 梯度下降算法
 * 批量梯度下降
 * 随机梯度下降
 * @author chehuizi
 *
 */
public class GradientDescent {
	
	private static final Logger logger = LogManager.getLogger(GradientDescent.class);
	
	private LinearModel linearModel;
	/**
	 * h(x) = m0 + m1*x1
	 * 步长: 0.5
	 * input: (1, 2), (2, 4), (3, 6), (4, 8), (5, 10)
	 * 误差: 0.01
	 */
	public static void batchGD_one_param() {
		double m1 = 0, m0 = 0;
		double[][] input = {{1, 2}, {2, 4}, {3, 6}, {4, 8}, {5, 10}};
		double deviation = 0.0000001;
		double step = 0.19;
		
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
	
	/**
	 * 假设函数：p(x)=p0+p1*x1+p2*x2+p3*x3+···+pn*xn
	 * 输入：{{1,x11,x12,x13,···,x1n}, 
	 * 		 {1,x21,x22,x23,···,x2n}, 
	 * 		 {1,x31,x32,x33,···,x3n}, 
	 * 		 ··· , 
	 * 		 {1,xn1,xn2,xn3,···,xnn}}
	 * 输出：{y1,y2,y3,···,yn}
	 * 批量梯度下降算法
	 * 
	 * @param input : 输入
	 * @param output : 输出
	 * @param deviation : 误差
	 * @param step : 步长
	 */
	public void batchGD() {
		double[][] input = linearModel.getInput(); 
		double[] output = linearModel.getOutput(); 
		double deviation = linearModel.getDeviation(); 
		double step = linearModel.getStep();
		int paramSize = input[0].length;
		double[] params = new double[paramSize];
		for (int i=0; i<paramSize; i++) {
			params[i] = 0;
		}
		
		double dd = 0;
		int times = 0;
		do {
			times++;
			dd = 0;
			for (int i=0; i<input.length; i++) {
				double y = output[i];
				
				double h = 0;
				for (int j=0; j<input[i].length; j++) {
					h += params[j] * input[i][j];
				}
				
				dd += (h - y) * (h - y);
			}
			dd = 1.0/2.0 * 1/input.length * dd;
			if (dd > deviation) {
				double temp = 0;
				for (int m=0; m<params.length; m++) {
					for (int i=0; i<input.length; i++) {
						double sum = 0;
						for (int j=0; j<input[i].length; j++) {
							sum += params[j] * input[i][j];
						}
						temp += (sum - output[i]) * input[i][m];
					}
					params[m] = params[m] - step * 1/input.length * temp;
				}
			}
		} while (dd > deviation);
		
		linearModel.setParams(params);
		
		logger.info(linearModel.toString());
	}
	
	/**
	 * 假设函数：p(x)=p0+p1*x1+p2*x2+p3*x3+···+pn*xn
	 * 输入：{{x11,x12,x13,···,x1n}, 
	 * 		 {x21,x22,x23,···,x2n}, 
	 * 		 {x31,x32,x33,···,x3n}, 
	 * 		 ··· , 
	 * 		 {xn1,xn2,xn3,···,xnn}}
	 * 输出：{y1,y2,y3,···,yn}
	 * 随机梯度下降算法
	 * 
	 * @param paramSize : 参数个数
	 * @param input : 输入
	 * @param output : 输出
	 * @param step : 步长
	 */
	public void stochasticGD(int paramSize, double[][] input, double[] output, double step) {
		double[] params = new double[paramSize];
		double b = 0;
		for (int i=0; i<paramSize; i++) {
			params[i] = 0;
		}
		
		int times = 0;
		double dd = 0;
		
		for (int i=0; i<input.length; i++) {
			times++;
			dd = 0;
			double y = output[i];
			double h = 0;
			h += 1 * b;
			for (int j=0; j<input[i].length; j++) {
				h += params[j] * input[i][j];
			}
			dd += (h - y) * (h - y);
			dd = 1.0/2.0 * 1/input.length * dd;
			
			double temp = 0;
			double sum = 0;
			for (int j=0; j<input[i].length; j++) {
				sum += params[j] * input[i][j];
			}
			temp += (b + sum - output[i]) * 1;
			
			b = b - step * 1/input.length * temp;
			
			for (int m=0; m<params.length; m++) {
				temp = 0;
				sum = 0;
				for (int j=0; j<input[i].length; j++) {
					sum += params[j] * input[i][j];
				}
				temp += (b + sum - output[i]) * input[i][m];
				params[m] = params[m] - step * 1/input.length * temp;
			}
			
			StringBuffer sb = new StringBuffer();
			for (int j=0; j<params.length; j++) {
				sb.append("params[" + j + "]=" + params[j] + ", ");
			}
			System.out.println(sb.toString() + "b=" + b + ", dd=" + dd + ", times=" + times);
		}
	}

	public LinearModel getLinearModel() {
		return linearModel;
	}

	public void setLinearModel(LinearModel linearModel) {
		this.linearModel = linearModel;
	}
	
}
