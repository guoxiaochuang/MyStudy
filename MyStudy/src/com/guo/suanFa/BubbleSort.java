package com.guo.suanFa;

/**
 * 
 * <p>冒泡排序</p>
 *
 * @author guoxiaochuang
 * @email guoxiaochuang@boco.com.cn
 * @version v1.0
 * @date 2019年5月24日 下午4:32:28
 * @modify <BR>
 * 		修改内容：<BR/>
 * 		修改人员：<BR/>
 * 		修改时间：<BR/>
 */
public class BubbleSort {
	public static int[] sort(int[] arr){
		for(int i=0; i<arr.length-1; i++){
			for(int j=i+1; j<arr.length; j++){
//				if(arr[i]<arr[j]){ // 降序
				if(arr[i]>arr[j]){ // 升序
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
	public static int[] sort2(int[] arr){
		for(int i=0; i<arr.length; i++){
			for(int j=i; j<arr.length-1-i; j++){
				if(arr[j]>arr[j+1]){ // 升序
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		int[] a = {9,1,8,2,7,3,6,4,5};
//		int[] b = sort(a);
		int[] b = sort2(a);
		for(int n:b){
			System.out.println(n);
		}
	}
}
