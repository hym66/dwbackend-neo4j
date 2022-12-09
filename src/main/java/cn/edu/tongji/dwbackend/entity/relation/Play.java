package cn.edu.tongji.dwbackend.entity.relation;

import cn.edu.tongji.dwbackend.entity.node.Actor;
import cn.edu.tongji.dwbackend.entity.node.Genre;
import cn.edu.tongji.dwbackend.entity.node.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @Author HUAWEI
 * @Date $ $
 * @MethodName $
 * @Description $
 * @Return $
 * @Throw $
 */
@RelationshipEntity(type = "Play")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Play {
    @Property("play_genre_comment_sum")
    int playGenreCommentSum;

    @StartNode
    Actor actor;

    @EndNode
    Genre genre;
}
