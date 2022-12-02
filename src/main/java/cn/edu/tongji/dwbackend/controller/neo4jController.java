package cn.edu.tongji.dwbackend.controller;


import cn.edu.tongji.dwbackend.common.Result;
import cn.edu.tongji.dwbackend.entity.MovieNode;
import cn.edu.tongji.dwbackend.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result<MovieNode> findMovieById(@ApiParam(name="id", value="要查询的movieId", required = true)
                                            @PathVariable("id") Long id){
        try {
            MovieNode movieNode = movieService.findNodeById(id);
            return Result.success(movieNode);
        }
        catch (Exception e){
            return Result.fail(500,e.getMessage());
        }
    }

}
