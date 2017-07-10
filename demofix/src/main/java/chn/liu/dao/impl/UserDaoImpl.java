package chn.liu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import chn.liu.dao.IUserDao;
import chn.liu.entity.MybatisUser;

@Repository
public class UserDaoImpl implements IUserDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void dropTable() {
		jdbcTemplate.update("drop table t_user if exists");
	}

	// "create table t_user (id bigint generated by default as identity, age integer, name varchar(255), primary key (id))"
	@Override
	public void createTable() {
		jdbcTemplate.update("create table t_user("
				+ "id bigint generated by default as identity,"
				+ " age integer,"
				+ " name varchar(255),"
				+ " primary key (id)"
				+ ")");		
	}

	@Override
	public void save(MybatisUser user) {
		jdbcTemplate.update("insert into t_user(name, age) values(?, ?)", user.getName(), user.getAge());		
	}

	@Override
	public List<MybatisUser> findAll() {
		List<MybatisUser> users = jdbcTemplate.query("select id, name, age from t_user", BeanPropertyRowMapper.newInstance(MybatisUser.class));
		return users;
	}

	@Override
	public void deleteAll() {
		jdbcTemplate.update("delete t_user");		
	}

	@Override
	public List<MybatisUser> findByNameLike(String name) {
		List<MybatisUser> users = jdbcTemplate.query("select id, name, age from t_user where name like ?", new Object[]{ name}, BeanPropertyRowMapper.newInstance(MybatisUser.class));
		return users;
	}

}