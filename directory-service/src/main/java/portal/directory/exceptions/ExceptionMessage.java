package portal.directory.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
public class ExceptionMessage {
    private String exception;
    private HttpStatus errorCode;
    private LocalDateTime date;
}
