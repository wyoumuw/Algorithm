package com.youmu.maven.Algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Created by youmu on 2017/7/5.
 */
public class GetCount {

	public static void main(String[] args) {
		int map[][]={
				{	-1,	5,	1,	4,	15,	23,	4,	8,	1,	15},
				{	1,	0,	3,	12,	1,	0,	9,	3,	4,	8},
				{	4,	5,	7,	0,	58,	5,	0,	7,	9,	3},
				{	7,	11,	5,	1,	4,	72,	1,	2,	9,	3}
		};
		GetCount c=new GetCount();
		if(c.start(map,map.length,map[0].length,48)) {
			System.out.println(c.getTraceArray());
		}else{
			System.out.println("无法达到");
		}
	}

	private Deque<String> traceArray;

	public Deque<String> getTraceArray() {
		return traceArray;
	}

	public GetCount(){
		traceArray=new ArrayDeque<String>();
	}
	boolean start(int[][]map,int length,int width,int expectedScore){
		return next(1,0,0,map,length,width,0,expectedScore)||next(2,0,0,map,length,width,0,expectedScore);
	}
	/**
	 *
	 * @param direction 0 上， 1 右， 2 下， 3 左
	 * @param x
	 * @param y
	 * @param map
	 * @param length
	 * @param width
	 */
	boolean next(int direction,int x,int y,int[][]map,int length,int width,int lastScore,int expectedScore){
		addTrace(direction);//添加路径追踪
		switch (direction){
			case 0:y--;break;//上
			case 1:x++;break;//右
			case 2:y++;break;//下
			case 3:x--;break;//左
			default:removeTrace();return false;
		}
		if(isIllegalPosition(x,y,width,length)){
			removeTrace();
			return false;
		}
		//这个点是0则要么是答案要么放弃这个移动
		if(0==map[y][x]){
			if(lastScore==expectedScore){
				return true;
			}else{
				removeTrace();
				return false;
			}
		}
		//移动到下个点
		boolean ret=next(1,x,y,map,length,width,lastScore+map[y][x],expectedScore)||next(2,x,y,map,length,width,lastScore+map[y][x],expectedScore);
		if(!ret){
			removeTrace();
		}
		return ret;

	}

	void addTrace(int direction){
		switch (direction){
			case 0:traceArray.add("上");break;//上
			case 1:traceArray.add("右");break;//右
			case 2:traceArray.add("下");break;//下
			case 3:traceArray.add("左");break;//左
		}
	}

	void removeTrace(){
		traceArray.pollLast();
	}

	boolean isIllegalPosition(int x,int y,int width,int length){
		if(x>=width||x<0||y<0||y>=length){
			return true;
		}
		return false;
	}
}
