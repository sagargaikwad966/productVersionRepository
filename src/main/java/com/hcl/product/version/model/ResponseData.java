package com.hcl.product.version.model;

import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {


	private String responseMessage;
	private Map<Integer, String> status;
	private Object data;
	public void setStatus(HttpStatus ok) {
		// TODO Auto-generated method stub

	}

}
