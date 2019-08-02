package test;

import runtime.RuntimeExec;
import util.PropertiesUtil;

public class Test {

	public static void main(String[] args) {
		try {
			/*			
			String pythonFile = PropertiesUtil.getKey("pythonFile", "util.properties");
			String pythonPath = PropertiesUtil.getKey("pythonPath", "util.properties");
			RuntimeExec.execPython(pythonFile);			
			RuntimeExec.execPython(pythonFile, pythonPath);*/
			String[] ar = new String[]{"cmd","/c","python C:\\Users\\admin\\Desktop\\helloworld.py","1","2"};
			RuntimeExec.execPython(ar);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
