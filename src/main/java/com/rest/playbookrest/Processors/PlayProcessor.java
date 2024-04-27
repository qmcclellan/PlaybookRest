package com.rest.playbookrest.Processors;

import com.rest.playbookrest.Entity.Play;
import org.springframework.batch.item.ItemProcessor;

public class PlayProcessor implements ItemProcessor<Play,Play> {
    @Override
    public Play process(Play play) throws Exception {

        String type = play.getScheme().getType();

        play.setType(type);

        return play;
    }
}
