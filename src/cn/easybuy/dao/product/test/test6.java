package cn.easybuy.dao.product.test;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.easybuy.dao.product.ProductMapper;
import cn.easybuy.utils.MyBatisUtil;

public class test6 {
	private Logger logger=Logger.getLogger(test6.class);
	@Test
	public void test() {
		SqlSession sqlSession=null;
		String proName="香";
		Integer categoryId=null;
		Integer level=null;
		int count=0;
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			count=sqlSession.getMapper(ProductMapper.class).queryProductCount(proName, categoryId, level);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		logger.debug("count:"+count);
	}

}
