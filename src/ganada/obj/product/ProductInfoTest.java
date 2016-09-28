package ganada.obj.product;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import ganada.core.DB;
import ganada.core.DBTester;

public class ProductInfoTest extends DBTester {
	public static ProductInfo productInfoOrg;

    @BeforeClass
    public static void init() {
    	productInfoOrg = new ProductInfo(); 	
    	productInfoOrg.setPd_infocontent("상품정보들");
    }

    @Test
    public void test() {
    	ProductInfoDao dao = ProductInfoDao.getInstance();
		try {
		    DB.OUTLN(dao.select("2").toString());
		} catch (Exception e) {
		    e.printStackTrace();
		}
    }

}