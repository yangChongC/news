package cn.easybuy.dao.product.test;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.easybuy.dao.product.ProductMapper;
import cn.easybuy.entity.Product;
import cn.easybuy.utils.MyBatisUtil;

public class test2 {
	private Logger logger=Logger.getLogger(test2.class);
	@Test
	public void test() {
		SqlSession sqlSession=null;
		int count=0;
		Product product=new Product();
		product.setName("小米10s");
		product.setDescription("国产神机");
		product.setId(771);
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			count=sqlSession.getMapper(ProductMapper.class).update(product);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			count=0;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}if(count>0){
			logger.debug("修改成功");
		}else{
			logger.debug("修改失败");
		}
	}

}
