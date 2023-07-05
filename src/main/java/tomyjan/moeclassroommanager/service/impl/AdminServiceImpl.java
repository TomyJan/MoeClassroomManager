package tomyjan.moeclassroommanager.service.impl;

import tomyjan.moeclassroommanager.common.base.service.BaseServiceImpl;
import tomyjan.moeclassroommanager.domain.Admin;
import tomyjan.moeclassroommanager.mapper.AdminMapper;
import tomyjan.moeclassroommanager.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends BaseServiceImpl<AdminMapper, Admin> implements AdminService{
}
