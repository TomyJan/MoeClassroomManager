package tomyjan.moeclassroommanager.service.impl;

import com.github.pagehelper.PageInfo;
import tomyjan.moeclassroommanager.common.base.service.BaseServiceImpl;
import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;
import tomyjan.moeclassroommanager.domain.Floor;
import tomyjan.moeclassroommanager.dto.FloorDTO;
import tomyjan.moeclassroommanager.mapper.FloorMapper;
import tomyjan.moeclassroommanager.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FloorServiceImpl extends BaseServiceImpl<FloorMapper, Floor> implements FloorService {

    @Autowired
    private FloorMapper floorMapper;

    @Override
    public PageInfo<FloorDTO> selectDtoPage(MybatisCondition condition) {
        startPage(condition);
        return new PageInfo<>(floorMapper.selectDto(condition));
    }
}
