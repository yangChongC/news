package cn.easybuy.dao.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.easybuy.entity.Product;



public interface ProductMapper {
	public int  add(Product product) throws Exception;
	
	public int update(Product product) throws Exception;
	
	public int deleteProductById(@Param("id")Integer productId) throws Exception;
	
	public Product getProductById(@Param("id")Integer productId) throws Exception;
	
	public List<Product> getProductList(@Param("from")Integer currentPageNo,
										@Param("pageSize")Integer pageSize,
										@Param("proName")String proName,
										@Param("categoryId")Integer categoryId,
										@Param("level")Integer level);
	
	public int queryProductCount(@Param("proName")String proName,
								 @Param("categoryId")Integer categoryId,
								 @Param("level")Integer level)throws Exception;
	
	
	Integer updateStock(@Param("id")Integer id,@Param("quantity") Integer quantity) throws Exception;
}




