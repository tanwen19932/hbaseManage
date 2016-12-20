package edu.buaa.nlp.tw.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PropertiesUtil {
    private static Logger LOG = LoggerFactory.getLogger(PropertiesUtil.class);
    public static synchronized Properties getProp(String filePath) {
        Properties properties = null;
        InputStream fis;
        try {
            fis = new FileInputStream(filePath);
        } catch (IOException e) {
            try {
                LOG.warn("Get ProFile ERROR! TRY RESOURCE!"+e);
                fis = new FileInputStream( PropertiesUtil.class.getResource("/").getPath()+"/" +filePath);
            } catch (FileNotFoundException e1) {
                LOG.warn("Get ProFile ERROR! TRY CLASSLOADER!"+e1);
                fis = PropertiesUtil.class.getClassLoader().getResourceAsStream(filePath);
            }
        }
        if (fis == null) {
            LOG.warn("Get ProFile FAIL! return an EMPTY properties");
            properties = new Properties();
            return properties;
        }
        properties = new Properties();
        try {
            properties.load(fis);            //从输入流中读取属性文件的内容
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


    public static synchronized void saveProp(Properties properties, String filePath) {
        try {

            FileOutputStream fos = new FileOutputStream(filePath);
            properties.store(fos, "???");
            fos.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static List<String> getHmDatabases(Properties properties)
            throws IOException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        List<String> databases = Collections.synchronizedList(new LinkedList<>());
        GregorianCalendar gc_yes = new GregorianCalendar();
        gc_yes.setTime(new Date());
        /*减少一天*/
        gc_yes.add(5, -1);

        System.out.println(gc_yes.getWeekYear());
        int proYear = Integer.parseInt(properties.getProperty("YEAR"));
        //		if(gc_yes.YEAR)
        //		System.out.println(sdf.format(gc_yes.getTime()));
        //		fis.close();
        //2016-1900, 5, 1
        if (proYear < gc_yes.getWeekYear()) {
            gc_yes.set(proYear, 11, 31);
        }
        Date endDate = new Date(proYear - 1900, 1 - 1, 1);
        int i = 0;

        while (Integer.parseInt(sdf.format(gc_yes.getTime())) / 1000 - Integer.parseInt(sdf.format(endDate)) / 1000 >= 0) {
            String database = "articles_" + sdf.format(gc_yes.getTime()).substring(4);
            try {
                if (!properties.get(database).toString().startsWith("done"))
                    databases.add(database);
            } catch (Exception e) {
                properties.setProperty(database, "0");
                System.out.println(database + " " + ++i);
                databases.add(database);
            }

            gc_yes.add(5, -1);
        }
        return databases;
    }

    public static void main(String[] args)
            throws IOException, ParseException {
        //		String aString = "done_20016";
        //		System.out.println(aString.startsWith("done"));
        //		Properties pro	= new Properties();
        //		pro.setProperty("YEAR", "2015");
        //		getHmDatabases(pro);
    }
}
