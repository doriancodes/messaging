package dorian.codes.messaging.users;

/**
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest

public class UserRepositoryIntegrationTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findUser(){
        User alex = new User("alex");
        entityManager.persist(alex);
        entityManager.flush();

        Optional<User> found = userRepository.findById(alex.getId());

        found.ifPresent(f -> assertThat(f.getId()).isEqualTo(alex.getId()));


    }
}*/
