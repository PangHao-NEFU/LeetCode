package Work.用于检测谁没交青年大学习;

import java.io.File;

public class whoIsEmpty implements folderAdd {
    public static void main(String[] args) {
        File folder = new File(originAdd);  //模板地址不能改
        String[] folderNameList = folder.list();
        File file = new File(targetAdd);
        String[] studentList = file.list();
        int totalNum=60;
        assert folderNameList != null;
        for (String string1 : folderNameList) {
            int flag=0;
            assert studentList != null;
            for (String string2 : studentList) {
                if (string2.contains(string1)) {
                    flag=1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println(string1);
            }
        }

    }
}
