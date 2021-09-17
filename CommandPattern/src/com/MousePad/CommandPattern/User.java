package com.MousePad.CommandPattern;

import javax.swing.JOptionPane;

public class User {
	private Actions actions;
	private String cmds[] = {MouseControls.MOVE_UP,MouseControls.MOVE_DOWN,
							 MouseControls.MOVE_LEFT,MouseControls.MOVE_RIGHT,
							 MouseControls.ACTION_TAP,MouseControls.ACTION_DRAG,
							 PowerControls.Power_Off,PowerControls.Power_On,
							 Actions.CLICK,Actions.SELECT,Actions.DOUBLECLICK,Actions.EXIT};
	
	public User(Actions actions) {
		this.actions = actions;
	}
	
	public void useMousePad() {
		do {
			String cmd = (String)JOptionPane.showInputDialog(null,"SelectCommand","CommandControl",JOptionPane.INFORMATION_MESSAGE, null, this.cmds, this.cmds[0]);
			actions.execute(cmd);
		}while(true);
	}
}
