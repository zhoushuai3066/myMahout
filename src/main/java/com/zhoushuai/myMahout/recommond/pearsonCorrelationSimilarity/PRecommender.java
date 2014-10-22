package com.zhoushuai.myMahout.recommond.pearsonCorrelationSimilarity;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class PRecommender {
	
	private String path = System.getProperty("user.dir");
	private String fieldpath = path+"\\data\\pearsonCorrelationSimilarity.txt";
	
	public void recommender() throws IOException, TasteException{
		
	   File f = new File(fieldpath);
	   
	   DataModel dataModel = new FileDataModel(f);  //创建datamodel 。mahout推荐需要的数据源
	   
       UserSimilarity userSimilarity = new PearsonCorrelationSimilarity(dataModel); //采用基于皮尔逊相关系数的相似度算法计算数据的相似度
       
       UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, userSimilarity, dataModel); //表示取2个相似度最大的用户做参考
       
       Recommender recommender = new GenericUserBasedRecommender(dataModel, neighborhood, userSimilarity);  //创建推userbase的推荐程序
       
       List<RecommendedItem> recommendations = recommender.recommend(1, 2);     //表示为用户1推荐2个物品
       
       //遍历推荐的数据
       for(RecommendedItem recommendedItem:recommendations){
       	System.out.println(recommendedItem);
       }
	}

}
