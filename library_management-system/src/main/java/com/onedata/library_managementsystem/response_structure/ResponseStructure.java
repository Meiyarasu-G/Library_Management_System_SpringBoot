package com.onedata.library_managementsystem.response_structure;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ResponseStructure<T> {
	private T data;
	private LocalDateTime dateTime;
	private int statusCode;
	private String message;
}
