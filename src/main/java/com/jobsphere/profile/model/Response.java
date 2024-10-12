package com.jobsphere.profile.model;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class Response<T> {
	
	public Integer code;

	public String status;

	public T result;

	public Response(Integer code, String status, T result) {
		this.code = code;
		this.status = status;
		this.result = result;
	}
}
