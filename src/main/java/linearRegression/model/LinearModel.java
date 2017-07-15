package linearRegression.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import linearRegression.handle.ScaleHandler;
import linearRegression.handle.VerifyHandler;

public class LinearModel extends BaseModel implements ScaleHandler, VerifyHandler {
	
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
	
	public void scale() {
		scaleInput();
		scaleOutput();
	}
	
	private void scaleInput() {
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
	
	private void scaleOutput() {
		double avg = 0;
		for (int i=0; i<output.length; i++) {
			avg += output[i];
		}
		avg = avg/input.length;
		
		double vv = 0;
		for (int i=0; i<output.length; i++) {
			vv += (output[i] - avg) * (output[i] - avg);
		}
		vv = vv/output.length;
		
		for (int i=0; i<output.length; i++) {
			if (vv == 0) {
				output[i] = output[i]/avg;
			} else {
				output[i] = (output[i] - avg)/Math.sqrt(vv);
			}
		}
	}
	
	public void verify() {
		for (int i=0; i<output.length; i++) {
			double h = 0;
			for (int j=0; j<input[i].length; j++) {
				h += params[j] * input[i][j];
			}
			logger.info("h" + (i+1) + "=" + h + ", output" + (i+1) + "=" + output[i]);
		}
	}
}
