package dorian.codes.messaging;

import dorian.codes.messaging.messages.Message;
import dorian.codes.messaging.messages.MessageRepository;
import dorian.codes.messaging.users.User;
import dorian.codes.messaging.users.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//TODO add logger
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(UserRepository repository, MessageRepository msgRepository){
        User Bob = new User("bob");
        User Maria = new User("maria");
        User Jay = new User("jay");

        Message msg1 = new Message("Hi! How are you?", 1L, 2L);
        Message msg2 = new Message("I'm fine and you?", 2L, 1L);

        return args -> {
            System.out.println("preloading users " + repository.save(Bob));
            System.out.println("preloading users " + repository.save(Maria));

            System.out.println("preloading messages = " + msgRepository.save(msg1));
            System.out.println("preloading messages = " + msgRepository.save(msg2));


        };
    }
}
