package w_company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
막대기 들어왔을때 x축에 겹치면 1개의 막대기로 안겹치면 그냥막대기가 되는거


*/
public class Test02 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine(); //{3,7},{5,9},{12,17},{19,25},{12,15},{0,1}
		Analyze analyzeLine = new Analyze();

		Bar[] barList = analyzeLine.analyzeLine(line);
		analyzeLine.overlabBar(barList);
		analyzeLine.overlabBarV2(barList, barList[0].getX(), barList[0].getY(), 1);
	}

}

class Analyze {

	public Bar[] analyzeLine(String line) {
		List<Bar> barList = new ArrayList<Bar>();
		Bar[] barArr;
		String firstAnalyze[] = line.split("\\},");

		Arrays.asList(firstAnalyze).forEach(value -> {
			String[] secondAnalyze = value.replaceAll("\\{", "").replaceAll("\\}", "").split(",");
			int x = Integer.parseInt(secondAnalyze[0]);
			int y = Integer.parseInt(secondAnalyze[1]);
			barList.add(new Bar(x, y));
		});

		barArr = barList.toArray(new Bar[barList.size()]);
		Arrays.sort(barArr);

		return barArr;
	}

	public void overlabBar(Bar[] bar) {
		int a = 0, b = 1;
		boolean check = false;

		while (a < bar.length) {
			int historyX;
			int historyY;

			while (b < bar.length) {
				if (check)
					break;

				if (bar[a].getY() < bar[b].getX()) {
					System.out.println("{" + bar[a].getX() + "," + bar[a].getY() + "}");
					break;
				} else {
					historyX = bar[a].getX();
					historyY = bar[b].getY();
					for (int c = b + 1; c < bar.length - 1; c++) {
						if (historyY < bar[c].getX()) {
							System.out.println("{" + historyX + "," + historyY + "}");
							a = c;
							b = c + 1;
							check = true;
							break;
						} else {
							historyY = bar[c].getY();
						}
					}

				}
			}
			a++;
			b = a + 1;
			check = false;
			if (a == bar.length) {
				System.out.println("{" + bar[a - 1].getX() + "," + bar[a - 1].getY() + "}");
			}
		}
	}

	public void overlabBarV2(Bar[] bar, int x, int y, int index) {

		while (index < bar.length) {
			Bar b = bar[index];
			if (b.getX() >= x && y >= b.getX() && index + 1 != bar.length) {
				y = b.getY();

			} else {
				System.out.println("{" + x + "," + y + "}");

				if (index + 1 == bar.length) {
					System.out.println("{" + b.getX() + "," + b.getY() + "}");
				} else {
					x = b.getX();
					y = b.getY();
				}
			}
			index++;
		}
	}

}

class Bar implements Comparable<Bar> {

	private Integer x, y;

	public Bar(Integer _x, Integer _y) {
		this.x = _x;
		this.y = _y;
	}

	public Integer getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int compareTo(Bar o) {
		// TODO Auto-generated method stub
		if (this.getX().compareTo(o.getX()) == 0) {
			return this.getY().compareTo(o.getY());
		}

		return this.getX().compareTo(o.getX());
	}

}