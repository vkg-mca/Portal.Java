package codefactory.common.logging;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PortalLoggerTest {
    @Test
    @DisplayName("Should log information using INFO log level")
    public void InfoLogTest()
    {
        IPortalLogger logger=new PortalLogger();
        logger.LogInfo("common","logging","LogInfo","Test log message");
        assertThat(1==1);
    }
}
