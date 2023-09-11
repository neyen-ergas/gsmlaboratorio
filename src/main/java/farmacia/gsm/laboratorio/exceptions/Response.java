package farmacia.gsm.laboratorio.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Response<T> {
    private List<ErrorCode> errors;
    private String message;
    private T data;

    public void addError(ErrorCode error) {
        if (Objects.isNull(this.errors)) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(error);
    }
}
