package labo6.Profiler;

import labo6.Ressources;
import labo6.User;
import labo6.bots.Behavior.Check.CheckBehavior;
import labo6.bots.Behavior.Check.CheckBehaviorPatient;
import labo6.bots.Behavior.Wait.WaitBehavior;
import labo6.bots.Behavior.Wait.WaitBehaviorAsk;
import labo6.database.*;


public class NormalProfile extends Profiler {

    public NormalProfile(User peer) {
        super(peer);
    }

    public TextList getSuitableMessages(){
        Ressources.Country human = getHumanCountry();

        TextList textlist = TextDatabase.getAllMessages();
        if (human == Ressources.Country.France || human == Ressources.Country.Quebec)
        {
            textlist = textlist.keep(TextMessage.TextKey.language, TextMessage.Language.french);
        }
        if (human == Ressources.Country.Japan || human == Ressources.Country.Canada)
        {
            textlist = textlist.keep(TextMessage.TextKey.language, TextMessage.Language.english);
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
}
