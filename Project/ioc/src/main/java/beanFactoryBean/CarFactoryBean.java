package beanFactoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author micro soft
 * @date 2019/7/6 10:31
 */
public class CarFactoryBean implements FactoryBean {
    private String brand;

    public void setBrand(String brand){
        this.brand=brand;
    }

    public Object getObject() throws Exception {
        return new Car(brand,500000);
    }

    public Class<?> getObjectType() {
        return Car.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
