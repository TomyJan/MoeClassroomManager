package tomyjan.moeclassroommanager.domain;

import tomyjan.moeclassroommanager.common.base.dto.BaseDomain;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Table;
import java.io.Serializable;

@Data
@Accessors(chain = true)
@Table(name = "Login_Log")
public class LoginLog extends BaseDomain implements Serializable {

    /**
     *
     */
    private String username;

    /**
     *
     */
    private Integer userId;

    /**
     *
     */
    private String ip;
}
