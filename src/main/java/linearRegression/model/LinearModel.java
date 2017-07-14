package linearRegression.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinearModel extends BaseModel {
	
	private static final Logger logger = LogManager.getLogger(LinearModel.class);
	
	/**
	 * 输入
	 */
	private double[][] input;
	/**
	 * 输出
	 */
	private double[] output;
	/**
	 * 参数
	 */
	private double[] params;
	/**
	 * 误差
	 */
	private double deviation;
	/**
	 * 步长
	 */
	private double step;
	
	
	public double[][] getInput() {
		return input;
	}
	public void setInput(double[][] input) {
		this.input = input;
	}
	public double[] getOutput() {
		return output;
	}
	public void setOutput(double[] output) {
		this.output = output;
	}
	public double[] getParams() {
		return params;
	}
	public void setParams(double[] params) {
		this.params = params;
	}
	public double getDeviation() {
		return deviation;
	}
	public void setDeviation(double deviation) {
		this.deviation = deviation;
	}
	public double getStep() {
		return step;
	}
	public void setStep(double step) {
		this.step = step;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		if (params.length > 1) {
			sb.append(params[0]);
			for (int i=1; i<params.length; i++) {
				sb.append("+" + params[i] + "*x" + i);
			}
		}
		
		return sb.toString();
	}
	
}
