import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class dplx {

	public static void main(String[] args) {

		Stack<Double> stack = new Stack<Double>();
		HashMap<String, Double> varMap = new HashMap<String, Double>();

		try {
			String[] codeArray = readLines(args[0]);
			String[] tCode;
			int PC = 0; // Instruction Pointer

			while (PC < codeArray.length) {

				// Tokenize byte code.
				tCode = codeArray[PC].split(" ");
				
				if (tCode[0].contentEquals("READ")) {
					stack.push(getInput());
				}
				if (tCode[0].contentEquals("PRINT")) {
					System.out.println(stack.pop());
				}
				if (tCode[0].contentEquals("STOR")) {
					varMap.put(tCode[1], stack.pop());
				}
				if (tCode[0].contentEquals("TGT")) {
					double var1 = stack.pop();
					double var2 = stack.pop();

					if (var2 > var1) {
						stack.push(1.0);
					} else
						stack.push(0.0);
				}
				if (tCode[0].contentEquals("TLT")) {
					double var1 = stack.pop();
					double var2 = stack.pop();

					if (var2 < var1) {
						stack.push(1.0);
					} else
						stack.push(0.0);
				}
				if (tCode[0].contentEquals("TEQ")) {
					double var1 = stack.pop();
					double var2 = stack.pop();

					if (var2==var1) {
						stack.push(1.0);
					} else
						stack.push(0.0);
				}
				if (tCode[0].contentEquals("ADD")) {
					double var1 = stack.pop();
					double var2 = stack.pop();

					stack.push(var2 + var1);
				}
				if (tCode[0].contentEquals("SUB")) {
					double var1 = stack.pop();
					double var2 = stack.pop();

					stack.push(var2 - var1);
				}
				if (tCode[0].contentEquals("MUL")) {
					double var1 = stack.pop();
					double var2 = stack.pop();

					stack.push(var2 * var1);
				}
				if (tCode[0].contentEquals("DIV")) {
					double var1 = stack.pop();
					double var2 = stack.pop();

					stack.push(var2 / var1);
				}
				if (tCode[0].contentEquals("JMP")) {
					PC = Integer.parseInt(tCode[1]);
					continue;
				}
				if (tCode[0].contentEquals("JIF") && stack.pop() == 0.0) {
					PC = Integer.parseInt(tCode[1]);
					continue;
				}
				if (tCode[0].contentEquals("END")) {
					PC = codeArray.length;
					continue;
				}
				if (tCode[0].contentEquals("PUSH")) {
					//Are we pushing something from the hash table or a literal?
					if (tCode[1].matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")) {
						stack.push(Double.parseDouble(tCode[1]));
					} else {
						stack.push(varMap.get(tCode[1]));
					}
				}
				// Increment Program Counter
				PC++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String[] readLines(String filename) throws IOException {
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String> lines = new ArrayList<String>();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			lines.add(line);
		}
		bufferedReader.close();
		return lines.toArray(new String[lines.size()]);
	}

	public static double getInput() throws IOException {
		double doubleInput = 0;
		String input = "";

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.print("#>");
		try {
			input = reader.readLine();
		}
		catch (IOException ioe) {
			System.out.println("An unexpected error occured.");
		}
		try {
			doubleInput = Double.parseDouble(input);
		} catch (NumberFormatException notADouble) {
			System.out.println("Input must be a Double");
		}
		return doubleInput;
	}
}
