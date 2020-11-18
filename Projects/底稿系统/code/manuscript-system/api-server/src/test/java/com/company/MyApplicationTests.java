package com.company;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("Spring Boot Test");
	}
	@BeforeClass
	public static void before() {
		System.setProperty("es.set.netty.runtime.available.processors", "false");
	}
}
