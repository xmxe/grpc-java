package test;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import runtime.RuntimeExec;
import util.PropertiesUtil;

public class Test {

	public static void main(String[] args) {
		try {
			/*String pythonFile = PropertiesUtil.getKey("pythonFile", "util.properties");
			RuntimeExec.execPython(pythonFile);
			String pythonFile = PropertiesUtil.getKey("pythonFile", "util.properties");
			
			String pythonPath = PropertiesUtil.getKey("pythonPath", "util.properties");
			RuntimeExec.execPython(pythonFile, pythonPath);*/
			String[] ar = new String[]{"cmd","/c","python C:\\Users\\admin\\Desktop\\helloworld.py","1","2"};
			//String[] envp = new String[]{"path=C:\\Program Files\\Python37"};
			Process p = Runtime.getRuntime().exec("python -V");
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
			br.close();
			int a = p.waitFor();
			System.err.println(a);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
