
package tw.utils;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author hu
 */
public class FileUtils {

    public static String getFileStr(String filePath)
            throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = bf.readLine()) != null) {
            sb.append(line).append("\n");
        }
        bf.close();
        return sb.toString();
    }

    public static void mkFolder(String fileName) {
        File f = new File(fileName);
        if (!f.exists()) {
            f.mkdir();
        }
    }

    public static File mkFile(String fileName) {
        File f = new File(fileName);
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return f;
    }

    public static void deleteDir(File dir) {
        File[] filelist = dir.listFiles();
        for (File file : filelist) {
            if (file.isFile()) {
                file.delete();
            } else {
                deleteDir(file);
            }
        }
        dir.delete();
    }

    public static void copy(File origin, File newfile)
            throws FileNotFoundException, IOException {
        if (!newfile.getParentFile().exists()) {
            newfile.getParentFile().mkdirs();
        }
        FileInputStream fis = new FileInputStream(origin);
        FileOutputStream fos = new FileOutputStream(newfile);
        byte[] buf = new byte[2048];
        int read;
        while ((read = fis.read(buf)) != -1) {
            fos.write(buf, 0, read);
        }
        fis.close();
        fos.close();
    }

    public static void writeFile(String fileName, String contentStr, String charset)
            throws FileNotFoundException, IOException {
        byte[] content = contentStr.getBytes(charset);
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(content);
        fos.close();
    }

    public static void writeFile(File file, String contentStr, String charset)
            throws FileNotFoundException, IOException {
        byte[] content = contentStr.getBytes(charset);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(content);
        fos.close();
    }

    public static void writeFileWithParent(String fileName, String contentStr, String charset)
            throws FileNotFoundException, IOException {
        File file = new File(fileName);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        byte[] content = contentStr.getBytes(charset);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(content);
        fos.close();
    }


    public static void writeFile(String fileName, byte[] content)
            throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(content);
        fos.close();
    }

    public static void writeFile(File file, byte[] content)
            throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(content);
        fos.close();
    }

    public static void writeFileWithParent(String fileName, byte[] content)
            throws FileNotFoundException, IOException {
        File file = new File(fileName);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(content);
        fos.close();
    }

    public static void writeFileWithParent(File file, byte[] content)
            throws FileNotFoundException, IOException {

        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(content);
        fos.close();
    }

    public static byte[] readFile(File file)
            throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[2048];
        int read;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((read = fis.read(buf)) != -1) {
            bos.write(buf, 0, read);
        }

        fis.close();
        return bos.toByteArray();
    }

    public static byte[] readFile(String fileName)
            throws IOException {
        File file = new File(fileName);
        return readFile(file);
    }

    public static String readFile(File file, String charset)
            throws Exception {
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[2048];
        int read;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((read = fis.read(buf)) != -1) {
            bos.write(buf, 0, read);
        }

        fis.close();
        return new String(bos.toByteArray(), charset);
    }

    public static String readFile(String fileName, String charset)
            throws Exception {
        File file = new File(fileName);
        return readFile(file, charset);
    }

    public static void fileAppendMethod1(String file, String conent) {
        BufferedWriter out = null;
        try {
            File file1 = new File(file);
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1, true)));
            out.write(conent);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 追加文件：使用FileWriter
     *
     * @param fileName
     * @param content
     */
    public synchronized static void fileAppendMethod2(String fileName, String content) {
        FileWriter writer = null;
        try {
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            writer = new FileWriter(fileName, true);
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void fileAppendStr(String fileName, String content) {
        RandomAccessFile randomFile = null;
        fileName.replaceAll("\\\\","/");
        try {
            // 打开一个随机访问文件流，按读写方式
            randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            if( fileLength> 20*1024*1024){
                randomFile.close();
                Path fromPath = Paths.get(fileName);
                Path toPath ;
                int count = 1;
                File toFile = new File(fileName+"."+count);
                while(toFile.exists()){
                    count++;
                    toFile = new File(fileName+"."+count);
                }
                toPath = Paths.get(toFile.getAbsolutePath());
                while(true){
                    try {
                        Files.move(fromPath, toPath , StandardCopyOption.ATOMIC_MOVE);
                        System.out.println("++++++++move    "+fromPath + "    TO    "+ toPath +"     成功+++++++++");
                        break;
                    }catch (Exception e){
                        continue;
                    }
                }
                randomFile =new RandomAccessFile(fileName, "rw");
                fileLength = randomFile.length();
            }

            // 将写文件指针移到文件尾。
            if (fileLength != 0) {
                randomFile.seek(fileLength - 1);
                randomFile.write(("," + content.toString() + "\r\n]").getBytes("utf-8"));
            } else {
                System.out.println("+++++++新建文件++++       "+fileName);
                randomFile.seek(0);
                randomFile.write(("[\r\n" + content.toString() + "]").getBytes("utf-8"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomFile != null) {
                try {
                    randomFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 追加文件：使用RandomAccessFile
     *
     * @param fileName 文件名
     * @param jo  追加的内容
     */
    public static void fileAppendJson(String fileName, JSONObject jo) {
        fileAppendStr(fileName,jo.toString());
    }

    public static void saveUrlToFile(String destUrl, String fileName) {
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        URL url = null;
        byte[] buf = new byte[1024];
        int size = 0;

        // 建立链接
        try {
            File file = new File(fileName.substring(0, fileName.lastIndexOf('/')));
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(fileName);
            if (file.exists())
                return;
            url = new URL(destUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            // 连接指定的资源
            httpUrl.connect();
            // 获取网络输入流
            bis = new BufferedInputStream(httpUrl.getInputStream());
            // 建立文件
            fos = new FileOutputStream(file);
            // 保存文件
            while ((size = bis.read(buf)) != -1)
                fos.write(buf, 0, size);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (httpUrl != null)
                httpUrl.disconnect();
        }
    }

}
