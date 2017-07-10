package chn.liu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import chn.liu.entity.User;
import chn.liu.json.AjaxResult;
import chn.liu.repository.IUserRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	IUserRepository userDao;

	// 显示用户列表页面
	@ApiOperation(value = "获取用户列表", httpMethod="GET", notes = "获取用户列表跳转显示界面")
	@RequestMapping("/list")
	public String list() {
		return "user";
	}

	// 从user.jsp列表页面由easyui-datagrid发出ajax请求获取json数据
	@ApiOperation(value = "获取用户列表，支持分页", httpMethod="GET", notes = "ajax json方法获取用户列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "page", value = "当前页码", required = true, dataType = "int"),
			@ApiImplicitParam(name = "rows", value = "每页条数", required = true, dataType = "int") })
	@RequestMapping("/json")
	@ResponseBody
	public Map<String, Object> json(@RequestParam(name = "page", defaultValue = "1") int page,
										@RequestParam(name = "rows", defaultValue = "10") int rows, final String q) {
		// 按照id降序
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		// 封装分页查询条件
		Pageable pageable = new PageRequest(page - 1, rows, sort);
		if (!StringUtils.isEmpty(q)) {
			// 拼接查询条件
			Specification<User> specification = new Specification<User>() {
				@Override
				public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					List<Predicate> list = new ArrayList<Predicate>();
					list.add(cb.like(root.get("name").as(String.class), "%" + q + "%"));
					Predicate[] p = new Predicate[list.size()];
					return cb.and(list.toArray(p));

				}
			};
			return findEasyUIData(userDao.findAll(specification, pageable));
		} else {
			return findEasyUIData(userDao.findAll(pageable));
		}

	}

	// 处理保存
	@ApiOperation(value = "保存用户", httpMethod="POST", notes = "根据User对象操作用户")
//	@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(@ApiParam(value = "用户信息") @RequestBody User user) {
		userDao.save(user);
		return new AjaxResult().success();
	}

	// 处理删除
	@ApiOperation(value = "删除用户", httpMethod="GET", notes = "根据url的id来指定删除对象")
	@ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id) {
		int a = 1 / 0;
		userDao.delete(id);
		return new AjaxResult().success();
	}
}
