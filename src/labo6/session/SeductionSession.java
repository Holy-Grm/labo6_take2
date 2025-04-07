package labo6.session;

import labo6.Labo6Main;
import labo6.User;
import labo6.database.*;

public class SeductionSession extends Session {

//Constructeur.
    public SeductionSession(Labo6Main l, User u) {
        super(l, u);
    }

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

 @Override
 public PictureList getSuitablePictures () {
     PictureList piclist = PictureDatabase.getAllPictures();
     piclist = piclist.keep(Picture.PictureKey.isSeductive, true);
     return piclist;
 }
}
