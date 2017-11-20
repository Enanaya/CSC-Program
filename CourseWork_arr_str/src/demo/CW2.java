package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CW2 {

	public static void main(String[] args) {
			Scanner read_sc = null;
			try {
				// read
				read_sc = new Scanner(new FileReader(new File(
						System.getProperty("user.dir") + "/src/demo/Input_Text")));
				while (read_sc.hasNextLine()) {
					
					String str = read_sc.nextLine();
					ArrayList<String> as = new ArrayList<String>(
							Arrays.asList(str.toLowerCase().split("[ .]|, ")));
					
					// delete all numbers
					as.removeIf(n -> n.matches("[0-9]*"));
					
					// sort
					Collections.sort(as);
					
					//store in map
					Map<String, Integer> map=new TreeMap<String, Integer>();
					
					as.forEach(n->{
						if (!map.containsKey(n))
						{
							map.put(n, 1);
						}
						else {
							map.put(n,map.get(n)+1);
						}
					});
					
					map.forEach((k,v)->System.out.println(k+"\t\t\t"+v)); 
					
					// deduplicate
					HashSet<String> dis = new HashSet<>(as);
					as.clear();
					as.addAll(dis);

					// write
					File R_file = new File(System.getProperty("user.dir") + "/src/demo/Output_Text");
					if (!R_file.exists() || R_file == null) {
						R_file.createNewFile();
					}

					PrintWriter pw = new PrintWriter(new FileWriter(R_file));
					as.forEach(n -> pw.write(n + "\n"));
					pw.flush();
					pw.close();
				}
			} catch (FileNotFoundException e) {
				System.out.println("Can not find this file!");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				read_sc.close();
			}
		}
	}


