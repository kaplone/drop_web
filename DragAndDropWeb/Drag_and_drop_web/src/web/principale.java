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
		
		if (path.toFile().isDirectory()){
			
			System.out.println("parcours du répertoire : " + path.toString());
			
			for(File f : path.toFile().listFiles()){
				
				if (f.isFile() && f.toString().toLowerCase().endsWith("mp4")){
					Convertion.convertir(f.toPath());
				}
				else{
					System.out.println("\n\n############################################\n#\n#");
					System.out.println("# " + f + " : n'est pas un fichier vidéo valide ...");
					System.out.println("#\n#\n############################################\n\n");
				}
				
				
			}
			
		}
		else{
			Convertion.convertir(path);
		}
		
		

	}

}
