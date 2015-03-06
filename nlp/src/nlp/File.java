
package nlp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
/**
 * �ļ����ò�����
 *
 */
public class File {

	/**
	 * ���ļ������ش򿪵�BufferedReader
	 * @param url,�ļ���ַ
	 * @return
	 */
	public static BufferedReader openByReader(String url){
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(url));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			br = null;
		}
		return br;
	}
	/**
	 * ���ļ������ض�ȡ���ı����ı���GBK��ȡ
	 * @param url,�ļ���ַ
	 * @return, ����strng����GBK��ȡ
	 */
	public static String open(String url){
		FileInputStream fis = null;
		String result = "";
		byte[] buffer = new byte[10 * 1024];
		byte[] temp = null;
		int count = 0;
		try {
			fis = new FileInputStream(url);
			while(true){
				count = fis.read(buffer);
				if (count == -1) break;
				temp = new byte[count];
				System.arraycopy(buffer, 0, temp, 0, count);
				result += new String(temp, "GBK");
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * д�ļ�����GBK�����ʽд��
	 * @param url���ļ���
	 * @param content��д�������
	 * @return
	 */
	public static boolean writeFile(String url, String content){
		java.io.File file = new java.io.File(url);
		String parent = file.getParent();
		java.io.File dir = new java.io.File(parent);
		if (!dir.exists()) dir.mkdirs();
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(url);
			fos.write(content.getBytes("GBK"));
			fos.close();
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("file not found, " + url);
			return false;
		} catch (UnsupportedEncodingException e) {
			System.out.println("UnsupportedEncodingException, " + url);
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * ȡ��ĳһ·���µ������ļ�
	 * @param path
	 * @return
	 */
	public static java.io.File[] getFiles(String path, FilenameFilter filter){
		java.io.File file = new java.io.File(path);
		return file.listFiles(filter);
	}

}
