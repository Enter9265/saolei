package com.yan.dao;
/*
 * 雷周围的数字计算，一个雷周围的数字都加1
 * 注意：
 * 		特殊区域：左上角，右上角，左下角，右下角，左边，右边，上边，下边，八个地方特殊处理
 * 		其余地方周围都加1
 * */
public class Jisuan {
	public static void jisuan(int[][] s, int a, int b) {


		for(int x = 0;x < a; x++){
			for(int y = 0; y < b; y++ ){
				if(s[x][y]>=100 ){
					if(x==a-1&&y==b-1){//右下角
						s[x-1][y]++
						;s[x][y-1]++;
						s[x-1][y-1]++;
					}else if(x==a-1&&y==0){//左下角
						s[x-1][y]++;
						s[x][y+1]++;
						s[x-1][y+1]++;
					}else if(x==0&&y==0){//左上角
						s[x][y+1]++;
						s[x+1][y]++;
						s[x+1][y+1]++;
					}else if(x==0&&y==b-1){//右上角
						s[x][y-1]++;
						s[x+1][y]++;
						s[x+1][y-1]++;
					}else if(x==0&&y!=b-1&&y!=0){//上边
						s[x+1][y]++;
						s[x][y+1]++;
						s[x][y-1]++;
						s[x+1][y-1]++;
						s[x+1][y+1]++;
					}else if(x==a-1&&y!=0&&y!=b-1){//右边
						s[x-1][y]++;
						s[x][y+1]++;
						s[x][y-1]++;
						s[x-1][y+1]++;
						s[x-1][y-1]++;
					}else if(x!=0&&x!=a-1&&y==0){//左边
						s[x+1][y]++;
						s[x-1][y]++;
						s[x][y+1]++;
						s[x+1][y+1]++;
						s[x-1][y+1]++;
					}else if(x!=0&&x!=a-1&&y==b-1){//下边
						s[x+1][y]++;
						s[x-1][y]++;
						s[x][y-1]++;
						s[x+1][y-1]++;
						s[x-1][y-1]++;
					}else{//其余的数
						s[x+1][y]++;
						s[x-1][y]++;
						s[x][y+1]++;
						s[x][y-1]++;
						s[x+1][y-1]++;
						s[x+1][y+1]++;
						s[x-1][y+1]++;
						s[x-1][y-1]++;
					}
				}
			}
		}
	}
}
