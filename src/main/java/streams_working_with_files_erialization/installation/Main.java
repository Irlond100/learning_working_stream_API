package streams_working_with_files_erialization.installation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		
		File scr = new File("D://Games/scr");
		
		StringBuilder sb = new StringBuilder();
		
		if (scr.mkdir()) {
			sb.append("Каталог успешно создан /scr\n");
			
			File main = new File("D://Games/scr/main");
			
			if (main.mkdir()) {
				sb.append("Каталог успешно создан /main\n");
				
				File newFile1 = new File("D://Games/scr/main//Main.java");
				File newFile2 = new File("D://Games/scr/main//Utils.java");
				try {
					if (newFile1.createNewFile()) {
						sb.append("Файл создан Main.java\n");
					} else {
						sb.append("Файл не создан Main.java\n");
					}
					if (newFile2.createNewFile()) {
						sb.append("Файл создан Utils.java\n");
					} else {
						sb.append("Файл не создан Utils.java\n");
					}
				} catch (IOException ex) {
					
					System.out.println(ex.getMessage());
				}
				
			} else {
				sb.append("Каталог не создан /main\n");
			}
			
			File test = new File("D://Games/scr/test");
			
			if (test.mkdir()) {
				sb.append("Каталог успешно создан /test\n");
			} else {
				sb.append("Каталог не создан /test\n");
			}
		} else {
			sb.append("Каталог не создан /scr\n");
		}
		
		File res = new File("D://Games/res");
		
		if (res.mkdir()) {
			sb.append("Каталог успешно создан /res\n");
			
			File drawables = new File("D://Games/scr/drawables");
			
			if (drawables.mkdir()) {
				sb.append("Каталог успешно создан /drawables\n");
			} else {
				sb.append("Каталог не создан /drawables\n");
			}
			
			File vectors = new File("D://Games/scr/vectors");
			
			if (vectors.mkdir()) {
				sb.append("Каталог успешно создан /vectors\n");
			} else {
				sb.append("Каталог не создан /vectors\n");
			}
			
			File icons = new File("D://Games/scr/icons");
			
			if (icons.mkdir()) {
				sb.append("Каталог успешно создан /icons\n");
			} else {
				sb.append("Каталог не создан /icons\n");
			}
		} else {
			sb.append("Каталог не создан /res\n");
		}
		
		File saveGames = new File("D://Games/savegames");
		
		if (saveGames.mkdir()) {
			sb.append("Каталог успешно создан /savegames\n");
		} else {
			sb.append("Каталог не создан /savegames\n");
		}
		
		File temp = new File("D://Games/temp");
		
		if (temp.mkdir()) {
			sb.append("Каталог успешно создан /temp\n");
			
			File newFile3 = new File("D://Games/temp//temp.txt");
			try {
				if (newFile3.createNewFile()) {
					sb.append("Файл создан temp.txt\n");
					
					FileWriter writer = new FileWriter(newFile3);
					
					writer.write(String.valueOf(sb));
					writer.flush();
					writer.close();
				} else {
					sb.append("Файл не создан temp.txt\n");
				}
				
			} catch (IOException ex) {
				
				System.out.println(ex.getMessage());
			}
		} else {
			sb.append("Каталог не создан /temp\n");
		}
	}
	
}