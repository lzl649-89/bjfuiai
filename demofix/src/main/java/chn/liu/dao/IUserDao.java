package chn.liu.dao;

import java.util.List;

import chn.liu.entity.MybatisUser;

public interface IUserDao {
	void dropTable();

	void createTable();

	void save(MybatisUser user);

	List<MybatisUser> findAll();

	void deleteAll();

	List<MybatisUser> findByNameLike(String name);

}
