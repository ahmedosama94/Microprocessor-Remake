package hardware.components;

import hardware.components.exceptions.HardwareComponentException;
import hardware.components.utilities.Integer;

import java.util.ArrayList;

public class Register {
	
	private int data;
	private Integer inputBuffer;
	private Integer outputBuffer;
	private static ArrayList<Register> all;
	private boolean enable;
	
	public Register() {
		enable = false;
		all.add(this);
	}
	
	public void setInputBuffer(Integer input) throws HardwareComponentException {
		inputBuffer = input;
	}
	
	public Integer getOutputBuffer() {
		return outputBuffer;
	}
	
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	public int getInt() {
		return data;
	}
	
	public String getHex() {
		return java.lang.Integer.toHexString(data);
	}
	
	public String getBits() {
		return java.lang.Integer.toBinaryString(data);
	}
	
	private void clockCycle() {
		if(enable) {
			data = inputBuffer.getValue();
		}
	}
	
	private void updateOutput() {
		outputBuffer.setValue(data);
	}
	
	public static void clockCycleAll() {
		for(int i = 0; i < all.size(); i++) {
			all.get(i).clockCycle();
		}
		for(int i = 0; i < all.size(); i++) {
			all.get(i).updateOutput();
		}
	}

}
