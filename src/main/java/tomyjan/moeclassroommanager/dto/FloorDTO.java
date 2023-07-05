package tomyjan.moeclassroommanager.dto;

import tomyjan.moeclassroommanager.domain.Floor;
import lombok.Data;

@Data
public class FloorDTO extends Floor {

    /**
     * 楼主
     */
    private String userName;
}
