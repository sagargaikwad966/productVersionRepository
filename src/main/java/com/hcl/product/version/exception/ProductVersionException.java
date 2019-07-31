package com.hcl.product.version.exception;

import org.springframework.stereotype.Component;

@Component
public class ProductVersionException extends Exception{


	private static final long serialVersionUID = 6147204535194846372L;

	public ProductVersionException(String arg0) {
		super(arg0);
	}

	public ProductVersionException() {
		super();

	}

	public ProductVersionException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ProductVersionException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ProductVersionException(Throwable arg0) {
		super(arg0);
	}

	
	
}
