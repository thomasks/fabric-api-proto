package cn.freeexchange.fabric.api.ctrl;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.freeexchange.fabric.api.req.CCResult;
import cn.freeexchange.fabric.api.req.InvokeReq;
import cn.freeexchange.fabric.api.req.QueryReq;
import cn.freeexchange.fabric.api.utils.ChaincodeManager;
import cn.freeexchange.fabric.api.utils.FabricManager;

@RestController
@RequestMapping("/api/state")
public class FabricStateCtrl {
	
	
	 @RequestMapping(value = "/query", method = RequestMethod.POST)
	 public @ResponseBody CCResult query(@RequestBody QueryReq queryReq) throws Exception {
		 CCResult result = new CCResult();
		 String funcName = queryReq.getFuncName();
		 String[] args = queryReq.getArgs();
		 ChaincodeManager manager = FabricManager.obtain().getManager();
		 Map<String, String> ret = manager.query(funcName, args);
		 result.setCode(ret.get("code"));
		 result.setData(ret.get("data"));
		 return result;
	 }
	 
	 @RequestMapping(value = "/invoke", method = RequestMethod.POST)
	 public @ResponseBody CCResult invoke(@RequestBody InvokeReq invokeReq) throws Exception {
		 CCResult result = new CCResult();
		 String funcName = invokeReq.getFuncName();
		 String[] args = invokeReq.getArgs();
		 ChaincodeManager manager = FabricManager.obtain().getManager();
		 Map<String, String> ret = manager.invoke(funcName, args);
		 result.setCode(ret.get("code"));
		 result.setData(ret.get("data"));
		 return result;
	 }
	 
	

}
