package dorian.codes.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MessagingApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(MessagingApplication.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public static void main(String[] args) {
        SpringApplication.run(MessagingApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        LoadDatabase.populate(jdbcTemplate);

    }
}
