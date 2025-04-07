package labo6.session;

import labo6.Labo6Main;
import labo6.Ressources;
import labo6.User;
import labo6.bots.ChatBot;
import labo6.bots.ImpatientChatBot;
import labo6.database.*;

public class SeductionSession extends Session {

//Constructeur.
    public SeductionSession(Labo6Main l, User u) {
        super(l, u);
    }
/* La modif 5 nous permet d'omettre ce code
 @Override
 public String generateAnswer() {
     TextList list = TextDatabase.getAllMessages();
     list = list.keep(TextMessage.TextKey.isSeductive, true);
     TextMessage msg = list.random();
     return msg.getMessage();
 }

 @Override
 public String generateGreeting() {
     TextList list = TextDatabase.getAllMessages();
     list = list.keep(TextMessage.TextKey.isSeductive, true);
     TextMessage msg = list.random();
     return msg.getMessage();
 }
*/
 @Override
 public PictureList getSuitablePictures () {
     PictureList piclist = PictureDatabase.getAllPictures();
     piclist = piclist.keep(Picture.PictureKey.isSeductive, true);
     return piclist;
 }

 @Override
 public TextList getSuitableMessages(){
     TextList textlist = TextDatabase.getAllMessages();
     textlist = textlist.keep(TextMessage.TextKey.isSeductive, true);
     return textlist;
 }
    @Override
    protected ChatBot createChatBot(User peer, String name, Picture picture, Ressources.Gender gender) {
        return new ImpatientChatBot(peer, name, picture, gender);
    }
}
