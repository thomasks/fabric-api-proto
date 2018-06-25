package cn.freeexchange.fabric.api;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import cn.freeexchange.fabric.api.utils.ChaincodeManager;
import cn.freeexchange.fabric.api.utils.FabricManager;


public class FabricManagerTest {
	
	@Test
	public  void testQuery() throws Exception {
		ChaincodeManager manager = FabricManager.obtain().getManager();
		Map<String, String> querya = manager.query("query", new String[] {"testkey4"});
		Assert.assertEquals("the value of testkey4 is : testkey0:testvalue4", "testkey0:testvalue4", querya.get("data"));
		System.out.println(querya.toString());
	}
}
