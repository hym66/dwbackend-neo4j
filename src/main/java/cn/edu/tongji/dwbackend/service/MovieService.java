package cn.edu.tongji.dwbackend.service;

import cn.edu.tongji.dwbackend.entity.node.Actor;
import cn.edu.tongji.dwbackend.entity.node.Movie;
import cn.edu.tongji.dwbackend.entity.relation.Cooperate;
import cn.edu.tongji.dwbackend.entity.relation.Play;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    Movie findNodeById(Long id);
    Integer findGenreMovieSum(String genreTitle);
    List<Cooperate> findOftenActorActor();
    List<Cooperate> findOftenActorDirector();
    Integer findDirectorMovieNum(String directorName);
    Integer findStarMovieNum(String starName);
    Integer findActorMovieNum(String actorName);
    List<Play> findPersonMatchGenre(String genreTitle, int personNum);
}
