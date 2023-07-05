package tomyjan.moeclassroommanager.mapper;

import tomyjan.moeclassroommanager.common.CustomerMapper;
import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;
import tomyjan.moeclassroommanager.domain.Approval;
import tomyjan.moeclassroommanager.dto.ApprovalDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApprovalMapper extends CustomerMapper<Approval> {

    /**
     * 列表
     * @param mybatisCondition
     * @return
     */
    List<ApprovalDTO> selectDto(MybatisCondition mybatisCondition);
}
