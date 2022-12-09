package cn.edu.tongji.dwbackend.entity.relation;

import cn.edu.tongji.dwbackend.entity.node.Actor;
import cn.edu.tongji.dwbackend.entity.node.Person;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;
import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * @Author hym
 * @Date $ $
 * @MethodName $
 * @Description $
 * @Return $
 * @Throw $
 */
@RelationshipEntity(type = "Cooperate")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cooperate {
    @Property(name="cooperate_num")
    int cooperateNum;

    @StartNode
    Person startPerson;

    @EndNode
    Person endPerson;
}
