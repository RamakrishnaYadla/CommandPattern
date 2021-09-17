package com.MousePad.CommandPattern;

public class PowerControls implements CommandController{

	private Power power;
	
	public static final String Power_On = "Power_On";
	public static final String Power_Off = "Power_Off";
	
	public PowerControls(){
		this.power = new Power();
	}
	
	@Override
	public void execute(String cmd) {
		switch (cmd) {
		case Power_On: 
			power.powerOn();
			break;
		case Power_Off:
			power.powerOff();
			break;
		default:
			System.out.println("Invalid Command");
		}
	}
	
	@Override
	public boolean Handle(String cmd) {
		if(cmd.equals(Power_Off) || cmd.equals(Power_On)) {
			return true;
		}
		return false;
	}
}