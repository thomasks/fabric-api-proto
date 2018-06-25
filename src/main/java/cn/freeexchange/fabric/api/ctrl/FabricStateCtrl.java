package cn.freeexchange.fabric.api.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.freeexchange.fabric.api.req.CCResult;
import cn.freeexchange.fabric.api.req.InvokeReq;
import cn.freeexchange.fabric.api.req.QueryReq;

@RestController
@RequestMapping("/api/state")
public class FabricStateCtrl {
	
	
	 @RequestMapping(value = "/query", method = RequestMethod.GET)
	 public CCResult query(QueryReq queryReq) {
		 CCResult ccr = new CCResult();
		 return ccr;
	 }
	 
	 @RequestMapping(value = "/invoke", method = RequestMethod.GET)
	 public CCResult invoke(InvokeReq invokeReq) {
		 CCResult ccr = new CCResult();
		 return ccr;
	 }
	 
	

}
