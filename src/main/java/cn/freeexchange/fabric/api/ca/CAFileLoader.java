package cn.freeexchange.fabric.api.ca;

import java.io.FileNotFoundException;

import org.springframework.util.ResourceUtils;

import cn.freeexchange.fabric.api.utils.ChaincodeManager;

public class CAFileLoader {

	public static  String getCAMaterialRootPath() {
		String directorys = null;
    	try {
			directorys = ResourceUtils.getFile("classpath:fabric").getAbsolutePath();
		} catch (FileNotFoundException e) {
			directorys = ChaincodeManager.class.getClassLoader().getResource("fabric").getFile();
		}
    	return directorys;
	}
}
