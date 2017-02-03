package model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;

public class ShowList extends ArrayList<Show> {

	/*
	 * 返回用户查询的该电影院的movie的票数
	 */
	public int returnTicketNumber(Date date, Time time) {
		int tickets = 0;
		for (Iterator iter = this.iterator(); iter.hasNext();) {
			// System.out.println(((Show)iter.next()).getTitle());
			// 这样直接的this 是可以的,掉渣天啊
			Show show = (Show) iter.next();
			if(show.getDateSHow().compareTo(date) == 0&&show.getShowing().compareTo(time) == 0){
				tickets = Integer.parseInt(show.getSeatLeft());
			}
		}
		return tickets;
	}

}
