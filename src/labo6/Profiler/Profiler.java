package labo6.Profiler;

import labo6.Ressources;
import labo6.User;
import labo6.bots.Behavior.Wait.WaitBehavior;
import labo6.bots.Behavior.Check.CheckBehavior;
import labo6.database.Picture;
import labo6.database.PictureList;
import labo6.database.TextList;
import labo6.bots.ChatBot;
import labo6.database.TextMessage;

public abstract class Profiler {


    public abstract PictureList getSuitablePictures();
    public abstract TextList getSuitableMessages();
    public abstract WaitBehavior createWaitBehavior();
    public abstract CheckBehavior createCheckBehavior();

    //public ChatBot createChatBot(User peer, String name, Picture picture, Ressources.Gender gender) {
    public ChatBot createChatBot(User peer, String name, Picture picture, Ressources.Gender gender) {

        return new ChatBot(peer, name, picture, gender, createWaitBehavior(), createCheckBehavior());
    }

    public String generateGreeting() {
        TextList list = getSuitableMessages();
        list = list.keep(TextMessage.TextKey.isGreeting, true);
        TextMessage msg = list.random();
        return msg.getMessage();
    }

    public String generateAnswer() {

        TextList list = getSuitableMessages();
        list = list.keep(TextMessage.TextKey.isGreeting, false);
        TextMessage msg = list.random();
        return msg.getMessage();
    }

/*
	public Ressources.Gender getSuitableGender(){
		if(human.getGender() == Ressources.Gender.man)
		{
			gender = Ressources.Gender.man;
		}

		else if (human.getGender() == Ressources.Gender.woman)
		{
			gender = Ressources.Gender.woman;
		}
		else {
			gender = Ressources.Gender.nonbinary;

		}
		return gender;
	}*/

}
