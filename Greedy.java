package naver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//백준 알고리즘 1931번:회의실 배정
//https://www.acmicpc.net/problem/1931

public class Greedy {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = Integer.parseInt(scan.next()); //회의 수
		List<Meeting> meetingList = new ArrayList<>();
		for(int i=0; i<n; i++) {
			Meeting m = new Meeting();
			m.setStart(Integer.parseInt(scan.next()));
			m.setEnd(Integer.parseInt(scan.next()));
			
			meetingList.add(m);
		}
		
		//정렬
		Collections.sort(meetingList);
		
		//계산
		int endTime = meetingList.get(0).getEnd();
		int possibleNum = 1;
		
		for(int i=1; i<n; i++) {
			if(endTime <= meetingList.get(i).getStart()) {
				endTime = meetingList.get(i).getEnd();
				++ possibleNum;
			}
		}
		System.out.println(possibleNum);
	
	}
}

class Meeting implements Comparable<Meeting>{
	int start;
	int end;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	//종료시간 기준
	public int compareTo(Meeting m) {
		if(this.getEnd() == m.getEnd()) {
			if(this.getStart() < m.getStart()) {
				return -1; 
			}
			return 1;
		}else if(this.getEnd() < m.getEnd()) {
			return -1;
		}else {
			return 1;
		}
 	}
	
	
}
