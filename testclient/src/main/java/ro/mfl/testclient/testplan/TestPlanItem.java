package ro.mfl.testclient.testplan;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Data
public class TestPlanItem {
	 private final String journeyName;
	 private final Integer runsNumber;
}
