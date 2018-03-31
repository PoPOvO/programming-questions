package org.xli.fraction_addition;

import java.util.Arrays;

public class FractionAddition {
    public String fractionAddition(String expression) {
    	expression = expression.replaceAll("\\+", ":+");
    	expression = expression.replaceAll("-", ":-");
    	String[] items = expression.split(":");
    	int leastCommonMultiple = 0;                         //所有分数分母的最小公倍数
    	int greatestCommonDivisor = 0;                       //分子和分母的最大公约数
    	int sum = 0;
    	
    	if (expression.codePointAt(0) == ":".codePointAt(0)) {
    		items = Arrays.copyOfRange(items, 1, items.length);
    	}
    	
    	for (int i = 0; i < items.length; i++) {             //计算分母的最小公倍数
    		String[] integers = items[i].split("/");
    		if (i == 0) {
    			leastCommonMultiple = Integer.valueOf(integers[1]);    			
    		} else {
    			leastCommonMultiple = leastCommonMultiple(leastCommonMultiple, Integer.valueOf(integers[1]));
    		}
    	}
    	
    	for (int i = 0; i < items.length; i++) {             //根据最小公倍数修改分子，并计算所有分子的和
    		String[] integers = items[i].split("/");
    		sum += Integer.valueOf(integers[0]) * (leastCommonMultiple / Integer.valueOf(integers[1]));
    	}
    	
    	greatestCommonDivisor = greatestCommonDivisor(sum, leastCommonMultiple); //求出分子和分母的最大公约数，进行化简
    	sum /= greatestCommonDivisor;
    	leastCommonMultiple /= greatestCommonDivisor;

    	return sum + "/" + leastCommonMultiple;
    }
    
    //最大公约数
    private int greatestCommonDivisor(int m, int n) {
        int r = 0 ;
        while(n != 0){
            r = m % n;
            m = n;
            n = r;
        }
        return m;
    }
    
    //最小公倍数
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
