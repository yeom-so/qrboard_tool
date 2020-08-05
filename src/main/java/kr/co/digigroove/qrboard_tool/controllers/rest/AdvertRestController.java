package kr.co.digigroove.qrboard_tool.controllers.rest;

import kr.co.digigroove.qrboard_tool.service.AdvertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.Serializable;

@RestController
@RequestMapping(value="/advertRest")
public class AdvertRestController implements Serializable{

	private static final Logger LOGGER = LoggerFactory.getLogger(AdvertRestController.class);

	@Autowired
	private AdvertService advertService;

}
