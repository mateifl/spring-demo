package ro.mfl.testclient.testplan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ResourceUtils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class TestPlan {

	private final List<TestPlanItem> items = new ArrayList<TestPlanItem>();

	public void loadFromFile(String path) {
		log.info("load test plan from: " + path);

		try (BufferedReader reader = new BufferedReader(
				new FileReader(ResourceUtils.getFile(path)))) {
			reader.lines().forEach(line -> {
				String[] lineItems = line.split(" ");
				TestPlanItem item = TestPlanItem.builder()
						.journeyName(lineItems[0])
						.runsNumber(Integer.valueOf(lineItems[1]))
						.build();
				items.add(item);
			});
		} catch (Exception e) {
			log.error("", e);
		} 
	}
}
