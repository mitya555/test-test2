package test.test2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InitApp implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String id) throws BeansException {
		if (bean instanceof Person) {
			System.out.println(id + ": before init; name: " + ((Person)bean).getName() + "; age: " + ((Person)bean).getAge());
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String id) throws BeansException {
		if (bean instanceof Person) {
			System.out.println(id + ": after init; name: " + ((Person)bean).getName() + "; age: " + ((Person)bean).getAge());
		}
		return bean;
	}

}

