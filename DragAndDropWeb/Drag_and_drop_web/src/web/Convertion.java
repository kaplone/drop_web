package web;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class Convertion {
	
	private static BufferedReader getOutput(Process p) {
        return new BufferedReader(new InputStreamReader(p.getInputStream()));
    }

    private static BufferedReader getError(Process p) {
        return new BufferedReader(new InputStreamReader(p.getErrorStream()));
    }
	
	static void convertir(Path path){

		String commande2 = "C:\\drop_web\\mencoder.exe \"%s\" -ovc x264 -vf scale=768:432 -sws 9 -x264encopts nocabac:level_idc=30:bframes=0:bitrate=2000:threads=auto:turbo=1:global_header:threads=auto:subq=5:frameref=6:partitions=all:trellis=1:chroma_me:me=umh -oac faac -faacopts mpeg=4:object=2:raw:br=192 -of lavf -lavfopts format=mp4 -o \"%s\"";
		String commande3 = String.format(commande2, path, path.getParent().resolve(path.getFileName().toString().split(".mp")[0] + "_version_web_temp.mp4" ));

		//System.out.println(commande3);
		
        Process p = null;
		
		try {
			p = Runtime.getRuntime().exec(commande3);
			BufferedReader output = getOutput(p);
            BufferedReader error = getError(p);
            String ligne = "";

            while ((ligne = output.readLine()) != null) {
                System.out.println("- " + ligne);
            }
            
            while ((ligne = error.readLine()) != null) {
                System.out.println("+ " + ligne);
            }
            
			p.waitFor();
		} catch (IOException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		faststart(path.getParent().resolve(path.getFileName().toString().split(".mp")[0] + "_version_web_temp.mp4").toString(),
				  path.getParent().resolve(path.getFileName().toString().split(".mp")[0] + "_version_web.mp4").toString());
		
		String commande2_hd = "C:\\drop_web\\mencoder.exe \"%s\" -ovc x264 -vf scale=1280:720 -sws 9 -x264encopts nocabac:level_idc=30:bframes=0:bitrate=6000:threads=auto:turbo=1:global_header:threads=auto:subq=5:frameref=6:partitions=all:trellis=1:chroma_me:me=umh -oac faac -faacopts mpeg=4:object=2:raw:br=384 -of lavf -lavfopts format=mp4 -o \"%s\"";
		String commande3_hd = String.format(commande2_hd, path, path.getParent().resolve(path.getFileName().toString().split(".mp")[0] + "_version_web_hd_temp.mp4" ));

		//System.out.println(commande3);
		
        Process p_hd = null;
		
		try {
			p_hd = Runtime.getRuntime().exec(commande3_hd);
			BufferedReader output_hd = getOutput(p_hd);
            BufferedReader error_hd = getError(p_hd);
            String ligne_hd = "";

            while ((ligne_hd = output_hd.readLine()) != null) {
                System.out.println("- " + ligne_hd);
            }
            
            while ((ligne_hd = error_hd.readLine()) != null) {
                System.out.println("+ " + ligne_hd);
            }
            
			p_hd.waitFor();
		} catch (IOException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		faststart(path.getParent().resolve(path.getFileName().toString().split(".mp")[0] + "_version_web_hd_temp.mp4").toString(),
				  path.getParent().resolve(path.getFileName().toString().split(".mp")[0] + "_version_web_hd.mp4").toString());
		
	}
	
	static void faststart(String pathIn, String pathOut) {
		
		String commande4 = "C:\\drop_web\\qt-faststart.exe \"%s\" \"%s\"";
		String commande5 = String.format(commande4, pathIn, pathOut);
		
		//System.out.println(commande5);
		
        Process p = null;
		
		try {
			p = Runtime.getRuntime().exec(commande5);
			BufferedReader output = getOutput(p);
            BufferedReader error = getError(p);
            String ligne = "";

            while ((ligne = output.readLine()) != null) {
                System.out.println("- " + ligne);
            }
            
            while ((ligne = error.readLine()) != null) {
                System.out.println("+ " + ligne);
            }
            
			p.waitFor();
		} catch (IOException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		File temp = new File(pathIn);
		temp.delete();
		
	}


}
