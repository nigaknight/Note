package beanCollection;

import java.util.Properties;

/**
 * @author micro soft
 * @version 1: Datasource, v 0.1 2019/7/1 17:07 micro soft Exp$
 */
public class Datasource {
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Datasource{" +
                "properties=" + properties +
                '}';
    }
}
