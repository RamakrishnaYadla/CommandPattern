package com.MousePad.CommandPattern;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		PowerControls powerControls = new PowerControls();
		MouseControls mouseControls = new MouseControls();
		List<CommandController> cmdControls = new ArrayList<CommandController>();
		cmdControls.add(powerControls);
		cmdControls.add(mouseControls);
		Actions a = new Actions(cmdControls);
		User u = new User(a);
		u.useMousePad();
	}
}
