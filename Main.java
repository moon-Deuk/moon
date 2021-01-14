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
 * n���� �����͸� k���� �������� ������ ���α׷�.
 * 
 * version_01
 * 0~9999������ ������ �ִ� 50�� ���� �������� �߻�����
 * ǥ�������� 1000������ ������, 3~4���� �������� ������.
 * 
 * @author davin
 *
 */
public class Main {

	public static void main(String[] args) {

		final int N = 50;
		final int MAX = 10000;

		Random random = new Random();

		System.out.println("N(���� �߻� ����)= 1 ~ " + N);
		System.out.println("MAX(���� �ִ밪)= " + (MAX-1));
		System.out.println();

		// 0�̻�, MAX �̸� ���� ������ N�� �߻����� ����Ʈ�� �����Ѵ�.
		List<Integer> list = new ArrayList<Integer>();
		int n;
		System.out.println("<list>");
		for(int i = 0; i < random.nextInt(N)+1; i++) {
			n = random.nextInt(MAX);
			list.add(n);
		}
		// ����Ʈ�� ����Ѵ�.
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
		System.out.println();

		//-------------------------------
		Collections.sort(list);

		iterator = list.iterator();
		System.out.println("<list - ������������ ���ĵ� ����>");
		while (iterator.hasNext())
			System.out.println(iterator.next());
		System.out.println();

		//-------------------------------

		// Map�̶�List �� �� �ʿ���°� ���߿� �����
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> sD = new ArrayList<>();

		for(int i = 1; i <= list.size(); i++) {
			map.put(i, standardDeviation(list, i));
			sD.add(standardDeviation(list, i));		
		}

		System.out.println("<list - ���� : ǥ������>");

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

		// 1000������ ������.
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
		System.out.println("<���� ���� ����Ʈ�� ������ ���>");

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
	 * ǥ������ ���ϰ� ��ȯ�ϴ� �޼ҵ�
	 * @param list
	 * @param num
	 * @return ǥ������(int������ ����ȯ)
	 */
	public static int standardDeviation(List<Integer> list, int num) {
		int aver = average(list, num);		// ���
		int devi = 0;

		//List<Number> deviation = new ArrayList<>();
		for(int i = 0; i < num; i++) {
			devi += (Math.pow((list.get(i) - aver), 2));
		}

		devi /= num;	

		return (int)Math.sqrt(devi);	
	}

	/**
	 * ��� ���ؼ� ��ȯ�ϴ� �޼ҵ�
	 * @param list ������ ���ڰ� ����ִ� ����Ʈ
	 * @param num ����� ���� ���ڵ��� ����
	 * @return list�� num���� ���
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
