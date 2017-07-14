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
	/**
	 * 计算次数
	 */
	private int times;
	
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
	
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		if (params.length > 1) {
			sb.append("linear model : \r\n");
			sb.append("model : " + params[0]);
			for (int i=1; i<params.length; i++) {
				sb.append(" + " + params[i] + "*x" + i);
			}
		}
		sb.append("\r\n");
		sb.append("times : " + times);
		sb.append("\r\n");
		sb.append("deviation : " + deviation);
		
		return sb.toString();
	}
	
}
