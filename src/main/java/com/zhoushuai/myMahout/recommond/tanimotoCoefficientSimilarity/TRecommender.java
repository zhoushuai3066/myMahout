package com.zhoushuai.myMahout.recommond.tanimotoCoefficientSimilarity;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class TRecommender {
	
	private String path = System.getProperty("user.dir");
	private String fieldpath = path+"\\data\\tanimotoCoefficientSimilarityData.txt";
	
	public void recommender() throws IOException, TasteException{
	   File f = new File(fieldpath);
	   DataModel dataModel = new FileDataModel(f);//创建datamodel 。mahout推荐需要的数据源
	   
	   dataModel.getUserIDs();
	   
       UserSimilarity userSimilarity = new TanimotoCoefficientSimilarity(dataModel);  //表示采用基于谷本系数相似度算法计算用户的相似度
       
       UserNeighborhood neighborhood = new NearestNUserNeighborhood(12,0.5, userSimilarity, dataModel);  //表示取2个相似度最大的用户做参考
       long[] arg = neighborhood.getUserNeighborhood(1);
       for(int i=0;i<arg.length;i++){
    	   System.out.println("用户"+1+"和用户"+arg[i]+"的相似性是:"+userSimilarity.userSimilarity(1, arg[i]));
       }
//       Recommender recommender = new GenericUserBasedRecommender(dataModel, neighborhood, userSimilarity); //创建推userbase的推荐程序
       
       
//       List<RecommendedItem> recommendations = recommender.recommend(1, 2); //表示为用户1推荐2个物品
       
     //遍历推荐的数据 输出计算结果
//       for(RecommendedItem recommendedItem:recommendations){
//       	System.out.println(recommendedItem);
//       }
	}
	
	
	public static void main( String[] args ) throws IOException, TasteException 
    {
		TRecommender tRecommender = new TRecommender();
		tRecommender.recommender();
    }

}
