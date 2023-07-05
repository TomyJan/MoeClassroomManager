package tomyjan.moeclassroommanager.dto;

import tomyjan.moeclassroommanager.domain.Approval;
import lombok.Data;

@Data
public class ApprovalDTO extends Approval {
    /**
     * 发起人
     */
    private String userName;

    /**
     * 一级审批人
     */
    private String opinionUser1;

    /**
     * 二级审批人
     */
    private String opinionUser2;

    /**
     * 教学楼
     */
    private String floorName;

    /**
     * 教室
     */
    private String roomName;

    private String scale;
    private String floor;
}
