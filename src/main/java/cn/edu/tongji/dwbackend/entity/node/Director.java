package cn.edu.tongji.dwbackend.entity.node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * @Author hym
 * @Date $ $
 * @MethodName $
 * @Description $
 * @Return $
 * @Throw $
 */
@NodeEntity(label = "Director")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Director extends Person {
    @Property(name="name")
    String name;
}
