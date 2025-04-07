package labo6.bots;

import labo6.Ressources;
import labo6.User;
import labo6.database.Picture;
import labo6.bots.ChatBot;
//seducton
public class ImpatientChatBot extends ChatBot {
    public ImpatientChatBot(User p, String n, Picture pic, Ressources.Gender g) {
        super(p, n, pic, g);
    }
    @Override
    public boolean checkForWakeUp(String currentText) {
        return !currentText.trim().isEmpty();
    }
}
