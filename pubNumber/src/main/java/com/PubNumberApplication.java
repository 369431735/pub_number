package com;

import com.chatwet.until.bean.RepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
@EnableJpaRepositories(repositoryBaseClass = RepositoryFactoryBean.class)
@SpringBootApplication
public class PubNumberApplication {

	public static void main(String[] args) {
		SpringApplication.run(PubNumberApplication.class, args);
	//	startPort();
	}
	public static void startPort(){
		String path = "F:\\softWare\\windows_amd64\\run.bat";
		Runtime run = Runtime.getRuntime();//返回与当前 Java 应用程序相关的运行时对象
		try {

			Process p=run.exec("cmd /c F: && cd F:\\softWare\\windows_amd64 && "+path);

			BufferedInputStream in = new BufferedInputStream(p.getInputStream());
			BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
			String lineStr;
			while ((lineStr = inBr.readLine()) != null)
				//获得命令执行后在控制台的输出信息
				System.out.println(lineStr);// 打印输出信息
			//检查命令是否执行失败。
			if (p.waitFor() != 0) {
				if (p.exitValue() == 1)//p.exitValue()==0表示正常结束，1：非正常结束
					System.err.println("命令执行失败!");
			}
			inBr.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
