package chn.liu.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import chn.liu.entity.User;
import chn.liu.repository.IUserRepository;

@Component
public class InitApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private IUserRepository userDao;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
//		ApplicationContext context = event.getApplicationContext();
//		IUserRepository userDao = context.getBean("userDao", IUserRepository.class);
		for (int i = 0; i < 25; i++) {
			User user = new User("user" + i, 25 + i);
			userDao.save(user);
		}
	}

}
