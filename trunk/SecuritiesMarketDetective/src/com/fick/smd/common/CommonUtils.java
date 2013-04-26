package com.fick.smd.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.com.webxml.ArrayOfString;

import com.fick.smd.hibernate.formbean.stockbean.Stock;

public class CommonUtils {

	private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final String splitFlag = " / ";

	/**
	 * webservice的ArrayOfString对象转换为Stock对象
	 * 
	 * @param ArrayOfString
	 * @return
	 */
	public static Stock arrayToStock(ArrayOfString array) {
		if (array == null) {
			return null;
		}
		List<String> strings = array.getString();
		if (strings.get(3) == null || "".equals(strings.get(3))) {
			return null;
		}
		Stock retVal = new Stock();
		retVal.setCode(strings.get(0));
		retVal.setName(strings.get(1));
		try {
			retVal.setDatetime(df.parse(strings.get(2)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			retVal.setDatetime(new Date());
		}
		retVal.setPrice_current(Float.parseFloat(strings.get(3)));
		retVal.setPrice_yesterday(Float.parseFloat(strings.get(4)));
		retVal.setPrice_today(Float.parseFloat(strings.get(5)));
		retVal.setPrice_change(Float.parseFloat(strings.get(6)));
		retVal.setPrice_lowest(Float.parseFloat(strings.get(7)));
		retVal.setPrice_highest(Float.parseFloat(strings.get(8)));
		retVal.setChange_rate(Float.parseFloat(strings.get(9).replace("%", "")));
		retVal.setTurnover(Float.parseFloat(strings.get(10)));
		retVal.setTurnover_sum(Float.parseFloat(strings.get(11)));
		if (strings.get(12) != null) {
			retVal.setPrice_buy(Float.parseFloat(strings.get(12)));
		}
		if (strings.get(13) != null) {
			retVal.setPrice_sell(Float.parseFloat(strings.get(13)));
		}
		if (strings.get(14) != null) {
			retVal.setCons_rate(Float.parseFloat(strings.get(14).replace("%", "")));
		}
		float[] vals = new float[2];
		String[] strs = new String[2];
		if (strings.get(15) != null) {
			strs = strings.get(15).split(splitFlag);
			vals[0] = Float.parseFloat(strs[0]);
			vals[1] = Float.parseFloat(strs[1]);
			retVal.setPrice_buy_one(vals);
		}
		if (strings.get(16) != null) {
			strs = strings.get(16).split(splitFlag);
			vals[0] = Float.parseFloat(strs[0]);
			vals[1] = Float.parseFloat(strs[1]);
			retVal.setPrice_buy_two(vals);
		}
		if (strings.get(17) != null) {
			strs = strings.get(17).split(splitFlag);
			vals[0] = Float.parseFloat(strs[0]);
			vals[1] = Float.parseFloat(strs[1]);
			retVal.setPrice_buy_three(vals);
		}
		if (strings.get(18) != null) {
			strs = strings.get(18).split(splitFlag);
			vals[0] = Float.parseFloat(strs[0]);
			vals[1] = Float.parseFloat(strs[1]);
			retVal.setPrice_buy_four(vals);
		}
		if (strings.get(19) != null) {
			strs = strings.get(19).split(splitFlag);
			vals[0] = Float.parseFloat(strs[0]);
			vals[1] = Float.parseFloat(strs[1]);
			retVal.setPrice_buy_five(vals);
		}
		if (strings.get(20) != null) {
			strs = strings.get(20).split(splitFlag);
			vals[0] = Float.parseFloat(strs[0]);
			vals[1] = Float.parseFloat(strs[1]);
			retVal.setPrice_sell_one(vals);
		}
		if (strings.get(21) != null) {
			strs = strings.get(21).split(splitFlag);
			vals[0] = Float.parseFloat(strs[0]);
			vals[1] = Float.parseFloat(strs[1]);
			retVal.setPrice_sell_two(vals);
		}
		if (strings.get(22) != null) {
			strs = strings.get(22).split(splitFlag);
			vals[0] = Float.parseFloat(strs[0]);
			vals[1] = Float.parseFloat(strs[1]);
			retVal.setPrice_sell_three(vals);
		}
		if (strings.get(23) != null) {
			strs = strings.get(23).split(splitFlag);
			vals[0] = Float.parseFloat(strs[0]);
			vals[1] = Float.parseFloat(strs[1]);
			retVal.setPrice_sell_four(vals);
		}
		if (strings.get(24) != null) {
			strs = strings.get(24).split(splitFlag);
			vals[0] = Float.parseFloat(strs[0]);
			vals[1] = Float.parseFloat(strs[1]);
			retVal.setPrice_sell_five(vals);
		}
		return retVal;
	}

	/**
	 * String数据转换成Stock对象，用于http连接得到股票信息
	 * 
	 * @param strings
	 * @return
	 */
	public static Stock stringsToStock(String[] strings) {
		if (strings == null) {
			return null;
		}
		Stock retVal = new Stock();
		retVal.setCode(strings[0]);
		retVal.setName(strings[1]);
		if (strings.length == 7) {
			retVal.setValue_current(Float.parseFloat(strings[2]));
			retVal.setPrice_current(Float.parseFloat(strings[3]));
			retVal.setChange_rate(Float.parseFloat(strings[4]));
			retVal.setTurnover(Float.parseFloat(strings[5]));
			retVal.setTurnover_sum(Float.parseFloat(strings[6]));

		} else if (strings.length == 34) {
			retVal.setPrice_today(Float.parseFloat(strings[2]));
			retVal.setPrice_yesterday(Float.parseFloat(strings[3]));
			retVal.setPrice_current(Float.parseFloat(strings[4]));
			retVal.setPrice_highest(Float.parseFloat(strings[5]));
			retVal.setPrice_lowest(Float.parseFloat(strings[6]));
			retVal.setPrice_buy(Float.parseFloat(strings[7]));
			retVal.setPrice_sell(Float.parseFloat(strings[8]));
			retVal.setTurnover(Float.parseFloat(strings[9]));
			retVal.setTurnover_sum(Float.parseFloat(strings[10]));
			retVal.setPrice_avg(retVal.getTurnover_sum() / retVal.getTurnover());
			float[] vals = new float[2];
			vals[0] = Float.parseFloat(strings[12]);
			vals[1] = Float.parseFloat(strings[11]);
			retVal.setPrice_buy_one(vals);

			vals[0] = Float.parseFloat(strings[14]);
			vals[1] = Float.parseFloat(strings[13]);
			retVal.setPrice_buy_two(vals);

			vals[0] = Float.parseFloat(strings[16]);
			vals[1] = Float.parseFloat(strings[15]);
			retVal.setPrice_buy_three(vals);

			vals[0] = Float.parseFloat(strings[18]);
			vals[1] = Float.parseFloat(strings[17]);
			retVal.setPrice_buy_four(vals);

			vals[0] = Float.parseFloat(strings[20]);
			vals[1] = Float.parseFloat(strings[19]);
			retVal.setPrice_buy_five(vals);

			vals[0] = Float.parseFloat(strings[22]);
			vals[1] = Float.parseFloat(strings[21]);
			retVal.setPrice_sell_one(vals);

			vals[0] = Float.parseFloat(strings[24]);
			vals[1] = Float.parseFloat(strings[23]);
			retVal.setPrice_sell_two(vals);

			vals[0] = Float.parseFloat(strings[26]);
			vals[1] = Float.parseFloat(strings[25]);
			retVal.setPrice_sell_three(vals);

			vals[0] = Float.parseFloat(strings[28]);
			vals[1] = Float.parseFloat(strings[27]);
			retVal.setPrice_sell_four(vals);

			vals[0] = Float.parseFloat(strings[30]);
			vals[1] = Float.parseFloat(strings[29]);
			retVal.setPrice_sell_five(vals);
			try {
				retVal.setDatetime(df.parse(strings[31] + " " + strings[32]));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				retVal.setDatetime(new Date());
			} catch (NumberFormatException e2) {
				retVal.setDatetime(new Date());
			}
		}
		retVal.setChange_rate((retVal.getPrice_current() - retVal.getPrice_yesterday()) * 100 / retVal.getPrice_yesterday());
		return retVal;
	}

	/**
	 * 将代码列表组织成'code1','code2','code3'的字符串形式；
	 * 
	 * @param stocks
	 * @return
	 */
	public static String getStringFromList(List<String> stocks) {
		if (stocks == null || stocks.size() < 1) {
			return "";
		}
		StringBuffer sb = new StringBuffer("");
		for (String temp : stocks) {
			sb.append("'");
			sb.append(temp);
			sb.append("',");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	/**
	 * 根据字符串，得到Long类型值，用于解析配置文件中的Long类型值
	 * 
	 * @param s
	 * @return
	 */
	public static Long getLongFromString(String s) {
		if (s != null) {
			return Long.parseLong(s);
		}
		return null;
	}

	/**
	 * 根据字符串，得到Integer类型值，用于解析配置文件中的Integer类型值
	 * 
	 * @param s
	 * @return
	 */
	public static Integer getIntegerFromString(String s) {
		if (s != null) {
			return Integer.parseInt(s);
		}
		return null;
	}

	/**
	 * 根据字符串，得到Float类型值，用于解析配置文件中的Float类型值
	 * 
	 * @param s
	 * @return
	 */
	public static Float getFloatFromString(String s) {
		if (s != null) {
			return Float.parseFloat(s);
		}
		return null;
	}

	/**
	 * 根据字符串，得到Boolean类型值，用于解析配置文件中的Boolean类型值
	 * 
	 * @param s
	 * @return
	 */
	public static Boolean getBooleanFromString(String s) {
		if (s != null) {
			return Boolean.parseBoolean(s);
		}
		return null;
	}
	//
	// public static float getAvg(Float curr, float val) {
	// return curr == null ? val : (curr + val) / 2;
	// }
}
