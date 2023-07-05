package tomyjan.moeclassroommanager.mapper;

import tomyjan.moeclassroommanager.common.utils.Md5Utils;
import tomyjan.moeclassroommanager.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertAdmin() {
        User user = new User().setPassword(Md5Utils.encode("123456")).setUsername("admin");
        userMapper.insertSelective(user);
    }

}