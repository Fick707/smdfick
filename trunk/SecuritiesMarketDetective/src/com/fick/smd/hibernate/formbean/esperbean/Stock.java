package com.fick.smd.hibernate.formbean.esperbean;

import java.util.Date;

/**
 * 
 * String(25)，结构为：
 * String(0)股票代号、
 * String(1)股票名称、
 * String(2)行情时间、
 * String(3)最新价（元）、
 * String(4)昨收盘（元）、
 * String(5)今开盘（元）、
 * String(6)涨跌额（元）、
 * String(7)最低（元）、
 * String(8)最高（元）、
 * String(9)涨跌幅（%）、
 * String(10)成交量（手）、
 * String(11)成交额（万元）、
 * String(12)竞买价（元）、
 * String(13)竞卖价（元）、
 * String(14)委比（%）、
 * String(15)-String(19)买一 - 买五（元）/手、
 * String(20)-String(24)卖一 - 卖五（元）/手。
 */
public class Stock {

	private String code;
	private String name;
	private Date datetime;
	private float price_current;
	private float price_yesterday;
	private float price_today;
	private float price_change;
	private float price_lowest;
	private float price_highest;
	private float change_rate;
	private float turnover;
	private float turnover_sum;
	private float price_buy;
	private float price_sell;
	private float cons_rate;
	private float[] price_buy_one = new float[2];
	private float[] price_buy_two = new float[2];
	private float[] price_buy_three = new float[2];
	private float[] price_buy_four = new float[2];
	private float[] price_buy_five = new float[2];
	private float[] price_sell_one = new float[2];
	private float[] price_sell_two = new float[2];
	private float[] price_sell_three = new float[2];
	private float[] price_sell_four = new float[2];
	private float[] price_sell_five = new float[2];
	private float value_current;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public float getPrice_current() {
		return price_current;
	}

	public void setPrice_current(float price_current) {
		this.price_current = price_current;
	}

	public float getPrice_yesterday() {
		return price_yesterday;
	}

	public void setPrice_yesterday(float price_yesterday) {
		this.price_yesterday = price_yesterday;
	}

	public float getPrice_today() {
		return price_today;
	}

	public void setPrice_today(float price_today) {
		this.price_today = price_today;
	}

	public float getPrice_change() {
		return price_change;
	}

	public void setPrice_change(float price_change) {
		this.price_change = price_change;
	}

	public float getPrice_lowest() {
		return price_lowest;
	}

	public void setPrice_lowest(float price_lowest) {
		this.price_lowest = price_lowest;
	}

	public float getPrice_highest() {
		return price_highest;
	}

	public void setPrice_highest(float price_highest) {
		this.price_highest = price_highest;
	}

	public float getChange_rate() {
		return change_rate;
	}

	public void setChange_rate(float change_rate) {
		this.change_rate = change_rate;
	}

	public float getTurnover() {
		return turnover;
	}

	public void setTurnover(float turnover) {
		this.turnover = turnover;
	}

	public float getTurnover_sum() {
		return turnover_sum;
	}

	public void setTurnover_sum(float turnover_sum) {
		this.turnover_sum = turnover_sum;
	}

	public float getPrice_buy() {
		return price_buy;
	}

	public void setPrice_buy(float price_buy) {
		this.price_buy = price_buy;
	}

	public float getPrice_sell() {
		return price_sell;
	}

	public void setPrice_sell(float price_sell) {
		this.price_sell = price_sell;
	}

	public float[] getPrice_buy_one() {
		return price_buy_one;
	}

	public void setPrice_buy_one(float[] price_buy_one) {
		this.price_buy_one = price_buy_one;
	}

	public float[] getPrice_buy_two() {
		return price_buy_two;
	}

	public void setPrice_buy_two(float[] price_buy_two) {
		this.price_buy_two = price_buy_two;
	}

	public float[] getPrice_buy_three() {
		return price_buy_three;
	}

	public void setPrice_buy_three(float[] price_buy_three) {
		this.price_buy_three = price_buy_three;
	}

	public float[] getPrice_buy_four() {
		return price_buy_four;
	}

	public void setPrice_buy_four(float[] price_buy_four) {
		this.price_buy_four = price_buy_four;
	}

	public float[] getPrice_buy_five() {
		return price_buy_five;
	}

	public void setPrice_buy_five(float[] price_buy_five) {
		this.price_buy_five = price_buy_five;
	}

	public float[] getPrice_sell_one() {
		return price_sell_one;
	}

	public void setPrice_sell_one(float[] price_sell_one) {
		this.price_sell_one = price_sell_one;
	}

	public float[] getPrice_sell_two() {
		return price_sell_two;
	}

	public void setPrice_sell_two(float[] price_sell_two) {
		this.price_sell_two = price_sell_two;
	}

	public float[] getPrice_sell_three() {
		return price_sell_three;
	}

	public void setPrice_sell_three(float[] price_sell_three) {
		this.price_sell_three = price_sell_three;
	}

	public float[] getPrice_sell_four() {
		return price_sell_four;
	}

	public void setPrice_sell_four(float[] price_sell_four) {
		this.price_sell_four = price_sell_four;
	}

	public float[] getPrice_sell_five() {
		return price_sell_five;
	}

	public void setPrice_sell_five(float[] price_sell_five) {
		this.price_sell_five = price_sell_five;
	}

	public float getCons_rate() {
		return cons_rate;
	}

	public void setCons_rate(float cons_rate) {
		this.cons_rate = cons_rate;
	}

	public float getValue_current() {
		return value_current;
	}

	public void setValue_current(float value_current) {
		this.value_current = value_current;
	}

	/**
	 * 根据股票代码和更新时间判断是否一样
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Stock)) {
			return false;
		}
		Stock stock = (Stock) obj;
		if (stock.getCode().equals(this.code) && stock.getPrice_current() == this.price_current) {
			return true;
		}
		return false;
	}

}
