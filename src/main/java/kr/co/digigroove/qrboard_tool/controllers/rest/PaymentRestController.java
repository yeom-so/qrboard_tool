package kr.co.digigroove.qrboard_tool.controllers.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping(value="/paymentRest")
public class PaymentRestController implements Serializable{

	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentRestController.class);

}
