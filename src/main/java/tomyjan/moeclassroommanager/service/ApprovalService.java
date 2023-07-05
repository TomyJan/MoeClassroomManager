package tomyjan.moeclassroommanager.service;

import com.github.pagehelper.PageInfo;
import tomyjan.moeclassroommanager.common.base.service.BaseService;
import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;
import tomyjan.moeclassroommanager.domain.Approval;
import tomyjan.moeclassroommanager.dto.ApprovalDTO;

public interface ApprovalService extends BaseService<Approval> {

    /**
     * 列表
     * @param condition
     * @return
     */
    PageInfo<ApprovalDTO> selectDtoPage(MybatisCondition condition);
}
