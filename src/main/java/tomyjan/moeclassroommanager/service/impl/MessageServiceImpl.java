package tomyjan.moeclassroommanager.service.impl;

import com.github.pagehelper.PageInfo;
import tomyjan.moeclassroommanager.common.base.service.BaseServiceImpl;
import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;
import tomyjan.moeclassroommanager.domain.Message;
import tomyjan.moeclassroommanager.dto.MessageDTO;
import tomyjan.moeclassroommanager.mapper.MessageMapper;
import tomyjan.moeclassroommanager.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends BaseServiceImpl<MessageMapper, Message> implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public PageInfo<MessageDTO> selectDtoPage(MybatisCondition condition) {
        startPage(condition);
        return new PageInfo<>(messageMapper.selectDto(condition));
    }
}
