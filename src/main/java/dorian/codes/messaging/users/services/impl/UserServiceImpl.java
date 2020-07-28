package dorian.codes.messaging.users.services.impl;

import dorian.codes.messaging.users.models.User;
import dorian.codes.messaging.users.models.UserNickname;
import dorian.codes.messaging.users.repositories.UserRepository;
import dorian.codes.messaging.users.services.UserService;
import org.springframework.stereotype.Service;

@Service
class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserNickname createUser(UserNickname userNickname) {
        userRepository.save(new User(userNickname.getNickname()));
        return userNickname;
    }
}
