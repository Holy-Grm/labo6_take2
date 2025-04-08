package labo6.bots;

import labo6.Ressources;
import labo6.User;
import labo6.database.Picture;
import labo6.database.TextList;
import labo6.database.TextMessage;
import labo6.session.Session;

//session
public class PatientChatBot extends ChatBot {
    public PatientChatBot(User p, String n, Picture pic, Ressources.Gender g) {
        super(p, n, pic, g);
    }


    /*on bouge ca dans cb patient
    @Override
    public boolean checkForWakeUp(String currentText) {
        return currentText.endsWith("?");
    }
*/

/*on bouge ca dans waitbehaviorask
    @Override
    public void waitForUser() {
        sleep(2000);
        TextList list = getMessages();
        list = list.keep(TextMessage.TextKey.isQuestion, true);
        appendMessage(list.random().getMessage());
    }*/

}
