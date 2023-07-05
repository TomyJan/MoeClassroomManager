package tomyjan.moeclassroommanager.service.impl;

import tomyjan.moeclassroommanager.common.base.service.BaseServiceImpl;
import tomyjan.moeclassroommanager.domain.LoginLog;
import tomyjan.moeclassroommanager.mapper.LoginLogMapper;
import tomyjan.moeclassroommanager.service.LoginLogService;
import org.springframework.stereotype.Service;

@Service
public class LoginLogServiceImpl extends BaseServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {
}
