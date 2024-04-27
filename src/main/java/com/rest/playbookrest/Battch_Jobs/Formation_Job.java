package com.rest.playbookrest.Battch_Jobs;

import com.rest.playbookrest.Dao.FormationDao;
import com.rest.playbookrest.Entity.Formation;
import com.rest.playbookrest.Processors.FormationProcessor;
import com.rest.playbookrest.Service.FormationService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.HashMap;

@Configuration
public class Formation_Job {

private FormationDao formationDao;

    public Formation_Job(FormationDao formationDao) {
        this.formationDao = formationDao;
    }

    @Bean
    public RepositoryItemReader<Formation> formationItemReader(){

        RepositoryItemReader<Formation> reader = new RepositoryItemReader<>();
        HashMap<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("name", Sort.Direction.ASC);
        reader.setRepository(formationDao);
        reader.setMethodName("findAll");
        reader.setSort(sorts);
        reader.setPageSize(10);

        return reader;

    }

    @Bean
    public RepositoryItemWriter formationItemWriter(){

        RepositoryItemWriter<Formation> writer = new RepositoryItemWriter<>();

        writer.setRepository(formationDao);
        writer.setMethodName("saveAllAndFlush");

        return writer;
    }

    @Bean
    public ItemProcessor<Formation, Formation> formationItemProcessor(){

        return new FormationProcessor();
    }

    @Bean
    public Step writeFormationStep(JobRepository jobRepository, PlatformTransactionManager transactionManager){

        return new StepBuilder("writeFormation", jobRepository)
                .<Formation, Formation>chunk(20, transactionManager)
                .reader(formationItemReader())
                .processor(formationItemProcessor())
                .writer(formationItemWriter())
                .build();
    }

    @Bean
    public Job runFormationJob(JobRepository jobRepository, PlatformTransactionManager transactionManager){

        return new JobBuilder("FormationJob", jobRepository)
                .start(writeFormationStep(jobRepository,transactionManager))
                .build();
    }
}
