package cn.easybuy.dao.product.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.easybuy.dao.product.ProductMapper;
import cn.easybuy.entity.Product;
import cn.easybuy.utils.MyBatisUtil;

public class test5 {
	private Logger logger=Logger.getLogger(test5.class);
	@Test
	public void test() {
		SqlSession sqlSession=null;
		Integer currentPageNo=0;
		Integer  pageSize=5;
		String proName="";
		Integer categoryId=null;
		Integer level=null;
		List<Product> productList=new ArrayList<Product>();
		try {
			sqlSession=MyBatisUtil.createSqlSession();
			productList=sqlSession.getMapper(ProductMapper.class).getProductList(currentPageNo, pageSize, proName, categoryId, level);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}for (Product product : productList) {
			logger.debug("id:"+product.getId()+"name:"+product.getName());
		}
	}

}
