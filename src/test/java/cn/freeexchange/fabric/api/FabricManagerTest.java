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
		Map<String, String> querya = manager.query("query", new String[] {"a"});
		Assert.assertEquals("the bal of a is : 90", "90", querya.get("data"));
		Map<String, String> queryb = manager.query("query", new String[] {"b"});
		System.out.println(queryb.toString());
		Assert.assertEquals("the bal of b is : 210", "210", queryb.get("data"));
	}
}
