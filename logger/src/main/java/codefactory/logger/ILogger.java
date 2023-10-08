package codefactory.logger;

import org.springframework.boot.logging.LogLevel;

public interface ILogger {
    public void Log(LogInfo log);
    public void LogFatal(String componentName, String className, String methodName, String message, Exception exception,String extendedMessage);
    public void LogError(String componentName, String className, String methodName, String message, Exception exception,String extendedMessage);
    public void LogInfo(String componentName, String className, String methodName, String message, String extendedMessage);
    public void LogDebug(String componentName, String className, String methodName, String message, String extendedMessage);
}


