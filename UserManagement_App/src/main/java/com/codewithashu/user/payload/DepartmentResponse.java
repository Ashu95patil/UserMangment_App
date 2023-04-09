package com.codewithashu.user.payload;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DepartmentResponse {
	
	
	private List<DepartmentDto> content;

	private int pageNumber;

	private int pageSize;

	private long totalElement;

	private int totalPage;

	private boolean lastPage;


}
