package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BatchBranchWiseData {

	public static void main(String[] args) {
	
		Map<String, Object> batchBranchMapData = new HashMap<>();
		
		List<Map<String,String>> batchBranchList = new ArrayList<>();
		Map<String,String> hMap = new HashMap<String, String>();
		
		hMap.put("branch", "B.Tech - CIVIL");
		hMap.put("batch", "2010-2014");
		hMap.put("student_count", "9");
		batchBranchList.add(hMap);
		
		hMap = new HashMap<String, String>();
		hMap.put("branch", "B.Tech - CSE");
		hMap.put("batch", "2010-2014");
		hMap.put("student_count", "2");
		batchBranchList.add(hMap);
		
		hMap = new HashMap<String, String>();
		hMap.put("branch", "B.Tech - EEE");
		hMap.put("batch", "2010-2014");
		hMap.put("student_count", "1");
		batchBranchList.add(hMap);
		
		hMap = new HashMap<String, String>();
		hMap.put("branch", "B.Tech - IT");
		hMap.put("batch", "2010-2014");
		hMap.put("student_count", "10");
		batchBranchList.add(hMap);
		
		hMap = new HashMap<String, String>();
		hMap.put("branch", "B.Tech - CIVIL");
		hMap.put("batch", "2011-2015");
		hMap.put("student_count", "2");
		batchBranchList.add(hMap);
		
		hMap = new HashMap<String, String>();
		hMap.put("branch", "B.Tech - IT");
		hMap.put("batch", "2011-2015");
		hMap.put("student_count", "3");
		batchBranchList.add(hMap);
		
		hMap = new HashMap<String, String>();
		hMap.put("branch", "B.Tech - CIVIL");
		hMap.put("batch", "2012-2016");
		hMap.put("student_count", "1");
		batchBranchList.add(hMap);
		
		hMap = new HashMap<String, String>();
		hMap.put("branch", "B.Tech - ECE");
		hMap.put("batch", "2013-2017");
		hMap.put("student_count", "1");
		batchBranchList.add(hMap);
		
		hMap = new HashMap<String, String>();
		hMap.put("branch", "-");
		hMap.put("batch", "2014-2018");
		hMap.put("student_count", "0");
		batchBranchList.add(hMap);
		
		hMap = new HashMap<String, String>();
		hMap.put("branch", "-");
		hMap.put("batch", "2015-2019");
		hMap.put("student_count", "0");
		batchBranchList.add(hMap);
		
//		Collections.synchronizedMap(hMap);
		
		
//		System.out.println(batchBranchList);
		
		Map<String, Object> branchWiseMap = new HashMap<>();
		int[] branchDataArray;
		int index = 0;

		for(String branch : getBranchNames()) {	
			branchDataArray = new int[getBranchNames().size()];	

			for(Map batchBranchMap : batchBranchList) {
				if(batchBranchMap.containsValue(branch) ) {
					
					if(branch.equals(batchBranchMap.get("branch"))) {
						index = getBatchNames().indexOf(batchBranchMap.get("batch"));
						
						branchDataArray[index] = Integer.parseInt(batchBranchMap.get("student_count")+"");
					}
				}
			}
			
			branchWiseMap.put(branch, Arrays.stream(branchDataArray).boxed().collect(Collectors.toList()) );
		}

		System.out.println(branchWiseMap);
		
		batchBranchMapData.put("branchWiseMap", branchWiseMap);
	}
	
	
	
	static List<String> getBranchNames() {
		String [] branchArray = {"B.Tech - CIVIL", "B.Tech - EEE", "B.Tech - MECH",	"B.Tech - ECE",	"B.Tech - CSE",	"B.Tech - IT"};
		
		List<String> branchNames = Arrays.asList(branchArray);
		
		return branchNames;
	}
	
	static List<String> getBatchNames() {
		String [] branchArray = {"2010-2014", "2011-2015", "2012-2016",	"2013-2017", "2014-2018", "2015-2019"};
		
		List<String> branchNames = Arrays.asList(branchArray);
		
		return branchNames;
	}


}
