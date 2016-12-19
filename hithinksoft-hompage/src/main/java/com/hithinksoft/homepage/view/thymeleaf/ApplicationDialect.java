package com.hithinksoft.homepage.view.thymeleaf;

import com.hithinksoft.homepage.view.helper.UrlHelper;
import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionEnhancingDialect;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author snowblink on 16/5/25.
 */
public class ApplicationDialect extends AbstractDialect implements IExpressionEnhancingDialect {

    private static final Map<String, Object> EXPRESSION_OBJECTS;
    static {
        Map<String, Object> objects = new HashMap<>();
        objects.put("urlHelper", new UrlHelper());
        EXPRESSION_OBJECTS = Collections.unmodifiableMap(objects);
    }

    @Override
    public Map<String, Object> getAdditionalExpressionObjects(IProcessingContext processingContext) {
        return EXPRESSION_OBJECTS;
    }

    @Override
    public String getPrefix() {
        return null;
    }
}
