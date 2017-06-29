package cn.easybuy.dao.user;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.easybuy.entity.User;

/**
 *  UserMapper接口方法：
 * （1）增加用户（返回类型：int，参数：User对象）。
 * （2）根据用户id修改用户信息（返回类型：int，参数：User对象）。
 * （3）根据用户id删除用户信息（返回类型：int，参数：用户id）。
 * （4）根据查询条件（id、loginName）获取用户信息（返回类型：User，参数：用户id,登录名称）。
 * （5）分页显示用户信息列表（返回类型：List<User>，参数：当前页码、页码容量）。
 * （6）查询用户表总记录数（返回类型：int，参数：用户id）。
 */
public interface UserMapper {
	
	public int add(User user) throws Exception;
	
	public int update(User user) throws Exception;
	
	public int deleteUserById(@Param("id")Integer userId) throws Exception;
	
	public User getUser(@Param("id")Integer userId,@Param("loginName")String loginName) throws Exception;
	
	public List<User> getUserList(@Param("from")Integer currentPageNo,@Param("pageSize")Integer pageSize) throws Exception;
	
	public int count() throws Exception;
	
	
}
