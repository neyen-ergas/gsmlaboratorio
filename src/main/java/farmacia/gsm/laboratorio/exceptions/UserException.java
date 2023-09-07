package farmacia.gsm.laboratorio.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserException extends Throwable{
    private final String message;
    private final ErrorCode errorCode;
}