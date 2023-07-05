package tomyjan.moeclassroommanager.common.mybatis.condition;

import lombok.Getter;

import java.util.List;

/**
 * 查询条件
 */
@Getter
public class Criterion {
    private String condition;

    private Object value;

    private Object secondValue;

    private boolean noValue;

    private boolean singleValue;

    private boolean betweenValue;

    private boolean listValue;

    Criterion(String condition) {
        this.condition = condition;
        this.noValue = true;
    }

    Criterion(String condition, Object value) {
        this.condition = condition;
        this.value = value;
        if (value instanceof List<?>) {
            this.listValue = true;
        } else {
            this.singleValue = true;
        }
    }

    Criterion(String condition, Object value, Object secondValue) {
        this.condition = condition;
        this.value = value;
        this.secondValue = secondValue;
        this.betweenValue = true;
    }

}