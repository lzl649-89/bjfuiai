package chn.liu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import chn.liu.entity.MybatisUser;

@Mapper
public interface IUserMapper {
	
	@Delete("drop table t_user if exists")
	void dropTable();
	
	@Insert("create table t_user (" +
				"id bigint generated by default as identity," +
				" age integer," +
				" name varchar(255)," +
				" primary key(id)" +
			")")
	
	// "create table t_user (id bigint generated by default as identity, age integer, name varchar(255), primary key (id))"
	void createTable();
	
	
	@Insert("insert into t_user(name, age) values(#{name}, #{age})")
	void save(MybatisUser user);
	
	@Delete("delete t_user")
	void deleteAll();
	
	@Select("select id, name, age from t_user")
	List<MybatisUser> findAll();
	
	@Select("select id, name, age from t_user where name like #{name}")
	List<MybatisUser> findByNameLike(String name);
}
