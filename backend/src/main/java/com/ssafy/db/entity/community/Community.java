package com.ssafy.db.entity.community;

import com.ssafy.api.request.CommunityParamDto;
import com.ssafy.db.entity.auth.UserProfile;
import com.ssafy.db.entity.community.CommunityComment;
import com.ssafy.db.entity.community.CommunityImage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static com.ssafy.db.entity.community.QCommunity.community;

/**
 * 커뮤니티 게시글 정보 Entity
 */
@Entity
@Table(name="community", schema = "community")
@SqlResultSetMapping(
        name="CommunityAndUserMapping",
        classes = @ConstructorResult(
                targetClass = CommunityParamDto.class,
                columns = {
                        @ColumnResult(name="id", type = Long.class),
                        @ColumnResult(name="description", type = String.class),
                        @ColumnResult(name="title", type = String.class),
                        @ColumnResult(name="user_id", type = String.class),
                        @ColumnResult(name="name", type = String.class),
                        @ColumnResult(name="category", type = String.class),
                })
)
@NamedNativeQuery(
        name="CommunityAndUser",
        query="select c.id, c.description, c.title, c.user_id, u.name, c.category from community.community c inner join auth.user_profile u where c.user_id = u.user_id",
        resultSetMapping="CommunityAndUserMapping")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Community extends BaseEntity {

    @Column(name="user_id")
    private String userId;                    // 사용자 아이디

    @Column(length = 30)
    private String title;                     // 게시글 제목

    @Column(columnDefinition = "TEXT")
    private String description;               // 게시글 내용

    @Column(length = 10)
    private String category;                  // 게시글 종류

    @Column(name="reg_date", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private LocalDateTime regDate;

//    @OneToMany(mappedBy = "community_id", cascade = {CascadeType.ALL}, orphanRemoval=true)
//    private List<CommunityComment> communityComments;
//
//    @OneToMany(mappedBy = "communityId", cascade = {CascadeType.ALL}, orphanRemoval=true)
//    private List<CommunityImage> communityImages;

}

