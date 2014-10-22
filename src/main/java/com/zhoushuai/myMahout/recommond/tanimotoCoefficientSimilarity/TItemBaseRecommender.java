package com.zhoushuai.myMahout.recommond.tanimotoCoefficientSimilarity;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class TItemBaseRecommender {
	
	private String path = System.getProperty("user.dir");
	private String fieldpath = path+"\\data\\itemSimilarityData.txt";
	
	public void recommender() throws IOException, TasteException{
	   File f = new File(fieldpath);
	   DataModel dataModel = new FileDataModel(f);//创建datamodel 。mahout推荐需要的数据源
	   
       ItemSimilarity itemSimilarity = new TanimotoCoefficientSimilarity(dataModel);  //表示采用基于谷本系数相似度算法计算用户的相似度
       long[] a = itemSimilarity.allSimilarItemIDs(101);
       for(long i:a){
    	   System.out.println(i);
       }
       GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dataModel,itemSimilarity);
       
     List<RecommendedItem> recommendations = recommender.recommend(201, 2); //表示为用户1推荐2个物品
       
   //遍历推荐的数据 输出计算结果
     for(RecommendedItem recommendedItem:recommendations){
     	System.out.println(recommendedItem);
     }
       
	}
	
	  public static void main( String[] args ) throws IOException, TasteException 
	    {
		  	TItemBaseRecommender tItemBaseRecommender = new TItemBaseRecommender();
		  	tItemBaseRecommender.recommender();
	    }

}
