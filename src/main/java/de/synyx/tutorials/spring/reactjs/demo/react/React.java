package de.synyx.tutorials.spring.reactjs.demo.react;

import de.synyx.tutorials.spring.reactjs.demo.product.Product;
import de.synyx.tutorials.spring.reactjs.demo.utils.Fetch;
import jdk.nashorn.api.scripting.NashornScriptEngine;
import org.springframework.stereotype.Component;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.util.List;

@Component
public class React {

    public String renderProducts(List<Product> products, String sortBy) throws ScriptException {
        NashornScriptEngine nashornScriptEngine = getNashornScriptEngine();

        try {
            Object html = nashornScriptEngine.invokeFunction("renderServer", products, sortBy);
            return String.valueOf(html);
        } catch (Exception e) {
            throw new IllegalStateException("failed to renderProducts react component", e);
        }
    }

    private NashornScriptEngine getNashornScriptEngine() throws ScriptException {
        NashornScriptEngine nashornScriptEngine = (NashornScriptEngine) new ScriptEngineManager().getEngineByName("nashorn");
        nashornScriptEngine.eval("load ('src/main/resources/static/nashorn-polyfill.js')");

        // @Todo(u) add 'if env == development'
        try {
            String bundleJs = new Fetch().fetch("http://localhost:8081/assets/bundle.js");
            nashornScriptEngine.eval(bundleJs);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // @Todo(u) add 'else'
        // nashornScriptEngine.eval("load ('src/main/resources/static/bundle.js')");

        return nashornScriptEngine;
    }
}
