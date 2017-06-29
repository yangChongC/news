package cn.easybuy.dao.product.test;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.easybuy.dao.product.ProductMapper;
import cn.easybuy.entity.Product;
import cn.easybuy.utils.MyBatisUtil;

public class test1 {
	private Logger logger=Logger.getLogger(test1.class);
	@Test
	public void test() {
		SqlSession sqlSession=null;
		int count=0;
		Product product=new Product();
		product.setName("苹果10");
		product.setDescription("高端品牌手机");
		product.setPrice((float) 500);
		product.setStock(1000);
		product.setCategoryLevel1Id(548);
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			count=sqlSession.getMapper(ProductMapper.class).add(product);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			count=0;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}if(count>0){
			logger.debug("添加成功");
		}else{
			logger.debug("添加失败");
		}
	}

}
