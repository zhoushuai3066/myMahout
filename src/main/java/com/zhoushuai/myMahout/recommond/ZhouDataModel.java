package com.zhoushuai.myMahout.recommond;

import java.util.Collection;

import org.apache.mahout.cf.taste.common.Refreshable;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.FastIDSet;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.PreferenceArray;

public class ZhouDataModel implements DataModel {

	public void refresh(Collection<Refreshable> alreadyRefreshed) {
		// TODO Auto-generated method stub

	}

	public LongPrimitiveIterator getUserIDs() throws TasteException {
		// TODO Auto-generated method stub
		return null;
	}

	public PreferenceArray getPreferencesFromUser(long userID)
			throws TasteException {
		// TODO Auto-generated method stub
		return null;
	}

	public FastIDSet getItemIDsFromUser(long userID) throws TasteException {
		// TODO Auto-generated method stub
		return null;
	}

	public LongPrimitiveIterator getItemIDs() throws TasteException {
		// TODO Auto-generated method stub
		return null;
	}

	public PreferenceArray getPreferencesForItem(long itemID)
			throws TasteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Float getPreferenceValue(long userID, long itemID)
			throws TasteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getPreferenceTime(long userID, long itemID)
			throws TasteException {
		// TODO Auto-generated method stub
		return null;
	}

	public int getNumItems() throws TasteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getNumUsers() throws TasteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getNumUsersWithPreferenceFor(long itemID) throws TasteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getNumUsersWithPreferenceFor(long itemID1, long itemID2)
			throws TasteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setPreference(long userID, long itemID, float value)
			throws TasteException {
		// TODO Auto-generated method stub

	}

	public void removePreference(long userID, long itemID)
			throws TasteException {
		// TODO Auto-generated method stub

	}

	public boolean hasPreferenceValues() {
		// TODO Auto-generated method stub
		return false;
	}

	public float getMaxPreference() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float getMinPreference() {
		// TODO Auto-generated method stub
		return 0;
	}

}
