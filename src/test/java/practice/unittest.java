package practice;

import java.util.List;
import java.util.Map;
import org.junit.Test;
import amfam.bdd.base.BaseClass;

public class unittest {

	@Test
	public void excelUtilTest() {
		BaseClass baseClass = new BaseClass();
		List<Map<String, String>> data = baseClass.utils.getMapDataList();
		int appender = 0;
		for(Map<String, String> innerMap : data) {
			System.out.println(innerMap.keySet());
			appender++;
			System.out.println(innerMap.get("zip"+appender));
		}
	}
}
