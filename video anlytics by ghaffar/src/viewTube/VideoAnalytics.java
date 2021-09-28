/*
* IMPORTANT!!! 
* 20 marks will be deducted if the following information is not filled.
* STUDENT NAME
* STUDENT ID
* [] 	I confirm this is my own work (in design and implementation) 
*		and that I have not viewed another student's code OR design.
*
* EXAMPLE:
* GAURAV GUPTA
* 17299271
* [x] 	I confirm this is my own work (in design and implementation) 
*		and that I have not viewed another student's code OR design.

*/
package viewTube;

public class VideoAnalytics {
	public String title;
	public int[] views;
	
	/**
	 * CONSTRUCTOR - VERY IMPORTANT!!!
	 * (make instance copies of the parameters into corresponding instance variables)
	 * WEEK 4 LECTURE COVERS EVERYTHING NEEDED FOR THE CONSTRUCTOR 
	 * @param title
	 * @param views
	 */
	public VideoAnalytics(String _title, int[] _views) {
		//to be completed
	}
	
	/**
	 * 
	 * @return the number of days for which view history is kept
	 * return 0 if views is null
	 */
	public int getHistoryLength() {
		return 0; //to be completed
	}
	
	/**
	 * 
	 * @return total number of views (return 0 if views is null)
	 */
	public int getTotalViews() {
		return 0; //to be completed
	}
	
	/**
	 * 
	 * @return the index of the day that had the least views.
	 * return null if views is null or empty
	 */
	public Integer indexOfLeastViews() {
		return 0; //to be completed
	}
	
	/**
	 * 
	 * @return the maximum number of daily views. 
	 * return 0 if views is null or empty.
	 */
	public int highestViewCount() {
		return 0; //to be completed
	}
	
	/**
	 * 
	 * @return an array representing the number of views as a percentage
	 * of total views.
	 * for example, if views = {10, 70, 20, 90}, the total views are 190.
	 * 10 is 5.26% of 190
	 * 70 is 36.84% of 190
	 * 20 is 10.52% of 190
	 * 90 is 47.36% of 190
	 * Don't worry about the EXACT value. The test checks if each value is
	 * within 0.01 of the value expected 
	 * return null if views is null and empty array if views is an empty array
	 */
	public double[] viewsInPercentage() {
		return null; //to be completed		
	}
	
	/**
	 * 
	 * @param other
	 * @return 
	 * 1 if the total views of calling object are more than the total views of parameter object
	 * -1 if the total views of calling object are less than the total views of parameter object
	 * 0 if the total views of calling object are equal to the total views of parameter object
	 */
	public int compareTo(VideoAnalytics other) {
		return 0; //to be completed
	}
	
	/**
	 * return a String representation of the calling object of the form:
	 * 
	 * Title
	 * Day 1 views: <day 1 views>
	 * Day 2 views: <day 2 views>
	 * ...
	 * 
	 * (special case for when views is null or empty)
	 * 
	 * For example, 
	 * 
	 * if title = "Intro" and views = {10, 70, 20, 90}, return
	 * 
	 * "Intro
	 * Day 1 views: 10
	 * Day 2 views: 70
	 * Day 3 views: 20
	 * Day 4 views: 90"
	 * 
	 * return the String "Intro - No Views Yet"	if title = "Intro" and views is null or empty
	 */
	public String toString() {
		return ""; //to be completed
	}
	
	/**
	 * 
	 * @return the length of the longest sequence where 
	 * each item is strictly more than the item before it.
	 * return 0 if views is null or empty
	 */
	public int maxLengthIncreasingViews() {
		return 0; //to be completed
	}
	
	/**
	 * 
	 * @param n
	 * @return the view history separated in buckets of size n, 
	 * padding any extra spaces with 0s (as demonstrated in the example)
	 * return null if views is null or empty or if n is less than or equal to 0
	 * 
	 * For example, 
	 * if views = {10,70,20,30,80,40} and n = 3, return {{10,70,20},{30,80,40}}
	 * if views = {10,70,20,30,80,40} and n = 4, return {{10,70,20,30},{80,40,0,0}} 
	 */
	public int[][] buckets(int n) {
		return null; //to be completed
	}
	
	/**
	 * 
	 * @param n
	 * @return the indices in the array where view count is at least n
	 * return null if views is null or empty
	 */
	public int[] getIndicesViewCountAtleast(int n) {
		return null; //to be completed
	}
	
	/**
	 * 
	 * @param beginIndex
	 * @param endIndex
	 * @return a VideoAnalytics object that represents a slice of the calling object.
	 * For example, 
	 * 
	 * if views = {10,70,20,90} and title = "Introduction", 
	 * and the parameters are beginIndex=1, endIndex=2, you must return
	 * a VideoAnalytics object that has views = {70,20} and title = "Introduction"
	 * 
	 * if views = {10,70,20,90} and title = "Introduction", 
	 * and the parameters are beginIndex=0, endIndex=3, you must return
	 * a VideoAnalytics object that has views = {10,70,20,90} and title = "Introduction"
	 * 
	 * In the second case, if you make any changes to the array views of the calling object
	 * AFTER the function call, the array views of the returned object should NOT change.
	 * 
	 * You must return a VideoAnalytics object with required title and views = null
	 * for any invalid parameter (see test cases for most info on this)
	 */
	public VideoAnalytics slice(int beginIndex, int endIndex) {
		return null; //to be completed
	}
}
