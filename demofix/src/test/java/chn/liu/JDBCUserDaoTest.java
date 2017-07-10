package chn.liu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import chn.liu.dao.IUserDao;
import chn.liu.entity.MybatisUser;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class JDBCUserDaoTest {

	@Autowired
	IUserDao userDao;

	@Before
	public void before() {
		userDao.dropTable();
		userDao.createTable();
	}

	@Test
	public void proxy() {
		System.out.println(userDao.getClass());
	}

	@Test
	public void save() {
		for (int i = 0; i < 10; i++) {
			MybatisUser newgee = new MybatisUser("test" + i, 25 + i);
			userDao.save(newgee);
		}
	}

	@Test
	public void all() {
		save();
		assertThat(userDao.findAll()).hasSize(10);
	}

	@Test
	public void findAllByName() {
		save();
		assertThat(userDao.findByNameLike("test%")).hasSize(10);
	}

	@Test
	public void delete() {
		userDao.deleteAll();
	}
}
