package com.example.systemdesigns.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.systemdesigns.models.Department;
import com.example.systemdesigns.models.DoublyLinkedList;
import com.example.systemdesigns.models.DoublyLinkedList.Node;
import com.example.systemdesigns.models.Employee;
import com.example.systemdesigns.models.LRUCacheLinkedHashMap;

@RestController
@RequestMapping("/system/design")
public class SystemDesignController {
	private final LRUCacheLinkedHashMap<Employee, Department> cache = LRUCacheLinkedHashMap.newInstance(4);

	@PostMapping("/lrucache/nonlinkedhashmap")
	public void designLRUCacheNonLinkedHashMap() {
		DoublyLinkedList dLList = new DoublyLinkedList();
		Node firstNode = dLList.buildDoublyLinkedList(new int[] {4,6,3,8,5});
		dLList.printNodes(firstNode);
	}
	
	@PostMapping("/lrucache/linkedhashmap/{empId}/{depId}")
	public @ResponseBody Map<String,List<String>> designLRUCacheLinkedHashMap(@PathVariable Integer empId, @PathVariable Integer depId) {
		return addToLRUCache(empId, depId);
	}
	
	private Map<String,List<String>> addToLRUCache(int empNo,int depNo) {
		Map<String,List<String>> map = new HashMap<>();
		Employee emp = new Employee(empNo,"Emp"+empNo,"contact"+empNo,"add"+empNo);
		Department dep = new Department(depNo,"Dep"+depNo,"code"+depNo,"head"+depNo);
		cache.put(emp, dep);
		Set<Entry<Employee, Department>> entrySet = cache.entrySet();
		List<String> emps = cache.entrySet().stream().map(e->e.getKey().getName()).collect(Collectors.toList());
		List<String> deps = cache.entrySet().stream().map(e->e.getValue().getName()).collect(Collectors.toList());
		map.put("emps",emps);
		map.put("deps",deps);
		return map;
	}
}
