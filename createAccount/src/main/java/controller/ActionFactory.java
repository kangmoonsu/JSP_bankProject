package controller;

import controller.action.Action;
import controller.action.CreateAccountAction;



public class ActionFactory {

	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		if (command.equals("createAccountAction")) {
			action = new CreateAccountAction();
		} 
		return action;
	}
}
