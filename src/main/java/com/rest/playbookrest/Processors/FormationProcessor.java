package com.rest.playbookrest.Processors;

import com.rest.playbookrest.Entity.Formation;
import org.springframework.batch.item.ItemProcessor;

public class FormationProcessor implements ItemProcessor<Formation, Formation> {

    @Override
    public Formation process(Formation formation) throws Exception {

        if(formation.getType() == null) {

           System.out.println(formation);
            String type = formation.getPlayBook().getType();

            formation.setType(type);
            return formation;
        }else{
            return null;
        }

    }
}
