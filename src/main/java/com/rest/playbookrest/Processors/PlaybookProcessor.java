package com.rest.playbookrest.Processors;

import com.rest.playbookrest.Entity.Playbook;
import org.springframework.batch.item.ItemProcessor;

public class PlaybookProcessor implements ItemProcessor<Playbook,Playbook> {

    @Override
    public Playbook process(Playbook playbook) throws Exception {

        return playbook;
    }
}
