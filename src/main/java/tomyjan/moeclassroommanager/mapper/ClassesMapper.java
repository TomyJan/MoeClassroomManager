package tomyjan.moeclassroommanager.mapper;

import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;
import tomyjan.moeclassroommanager.domain.Classes;
import tomyjan.moeclassroommanager.dto.ClassesDTO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ClassesMapper extends Mapper<Classes> {

    /**
     * 条件查找
     * @param condition
     * @return
     */
    List<ClassesDTO> selectDto(MybatisCondition condition);
}
