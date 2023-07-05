package tomyjan.moeclassroommanager.service;

import com.github.pagehelper.PageInfo;
import tomyjan.moeclassroommanager.common.base.service.BaseService;
import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;
import tomyjan.moeclassroommanager.domain.Room;
import tomyjan.moeclassroommanager.dto.RoomDTO;

import java.util.List;

public interface RoomService extends BaseService<Room> {
    /**
     * 通过条件查找
     *
     * @param condition
     *
     * @return
     */
    PageInfo<RoomDTO> selectDtoPage(MybatisCondition condition);

    /**
     * 通过条件查找
     *
     * @param condition
     *
     * @return
     */
    List<RoomDTO> selectDto(MybatisCondition condition);
}
