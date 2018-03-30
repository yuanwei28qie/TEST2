package com.microsilver.mrcard.common;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.text.ParseException;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.common.CryptoTools
 * @Description 加密工具类
 * 
 * @Author bruce
 * @Version 2017年6月28日
 * @Copyright Micro Silver
 *
 */
public class CryptoTools {
	// private final static String DESKey = Consts.APP_TOKEN_DES_KEY;
	// private final static byte[] DESIV = { 0x12, 0x34, 0x56, 0x78, (byte) 0x90,
	// (byte) 0xAB, (byte) 0xCD, (byte) 0xEF };
	private final static byte[] DESIV = { 1, 2, 3, 4, 5, 6, 7, 8 };
	private static AlgorithmParameterSpec iv = null;
	//private static Key key = null;

	private static Key getKey(byte[] arrBTmp) throws Exception {
        // 创建一个空的8位字节数组（默认值为0）
        byte[] arrB = new byte[8];

        // 将原始字节数组转换为8位
        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }

        // 生成密钥
        Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");

        return key;
    }
	/**
	 * MD5加密，和PHP加密保持一致，仅密码加密使用
	 * 
	 * @param source
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String EncoderByMd5(String source) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(source.getBytes("GBK"));
			StringBuffer buf = new StringBuffer();
			for (byte b : md.digest()) {
				buf.append(String.format("%02x", b & 0xff));
			}
			return buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encodeByDes(String data, String descKey) throws Exception {
		iv = new IvParameterSpec(DESIV);
		//DESKeySpec keySpec = new DESKeySpec(descKey.getBytes("UTF-8"));
		//SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		//Key key1 = keyFactory.generateSecret(keySpec);
		Key key =getKey(descKey.getBytes());
		Cipher enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		enCipher.init(Cipher.ENCRYPT_MODE, key, iv);
		byte[] pasByte = enCipher.doFinal(data.getBytes("utf-8"));

		Base64 base64 = new Base64();
		return base64.encodeAsString(pasByte);
	}

	/**
	 * 解密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String decodeByDes(String data, String descKey) throws Exception {
		iv = new IvParameterSpec(DESIV);// 设置向量
		//DESKeySpec keySpec = new DESKeySpec(descKey.getBytes("UTF-8"));// 设置密钥参数
		//SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// 获得密钥工厂
		//key = keyFactory.generateSecret(keySpec);// 得到密钥对象
		Key key =getKey(descKey.getBytes());
		Cipher deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		deCipher.init(Cipher.DECRYPT_MODE, key, iv);
		Base64 base64 = new Base64();

		
		//return new String(deCipher.doFinal(hexStr2ByteArr(data)));
		byte[] pasByte = deCipher.doFinal(base64.decode(data));
		return new String(pasByte, "UTF-8");
		
	}
	
	 

	public static void main(String args[]) {
		String mw = "PucJgPdtYbxJNMuiYZfPiHSHcxr88b1mR3okQaOjfsEDSaIIelU82EHqGRMYQFJr";
		String cer = "ul9POTsAFAVMsyplVjsptp+GqGu7uIe";
		try {
			String str1 = decodeByDes(mw, "microsilver");
			System.out.println("第一次：" + str1);
			String str2 = decodeByDes(cer, "microsilver");
			System.out.println("第二次：" + str2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
