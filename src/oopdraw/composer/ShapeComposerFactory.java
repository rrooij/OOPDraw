package oopdraw.composer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ShapeComposerFactory {
	private HashMap<String, ShapeComposer> composers;
	private String[] names;
	
	public ShapeComposerFactory() {
		composers = new HashMap<String, ShapeComposer>();
		addNames();
	}
	
	private void addNames() {
		names = new String[3];
		String trimString = "Composer";
		String rectClassName = RectComposer.class.getSimpleName().replaceAll(trimString, "");
		String ovalClassName = OvalComposer.class.getSimpleName().replaceAll(trimString, "");
		String lineClassName = LineComposer.class.getSimpleName().replaceAll(trimString, "");
		names[0] = rectClassName.toLowerCase();
		names[1] = ovalClassName.toLowerCase();
		names[2] = lineClassName.toLowerCase();
	}
	
	public String[] listComposerNames() {
		return names;
	}
	
	public ShapeComposer createComposer(String name) throws Exception {
		if (composers.containsKey(name)) {
			return composers.get(name);
		}
		
		ShapeComposer currentComposer;
		switch(name) {
		case "rect":
			currentComposer = new RectComposer();
			break;
		case "line":
			currentComposer = new LineComposer();
			break;
		case "oval":
			currentComposer = new OvalComposer();
			break;
		default:
			throw new Exception("Oeps");
		}
		composers.put(name, currentComposer);
		return currentComposer;
	}
}
