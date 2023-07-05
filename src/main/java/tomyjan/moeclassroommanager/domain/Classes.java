package tomyjan.moeclassroommanager.domain;

import tomyjan.moeclassroommanager.common.base.dto.BaseDomain;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Classes extends BaseDomain {

    /**
     * 辅导员ID
     */
    private Integer userId;

    /**
     * 名字
     */
    @NotBlank(message = "班级名字必填")
    private String name;
}
