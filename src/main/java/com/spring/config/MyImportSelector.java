package com.spring.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata metadata) {
		
		metadata.getAnnotationTypes().stream().forEach(System.out::println);
		return new String[] {};
	}

}
