package org.xli.test;

import java.util.Scanner;

import org.xli.core.StudentNode;
import org.xli.core.StudentStorage;

/*
7
1
2
3
6
5
4
5
3
 */
public class StudentTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentStorage storage = null;
		int capacity = 0;
		int size = 0;
		
		capacity = scanner.nextInt();                              //����ѧ������
		storage = new StudentStorage(capacity);
		while (capacity-- > 0) {                                   //��������ѧ����count
			size = scanner.nextInt();
			storage.addStudent(new StudentNode().setCount(size));
		}
		size = scanner.nextInt();                                  //��ѡ��size��������ѧ��
		storage.injectNodeSum(size);
		StudentNode maxSumNode = storage.getMaxSumStudents();
		System.err.println(maxSumNode.getSum());                   //��ȡ���sum
		
		scanner.close();
	}
}
