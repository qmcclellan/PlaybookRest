package com.rest.playbookrest.Battch_Jobs;

import com.rest.playbookrest.Dao.PlayDao;
import com.rest.playbookrest.Entity.Play;
import com.rest.playbookrest.Processors.PlayProcessor;
import com.rest.playbookrest.Service.PlayService;
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
import org.springframework.transaction.PlatformTransactionManager;

import java.util.HashMap;

@Configuration
public class Play_Job {

  private PlayDao playDao;

    public Play_Job(PlayDao playDao) {
        this.playDao = playDao;
    }

    @Bean
    public RepositoryItemReader<Play> playItemReader(){

        RepositoryItemReader<Play> reader = new RepositoryItemReader<>();

        HashMap<String, Sort.Direction> sorts = new HashMap<>();

        sorts.put("name", Sort.Direction.ASC);

        reader.setRepository(playDao);
        reader.setMethodName("findAll");
        reader.setSort(sorts);
        reader.setPageSize(100);

        return reader;

    }

    @Bean
    public RepositoryItemWriter<Play> playItemWriter(){

        RepositoryItemWriter<Play> writer = new RepositoryItemWriter<>();

        writer.setRepository(playDao);

        writer.setMethodName("saveAllAndFlush");
        return writer;

    }

    @Bean
    ItemProcessor<Play, Play> playItemProcessor(){

        return new PlayProcessor();
    }

    @Bean
    public Step writePlayStep(JobRepository jobRepository, PlatformTransactionManager transactionManager){

       return new StepBuilder("writePlay", jobRepository)
                .<Play,Play>chunk(50,transactionManager)
                .reader(playItemReader())
                .processor(playItemProcessor())
                .writer(playItemWriter())
                .build();



    }

    @Bean
    public Job runPlayJob(JobRepository jobRepository, PlatformTransactionManager transactionManager){

        return new JobBuilder("writePlay", jobRepository)
                .start(writePlayStep(jobRepository, transactionManager))
                .build();
    }
}
