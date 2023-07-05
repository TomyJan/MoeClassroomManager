package tomyjan.moeclassroommanager.domain;

import tomyjan.moeclassroommanager.common.base.dto.BaseDomain;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Admin extends BaseDomain implements Serializable {

    @NotEmpty(message = "账号不能为空")
    private String username;

    private String password;

    /**
     *
     */
    private String type;
}
