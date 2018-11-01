package com.spring.factory;

import org.springframework.beans.factory.FactoryBean;

import com.spring.bean.Color;

public class MyFactoryBean implements FactoryBean<Color> {

	@Override
	public Color getObject() throws Exception {
		return new Color();
	}

	@Override
	public Class<?> getObjectType() {
		return Color.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}


}
