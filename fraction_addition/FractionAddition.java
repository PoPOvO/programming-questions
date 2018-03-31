package org.xli.fraction_addition;

import java.util.Arrays;

public class FractionAddition {
    public String fractionAddition(String expression) {
    	expression = expression.replaceAll("\\+", ":+");
    	expression = expression.replaceAll("-", ":-");
    	String[] items = expression.split(":");
    	int leastCommonMultiple = 0;                         //���з�����ĸ����С������
    	int greatestCommonDivisor = 0;                       //���Ӻͷ�ĸ�����Լ��
    	int sum = 0;
    	
    	if (expression.codePointAt(0) == ":".codePointAt(0)) {
    		items = Arrays.copyOfRange(items, 1, items.length);
    	}
    	
    	for (int i = 0; i < items.length; i++) {             //�����ĸ����С������
    		String[] integers = items[i].split("/");
    		if (i == 0) {
    			leastCommonMultiple = Integer.valueOf(integers[1]);    			
    		} else {
    			leastCommonMultiple = leastCommonMultiple(leastCommonMultiple, Integer.valueOf(integers[1]));
    		}
    	}
    	
    	for (int i = 0; i < items.length; i++) {             //������С�������޸ķ��ӣ����������з��ӵĺ�
    		String[] integers = items[i].split("/");
    		sum += Integer.valueOf(integers[0]) * (leastCommonMultiple / Integer.valueOf(integers[1]));
    	}
    	
    	greatestCommonDivisor = greatestCommonDivisor(sum, leastCommonMultiple); //������Ӻͷ�ĸ�����Լ�������л���
    	sum /= greatestCommonDivisor;
    	leastCommonMultiple /= greatestCommonDivisor;

    	return sum + "/" + leastCommonMultiple;
    }
    
    //���Լ��
    private int greatestCommonDivisor(int m, int n) {
        int r = 0 ;
        while(n != 0){
            r = m % n;
            m = n;
            n = r;
        }
        return m;
    }
    
    //��С������
    private int leastCommonMultiple(int m, int n) {
    	for (int i = m > n ? m : n;; i++) {
    		if (i % m == 0 && i % n == 0) {
    			return i;
    		}
    	}
    }
	
	public static void main(String[] args) {
		System.err.println(new FractionAddition().fractionAddition("-1/2+1/2"));;
	}
}
