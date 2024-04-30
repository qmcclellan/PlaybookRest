package com.rest.playbookrest.Processors;

import com.rest.playbookrest.Entity.Scheme;
import org.springframework.batch.item.ItemProcessor;

public class SchemeProcessor implements ItemProcessor<Scheme,Scheme> {
    @Override
    public Scheme process(Scheme scheme) throws Exception {
        String type = scheme.getFormation().getType();

        scheme.setType(type);

        return scheme;
    }
}
