package labo6.session;

import labo6.Labo6Main;
import labo6.Ressources;
import labo6.Ressources.Gender;
import labo6.User;
import labo6.bots.Behavior.Check.CheckBehavior;
import labo6.bots.Behavior.Check.CheckBehaviorPatient;
import labo6.bots.Behavior.Wait.WaitBehavior;
import labo6.bots.Behavior.Wait.WaitBehaviorAsk;
import labo6.bots.ChatBot;
//import labo6.bots.PatientChatBot;
import labo6.database.*;
import labo6.Profiler.Profiler;
import labo6.Profiler.NormalProfile;

/*
 * Cette classe repr?sente une session d'un utilisateur humain
 * avec un ou plusieurs robots.
 * La session se termine lorsqu'on d?tecte que l'utilisateur humain
 * s'est d?connect? (change de pays ou de genre, via les boutons "PAYS" et "GENRE").
 */

public class Session {

	public User human;
	private ChatBot robot;
	private Labo6Main ui;
	private boolean ended;
	private Thread sleeper;

	public static final String NORMAL_SESSION = "normal";
	public static final String SEDUCTION_SESSION = "seduction";
	public static final String CASUAL_SESSION = "casual";
	public Profiler profiler;
	public Gender gender;

	public Session(Labo6Main l, User u) {
		ui = l;
		human = u;
		ended = false;
		sleeper = Thread.currentThread();
	}

	public void start() {
		profiler = createProfiler();
		robot = profiler.createChatBot(human, "Other", profiler.getSuitablePictures().random(), Gender.random());
		ui.initBackGround(robot);

		robot.appendMessage(profiler.generateGreeting());
		String oldText = human.getUI().getText();
		while (!hasEnded()) {

			robot.waitForUser();

			if (robot.checkForWakeUp(human.getUI().getText())) {

				robot.appendMessage(profiler.generateAnswer());
				oldText = human.getUI().getText();
			}
		}
	}

	public Profiler createProfiler() {

		return new NormalProfile();
	}

	/*
	 * Appel? par le bouton SUIVANT
	 */
	public void changeChatBot() {
		robot = profiler.createChatBot(human, "Other", profiler.getSuitablePictures().random(), Gender.random());
		ui.initBackGround(robot);
	}


	public synchronized void end() {
		ended = true;
		sleeper.interrupt();
	}

	private synchronized boolean hasEnded() {
		return ended;
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
	/*
	public WaitBehavior createWaitBehavior(){
		return new WaitBehaviorAsk();
	}
	public CheckBehavior createCheckBehavior(){
		return new CheckBehaviorPatient();
	}*/
/* on bouge ca dans profiler
	protected ChatBot createChatBot(User peer, String name, Picture picture, Gender gender) {
		return new ChatBot(peer, name, picture, gender, createWaitBehavior(), createCheckBehavior());
	}

 */
	/* On peut retirer ce bloc pour la modif 5 */
	/* on bouge ca dans Profiler
	public String generateAnswer() {

		TextList list = getSuitableMessages();
		list = list.keep(TextMessage.TextKey.isGreeting, false);
		TextMessage msg = list.random();
		return msg.getMessage();
	}
	*/
/* on bouge ca dans profiler
	public String generateGreeting() {
		TextList list = getSuitableMessages();
		list = list.keep(TextMessage.TextKey.isGreeting, true);
		TextMessage msg = list.random();
		return msg.getMessage();
	}
*/
	/* non utilisé
	public String generateQuestion() {
		TextList list = getSuitableMessages();
		list = list.keep(TextMessage.TextKey.isQuestion, true);
		TextMessage msg = list.random();
		return msg.getMessage();
	}
*/
	/* rendu dans profiler
	public TextList getSuitableMessages(){
		TextList textlist = TextDatabase.getAllMessages();
		return textlist;
	}

	public PictureList getSuitablePictures (){
		PictureList piclist = PictureDatabase.getAllPictures();
		return piclist;
	}*/
}
