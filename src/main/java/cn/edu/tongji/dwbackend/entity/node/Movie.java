package cn.edu.tongji.dwbackend.entity.node;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
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

@NodeEntity(label = "Movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
@QueryResult
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Movie {
    @Id
    @GeneratedValue
    @JsonSerialize(using= ToStringSerializer.class)
    private Long movieId;
}
