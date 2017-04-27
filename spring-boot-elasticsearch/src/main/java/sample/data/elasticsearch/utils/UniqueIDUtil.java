package sample.data.elasticsearch.utils;

public class UniqueIDUtil {

	private static SnowFlake sf = new SnowFlake(1, 1);

	public static String nextId() {
		return "" + sf.nextId();
	}
}
