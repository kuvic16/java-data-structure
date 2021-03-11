import model.UploadFileResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Shaiful Islam Palash | kuvic16@gmail.com
 * @CreatedAt: 3/11/2021
 */
public class Stream {
    public static void main(String[] args) {
        List<UploadFileResponse> list = new ArrayList<>();
        list.add(new UploadFileResponse("1"));
        list.add(new UploadFileResponse("2"));
        list.add(new UploadFileResponse("3"));

        Object[] fileNames = list.stream()
                .map(file -> file.getFileName())
                .collect(Collectors.toList()).toArray();

        for(Object fileName : fileNames) {
            System.out.println(fileName.toString());
        }


        String[] fileNames1 = list.stream()
                .map(file -> file.getFileName())
                .collect(Collectors.toList()).toArray(new String[list.size()]);

        for(String fileName : fileNames1) {
            System.out.println(fileName);
        }
    }
}
