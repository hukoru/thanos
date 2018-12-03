package com.thanos.api.common.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileExtFilter {

    private static String filesExt = "jpg,jpeg,png";

    /**
     * 파일 확장자에 들어가 있는 파일만 업로드 가능하도록 필터링
     * @param file
     * @return
     */
    public static boolean whiteListImgExt(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        String[] WHITE_EXTENSION = getFilesExt();

        for(String whiteExt : WHITE_EXTENSION) {
            if(fileExt.equalsIgnoreCase(whiteExt)) {
                return true;
            }
        }

        return false;
    }

    public static String[] getFilesExt() {
        return filesExt.split(",");
    }

    public static String getFileExtension(MultipartFile multipartFile){
        String fileName = multipartFile.getOriginalFilename();
        String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        if( "".equals(fileExt) ){
            fileName = multipartFile.getName();
            fileExt = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        }

        return fileExt;
    }
}
