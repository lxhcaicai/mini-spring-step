package org.springframework.test.ioc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.ioc.bean.Person;

public class PopulateBeanWithPropertyValuesTest {

    @Test
    public void PopulateBeanWithPropertyValues() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name","derek"));
        propertyValues.addPropertyValue(new PropertyValue("age", 18));

        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValues);
        beanFactory.registerBeanDefinition("person",beanDefinition);

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
        Assertions.assertEquals(person.getName(),"derek");
        Assertions.assertEquals(person.getAge(), 18);
    }
}
