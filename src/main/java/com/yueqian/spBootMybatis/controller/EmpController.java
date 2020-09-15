package com.yueqian.spBootMybatis.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yueqian.spBootMybatis.domain.EmpVO;
import com.yueqian.spBootMybatis.service.EmpService;

@Controller
public class EmpController {
	@Resource
	private EmpService empService;
	
	@RequestMapping("/")
	public String index(ModelMap mm, HttpServletRequest req, HttpSession session) {
		
		List<EmpVO> empList = empService.getEmps();
		empList.get(0).setJob(null);
		empList.get(empList.size()-1).setJob(null);
		empList.add(0,null);
		empList.add(3,null);
		mm.addAttribute("empList", empList);
		
//		//Map<员工编号,员工对象>
//		Map<Integer, EmpVO> eMap = new HashMap<Integer, EmpVO>();
//		for (EmpVO empVO : empList) {
//			eMap.put(empVO.getEmpno(), empVO);
//		}
//		//Map<部门编号,Map<员工编号,员工>> 
//		Map<Integer,Map<Integer, EmpVO>> result = new TreeMap<Integer,Map<Integer, EmpVO>>();
//		for (EmpVO emp : empList) {
//			Map<Integer, EmpVO> deptMap = result.get(emp.getDeptno());
//			if( deptMap == null ) {
//				deptMap = new TreeMap<Integer, EmpVO>();
//				result.put(emp.getDeptno(), deptMap);
//			}
//			deptMap.put(emp.getEmpno(), emp);
//		}
		
		System.out.println(empList);
		Collections.sort(empList, new Comparator<EmpVO>(){
			@Override
			public int compare(EmpVO o1, EmpVO o2) {
				//null last
				if(o1 == null) {
					return 1;
				}
				if(o2 == null) {
					return -1;
				}
				
				if(o1.getJob() == null) {
					return 1;
				}
				
				if(o2.getJob() == null) {
					return -1;
				}
				//按照工作排序，工作一样按照工资升序排序
				if(o1.getJob().compareTo(o2.getJob()) != 0) {
					return o1.getJob().compareTo(o2.getJob());
				}else if(o1.getSal() > o2.getSal()){
					return 1;
				}else {
					return -1;
				}
			}
		});
		System.out.println(empList);
		
//		ArrayList list = new ArrayList();
//		list.add("item1");
//		list.add("item2");
//		mm.addAttribute("empList", new ArrayList());
		EmpVO emp = empService.getEmpById(7839);
		emp.setName("<b>"+emp.getName()+"</b>");
		mm.addAttribute("employee",	emp);
		
		//request范围
		mm.addAttribute("key1", "request scope val");
		//session范围
		session.setAttribute("key1", "session scope val");
		//application范围
		req.getServletContext().setAttribute("key1", "application scope val");
		
		mm.addAttribute("sysdate", new Date());
		
		mm.addAttribute("classKey", null);
		
		
		
		
		
		return "index";
	}
}
