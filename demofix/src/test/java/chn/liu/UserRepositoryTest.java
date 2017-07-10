package chn.liu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import chn.liu.repository.IUserRepository;
import chn.liu.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class UserRepositoryTest {

	@Autowired
	IUserRepository userDao;
	
	@Test
	public void proxy() {
		System.out.println(userDao.getClass());
	}
	
	@Test
	public void save() throws Exception {
		for (int i = 0; i < 10; i++) {
			User newgee = new User("test" + i, 25 + i);
			userDao.save(newgee);
		}
	}
	
	@Test
	public void all() throws Exception {
		save();
		assertThat(userDao.findAll()).hasSize(10);
	}
	
	@Test
	public void findAllByName() throws Exception {
		save();
		assertThat(userDao.findByNameLike("test%")).hasSize(10);
	}
	
	@After
	public void destory() throws Exception {
		userDao.deleteAll();
	}
}
