package com.zyh;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

/**
 * world count with spark and java8
 * Created by zhaoyh on 2017/8/18.
 */
public class WordCount {
    public static void main(String[] args) {
        SparkConf sparkConf=new SparkConf().setAppName("wordCount").setMaster("local[2]");
        JavaSparkContext sc=new JavaSparkContext(sparkConf);
        JavaRDD<String> textFile= sc.textFile("D:/README.md");
        //呵呵
        JavaRDD<String> words= textFile.flatMap(line-> Arrays.asList(line.split(" ")).iterator());
        JavaRDD<String> lowerwords= words.map(String::toLowerCase);
        JavaPairRDD<String,Integer> wordPair= lowerwords.mapToPair(word->new Tuple2<>(word,1));
        JavaPairRDD<String,Integer> count= wordPair.reduceByKey((a,b)->a+b);
        count.sortByKey();
        List<Tuple2<String,Integer>> clist= count.collect();
        for (Tuple2  c:clist){
            System.out.println("key:"+c._1()+"==============value:"+c._2());
        }
        count.saveAsTextFile("D:/result");//这里接受的是一个文件夹
        sc.close();


    }

}
