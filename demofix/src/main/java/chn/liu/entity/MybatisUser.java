package chn.liu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="用户实体类(Mybatis、JDBC)")
public class MybatisUser {
	@ApiModelProperty(value="用户ID", dataType="Long")
	private Long id;

	@ApiModelProperty(value="用户名", dataType="String")
	private String name;
	@ApiModelProperty(value="用户年龄", dataType="Integer")
	private Integer age;

	public MybatisUser() {
		super();
	}

	public MybatisUser(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public MybatisUser(Long id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
