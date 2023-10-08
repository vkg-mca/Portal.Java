package codefactory.logger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder//Builder method implements
public class LogInfo
{
    public LogLevel logLevel;
    public Date dateTime;
    public String componentName;
    public String className;
    public String methodName;
    public String message;
    public String extendedMessage;
    public Exception exception;
}
