package cn.edu.tongji.dwbackend.controller;


import cn.edu.tongji.dwbackend.common.Result;
import cn.edu.tongji.dwbackend.entity.node.Actor;
import cn.edu.tongji.dwbackend.entity.node.Movie;
import cn.edu.tongji.dwbackend.entity.relation.Cooperate;
import cn.edu.tongji.dwbackend.entity.relation.Play;
import cn.edu.tongji.dwbackend.service.MovieService;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author hym
 * @Date $ $
 * @MethodName $
 * @Description $
 * @Return $
 * @Throw $
 */

@Api(tags = {"Movie"})
@RestController
@RequestMapping("/neo4j")
public class neo4jController {
    @Autowired
    MovieService movieService;

    @ApiOperation("根据movieId找到电影")
    @GetMapping("findMovieById/{id}")
    public Result<Movie> findMovieById(@ApiParam(name="id", value="要查询的movieId", required = true)
                                            @PathVariable("id") Long id){
        try {
            long start=System.currentTimeMillis();
            Movie movieNode = movieService.findNodeById(id);
            long end=System.currentTimeMillis();
            return Result.success(movieNode, end-start);
        }
        catch (Exception e){
            return Result.fail(500,e.getMessage());
        }
    }

    @ApiOperation("返回某个种类的电影数")
    @GetMapping("findGenreMovieSum")
    public Result<Integer> findGenreMovieSum(@ApiParam(name="genreTitle", value="要查询的种类名称", required = true)
                                                 @RequestParam("genreTitle") String genreTitle){
        try{
            long start=System.currentTimeMillis();
            int movieSum = movieService.findGenreMovieSum(genreTitle);
            long end=System.currentTimeMillis();
            return Result.success(movieSum,end-start);
        }
        catch (Exception e){
            return Result.fail(500,e.getMessage());
        }
    }

    @ApiOperation("查询经常合作的演员")
    @GetMapping("findOftenActorActor")
    public Result<List<Cooperate>> findOftenActorActor(){
        try{
            long start=System.currentTimeMillis();
            List<Cooperate> actorActorList = movieService.findOftenActorActor();
            long end=System.currentTimeMillis();
            return Result.success(actorActorList,end-start);
        }
        catch (Exception e){
            return Result.fail(500,e.getMessage());
        }
    }

    @ApiOperation("查询经常合作的演员和导演")
    @GetMapping("findOftenActorDirector")
    public Result<List<Cooperate>> findOftenActorDirector(){
        try{
            long start=System.currentTimeMillis();
            List<Cooperate> actorDirectorList = movieService.findOftenActorDirector();
            long end=System.currentTimeMillis();
            return Result.success(actorDirectorList,end-start);
        }
        catch (Exception e){
            return Result.fail(500,e.getMessage());
        }
    }

    @ApiOperation("查询导演执导过的电影数")
    @GetMapping("findDirectorMovieNum")
    public Result<Integer> findDirectorMovieNum(@ApiParam(name="directorName", value="要查询的导演名字", required = true)
                                                    @RequestParam("directorName") String directorName){
        try{
            long start=System.currentTimeMillis();
            int movieSum = movieService.findDirectorMovieNum(directorName);
            long end=System.currentTimeMillis();
            return Result.success(movieSum,end-start);
        }
        catch (Exception e){
            return Result.fail(500,e.getMessage());
        }
    }

    @ApiOperation("查询演员主演过的电影数")
    @GetMapping("findStarMovieNum")
    public Result<Integer> findStarMovieNum(@ApiParam(name="starName", value="要查询的主演名字", required = true)
                                                @RequestParam("starName") String starName){
        try{
            long start=System.currentTimeMillis();
            int movieSum = movieService.findStarMovieNum(starName);
            long end=System.currentTimeMillis();
            return Result.success(movieSum,end-start);
        }
        catch (Exception e){
            return Result.fail(500,e.getMessage());
        }
    }

    @ApiOperation("查询演员参演过的电影数")
    @GetMapping("findActorMovieNum")
    public Result<Integer> findActorMovieNum(@ApiParam(name="actorName", value="要查询的参演名字", required = true)
                                                 @RequestParam("actorName") String actorName){
        try{
            long start=System.currentTimeMillis();
            int movieSum = movieService.findActorMovieNum(actorName);
            long end=System.currentTimeMillis();
            return Result.success(movieSum,end-start);
        }
        catch (Exception e){
            return Result.fail(500,e.getMessage());
        }
    }

    @ApiOperation("若要拍摄一部xx类型的电影，挑选出最适合的演员组合(n人)")
    @GetMapping("findActorMatchGenre")
    public Result<List<Play>> findActorMatchGenre(@ApiParam(name="genreTitle", value="要查询的电影类型名称", required = true)
                                                       @RequestParam("genreTitle") String genreTitle,
                                                   @ApiParam(name="personNum", value="要查询的演员组合人数", required = true)
                                                       @RequestParam("personNum") int personNum){
        try{
            long start=System.currentTimeMillis();
            List<Play> actorList = movieService.findPersonMatchGenre(genreTitle, personNum);
            long end=System.currentTimeMillis();
            return Result.success(actorList, end-start);
        }
        catch (Exception e){
            return Result.fail(500,e.getMessage());
        }
    }
}
