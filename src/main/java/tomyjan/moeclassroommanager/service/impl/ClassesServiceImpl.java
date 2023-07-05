package tomyjan.moeclassroommanager.service.impl;

import com.github.pagehelper.PageInfo;
import tomyjan.moeclassroommanager.common.base.service.BaseServiceImpl;
import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;
import tomyjan.moeclassroommanager.domain.Classes;
import tomyjan.moeclassroommanager.dto.ClassesDTO;
import tomyjan.moeclassroommanager.mapper.ClassesMapper;
import tomyjan.moeclassroommanager.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassesServiceImpl extends BaseServiceImpl<ClassesMapper, Classes> implements ClassesService {
    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public PageInfo<ClassesDTO> selectDtoPage(MybatisCondition condition) {
        startPage(condition);
        return new PageInfo<>(classesMapper.selectDto(condition));
    }
}
