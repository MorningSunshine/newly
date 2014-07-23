package org.my.framework;

import javax.inject.Inject;

import org.my.framework.entity.Manager;
import org.my.framework.jms.ProduceService;
import org.my.framework.repo.ManagerDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransationTestBean {
	@Inject
	private ProduceService produceService;
	@Inject
	private ManagerDao managerDao;

	public void test() {
		produceService.send("test", "test".getBytes());

		Manager m = new Manager();
		m.setUsername("test1");
		m.setPassword("test");
		managerDao.save(m);
	}
}