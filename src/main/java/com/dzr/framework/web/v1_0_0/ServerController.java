/*
 * Copyright @ 2016QIANLONG.
 * All right reserved.
 */

package com.dzr.framework.web.v1_0_0;


import com.dzr.framework.constant.Constants;
import com.dzr.framework.pojo.dto.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * Description:检测web服务是否正常的接口
 * 
 * @PackageName:com.sdxd.framework.web.v1_0_0
 * @ClassName:ServerCheckController
 * @author xiongweitao
 * @date 2016年3月9日 上午10:43:27
 */
@Controller
@RequestMapping("server")
public class ServerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServerController.class);

	/**
	 * 
	 * Description:供后台配置系统访问,测试本系统是否宕机
	 * 
	 * @return
	 * @author xiongweitao
	 * @date 2016年3月10日 下午5:55:33
	 */
	@RequestMapping(value = "checkServer", method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public ResponseEntity checkServer() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("ServerController.checkServer execution");
		}
		ResponseEntity entity = new ResponseEntity();
		try {
			entity.setStatus(Constants.System.OK);
			entity.setError(Constants.System.SERVER_SUCCESS);
		} catch (Exception e) {
			entity.setStatus(Constants.System.FAIL);
			entity.setError(Constants.System.SYSTEM_ERROR_CODE);
			entity.setError(Constants.System.SYSTEM_ERROR_MSG);
		}
		return entity;
	}

	/**
	 * 
	 * Description:供外部访问,获取动态系统参数列表
	 * 
	 * @return
	 * @author xiongweitao
	 * @date 2016年3月10日 下午5:55:56
	 */
	@RequestMapping(value = "getActiveMap", method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public ResponseEntity getActiveMap() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("ServerStatusController.getActiveMap execution");
		}
		ResponseEntity entity = new ResponseEntity();
		try {
			entity.setStatus(Constants.System.OK);
			entity.setError(Constants.System.SERVER_SUCCESS);
//			entity.setData(CacheManager.getActiveMap());
		} catch (Exception e) {
			entity.setStatus(Constants.System.FAIL);
			entity.setError(Constants.System.SYSTEM_ERROR_CODE);
			entity.setError(Constants.System.SYSTEM_ERROR_MSG);
		}
		return entity;
	}
}
