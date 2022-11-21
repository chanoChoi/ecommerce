package com.example.ecommerce.global;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@Builder
public class SuccessResponse {
    private HttpStatus status;
    private int code;
    private String msg;
    private Object data;

    // 적절한 변수명을 모르겠습니다. 아니면 접근방식을 변경해야하나 고민중...
    public static SuccessResponse sendWithoutObject(HttpStatus status, String msg) {
        return sendWithObject(status, msg, null);
    }

    // 적절한 변수명을 모르겠습니다. 아니면 접근방식을 변경해야하나 고민중...
    public static SuccessResponse sendWithObject(HttpStatus status, String msg, Object data) {
        return SuccessResponse.builder()
                .status(status)
                .code(status.value())
                .msg(msg)
                .data(data)
                .build();
    }
}
