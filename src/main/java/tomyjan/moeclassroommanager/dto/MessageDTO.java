package tomyjan.moeclassroommanager.dto;

import tomyjan.moeclassroommanager.domain.Message;
import lombok.Data;

@Data
public class MessageDTO extends Message {

    /**
     *
     */
    private String userName;

    /**
     *
     */
    private String roomName;

    /**
     *
     */
    private String floorName;
}
