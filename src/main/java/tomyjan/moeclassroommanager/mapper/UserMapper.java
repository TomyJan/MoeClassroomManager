package tomyjan.moeclassroommanager.mapper;

import org.apache.ibatis.annotations.Mapper;
import tomyjan.moeclassroommanager.common.CustomerMapper;
import tomyjan.moeclassroommanager.domain.User;

@Mapper
public interface UserMapper extends CustomerMapper<User> {
    /**
     * 根据用户名获取用户
     *
     * @param userName
     * @return
     */
    User selectByUsername(String userName);

    /**
     * 根据ID删除
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 得到用户的辅导员
     * @param userId
     * @return
     */
    User selectCounselorByUser(Integer userId);
}
