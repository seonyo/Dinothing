package com.example.Dinothing.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    INTER_SERVER_ERROR(500, "SERVER-ERROR-500", "내부 서버 오류가 발생했습니다."),
    EMAIL_DUPLICATION(400, "USER-ERROR-400", "이미 가입된 이메일 입니다."),
    EMAIL_NOTFOUND(404, "USER-ERROR-404", "가입된 이메일이 아닙니다"),
    PASSWORD_NOTFOUND(404, "USER-ERROR-404", "비밀번호가 일치하지 않습니다.");

    private int status;
    private String errorCode;
    private String errorMessage;

}
