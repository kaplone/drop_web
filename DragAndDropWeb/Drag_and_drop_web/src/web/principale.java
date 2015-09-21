package web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class principale {
	
	public static void main(String[] args) {
		
		
		System.out.println(args[0]);
		
		//Path path = new File(args[0]).toPath();
		Path path = Paths.get(args[0]);
		
		Convertion.convertir(path);

	}

}
