package labo6.session;

import labo6.Labo6Main;
import labo6.Ressources.Gender;
import labo6.User;
import labo6.bots.ChatBot;
import labo6.bots.PatientChatBot;
import labo6.database.*;


/*
 * Cette classe repr?sente une session d'un utilisateur humain
 * avec un ou plusieurs robots.
 * La session se termine lorsqu'on d?tecte que l'utilisateur humain
 * s'est d?connect? (change de pays ou de genre, via les boutons "PAYS" et "GENRE").
 */

public class Session {

	private User human;
	private ChatBot robot;
	private Labo6Main ui;
	private boolean ended;
	private Thread sleeper;

	public static final String NORMAL_SESSION = "normal";
	public static final String SEDUCTION_SESSION = "seduction";
	public static final String CASUAL_SESSION = "casual";


	public Session(Labo6Main l, User u) {
		ui = l;
		human = u;
		ended = false;
		sleeper = Thread.currentThread();
	}

	public void start() {


		robot = createChatBot(human, "Other", getSuitablePictures().random(), Gender.random());
		ui.initBackGround(robot);
		
		robot.appendMessage(generateGreeting());
		String oldText = human.getUI().getText();
		while (!hasEnded()) {

			robot.sleep(2000);

			/* Modification 7
			if (!human.getUI().getText().equals(oldText)) {*/
			if (robot.checkForWakeUp(human.getUI().getText())) {

				robot.appendMessage(generateAnswer());
				oldText = human.getUI().getText();
			}
		}
	}

	/*
	 * Appel? par le bouton SUIVANT
	 */
	public void changeChatBot() {
		robot = createChatBot(human, "Other", getSuitablePictures().random(), Gender.random());
		ui.initBackGround(robot);
	}
	

	public synchronized void end() {
		ended = true;
		sleeper.interrupt();
	}

	private synchronized boolean hasEnded() {
		return ended;
	}

	/* On peut retirer ce bloc pour la modif 5 */
	public String generateAnswer() {
		TextList list = getSuitableMessages();
		list = list.keep(TextMessage.TextKey.isGreeting, false);
		TextMessage msg = list.random();
		return msg.getMessage();
	}

	public String generateGreeting() {
		TextList list = getSuitableMessages();
		list = list.keep(TextMessage.TextKey.isGreeting, true);
		TextMessage msg = list.random();
		return msg.getMessage();
	}

	public TextList getSuitableMessages(){
		TextList textlist = TextDatabase.getAllMessages();
		return textlist;
	}

	public PictureList getSuitablePictures (){
		PictureList piclist = PictureDatabase.getAllPictures();
		return piclist;
	}

	public static Session createSession (String type, Labo6Main ui, User autre){
		if (type.equals(NORMAL_SESSION)){
			return new Session(ui, autre);
		}
		else if (type.equals(SEDUCTION_SESSION)){
			return new SeductionSession(ui, autre);
		}
		else if (type.equals(CASUAL_SESSION)){
			return new CasualSession(ui, autre);
		}
		else {
			throw new IllegalArgumentException("Wrong session type: " + type);
		}
	}
	protected ChatBot createChatBot(User peer, String name, Picture picture, Gender gender) {
		return new PatientChatBot(peer, name, picture, gender);
	}
}
