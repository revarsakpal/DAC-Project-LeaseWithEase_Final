package com.LeaseWithEaseBackend.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LeaseWithEaseBackend.Model.Product;
import com.LeaseWithEaseBackend.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
@Autowired
ProductRepository pRepository;

@Override
public List<Product> getAllProducts() {
	return pRepository.findAll();
}

@Override
public Product getProductById(int p_id) {
	Optional<Product> op=pRepository.findById(p_id);
	return op.get();
}

@Override
public void addNewProduct(Product product) {
	pRepository.save(product);
}

@Override
public void updateProduct(Product updatedproduct) {
Product existingProduct=getProductById(updatedproduct.getP_id());	
existingProduct.setProd_name(updatedproduct.getProd_name());
existingProduct.setProd_desc(updatedproduct.getProd_desc());
existingProduct.setProd_img_url(updatedproduct.getProd_img_url());
existingProduct.setStock(updatedproduct.getStock());
existingProduct.setProductCategory(updatedproduct.getProductCategory());
existingProduct.setSubCategory(updatedproduct.getSubCategory());
pRepository.save(existingProduct);

}

@Override
public void deleteProduct(int p_id) {
pRepository.deleteById(p_id);	
}

@Override
public List<Product> getAllSubcaterisedProducts(int pc_id,int psc_id) {
	List<Product> listProducts=getAllProducts();
	List<Product> plist=new ArrayList<Product>();
	for(Product p : listProducts) {
		if(p.getProductCategory().getPc_id()==pc_id && p.getSubCategory().getPsc_id()==psc_id){
			plist.add(p);
		}
	}
	
return plist;
}
}
