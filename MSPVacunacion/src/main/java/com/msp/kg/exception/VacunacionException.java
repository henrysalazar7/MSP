package com.msp.kg.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msp.kg.dto.Message;
import com.msp.kg.dto.ResponseBase;
import com.msp.kg.enums.ErrorEnum;
import com.msp.kg.service.impl.LoteServiceImpl;

public class VacunacionException extends Exception implements Serializable {

	private static Logger LOG = LoggerFactory.getLogger(LoteServiceImpl.class);

	private static final long serialVersionUID = 1L;

	public static void manageException(Exception ex, ResponseBase response) {
		if (ex instanceof RuntimeException) {
			LOG.error(ex.getMessage());
		}

		ErrorEnum errorCode = ErrorEnum.ERROR_5000;
		Message msg = new Message();
		msg.setCode(errorCode.getCode());
		msg.setDescription(errorCode.getDescription());

		List<Message> msgList = new ArrayList<>();
		msgList.add(msg);

		response.setSuccess(false);
		response.setMessages(msgList);
	}

	public static void manageError(ResponseBase response, ErrorEnum errorCode) {
		LOG.info("Se registra error " + errorCode.getCode());
		Message msg = new Message();
		msg.setCode(errorCode.getCode());
		msg.setDescription(errorCode.getDescription());

		List<Message> msgList = new ArrayList<>();
		msgList.add(msg);

		response.setSuccess(false);
		response.setMessages(msgList);
	}
}
