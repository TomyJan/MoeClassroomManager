package tomyjan.moeclassroommanager.mapper;

import tomyjan.moeclassroommanager.common.CustomerMapper;
import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;
import tomyjan.moeclassroommanager.domain.Floor;
import tomyjan.moeclassroommanager.dto.FloorDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FloorMapper extends CustomerMapper<Floor> {

    /**
     *
     * @param condition
     * @return
     */
    List<FloorDTO> selectDto(MybatisCondition condition);
}
