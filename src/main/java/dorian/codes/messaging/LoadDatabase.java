package dorian.codes.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


    static void populate(JdbcTemplate jdbcTemplate){
        log.info("Creating table");
        jdbcTemplate.execute("DROP TABLE IF EXISTS users;");
        jdbcTemplate.execute("DROP TABLE IF EXISTS messages;");

        jdbcTemplate.execute("CREATE TABLE users(id SERIAL PRIMARY KEY, nickname TEXT);");
        jdbcTemplate.execute("CREATE TABLE messages(id SERIAL PRIMARY KEY, content TEXT, sender_id INTEGER, receiver_id INTEGER);");


        log.info("Inserting data...");

        jdbcTemplate.update("INSERT INTO users (nickname) VALUES ('bob');");
        jdbcTemplate.update("INSERT INTO users (nickname) VALUES ('maria');");
        jdbcTemplate.update("INSERT INTO users (nickname) VALUES ('jay');");
        jdbcTemplate.update("INSERT INTO users (nickname) VALUES ('valerie');");

        jdbcTemplate.update("INSERT INTO messages (content, sender_id, receiver_id) VALUES ('Hi, how are you?', 1, 2);");
        jdbcTemplate.update("INSERT INTO messages (content, sender_id, receiver_id) VALUES ('Fine and you?', 2, 1);");


        log.info("... Done.");
    }


}
