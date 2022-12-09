package cn.edu.tongji.dwbackend.service.impl;

import cn.edu.tongji.dwbackend.entity.node.Actor;
import cn.edu.tongji.dwbackend.entity.node.Movie;
import cn.edu.tongji.dwbackend.entity.relation.Cooperate;
import cn.edu.tongji.dwbackend.entity.relation.Play;
import cn.edu.tongji.dwbackend.repository.MovieNodeRepository;
import cn.edu.tongji.dwbackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hym
 * @Date $ $
 * @MethodName $
 * @Description $
 * @Return $
 * @Throw $
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieNodeRepository movieNodeRepository;

    @Override
    public Movie findNodeById(Long id) {
        System.out.println(movieNodeRepository.findNodeById(id));
        return movieNodeRepository.findNodeById(id);
    }

    @Override
    public Integer findGenreMovieSum(String genreTitle) {
        return movieNodeRepository.findGenreMovieSum(genreTitle);
    }

    @Override
    public List<Cooperate> findOftenActorActor() {
        List<Cooperate> actorActor = movieNodeRepository.findOftenActorActor();
        return actorActor;
    }

    @Override
    public List<Cooperate> findOftenActorDirector() {
        List<Cooperate> actorDirector = movieNodeRepository.findOftenActorDirector();
        return actorDirector;
    }

    @Override
    public Integer findDirectorMovieNum(String directorName) {
        return movieNodeRepository.findDirectorMovieNum(directorName);
    }

    @Override
    public Integer findStarMovieNum(String starName) {
        return movieNodeRepository.findStarMovieNum(starName);
    }

    @Override
    public Integer findActorMovieNum(String actorName) {
        return movieNodeRepository.findActorMovieNum(actorName);
    }

    @Override
    public List<Play> findPersonMatchGenre(String genreTitle, int personNum) {
        List<Play> actorList = movieNodeRepository.findPersonMatchGenre(genreTitle, personNum);
        return actorList;
    }


}
