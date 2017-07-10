package chn.liu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "t_user")
@ApiModel(value="用户实体类(JPA)")
public class User {
	@Id
	@GeneratedValue
	@ApiModelProperty(value="用户ID", dataType="Long")
	private Long id;
	
	@ApiModelProperty(value="用户名", dataType="String")
	private String name;
	@ApiModelProperty(value="用户年龄", dataType="Integer")
	private Integer age;

	public User() {
		super();
	}

	public User(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public User(Long id, String name, Integer age) {
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
