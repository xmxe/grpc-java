package runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class RuntimeExec {
	

	/**
	 * 在单独的进程中执行指定命令和变量
	 * @param args 参数
	 * @param path 路径
	 * @throws Exception 
	 */
	public static void execPython(String args,String path) throws Exception{
		if(args.contains(" ")){
			args = args.replaceAll("\\s+", " ");	//修正多余空格保留1个
		}
		String[] arg = args.split(" ");
		String[] cmdarray = new String[arg.length+1];
		cmdarray[0] = path+"\\python.exe";
		for(int i =0;i < arg.length;i++){
			cmdarray[1+i] = arg[i];
		}
		
		//String[] cmdarray = new String[]{"C:\\Program Files\\Python37\\python.exe",args};
		Process process = Runtime.getRuntime().exec(cmdarray);
		printMessage(process.getInputStream());
		printMessage(process.getErrorStream());
		int value = process.waitFor();
		if(value == 0){
			System.out.println("程序正常执行");
		}else{
			System.err.println("程序执行出现异常");
		}
	}
	
	
	/**
	 * 在指定环境的独立进程中指定命令和变量
	 * @param arg0
	 * @throws Exception
	 */
	public static void execPython1(String args,String path) throws Exception{
		String[] envp = new String[]{"path="+path};
		if(args.contains(" ")){
			args = args.replaceAll("\\s+", " ");	//修正多余空格保留1个			
		}
		String[] arg = args.split(" ");
		String[] cmdarray = new String[arg.length+2];
		cmdarray[0] = "cmd";cmdarray[1]="/c";
		for(int i =0;i < arg.length;i++){
			if(i ==0 ) arg[i] = "python "+arg[i];
			cmdarray[2+i] = arg[i];
		}		
		//String[] cmdarray = new String[]{"cmd","/c","python C:\\Users\\admin\\Desktop\\helloworld.py","1","2"};
		Process process = Runtime.getRuntime().exec(cmdarray,envp);
		printMessage(process.getInputStream());
		printMessage(process.getErrorStream());
		int value = process.waitFor();
		if(value == 0){
			System.out.println("程序正常执行");
		}else{
			System.err.println("程序执行出现异常");
		}
		
	}	
	
	
	
	/**
	 * 处理缓冲区信息，避免阻塞
	 * @param input
	 */
	private static void printMessage(final InputStream input){
		new Thread(new Runnable() {			
			@Override
			public void run() {
				Reader reader = new InputStreamReader(input);
				BufferedReader br = new BufferedReader(reader);
				String line = "";
				try {
					while((line = br.readLine()) != null){
						System.out.println(line);
					}
				} catch (IOException e) {				
					e.printStackTrace();
				}finally{
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
	}
}
