
package nlp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;



//import com.xq.util.File;
//import com.xq.util.Search; 
/**
 * 字典
 *
 */
public class SubDictionary {
	/**
	 * 字典单词的最大长度
	 */
	private int wordLen = 0;
	/**
	 * 字典数据
	 */
	private Hashtable<String, Integer> data = null;
	/**
	 * 字典文件位置
	 */
	private String url = "";
	
	/**
	 * 初始化子字典
	 * @param url，字典的url
	 */
	public SubDictionary(String url){
		this.url = url;
		data = new Hashtable<>();
	}
	
	/**
	 * 加载文件
	 * @param url，文件的位置
	 */
	public void load(){
		Word word = null;
		BufferedReader br = null;
		String temp = "";
		int len;
		if (data == null) data = new Hashtable<>();
		br = File.openByReader(url);
		if (br != null){
			try {
				while(true){
					temp = br.readLine();
					if (temp == null) break;
					String temp1 = null;
					//System.out.println(temp.length());
					 int i=0;
					  for(int j = 0;j<temp.length();j++)
					   {if (temp.charAt(j)==' '&&i<j) 
					     { //System.out.println(1);
						   //System.out.println(i+"--"+j);
						  temp1=temp.substring(i, j);
						 // System.out.println(temp1);
						  word = new Word(temp1);
						  data.put(word.getContent(), word.getLength());
						  len=word.getLength();
						  if(len>wordLen)
						  { wordLen=word.getLength(); }
						  i=j+2;
						  j=j+2;
					     }
					     if (j==temp.length()-1) 
					     {
					    	//System.out.println(2);
							//System.out.println(i+"--"+j);
							temp1=temp.substring(i);
							//System.out.println(temp1);
							word = new Word(temp1);
							data.put(word.getContent(),word.getLength());
							len=word.getLength();
							if(len>wordLen)
							  {wordLen=word.getLength();}
							//i=temp.length()-1;
							break;
						 }
					   }
					
				}
				br.close();
			} catch (IOException e) {
				System.out.println("dictionary load error, " + url);
			}
		}
		
	}
	/**
	 * 导入单词，检查word的长度是否和当前字典的一致
	 * @param word，要导入的单词
	 * @return
	 */
	/**
	 * 保存字典
	 *
	 */
	/**
	 * 在字典查找word，找到返回true
	 * @param word
	 * @return
	 */
	/**
	 * 在字典查找word，找到返回true
	 * @param word
	 * @return
	 */
	/**
	 * 返回字典的单词长度
	 * @return
	 */
	public boolean find(String str){
		Word newWord = new Word(str);
		if(this.data.containsKey(newWord.getContent()))
			return true;
		else 
		    return false;
	}
	public int getWordLen() {
		return wordLen;
	}
	/**
	 * 设置字典的单词长度
	 * @param wordLen
	 */
	public void setWordLen(int wordLen) {
		this.wordLen = wordLen;
	}
}
