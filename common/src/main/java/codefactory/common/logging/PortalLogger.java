package codefactory.common.logging;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PortalLogger implements IPortalLogger {
    /**
     * @param component project name
     * @param module class name
     * @param method method name
     * @param message message
     */
    @Override
    public void LogInfo(String component, String module, String method, String message) {
        log.info("Project:{}, Class:{}, Method:{}, Message:{}",component,module,method,message);
    }
}
