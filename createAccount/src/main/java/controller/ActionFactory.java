package controller;


import controller.action.*;


public class ActionFactory {

	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		if (command.equals("indexBeforeLogin")) {
			action = new IndexBeforeLogin();
		} else if (command.equals("loginAction")) {
			action = new LoginAction();
		} else if (command.equals("indexAfterLogin")) {
			action = new IndexAfterLogin();
		} else if (command.equals("joinFormAction")) {
			action = new JoinFormAction();
		} else if (command.equals("joinAction")) {
			action = new JoinAction();
		} else if (command.equals("logoutAction")) {
			action = new LogoutAction();
		} else if (command.equals("createAccountAction")) {
			action = new CreateAccountAction();
		} else if (command.equals("exchangeAction")) {
			action = new ExchangeAction();
		} else if (command.equals("customerBoardForm")) {
			action = new CustomerBoardForm();
		} else if (command.equals("transactionAction")) {
			action = new TransactionAction();
		} else if (command.equals("CustomerMyPageAction")) {
			action = new customerMyPageAction();
		}
		return action;
	}
}
