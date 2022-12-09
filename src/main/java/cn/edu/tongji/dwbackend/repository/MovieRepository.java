package cn.edu.tongji.dwbackend.repository;

import cn.edu.tongji.dwbackend.entity.node.Movie;
import cn.edu.tongji.dwbackend.entity.relation.Cooperate;
import cn.edu.tongji.dwbackend.entity.relation.Play;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie,Long> {
    @Query("MATCH (n:Movie{movie_id:$id}) RETURN n")
    Movie findNodeById(Long id);

    //查询某一种类的电影数
    @Query("MATCH(movie:Movie)-[r:Belong]->(genre:Genre{name:$genreTitle})\n" +
            "RETURN COUNT(*)")
    Integer findGenreMovieSum(String genreTitle);

    //查询经常合作的演员
    @Query("MATCH p = (n1:Actor)-[r:Cooperate]->(n2:Actor)\n" +
            "WHERE r.cooperate_num>20\n" +
            "RETURN p")
    List<Cooperate> findOftenActorActor();

    //查询经常合作的导演和演员
    @Query ("MATCH p = (n1:Actor)-[r:Cooperate]->(n2:Director)\n" +
            "WHERE r.cooperate_num>20\n" +
            "RETURN p")
    List<Cooperate> findOftenActorDirector();

    //查询某一导演的电影数
    @Query("MATCH (n:Director{name:$directorName})-[r:Direct]->(m:Movie)" +
            "RETURN COUNT(*)")
    Integer findDirectorMovieNum(String directorName);

    //查询某一演员主演的电影数
    @Query("MATCH (n:Actor{name:$starName})-[r:Act{is_star:true}]->(m:Movie)" +
            "RETURN COUNT(*)")
    Integer findStarMovieNum(String starName);

    //查询某一演员参演的电影数
    @Query("MATCH (n:Actor{name:$actorName})-[r:Act{is_star:true}]->(m:Movie)" +
            "RETURN COUNT(*)")
    Integer findActorMovieNum(String actorName);

    @Query("MATCH p=(a:Actor)-[r:Play]->(g:Genre{name:'Action'})\n" +
            "WHERE r.play_genre_comment_sum>0\n" +
            "RETURN p\n" +
            "ORDER BY r.play_genre_comment_sum DESC\n" +
            "LIMIT $personNum")
    List<Play> findPersonMatchGenre(String genreTitle, int personNum);
}
