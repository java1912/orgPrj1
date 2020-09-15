package com.yueqian.spBootMybatis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yueqian.spBootMybatis.domain.EmpVO;
import com.yueqian.spBootMybatis.mapper.EmpMapper;
import com.yueqian.spBootMybatis.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {
	@Resource
	private EmpMapper empMapper;
	
	/**
	 * 获取员工
	 */
	public EmpVO getEmpById(int empno) {
		return empMapper.getEmpById(empno);
	}
	
	@Override
	public List<EmpVO> getEmps() {
		return empMapper.getEmps();
	}

}
