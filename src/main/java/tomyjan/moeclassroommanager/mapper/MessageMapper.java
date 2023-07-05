package tomyjan.moeclassroommanager.mapper;

import tomyjan.moeclassroommanager.common.CustomerMapper;
import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;
import tomyjan.moeclassroommanager.domain.Message;
import tomyjan.moeclassroommanager.dto.MessageDTO;

import java.util.List;

public interface MessageMapper extends CustomerMapper<Message> {

    /**
     * 通过条件查找
     * @param condition
     * @return
     */
    List<MessageDTO> selectDto(MybatisCondition condition);
}
