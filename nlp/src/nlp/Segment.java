
package nlp;

/**
 * 分词接口
 */

public interface Segment {
	/**
	 * 按给定的字典对文本分词
	 * @param source，要分词的文本
	 * @param Subdictionary，给定的字典
	 * @return
	 */
	public String segment(String source, SubDictionary dictionary);
}
