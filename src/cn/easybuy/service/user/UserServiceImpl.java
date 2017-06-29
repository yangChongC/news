package cn.easybuy.service.user;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import cn.easybuy.dao.user.UserMapper;
import cn.easybuy.entity.User;
import cn.easybuy.utils.MyBatisUtil;

public class UserServiceImpl implements UserService {
	
	private Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Override
	public boolean add(User user){
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if(sqlSession.getMapper(UserMapper.class).add(user) > 0)
               flag = true;
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sqlSession.rollback();
			flag = false;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return flag;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if(sqlSession.getMapper(UserMapper.class).update(user) > 0)
               flag = true;
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sqlSession.rollback();
			flag = false;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return flag;
	}

	@Override
	public boolean deleteUserById(Integer userId) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if(sqlSession.getMapper(UserMapper.class).deleteUserById(userId) > 0)
               flag = true;
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sqlSession.rollback();
			flag = false;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return flag;
	}

	@Override
	public User getUser(Integer userId, String loginName) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		User user = new User();
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			user = sqlSession.getMapper(UserMapper.class).getUser(userId, loginName);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			user = null;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return user;
	}

	@Override
	public List<User> getUserList(Integer currentPageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		List<User> userList = new ArrayList<User>();
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			currentPageNo = (currentPageNo-1)*pageSize;
			userList = sqlSession.getMapper(UserMapper.class).getUserList(currentPageNo, pageSize);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			userList = null;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		logger.debug("userList size: " + userList.size());
		return userList;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		int count = 0;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			count = sqlSession.getMapper(UserMapper.class).count();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			count = 0;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return count;
	}
}
