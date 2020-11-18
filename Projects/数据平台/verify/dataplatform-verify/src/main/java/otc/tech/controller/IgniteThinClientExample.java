package otc.tech.controller;

import java.util.Arrays;

import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.ClientException;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.ClientConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import otc.tech.model.City;
import otc.tech.model.Province;
@RestController
@RequestMapping("/test")
public class IgniteThinClientExample {
    private static  ClientCache<Integer, Province> provinceCache;
    private static  ClientCache<String, City> cityCache;
    @GetMapping("/test")
	@ResponseBody
    public  void test() {
        System.out.println();
        System.out.println("Ignite thin client example started.");
        //连接到Ignite集群,默认端口号为10800
        ClientConfiguration cfg = new ClientConfiguration().setAddresses("10.0.48.60:9981");
 
        //用java的try-with-resource statement启动client
        try (IgniteClient igniteClient = Ignition.startClient(cfg)){
        	String[] args1=new String[]{"张三","李四","王五"};
            System.out.println();
            System.out.println("Begin create cache and insert data.");
            //创建两个缓存,具体步骤见该函数
            creatCacheAndInsertData(igniteClient);
 
            System.out.println();
            System.out.println("Begin query cache.");
            //根据输入开始查询
            for(String city : args1)
            {
                //先用城市名字,查询city缓存
                City c = cityCache.get(city);
                Province p = null;
                if (c != null)
                {
                    //在用城市数据中的province id查询province缓存
                    p = provinceCache.get(c.getProvinceId());
                }
                //输出查询结果
                if (c != null && p != null) {
                    System.out.println("Find " + c.getName() + " in province " + p.getName());
                }
                else
                {
                    System.out.println("Cannot find " + city + " in any province.");
                }
            }
        }
        catch (ClientException e) {
            System.err.println(e.getMessage());
        }
        catch (Exception e) {
            System.err.format("Unexpected failure: %s\n", e);
        }
    }
 
    private static void creatCacheAndInsertData(IgniteClient igniteClient)
    {
        //创建province缓存,用来存放省份信息,该缓存以省的id为key
        final String PROVINCE_CACHE_NAME = "province";
        provinceCache = igniteClient.getOrCreateCache(PROVINCE_CACHE_NAME);
 
        //往province缓存中写入一些数据
        int provinceId = 1;
        final Province on = new Province(provinceId++, "Ontario");
        final Province ab = new Province(provinceId++, "Alberta");
        final Province qc = new Province(provinceId++, "Quebec");
 
        provinceCache.put(on.getId(), on);
        provinceCache.put(ab.getId(), ab);
        provinceCache.put(qc.getId(), qc);
        System.out.println("Successfully insert all provinces data.");
 
        //创建city缓存,用来存放城市信息,该缓存以城市的名字为key
        final String CITY_CACHE_NAME = "city";
        cityCache = igniteClient.getOrCreateCache(CITY_CACHE_NAME);
        //往city缓存写入一些数据
        int cityId = 1;
        final City toronto = new City(cityId++, "Toronto", on.getId());
        final City edmonton = new City(cityId++, "Edmonton", ab.getId());
        final City calgary = new City(cityId++, "Calgary", ab.getId());
        final City montreal = new City(cityId++, "Montreal", qc.getId());
 
        cityCache.put(toronto.getName(), toronto);
        cityCache.put(edmonton.getName(), edmonton);
        cityCache.put(calgary.getName(), calgary);
        cityCache.put(montreal.getName(), montreal);
        System.out.println("Successfully insert all city data.");
    }
    
    
    public static void main(String[] args) {
    	//Ignition.setClientMode(true);
    	 
        try(Ignite ignite = Ignition.start("D:\\default-config.xml")){
        	
        	// 缓存配置
            CacheConfiguration<Integer, String> cacheCfg = new CacheConfiguration<Integer, String>();
            cacheCfg.setName("myCache");
        	// 设置缓存过期时间
            cacheCfg.setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(Duration.ONE_MINUTE));
        	
        	/**
        	 * 缓存系统中的存储和获取是同步操作
        	 * 在ignite集群中创建名称为simple的分布式缓存。第二次启动时，
        	 * 名称为simple的缓存已经存在获取该缓存，把put语句注释掉仍然可以获取到值
        	 */
            // 如果缓存不存在就创建，如果已存在就获取缓存 
           /* IgniteCache<Integer,String> cache = ignite.getOrCreateCache("simple");
            for(int i = 0; i < 10; i++){
                cache.put(i, i+"haha");
            }
            for(int i=0; i< 10; i++){
                System.out.println(cache.get(i));
            }*/
            
            /**
             * 异步操作
             */
            /*IgniteCache<Integer, String> simple =
                    ignite.getOrCreateCache("simple");
 
			// 启动异步操作 
			@SuppressWarnings("deprecation")
			IgniteCache<Integer, String>  asynCache = simple.withAsync();
			 
			// 原子操作 获取旧值 存入新值
			asynCache.getAndPut(33, "3332");
			 
			// 获取上面调用的future
			@SuppressWarnings("deprecation")
			IgniteFuture<Integer> fut = asynCache.future();
			// 监听结果 
			fut.listen(f -> System.out.println("Previous cache value: " + f.get()));*/
        	
        	/**
        	 * 原子操作
        	 */
        	IgniteCache<Integer, String> simple =ignite.getOrCreateCache("simple");
        	
 
			// 插入或更新  返回旧值 
			String oldVal = simple.getAndPut(11, "haha");
			 
			// 如果不存在则插入 返回旧值
			oldVal = simple.getAndPutIfAbsent(11, "11 getAndPutIfAbsent2");
			 
			// 如果存在则替换 返回旧值
			oldVal = simple.getAndReplace(11, "11 getAndReplace");
			 
			// 删除键值对 返回旧值
			oldVal = simple.getAndRemove(11);
			 
			// 如果不存在则插入 成功返回true
			boolean success = simple.putIfAbsent(12, "12 putIfAbsent");
			 
			// 如果存在则替换 成功返回 true
			success = simple.replace(12, "12 replace");
			 
			// 如果值匹配 则替换 成功返回true
			success = simple.replace(12, "12 replace", "12 12 12");
			 
			// 如果值匹配则删除 成功返回true
			success = simple.remove(11, "11");
        	
			//获取缓存数据并输出
			for(int i=0; i< 20; i++){
				if(simple.get(i)==null) {
					continue;
				}else {
					System.out.println(simple.get(i));
				}
            }
        }

//        Ignite ignite;
// 
//        if(args.length == 1 && !args[0].isEmpty())
//        {
//            //如果启动时指定了xml配置文件,则用指定的配置文件
//            System.out.println("Use " + args[0] + " to start.");
//            ignite = Ignition.start(args[0]);
//           // /resources/default-config.xml
//        }
//        else
//        {
//            //如果启动时没指定配置文件,则生成一个配置文件
//            System.out.println("Create an IgniteConfiguration to start.");
//            TcpDiscoverySpi spi = new TcpDiscoverySpi();
//            TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
//           // ipFinder.setAddresses(Arrays.asList("127.0.0.1:8083"));
//            //ipFinder.setMulticastGroup("10.0.48.60");
//            //ipFinder.setLocalAddress(locAddr);
//            ipFinder.setMulticastGroup("10.0.48.17");
//            spi.setIpFinder(ipFinder);
//            IgniteConfiguration cfg = new IgniteConfiguration();
//            cfg.setDiscoverySpi(spi);
//            
//            //cfg.setLocalHost("10.0.48.17");
//            ignite = Ignition.start();
//        }
// 
//        // 创建一个TEST缓存并写入一些数据, key是城市的名字,value是省的名字
//        IgniteCache<String, String> cityProvinceCache = ignite.getOrCreateCache("TEST");
//        cityProvinceCache.put("Edmonton", "Alberta");
//        cityProvinceCache.put("Markham", "Ontario");
//        cityProvinceCache.put("Montreal", "Quebec");
    }
}
 
 
