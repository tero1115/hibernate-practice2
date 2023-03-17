package shop.mtcoding.hiberpc.model.board;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.hiberpc.model.user.User;

@NoArgsConstructor // 없으면 하이버네이터가 new를 못함
@Getter
@Setter
@Table(name = "board_tb")
@Entity
public class Board {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY) // many는 Board One은 user
    private User user;// foreign key 설정

    private String title;
    private String content;

    @CreationTimestamp
    private Timestamp createdAt;

    @Builder
    public Board(Integer id, User user, String title, String content, Timestamp createdAt) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Board [id=" + id + ", user=" + user + ", title=" + title + ", content=" + content + ", createdAt="
                + createdAt + "]";
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
