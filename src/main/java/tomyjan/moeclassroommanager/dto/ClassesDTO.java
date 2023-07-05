package tomyjan.moeclassroommanager.dto;

import tomyjan.moeclassroommanager.domain.Classes;
import lombok.Data;

@Data
public class ClassesDTO extends Classes {

    /**
     * 辅导员名字
     */
    private String userName;
}
