package codegenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CodeGenerator {

	public static void main(String[] args) {
		// create object of Random class
		final long startTime = System.nanoTime();
		List<String> codes = new ArrayList<String>();
		List<String> duplicates = new ArrayList<String>();
		int codesNumbers = 10000;
		for (int i = 1; i <= codesNumbers; i++) {
			String code = generateCode();
			outerloop: for (;;) {
				if (codes.contains(code)) {
					code = generateCode();
					System.out.println("Duplication found");
					duplicates.add(code);
					continue;
				} else {
					codes.add(code);
					System.out.println("Code number " + i + " added successfully.");
					break outerloop;
				}
			}
		}
		final long duration = System.nanoTime() - startTime;
		final long seconds = duration / 1_000_000_000;
		System.out.println("----------------------------------");

		System.out.println("Codese generated is :");

		for (String code : codes) {
			System.out.println("code " + code);
		}

		if (duplicates.size() > 0)
			System.out.println("Douplicated codes :");
		for (String code : duplicates) {
			System.out.println("duplicated code " + code);
		}
		System.out.println("----------------------------------");

		System.out.println("Generated Codes :" + codes.size());
		System.out.println("----------------------------------");

		System.out.println("Douplicated Codes :" + duplicates.size());
		System.out.println("Codese douplicated is :" + duplicates.size());
		System.out.println("----------------------------------");

		System.out.println("Time generation :" + seconds +" seconds");
		System.out.println("Time generation :" + duration +" nanoseconds");
	}

	private static String generateCode() {
		Random obj = new Random();
		int rand_num = obj.nextInt(0xffffff + 1);
//		int rand_num2 = obj.nextInt(0xff + 1);
		// format it as hexadecimal string and print
		String colorCode = String.format("#%06x", rand_num);
//		String code = String.format("%05x", rand_num);
//		System.out.println(colorCode);
//		System.out.println(colorCode2)
		return colorCode;
	}
}
