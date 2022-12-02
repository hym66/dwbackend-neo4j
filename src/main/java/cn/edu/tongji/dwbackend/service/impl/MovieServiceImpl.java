package cn.edu.tongji.dwbackend.service.impl;

import cn.edu.tongji.dwbackend.entity.MovieNode;
import cn.edu.tongji.dwbackend.repository.MovieNodeRepository;
import cn.edu.tongji.dwbackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public MovieNode findNodeById(Long id) {
        return movieNodeRepository.findNodeById(id);
    }
}
