package h_company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
/*
	문제 : A리스트 (1,3,5,7,9) B리스트 (2,4,6,8,10) 이 존재 할때 
	두 리스트를 오름차순으로 정렬 하시오.
*/
public class ListSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = Arrays.asList(new Integer(1),new Integer(3),new Integer(5),new Integer(7),new Integer(9));
		List<Integer> b = Arrays.asList(new Integer(2),new Integer(4),new Integer(6),new Integer(8),new Integer(10));
		List<Integer> c = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		
		
		
		for(int num = 0; num < a.size()+b.size();num++) {
			
			Integer aVal = i < a.size() ? a.get(i) : Integer.MAX_VALUE;
			Integer bVal = j < b.size() ? b.get(j) : Integer.MAX_VALUE;
			
			if(aVal < bVal) {
				c.add(aVal);
				i= i+1;
			}else {
				c.add(bVal);
				j= j+1;
			}
			
		}
		
		System.out.println(c);
	}

}
