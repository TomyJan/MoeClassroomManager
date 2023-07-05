package tomyjan.moeclassroommanager.mapper;

import tomyjan.moeclassroommanager.common.CustomerMapper;
import tomyjan.moeclassroommanager.domain.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper extends CustomerMapper<Admin> {
}
