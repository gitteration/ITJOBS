package com.kh.hard.controller;

import java.util.Scanner;

public class CompExample {
	
	public void method1() {
		
		// ����ڿ��� �� ���� ������ �Է¹ް�
		// 1���� �Է� ���� ������ Ȧ��/¦���� ������
		// Ȧ���� ��, ¦���� �� ���
		
		// ��, �Է¹��� ���� ����� �ƴϸ� "����� �ƴմϴ�" ���
		
		
		// ���� ) 4 �Է½�  -->  "�ڼ��ڼ�" ���
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		if(num > 0) { // �Է¹��� ���� ����� ��� (�� �Է��Ͽ��� ���)
			
			for(int i = 1; i <= num; i++) { // 1���� ����ڰ� �Է��� ������ �ݺ�����
				
				if(i % 2 == 1) {	// Ȧ���� ���
					System.out.print("��");
					
				} else {			// ¦���� ���
					System.out.print("��");
					
				}
			}
			
		} else {	// �Է� ���� ���� ����� �ƴ� ��� (�� �� �Է��Ͽ��� ���)
			
			System.out.println("����� �ƴմϴ�.");
		}
	}
	
	
	public void method2() {
		// ���� method1���� ����� �ƴ� ��� �ٽ� �Է¹޵��� �ݺ� ����
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) { // �켱 ���� �ݺ����� �����ϰ�
			
			System.out.print("���� : ");
			int num = sc.nextInt();
			
			if(num > 0) { // �Է¹��� ���� ����� ��� (�� �Է��Ͽ��� ���)
				
				for(int i = 1; i <= num; i++) { // 1���� ����ڰ� �Է��� ������ �ݺ�����
					
					if(i % 2 == 1) {	// Ȧ���� ���
						System.out.print("��");
						
					} else {			// ¦���� ���
						System.out.print("��");
						
					}
				}
				
				// ����� ��� ����� ��µǰ� ���ѹݺ����� ����������
				break;
				
			} else {	// �Է� ���� ���� ����� �ƴ� ��� (�� �� �Է��Ͽ��� ���)
				
				System.out.println("����� �ƴմϴ�.");
				
				// ����� �ƴ� ��� �ٽ� �ݺ����� ó������ ���ư� ������ �Է¹ް� �ɰŴ�.
			}
			
		}
	}
	
	
	public void method3() {
		// ���ڿ��� �Է� �ް� 					(str)
		// �Է¹��� ���ڿ����� �˻��ϰ� ���� ���ڵ� �Է¹޴´�.	(ch)
		
		// ���ڿ��� �� ���ڰ� �� �� �ִ��� ���� ���
		
		// ���� ) banana, a �� �Է� �ް� �Ǹ� 3���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ� : ");
		String str = sc.nextLine();
		
		System.out.print("���� : ");
		char ch = sc.nextLine().charAt(0);
		
		int count = 0;		// �˻��� ������ ������ ���� ����
		
		for(int i=0; i<str.length(); i++) { // 0���� ���ڿ��� ����-1 ��ŭ �ݺ�
			
			if(ch == str.charAt(i)) { // �Է¹��� ���ڿ� ���ڿ��� �� �ε��� ���� ���� ���
				count++; 			  // ������ ���ڶ�� �Ǵ��Ͽ� count 1 ����
			}
			
		}
		
		System.out.println("���Ե� ���� : " + count);
		
	}
	
	
	
	public void method4() {
		// ������ ������
		
		// ����ڿ��� ��ǰ ���ݰ� �մԿ��� ���� �ݾ��� �Է¹޾�
		// �Ž������� ����, ��� �������� ����ϴ� ����
		// ��������, ������, ��õ����, õ����, �����, ���, �ʿ�
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("��ǰ ���� : ");
		int price = sc.nextInt();
		
		System.out.print("������ �ݾ� : ");
		int all = sc.nextInt();
		
		int remain = all - price; // �Ž�����
		
		System.out.println("�Ž����� : " + remain + "��\n");
		
		int m50000 = remain / 50000;
		int m10000 = remain % 50000 / 10000;
		int m5000 = remain % 50000 % 10000 / 5000;
		int m1000 = remain % 50000 % 10000 % 5000 / 1000;
		int m500 = remain % 50000 % 10000 % 5000 % 1000 / 500;
		int m100 = remain % 50000 % 10000 % 5000 % 1000 % 500 / 100;
		int m50 = remain % 50000 % 10000 % 5000 % 1000 % 500 % 100 / 50;
		int m10 = remain % 50000 % 10000 % 5000 % 1000 % 500 % 100 % 50 / 10;
		
		System.out.println("�������� : " + m50000 + "��");
		System.out.println("������ : " + m10000 + "��");
		System.out.println("��õ���� : " + m5000 + "��");
		System.out.println("õ���� : " + m1000 + "��");
		System.out.println("����� : " + m500 + "��");
		System.out.println("��� : " + m100 + "��");
		System.out.println("50�� : " + m50 + "��");
		System.out.println("10�� : " + m10 + "��");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
