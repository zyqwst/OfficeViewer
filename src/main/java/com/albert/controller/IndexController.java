/**
 * 
 */
package com.albert.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.converter.XlsConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


/** 
* @ClassName: IndexController 
* @Description: 
* @author albert
* @date 2017年9月18日 下午1:31:02 
*  
*/
@Controller
public class IndexController {
	
	
	@ResponseBody
	@RequestMapping(value="upload",method= RequestMethod.POST)
	public String upload(HttpServletRequest req,@RequestParam("file") MultipartFile file){
		try {
			String server = req.getContextPath();
//			String path = uploadFile(file.getBytes(), server, file.getOriginalFilename());
			XlsConverter.convert("/Users/albert/Documents/workspace/OfficeViewer/test.xls", "/Users/albert/Documents/workspace/OfficeViewer/test.html");
			return server+file.getOriginalFilename();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public static String  uploadFile(byte[] file, String filePath, String fileName) throws Exception { 
        File targetFile = new File(filePath);  
        if(!targetFile.exists()){    
            targetFile.mkdirs();    
        }       
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
        return targetFile.getAbsolutePath()+"/"+fileName;
    }
}
