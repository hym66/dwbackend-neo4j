package cn.edu.tongji.dwbackend.entity.node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * @Author hym
 * @Date $ $
 * @MethodName $
 * @Description $
 * @Return $
 * @Throw $
 */
@NodeEntity(label = "Genre")
@Data
@NoArgsConstructor
@AllArgsConstructor
@QueryResult
public class Genre {
    @Id
    String name;
}
