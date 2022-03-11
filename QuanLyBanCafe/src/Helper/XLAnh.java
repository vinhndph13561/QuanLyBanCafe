/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.awt.Image;
import java.io.File;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author vinhn
 */
public class XLAnh {
    public static Image getIcon(){
        URL url = XLAnh.class.getResource("/Icon/fpt.png");
        return new ImageIcon(url).getImage();
    }
    public static boolean save(File src){
        File dst = new File("src\\Icon",src.getName());
        if (!dst.getParentFile().exists()){
            dst.getParentFile().mkdirs(); // tao thu muc
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(src.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static ImageIcon read(String fileName){
        File path = new File("src\\Icon", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
}
