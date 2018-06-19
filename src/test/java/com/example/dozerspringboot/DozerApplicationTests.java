package com.example.dozerspringboot;

import org.assertj.core.api.Assertions;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DozerApplicationTests {

	@Autowired
	private Mapper dozerMapper;

	@Test
	public void contextLoads() {
		Source source = new Source();
		source.value = "test";

		Destination destination = dozerMapper.map(source, Destination.class);

		Assertions.assertThat(destination)
				.hasFieldOrPropertyWithValue("value", "test");

		@SuppressWarnings("deprecation")
		List<String> mappingFiles = DozerBeanMapper.class.cast(dozerMapper).getMappingFiles();
		Assertions.assertThat(mappingFiles).isNotEmpty();
	}

	static class Source {
		private String value;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	static class Destination {
		private String value;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

}
