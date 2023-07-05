package tomyjan.moeclassroommanager.service;

import com.github.pagehelper.PageInfo;
import tomyjan.moeclassroommanager.common.base.service.BaseService;
import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;
import tomyjan.moeclassroommanager.domain.Message;
import tomyjan.moeclassroommanager.dto.MessageDTO;

public interface MessageService extends BaseService<Message> {
    PageInfo<MessageDTO> selectDtoPage(MybatisCondition condition);
}
