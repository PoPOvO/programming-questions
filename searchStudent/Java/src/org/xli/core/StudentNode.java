package org.xli.core;

public class StudentNode {
	private int count;
	private int sum;
	
	public StudentNode() {
	}

	public int getCount() {
		return count;
	}

	public StudentNode setCount(int count) {
		this.count = count;
		return this;
	}

	public int getSum() {
		return sum;
	}

	public StudentNode setSum(int sum) {
		this.sum = sum;
		return this;
	}

	@Override
	public String toString() {
		return "StudentNode [count=" + count + ", sum=" + sum + "]";
	}
}
