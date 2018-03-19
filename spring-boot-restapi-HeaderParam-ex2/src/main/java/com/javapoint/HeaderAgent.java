package com.javapoint;

import org.springframework.stereotype.Component;

@Component
public class HeaderAgent {
	String headerName;

	public String getHeaderName() {
		return headerName;
	}

	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}
}
