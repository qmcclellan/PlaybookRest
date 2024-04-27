package com.rest.playbookrest.Battch_Jobs;

import com.rest.playbookrest.Dao.SchemeDao;
import com.rest.playbookrest.Entity.Playbook;
import com.rest.playbookrest.Entity.Scheme;
import com.rest.playbookrest.Processors.PlaybookProcessor;
import com.rest.playbookrest.Processors.SchemeProcessor;
import com.rest.playbookrest.Service.SchemeService;
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
public class Scheme_Job {

    private SchemeDao schemeDao;

    public Scheme_Job(SchemeDao schemeDao) {
        this.schemeDao = schemeDao;
    }

    @Bean
    public RepositoryItemReader<Scheme> schemeItemReader() {

        RepositoryItemReader<Scheme> reader = new RepositoryItemReader<>();

        HashMap<String, Sort.Direction> sorts = new HashMap<>();

        sorts.put("name", Sort.Direction.ASC);

        reader.setRepository(schemeDao);
        reader.setMethodName("findAll");
        reader.setSort(sorts);
        reader.setPageSize(50);

        return reader;

    }


    @Bean
    public RepositoryItemWriter<Scheme> schemeItemWriter(){

        RepositoryItemWriter<Scheme> writer = new RepositoryItemWriter<>();

        writer.setRepository(schemeDao);

        writer.setMethodName("saveAllAndFlush");

        return writer;

    }

    @Bean
    public ItemProcessor<Scheme,Scheme> schemeItemProcessor(){

        return new SchemeProcessor();
    }

    @Bean
    public Step writeSchemeStep(JobRepository jobRepository, PlatformTransactionManager transactionManager){

        return new StepBuilder("schemeWriter", jobRepository)
                .<Scheme,Scheme>chunk(50, transactionManager)
                .reader(schemeItemReader())
                .processor(schemeItemProcessor())
                .writer(schemeItemWriter())
                .build();

    }

    @Bean
    public Job runSchemeJob(JobRepository jobRepository, PlatformTransactionManager transactionManager){

        return new JobBuilder("schemeJob", jobRepository)
                .start(writeSchemeStep(jobRepository,transactionManager))
                .build();
    }
}
