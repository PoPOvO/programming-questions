package org.xli.core;

import java.util.ArrayList;
import java.util.List;

public class StudentStorage {
	/**
	 * 所有学生
	 */
	private List<StudentNode> students;
	/**
	 * 老师要挑选出<strong>连续</strong>size个学生
	 */
	private int size;
	
	public StudentStorage(int capacity) {
		students = new ArrayList<>(capacity);
	}
	
	/**
	 * 挑选出sum最大的一个节点
	 * 
	 * @return
	 */
	public StudentNode getMaxSumStudents() {
		StudentNode max = students.get(0);
		
		for (StudentNode node: students) {
			if (max.getSum() < node.getSum()) {
				max = node;
			}
		}
		return max;
	}
	
	/**
	 * 为每个节点填入sum
	 * 
	 * @param size
	 */
	public void injectNodeSum(int size) {
		this.size = size;
		
		for (int i = 0; i < students.size(); i++) {
			StudentNode node = students.get(i);
			int sum = 0;
			
			for (int j = 0; j < size; j++) {
				if (i+j >= students.size()) {							//处理最后的m-1个学生的sum
					sum += students.get(i+j-students.size()).getCount();
				} else {
					sum += students.get(i+j).getCount();
				}
			}
			node.setSum(sum);
		}
	}
	
	public void addStudent(StudentNode node) {
		students.add(node);
	}
	
	public StudentNode getStudent(int index) {
		return students.get(index);
	}
	
	public int getSize() {
		return size;
	}
}
