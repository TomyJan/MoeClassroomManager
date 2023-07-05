package tomyjan.moeclassroommanager.service;

import com.github.pagehelper.PageInfo;
import tomyjan.moeclassroommanager.common.base.service.BaseService;
import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;
import tomyjan.moeclassroommanager.domain.Floor;
import tomyjan.moeclassroommanager.dto.FloorDTO;

public interface FloorService extends BaseService<Floor> {

    /**
     * 通过条件查找
     *
     * @param condition
     *
     * @return
     */
    PageInfo<FloorDTO> selectDtoPage(MybatisCondition condition);
}
