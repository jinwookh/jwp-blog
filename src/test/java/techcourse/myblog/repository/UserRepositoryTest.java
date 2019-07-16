package techcourse.myblog.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import techcourse.myblog.domain.User;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void 유저_정보_저장() {
        User user = new User("test1","test@test.com","1234");
        userRepository.save(user);
        assertThat(userRepository.findById(1L).get().getUserName()).isEqualTo("test1");
        assertThat(userRepository.findById(1L).get().getEmail()).isEqualTo("test@test.com");
        assertThat(userRepository.findById(1L).get().getPassword()).isEqualTo("1234");
    }

    @Test
    void 유저_정보_조회() {
        List<User> users = (List<User>) userRepository.findAll();

        assertThat(users.get(0).getId()).isEqualTo(10);
        assertThat(users.get(0).getUserName()).isEqualTo("test1");
        assertThat(users.get(0).getEmail()).isEqualTo("test2@test.com");
        assertThat(users.get(0).getPassword()).isEqualTo("1234");
    }
}
