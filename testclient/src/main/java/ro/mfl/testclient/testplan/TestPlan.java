package ro.mfl.testclient.testplan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;


@Data
public class TestPlan {

	private final List<TestPlanItem> items = new ArrayList<TestPlanItem>();
	
	public void loadFromFile(String path) {
		try( BufferedReader reader = new BufferedReader( new FileReader(path) ) )
		{
			reader.lines().forEach( line -> {
				String[] lineItems = line.split(" ");
				TestPlanItem item = TestPlanItem.builder()
						.journeyName(lineItems[0])
						.runsNumber(Integer.valueOf(lineItems[1]))
						.build();
				items.add(item);
			});
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}



