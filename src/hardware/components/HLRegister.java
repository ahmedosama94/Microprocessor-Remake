package hardware.components;

import hardware.components.exceptions.HardwareComponentException;

public class HLRegister extends Register {
	
	private Short inputBuffer;
	
	public HLRegister() {
		super();
	}
	
	public void setInputBuffer(Integer input) throws HardwareComponentException {
		throw new HardwareComponentException("This Register has only 16 bits as input");
	}
	
	public void setInputBuffer(Short input) {
		inputBuffer = input;
	}

}
