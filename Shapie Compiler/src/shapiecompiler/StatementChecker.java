package shapiecompiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StatementChecker {

	static Pattern actionReg = Pattern
			.compile("(Put|Color|Place|Resize|Change)");
	static Pattern numReg = Pattern.compile("(a|\\d)");
	static Pattern shapeReg = Pattern.compile("(circle|square|triangle)");
	static Pattern pluralReg = Pattern.compile("(circles|squares|triangles)");
	static Pattern colorReg = Pattern
			.compile("(red|blue|yellow|pink|green|black)");
	static Pattern sizeReg = Pattern.compile("(small|big)");
	static Pattern posReg = Pattern.compile("(\\(-?\\d{1,10},-?\\d{1,10})\\)");
	static Pattern variableReg = Pattern.compile("\"([^\"]*)\"");
	static Pattern textReg = Pattern.compile("(\"([^\"]*)\")");
	static Pattern[] cases;
	static int pats = 20;

	public static void check(String s) {
		cases = new Pattern[pats];
		cases[0] = Pattern.compile("Put a " + sizeReg + " " + colorReg + " "
				+ shapeReg); // ok
		cases[1] = Pattern.compile("Put a " + sizeReg + " " + colorReg + " "
				+ shapeReg + " in " + posReg); // ok
		cases[2] = Pattern.compile("Put a " + sizeReg + " " + colorReg + " "
				+ shapeReg + " in " + posReg + " named " + variableReg); // ok
		cases[3] = Pattern.compile("Put a " + sizeReg + " " + colorReg + " "
				+ shapeReg + " named " + variableReg);// ok
		cases[4] = Pattern.compile("Put a " + colorReg + " " + shapeReg);// ok
		cases[5] = Pattern.compile("Put a " + colorReg + " " + shapeReg
				+ " in " + posReg);// ok
		cases[6] = Pattern.compile("Put a " + colorReg + " " + shapeReg
				+ " named " + variableReg);
		cases[7] = Pattern.compile("Put a " + shapeReg);
		cases[8] = Pattern.compile("Put a " + sizeReg + " " + shapeReg);// ok
		cases[9] = Pattern.compile("Put a " + sizeReg + " " + shapeReg + " in "
				+ posReg);// ok
		cases[10] = Pattern.compile("Put a " + sizeReg + " " + shapeReg
				+ " named " + variableReg);
		cases[11] = Pattern.compile("Put " + numReg + " " + sizeReg + " "
				+ colorReg + " " + pluralReg + " everywhere"); // ok
		cases[12] = Pattern.compile("Put " + numReg + " " + colorReg + " "
				+ pluralReg + " everywhere"); // ok
		cases[13] = Pattern.compile("Put " + numReg + " " + sizeReg + " "
				+ pluralReg + " everywhere"); // ok
		cases[14] = Pattern.compile("Put a " + sizeReg + " " + colorReg + " "
				+ textReg + " named " + variableReg);// ok
		cases[15] = Pattern.compile("Put a " + sizeReg + " " + colorReg + " "
				+ textReg + " named " + variableReg + " in " + posReg);
		cases[16] = Pattern.compile("Change background to " + colorReg);
		cases[17] = Pattern.compile("Place " + variableReg + " in " + posReg);
		cases[18] = Pattern.compile("Resize " + variableReg + " to " + sizeReg);
		cases[19] = Pattern.compile("Color " + variableReg + " to " + colorReg);
		int matched = matches(s);
		System.out.println(matched);

		Pattern words = Pattern.compile("\\w+");

		Matcher m = words.matcher(s);
		int t = 0, q = 0;
		String action = null, num = null, size = "small", color = "black", plural = null, shape = null, pos = null, text = null, var = null;
		if (matched >= 0) {
			while (m.find()) {
				System.out.println(m.group());
				if (actionReg.matcher(m.group()).matches()) {
					action = m.group();
				} else if (numReg.matcher(m.group()).matches()) {
					if (num == null)
						num = m.group();
				} else if (sizeReg.matcher(m.group()).matches()) {
					size = m.group();
				} else if (colorReg.matcher(m.group()).matches()) {
					color = m.group();
				} else if (pluralReg.matcher(m.group()).matches()) {
					plural = m.group();
				} else if (shapeReg.matcher(m.group()).matches()) {
					shape = m.group();
				} else if (m.group().matches("everywhere")) {
					pos = m.group();
				}
			}
			m = textReg.matcher(s);
			while (m.find()) {
				q++;
			}
			m = textReg.matcher(s);
			while (m.find()) {
				if (q == 1) {
					var = m.group();
					System.out.println(var);
				} else if (t == 0) {
					text = m.group();
					t++;
					q--;
				}
			}
			m = posReg.matcher(s);
			while (m.find())
				pos = m.group();
		}
			System.out.println("action" + action);
			System.out.println("num" + num);
			System.out.println("size" + size);
			System.out.println("color" + color);
			System.out.println("plural" + plural);
			System.out.println("shape" + shape);
			System.out.println("text" + text);
			System.out.println("var" + var);
			System.out.println("pos" + pos);
			Put p = new Put();
			Place pl = new Place();
			Change c = new Change();
			NColor nc = new NColor();
			Resize rs = new Resize();
			// String num, size, color, shape, position, variable, plural, text;

			// INITIALIZE VARIABLES ABOVE
			if (action.matches("Put")) {
				if (matched >= 0 && matched <= 10) {
					p.putShape(size, color, shape, pos, var);
				} else if (matched >= 11 && matched <= 13) {
					p.putShapes(num, size, color, plural, pos, var);
				} else if (matched >= 14 && matched <= 15) {
					p.putText(size, color, text, var, pos);
				}
			} else if (action.matches("Place")) {
				pl.Place(var, pos);
			} else if (action.matches("Color")) {
				nc.NColor(var, color);
			} else if (action.matches("Resize")) {
				rs.Resize(var, size);
			} else if (action.matches("Change")) {
				Matcher n = words.matcher(s);
				while (n.find()) {
					n.group();
					if (colorReg.matcher(n.group()).matches()) {
						System.out.println("color");
						color = n.group();
					}
				}
				c.changeBG(color);
				System.out.println("Change background");
			}
		
	}

	public static int matches(String s) {
		for (int i = 0; i < pats; i++) {
			if (cases[i] != null && cases[i].matcher(s).matches()) {
				return i;
			}
		}
		return -1;
	}

}
