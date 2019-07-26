package techcourse.myblog.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(length = 100)
    private String userName;

    @NonNull
    @Column(length = 100)
    private String email;

    @NonNull
    @Column(length = 100)
    private String password;

    @OneToMany(mappedBy = "author")
    private List<Article> articles = new ArrayList<>();

    public boolean matchPassword(String password) {
        return this.password.equals(password);
    }

    public void update(User user) {
        this.userName = user.userName;
        this.email = user.email;
        this.password = user.password;
    }

    public void addArticle(Article persistArticle) {
        articles.add(persistArticle);
    }

}
