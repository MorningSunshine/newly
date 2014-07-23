package org.my.framework.jms;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.my.framework.jms.ProduceService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JmsTest {

	@Inject
	private ProduceService produceService;

	@Test
	public void test() {
		produceService.send("test", "hello world".getBytes());
	}

}
