package tomyjan.moeclassroommanager.service;

import com.github.pagehelper.PageInfo;
import tomyjan.moeclassroommanager.common.base.service.BaseService;
import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;
import tomyjan.moeclassroommanager.domain.Classes;
import tomyjan.moeclassroommanager.dto.ClassesDTO;

public interface ClassesService extends BaseService<Classes> {

    /**
     * 通过条件查找
     *
     * @param condition
     * @return
     */
    PageInfo<ClassesDTO> selectDtoPage(MybatisCondition condition);
}
