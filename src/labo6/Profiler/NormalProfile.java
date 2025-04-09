package labo6.Profiler;

import labo6.Ressources;
import labo6.User;
import labo6.bots.Behavior.Check.CheckBehavior;
import labo6.bots.Behavior.Check.CheckBehaviorPatient;
import labo6.bots.Behavior.Wait.WaitBehavior;
import labo6.bots.Behavior.Wait.WaitBehaviorAsk;
import labo6.database.PictureDatabase;
import labo6.database.PictureList;
import labo6.database.TextList;
import labo6.database.TextDatabase;


public class NormalProfile extends Profiler {

    public NormalProfile(User peer) {
        super(peer);
    }

    public TextList getSuitableMessages(){
        TextList textlist = TextDatabase.getAllMessages();
        return textlist;
    }

    public PictureList getSuitablePictures (){
        PictureList piclist = PictureDatabase.getAllPictures();
        return piclist;
    }
    public WaitBehavior createWaitBehavior(){
        return new WaitBehaviorAsk();
    }
    public CheckBehavior createCheckBehavior() {
        return new CheckBehaviorPatient();
    }
}
