package io.swagger.codegen.mustache;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

import java.io.IOException;
import java.io.Writer;

/**
 * Adding trailing forwardslash if it doesn't not exist
 *
 * Register:
 * <pre>
 * additionalProperties.put("add_trailing_forwardslash", new AddTrailingForwardslashLambda());
 * </pre>
 *
 * Use:
 * <pre>
 * {{#add_trailing_forwardslash}}{{path}}{{/add_trailing_forwardslash}}
 * </pre>
 */
public class AddTrailingForwardslashLambda implements Mustache.Lambda {
    @Override
    public void execute(Template.Fragment fragment, Writer writer) throws IOException {
        String text = fragment.execute();
        if (!text.endsWith("/"))
            text += "/";
        writer.write(text);
    }
}
