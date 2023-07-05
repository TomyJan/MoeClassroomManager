package tomyjan.moeclassroommanager.mapper;

import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;
import tomyjan.moeclassroommanager.domain.Room;
import tomyjan.moeclassroommanager.dto.RoomDTO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoomMapper extends Mapper<Room> {

    /**
     * 根据条件查找
     * @param condition
     * @return
     */
    List<RoomDTO> selectDto(MybatisCondition condition);
}
