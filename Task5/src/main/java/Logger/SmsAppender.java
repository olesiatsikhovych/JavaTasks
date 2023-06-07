package Logger;

import org.apache.logging.log4j.core.*;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.*;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.io.Serializable;

@Plugin(name = "SMS", category = "Core", elementType = "appender", printObject = true)
public class SmsAppender extends AbstractAppender {
    protected SmsAppender(String name, Filter filter,
                          Layout<? extends Serializable> layout, final boolean ignoreExceptions) {
        super(name, filter, layout, ignoreExceptions);
    }

    public void append(LogEvent event) {
        try {
            SmsSender.send(new String(getLayout().toByteArray(event)));
        } catch (Exception ex) {
        }
    }

    @PluginFactory
    public static SmsAppender createAppender(
            @PluginAttribute("name") String name,
            @PluginElement("Layout") Layout<? extends Serializable> layout,
            @PluginElement("Filter") final Filter filter,
            @PluginAttribute("otherAttribute") String otherAttribute) {
        if (name == null) {
            LOGGER.error("No name provided for MyCustomAppenderImpl");
            return null;
        }
        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }
        return new SmsAppender(name, filter, layout, true);
    }
}
