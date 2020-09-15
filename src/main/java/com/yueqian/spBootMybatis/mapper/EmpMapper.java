package com.yueqian.spBootMybatis.mapper;

import java.util.List;

import com.yueqian.spBootMybatis.domain.EmpVO;

public interface EmpMapper {
	
	/**
	 * 获取员工
	 */
	public EmpVO getEmpById(int empno);
	/**
	 * 获取所有员工
	 */
	public List<EmpVO> getEmps();

}
