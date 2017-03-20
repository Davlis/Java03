/*
 * Created by Dawid Liszka
 */
import static java.lang.Math.*;
class Point
{
	private double x;
	private double y;

	public Point()
	{
		this.x = 0;
		this.y = 0;
	}

	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public Point(Point point)
	{
		this.x = point.x;
		this.y = point.y;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public void setY(double y)
	{
		this.y = y;
	}

	public void setXY(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public double getX()
	{
		return this.x;
	}

	public double getY()
	{
		return this.y;
	}

	public double getLength(Point point)
	{
		return Math.sqrt( (this.x - point.x)*(this.x - point.x) + (this.y - point.y)*(this.y - point.y) );
	}

	public static double NORMA(Point point, Point point_)
	{
		return Math.sqrt( (point.x - point_.x)*(point.x - point_.x) + (point.y - point_.y)*(point.y - point_.y));
	}

	@Override
	public String toString()
	{
		String str = "(";
		str += this.x+", "+this.y+")";
		return str;
	}

	@Override
	public boolean equals(Object object)
	{
		if(this == object) 
			return true;
		if(this == null) 
			return false;
		if(this.getClass() != object.getClass())
			return false;
		else
		{
			Point tmp = (Point) object;
			if( (tmp.x == this.x)&&(tmp.y == this.y) )
				return true;
			return false;
		}
	}
}