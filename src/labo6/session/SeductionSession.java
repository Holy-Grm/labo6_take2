package labo6.session;

import labo6.Labo6Main;
import labo6.User;
import labo6.database.TextDatabase;
import labo6.database.TextList;
import labo6.database.TextMessage;

public class SeductionSession extends Session {

//Constructeur
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


}
