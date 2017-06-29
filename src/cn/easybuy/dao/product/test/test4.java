package cn.easybuy.dao.product.test;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.easybuy.dao.product.ProductMapper;
import cn.easybuy.entity.Product;
import cn.easybuy.utils.MyBatisUtil;

public class test4 {
	private Logger logger=Logger.getLogger(test4.class);
	@Test
	public void test() {
		SqlSession sqlSession=null;
		Integer id=759;
		Product product=null;
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			product=sqlSession.getMapper(ProductMapper.class).getProductById(id);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		logger.debug("id:"+product.getId()+"name:"+product.getName());
	}

}
