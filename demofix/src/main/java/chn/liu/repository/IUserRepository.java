package chn.liu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import chn.liu.entity.User;

public interface IUserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
	List<User> findByNameLike(String name);
}
