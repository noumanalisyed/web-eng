import com.techno.products.dao.ProductDao;
import com.techno.products.entity.Product;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class DAOTest {

    @Resource(name="jdbc/products")
    private DataSource dataSource;

    ProductDao productDao;
    List<Product> products;
    @Before
    public void init(){
        products = new ArrayList<Product>();
        products.add(new Product("Coke","Beverages","Coke"));
        products.add(new Product("Pepsi","Beverages","Pepsi"));
        productDao = new ProductDao(dataSource);
        System.out.println("Initializing -- Product Test ");

    }

    public void addProduct(Product product){
        try {
            productDao.addProduct(product);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testProductAdd(){
        for (Product product:products){
            addProduct(product);
        }
    }
}
