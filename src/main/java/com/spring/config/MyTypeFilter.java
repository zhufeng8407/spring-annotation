package com.spring.config;

import java.io.IOException;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyTypeFilter implements TypeFilter {

	@Override
	public boolean match(MetadataReader reader, MetadataReaderFactory readerFactory) throws IOException {
		
		return reader.getAnnotationMetadata().getClassName().contains("Con");
	}

}
