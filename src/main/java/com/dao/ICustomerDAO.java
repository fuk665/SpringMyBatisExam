package com.dao;

import com.entity.Customer;

public interface ICustomerDAO {

	//增加
	public void addCus(Customer cus) throws Exception ;
	
	//删除
	public void delCus(Integer cid) throws Exception ;
	
	//查询addressid是否存在
	public String findAddressIdisE(Integer aid) throws Exception ;
	
	//查询address
	public String findAddressById(Integer aid) throws Exception ;
	
	//查询cusid是否存在
	public String findCid(Integer cid) throws Exception ;
	
	//测试
	public int testt() throws Exception ;
	
}
