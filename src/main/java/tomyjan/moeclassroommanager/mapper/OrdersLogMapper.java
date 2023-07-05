package tomyjan.moeclassroommanager.mapper;

import tomyjan.moeclassroommanager.common.CustomerMapper;
import tomyjan.moeclassroommanager.domain.OrdersLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersLogMapper extends CustomerMapper<OrdersLog> {
}
