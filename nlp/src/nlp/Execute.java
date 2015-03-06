package nlp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//import com.xq.util.File;
/**
 * 必须先导入词库，才能开始分词
 * @author Administrator
 *
 */
public class Execute {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//分解字符串，必须先导入词库
		String str1 = null;
		//String str1 = "G:/NLP/nlp_Chinese/bin/com/xq/dic/DicData2.txt";
		System.out.println("请输入词库路径和文件名");
		Scanner in1 = new Scanner(System.in);
		str1 = in1.next();
		SubDictionary dictionary = new SubDictionary(str1);
		dictionary.load();
		BufferedReader bReader = null;
		Scanner in = new Scanner(System.in);
		String str = "";
		String url = null;
		//String url = "C:/Users/HWB/Desktop/2.txt";
		System.out.println("请输入文件路径加名字");
		url = in.next();
		bReader = File.openByReader(url);
		//BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("result.txt"));
		long start = System.currentTimeMillis();
		if(bReader!=null){
			try {
				while(true){
					//bufferedWriter.write(cbuf);
					str=bReader.readLine();
					if(str==null) break;
					MaxMatchSegment seg = new MaxMatchSegment();
					int length = str.length();
					str = seg.segment(str, dictionary);
					str = str+"\n\r";
					bufferedWriter.write(str);
					//bufferedWriter.write("\n");
					//fW.write("str\n");
					//System.out.println(str);
				}
			} catch (Exception e) {
				System.out.println("无效路径！");
				// TODO: handle exception
			}finally{
					bufferedWriter.close();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("用时：" + (end - start));
		

	}

}
