package io.swagger.codegen.mustache;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

import java.io.IOException;
import java.io.Writer;

/**
 * Removing forwardslash at the start of a string if it exists
 *
 * Register:
 * <pre>
 * additionalProperties.put("remove_initial_forwardslash", new RemoveInitialForwardslashLambda());
 * </pre>
 *
 * Use:
 * <pre>
 * {{#remove_initial_backslash}}{{path}}{{/remove_initial_backslash}}
 * </pre>
 */
public class RemoveInitialForwardslashLambda implements Mustache.Lambda {
    @Override
    public void execute(Template.Fragment fragment, Writer writer) throws IOException {
        String text = fragment.execute();
        if (text.length() > 0 && text.startsWith("/"))
            text = text.substring(1);
        writer.write(text);
    }
}
