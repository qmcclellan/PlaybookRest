package com.rest.playbookrest.Config;

import com.rest.playbookrest.Entity.Playbook;
import com.rest.playbookrest.Processors.PlaybookProcessor;
import com.rest.playbookrest.Service.PlaybookService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Sort;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
//@EnableBatchProcessing
public class BatchConfig {

    private DataSource dataSource;

    private PlaybookService playbookService;

    public BatchConfig(DataSource dataSource,  PlaybookService playbookService) {
        this.dataSource = dataSource;
        this.playbookService = playbookService;
    }

    @Bean
    public RepositoryItemReader<Playbook> itemReader() {
        RepositoryItemReader<Playbook> reader = new RepositoryItemReader<>();

        HashMap<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("name", Sort.Direction.ASC);

        reader.setRepository(playbookService);
        reader.setMethodName("findAll");
        reader.setSort(sorts);
        reader.setPageSize(10);
        return reader;

    }

    @Bean
    public ItemProcessor<Playbook,Playbook> processor(){

        return new PlaybookProcessor();
    }

    @Bean
    public ItemWriter<Playbook> itemWriter(){

        BeanWrapperFieldExtractor<Playbook> extractor = new BeanWrapperFieldExtractor<>();
        extractor.setNames(new String[] { "id", "name" });

        DelimitedLineAggregator<Playbook> aggregator = new DelimitedLineAggregator<>();
        aggregator.setFieldExtractor(extractor);

        return new FlatFileItemWriterBuilder<Playbook>()
                .name("playbookWriter")
                .append(true)
                .lineAggregator(aggregator)
                .resource(new FileSystemResource("Playbooks.csv")) // Set the resource here
                .formatted()
                .format("%-9s%-2.0f")
                .names(new String[] {"id", "name"})
                .build();

    }

    @Bean
    public Step writeStep(JobRepository jobRepository, PlatformTransactionManager transactionManager){

        return new StepBuilder("writeCSV", jobRepository)
                .<Playbook,Playbook>chunk(10, transactionManager)
                .reader(itemReader())
                .processor(processor())
                .writer(itemWriter())
                .build();
    }

    @Bean
    public Job runJob(JobRepository jobRepository, PlatformTransactionManager transactionManager){

        return new JobBuilder("writePlaybookToCsv", jobRepository)
                .start(writeStep(jobRepository, transactionManager))
                .build();
    }
}
