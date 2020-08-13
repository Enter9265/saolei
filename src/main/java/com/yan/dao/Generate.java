package com.yan.dao;

/*
 * l的值为炸弹的数量
 * x的值为行数
 * y的值为列数
 * 炸弹的个数就是所需坐标的个数，一个炸弹有（x，y）一个坐标
 * (x，y)的坐标不能相同，由此定义一个坐标类，使用HashSet来存储数据，泛型为坐标类。
 * */

import com.yan.pojo.Index;
import com.yan.pojo.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Generate {

	Map<String,String> linkedHashMap = new LinkedHashMap();

	public int[][] method(int l, int x, int y) {

		int  s[][] = new int[x][y];//定义一个字符数组

		//初始化数组
		for(int i = 0 ;i < x ; i++){
			for(int j = 0 ;j < y ;j++){
				s[i][j] = 0;
			}
		}


		//存储不重复的两个随机数
		// 创建HashSet对象 set，泛型为定义Shuzi类(里面包含了两个数字x，y)

		HashSet<Shuzi> set = new HashSet<Shuzi>();
		Random random = new Random();



		//  获取随机数字，值赋给set

		for(int i = 0 ;i < l ;i++){
			int a = random.nextInt(x);
			int b = random.nextInt(y);
			Shuzi k =new Shuzi(a,b);
			//System.out.println(k+" "+a+" "+b);
			if(!set.add(k))//添加不成功重新添加，直到添加的对象与之前的对象不同为止
				i--;
			//set.add(k);
		}

		//通过迭代器来给数组标记炸弹的位置，炸弹位置的值为1
		Iterator<Shuzi> ddq = set.iterator();
		while (ddq.hasNext()) {
			Shuzi a = ddq.next();
			s[a.getX()][a.getY()] = 100;
		}

		// 遍历数组显示，把炸弹的位置即数值大于等于100的地方显示"●"
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (s[i][j] >= 100) {
					System.out.print("  " + "●");
				} else {
					System.out.print("  " + s[i][j]);
				}
			}
			System.out.println();
		}

		Jisuan.jisuan(s, x, y);//调用Jisuan的静态方法jisuan来计算炸弹周围显示的数字
		return s;
	}



	public User gets(User user,int x,int y) {

		int xx = user.getX();
		int yy = user.getY();
		int[][] s = user.getMap();


		get(x, y,user);



		for (int i = 0; i < xx; i++) {
			for (int j = 0; j < yy; j++) {
				if (s[i][j] >= 100) {
					System.out.print("     " + "●");
				} else {
					System.out.print("     " + s[i][j]);
				}
			}
			System.out.println();
		}

		return user;
	}



	private Boolean get(int x, int y,User user) {
		int xx = user.getX();
		int yy = user.getY();

		int[][] s = user.getMap();
		if (x > xx - 1) {
			return false;
		}
		if (y > xx - 1) {
			return false;
		}
		if (y < 0) {
			return false;
		}
		if (x < 0) {
			return false;
		}
		if (s[x][y] == 0) {
			set(x,y,user);
			s[x][y] = -1;
			if (get(x + 1, y,user)) {
				return true;
			} else if (get(x + 1, y,user)) {
				return true;
			} else if (get(x - 1, y,user)) {
				return true;
			} else if (get(x, y + 1,user)) {
				return true;
			} else if (get(x, y - 1,user)) {
				return true;
			} else {
				int xy1 = x - 1;
				int xy2 = y - 1;
				int xy3 = x + 1;
				int xy4 = y + 1;

				if (xy1 != -1 && xy2 != -1 ) {
					if (s[xy1][xy2] != -1 && s[xy1][xy2] < 100 && s[xy1][xy2] != 0)
//                    if (s[xy1][xy2] < 100 && s[xy1][xy2] != 0)
						set(xy1,xy2,user);
				}
				if (xy1 != -1 && xy4 < yy) {
					if (s[xy1][xy4] != -1 && s[xy1][xy4] < 100 && s[xy1][xy4] != 0)
//                    if ( s[xy1][xy4] < 100 && s[xy1][xy4] != 0)
						set(xy1,xy4,user);
				}
				if (xy3 < xx && xy2 != -1) {
					if (s[xy3][xy2] != -1 && s[xy3][xy2] < 100 && s[xy3][xy2] != 0)
//                    if (s[xy3][xy2] < 100 && s[xy3][xy2] != 0)
						set(xy3,xy2,user);
				}
				if (xy3 < xx && xy4 < yy) {
					if (s[xy3][xy4] != -1 && s[xy3][xy4] < 100 && s[xy3][xy4] != 0)
//                    if (s[xy3][xy4] < 100 && s[xy3][xy4] != 0)
						set(xy3,xy4,user);
				}
				return false;
			}
		} else {
			if (s[x][y] != -1) {
				set(x,y,user);
			}
			return false;
		}
	}

	private  void set(int x,int y,User user){
		Set<String> set = user.getSet();
		if (set == null){
			set = new HashSet<>();
		}

		int[][] map = user.getMap();
		System.out.println(map[x][y]);
		if (map[x][y]>=100){
			user.setState(false);
		}

		String str = x + "-" + y;
		set.add(str);

		user.setSet(set);

	}

}