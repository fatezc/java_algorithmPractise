package practise;
/*
* 比较两个版本号 version1 和 version2。
如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。

你可以假设版本字符串非空，并且只包含数字和 . 字符。

 . 字符不代表小数点，而是用于分隔数字序列。

例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。

你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/compare-version-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        String[] s1;
        String[] s2;
        //不包含“.”时
        if (!version1.contains(".")) {
             s1 = new String[]{version1};
        }
        else {
            //由于“.”是转义字符，所以需要加俩斜杠
             s1 = version1.split("\\.");
        }
        if (!version2.contains(".")){
             s2 = new String[]{version2};
        }
        else {
             s2 = version2.split("\\.");
        }

        int i;
        for ( i = 0; i < s1.length&&i<s2.length; i++) {
            if (Integer.parseInt(s1[i])<Integer.parseInt(s2[i]))
                return -1;
            else if (Integer.parseInt(s1[i])>Integer.parseInt(s2[i]))
                return 1;
        }
        while (i<s1.length){
            if (Integer.parseInt(s1[i])>0)
                return 1;
            ++i;
        }
        while (i<s2.length){
            if (Integer.parseInt(s2[i])>0)
                return -1;
            ++i;
        }
        return 0;
    }
}
