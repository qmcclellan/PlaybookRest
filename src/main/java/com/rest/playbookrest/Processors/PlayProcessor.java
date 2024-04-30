package com.rest.playbookrest.Processors;

import com.rest.playbookrest.Entity.Play;
import org.aspectj.bridge.IMessageHandler;
import org.springframework.batch.item.ItemProcessor;

import java.util.ArrayList;
import java.util.List;

public class PlayProcessor implements ItemProcessor<Play,Play> {
    @Override
    public Play process(Play play) throws Exception {

            String type = play.getType();

            String image = play.getImage();

          //  String newPath = "";

        List<Play> plays = new ArrayList<>();

            if(image.contains("P:/")) {

                plays.add(play);

                for(Play curPlay : plays) {


                    switch (type) {

                        case "offense":

                            image = play.getImage().replace("P:/Angular/Playbook Frontend/Storage/Images/Plays/offense_plays/", "assets/images/plays/Plays/offense_Plays/");

                            // newPath = "assets/images/plays/Plays/offense_plays/" + image;

                            curPlay.setImage(image);

                            break;

                        case "defense":

                            image = play.getImage().replace("P:/Angular/Playbook Frontend/Storage/Images/Plays/defense_plays/", "assets/images/plays/Plays/defense_Plays/");

                            //newPath = "assets/images/plays/Plays/defense_Plays/" + image;

                            curPlay.setImage(image);

                            break;


                    }
                    System.out.println(plays.size());

                    return curPlay;
                }
            }
            return null;
    }
}
