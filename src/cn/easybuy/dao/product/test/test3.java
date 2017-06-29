package cn.easybuy.dao.product.test;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.easybuy.dao.product.ProductMapper;
import cn.easybuy.utils.MyBatisUtil;

public class test3 {
	private Logger logger=Logger.getLogger(test3.class);
	@Test
	public void test() {
		SqlSession sqlSession=null;
		int count=0;
		Integer  id=771;
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			count=sqlSession.getMapper(ProductMapper.class).deleteProductById(id);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			count=0;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}if(count>0){
			logger.debug("删除成功");
		}else{
			logger.debug("删除失败");
		}
	}

}
