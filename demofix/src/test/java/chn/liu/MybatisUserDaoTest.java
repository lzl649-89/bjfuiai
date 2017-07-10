package chn.liu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import chn.liu.entity.MybatisUser;
import chn.liu.mapper.IUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class MybatisUserDaoTest {

	@Autowired
	IUserMapper userDao;
	
	@Before
	public void before() throws Exception {
		userDao.dropTable();
		userDao.createTable();
	}
	
	@Test
	public void proxy() {
		System.out.println(userDao.getClass());
	}
	
	@Test
	public void save() throws Exception {
		for (int i = 0; i < 10; i++) {
			MybatisUser newgee = new MybatisUser("test" + i, 25 + i);
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
