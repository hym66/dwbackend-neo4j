package cn.edu.tongji.dwbackend.service;

import cn.edu.tongji.dwbackend.entity.MovieNode;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {
    MovieNode findNodeById(Long id);
}
