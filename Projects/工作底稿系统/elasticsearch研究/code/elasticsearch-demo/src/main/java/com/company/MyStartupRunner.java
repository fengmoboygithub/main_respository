package com.company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 程序启动时执行
 * @author yangyanchao
 *
 */
@Component
public class MyStartupRunner implements CommandLineRunner {
	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(MyStartupRunner.class);

    /**
     * 运行代码
     */
    @Override
    public void run(String... args) throws Exception {

    }
}