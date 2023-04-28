import com.shuhai65.CacheService;
import com.shuhai65.SimpleCacheService;
import com.shuhai65.cuisine.impl.AbstractFactoryCacheServiceImpl;
import com.shuhai65.cuisine.impl.SimpleCacheServiceImpl;
import com.shuhai65.factory.JDKProxy;
import com.shuhai65.factory.impl.EGMCacheAdapter;
import org.junit.Test;

public class ApiTest {
    @Test
    public void testSimpleCacheService() {
        SimpleCacheService simpleCacheService = new SimpleCacheServiceImpl();
        simpleCacheService.set("user_name_01", "Tom", 1);
        String val = simpleCacheService.get("user_name_01", 1);
        System.out.println(val);
    }

    @Test
    public void testAbstractCacheService() throws Exception {
        CacheService proxy_EGM = JDKProxy.getProxy(AbstractFactoryCacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("user_name_01", "Tom");
        String val = proxy_EGM.get("user_name_01");
        System.out.println(val);

        CacheService proxy_IIR = JDKProxy.getProxy(AbstractFactoryCacheServiceImpl.class, new EGMCacheAdapter());
        proxy_IIR.set("user_name_01", "jame");
        String val1 = proxy_IIR.get("user_name_01");
        System.out.println(val1);
    }
}
