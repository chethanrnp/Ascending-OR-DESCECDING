package com.crm.vtiger;

import java.time.Instant;
import java.util.Date;

public class System_DateFetching {

	 public static void main(String[] args) {
		Date d=new Date();
		String date = d.toString();
		//in IST format
		System.out.println(date);
		String year = date.split(" ")[5];
		String day = date.split(" ")[2];
		//String month = date.split(" ")[1];
		int month = d.getMonth();
		System.out.println(year+"/"+day+"/"+month);
	}
}