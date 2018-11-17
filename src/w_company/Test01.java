package w_company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
입력받는 값에 따른 계산기

*/
public class Test01 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		WadizWordClassifition wadizWordClassifition = new WadizWordClassifition();
		while( (line = br.readLine()) != null) {
			wadizWordClassifition.wordClassify(line);
			if(line.equals("exit"))
				break;
		}

	}

}

class WadizCalculator {

	private int sum;

	private static WadizCalculator getInstance;
	
	private ArrayList<HistoryData> historyDataList;

	public WadizCalculator() {
	}

	public WadizCalculator(int _init) {
		this.sum = _init;
		System.out.print(sum + "\n");
		
		historyDataList = new ArrayList<>();
		historyDataList.add(new HistoryData("init",_init));
	}
	

	public static WadizCalculator getGetInstance() {
		return getInstance;
	}

	public static void newInstance(int n) {
		getInstance = new WadizCalculator(n);
	}

	public void plusNum(int _num) {
		this.sum += _num;
		historyDataList.add(new HistoryData("plus",_num));
		
	}

	public void minusNum(int _num) {
		this.sum -= _num;
		historyDataList.add(new HistoryData("minus",_num));
		
	}

	public void removeBeforeCal(int _num) {
		_num = _num - 1;
		
		if(historyDataList.size()>_num||_num<0) {
			HistoryData historyData = historyDataList.get(_num);
			if(historyData.getOpertator().equals("plus")) {
				this.sum -= historyData.getNum();
				historyDataList.remove(historyData);
			}else if(historyData.getOpertator().equals("minus")){
				this.sum += historyData.getNum();
				historyDataList.remove(historyData);
			}
		}
		
	}

	public int getSum() {
		return this.sum;
	}

}

class HistoryData{
	
	private String opertator;
	
	private int num;
	
	public HistoryData() {}
	
	public HistoryData(String _opertator,int _num) {
		this.opertator = _opertator;
		this.num       = _num;
				
	}

	public String getOpertator() {
		return opertator;
	}

	public void setOpertator(String opertator) {
		this.opertator = opertator;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	} 
	
	
	
	
}

class WadizWordClassifition {

	private boolean initCheck = false;

	public void wordClassify(String message) {

		String[] arr = message.split(" ");

		if (arr.length > 1) {
			int number = Integer.parseInt(arr[1]);

			if (arr[0].equals("init")) {
					initCheck = true;
					System.out.print("set ");
					WadizCalculator.newInstance(number);
			}

			if (arr[0].equals("plus")) {
				if(initCheck)
					WadizCalculator.getGetInstance().plusNum(number);
				else
					System.out.println("-1");
			} else if (arr[0].equals("minus")&&initCheck) {
				if(initCheck)
					WadizCalculator.getGetInstance().minusNum(number);
				else
					System.out.println("-1");
			} else if (arr[0].equals("remove")&&initCheck) {
				if(initCheck)
					WadizCalculator.getGetInstance().removeBeforeCal(number);
				else
					System.out.println("-1");
			}

		} else {
			if (arr[0].equals("exit")) {
				System.out.println(WadizCalculator.getGetInstance().getSum());
			}
		}

	}

}