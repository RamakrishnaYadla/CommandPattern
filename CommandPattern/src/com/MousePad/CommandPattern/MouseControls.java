package com.MousePad.CommandPattern;

public class MouseControls implements CommandController{

	private Mouse mouse;
	
	public static final String MOVE_UP = "MOVE_UP";
	public static final String MOVE_DOWN = "MOVE_DOWN";
	public static final String MOVE_LEFT = "MOVE_LEFT";
	public static final String MOVE_RIGHT = "MOVE_RIGHT";
	public static final String ACTION_TAP = "ACTION_TAP";
	public static final String ACTION_DRAG = "ACTION_DRAG";
	
	public MouseControls() {
		this.mouse = new Mouse();
	}
	
	@Override
	public void execute(String cmd) {
		switch(cmd) {
			case MOVE_UP: mouse.moveUp();
			  break;
			case MOVE_DOWN: mouse.moveDown();
			  break;
			case MOVE_LEFT: mouse.moveLeft();
			  break;
			case MOVE_RIGHT: mouse.moveRight();
			  break;
			case ACTION_TAP: mouse.actionTap();
			  break;
			case ACTION_DRAG: mouse.actionDrag();
			  break;
			default: System.out.println("Haven't received any direction for movement on Mouse Pad");
			  break;
		}
	}
	
	@Override
	public boolean Handle(String cmd) {
		if(cmd.equals(MOVE_UP) || cmd.equals(MOVE_DOWN) || cmd.equals(MOVE_RIGHT) || cmd.equals(MOVE_LEFT) || cmd.equals(ACTION_TAP) || cmd.equals(ACTION_DRAG)) {
			return true;
		}
		return false;
	}
}
