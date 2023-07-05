package tomyjan.moeclassroommanager.service.impl;

import com.github.pagehelper.PageInfo;
import tomyjan.moeclassroommanager.common.base.service.BaseServiceImpl;
import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;
import tomyjan.moeclassroommanager.domain.Approval;
import tomyjan.moeclassroommanager.dto.ApprovalDTO;
import tomyjan.moeclassroommanager.mapper.ApprovalMapper;
import tomyjan.moeclassroommanager.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovalServiceImpl extends BaseServiceImpl<ApprovalMapper, Approval> implements ApprovalService {

    @Autowired
    private ApprovalMapper approvalMapper;

    @Override
    public PageInfo<ApprovalDTO> selectDtoPage(MybatisCondition condition) {
        startPage(condition);
        return new PageInfo<>(approvalMapper.selectDto(condition));
    }
}