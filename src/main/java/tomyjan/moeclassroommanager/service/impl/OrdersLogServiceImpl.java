package tomyjan.moeclassroommanager.service.impl;

import tomyjan.moeclassroommanager.common.base.service.BaseServiceImpl;
import tomyjan.moeclassroommanager.domain.OrdersLog;
import tomyjan.moeclassroommanager.mapper.OrdersLogMapper;
import tomyjan.moeclassroommanager.service.OrdersLogService;
import org.springframework.stereotype.Service;

@Service
public class OrdersLogServiceImpl extends BaseServiceImpl<OrdersLogMapper, OrdersLog> implements OrdersLogService {
}
