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
		
		capacity = scanner.nextInt();                              //输入学生个数
		storage = new StudentStorage(capacity);
		while (capacity-- > 0) {                                   //依次输入学生的count
			size = scanner.nextInt();
			storage.addStudent(new StudentNode().setCount(size));
		}
		size = scanner.nextInt();                                  //挑选出size个连续的学生
		storage.injectNodeSum(size);
		StudentNode maxSumNode = storage.getMaxSumStudents();
		System.err.println(maxSumNode.getSum());                   //获取最大sum
		
		scanner.close();
	}
}
