package tomyjan.moeclassroommanager.service.impl;

import com.github.pagehelper.PageInfo;
import tomyjan.moeclassroommanager.common.base.service.BaseServiceImpl;
import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;
import tomyjan.moeclassroommanager.domain.Room;
import tomyjan.moeclassroommanager.dto.RoomDTO;
import tomyjan.moeclassroommanager.mapper.RoomMapper;
import tomyjan.moeclassroommanager.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl extends BaseServiceImpl<RoomMapper, Room> implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public PageInfo<RoomDTO> selectDtoPage(MybatisCondition condition) {
        startPage(condition);
        return new PageInfo<>(roomMapper.selectDto(condition));
    }

    @Override
    public List<RoomDTO> selectDto(MybatisCondition condition) {
        return roomMapper.selectDto(condition);
    }

}
