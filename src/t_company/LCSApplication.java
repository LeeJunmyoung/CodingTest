package t_company;


//LCS알고리즘에서 연속되는 공통된 글자에서 가장 긴거 찾기
public class LCSApplication {
	

	public static void main(String args[]) {
		String first = "penpineapple";
		String second = "applepen";
		System.out.println(LCS(first, second));
		System.out.println(improveLCS(first, second));
	}

	static String LCS(String first, String second) { //제출한거
		int longestCommon = 0;
		int compareValue = 0;
		String commonstring = null;

		for (int i = 0; i < first.length(); i++) {

			for (int j = 0; j < second.length(); j++) {

				if (first.charAt(i) == second.charAt(j)) {

					int minoftwo = Math.min(first.length(), second.length());
					String common = "";

					for (int k = 0; k < minoftwo; k++) {

						try {
							if (first.charAt(i + k) == second.charAt(j + k)) {
								common = common.concat(String.valueOf(first.charAt(i + k)));
								longestCommon++;
							}
						} catch (StringIndexOutOfBoundsException e) {
							
						}

					}
					if (longestCommon > compareValue) {
						compareValue = longestCommon;
						commonstring = common;
					}
					longestCommon = 0;
				}

			}

		}
		return commonstring;
	}

	
	static String improveLCS(String first, String second) { //제출한거
		int longestCommon = 0;
		int compareValue = 0;
		String commonstring = null;

		for (int i = 0; i < first.length(); i++) {

			for (int j = 0; j < second.length(); j++) {

				if (first.charAt(i) == second.charAt(j)) {

					int minoftwo = Math.min(first.length(), second.length());
					String common = "";

					for (int k = 0; k < minoftwo; k++) {
						if(i+k>=first.length()||j+k>=second.length())
							break;
						
						if (first.charAt(i + k) == second.charAt(j + k)) {
							common = common.concat(String.valueOf(first.charAt(i + k)));
							longestCommon++;
						}
						

					}
					if (longestCommon > compareValue) {
						compareValue = longestCommon;
						commonstring = common;
					}
					longestCommon = 0;
				}

			}

		}
		return commonstring;
	}
	
}

