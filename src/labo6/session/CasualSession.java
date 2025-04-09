package labo6.session;

import labo6.Labo6Main;
import labo6.Profiler.CasualProfile;
import labo6.Profiler.NormalProfile;
import labo6.Profiler.Profiler;
import labo6.Ressources;
import labo6.User;
import labo6.bots.Behavior.Check.CheckBehavior;
import labo6.bots.Behavior.Check.CheckBehaviorPatient;
import labo6.bots.Behavior.Check.CheckBehaviorSlowmo;
import labo6.bots.Behavior.Wait.WaitBehavior;
import labo6.bots.Behavior.Wait.WaitBehaviorAsk;
import labo6.bots.Behavior.Wait.WaitBehaviorNothing;
import labo6.bots.ChatBot;
//import labo6.bots.SlowmoChatBot;
import labo6.database.*;
import labo6.Profiler.Profiler;
import labo6.Profiler.NormalProfile;
import labo6.bots.ChatBot;



public class CasualSession extends Session {

    //Constructeur.
    public CasualSession(Labo6Main l, User u) {
        super(l, u);
    }


    @Override
    public Profiler createProfiler() {

        return new CasualProfile(peer);
    }

/* La modif 5 nous permet d'omettre ce code
    @Override
    public String generateAnswer() {
        TextList list = TextDatabase.getAllMessages();
        list = list.keep(TextMessage.TextKey.isSeductive, false);
        TextMessage msg = list.random();
        return msg.getMessage();
    }
    @Override
    public String generateGreeting() {
        TextList list = TextDatabase.getAllMessages();
        list = list.keep(TextMessage.TextKey.isSeductive, false);
        TextMessage msg = list.random();
        return msg.getMessage();
    }
*//* dans casualprofile
    @Override
    public PictureList getSuitablePictures () {
        PictureList piclist = PictureDatabase.getAllPictures();
        piclist = piclist.keep(Picture.PictureKey.isSeductive, false);
        return piclist;
    }

    @Override
    public TextList getSuitableMessages(){
        TextList textlist = TextDatabase.getAllMessages();
        textlist = textlist.keep(TextMessage.TextKey.isSeductive, false);
        return textlist;
    }

    public WaitBehavior createWaitBehavior(){
        return new WaitBehaviorNothing();
    }
    public CheckBehavior createCheckBehavior(){
        return new CheckBehaviorSlowmo();
    }

    @Override
    protected ChatBot createChatBot(User peer, String name, Picture picture, Ressources.Gender gender) {
        return new ChatBot(peer, name, picture, gender, createWaitBehavior(), createCheckBehavior());
    }*/
}
