package com.fire.utils;

import java.math.BigInteger;

/**
 * @author Administrator
 * 权限计算帮助�?
 */
public class RightsHelper {
	/**
	 * 利用BigInteger对权限进�?的权的和计算
	 * @param rights int型权限编码数�?
	 * @return 2的权的和
	 */
	public static BigInteger sumRights(int[] rights){
		BigInteger num = new BigInteger("0");
		for(int i=0; i<rights.length; i++){
			num = num.setBit(rights[i]);
		}
		return num;
	}
	/**
	 * 利用BigInteger对权限进�?的权的和计算
	 * @param rights String型权限编码数�?
	 * @return 2的权的和
	 */
	public static BigInteger sumRights(String[] rights){
		BigInteger num = new BigInteger("0");
		for(int i=0; i<rights.length; i++){
			num = num.setBit(Integer.parseInt(rights[i]));
		}
		return num;
	}
	
	/**
	 * 测试是否具有指定编码的权�?
	 * @param bigInteger
	 * @param targetRights
	 * @return
	 */
	public static boolean testRights(BigInteger bigInteger,int targetRights){
		return bigInteger.testBit(targetRights);
	}
	
	/**
	 * 测试是否具有指定编码的权�?
	 * @param sum
	 * @param targetRights
	 * @return
	 */
	public static boolean testRights(String sum,int targetRights){
		if(Tools.isEmpty(sum))
			return false;
		return testRights(new BigInteger(sum),targetRights);
	}
	
	/**
	 * 测试是否具有指定编码的权�?
	 * @param sum
	 * @param targetRights
	 * @return
	 */
	public static boolean testRights(String sum,String targetRights){
		if(Tools.isEmpty(sum))
			return false;
		return testRights(new BigInteger(sum),targetRights);
	}
	
	/**
	 * 测试是否具有指定编码的权�?
	 * @param sum
	 * @param targetRights
	 * @return
	 */
	public static boolean testRights(BigInteger sum,String targetRights){
		return testRights(sum,Integer.parseInt(targetRights));
	}
}
