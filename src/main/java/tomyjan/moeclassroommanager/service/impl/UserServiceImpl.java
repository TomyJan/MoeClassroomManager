package tomyjan.moeclassroommanager.service.impl;

import tomyjan.moeclassroommanager.common.base.service.BaseServiceImpl;
import tomyjan.moeclassroommanager.common.exception.MessageException;
import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;
import tomyjan.moeclassroommanager.common.utils.Md5Utils;
import tomyjan.moeclassroommanager.domain.Admin;
import tomyjan.moeclassroommanager.domain.User;
import tomyjan.moeclassroommanager.mapper.AdminMapper;
import tomyjan.moeclassroommanager.mapper.UserMapper;
import tomyjan.moeclassroommanager.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminMapper adminMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateOrSaveUser(User user) {
        if (user.getId() == null) {
            boolean exist = isExist(new MybatisCondition().eq("username", user.getUsername()));
            if (exist) {
                throw new MessageException("用户名已存在");
            }
            if (StringUtils.isEmpty(user.getPassword())) {
                throw new MessageException("密码不能为空");
            }
            String password = Md5Utils.encode(user.getPassword());
            user.setPassword(password);
            userMapper.insertSelective(user);
        } else {
            boolean exist = isExist(
                    new MybatisCondition().eq("username", user.getUsername()).eqNot("id", user.getId()));
            if (exist) {
                throw new MessageException("用户名已存在");
            }
            User updateUser = userMapper.selectByPrimaryKey(user.getId());
            if (null != updateUser) {
                if (StringUtils.isNotBlank(user.getPassword())) {
                    String password = Md5Utils.encode(user.getPassword());
                    user.setPassword(password);
                } else {
                    user.setPassword(null);
                }
                userMapper.updateByPrimaryKeySelective(user);
            } else {
                throw new MessageException("操作失败，用户不存在");
            }
        }
    }

    @Override
    public Object login(String username, String password, User.UserRoleEnum role) {
        if (role == User.UserRoleEnum.ADMIN) {
            Admin admin = new Admin();
            admin.setUsername(username);
            admin.setPassword(Md5Utils.encode(password));
            return adminMapper.selectOne(admin);
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(Md5Utils.encode(password));
        return userMapper.selectOne(user);
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }
}
