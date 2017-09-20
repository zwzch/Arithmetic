package OneHash;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

public class HashUtil {
	public HashUtil() {
	}

	//	private Long hash(String key) {
//
//		ByteBuffer buf = ByteBuffer.wrap(key.getBytes());
//		int seed = 0x1234ABCD;
//
//		ByteOrder byteOrder = buf.order();
//		buf.order(ByteOrder.LITTLE_ENDIAN);
//
//		long m = 0xc6a4a7935bd1e995L;
//		int r = 47;
//
//		long h = seed ^ (buf.remaining() * m);
//
//		long k;
//		while (buf.remaining() >= 8) {
//			k = buf.getLong();
//
//			k *= m;
//			k ^= k >>> r;
//			k *= m;
//
//			h ^= k;
//			h *= m;
//		}
//
//		if (buf.remaining() > 0) {
//			ByteBuffer finish = ByteBuffer.allocate(8).order(
//					ByteOrder.LITTLE_ENDIAN);
//			// for big-endian version, do this first:
//			// finish.position(8-buf.remaining());
//			finish.put(buf).rewind();
//			h ^= finish.getLong();
//			h *= m;
//		}
//
//		h ^= h >>> r;
//		h *= m;
//		h ^= h >>> r;
//
//		buf.order(byteOrder);
//		return h;
//	}
	public static long Hash(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'0', '1', '2', '3', '4', '5' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			int data =  Integer.parseInt(new String(str).substring(0, 8));
			return getUnsignedIntt(data);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public static long getUnsignedIntt(int data){     //将int数据转换为0~4294967295 (0xFFFFFFFF即DWORD)。
		return data&0x0FFFFFFFFl;
	}
	public static void main(String[] args) {

		System.out.println();
		System.out.println(new HashUtil().Hash("192.168.56.111"));
	}
}
