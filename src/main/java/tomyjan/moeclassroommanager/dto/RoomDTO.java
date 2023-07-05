package tomyjan.moeclassroommanager.dto;

import tomyjan.moeclassroommanager.domain.Room;
import lombok.Data;

@Data
public class RoomDTO extends Room {

    /**
     * 辅导员
     */
    private String userName;

    /**
     * 教学楼
     */
    private String floorName;
}
