package com.MousePad.CommandPattern;

import java.util.Iterator;
import java.util.List;

public class Actions implements CommandController{
	
	private List<CommandController> cmdControls;
	
	public Actions(List<CommandController> cmdControls) {
		cmdControls.add(this);
		this.cmdControls = cmdControls;
	}

	public static final String CLICK = "CLICK";
	public static final String SELECT = "SELECT";
	public static final String DOUBLECLICK = "DOUBLECLICK";
	public static final String EXIT = "EXIT";
	
	@Override
	public void execute(String cmd) {
		Iterator<CommandController> cmdIterator = this.cmdControls.iterator();
		while (cmdIterator.hasNext()) {
			CommandController cmdController = cmdIterator.next();
			if(cmdController instanceof Actions) {
				switch (cmd) {
				case Actions.CLICK:
					this.click();
					break;
				case Actions.SELECT:
					this.select();
					break;
				case Actions.DOUBLECLICK:
					this.doubleClick();
					break;
				case Actions.EXIT:
					System.exit(0);
				}
			}else if(cmdController.Handle(cmd)) {
				cmdController.execute(cmd);
			}
			
		}
	}

	@Override
	public boolean Handle(String cmd) {
		if(cmd.equals(CLICK) || cmd.equals(SELECT) || cmd.equals(DOUBLECLICK) || cmd.equals(EXIT)) {
			return true;
		}
		return false;
	}
	
	public void click() {
		System.out.println("*********** MousePad click Action ***********");
		this.execute(PowerControls.Power_On);
		this.execute(MouseControls.MOVE_UP);
		this.execute(MouseControls.ACTION_TAP);
		this.execute(PowerControls.Power_Off);
		System.out.println("*********** Performed Mouse Pad click Action ***********");
	}

	public void select() {
		System.out.println("*********** MousePad Select Action ***********");
		this.execute(PowerControls.Power_On);
		this.execute(MouseControls.MOVE_DOWN);
		this.execute(MouseControls.ACTION_TAP);
		this.execute(MouseControls.ACTION_DRAG);
		this.execute(MouseControls.MOVE_RIGHT);
		this.execute(PowerControls.Power_Off);
		System.out.println("*********** Performed MousePad Select Action ***********");
	}
	
	public void doubleClick() {
		System.out.println("*********** MousePad DoubleClick Action ***********");
		this.execute(PowerControls.Power_On);
		this.execute(MouseControls.MOVE_LEFT);
		this.execute(MouseControls.ACTION_TAP);
		this.execute(MouseControls.ACTION_TAP);
		this.execute(PowerControls.Power_Off);
		System.out.println("*********** Performed MousePad DoubleClick Action ***********");
	}
}