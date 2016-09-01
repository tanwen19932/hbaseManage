import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;

import org.apache.hadoop.mapreduce.Mapper;

import org.apache.hadoop.mapreduce.Reducer;

import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


import java.io.IOException;


/**

 * @author wei.feng@corp.elong.com

 * @since 15-3-27

 */

public class Dedup {


    public static class Map extends Mapper {


        private static Text line = new Text();

        protected void map(Object key, Text value, Context context)

                throws IOException, InterruptedException {

            //super.map(key, value, context);

            line = value;

            context.write(line, new Text(""));

        }

    }


    public static class Reduce extends Reducer {

        protected void reduce(Text key, Iterable values, Context context)

                throws IOException, InterruptedException {

            context.write(key, new Text(""));

        }

    }


    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();

        conf.set("mapred.job.tracker", "192.168.59.20:9001");

        Job job = Job.getInstance(conf, "Data Deduplication");

        job.setJarByClass(Dedup.class);

        job.setMapperClass(Map.class);

        job.setCombinerClass(Reduce.class);

        job.setReducerClass(Reduce.class);


        job.setOutputKeyClass(Text.class);

        job.setOutputValueClass(Text.class);


        FileInputFormat.addInputPath(job,

                new Path("hdfs://hadoop1:9000/dedup_in"));

        FileOutputFormat.setOutputPath(job,

                new Path("hdfs://hadoop1:9000/dedup_out"));


        System.exit(job.waitForCompletion(true) ? 0 : 1);

    }

}