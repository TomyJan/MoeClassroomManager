package tomyjan.moeclassroommanager.domain;

import tomyjan.moeclassroommanager.common.base.dto.BaseDomain;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Table;

/**
 * 预约表
 */
@Data
@Table(name = "orders")
@Accessors(chain = true)
public class Approval extends BaseDomain {

    /**
     *
     */
    private Integer userId;

    /**
     * 预约教室
     */
    private Integer roomId;

    /**
     * 预约时间
     */
    private String orderTime;

    /**
     * 一级审批意见
     */
    private String opinion1;
    /**
     * 二级审批意见
     */
    private String opinion2;

    /**
     * 预约时间
     */
    private String week;

    private ApprovalStatusEnum status;


    public enum ApprovalStatusEnum {
        /**
         * 待审核
         */
        WAIT,
        /**
         * 超时
         */
        OVER_TIME,
        /**
         * 同意
         */
        AGREE_1,
        /**
         * 拒绝
         */
        REJECT_1,
        AGREE_2,
        /**
         * 拒绝
         */
        REJECT_2;
    }
}
