package com.yueqian.spBootMybatis.service;

import java.util.List;

import com.yueqian.spBootMybatis.domain.EmpVO;

public interface EmpService {
	/**
	 * 获取员工
	 */
	public EmpVO getEmpById(int empno);
	/**
	 * 获取所有员工
	 */
	public List<EmpVO> getEmps();
}
