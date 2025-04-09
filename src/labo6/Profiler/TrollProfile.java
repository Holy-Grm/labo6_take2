package labo6.Profiler;

import labo6.Ressources;
import labo6.User;
import labo6.bots.Behavior.Check.CheckBehavior;
import labo6.bots.Behavior.Check.CheckBehaviorPatient;
import labo6.bots.Behavior.Wait.WaitBehavior;
import labo6.bots.Behavior.Wait.WaitBehaviorAsk;
import labo6.database.*;

public class TrollProfile extends Profiler {
    public TrollProfile(User peer) {
        super(peer);
    }

    @Override
    public String generateGreeting() {
        TextList list = getSuitableMessages();
        list = list.keep(TextMessage.TextKey.isGreeting, true);
        list = list.keep(TextMessage.TextKey.isOffensive, true);
        TextMessage msg = list.random();
        return msg.getMessage();
    }

    public TextList getSuitableMessages(){
        Ressources.Country human = getHumanCountry();

        TextList textlist = TextDatabase.getAllMessages();
        if (human == Ressources.Country.France || human == Ressources.Country.Quebec)
        {
            textlist = textlist.keep(TextMessage.TextKey.language, TextMessage.Language.english);
        }
        if (human == Ressources.Country.Japan || human == Ressources.Country.Canada)
        {
            textlist = textlist.keep(TextMessage.TextKey.language, TextMessage.Language.french);
        }
        return textlist;

    }

    public PictureList getSuitablePictures (){
        Ressources.Country human = getHumanCountry();
        PictureList piclist = PictureDatabase.getAllPictures();
        if (human == Ressources.Country.Japan)
        {
            piclist = piclist.keep(Picture.PictureKey.isComic, true);
        }
        return piclist;
    }
    public WaitBehavior createWaitBehavior(){
        return new WaitBehaviorAsk();
    }
    public CheckBehavior createCheckBehavior() {
        return new CheckBehaviorPatient();
    }

    @Override
    public Ressources.Gender getSuitableGender(){
        Ressources.Gender gender;
            if (Math.random() < 0.333333) {
                gender = Ressources.Gender.man;
            } else if (Math.random() > 0.666666) {
                gender = Ressources.Gender.woman;
            } else {
                gender = Ressources.Gender.nonbinary;
            }
        return gender;	}
}