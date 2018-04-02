package org.xli.core;

import java.util.ArrayList;
import java.util.List;

public class StudentStorage {
	/**
	 * ����ѧ��
	 */
	private List<StudentNode> students;
	/**
	 * ��ʦҪ��ѡ��<strong>����</strong>size��ѧ��
	 */
	private int size;
	
	public StudentStorage(int capacity) {
		students = new ArrayList<>(capacity);
	}
	
	/**
	 * ��ѡ��sum����һ���ڵ�
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
	 * Ϊÿ���ڵ�����sum
	 * 
	 * @param size
	 */
	public void injectNodeSum(int size) {
		this.size = size;
		
		for (int i = 0; i < students.size(); i++) {
			StudentNode node = students.get(i);
			int sum = 0;
			
			for (int j = 0; j < size; j++) {
				if (i+j >= students.size()) {							//��������m-1��ѧ����sum
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
