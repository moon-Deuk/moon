package version01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.lang.Math;

/**
 * n개의 데이터를 k개의 집단으로 나누는 프로그램.
 * 
 * version_01
 * 0~9999까지의 난수를 최대 50개 까지 랜덤으로 발생시켜
 * 표준편차를 1000단위로 나누고, 3~4개의 집단으로 나눈다.
 * 
 * @author davin
 *
 */
public class Main {

	public static void main(String[] args) {

		final int N = 50;
		final int MAX = 10000;

		Random random = new Random();

		System.out.println("N(난수 발생 갯수)= 1 ~ " + N);
		System.out.println("MAX(난수 최대값)= " + (MAX-1));
		System.out.println();

		// 0이상, MAX 미만 정수 난수를 N개 발생시켜 리스트에 저장한다.
		List<Integer> list = new ArrayList<Integer>();
		int n;
		System.out.println("<list>");
		for(int i = 0; i < random.nextInt(N)+1; i++) {
			n = random.nextInt(MAX);
			list.add(n);
		}
		// 리스트를 출력한다.
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
		System.out.println();

		//-------------------------------
		Collections.sort(list);

		iterator = list.iterator();
		System.out.println("<list - 오름차순으로 정렬된 난수>");
		while (iterator.hasNext())
			System.out.println(iterator.next());
		System.out.println();

		//-------------------------------

		// Map이랑List 둘 중 필요없는거 나중에 지우기
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> sD = new ArrayList<>();

		for(int i = 1; i <= list.size(); i++) {
			map.put(i, standardDeviation(list, i));
			sD.add(standardDeviation(list, i));		
		}

		System.out.println("<list - 갯수 : 표준편차>");

		Set<Integer> keys = map.keySet();
		for (Integer key : keys) {
			Number value = map.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println();

		//---------------------------------

		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		List<Integer> l3 = new ArrayList<>();
		List<Integer> l4 = new ArrayList<>();

		// 1000단위로 나누기.
		for (int i = 0; i < sD.size(); i++) {
			if(sD.get(i) < 1000)
				l1.add(list.get(i));
			else if (sD.get(i) < 2000)
				l2.add(list.get(i));
			else if (sD.get(i) < 3000)
				l3.add(list.get(i));
			else
				l4.add(list.get(i));
		}

		//-----------------------------
		System.out.println("<여러 개의 리스트로 나누고 출력>");

		if (!l1.isEmpty()) {
			System.out.println("[list_1]");
			iterator = l1.iterator();
			while (iterator.hasNext())
				System.out.print(iterator.next() + " ");
			System.out.println();
		}

		if (!l2.isEmpty()) {
			System.out.println("[list_2]");
			iterator = l2.iterator();
			while (iterator.hasNext())
				System.out.print(iterator.next() + " ");
			System.out.println();
		}

		if (!l3.isEmpty()) {
			System.out.println("[list_3]");
			iterator = l3.iterator();
			while (iterator.hasNext())
				System.out.print(iterator.next() + " ");
			System.out.println();
		}
		if (!l4.isEmpty()) {
			System.out.println("[list_4]");
			iterator = l4.iterator();
			while (iterator.hasNext())
				System.out.print(iterator.next() + " ");
			System.out.println();
		}

	}

	/**
	 * 표준편차 구하고 반환하는 메소드
	 * @param list
	 * @param num
	 * @return 표준편차(int형으로 형변환)
	 */
	public static int standardDeviation(List<Integer> list, int num) {
		int aver = average(list, num);		// 평균
		int devi = 0;

		//List<Number> deviation = new ArrayList<>();
		for(int i = 0; i < num; i++) {
			devi += (Math.pow((list.get(i) - aver), 2));
		}

		devi /= num;	

		return (int)Math.sqrt(devi);	
	}

	/**
	 * 평균 구해서 반환하는 메소드
	 * @param list 랜덤한 숫자가 들어있는 리스트
	 * @param num 평균을 구할 숫자들의 개수
	 * @return list의 num개의 평균
	 */
	public static int average(List<Integer> list, int num) {
		int sum = 0;
		int n = 0;

		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext() && n < num) {
			sum += iterator.next();
			n++;
		}

		sum /= num;
		return sum;
	}

}
