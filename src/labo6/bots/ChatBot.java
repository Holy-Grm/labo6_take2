package labo6.bots;

import labo6.Ressources.Gender;
import labo6.User;
import labo6.database.Picture;
import labo6.database.TextDatabase;
import labo6.database.TextList;

public abstract class ChatBot extends User {
	protected TextList getMessages(){
		return TextDatabase.getAllMessages();
	}
	//L'utilisateur avec lequel le robot est en communication.
	private User peer;
	private String lastText = ""; // Pour SlowmoChatBot

	public ChatBot(User p, String n, Picture pic, Gender g) {
		super(n, pic, g);
		peer = p;
	}

	public abstract boolean checkForWakeUp(String currentText);

	public void sleep(int time) {
		try {

			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
	}
	
	public void appendMessage(String msg){
		getUI().appendMessage(msg);
	}
	
	public User getPeer(){
		return peer;
	}

	protected String getLastText() {
		return lastText;
	}

	protected void setLastText(String text) {
		this.lastText = text;
	}
	public abstract void waitForUser();
}
