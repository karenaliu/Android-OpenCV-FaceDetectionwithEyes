/**
* Copyright (C) 2013 Imran Akthar (www.imranakthar.com)
* imran@imranakthar.com
*/
package org.opencv.samples.fd;
import java.util.ArrayList;
import java.util.List;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
public class HeadPose
{
	public float PI=3.141592f;
	public enum HeadPoseStatus { NONE, KEYFRAME, TRACKING };
	public int cornerCount,maxCorners,focalLength;
	//Point modelPoints;
	public List<Point> modelPoints = new ArrayList<Point>();
	public List<Point> previousCorners = new ArrayList<Point>();
	public List<Point> corners = new ArrayList<Point>();
	public HeadPoseStatus status;
	public Mat translationVector,rotationMatrix,cropped;
	
	public HeadPose()
	{
		focalLength=600;
		cornerCount=0;
		maxCorners=100;
		//previousCorners=NULL;
		
		
		
		
	}
	public void HeadPoseDetection(Mat mRgba,Rect[] facesArray)
	{
		this.status=status.NONE;
		
		Rect roi = new Rect(facesArray[0].x, facesArray[0].y, facesArray[0].height,facesArray[0].width);
		cropped = new Mat(mRgba, roi);
		//roi=mRgba.submat(facesArray[0].x,facesArray[0].br(),facesArray[0].y,facesArray[0].tl());
		hpFindCorners(mRgba,facesArray);
		
		
	}
	
	public void hpFindCorners(Mat mRgba,Rect[] facesArray)
	{
		Mat faceG= new Mat(cropped.height(),cropped.width(), CvType.CV_8U);
		Mat eigImage= new Mat(cropped.height(),cropped.width(), CvType.CV_32F);
		Mat tmpImage= new Mat(cropped.height(),cropped.width(), CvType.CV_32F);
		Imgproc.cvtColor(mRgba, faceG,Imgproc.COLOR_RGB2GRAY);
		///Imgproc.goodFeaturesToTrack(faceG, eigImage, tmpImage, qualityLevel, minDistance);
	}
	
	
	
}
